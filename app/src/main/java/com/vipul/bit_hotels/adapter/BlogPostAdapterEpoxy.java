package com.vipul.bit_hotels.adapter;

import com.airbnb.epoxy.EpoxyAdapter;
import com.vipul.bit_hotels.model.BlogPost;
import com.vipul.bit_hotels.model.BlogPostLayout1;
import com.vipul.bit_hotels.model.BlogPostLayout1_;
import com.vipul.bit_hotels.model.BlogPostLayout2;

import java.util.ArrayList;

public class BlogPostAdapterEpoxy extends EpoxyAdapter {
    BlogPostLayout1_ blogPostLayout1_ = new BlogPostLayout1_();

    public BlogPostAdapterEpoxy(ArrayList<BlogPost> blogPosts) {
        addPhotos(new BlogPostLayout1_());
    }

    public void addPhotos(BlogPostLayout1 blogPost1) {
        addModel(blogPost1);
    }
}