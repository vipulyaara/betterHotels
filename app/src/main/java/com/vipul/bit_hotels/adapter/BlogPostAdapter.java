package com.vipul.bit_hotels.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vipul.bit_hotels.R;
import com.vipul.bit_hotels.activity.BlogDetailActivity;
import com.vipul.bit_hotels.model.BlogPost;

import java.util.List;

public class BlogPostAdapter extends RecyclerView.Adapter<BlogPostAdapter.MyViewHolder> {
    private List<BlogPost> blogPosts;
    private Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvPostTitle, tvDateOfPublication;
        public ImageView ivHeroImage;
        public ViewGroup postLayout;

        public MyViewHolder(View view) {
            super(view);
            tvPostTitle = (TextView) view.findViewById(R.id.tv_post_title);
            tvDateOfPublication = (TextView) view.findViewById(R.id.tv_date_of_publication);
            ivHeroImage = (ImageView) view.findViewById(R.id.iv_hero_image);
            postLayout = (ViewGroup) view.findViewById(R.id.post_layout);
        }
    }

    public BlogPostAdapter(Context context, List<BlogPost> blogPosts) {
        this.blogPosts = blogPosts;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(getLayoutToInflate(viewType), parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final BlogPost blogPost = blogPosts.get(position);
        holder.tvPostTitle.setText(blogPost.getPostTitle());
        holder.tvDateOfPublication.setText(blogPost.getDateOfPublication());
        if (position != 0) {
            Picasso.with(context)
                    .load(blogPost.getHeroImageResource())
                    .into(holder.ivHeroImage);
        }
        holder.postLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pair<View, String> p1 = Pair.create((View) holder.ivHeroImage, holder.ivHeroImage.getTransitionName());
                ActivityOptionsCompat options = ActivityOptionsCompat.
                        makeSceneTransitionAnimation(((Activity) context), p1);
                Bundle bundle = options.toBundle();
                Intent i = new Intent(context, BlogDetailActivity.class);
                i.putExtra("image", blogPost.getHeroImageResource());
                i.putExtra("text", blogPost.getPostTitle());
                context.startActivity(i, bundle);
            }
        });
    }

    private int getLayoutToInflate(int position) {
        switch (position) {
            case 0:
                return R.layout.item_blog_layout_0;
            case 1:
                return R.layout.item_blog_layout_1;
            case 2:
                return R.layout.item_blog_layout_2;
            case 3:
                return R.layout.item_blog_layout_3;
            case 4:
                return R.layout.item_blog_layout_2;
            case 5:
                return R.layout.item_blog_layout_3;
            case 6:
                return R.layout.item_blog_layout_3;
            case 7:
                return R.layout.item_blog_layout_2;
            case 8:
                return R.layout.item_blog_layout_1;
            case 9:
                return R.layout.item_blog_layout_3;
            default:
                return R.layout.item_blog_layout_1;
        }
    }

    @Override
    public int getItemCount() {
        return blogPosts.size();
    }
}