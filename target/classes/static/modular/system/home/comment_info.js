/**
  * 初始化评论详情对话框
  */

var CommentDlg = {
    commentData : {},
    zTreeInstance : null,
    validateFields: {
        siteId: {
            validators: {
                notEmpty: {
                    message: '对应网站评论'
                }
            }
        },
        commentPostId: {
            validators: {
                notEmpty: {
                    message: '评论ID'
                }
            }
        },
        comment: {
            validators: {
                notEmpty: {
                    message: '评论内容'
                }
            }
        },
        author: {
            validators: {
                notEmpty: {
                    message: '作者'
                }
            }
        },
        email: {
             validators: {
                 notEmpty: {
                    message: '邮箱'
                 }
             }
        },
        url: {
             validators: {
                 notEmpty: {
                     message: '地址不能为空'
                 }
             }
        },
        commentParent: {
             validators: {
                 notEmpty: {
                     message: '回复id'
                 }
             }
        },
        httpReferer: {
              validators: {
                  notEmpty: {
                     message: '回复时地址'
                  }
              }
        },
        wpnonce: {
              validators: {
                   notEmpty: {
                       message: '随机产生码'
                   }
              }
        }

    }
};


/**
 * 清除数据
 */
CommentDlg.clearData = function() {
    this.commentData = {};
};

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CommentDlg.set = function(key, val) {
    this.commentData[key] = (typeof value == "undefined") ? $("#" + key).val() : value;
    return this;
};


/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CommentDlg.get = function(key) {
    return $("#" + key).val();
};

/**
 * 关闭此对话框
 */
CommentDlg.close = function() {
    parent.layer.close(window.parent.Comment.layerIndex);
};

/**
 * 收集数据
 */
CommentDlg.collectData = function() {
    this.set('id').set('siteId').set('commentPostId').set('comment').set('author').set('email').set('url').set('commentParent').set('httpReferer').set('wpnonce');
};

/**
 * 验证数据是否为空
 */
CommentDlg.validate = function () {
    $('#commentForm').data("bootstrapValidator").resetForm();
    $('#commentForm').bootstrapValidator('validate');
    return $("#commentForm").data('bootstrapValidator').isValid();
};


/**
 * 提交新增
 */
CommentDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    var reg=/(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;
    if(!reg.test(this.commentData.url)){
        Feng.error("请输入正确的网址!");
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/home/add", function(data){
        Feng.success("添加成功!");
        window.parent.Comment.table.refresh();
        CommentDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.commentData);
    ajax.start();
};

/**
 * 提交修改
 */
CommentDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    if (!this.validate()) {
        return;
    }

    var reg=/(http|ftp|https):\/\/[\w\-_]+(\.[\w\-_]+)+([\w\-\.,@?^=%&:/~\+#]*[\w\-\@?^=%&/~\+#])?/;
    if(!reg.test(this.commentData.url)){s
        Feng.error("请输入正确的网址!");
        return;
    }

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/home/update", function(data){
        Feng.success("修改成功!");
        window.parent.Comment.table.refresh();
        CommentDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.commentData);
    ajax.start();
};


$(function() {
    Feng.initValidator("commentForm", CommentDlg.validateFields);
});




