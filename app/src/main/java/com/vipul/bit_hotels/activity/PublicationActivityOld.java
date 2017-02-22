package com.vipul.bit_hotels.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vipul.bit_hotels.R;

public class PublicationActivityOld extends BaseActivity {
    CardView savedCardsView;
    ViewGroup blog1, blog2, blog0;
    ImageView ivImage, ivImage2;
    View viewBg;
    TextView tvTitle1;
    RecyclerView recyclerViewPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.app_dark_200));
        }
        setContentView(R.layout.activity_publication_old);

        tvTitle1 = (TextView) findViewById(R.id.tv_title_1);
        ivImage2 = (ImageView) findViewById(R.id.iv_image_2);
        ImageView ivImage3 = (ImageView) findViewById(R.id.iv_blog_3);
        ImageView ivImage4 = (ImageView) findViewById(R.id.iv_blog_4);
        ImageView ivImage5 = (ImageView) findViewById(R.id.iv_blog_5);
        ImageView ivImage6 = (ImageView) findViewById(R.id.iv_blog_6);
        ivImage = (ImageView) findViewById(R.id.iv_blog_1);
        viewBg = findViewById(R.id.view_bg);
        blog0 = (LinearLayout) findViewById(R.id.blog_0);
        blog1 = (RelativeLayout) findViewById(R.id.blog_1);

        blog2 = (RelativeLayout) findViewById(R.id.blog_2);


        Picasso.with(PublicationActivityOld.this)
                .load(R.drawable.img_city_42)
                .into(ivImage);
        Picasso.with(PublicationActivityOld.this)
                .load(R.drawable.img_food_3)
                .into(ivImage2);
        Picasso.with(PublicationActivityOld.this)
                .load(R.drawable.img_city_41)
                .into(ivImage3);
        Picasso.with(PublicationActivityOld.this)
                .load(R.drawable.img_city_8)
                .into(ivImage4);
        Picasso.with(PublicationActivityOld.this)
                .load(R.drawable.img_city_13)
                .into(ivImage5);
        Picasso.with(PublicationActivityOld.this)
                .load(R.drawable.img_city_45)
                .into(ivImage6);


        blog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair<View, String> p1 = Pair.create((View) ivImage, ivImage.getTransitionName());
                Pair<View, String> p2 = Pair.create((View) viewBg, viewBg.getTransitionName());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(((Activity) PublicationActivityOld.this), p1, p2);
                Bundle bundle = options.toBundle();
                Intent i = new Intent(PublicationActivityOld.this, BlogDetailActivity.class);
                i.putExtra("image", R.drawable.img_city_42);
                i.putExtra("text", "10 Reasons to book your tickets to Kashmir");
                startActivity(i, bundle);
            }
        });
        blog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair<View, String> p1 = Pair.create((View) ivImage2, ivImage2.getTransitionName());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(((Activity) PublicationActivityOld.this), p1);
                Bundle bundle = options.toBundle();
                Intent i = new Intent(PublicationActivityOld.this, BlogDetailActivity.class);
                i.putExtra("image", R.drawable.img_food_3);
                i.putExtra("text", "12 Delicious places in Delhi for a date");
                startActivity(i, bundle);
            }
        });
        blog0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair<View, String> p1 = Pair.create((View) tvTitle1, tvTitle1.getTransitionName());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(((Activity) PublicationActivityOld.this));
                Bundle bundle = options.toBundle();
                Intent i = new Intent(PublicationActivityOld.this, BlogDetailActivity.class);
//                i.putExtra("image", R.drawable.img_food_3);
                i.putExtra("text", "8 Destinations in India to celebrate New Year's");
                startActivity(i, bundle);
            }
        });

        initializeToolbar();
    }

    private void initializeBlogRecyclerView() {
//        recyclerViewPosts = (RecyclerView) findViewById(R.id.recycler_view_locations);
//        recyclerViewPosts.setHasFixedSize(true);
//        recyclerViewPosts.setNestedScrollingEnabled(false);
//        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(
//                this);
//        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//        recyclerViewPosts.setLayoutManager(mLayoutManager);
//
//        Blog
//        recyclerViewPosts.setAdapter(locationsAdapter);
    }

    private void initializeToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
//        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
//        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
