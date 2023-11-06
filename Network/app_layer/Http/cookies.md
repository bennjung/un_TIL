<h1>웹 사이트는 왜 쿠키를 사용하는가?</h1>

>웹 사이트 == <b> stateless </b>

<p> 사용자마다 페이지를 다르게 보여줄수있는 방법?

<p> 그전에, 웹서버는 사용자(클라이언트)들을 구별해야함

## 클라이언트 구분하기

### 0. Using IP?
- IP주소로 <b>클라이언트(사용자)</b>를 구분하기는 힘듦.</p>
- IP주소는 결국 논리적인 주소; 패킷을 주고 받는 최종 호스트 주소임


### 1. Using Login?
<p> 로그인으로 클라이언트 구분 <br>
<ol>
    <li>클라이언트의 웹서버로 접속 request -> <br>웹서버의 Unauthorized response[401]</li>
    <li>입력받은 클라이언트 ID,PW가 HTTP 헤더에 암호화되어 request </li>
    <li>웹서버의 Ok response[200]</li>
</ol>
<p> 모든 웹사이트 사용 조건이 로그인을 요구한다면? 
<br> <b>-> 끔찍한 사용자 경험</b>

### 2. Using Fat Url?
<p>서버가 유저에게 일회용 고유 ID 값 할당 <br> 할당된 ID값을 url(하이퍼링크)끝에 추가해서 유저 구분

<ol>
<li>Fat url(with private data) 공유 불가
<li>사용중 Fat url 이탈 가능성
<li>서버 부하 증가
<li>캐시 불가(Why?)

</ol>

### 3. Using Cookie?
<p> Fat url 방식과 유사하게 동작 <br> 
<ol>
<li> 최초 서버가 신규 방문자(클라이언트)에게 쿠키 할당 [set-cookie]
<li> 클라이언트는 할당받은 쿠키와 함께 다시 request
<li> 쿠키의 종류에 따라 사용기한이 다름<br>
=> 클라이언트가 쿠키를 통해 자기 자신 구별되게 만듦.
</ol>

<b> 쿠키의 종류 </b>
<li>Session cookie : 브라우저가 종료되면 할당받은 쿠키의 사용불가. 

<li> Persistent cookie : 브라우저가 종료되어도 할당받은 쿠키가 디스크에 저장되어 재사용 가능. 쿠키 만료 기한은 존재

단 쿠키는 최초 할당한 서버로만 쿠키 헤더를 추가해서 request를 보냄.

<b>쿠키 or 캐시 in sever</b>

<li> set-cookie 해더 캐싱 제한 ; set-cookie 캐싱해서 response를 하게 되면 여러 사용자에게 동일한 쿠키를 할당할수있기 때문
<li> cookie 해더 + request에 대한 response 문서 캐싱 제한 ; 개인정보 이슈
<p>
<p> 쿠키를 할당함으로써 안전하고 지속적이게 사용자 맞춤형 페이지를 서버에서 제공할수있음
        
    


