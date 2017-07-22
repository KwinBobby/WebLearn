package org.beta.android.aakashresearchlabs.test.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.beta.android.aakashresearchlabs.test.ChapterAdapter;
import org.beta.android.aakashresearchlabs.test.ChapterClass;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C1;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C2;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C3;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C4;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C5;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C6;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C7;
import org.beta.android.aakashresearchlabs.test.Lesson2.L2C8;
import org.beta.android.aakashresearchlabs.test.R;

import java.util.ArrayList;

public class LessonTwoActivity extends AppCompatActivity {

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
        chapterList.add(new ChapterClass("HTML basics","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",L2C1.class,"L2"));
        chapterList.add(new ChapterClass("Anatomy of an HTML element","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L2C2.class,"L2"));
        chapterList.add(new ChapterClass("Nesting elements","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L2C3.class,"L2"));
        chapterList.add(new ChapterClass("Anatomy of an HTML document","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L2C4.class,"L2"));
        chapterList.add(new ChapterClass("Images","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L2C5.class,"L2"));
        chapterList.add(new ChapterClass("Marking up text","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L2C6.class,"L2"));
        chapterList.add(new ChapterClass("Links","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L2C7.class,"L2"));
        chapterList.add(new ChapterClass("Conclusion","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L2C8.class,"L2"));
        adapter = new ChapterAdapter(chapterList,getApplicationContext());
        //Adding adapter to recyclerView
        recyclerView.setAdapter(adapter);

    }
}
