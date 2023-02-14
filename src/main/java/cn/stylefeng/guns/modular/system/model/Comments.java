package cn.stylefeng.guns.modular.system.model;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangjie
 * @since 2021-03-17
 */
public class Comments extends Model<Comments> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
    private Date createTime;
    private Date updateTime;


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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Comments{" +
        ", id=" + id +
        ", siteId=" + siteId +
        ", commentPostId=" + commentPostId +
        ", comment=" + comment +
        ", author=" + author +
        ", email=" + email +
        ", url=" + url +
        ", commentParent=" + commentParent +
        ", httpReferer=" + httpReferer +
        ", wpnonce=" + wpnonce +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
