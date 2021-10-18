<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>HappyHouse - 메인화면</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link
        href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
        rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
    <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">
    
    <!-- =======================================================
  * Template Name: MyBiz - v2.2.1
  * Template URL: https://bootstrapmade.com/mybiz-free-business-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" 
    integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    
</head>

<body>
    <!-- ======= Top Bar ======= -->
    <section id="topbar" class="d-none d-lg-block">
        <div class="container">
            <div class="user_maintainer bx-pull-right">
                <div class="before_login">
                    <a href="./user_join.html" class="user_join">회원가입</a>
                    <a href="./user_login.html" class="user_login">로그인</a>
                </div>
                <div class="after_login">
                    <a href="./user_profile.html" class="user_profile">회원정보</a>
                    <a href="#" class="user_logout">로그아웃</a>
                </div>
            </div>
        </div>
    </section>

    <!-- ======= Header ======= -->
    <header id="header" class="d-flex align-items-center">
        <div class="container d-flex align-items-center">

            <div class="logo mr-auto">
                <h1 class="text-light"><a href="index.jsp">Happy<span>House</span></a></h1>
                <!-- Uncomment below if you prefer to use an image logo -->
                <!-- <a href="index.html"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->
            </div>

            <nav class="nav-menu d-none d-lg-block">
                <ul>
                    <li class="active"><a href="#header">Home</a></li>
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">오늘의 뉴스</a></li>
                    <li><a href="#">관심지역 설정</a></li>
                    <li><a href="#">관심지역 살펴보기</a></li>
                </ul>
            </nav><!-- .nav-menu -->

        </div>
    </header><!-- End Header -->

    <div id="wrapper">
        <!-- ======= Hero Section ======= -->
        <section id="hero">
            <div class="hero-container">
                <div id="heroCarousel" class="carousel slide carousel-fade" data-ride="carousel">
    
                    <ol class="carousel-indicators" id="hero-carousel-indicators"></ol>
    
                    <div class="carousel-inner" role="listbox">
    
                        <!-- Slide 1 -->
                        <div class="carousel-item active" style="background-image: url(assets/img/slide/home1.jpeg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown">Welcome to <span>HappyHouse</span></h2>
                                    <p class="animate__animated animate__fadeInUp card-content">HappyHouse에서 원하는 집을 찾아보세요!</p>
                                </div>
                            </div>
                        </div>
    
                        <!-- Slide 2 -->
                        <div class="carousel-item" style="background-image: url(assets/img/slide/home2.jpeg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown">지역별로 엄선된 매물</h2>
                                    <p class="animate__animated animate__fadeInUp card-content">지역별 필터를 이용하여 원하는 매물을 찾으세요!</p>
                                </div>
                            </div>
                        </div>
    
                        <!-- Slide 3 -->
                        <div class="carousel-item" style="background-image: url(assets/img/slide/home3.jpeg);">
                            <div class="carousel-container">
                                <div class="carousel-content">
                                    <h2 class="animate__animated animate__fadeInDown">아파트, 주택에 대한 구체적인 정보</h2>
                                    <p class="animate__animated animate__adeInUp card-content">이미지와 함께 제공되는 상세한 매물 정보들을 얻어보세요!</p>
                                </div>
                            </div>
                        </div>
    
                    </div>
    
                    <a class="carousel-control-prev" href="#heroCarousel" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon ri-arrow-left-line" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
    
                    <a class="carousel-control-next" href="#heroCarousel" role="button" data-slide="next">
                        <span class="carousel-control-next-icon ri-arrow-right-line" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
    
                </div>
            </div>
        </section><!-- End Hero -->
    
        <section id="Select">
            <div class="sorting-filters text-center mb-20 d-flex justify-content-center">
                <form class="form-inline" id="frm" action= "${root}/housedeal/search.do">
                    <script>
                dealinfos = []; // 매매 정보 저장 리스트
				$(document).ready(function(){
					$.get("${root}/housedeal/sido.do"
						,function(data, status){
							$.each(data, function(index, vo) {
								$("#sido").append("<option value='"+vo.sidoCode+"'>"+vo.sidoName+"</option>");
							});//each
						}//function
						, "json"
					);//get
					
					// 시도 선택 시 시구군 불러오기
					$("#sido").change(function() {
						$.get("${root}/housedeal/gugun.do"
								,{sido:$("#sido").val()}
								,function(data, status){
									$("#gugun").empty();
									$("#gugun").append('<option value="0">시/구/군</option>');
									$.each(data, function(index, vo) {
										$("#gugun").append("<option value='"+vo.gugunCode+"'>"+vo.gugunName+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
					
					
					// 시/구/군 선택시 동 불러오기
					$("#gugun").change(function() {
						$.get("${root}/housedeal/dong.do"
								,{gugun:$("#gugun").val()}
								,function(data, status){
									$("#dong").empty();
									$("#dong").append('<option value="0">동</option>');
									$.each(data, function(index, vo) {
										$("#dong").append("<option value='"+vo.dongCode+"'>"+vo.dongName+"</option>");
									});//each
								}//function
								, "json"
						);//get
					});//change
					
				});//ready
				</script>
                <div class="form-group md">
                  <select class="form-control" name="sido" id="sido">
                    <option value="0">도/광역시</option>
                  </select>
                </div>
                <div class="form-group md-1">
                  <select class="form-control" name="gugun" id="gugun">
                    <option value="0">시/구/군</option>
                  </select>
                </div>
                <div class="form-group md-1">
                  <select class="form-control" name="dong" id="dong">
                    <option value="0">동</option>
                  </select>
                </div>
                <div class="form-group md-1">
                	<span>  </span>
                    <input class= "form-control" type = "submit" value = "검색">
                </div>
              </form>
            </div>
        </section>

        <div class="row">
            <div class="col-lg-2"></div>
            <div class="map col-lg-8">
                <iframe style="border:0; width: 100%; height: 500px; margin-top: 10px; margin-bottom: 150px;"
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1582.6424020405082!2d127.03850635012358!3d37.501200404812316!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca3ff67128961%3A0x55a56e8ffc5bc5d!2z66mA7Yuw7Lqg7Y287IqkIOyXreyCvA!5e0!3m2!1sko!2skr!4v1630673087028!5m2!1sko!2skr"
                    frameborder="0" allowfullscreen></iframe>
            </div>
            <div class="col-lg-2"></div>
        </div>
    
        <!-- ======= Footer ======= -->
        <footer id="footer">
            <div class="container">
                <div class="copyright">
                    &copy; Copyright <strong><span>SSAFY</span></strong>. All Rights Reserved
                </div>
                <div class="credits">
                    Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                </div>
            </div>
        </footer><!-- End Footer -->
    </div>

    <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

    <!-- Vendor JS Files -->
    <script src="assets/vendor/jquery/jquery.min.js"></script>
    <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
    <script src="assets/vendor/php-email-form/validate.js"></script>
    <script src="assets/vendor/jquery-sticky/jquery.sticky.js"></script>
    <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
    <script src="assets/vendor/counterup/counterup.min.js"></script>
    <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
    <script src="assets/vendor/venobox/venobox.min.js"></script>
    <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
    <!-- Template Main JS File -->
    <script src="assets/js/main.js"></script>
</body>
</html>