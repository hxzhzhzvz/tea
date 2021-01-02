package com.dream.tea.service.model.library;

import java.util.Date;

public class videoDisplayListDetail {
    private Long id;

    private Long videoDisplayListId;

    private Long videoListId;

    private Date gmtCreate;

    private Date gmtUpdate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVideoDisplayListId() {
        return videoDisplayListId;
    }

    public void setVideoDisplayListId(Long videoDisplayListId) {
        this.videoDisplayListId = videoDisplayListId;
    }

    public Long getVideoListId() {
        return videoListId;
    }

    public void setVideoListId(Long videoListId) {
        this.videoListId = videoListId;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }
}