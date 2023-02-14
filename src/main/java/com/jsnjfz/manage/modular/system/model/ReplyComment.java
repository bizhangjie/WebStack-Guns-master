package com.jsnjfz.manage.modular.system.model;

import java.util.List;

public class ReplyComment {

    private Integer id;

    private Integer siteId;

    private Integer commentPostId;

    private String comment;

    private String author;

    private String email;

    private String url;

    private Integer commentParent;

    private String httpReferer;

    private String wpnonce;

    private String createTime;

    private String updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public Integer getCommentPostId() {
        return commentPostId;
    }

    public void setCommentPostId(Integer commentPostId) {
        this.commentPostId = commentPostId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Integer commentParent) {
        this.commentParent = commentParent;
    }

    public String getHttpReferer() {
        return httpReferer;
    }

    public void setHttpReferer(String httpReferer) {
        this.httpReferer = httpReferer;
    }

    public String getWpnonce() {
        return wpnonce;
    }

    public void setWpnonce(String wpnonce) {
        this.wpnonce = wpnonce;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    private List<ReplyComment> ReplyComment;

    public List<com.jsnjfz.manage.modular.system.model.ReplyComment> getReplyComment() {
        return ReplyComment;
    }

    public void setReplyComment(List<com.jsnjfz.manage.modular.system.model.ReplyComment> replyComment) {
        ReplyComment = replyComment;
    }
}
