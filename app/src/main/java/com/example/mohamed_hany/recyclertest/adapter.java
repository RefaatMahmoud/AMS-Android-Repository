package com.example.mohamed_hany.recyclertest;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mohamed_Hany on 2/27/2018.
 */

public class adapter extends RecyclerView.Adapter<adapter.MyViewHolder> {

    private List<model> modelList;
    private Context context;
    Dialog myDialog;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView photo;
        public TextView time_lecture;
        public TextView place_lecture;

        private LinearLayout linearDialog;
        public Button button_dialog;


        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.nameTxt);
            photo = view.findViewById(R.id.spacecraftImage);
            time_lecture = view.findViewById(R.id.time_Lecture);
            place_lecture = view.findViewById(R.id.place);


        }
    }

    public adapter(List<model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row, parent, false);

        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.dialog_recycler);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final model model = modelList.get(position);
        holder.title.setText(model.getName());
        holder.photo.setImageResource(model.getImage());
        holder.time_lecture.setText(model.getTime());
        holder.place_lecture.setText(model.getPlace());

//        holder.button_dialog.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                holder.linearDialog.setVisibility(View.GONE);
//            }
//        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {


                TextView dialog_name = myDialog.findViewById(R.id.dialog_name);
                ImageView dialog_Image = myDialog.findViewById(R.id.dialog_image);
                Button dialogB = myDialog.findViewById(R.id.button_dialog);

                dialog_name.setText(model.getName());
                dialog_Image.setImageResource(model.getImage());
                final LinearLayout dialoglinear = myDialog.findViewById(R.id.linearDialog);

                TextView dialog_time = (TextView) myDialog.findViewById(R.id.dialog_time);
                dialog_time.setText(model.getTime());
                dialogB.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in =new Intent(context ,MainActivity.class);
                        context.startActivity(in);
                    }
                });


                myDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}