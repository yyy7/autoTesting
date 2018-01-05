window.gon = {};gon.gravatar_url="http://www.gravatar.com/avatar/%{hash}?s=%{size}&d=mm";

$('#projects-search').click(function(){
   $('#projects-search-form').submit();
});
// Author: Zoker, Date: 15.02.15, Note: 搜索框焦点背景色更改
$('#search_top-search-input').click(function(){
  document.getElementById("search_top-search-input").style.backgroundColor = '#eaeaea'
});
$('#search_top-search-input').blur(function(){
  document.getElementById("search_top-search-input").style.backgroundColor = '#efefef'
});
$('#projects-search-form').submit(function(){
  query_name = $('.code-search-input').val()
  if(query_name != undefined && $.trim(query_name).length < 5){
    $('#search_top-search-input').focus();
    alert("代码搜索关键字不能少于5个");
    return false;
  }
})


(function() {
  var notify_content, notify_options, setCookie, template;

  template = '<div data-notify="container" class="ui {0} message" role="alert">' + '<i data-notify="dismiss" class="close icon"></i>' + '<span data-notify="message">{2}</span>' + '</div>';

  notify_content = null;

  notify_options = {};

  if (notify_content) {
    notify_options.delay = 3000;
    notify_options.template = template;
    notify_options.offset = {
      x: 10,
      y: 30
    };
    notify_options.element = '#messages-container';
    $.notify(notify_content, notify_options);
  }

  setCookie = function(name, value) {
    var Days, exp;

    Days = 360;
    exp = new Date;
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + '=' + escape(value) + ';expires=' + exp.toGMTString();
  };

  $('#remove-bulletin').on('click', function() {
    setCookie('remove_bulletin', 'no_national_ad');
    $('#git-bulletin').hide();
  });

}).call(this);


var c_start;
c_start = document.cookie.indexOf("remote_way=");
if (c_start == -1) {
  setCookie('remote_way', "http", 360);
}
function setCookie(c_name, value, expiredays) {
  var exdate = new Date();
  exdate.setDate(exdate.getDate() + expiredays);
  document.cookie = c_name + "=" + escape(value) + ((expiredays == null) ? "" : ";expires = " + exdate.toGMTString()) + ("; path = /");
}

$(document).ready(function(){
  $.get("/osc_login", function(data){
    if(data == 1)
      $("#oneclick_login_by_osc").show();
  });
});


var $dropdown = $('#git-nav-user-bar .ui.dropdown');
$dropdown.dropdown({on: 'hover'});

if($(window).width() < 500){
  $(".ui.menu.fixed").css("position", "absolute")
  $('#git-header-nav').css("width", "1050px");
}

$(document).ready(function () {
  window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdMiniList":["weixin","tsina","qzone","tqq","mshare","sqq"],"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"6","bdPos":"right","bdTop":"100"},"image":{"viewList":["weixin","tsina","qzone","tqq","renren"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["weixin","tsina","qzone","tqq","renren"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='/bd_share/static/api/js/share.js'];
  changCssWithStatus();
})

var emailStatus, commentStatus, gotopStatus;

function changCssWithStatus() {
  emailStatus = $("#project-user-message").length;
  commentStatus = $("#home-comment").length;
  gotopStatus = $("#gotop").css("display");
  if (emailStatus == 0 && commentStatus > 0 && gotopStatus == "block") {
    $("#home-comment").css("margin-bottom","-48px");
    $("#gotop").css("margin-bottom","-83px");
  } else if (emailStatus > 0 && commentStatus == 0 && gotopStatus == "block") {
    $("#gotop").css("margin-bottom","-77px");
  } else if (emailStatus == 0 && commentStatus > 0 && gotopStatus == "none") {
    $("#home-comment").css("margin-bottom","-48px");
  } else if (emailStatus == 0 && commentStatus == 0 && gotopStatus == "block") {
    $("#gotop").css("margin-bottom","-38px");
  }
}

$(document).on({
  mouseenter: function(){
    $(".bdshare-slide-bottom").hide();
    $(".bdshare-slide-list-box").css("right","100px");
    $(".bdshare-slide-list-box").css("position","fixed");
}}, 'a.bdshare-slide-button');


function goTop(){
  $(window).scroll(function(e) {
    if($(this).scrollTop()>50){
      $("#gotop").fadeIn(1000);
      changCssWithStatus();
    }
    else
      $("#gotop").fadeOut(1000);
  });
};
$(function(){
  $("#gotop").click(function(e) {
    $('body,html').animate({scrollTop:0},500);
  });
  goTop();
});

function force_mobile() {
  current_url = window.location.href;
  force_mobile_url = current_url.substr(0,current_url.indexOf('?'))+'?force_mobile=true';
  location.href = force_mobile_url;
}
(function () {
  // 更新底栏的位置，当页面内容高度小于窗口高度时，会将底栏浮动定位在窗口底端
  function updateFooterPosition() {
    var pageHeight = document.body.offsetHeight;
    if ($footer.hasClass('fixed-bottom')) {
      pageHeight += $footer.outerHeight();
      if (pageHeight > $(window).height()) {
        $footer.removeClass('fixed-bottom');
      }
    } else {
      if (pageHeight < $(window).height()) {
        $footer.addClass('fixed-bottom');
      }
    }
  }
  var $footer = $('#git-footer-main');
  $(document).on('ready', updateFooterPosition);
  $(window).on({
    'scroll': updateFooterPosition,
    'resize': updateFooterPosition
  });
  // 每隔一段时间检测页面高度变化，确保底栏能在页面最底端
  setInterval(updateFooterPosition, 500);
})();

$(document).ready(function(){
  $.get("/osc_login", function(data){
    if(data == 1)
      $("#oneclick_login_by_osc").css('display','block');
  });
});
var swiper = new Swiper('.swiper-container', {
  slidesPerView: 3,
  paginationClickable: true,
  spaceBetween: 25,
  loop: true,
  nextButton: '.swiper-button-next',
  prevButton: '.swiper-button-prev',
  autoplay: 3000,
  observer:true,
  observeParents:true,
  autoplayDisableOnInteraction : false
});

$(".ui.grey.menu.grid.page.fixed.noborder").css("position", "absolute")
$(".ui.grey.menu.grid.page.fixed.noborder").css("min-width", "1080px");
