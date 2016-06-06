var gulp = require('gulp'),
    less = require('gulp-less'),
    ejs = require('gulp-ejs'),
    concat = require('gulp-concat'),
    rename = require('gulp-rename'),
    uglify = require('gulp-uglify'),
    minifycss = require('gulp-minify-css'),
    bower = require('gulp-bower'),
    webserver = require('gulp-webserver'),
    del = require('del');

var bower_source_dir = 'bower_components';
var bower_target_dir = 'src/main/webapp/static/libs';

gulp.task('bower', function() {
    return bower().pipe(gulp.dest(bower_source_dir))
});

gulp.task('copy-lib', function() {
    // jQuery
    gulp.src(bower_source_dir + '/jquery/dist/jquery.js')
        .pipe(gulp.dest(bower_target_dir + '/jquery'));

    gulp.src(bower_source_dir + '/jquery/dist/jquery.min.js')
        .pipe(gulp.dest(bower_target_dir + '/jquery'));

    gulp.src(bower_source_dir + '/jquery/dist/jquery.min.map')
        .pipe(gulp.dest(bower_target_dir + '/jquery'));

    // jQuery Migrate
    gulp.src(bower_source_dir + '/jquery-migrate/jquery-migrate.js')
        .pipe(gulp.dest(bower_target_dir + '/jquery-migrate'));

    gulp.src(bower_source_dir + '/jquery-migrate/jquery-migrate.min.js')
        .pipe(gulp.dest(bower_target_dir + '/jquery-migrate'));

    // jQuery Form
    gulp.src(bower_source_dir + '/jquery-form/jquery.form.js')
        .pipe(gulp.dest(bower_target_dir + '/jquery-plugin'));

    // jQuery Validation
    gulp.src(bower_source_dir + '/jquery-validation/dist/jquery.validate.js')
        .pipe(gulp.dest(bower_target_dir + '/jquery-plugin'));

    gulp.src(bower_source_dir + '/jquery-validation/dist/jquery.validate.min.js')
        .pipe(gulp.dest(bower_target_dir + '/jquery-plugin'));

    // underscore
    gulp.src(bower_source_dir + '/underscore/underscore.js')
        .pipe(gulp.dest(bower_target_dir + '/backbone'));

    gulp.src(bower_source_dir + '/underscore/underscore-min.js')
        .pipe(gulp.dest(bower_target_dir + '/backbone'));

    gulp.src(bower_source_dir + '/underscore/underscore-min.map')
        .pipe(gulp.dest(bower_target_dir + '/backbone'));

    // backbone
    gulp.src(bower_source_dir + '/backbone/backbone.js')
        .pipe(gulp.dest(bower_target_dir + '/backbone'));

    gulp.src(bower_source_dir + '/backbone/backbone-min.js')
        .pipe(gulp.dest(bower_target_dir + '/backbone'));

    gulp.src(bower_source_dir + '/backbone/backbone-min.map')
        .pipe(gulp.dest(bower_target_dir + '/backbone'));

    // JsRender
    gulp.src(bower_source_dir + '/jsrender/jsrender.js')
        .pipe(gulp.dest(bower_target_dir + '/jsrender'));

    gulp.src(bower_source_dir + '/jsrender/jsrender.min.js')
        .pipe(gulp.dest(bower_target_dir + '/jsrender'));

    gulp.src(bower_source_dir + '/jsrender/jsrender.min.js.map')
        .pipe(gulp.dest(bower_target_dir + '/jsrender'));

    // Bootstrap
    gulp.src(bower_source_dir + '/bootstrap/dist/**')
        .pipe(gulp.dest(bower_target_dir + '/bootstrap'));

    // smalot-bootstrap-datetimepicker
    gulp.src(bower_source_dir + '/smalot-bootstrap-datetimepicker/css/**')
        .pipe(gulp.dest(bower_target_dir + '/bootstrap-datetimepicker/css'));

    gulp.src(bower_source_dir + '/smalot-bootstrap-datetimepicker/js/**')
        .pipe(gulp.dest(bower_target_dir + '/bootstrap-datetimepicker/js'));

    // bootstrap-select
    gulp.src(bower_source_dir + '/bootstrap-select/dist/**')
        .pipe(gulp.dest(bower_target_dir + '/bootstrap-select'));

    // bootstrap-switch
    gulp.src(bower_source_dir + '/bootstrap-switch/dist/**')
        .pipe(gulp.dest(bower_target_dir + '/bootstrap-switch'));

    // bootstrap-table
    gulp.src(bower_source_dir + '/bootstrap-table/dist/**')
        .pipe(gulp.dest(bower_target_dir + '/bootstrap-table'));

    // Font-awesome
    gulp.src(bower_source_dir + '/font-awesome/css/**')
        .pipe(gulp.dest(bower_target_dir + '/font-awesome/css'));

    gulp.src(bower_source_dir + '/font-awesome/fonts/**')
        .pipe(gulp.dest(bower_target_dir + '/font-awesome/fonts'));

    // ztree
    gulp.src(bower_source_dir + '/z-tree.v3/css/**')
        .pipe(gulp.dest(bower_target_dir + '/ztree/css'));

    gulp.src(bower_source_dir + '/z-tree.v3/js/**')
        .pipe(gulp.dest(bower_target_dir + '/ztree/js'));
});

gulp.task('clean', function(cb) {
    del([
        bower_source_dir
    ], cb);
});

gulp.task('prototype', function() {
    gulp.src("src/main/webapp/prototype/src/**.ejs")
        .pipe(ejs({
            msg : "Hello Gulp!"
        }, {
            ext : '.html'
        }))
        .pipe(gulp.dest("src/main/webapp/prototype/public/views"));

    gulp.src('src/main/webapp/prototype/public')
        .pipe(webserver({
            fallback : 'index.html'
        }));
});

gulp.task('default', ['bower', 'copy-lib']);
