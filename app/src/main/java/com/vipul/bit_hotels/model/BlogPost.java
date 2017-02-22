package com.vipul.bit_hotels.model;

/**
 * Created by vipulkumar on 19/08/16.
 */
public class BlogPost {
    String postTitle;

    public int getHeroImageResource() {
        return heroImageResource;
    }

    public void setHeroImageResource(int heroImageResource) {
        this.heroImageResource = heroImageResource;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(String dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    String dateOfPublication;
    int heroImageResource;
}
