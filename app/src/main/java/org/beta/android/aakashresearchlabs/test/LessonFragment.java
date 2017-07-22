package org.beta.android.aakashresearchlabs.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.beta.android.aakashresearchlabs.test.lessons.LessonFiveActivity;
import org.beta.android.aakashresearchlabs.test.lessons.LessonFourActivity;
import org.beta.android.aakashresearchlabs.test.lessons.LessonOneActivity;
import org.beta.android.aakashresearchlabs.test.lessons.LessonSevenActivity;
import org.beta.android.aakashresearchlabs.test.lessons.LessonSixActivity;
import org.beta.android.aakashresearchlabs.test.lessons.LessonThreeActivity;
import org.beta.android.aakashresearchlabs.test.lessons.LessonTwoActivity;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;


public class LessonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    ArrayList<LessonClass> LessonList;
    MyLessonRecyclerViewAdapter adapter;


    public LessonFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static LessonFragment newInstance(int columnCount) {
        LessonFragment fragment = new LessonFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lesson_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
            LessonList=new ArrayList<>();

            LessonList.add(new LessonClass("First Meeting With Web Development",6,LessonOneActivity.class));
            LessonList.add(new LessonClass("The HandShake with HTML",8,LessonTwoActivity.class));
            LessonList.add(new LessonClass("Shaking Hands with Javascript",5,LessonThreeActivity.class));
            LessonList.add(new LessonClass("Shaking Hands with CSS",7,LessonFourActivity.class));
            LessonList.add(new LessonClass("Publishing a Website",5,LessonFiveActivity.class));
            LessonList.add(new LessonClass("Working of Web",6,LessonSixActivity.class));
            LessonList.add(new LessonClass("Knowing about accessibility",6,LessonSevenActivity.class));
           adapter=new MyLessonRecyclerViewAdapter(LessonList,getActivity().getApplicationContext());
            recyclerView.setAdapter(adapter);

        }
        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }

}
