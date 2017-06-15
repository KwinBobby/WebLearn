package com.beta.android.aakashresearchlabs.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beta.android.aakashresearchlabs.test.dummy.DummyContent.DummyItem;
import com.beta.android.aakashresearchlabs.test.lessons.LessonFiveActivity;
import com.beta.android.aakashresearchlabs.test.lessons.LessonFourActivity;
import com.beta.android.aakashresearchlabs.test.lessons.LessonOneActivity;
import com.beta.android.aakashresearchlabs.test.lessons.LessonSevenActivity;
import com.beta.android.aakashresearchlabs.test.lessons.LessonSixActivity;
import com.beta.android.aakashresearchlabs.test.lessons.LessonThreeActivity;
import com.beta.android.aakashresearchlabs.test.lessons.LessonTwoActivity;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class LessonFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    ArrayList<LessonClass> LessonList;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
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

            LessonList.add(new LessonClass("The story of your first website",6,LessonOneActivity.class));
            LessonList.add(new LessonClass("The HandShake with HTML",8,LessonTwoActivity.class));
            LessonList.add(new LessonClass("Shaking Hands with Javascript",5,LessonThreeActivity.class));
            LessonList.add(new LessonClass("Shaking Hands with CSS",7,LessonFourActivity.class));
            LessonList.add(new LessonClass("Publishing a Website",5,LessonFiveActivity.class));
            LessonList.add(new LessonClass("Working of Web",6,LessonSixActivity.class));
            LessonList.add(new LessonClass("Knowing about accessibility",6,LessonSevenActivity.class));
            MyLessonRecyclerViewAdapter adapter=new MyLessonRecyclerViewAdapter(LessonList,getActivity().getApplicationContext());
            recyclerView.setAdapter(adapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
