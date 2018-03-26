package com.example.ahmed.mas;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ahmed on 3/22/18.
 */

public class StudentRowAdapter extends RecyclerView.Adapter<StudentRowAdapter.RowViewHolder>{

    public StudentRowAdapter(Context context, ArrayList<String> data) {
        this.context = context;
        this.data = data;
        layoutInflater = LayoutInflater.from(context);
    }

    private Context context;
    private ArrayList<String> data;
    private LayoutInflater layoutInflater;

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

           View view = layoutInflater.inflate(R.layout.student_row_item,parent,false);
           RowViewHolder viewHolder = new RowViewHolder(view);
           return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RowViewHolder holder, int position) {

        final int itemType = getItemViewType(position);

    final String current =data.get(position);
      holder.StudentName.setText("Student"+position);
    holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked){
                holder.status.setTextColor(Color.rgb(0,171,250));
                holder.status.setText("Active");
            }
            else{
                holder.status.setTextColor(Color.rgb(12,82,114));
                holder.status.setText("Active");
            }
        }
    });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        private TextView StudentName,status;
        private CircleImageView image;
        private Switch  aSwitch;
        private Button button;

        public RowViewHolder(View itemView) {
            super(itemView);
            StudentName = (TextView)itemView.findViewById(R.id.student_name);
            status = (TextView)itemView.findViewById(R.id.status);
            image = (CircleImageView)itemView.findViewById(R.id.image_std);
            aSwitch = (Switch)itemView.findViewById(R.id.switch1);
            button = (Button)itemView.findViewById(R.id.pause);
        }
    }
}
