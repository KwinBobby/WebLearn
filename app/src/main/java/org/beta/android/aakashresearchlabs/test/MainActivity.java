package org.beta.android.aakashresearchlabs.test;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import static org.beta.android.aakashresearchlabs.test.R.layout.activity_main;


public class MainActivity extends AppCompatActivity {

    MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);
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


        TextView tx = (TextView) findViewById(R.id.webLearnTitle);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/WOX-Striped_Triple.otf");
        tx.setTypeface(custom_font);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.feedback: {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto: aakashandro@gmail.com"));
                i.putExtra(Intent.EXTRA_SUBJECT, "Feedback for WebLearnApp");
                //  i.putExtra(Intent.EXTRA_TEXT, "Name : "+e1.getText()+"\nMessage : "+e2.getText());
                try {
                    startActivity(Intent.createChooser(i, "Send feedback..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(getApplicationContext(), "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
