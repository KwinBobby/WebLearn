package org.beta.android.aakashresearchlabs.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


public class MyTestRecyclerViewAdapter extends RecyclerView.Adapter<MyTestRecyclerViewAdapter.ViewHolder> {

    private final List<String> mValues;
    Context mcontext;
    SharedPreferences sharedPreferences;


    public MyTestRecyclerViewAdapter(List<String> items, Context c) {
        mValues = items;
        mcontext=c;
        sharedPreferences=mcontext.getSharedPreferences(mcontext.getPackageName(),Context.MODE_PRIVATE);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_test, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        String heading=mValues.get(position);
        holder.testHeading.setText(heading);
        final String lessonResult="LessonTestResult"+(position+1);
        final int lessonResultInt=sharedPreferences.getInt(lessonResult,0);
        if(lessonResultInt!=0)
        {
           int total= ListOfQuestions.totalCollection.get(position).size();
            holder.bestAttempt.setText(lessonResultInt+"/"+total);
        }
        else
        {
            int total= ListOfQuestions.totalCollection.get(position).size();
            holder.bestAttempt.setText("0/"+total);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mcontext,CommonTestActivity.class);
                intent.putExtra("position",position);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView testHeading;
        public final TextView bestAttempt;

        public ViewHolder(View view) {
            super(view);
          testHeading=(TextView)view.findViewById(R.id.Heading);
            bestAttempt=(TextView)view.findViewById(R.id.bestAttempttext);

        }
    }
}
