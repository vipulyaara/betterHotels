package com.vipul.bit_hotels.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.adapter.BlogPagerAdapter;

public class BlogSliderActivity extends BaseActivity {
    private ViewPager viewPagerBlog;
    private TextView tvPageNo;
    private TextSwitcher tvBlogTitle;
    private String[] blogTitles = {"Play a fest of colors with Holi", "Where to go after Budapest", "The choice is yours!",
            "Discover the art of traveling", "Ultimate guide to Sri Lanka", "The answer is blowing in the wind",
            "Build your own pillow forts", "Where to go after Budapest", "The choice is yours!",
            "Discover the art of traveling", "Ultimate guide to Sri Lanka", "The answer is blowing in the wind"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog);

        initializeToolbar();


        tvBlogTitle = (TextSwitcher) findViewById(R.id.tv_blog_title);

        tvBlogTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(BlogSliderActivity.this);
                TextView textView = (TextView) inflater.inflate(R.layout.item_textview_blog_title, null);
                return textView;
            }
        });

        tvBlogTitle.setInAnimation(this, R.anim.fade_in);
        tvBlogTitle.setOutAnimation(this, R.anim.fade_out);

        tvPageNo = (TextView) findViewById(R.id.tv_page_no);

        viewPagerBlog = (ViewPager) findViewById(R.id.view_pager_blog);
        BlogPagerAdapter galleryPagerAdapter = new BlogPagerAdapter(getSupportFragmentManager());
        viewPagerBlog.setAdapter(galleryPagerAdapter);
        viewPagerBlog.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int finalPosition = position + 1;
                tvPageNo.setText("" + finalPosition + " of 12");
                tvBlogTitle.setText(blogTitles[position]);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initializeToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
