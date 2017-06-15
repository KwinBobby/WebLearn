package com.beta.android.aakashresearchlabs.test;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beta.android.aakashresearchlabs.test.LessonFragment.OnListFragmentInteractionListener;
import com.beta.android.aakashresearchlabs.test.dummy.DummyContent.DummyItem;

import java.util.List;

import at.grabner.circleprogress.CircleProgressView;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLessonRecyclerViewAdapter extends RecyclerView.Adapter<MyLessonRecyclerViewAdapter.ViewHolder> {

    private final List<LessonClass> mValues;
    Context mcontext;

    public MyLessonRecyclerViewAdapter(List<LessonClass> items, Context c) {
        mValues = items;
        mcontext=c;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_lesson, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final LessonClass currentLesson=mValues.get(position);
        holder.LHeading.setText(currentLesson.getLHeading());
        holder.chaptersCovered.setText("2/"+currentLesson.getTotalChapters());
        holder.progress.setMaxValue(currentLesson.getTotalChapters());
        holder.progress.setValue(2);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(mcontext,currentLesson.getlClass());
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

        public final TextView LHeading;
        public final TextView chaptersCovered;
        public final CircleProgressView progress;


        public ViewHolder(View view) {
            super(view);
            LHeading = (TextView) view.findViewById(R.id.Heading);
            chaptersCovered = (TextView) view.findViewById(R.id.chaptersCoveredtext);
            progress=(CircleProgressView)view.findViewById(R.id.circleProgress);
        }

    }
}
