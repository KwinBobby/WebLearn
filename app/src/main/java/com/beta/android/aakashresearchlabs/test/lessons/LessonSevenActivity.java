package com.beta.android.aakashresearchlabs.test.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.beta.android.aakashresearchlabs.test.ChapterAdapter;
import com.beta.android.aakashresearchlabs.test.ChapterClass;
import com.beta.android.aakashresearchlabs.test.Lesson7.L7C1;
import com.beta.android.aakashresearchlabs.test.Lesson7.L7C2;
import com.beta.android.aakashresearchlabs.test.Lesson7.L7C3;
import com.beta.android.aakashresearchlabs.test.Lesson7.L7C4;
import com.beta.android.aakashresearchlabs.test.Lesson7.L7C5;
import com.beta.android.aakashresearchlabs.test.Lesson7.L7C6;
import com.beta.android.aakashresearchlabs.test.R;

import java.util.ArrayList;

public class LessonSevenActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ChapterAdapter adapter;
    ArrayList chapterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_one);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        //Setting the recyclerView to have linearLayout
        recyclerView.setLayoutManager(layoutManager);
        chapterList=new ArrayList();
        chapterList.add(new ChapterClass("Accessibility","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L7C1.class));
        chapterList.add(new ChapterClass("What is accessibility?","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L7C2.class));
        chapterList.add(new ChapterClass("WAI-ARIA basics","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L7C3.class));
        chapterList.add(new ChapterClass("Tools and Testing","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L7C4.class));
        chapterList.add(new ChapterClass("Learning pathway","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L7C5.class));
        chapterList.add(new ChapterClass("Server-side website programming","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L7C6.class));
       adapter = new ChapterAdapter(chapterList,getApplicationContext());
        //Adding adapter to recyclerView
        recyclerView.setAdapter(adapter);

    }
}
