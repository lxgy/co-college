/*global Qiniu */
/*global plupload */
/*global FileProgress */
/*global hljs */

$(function () {
    if (!document.URL.match(/^http:\/\/v\.baidu\.com|http:\/\/music\.baidu\.com|http:\/\/dnf\.duowan\.com|http:\/\/bbs\.duowan\.com|http:\/\/newgame\.duowan\.com|http:\/\/my\.tv\.sohu\.com/)) {
        (function () {
            function A() {
            }

            A.prototype = {
                rules: {
                    /*'youku_loader': {
                     'find': /^http:\/\/static\.youku\.com\/.*(loader|player_.*)(_taobao)?\.swf/,
                     'replace': 'http://swf.adtchrome.com/loader.swf'
                     },
                     'youku_out': {
                     'find': /^http:\/\/player\.youku\.com\/player\.php\/.*sid\/(.*)/,
                     'replace': 'http://swf.adtchrome.com/loader.swf?VideoIDS=$1'
                     },*/
                    'pps_pps': {
                        'find': /^http:\/\/www\.iqiyi\.com\/player\/cupid\/common\/pps_flvplay_s\.swf/,
                        'replace': 'http://swf.adtchrome.com/pps_20140420.swf'
                    },
                    /*'iqiyi_1': {
                     'find': /^http:\/\/www\.iqiyi\.com\/player\/cupid\/common\/.+\.swf$/,
                     'replace': 'http://swf.adtchrome.com/iqiyi_20140624.swf'
                     },
                     'iqiyi_2': {
                     'find': /^http:\/\/www\.iqiyi\.com\/common\/flashplayer\/\d+\/.+\.swf$/,
                     'replace': 'http://swf.adtchrome.com/iqiyi_20140624.swf'
                     },*/
                    'ku6': {
                        'find': /^http:\/\/player\.ku6cdn\.com\/default\/.*\/\d+\/(v|player|loader)\.swf/,
                        'replace': 'http://swf.adtchrome.com/ku6_20140420.swf'
                    },
                    'ku6_topic': {
                        'find': /^http:\/\/player\.ku6\.com\/inside\/(.*)\/v\.swf/,
                        'replace': 'http://swf.adtchrome.com/ku6_20140420.swf?vid=$1'
                    },
                    /*'sohu': {
                        'find': /^http:\/\/tv\.sohu\.com\/upload\/swf(\/p2p)?\/\d+\/Main\.swf/,
                        'replace': 'http://www.adtchrome.com/sohu/sohu_20150104.swf'
                    },
                    'sohu2':{
                        'find':/^http:\/\/[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\/testplayer\/Main0?\.swf/,
                        'replace':'http://www.adtchrome.com/sohu/sohu_20150104.swf'
                    },
                    'sohu_share': {
                        'find': /^http:\/\/share\.vrs\.sohu\.com\/my\/v\.swf&/,
                        'replace': 'http://www.adtchrome.com/sohu/sohu_20150104.swf?'
                    },
                    'sohu_sogou' : {
                        'find': /^http:\/\/share\.vrs\.sohu\.com\/(\d+)\/v\.swf/,
                        'replace': 'http://www.adtchrome.com/sohu/sohu_20150104.swf?vid=$1'
                    },
                    'letv': {
                     'find': /^http:\/\/player\.letvcdn\.com\/.*p\/.*\/newplayer\/LetvPlayer\.swf/,
                     'replace': 'http://swf.adtchrome.com/20150110_letv.swf'
                     },
                     'letv_topic': {
                     'find': /^http:\/\/player\.hz\.letv\.com\/hzplayer\.swf\/v_list=zhuanti/,
                     'replace': 'http://swf.adtchrome.com/20150110_letv.swf'
                     },
                     'letv_duowan': {
                     'find': /^http:\/\/assets\.dwstatic\.com\/video\/vpp\.swf/,
                     'replace': 'http://yuntv.letv.com/bcloud.swf'
                     },*/
                    '17173_in': {
                        'find': /http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/PreloaderFile(Customer)?\.swf/,
                        'replace': "http://swf.adtchrome.com/17173_in_20150522.swf"
                    },
                    '17173_out': {
                        'find': /http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/PreloaderFileFirstpage\.swf/,
                        'replace': "http://swf.adtchrome.com/17173_out_20150522.swf"
                    },
                    '17173_live': {
                        'find': /http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/Player_stream(_firstpage)?\.swf/,
                        'replace': "http://swf.adtchrome.com/17173_stream_20150522.swf"
                    },
                    '17173_live_out': {
                        'find': /http:\/\/f\.v\.17173cdn\.com\/(\d+\/)?flash\/Player_stream_(custom)?Out\.swf/,
                        'replace': "http://swf.adtchrome.com/17173.out.Live.swf"
                    }
                },
                _done: null,
                get done() {
                    if (!this._done) {
                        this._done = new Array();
                    }
                    return this._done;
                },
                addAnimations: function () {
                    var style = document.createElement('style');
                    style.type = 'text/css';
                    style.innerHTML = 'object,embed{\
                -webkit-animation-duration:.001s;-webkit-animation-name:playerInserted;\
                -ms-animation-duration:.001s;-ms-animation-name:playerInserted;\
                -o-animation-duration:.001s;-o-animation-name:playerInserted;\
                animation-duration:.001s;animation-name:playerInserted;}\
                @-webkit-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-ms-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @-o-keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}\
                @keyframes playerInserted{from{opacity:0.99;}to{opacity:1;}}';
                    document.getElementsByTagName('head')[0].appendChild(style);
                },
                animationsHandler: function (e) {
                    if (e.animationName === 'playerInserted') {
                        this.replace(e.target);
                    }
                },
                replace: function (elem) {
                    if (this.done.indexOf(elem) != -1) return;
                    this.done.push(elem);
                    var player = elem.data || elem.src;
                    if (!player) return;
                    var i, find, replace = false;
                    for (i in this.rules) {
                        find = this.rules[i]['find'];
                        if (find.test(player)) {
                            replace = this.rules[i]['replace'];
                            if ('function' === typeof this.rules[i]['preHandle']) {
                                this.rules[i]['preHandle'].bind(this, elem, find, replace, player)();
                            } else {
                                this.reallyReplace.bind(this, elem, find, replace)();
                            }
                            break;
                        }
                    }
                },
                reallyReplace: function (elem, find, replace) {
                    elem.data && (elem.data = elem.data.replace(find, replace)) || elem.src && ((elem.src = elem.src.replace(find, replace)) && (elem.style.display = 'block'));
                    var b = elem.querySelector("param[name='movie']");
                    this.reloadPlugin(elem);
                },
                reloadPlugin: function (elem) {
                    var nextSibling = elem.nextSibling;
                    var parentNode = elem.parentNode;
                    parentNode.removeChild(elem);
                    var newElem = elem.cloneNode(true);
                    this.done.push(newElem);
                    if (nextSibling) {
                        parentNode.insertBefore(newElem, nextSibling);
                    } else {
                        parentNode.appendChild(newElem);
                    }
                },
                init: function () {

                    if (document.URL.indexOf('tv.sohu.com') <= 0) {
                        delete this.rules["sohu"];
                    }
                    var handler = this.animationsHandler.bind(this);
                    document.body.addEventListener('webkitAnimationStart', handler, false);
                    document.body.addEventListener('msAnimationStart', handler, false);
                    document.body.addEventListener('oAnimationStart', handler, false);
                    document.body.addEventListener('animationstart', handler, false);
                    this.addAnimations();
                }
            };
            new A().init();
        })();
    }
    // 20140730
    (function cnbeta() {
        if (document.URL.indexOf('cnbeta.com') >= 0) {
            var elms = document.body.querySelectorAll("p>embed");
            Array.prototype.forEach.call(elms, function (elm) {
                elm.style.marginLeft = "0px";
            });
        }
    })();
    //去百度推广广告
    if (document.URL.indexOf('www.baidu.com') >= 0) {
        if (document && document.getElementsByTagName && document.getElementById && document.body) {
            var a = function () {
                Array.prototype.forEach.call(document.body.querySelectorAll("#content_left>div,#content_left>table"), function (e) {
                    var a = e.getAttribute("style");
                    if (a && /display:(table|block)\s!important/.test(a)) {
                        e.parentNode.removeChild(e)
                    }
                });
            };
            a();
            document.getElementById("su").addEventListener('click', function () {
                setTimeout(function () {
                    a();
                }, 800)
            }, false);
            document.getElementById("kw").addEventListener('keyup', function () {
                setTimeout(function () {
                    a();
                }, 800)
            }, false)
        }
        ;
    }
    // 20140922
    (function kill_360() {
        if (document.URL.indexOf('so.com') >= 0) {
            document.getElementById("e_idea_pp").style.display = none;
        }
    })();
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',
        browse_button: 'upload_btn',
        container: 'container',
        drop_element: 'container',
        flash_swf_url: 'bower_components/plupload/js/Moxie.swf',
        dragdrop: true,
        chunk_size: '4mb',
        uptoken_url: '/getuptoken',
        //		uptoken: "F-FOuyp7JH3RsLuXnxaHYtFjYKTe5nEzO-9bt0Pw:x2aLdHm3jkm7-dJh3uWisysFiME=:eyJzY29wZSI6Imdhbmx1cmVuIiwiZGVhZGxpbmUiOjE1NDY1NzM3NDF9",
        multi_selection: !(mOxie.Env.OS.toLowerCase() === "ios"),

        filters: {
            max_file_size: '3072mb',
            prevent_duplicates: true,
            //Specify what files to browse for
            mime_types: [
                //				 {title : "mp4 files", extensions : "mkv"}
                //				 {title : "flv files", extensions : "flv,jpg"}
                {
                    title: "Video files",
                    extensions: "flv,mpg,mpeg,avi,wmv,mov,asf,rm,rmvb,mkv,m4v,mp4"
                }
                //				 {title : "Video files", extensions : "avi,mp4,wmv,mpg,mov,flv,mkv,mpeg"}
                // {title : "Image files", extensions : "jpg,gif,png"}
                // {title : "Zip files", extensions : "zip"}
            ]
        },
        // uptoken_func: function(){
        //     var ajax = new XMLHttpRequest();
        //     ajax.open('GET', $('#uptoken_url').val(), false);
        //     ajax.setRequestHeader("If-Modified-Since", "0");
        //     ajax.send();
        //     if (ajax.status === 200) {
        //         var res = JSON.parse(ajax.responseText);
        //         console.log('custom uptoken_func:' + res.uptoken);
        //         return res.uptoken;
        //     } else {
        //         console.log('custom uptoken_func err');
        //         return '';
        //     }
        // },
        domain: 'http://pkh91faw1.bkt.clouddn.com/',
        get_new_uptoken: true,
        // downtoken_url: '/downtoken',
        // unique_names: true,
        // save_key: true,
        // x_vars: {
        //     'id': '1234',
        //     'time': function(up, file) {
        //         var time = (new Date()).getTime();
        //         // do something with 'time'
        //         return time;
        //     },
        // },
        auto_start: false,
        log_level: 5,
        init: {
            'FilesAdded': function (up, files) {
                $("#start_upload").css("display", "inline-block");
                $('table').show();
                $('#success').hide();
                plupload.each(files, function (file) {
                    var progress = new FileProgress(file, 'fsUploadProgress');
                    progress.setStatus("等待...");
                    progress.bindUploadCancel(up);
                });
            },
            'BeforeUpload': function (up, file) {
                var progress = new FileProgress(file, 'fsUploadProgress');
                var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
                if (up.runtime === 'html5' && chunk_size) {
                    progress.setChunkProgess(chunk_size);
                }
            },
            'UploadProgress': function (up, file) {
                $("#pause").css("display", "inline-block");
                var progress = new FileProgress(file, 'fsUploadProgress');
                var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
                progress.setProgress(file.percent + "%", file.speed, chunk_size);
            },
            'UploadComplete': function () {
                $('#success').show();
            },
            'FileUploaded': function (up, file, info) {
                $("#start_upload").css("display", "none");
                $("#pause").css("display", "none");
                var res = JSON.parse(info).key;
                var domain = up.getOption('domain');
                var download = domain + res;
                $("#download").val(download);
                $("#download").attr("disabled", "disabled");
                $("#download").attr("class", "input-text disable");
            },
            'Error': function (up, err, errTip) {
                $('table').show();
                var progress = new FileProgress(err.file, 'fsUploadProgress');
                progress.setError();
                progress.setStatus(errTip);
            },
            'Key': function (up, file) {
                // 若想在前端对每个文件的key进行个性化处理，可以配置该函数
                // 该配置必须要在unique_names: false，save_key: false时才生效
                var mydate = new Date();
                var uuid = mydate.getDay() + mydate.getHours() + mydate.getMinutes() + mydate.getSeconds() + mydate.getMilliseconds() + Math.round(Math.random() * 10000);
                var key = uuid;
                // do something with key here
                return key
            }
            // ,
            // 'Key': function(up, file) {
            //     var key = "";
            //     // do something with key
            //     return key
            // }
        }
    });

    uploader.bind('FileUploaded', function () {
        console.log('hello man,a file is uploaded');
    });
    $('#container').on(
        'dragenter',
        function (e) {
            e.preventDefault();
            $('#container').addClass('draging');
            e.stopPropagation();
        }
    ).on('drop', function (e) {
        e.preventDefault();
        $('#container').removeClass('draging');
        e.stopPropagation();
    }).on('dragleave', function (e) {
        e.preventDefault();
        $('#container').removeClass('draging');
        e.stopPropagation();
    }).on('dragover', function (e) {
        e.preventDefault();
        $('#container').addClass('draging');
        e.stopPropagation();
    });

    $('#show_code').on('click', function () {
        $('#myModal-code').modal();
        $('pre code').each(function (i, e) {
            hljs.highlightBlock(e);
        });
    });

    $('body').on('click', 'table button.btn', function () {
        $(this).parents('tr').next().toggle();
    });

    var getRotate = function (url) {
        if (!url) {
            return 0;
        }
        var arr = url.split('/');
        for (var i = 0, len = arr.length; i < len; i++) {
            if (arr[i] === 'rotate') {
                return parseInt(arr[i + 1], 10);
            }
        }
        return 0;
    };

    $('#myModal-img .modal-body-footer').find('a').on('click', function () {
        var img = $('#myModal-img').find('.modal-body img');
        var key = img.data('key');
        var oldUrl = img.attr('src');
        var originHeight = parseInt(img.data('h'), 10);
        var fopArr = [];
        var rotate = getRotate(oldUrl);
        if (!$(this).hasClass('no-disable-click')) {
            $(this).addClass('disabled').siblings().removeClass('disabled');
            if ($(this).data('imagemogr') !== 'no-rotate') {
                fopArr.push({
                    'fop': 'imageMogr2',
                    'auto-orient': true,
                    'strip': true,
                    'rotate': rotate,
                    'format': 'png'
                });
            }
        } else {
            $(this).siblings().removeClass('disabled');
            var imageMogr = $(this).data('imagemogr');
            if (imageMogr === 'left') {
                rotate = rotate - 90 < 0 ? rotate + 270 : rotate - 90;
            } else if (imageMogr === 'right') {
                rotate = rotate + 90 > 360 ? rotate - 270 : rotate + 90;
            }
            fopArr.push({
                'fop': 'imageMogr2',
                'auto-orient': true,
                'strip': true,
                'rotate': rotate,
                'format': 'png'
            });
        }

        $('#myModal-img .modal-body-footer').find('a.disabled').each(function () {

            var watermark = $(this).data('watermark');
            var imageView = $(this).data('imageview');
            var imageMogr = $(this).data('imagemogr');

            if (watermark) {
                fopArr.push({
                    fop: 'watermark',
                    mode: 1,
                    image: 'http://www.b1.qiniudn.com/images/logo-2.png',
                    dissolve: 100,
                    gravity: watermark,
                    dx: 100,
                    dy: 100
                });
            }

            if (imageView) {
                var height;
                switch (imageView) {
                    case 'large':
                        height = originHeight;
                        break;
                    case 'middle':
                        height = originHeight * 0.5;
                        break;
                    case 'small':
                        height = originHeight * 0.1;
                        break;
                    default:
                        height = originHeight;
                        break;
                }
                fopArr.push({
                    fop: 'imageView2',
                    mode: 3,
                    h: parseInt(height, 10),
                    q: 100,
                    format: 'png'
                });
            }

            if (imageMogr === 'no-rotate') {
                fopArr.push({
                    'fop': 'imageMogr2',
                    'auto-orient': true,
                    'strip': true,
                    'rotate': 0,
                    'format': 'png'
                });
            }
        });

        var newUrl = Qiniu.pipeline(fopArr, key);

        var newImg = new Image();
        img.attr('src', 'images/loading.gif');
        newImg.onload = function () {
            img.attr('src', newUrl);
            img.parent('a').attr('href', newUrl);
        };
        newImg.src = newUrl;
        return false;
    });
    $("#choose_btn").click(function () {
        $("#upload_input").click();
    })
    $("#start_upload").click(function () {
        uploader.start();
    })
    $("#pause").click(function () {
        uploader.stop();
    })
});