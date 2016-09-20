/**
 * 常用工具类,封装一些常用的工具类方法
 */
'use strict';

var Utils = {
    escapeHTML : function(text) {
        if (typeof text === 'string') {
            return text
                .replace(/&/g, '&amp;')
                .replace(/</g, '&lt;')
                .replace(/>/g, '&gt;')
                .replace(/"/g, '&quot;')
                .replace(/'/g, '&#039;')
                .replace(/`/g, '&#x60;');
        }
        return text;
    }
};
