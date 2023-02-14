/**
 * 评论管理的单例
 */

var Comment = {
    id: "commentTable",  // 表格id
    seTtem: null,     // 选中的条目
    table: null,
    layerIndex: -1
};


/**
 * 初始化表格的列
 */
Comment.initColumn = function () {
     var columns = [
         {field: 'selectItem', radio: true},
         {title: 'id', field: 'id', visible: false, align: 'center', valign: 'middle'},
         {title: '对应网站评论', field: 'siteId', align: 'center', valign: 'middle', sortable: true},
         {title: '评论ID', field: 'commentPostId', align: 'center', valign: 'middle', sortable: true},
         {title: '评论内容', field: 'comment', align: 'center', valign: 'middle', sortable: true,},
         {title: '作者', field: 'author', align: 'center', valign: 'middle', sortable: true},
         {title: '邮箱', field: 'email', align: 'center', valign: 'middle', sortable: true},
         {title: '网站', field: 'url', align: 'center', valign: 'middle', sortable: true},
         {title: '回复id', field: 'commentParent', align: 'center', valign: 'middle', sortable: true},
         {title: '回复时地址', field: 'httpReferer', align: 'center', valign: 'middle', sortable: true},
         {title: '随机产生码', field: 'wpnonce', align: 'center', valign: 'middle', sortable: true}]
     return columns;
 };


/**
 * 检查是否选中
 */
Comment.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if (selected.length == 0) {
        Feng.info("请先选中表格中的某一记录！");
        return false;
    } else {
        Comment.seItem = selected[0];
        return true;
    }
};


/**
 * 点击添加评论
 */
Comment.openAddcomment = function () {
    var index = layer.open({
        type: 2,
        title: '添加网站',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/home/comment_add'
    });
    this.layerIndex = index;
    layer.full(index);
};


/**
 * 打开查看评论详情
 */
Comment.opencommentDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '网站详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/home/comment_update/' + Comment.seItem.id
        });
        this.layerIndex = index;
        layer.full(index);
    }
};

/**
 * 删除评论
 */
Comment.delete = function () {
    if (this.check()) {

        var operation = function(){
            var ajax = new $ax(Feng.ctxPath + "/home/delete", function () {
                Feng.success("删除成功!");
                Comment.table.refresh();
            }, function (data) {
                Feng.error("删除失败!" + data.responseJSON.message + "!");
            });
            ajax.set("id",Comment.seItem.id);
            ajax.start();
        };

        Feng.confirm("是否刪除网站?", operation);
    }
};


/**
 * 搜索
 */
Comment.search = function () {
    var queryData = {};

    queryData['comment'] = $("#comment").val();

    Comment.table.refresh({query: queryData});
}

$(function () {
    var defaultColunms = Comment.initColumn();
    var table = new BSTable(Comment.id, "/home/list", defaultColunms);
    table.setPaginationType("server");
    table.init();
    Comment.table = table;
});

