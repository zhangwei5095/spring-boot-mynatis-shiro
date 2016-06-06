/**
 * 应用类,包含应用的常用方法.
 */
'use strict';

var App = {
    baseUrl : '',
    changeLang : function(local) {
        $.ajax({
            url : this.getUrl('/lang/' + local)
        }).done(function() {
            location.reload();
        });
    },
    getUrl : function(url) {
        return url;
    }
};
