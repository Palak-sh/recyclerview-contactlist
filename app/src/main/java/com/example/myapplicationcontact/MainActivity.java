package com.example.myapplicationcontact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ContactModel> arrcontacts = new ArrayList<>();
    RecyclerContactAdapter adapter;
    Button btnOpenDialog;
    RecyclerView recyclerView;
Context context;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RecyclerView recyclerView = findViewById(R.id.recyclerContact);

        context = this;
        BindView();
        setClickListener();

       InsertData();


        setRecyclerVew();
    }

    private void setRecyclerVew() {
         adapter = new RecyclerContactAdapter(context, arrcontacts,getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void InsertData() {
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));
        arrcontacts.add(new ContactModel(R.drawable.ic_launcher_foreground, "A", "12345"));

    }

    private void setClickListener() {
        btnOpenDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.add_lay);
                EditText username = dialog.findViewById(R.id.username);
                EditText usercontact = dialog.findViewById(R.id.usercontact);

                Button btnAction = dialog.findViewById(R.id.btnaction);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = username.getText().toString();
                        String number = usercontact.getText().toString();
                        arrcontacts.add(new ContactModel(name,number));



                        adapter.notifyItemInserted(arrcontacts.size()-1);
                        recyclerView.scrollToPosition(arrcontacts.size());
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    private void BindView() {
        btnOpenDialog = findViewById(R.id.btnOpenDialog);
         recyclerView = (RecyclerView) findViewById(R.id.recyclerContact);

    }
}


