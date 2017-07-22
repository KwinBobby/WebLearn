package org.beta.android.aakashresearchlabs.test.lessons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.beta.android.aakashresearchlabs.test.ChapterAdapter;
import org.beta.android.aakashresearchlabs.test.ChapterClass;
import org.beta.android.aakashresearchlabs.test.Lesson1.L1C1;
import org.beta.android.aakashresearchlabs.test.Lesson1.L1C2;
import org.beta.android.aakashresearchlabs.test.Lesson1.L1C3;
import org.beta.android.aakashresearchlabs.test.Lesson1.L1C4;
import org.beta.android.aakashresearchlabs.test.Lesson1.L1C5;
import org.beta.android.aakashresearchlabs.test.Lesson1.L1C6;
import org.beta.android.aakashresearchlabs.test.R;

import java.util.ArrayList;

public class LessonOneActivity extends AppCompatActivity {
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
        chapterList.add(new ChapterClass("The story of your first website","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", L1C1.class,"L1"));
        chapterList.add(new ChapterClass("What tools do the professionals use?","Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", L1C2.class,"L1"));
        chapterList.add(new ChapterClass("What will your website look like?","Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. ", L1C3.class,"L1"));
        chapterList.add(new ChapterClass("Dealing with files","Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. ", L1C4.class,"L1"));
        chapterList.add(new ChapterClass("File paths"," Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", L1C5.class,"L1"));
        chapterList.add(new ChapterClass("What else should be done?"," Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem.", L1C6.class,"L1"));
        adapter = new ChapterAdapter(chapterList,getApplicationContext());
        //Adding adapter to recyclerView
        recyclerView.setAdapter(adapter);

    }
}
