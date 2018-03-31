package com.example.ahmed.mas;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by ahmed on 3/22/18.
 */

public class StudentRowAdapter extends RecyclerView.Adapter<StudentRowAdapter.RowViewHolder>{

    String []name = {"Ahmed","Mohamed","Mahomoud","Ali","Sara","Eman","Amera","Nabil","Aya","Medhat","Esraa","Ebrahim"};
    CountDownTimer countDownTimer;

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

        RowViewHolder viewHolder;
        View view = layoutInflater.inflate(R.layout.student_row_item,parent,false);
        viewHolder = new RowViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(final RowViewHolder holder,  int position) {

            holder.StudentName.setText(name[position]);
            holder.aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        holder.status.setTextColor(Color.rgb(0, 171, 250));
                        holder.status.setText("Active");
                    } else {
                        holder.status.setTextColor(Color.rgb(12, 82, 114));
                        holder.status.setText("Active");
                    }
                }
            });
            holder.pause.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.mainRow.setAlpha(0);
                    holder.timeCounter.setAlpha(1);
                    int timer = 1000*5;

                    countDownTimer = new CountDownTimer(timer,1000){
                        int minutes ;
                        int seconds;
                        int tempSecond;
                        @Override
                        public void onTick(long millisUntilFinished) {
                            seconds = (int) (millisUntilFinished/(1000));
                            minutes = seconds/60;
                            seconds = seconds%60;

                            holder.time.setText(minutes + " : "+seconds);

                            if (tempSecond == -1){
                                minutes--;
                                seconds = 59;
                            }

                        }

                        @Override
                        public void onFinish() {
                            holder.time.setText("Time out");
                            holder.resume.setAlpha((float) 0.5);
                            holder.resume.setEnabled(false);
                        }

                    }.start();

                }
            });
        holder.resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mainRow.setAlpha(1);
                holder.timeCounter.setAlpha(0);
                countDownTimer.cancel();
            }
        });
    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout mainRow;
        private RelativeLayout timeCounter;
        private TextView StudentName,status;
        private CircleImageView image;
        private Switch  aSwitch;
        private Button pause;
        private Button resume;
        private TextView time;

        public RowViewHolder(View itemView) {
            super(itemView);
            StudentName = (TextView)itemView.findViewById(R.id.student_name);
            status = (TextView)itemView.findViewById(R.id.status);
            image = (CircleImageView)itemView.findViewById(R.id.image_std);
            aSwitch = (Switch)itemView.findViewById(R.id.switch1);
            pause = (Button)itemView.findViewById(R.id.pause);
            mainRow = (RelativeLayout)itemView.findViewById(R.id.mainRow);
            timeCounter = (RelativeLayout)itemView.findViewById(R.id.timecount);
            resume = (Button)itemView.findViewById(R.id.resume);
            time = (TextView)itemView.findViewById(R.id.time);
        }
    }
}
