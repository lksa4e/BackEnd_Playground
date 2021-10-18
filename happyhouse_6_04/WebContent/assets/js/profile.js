/**
* Template Name: MyBiz - v2.2.1
* Template URL: https://bootstrapmade.com/mybiz-free-business-bootstrap-theme/
* Author: BootstrapMade.com
* License: https://bootstrapmade.com/license/
*/
!(function($) {
  "use strict";

  // Smooth scroll for the navigation menu and links with .scrollto classes
  var scrolltoOffset = $('#header').outerHeight() - 1;
  $(document).on('click', '.nav-menu a, .mobile-nav a, .scrollto', function(e) {
    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
      var target = $(this.hash);
      if (target.length) {
        e.preventDefault();

        var scrollto = target.offset().top - scrolltoOffset;

        if ($(this).attr("href") == '#header') {
          scrollto = 0;
        }

        $('html, body').animate({
          scrollTop: scrollto
        }, 1500, 'easeInOutExpo');

        if ($(this).parents('.nav-menu, .mobile-nav').length) {
          $('.nav-menu .active, .mobile-nav .active').removeClass('active');
          $(this).closest('li').addClass('active');
        }

        if ($('body').hasClass('mobile-nav-active')) {
          $('body').removeClass('mobile-nav-active');
          $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
          $('.mobile-nav-overly').fadeOut();
        }
        return false;
      }
    }
  });

    $('.user_logout').click(function () {
        $.ajax({
			type: "GET",
        	url: "/happyhouse_6_04/user/logout.do",
        	success: function (response) {
				alert("로그아웃 되었습니다.");
				location.href= "index.jsp";
	        },
	        error: function (err) {
		
	        }
  		})
    });

    $('#confirmBtn').click(function () {
        location.href = "index.jsp";
    });

    $('#modifyBtn').click(function () {
		let str = $("#frmProfile").serialize();
        if ($('#userId').val() != "" && $('#userpw').val() != "" && $('#username').val() != "" &&
			$('#useraddress').val() != "" && $('#userphone').val() != "") {
				$.ajax({
					type: "POST",
					data: str,
					dataType: 'json',
		        	url: "/happyhouse_6_04/user/update.do",
		        	success: function (response) {
						if(response == 0){
							alert("회원 정보가 수정되었습니다.");
							location.href= "index.jsp";
						}else{
							alert("회원정보 수정에 실패하였습니다.")
						}
			        },
			        error: function (err) {
			        }
	      		})
        }else{
			alert("모든 항목을 입력해주세요!");
		}
    });

	$('#deleteBtn').click(function () {
		let str = $("#frmProfile").serialize();
        if ($('#userId').val() != "") {
				$.ajax({
					type: "POST",
					data: str,
					dataType: 'json',
		        	url: "/happyhouse_6_04/user/delete.do",
		        	success: function (response) {
						if(response == 0){
							alert("회원정보가 삭제되었습니다.");
							location.href= "index.jsp";
						}
			        },
			        error: function (err) {
				
			        }
	      		})
        }
    });

	let user_id, user_pw, user_name, user_addr, user_tel;
  // Activate smooth scroll on page load with hash links in the url
    $(document).ready(function () {
		$.ajax({
			type: "GET",
        	url: "/happyhouse_6_04/user/loginCheck.do",
        	success: function (response) {
				if(response != null){
					user_id = response.userId;
					user_pw = response.userPw;
					user_name = response.userName;
					user_addr = response.userAddress;
					user_tel = response.userTel;
					
					$('#profile_userId').val(user_id);
					$('#profile_userpw').val(user_pw);
					$('#profile_username').val(user_name);
					$('#profile_useraddress').val(user_addr);
					$('#profile_userphone').val(user_tel);
					$('#profile_userId').attr("readonly", true);
				}
	        },
	        error: function (err) {
				$('.after_login').css('display', 'none');
	        }
	      })

    // 템플릿 js code
    if (window.location.hash) {
      var initial_nav = window.location.hash;
      if ($(initial_nav).length) {
        var scrollto = $(initial_nav).offset().top - scrolltoOffset;
        $('html, body').animate({
          scrollTop: scrollto
        }, 1500, 'easeInOutExpo');
      }
    }
  });

  // Mobile Navigation
  if ($('.nav-menu').length) {
    var $mobile_nav = $('.nav-menu').clone().prop({
      class: 'mobile-nav d-lg-none'
    });
    $('body').append($mobile_nav);
    $('body').prepend('<button type="button" class="mobile-nav-toggle d-lg-none"><i class="icofont-navigation-menu"></i></button>');
    $('body').append('<div class="mobile-nav-overly"></div>');

    $(document).on('click', '.mobile-nav-toggle', function(e) {
      $('body').toggleClass('mobile-nav-active');
      $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
      $('.mobile-nav-overly').toggle();
    });

    $(document).on('click', '.mobile-nav .drop-down > a', function(e) {
      e.preventDefault();
      $(this).next().slideToggle(300);
      $(this).parent().toggleClass('active');
    });

    $(document).click(function(e) {
      var container = $(".mobile-nav, .mobile-nav-toggle");
      if (!container.is(e.target) && container.has(e.target).length === 0) {
        if ($('body').hasClass('mobile-nav-active')) {
          $('body').removeClass('mobile-nav-active');
          $('.mobile-nav-toggle i').toggleClass('icofont-navigation-menu icofont-close');
          $('.mobile-nav-overly').fadeOut();
        }
      }
    });
  } else if ($(".mobile-nav, .mobile-nav-toggle").length) {
    $(".mobile-nav, .mobile-nav-toggle").hide();
  }

  // Navigation active state on scroll
  var nav_sections = $('section');
  var main_nav = $('.nav-menu, .mobile-nav');

  $(window).on('scroll', function() {
    var cur_pos = $(this).scrollTop() + 200;

    nav_sections.each(function() {
      var top = $(this).offset().top,
        bottom = top + $(this).outerHeight();

      if (cur_pos >= top && cur_pos <= bottom) {
        if (cur_pos <= bottom) {
          main_nav.find('li').removeClass('active');
        }
        main_nav.find('a[href="#' + $(this).attr('id') + '"]').parent('li').addClass('active');
      }
      if (cur_pos < 300) {
        $(".nav-menu ul:first li:first, .mobile-menu ul:first li:first").addClass('active');
      }
    });
  });

  // Toggle .header-scrolled class to #header when page is scrolled
  $(window).scroll(function() {
    if ($(this).scrollTop() > 100) {
      $('#header').addClass('header-scrolled');
    } else {
      $('#header').removeClass('header-scrolled');
    }
  });

  if ($(window).scrollTop() > 100) {
    $('#header').addClass('header-scrolled');
  }

  // Stick the header at top on scroll
  $("#header").sticky({
    topSpacing: 0,
    zIndex: '50'
  });

  // Intro carousel
  var heroCarousel = $("#heroCarousel");
  var heroCarouselIndicators = $("#hero-carousel-indicators");
  heroCarousel.find(".carousel-inner").children(".carousel-item").each(function(index) {
    (index === 0) ?
    heroCarouselIndicators.append("<li data-target='#heroCarousel' data-slide-to='" + index + "' class='active'></li>"):
      heroCarouselIndicators.append("<li data-target='#heroCarousel' data-slide-to='" + index + "'></li>");
  });

  heroCarousel.on('slid.bs.carousel', function(e) {
    $(this).find('h2').addClass('animate__animated animate__fadeInDown');
    $(this).find('p, .btn-get-started').addClass('animate__animated animate__fadeInUp');
  });

})(jQuery);