package inei.gob.pe.viewpagerinei;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static inei.gob.pe.viewpagerinei.R.id.viewPager;

public class MainActivity extends AppCompatActivity {


    ViewPager pager;

    MyPagerAdapter myPagerAdapter;
    private Button btnSkip, btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSkip = (Button) findViewById(R.id.btn_skip);
        btnNext = (Button) findViewById(R.id.btn_next);
        pager = (ViewPager) findViewById(viewPager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(myPagerAdapter);

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                launchHomeScreen();
                int current = pager.getCurrentItem() - 1;
                if (current > -1) {
                    // move to next screen
                    pager.setCurrentItem(current);}
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // checking for last page
                // if last page home screen will be launched
                int current = pager.getCurrentItem() + 1;
                if (current < myPagerAdapter.getCount()) {
                    // move to next screen
                    pager.setCurrentItem(current);}
            }
        });
    }


    private class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int pos) {

            switch(pos) {
                case 0: return new PrimerFragment();
                case 1: return new SegundoFragment();
                case 2: return new TercerFragment();
                default: return new TercerFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

    }
}