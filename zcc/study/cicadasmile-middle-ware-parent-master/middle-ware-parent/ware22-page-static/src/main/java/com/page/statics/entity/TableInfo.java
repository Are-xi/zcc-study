package com.page.statics.entity;

public class TableInfo {
    public TableInfo(String desc, String imgUrl) {
        this.desc = desc;
        this.imgUrl = imgUrl;
    }

    private String desc ;
    private String imgUrl ;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
