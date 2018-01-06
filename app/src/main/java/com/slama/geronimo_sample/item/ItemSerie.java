package com.slama.geronimo_sample.item;

/**
 * Created by Dell on 06/01/2018.
 */

public final class ItemSerie {
    private String title;
    private String detail;
    private String imageUrl;

    public ItemSerie(String title, String detail, String imageUrl) {
        this.title = title;
        this.detail = detail;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
