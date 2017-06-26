package com.beta.android.aakashresearchlabs.test;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.beta.android.aakashresearchlabs.test.customAdapters.wordAdapter;
import com.beta.android.aakashresearchlabs.test.customClasses.wordclass;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import java.util.ArrayList;

import static com.beta.android.aakashresearchlabs.test.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        mViewPager=(MaterialViewPager)findViewById(R.id.materialViewPager);
        Toolbar toolbar = mViewPager.getToolbar();

        if (toolbar != null) {
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
//            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(false);
        }
//        mViewPager.getToolbar().inflateMenu(R.menu.main);
//        mViewPager.getToolbar().setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem item) {
//                int id = item.getItemId();
//
//                //noinspection SimplifiableIfStatement
//                if (id == R.id.action_settings) {
//                    Toast.makeText(getApplicationContext(), "yaaaay", Toast.LENGTH_SHORT).show();
//                    return true;
//                }
//                return false;
//            }
//        });

        new ListOfQuestions().fillquestion();


        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        return new LessonFragment();
                    case 1:
                       return new TestFragment();
                    //case 2:
                    //    return WebViewFragment.newInstance();
                    default:
                        return null;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Lesson";
                    case 1:
                        return "Test";
                }
                return "";
            }
        });


        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorAndDrawable(
                                Color.parseColor("#009688"),
                                getDrawable(R.drawable.lesson_bg2));
                    case 1:
                        return HeaderDesign.fromColorAndDrawable(
                                getResources().getColor(android.R.color.black),
                                getDrawable(R.drawable.test_bg));
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


        //set font for app name in menu


        TextView tx = (TextView)findViewById(R.id.webLearnTitle);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/WOX-Striped_Triple.otf");
        tx.setTypeface(custom_font);


        //set menu list adapter
//
//        final ArrayList<wordclass> list = new ArrayList<wordclass>();
//
//        list.add(new wordclass(R.string.list1,R.color.list1,BasicActivity1. class));
//        list.add(new wordclass(R.string.list2,R.color.list2,GitBasicActivity1.class));
//        list.add(new wordclass(R.string.list3,R.color.list3,FrontEndActivity1.class));
//        list.add(new wordclass(R.string.list4,R.color.list4,BackEndActivity1. class));
//        list.add(new wordclass(R.string.list5,R.color.list5,FrameworkActivity1.class));
//        list.add(new wordclass(R.string.list6,R.color.list6,ImportantActivity1.class));
//
//        wordAdapter adapter = new wordAdapter(this,list);
//        ListView section = (ListView) findViewById(R.id.menu_list);
//        section.setAdapter(adapter);
//
//
//        //opening new activity for every item on menu list
//        section.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//
//                wordclass w = list.get(position);
//
//                //starting different activities respective to the item clicked
//                Intent intent = new Intent(getApplicationContext(),w.getmCls());
//                startActivity(intent);
//            }
//        });

    }

//    @Override
//    public void onBackPressed() {
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings: {
                Toast.makeText(this, "yaay", Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }




//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        Intent intent;
//
//        if (id == R.id.test)
//        {
//            intent = new Intent(getApplicationContext(),TestActivity.class);
//            startActivity(intent);
//        }
//
//        else if (id == R.id.nav_camera) {
//            // Handle the camera action
//        }
//
//        else if (id == R.id.nav_gallery) {
//
//        }
//
//        else if (id == R.id.nav_slideshow) {
//
//        }
//
//        else if (id == R.id.nav_share) {
//
//            Intent share=new Intent(Intent.ACTION_SEND);
//            share.putExtra(Intent.EXTRA_TITLE,"Sharing my progress");
//            share.putExtra(Intent.EXTRA_SUBJECT,"Puns :p");
//            share.setType("text/plain");
//            share.putExtra(Intent.EXTRA_TEXT,"How do functions break up? They stop calling each other");
//            startActivity(share);
//        }
//
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }
}
