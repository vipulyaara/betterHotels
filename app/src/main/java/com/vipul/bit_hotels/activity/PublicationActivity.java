package com.vipul.bit_hotels.activity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.adapter.BlogPostAdapter;
import com.vipul.bit_hotels.model.BlogPost;

import java.util.ArrayList;

public class PublicationActivity extends BaseActivity {
    private RecyclerView recyclerViewPosts;
    private ArrayList<BlogPost> blogPosts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.setStatusBarColor(getResources().getColor(R.color.app_dark_200));
        }
        setContentView(R.layout.activity_publication);
//        blog1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Pair<View, String> p1 = Pair.create((View) ivImage, ivImage.getTransitionName());
//                Pair<View, String> p2 = Pair.create((View) viewBg, viewBg.getTransitionName());
//                ActivityOptionsCompat options = ActivityOptionsCompat.
//                        makeSceneTransitionAnimation(((Activity) PublicationActivity.this), p1, p2);
//                Bundle bundle = options.toBundle();
//                Intent i = new Intent(PublicationActivity.this, BlogDetailActivity.class);
//                i.putExtra("image", R.drawable.img_city_42);
//                i.putExtra("text", "10 Reasons to book your tickets to Kashmir");
//                startActivity(i, bundle);
//            }
//        });

        initializeBlogRecyclerView();
        initializeToolbar();
    }

    private void initializeBlogRecyclerView() {
        recyclerViewPosts = (RecyclerView) findViewById(R.id.recycler_view_posts);
        recyclerViewPosts.setHasFixedSize(true);
        recyclerViewPosts.setNestedScrollingEnabled(false);
        final LinearLayoutManager mLayoutManager = new LinearLayoutManager(
                this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewPosts.setLayoutManager(mLayoutManager);

        String[] postTitles = {"8 Destinations in India to celebrate New Year's", "10 Reasons to book your tickets to Kashmir",
        "12 Delicious places in Delhi for a date", "This is why you should visit 10 countries before 30",
        "15 Destinations to win you over a nice weekend", "Pick From Our List Of 7 Things To Do In Kuala Lumpur In 24 Hours",
        "6 Tips For Exploring Dubai Within Rs 25,000!", "15 Destinations to win you over a nice weekend",
        "15 Destinations to win you over a nice weekend", "15 Destinations to win you over a nice weekend"};

        int[] heroImageResources = {R.drawable.img_city_37, R.drawable.img_city_42, R.drawable.img_food_3,
        R.drawable.img_city_41, R.drawable.img_city_8, R.drawable.img_city_2, R.drawable.img_city_45,
                R.drawable.img_city_23, R.drawable.img_city_25, R.drawable.img_city_27, R.drawable.img_city_40};

        for (int i = 0; i < 10; i++) {
            BlogPost blogPost  = new BlogPost();
            blogPost.setPostTitle(postTitles[i]);
            blogPost.setDateOfPublication("24 Feb, 2017");
            blogPost.setHeroImageResource(heroImageResources[i]);
            blogPosts.add(blogPost);
        }

        BlogPostAdapter blogPostAdapter = new BlogPostAdapter(PublicationActivity.this, blogPosts);
        recyclerViewPosts.setAdapter(blogPostAdapter);
    }

    private void initializeToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
