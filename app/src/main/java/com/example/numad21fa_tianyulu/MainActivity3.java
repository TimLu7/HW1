package com.example.numad21fa_tianyulu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {


    private ArrayList<LinkUnit> linkUnitList;
    private AlertDialog inputAlertDialog;

    private EditText NameInput, UrlInput;
    private RecyclerView recyclerView;
    private ViewAdapter ViewAdapter;


    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        linkUnitList = new ArrayList<>();

        //for landscape screen
        init(savedInstanceState);

        FloatingActionButton addLinkButton = findViewById(R.id.LinkButton);

        addLinkButton.setOnClickListener(v -> addLink());


        createInputAlertDialog();
        createRecyclerView();
        ViewAdapter.setOnLinkClickListener(position -> linkUnitList.get(position).onLinkUnitClicked(this));

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getLayoutPosition();
                linkUnitList.remove(position);
                ViewAdapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {

            int size = linkUnitList == null? 0 : linkUnitList.size();
            outState.putInt(NUMBER_OF_ITEMS, size);

            //Need to generate unique key for each item
            for(int i=0; i<size; i++){
                outState.putString(KEY_OF_INSTANCE + i+ "0", linkUnitList.get(i).getLinkName());
                outState.putString(KEY_OF_INSTANCE + i+ "1", linkUnitList.get(i).getLinkUrl());
            }
            super.onSaveInstanceState(outState);
        }

        private void init(Bundle savedInstanceState) {
            initialItemData(savedInstanceState);
            createRecyclerView();
        }

        private void initialItemData(Bundle savedInstanceState){

            if(savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)){
                if(linkUnitList == null || linkUnitList.size() == 0){

                    int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);

                    for(int i=0; i<size; i++){
                        String name = savedInstanceState.getString(KEY_OF_INSTANCE+i+"0");
                        String url = savedInstanceState.getString(KEY_OF_INSTANCE+i+"1");

                        LinkUnit unit = new LinkUnit(name, url);

                        linkUnitList.add(unit);

                    }
                }
            }
        }

        public void createInputAlertDialog() {
            LayoutInflater layoutInflater = LayoutInflater.from(this);
            View view = layoutInflater.inflate(R.layout.user_input, null);

            NameInput = view.findViewById(R.id.link_name_input);
            UrlInput = view.findViewById(R.id.link_url_input);

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setView(view);

            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton(getString(R.string.Add),
                            (dialog, id) -> {
                                LinkUnit linkUnit = new LinkUnit(NameInput.getText().toString(), UrlInput.getText().toString());
                                if (linkUnit.isValid()) {

                                    linkUnitList.add(0, linkUnit);
                                    ViewAdapter.notifyDataSetChanged();
                                    Snackbar.make(recyclerView, getString(R.string.add_success), Snackbar.LENGTH_LONG).show();
                                } else {
                                    Snackbar.make(recyclerView, getString(R.string.link_invalid), Snackbar.LENGTH_LONG).show();
                                }
                            })
                    .setNegativeButton(getString(R.string.Cancel),
                            (dialog, id) -> dialog.cancel());

            inputAlertDialog = alertDialogBuilder.create();
        }

        public void createRecyclerView() {
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView = findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            ViewAdapter = new ViewAdapter(linkUnitList);

            recyclerView.setAdapter(ViewAdapter);
            recyclerView.setLayoutManager(layoutManager);
        }


        private void addLink() {
            NameInput.getText().clear();
            UrlInput.setText(getString(R.string.Http));
            NameInput.requestFocus();
            inputAlertDialog.show();
        }

}