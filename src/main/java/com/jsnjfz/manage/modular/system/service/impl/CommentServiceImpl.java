package com.jsnjfz.manage.modular.system.service.impl;

import com.jsnjfz.manage.core.util.Pager;
import com.jsnjfz.manage.modular.system.dao.CommentMapper;
import com.jsnjfz.manage.modular.system.dao.ReplyCommentMappr;
import com.jsnjfz.manage.modular.system.model.Comment;
import com.jsnjfz.manage.modular.system.model.ReplyComment;
import com.jsnjfz.manage.modular.system.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 评论接口实现类
 */

@Service
public class CommentServiceImpl extends BaseService<Comment> {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private ReplyCommentMappr replyCommentMappr;

    public static Pager<Comment> pager = null;

    /**
     *  分页处理
     */

    public Pager<Comment> getPage(Map<String, Object> map, Integer pageNo, Integer size) {
        if (map == null) {
            if (pager != null) {
                return pager;
            }
            map = new HashMap<>();
        }
        int total =  commentMapper.getTotalCount(map);
        Pager<Comment> page = new Pager<>(total, pageNo, size);
        map.put("offset", pageNo);
        map.put("size", size);
        page.setList(commentMapper.getList(map));
        if (pager == null){
            pager = page;
        }
        return page;
    }


    public List<Comment> getCommentList(Map<String, Object> map){
        List<Comment> commentList = commentMapper.getList(map);
        List<ReplyComment> replyCommentList = replyCommentMappr.getList(map);
        for (Comment comment:commentList){
            List<ReplyComment> replyComments = new ArrayList<>();

            for (ReplyComment replyComment:replyCommentList){

                if (replyComment.getCommentParent() == comment.getCommentPostId()){
                    replyComments.add(replyComment);
                }

            }
            comment.setReplyComments(replyComments);
        }
        return commentList;
    }
}
