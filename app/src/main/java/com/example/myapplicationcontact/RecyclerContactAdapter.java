package com.example.myapplicationcontact;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrcontacts = new ArrayList<>();
    private ViewHolder holder;
    private int position;

    RecyclerContactAdapter(  Context context,ArrayList<ContactModel> arrcontacts) {

        this.context = context;
        this.arrcontacts = arrcontacts;
    }

    public RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrcontacts, Context applicationContext) {
        this.arrcontacts = arrcontacts;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerContactAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerContactAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        this.holder = holder;
        this.position = position;
        final ContactModel temp = arrcontacts.get(position);
        holder.imgContact.setImageResource(arrcontacts.get(position).img);
        holder.txtName.setText(arrcontacts.get(position).name);
        holder.txtNumber.setText(arrcontacts.get(position).num);
        holder.imgContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MyApplicationcontact2.class);
                intent.putExtra("img",temp.img);
                intent.putExtra("name",temp.name);
               intent.putExtra("num",temp.num);

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.add_lay);
                EditText username = dialog.findViewById(R.id.username);
                EditText usercontact = dialog.findViewById(R.id.usercontact);

                Button btnAction = dialog.findViewById(R.id.btnaction);
                TextView register = dialog.findViewById(R.id.register);
                register.setText("UPDATE");
                username.setText(arrcontacts.get(position).name);
                usercontact.setText(arrcontacts.get(position).num);
                btnAction.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String name = username.getText().toString();
                        String number = usercontact.getText().toString();
                        arrcontacts.set(position,new ContactModel(name,number));
                        notifyItemChanged(position);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrcontacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName,txtNumber;
        ImageView imgContact;
        Button btnupdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtNumber = (TextView) itemView.findViewById(R.id.txtNumber);
            imgContact = (ImageView) itemView.findViewById(R.id.imgContact);
            btnupdate = (Button)itemView.findViewById(R.id.btnupdate);

        }

    }
}
