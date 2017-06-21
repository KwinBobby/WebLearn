package com.beta.android.aakashresearchlabs.test.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.beta.android.aakashresearchlabs.test.ChapterAdapter;
import com.beta.android.aakashresearchlabs.test.ChapterClass;
import com.beta.android.aakashresearchlabs.test.Lesson5.L5C1;
import com.beta.android.aakashresearchlabs.test.Lesson5.L5C2;
import com.beta.android.aakashresearchlabs.test.Lesson5.L5C3;
import com.beta.android.aakashresearchlabs.test.Lesson5.L5C4;
import com.beta.android.aakashresearchlabs.test.Lesson5.L5C5;
import com.beta.android.aakashresearchlabs.test.R;

import java.util.ArrayList;

public class LessonFiveActivity extends AppCompatActivity {

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
        chapterList.add(new ChapterClass("Publishing your website","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L5C1.class,"L5"));
        chapterList.add(new ChapterClass("What are the options?","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L5C2.class,"L5"));
        chapterList.add(new ChapterClass("Using an online tool like GitHub, Google App Engine or Dropbox","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L5C3.class,"L5"));
        chapterList.add(new ChapterClass("Using a web-based IDE such as Thimble","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L5C4.class,"L5"));
        chapterList.add(new ChapterClass("Publishing via GitHub","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L5C5.class,"L5"));
        adapter = new ChapterAdapter(chapterList,getApplicationContext());
        //Adding adapter to recyclerView
        recyclerView.setAdapter(adapter);

    }
}
