jQuery(document).ready(function (jQuery) {
    var __cancel = $('#cancel-comment-reply-link'),
        __cancel_text = __cancel.text(),
        __list = 'comment-list';
    $(document).on("submit", "#commentform", function () {
        var post = document.getElementById('comment_post_ID').value,
            parent = document.getElementById('comment_parent').value;
        if (post != parent) {
            $.ajax({
                url: theme.ajaxurl,
                data: $(this).serialize() + "&action=ajax_comment",
                type: $(this).attr('method'),
                beforeSend: showAlert(JSON.parse('{"status":2,"msg":"提交中...."}')),
                error: function (request) {
                    showAlert(JSON.parse(request.responseText));
                },
                success: function (data) {
                    $('textarea').each(function () {
                        this.value = ''
                    });
                    var cancel = document.getElementById('cancel-comment-reply-link'),
                        temp = document.getElementById('wp-temp-form-div'),
                        respond = document.getElementById('respond'),
                        post = document.getElementById('comment_post_ID').value,
                        parent = document.getElementById('comment_parent').value;
                    $text = $(data);
                    if (parent != '0') {
                        $children = $('<ul class="children"></ul>');
                        $('#respond').before($children);
                        $children.html($text);
                    } else if (!$('.' + __list).length) {
                        $children = $('<ul class="' + __list + '"></ul>');
                        if (theme.formpostion == 'bottom') {
                            $('#respond').before($children);
                        } else {
                            $('#respond').after($children);
                        }
                        $children.html($text);
                    } else {
                        if (theme.order == 'asc') {
                            $('.' + __list).append($text);
                        } else {
                            $('.' + __list).prepend($text);
                        }
                    }
                    $text.children(".new-comment").animate({ opacity: 0 }, 2000);
                    showAlert(JSON.parse('{"status":1,"msg":"提交成功!"}'));
                    cancel.style.display = 'none';
                    cancel.onclick = null;
                    document.getElementById('comment_parent').value = '0';
                    if (temp && respond) {
                        temp.parentNode.insertBefore(respond, temp);
                        temp.parentNode.removeChild(temp)
                    }
                    setTimeout(function() { location.reload(); }, 1000);

                }
            });
        } else {
            showAlert(JSON.parse('{"status":3,"msg":"对不起不能给自己评论"}'));
        }

        return false;
    });
});

window.commentsTicket = function (res) {
    if (res.ret === 0) {
        document.getElementById("c_tcaptcha_ticket").value = res.ticket;
        document.getElementById("c_tcaptcha_randstr").value = res.randstr;
        $('#commentform').submit();
    } else if (res.ret === 2) {
        showAlert(JSON.parse('{"status":3,"msg":"你没有完成验证！"}'));
    }
}
