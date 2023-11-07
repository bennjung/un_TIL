# <I>'502 Bad Gateway'</i> 는 무슨 오류일까?

### 0. initial 
<p> 들어가기 앞서, 한번쯤은 502 Bad Gateway라는 오류를  한번쯤은 본적이 있을것이다. 

<p> 이 오류는 서버에 단시간에 트래픽이 몰리는 경우 발생한다, 즉 일종의 http error response 인것이다. 

<p> 그렇다면 앞에 '502'는 무엇이고, 'Bad gateway'는 무엇을 뜻할까?

### 1. analyze

<p> http에서는 client가 request를 server로 보내게 되면, server는 그에 맞는 response를 client로 돌려준다. 

<p> 이 respose에는"status code" 라는 내용을 담겨져 있다.

<p> status code는 request를 받은 서버의 상태를 알려주는 역할을 한다.

<p> 아래와 같이 status code는 크게 5가지로 나눌수있다 

#### status codes 
- Informatial[100 ~ 199] : 현재 request 처리"중"인 상황 
- Successful[200 ~ 299] : request 수신, 승인
- Redirection[300 ~ 399] : request를 완료하기 위해 추가적인 행동을 요구
- Client error[400 ~ 499] : request에 문법 오류 혹은 파라미터 누락
- Server error[500 ~ 599]  : server에 오류가 있거나, request의 처리를 불가능한 상황 

> Client · Server error는 status code와 함께 자세한 에러 상황 설명이 필요

### 3. explain

<p>위에 따라 502는 Server error 범주에 들어간다. 

<p> 그렇다면 502 'Bad Gateway'는 무엇일까?

> <i> "... The server act as a gateway or proxy, received an invalid response from an inbound server it accessed while attempting to fulfill the request." 
<br>https://www.rfc-editor.org/rfc/rfc9110#section-15.6.3-1 </i>

<p>직역하자면 request를 처리하는 과정에서 <i>inbound</i> 서버로부터 잘못된 응답을 받았다는 상태를 말해준다. 

<p> 여기서 <i>inbound</i> 서버는 내부 서버로 접근 하기위해서 검문소 역할을 하는 "방화벽" 이다. 
<p> 즉 <i>inbound</i> 서버가 내부 서버 프로세스들과 통신하기 때문에 잘못된 응답을 받았다고 client에게 알려주는것이다. 

<p> 이렇게 502 Bad Gateway 생기는 상황은 3가지로 나뉜다.

1. 한꺼번에 많은 request가 서버로 들어옴(서버 과부화)
2. 만료된 브라우저 캐시
3. 방화벽에서 ip차단 

<p> 대다수 1번-서버 과부화로 인해 웹 문서를 서버에서 찾을수가 없는것이다. 

### 4. solve?

<p> 502 Bad Gateway를 해결하는 방법은... <br>
1. 페이지 새로고침 <br>
2. 브라우저·Local Dns 캐시 삭제 <br>
3. 다른 브라우저 or 방해금지 모드 사용<br>

이외에 다른 방법도 있지만 2,3번 상황은 드물기 때문에 실질적으로 서버가 다시 정상화 되기까지 기다릴수밖에 없다.

### 5. annotation
<p> 이렇게 502 Bad Gateway에 대한 간략한(?) 설명을 마치겠다. 
<p> 다만 트래픽이 몰렸을때 서버가 어떻게 처리하고 장애를 어떻게 정상화 하는지가 궁금하다.
