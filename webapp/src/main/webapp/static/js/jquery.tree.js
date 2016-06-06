'use strict';

(function($) {
    $.createTree = function(tree, p) {
        p = $.extend({}, p);
        $(tree).addClass('datatable');
        return tree;
    };

    // 初始化列表
    $.fn.tree = function(p) {
        $(this).each(function() {
            $.createTree(this, p);
        });
        return this;
    };
})(jQuery);