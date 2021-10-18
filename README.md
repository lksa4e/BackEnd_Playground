# 🎯 관통 프로젝트

## 🧑 프로젝트 참여자

- **김경준**
- **이정수**

## 1. 목표

- 웹 MVC 아키텍처의 이해 및 활용을 통한 확장성과 유지보수성이 좋은 웹 서버 구축 </br>
- Servlet/JSP를 활용한 웹 서버 구축 </br>
- Front-End 및 DB와 백엔드의 연동 </br>

## 2. 사용 데이터

- 국토교통부 아파트/ 연립 다세대 실거래가 자료 - 공공 데이터 포탈
  - (https://www.data.go.kr/dataset/3050988/openapi.do)
- 법정 동 코드 – 행정 표준 코드 관리 시스템
  - (https://www.code.go.kr/stdcode/regCodeL.do)
- 환경 지도점검 데이터 – 서울 열린 데이터 광장
  - (https://data.seoul.go.kr/dataList/datasetList.do#)
- 상권정보 – 공공 데이터 포탈
  - (https://www.data.go.kr/dataset/15012005/fileData.do)
- 코로나 선별 진료소 현황- 공공데이터 포탈
  - https://www.mohw.go.kr/react/popup_200128_3.html
- 국민 안심 병원 목록- 공공데이터 포탈
  - https://www.mohw.go.kr/react/popup_200128.html

## 3. 요구사항

<h3> 1) 기본(필수) 기능</h3>

<h4> MVC 아키텍처를 이용한 HappyHouse 클래스 설계 및 구현 </h4>

- HappyHouse 메인 화면 구성

- 동별, 아프터별 실거래가 검색 기능 구현

- 회원정보 등록, 수정, 탈퇴, 조회 기능 구현

- 로그인/로그아웃 기능 구현

<h3> 2) 추가기능 </h3>

- 동네 업종 정보를 관리하고 업종 종류별로 지도에 출력

- 동네 환경 점검 정보를 관리하고 환경 점검 종류별로 지도에 출력

<h3> 3) 심화기능 </h3>

- HappyHouse 웹에 접속한 사용자를 위해 공지사항을 등록, 수정, 삭제, 조회할 수 있는 공지사항 구현

## 4. 결과 소스 코드

### Back-End

_Controller_

```java
Contoller           // Controller interface
HosueDealController // url 기반 실거래가 Logic 처리 Sub-Controller
UserController      // url 기반 사용자 Logic 처리 Sub-Controller
MainServlet         // 모든 요청을 받아들이는 Front-Controller 서블릿
```

_DAO_

```java
HouseDealDao        // 실거래가 정보 Database Logic 처리 DAO interface
HouseDealDaoImpl    // 실거래가 정보 Database Logic 처리 DAO 메서드 구현
UserDao             // 사용자 정보 Database Logic 처리 DAO interface
UserDaoImpl         // 사용자 정보 Database Logic 처리 DAO 메서드 구현
```

_DTO_

```java
DataInfo            // Front-Controller 구조를 위한 응답 데이터 관리 Class
HouseInfo           // 실거래가 데이터 관리 Class
SidoGugunCode       // 시/도/구군 데이터 관리 Class
User                // 사용자 데이터 관리 Class
```

_Service_

```java
HouseDealService      // 실거래가 Business Logic 처리 Service interface
HouseDealServiceImpl  // 실거래가 Business Logic 처리 Service 메서드 구현
UserService           // 사용자 Business Logic 처리 Service interface
UserServiceImpl       // 사용자 Business Logic 처리 Service interface
```

### Front-End

_View_

```java
index.html           // Applcation 메인 페이지
navbar.jsp           // 모든 화면에 포함되는 navigation bar
portfolio_detail.jsp // 실거래가 상세정보 조회 페이지
user_join.html       // 회원가입 페이지
user_login.html      // 로그인 페이지
user_profile.html    // 사용자 상제정보 페이지
```

_javaScript_

```java
join.js               // 회원가입 요청
login.js              // 로그인 요청
main.js               // 세션 기반 로그인 상태 요청, 시/군/구 입력시 실거래가 상세정보 요청
profile.js            // 세션 기반 로그인 사용자 상세정보 요청
portfolio_details.js  // 동별, 아파트별 실거래가 상세정보 요청
```

<img src="res/ERD.png" width="70%">

## 💡 진행 테이블

| 난이도 |                    구현 기능                    | 점수 | 완성 여부 |
| :----: | :---------------------------------------------: | :--: | :-------: |
|  기본  |                    메인 화면                    |  10  |    ⭕️    |
|  기본  |         실거래가 검색, 결과(동별 처리)          |  20  |    ⭕️    |
|  기본  |       실거래가 검색, 결과(아파트별 처리)        |  20  |    ⭕️    |
|  기본  |        회원관리(등록, 수정, 조회, 탈퇴)         |  10  |    ⭕️    |
|  기본  |                 로그인/로그아웃                 |  5   |    ⭕️    |
|  추가  |          관심지역 동네 업종 정보 조회           |  5   |    ⭕️    |
|  추가  |           관심지역 대기오염 정보 조회           |  5   |    ⭕️    |
|  심화  | 공지사항 관리(등록,수정,삭제,목록조회,상세조회) |  15  |    ⭕️    |

# 💡 기능 구현

### 🔍 회원 정보 데이터 관리

- 회원 등록 : id, pw, name, address, phone_num 컬럼 기준의 데이터 생성

- 로그인 : id, pw 기반의 로그인

- 회원정보 조회 : 로그인한 사용자의 id, pw, name, address, phone_num 출력

- 회원정보 수정 : id, pw, name, address, phone_num 컬럼 기준의 데이터 수정

- 회원정보 삭제 : 로그인한 사용자의 사용자 정보 삭제

### 🔍 House Deal 데이터 관리

- Hosue Deal 등록 : 시/도, 구/군, 동이름, 아파트 이름, 가격 컬럼 기준의 데이터 생성

- 동 이름으로 검색 : 동이름 기준의 아파트 거래 정보 데이터 출력

- 아파트 이름으로 검색 : 아파트 이름 기준의 아파트 거래 정보 데이터 출력

- 모든 거래 정보 출력 : 전체 HouseDeal 데이터 출력

### 🔍 관심지역 데이터 관리

- 관심지역 등록 : id, 시/도, 구/군 컬럼 기준의 데이터 생성

- 관심지역 삭제 : id, 지역정보 입력 시 (id, 지역정보)에 해당하는 데이터 삭제

- 회원 아이디 기준으로 검색 : id 입력 시 해당 id에 해당하는 관심지역 데이터를 출력

- 전체 관심지역 출력 : 모든 id에 저장된 관심지역 데이터를 출력

---

# 💡 동작 화면

## 🔍 메뉴 화면

![ezgif.com-gif-maker__2_](/uploads/3a3c72a8d18f261e1d27599692c22d96/ezgif.com-gif-maker__2_.gif)

</br>

## 🔍 회원 정보 데이터 관리

### 회원 등록

<img src="res/1_1_user_register.png" width="60%">

</br>

### 회원정보 수정

<img src="res/1_2_user_modify.png" width="60%">

<br>

### 회원 삭제

<img src="res/1_3_user_delete.png" width="60%">

</br>

### 회원 아이디로 검색

<img src="res/1_4_user_selectId.png" width="60%">

<br>

### 모든 회원정보 출력

<img src="res/1_5_user_selectAll.png" width="60%">

## 🔍 House Deal 데이터 관리

### 동 이름으로 검색

![ezgif.com-gif-maker__3_](/uploads/b61975bc4644bae89ed7d124d8590669/ezgif.com-gif-maker__3_.gif)

### 아파트 이름으로 검색

<img src="res/2_3_apt_selectApt.png" width="60%">

### 모든 거래 정보 출력

<img src="res/2_4_apt_selectAll.png" width="60%">

## 🔍 관심지역 데이터 관리

### 관심지역 등록

<img src="res/3_1_interest_register.png" width="60%">

### 관심지역 삭제

<img src="res/3_2_interest_delete.png" width="60%">

### 회원 아이디 기준으로 검색

<img src="res/3_3_interest_selectId.png" width="60%">

### 전체 관심지역 출력

<img src="res/3_4_interest_selectAll.png" width="60%">

## 🔍 주변 상권정보 데이터 관리

### 상권정보 등록

<img src="res/4_1_sales_register.png" width="60%">

### 상권 이름으로 검색

<img src="res/4_2_sales_selectName.png" width="60%">

### 군/구 기준으로 검색

<img src="res/4_3_sales_selectGu.png" width="60%">

### 전체 상권 정보 출력

<img src="res/4_4_sales_selectAll.png" width="60%">

## 🔍 주변 환경점검 데이터 관리

### 환경정보 등록

<img src="res/5_1_env_register.png" width="60%">

### 지역명 기준으로 검색

<img src="res/5_2_env_selectCity.png" width="60%">

### 전체 환경점검 정보 출력

<img src="res/5_3_env_selectAll.png" width="60%">

## 🔍 코로나 선별진료소 데이터 관리

### 선별진료소 등록

<img src="res/6_1_corona_register.png" width="60%">

### 선별진료소 이름으로 검색

<img src="res/6_2_corona_selectName.png" width="60%">

### 군/구 기준으로 검색

<img src="res/6_3_corona_selectGu.png" width="60%">

### 전체 선별진료소 정보 출력

<img src="res/6_4_corona_selectAll.png" width="60%">

## 🔍 병원정보 데이터 관리

### 병원 등록

<img src="res/7_1_hos_register.png" width="60%">

### 군/구 기준으로 검색

<img src="res/7_2_hos_selectGu.png" width="60%"/>

### 병원 이름으로 검색

<img src="res/7_3_hos_selectName.png" width="60%">

### 모든 병원 정보 출력

<img src="res/7_4_hos_selectAll.png" width="60%">

---

## 👀 느낀점 및 소감

**🧑김경준**

**[느낀점]**
이전 프론트엔드 관통처럼 단순하게 로컬에 저장된 파일을 가지고 데이터를 다루는 것이 아닌 실제 DB에 연동해서 사용해보니 실제로 백엔드를 개발하는 기분이 들었다. 그리고 첫번째 관통 프로젝트 당시에는 DAO, DTO의 개념이 헷갈려서 많이 헤맸지만, 자바 이론을 다시 공부하고, DB를 배운 이후에 구현해 보니 이전보다 훨씬 성장했다는 것을 느낄 수 있었다. 그리고 처음으로 추가기능 및 심화기능을 전부 구현한 프로젝트여서 뿌듯하다.

**[배운점]**
MySQL 사용법, 요구사항 분석 및 DB 모델링, DB 데이터 연동을 위한 DAO/DTO 클래스 구현, DDL 및 FK 제약사항

**[아쉬운 점]**
주어진 자료가 다양했지만, 데이터를 다루는 것이 미숙하여 테이블 내에 중복되는 데이터도 많고, 부족한 설계를 한 것 같다. 그리고 테이블을 자유자재로 다루지 못해서 단순 select, insert 기능들 위주로 구현하게 된 것 같다. 이후에 다시 DB 설계를 할 때에는 처음부터 더욱 제대로 설계해서 깔끔한 테이블을 만들고, 복잡한 기능구현도 시도해봐야겠다.

---

**🧑이정수**

**[느낀점]**
요구사항에 맞는 DB를 설계하는 것부터, DB 데이터 연동을 위한 DAO, DTO 클래스를 구현해보니 개념으로만 알고 있던 지식들이 확실히 정립되어 가는 것 같아 좋았다. 완벽하진 않지만 추가, 심화 기능을 완수한 점이 매우매우 기쁘다! 이후 프론트엔드, 백엔드와 DB를 연결할 날이 기대된다..

**[배운점]**
요구사항 분석, DB 설계, JDBC를 이용한 DB 데이터 연동, DAO, DTO 클래스 구현 등을 배울 수 있었다.

**[아쉬운점]**
처음에 요구사항을 적합한 DB를 설계하는 과정이 오래 걸렸고 이를 구현하는 것 또한 마냥 쉽지만은 않았다. 요구사항에 최적화된, 좋은 효율성의 DB를 구축하지 못했다는 점이 아쉽고 이후 이 부분을 좀더 개선하고 싶다.
# BackEnd_Playground
