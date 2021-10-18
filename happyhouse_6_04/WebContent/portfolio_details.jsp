<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/navbar.jsp" %>

  <div id="wrapper">
    <main id="main">
      <!-- ======= Portfolio Details Section ======= -->
      <section id="portfolio-details" class="portfolio-details">
        <div class="row" style="margin-bottom: 50px;">
          <div class="container">
            <div class="sorting-filters text-center mb-20 d-flex justify-content-center">
              <form class="form-inline" id="frm" action="searchRecentHouseDeal.do">
                <!-- <input type="hidden" id="code"  name="code" value="code"/> -->
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
					
					$.get("${root}/housedeal/dealinfo.do"
							,{dong:$("#dong").val()}
							,function(data, status){
								$(".housedeals").empty();
								dealinfos =[];
								$.each(data, function(index, vo) {
									dealinfos.push(vo);
									$(".housedeals").append(
											"<div class='icon-box mt-5 mt-lg-0' id='" + index +  "'> <i class='bx bx-building-house'></i>" + 
											"<a href='javascript:void(0);' onclick='aptclick()' style='color:darkslategray'>" + 
											"<h4>" + vo.aptName + "</h4>" +
						                      "</a>" +
						                      "<p><strong>거래금액 : " + vo.dealAmount + "만원</strong></p>" + 
											 "</div>"
											);
									$( "#" + index ).on( "click", function() {
											$("#whitespace").empty();
											$("#whitespace").append(
												"<h3>" + dealinfos[index].aptName + "</h3>"+
												"<ul>" + 
							                    "<li><strong>매매가: </strong>" + dealinfos[index].dealAmount + "만원</li>" + 
							                    "<li><strong>매매일: </strong>" + dealinfos[index].dealYear + "." + dealinfos[index].dealMonth + "." + dealinfos[index].dealDay + "</li>" + 
							                    "<li><strong>면적: </strong>" + dealinfos[index].area + "</li>" + 
							                    "<li><strong>층수: </strong>" + dealinfos[index].floor + "</li>" + 
							                    "<li><strong>준공일: </strong>" + dealinfos[index].buildYear + "</li>" + 
							                  "</ul>"
											);
										});

								});//each
								console.log(dealinfos);
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
					
					
					$("#dong").change(function() {
						$.get("${root}/housedeal/dealinfo.do"
								,{dong:$("#dong").val()}
								,function(data, status){
									$(".housedeals").empty();
									dealinfos =[];
									$.each(data, function(index, vo) {
										dealinfos.push(vo);
										$(".housedeals").append(
												"<div class='icon-box mt-5 mt-lg-0' id='" + index +  "'> <i class='bx bx-building-house'></i>" + 
												"<a href='javascript:void(0);' onclick='aptclick()' style='color:darkslategray'>" + 
												"<h4>" + vo.aptName + "</h4>" +
							                      "</a>" +
							                      "<p><strong>거래금액 : " + vo.dealAmount + "만원</strong></p>" + 
												 "</div>"
												);
										$( "#" + index ).on( "click", function() {
												$("#whitespace").empty();
												$("#whitespace").append(
													"<h3>" + dealinfos[index].aptName + "</h3>"+
													"<ul>" + 
								                    "<li><strong>매매가: </strong>" + dealinfos[index].dealAmount + "만원</li>" + 
								                    "<li><strong>매매일: </strong>" + dealinfos[index].dealYear + "." + dealinfos[index].dealMonth + "." + dealinfos[index].dealDay + "</li>" + 
								                    "<li><strong>면적: </strong>" + dealinfos[index].area + "</li>" + 
								                    "<li><strong>층수: </strong>" + dealinfos[index].floor + "</li>" + 
								                    "<li><strong>준공일: </strong>" + dealinfos[index].buildYear + "</li>" + 
								                  "</ul>"
												);
											});

									});//each
									console.log(dealinfos);
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
                  <select class="form-control" name="apt" id="apt">
                    <option value="apt">아파트</option>
                    <option value="villa">주택</option>
                  </select>
                </div>
              </form>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="container col-lg-4">
            <section id="about-list" class="about-list">
              <div class="container" id="list">
                <div class="row">
                  <div class="col-lg-5"></div>
                  <div class="col-lg-7 order-2 order-lg-1">
                    <h4><strong>아파트 거래정보</strong></h4>
                    <hr>
					<div class="housedeals">
					</div>
  
                    </hr>
                  </div>
  
                </div>
            </section><!-- End About List Section -->
          </div>
          <div class="container col-lg-7">
            <div class="row" style="margin-top : 50px">
              <div class=" col-lg-9 portfolio-details-container">
                <div>
                  <!-- class="owl-carousel portfolio-details-carousel" -->
                  <img id="change_img1" src="assets/img/apt/공덕1_삼성래미안_1.jpg" class="img-fluid" alt="">
                  <!-- <img id = "change_img2" src="assets/img/apt/공덕1_삼성래미안_2.jpg" class="img-fluid" alt="">
                  <img id = "change_img3" src="assets/img/apt/공덕1_삼성래미안_3.jpg" class="img-fluid" alt=""> -->
                </div>
  
                <div class="portfolio-info" id="whitespace">
                
                </div>
  
              </div>
  
              <div class="col-lg-3 portfolio-description">
                <h2> </h2>
              </div>
            </div>
          </div>
        </div>
      </section><!-- End Portfolio Details Section -->
  
    </main><!-- End #main -->
  
<%@ include file="/footer.jsp" %>