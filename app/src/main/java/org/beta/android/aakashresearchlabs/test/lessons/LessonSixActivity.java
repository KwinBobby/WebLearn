package org.beta.android.aakashresearchlabs.test.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.beta.android.aakashresearchlabs.test.ChapterAdapter;
import org.beta.android.aakashresearchlabs.test.ChapterClass;
import org.beta.android.aakashresearchlabs.test.Lesson6.L6C1;
import org.beta.android.aakashresearchlabs.test.Lesson6.L6C2;
import org.beta.android.aakashresearchlabs.test.Lesson6.L6C3;
import org.beta.android.aakashresearchlabs.test.Lesson6.L6C4;
import org.beta.android.aakashresearchlabs.test.Lesson6.L6C5;
import org.beta.android.aakashresearchlabs.test.Lesson6.L6C6;
import org.beta.android.aakashresearchlabs.test.R;

import java.util.ArrayList;

public class LessonSixActivity extends AppCompatActivity {

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
        chapterList.add(new ChapterClass("How the web works","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L6C1.class,"L6"));
        chapterList.add(new ChapterClass("Clients and servers","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L6C2.class,"L6"));
        chapterList.add(new ChapterClass("The other parts of the toolbox","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L6C3.class,"L6"));
        chapterList.add(new ChapterClass("So what happens, exactly?","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L6C4.class,"L6"));
        chapterList.add(new ChapterClass("DNS explained","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L6C5.class,"L6"));
        chapterList.add(new ChapterClass("Packets explained","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L6C6.class,"L6"));
        adapter = new ChapterAdapter(chapterList,getApplicationContext());
        //Adding adapter to recyclerView
        recyclerView.setAdapter(adapter);

    }
}
