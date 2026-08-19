**13.25 병렬 프라미스**
Promise.all()이 프라미스의 병렬 실행을 담당한다. Promise.all()은 프라미스 객체의 ㅂ ㅐ열을 받고 프라미스를 반환한다.
입력 프라미스 중 하나라도 거부되면 반환된 프라미스 역시 거부된다. 입력 프라미스가 모두 이행되면 전체 프라미스는 각 입력 프라미스 값으로 이루어진 배열로 이행된다.

**Promise  생성**
이전에는 프라미스 기반 함수들에 대해 알아봤다면, 직접 프라ㅡ미스를 반환하는 API를 만드는 법이다.

1. 다른 프라미스에 기반한 프라미스
프라미스를 이미  반환하는 함수가 있다면 이를 기초로 프라미스를 반환하는 함수를 만들  수 잇다. 
```
function getJson(url){
  return fetch(url).then(response => response.json());
}
```
2. 처음부터 만드는 프라미스
이런 경우에는 Promise() 생성자를 사용해서 완전히 제어할 수 있는 새 프라미스 객체를 생성하면 된다.
Promise() 생성자를 호출하면서 인자로 함수를 전달한다.
이 함수는 매개변수 두 개를 받으며 솬습적으로 resolve와 reject라는 이름을 쓴다.

이 다음은 async/await 에 대한 설명이 있어 15장으로 다시 넘어감


#### 15.11 네트워크

이 절에서는 3가지 네트워크 API를 설명한다.
1. Promise 기반 API를 사용해 HTTP/HTTPS 요청을 보내는 fetch() 메서드
- GET 요청을 단순하면서도 포괄적인 기능으로 바꾸는 동시에 HTTP로 할 수 있는 거의 모든 것을 지원한다.
2. 서버 전송 이벤트(SSE)
- 클라이언트가 원할 때마다 데이터를 전송할 수 있도록 웹 서버가 네트워크 연결을 열어두는 HTTP'롱 폴링' 기법의 이벤트 기반 인터페이스이다.
3. 웹소켓은
- HTTP는 아니지만 HTTP와 함께 사용하도록  만들어진 네트워크 프로토콜이다. 웹소켓은 클라이언트와 서버가 TCP 네트워크 소켓과 비슷한 방법으로 메시지를 주고받을 수 있는 비동기 메시지 전송 API이다.

**15.11.1 fetch**
기본적인 HTTP 요청에서 fetch()는 3단계로 동작한다.**
**1. 콘텐츠를 가져올 URL을 전달하면서 fetch() 호출
2. HTTP 응답이 도착하기 시작하면 1단계에서 비동기적으로 반환한 응답 객체를 가져오고, 응답 객체의 메서드를 호출해 응답 바디를 가져온다.
3. 2단계에서 비동기적으로 반환한 바디 객체를 사용해 이후 필요한 일을 한다.**

**fetch() API는 완전히 프라미스 기반이고, 비동기 단계가 두 단계 있으므로 fetch()를 사용할 때는 일반적으로 then()을 두 번 호출하거나 await 표현식을 두 번 쓴다.****
```
fetch ("/api/users/current")            // HTTP GET 요청을 보냄
  .then(response => response.Json())    // 바디를 JSON으로 파싱
  .then(currentUser => {                // 파싱된 객체를 사
    displayUserlnfo(currentUser);
});
```
서버에서 JSON 객체가 아닌 plain text(평범한 문자열)를 반환한다고 가정하면, 다음과 같은 형태로 사용된다.
```
async function isServiceReady() {
  1et response = awaitfetch("/api/5ervlce/status");
  1et body = await response.text();
  return body === "ready";
}
```

**요청 헤더 설정**
fetch() 요청을 보내면서 헤더를 설정해야 할 때도 있다. 예를 들어 자격 증명을 요구하는 API에 요청을 보낼 때는 Authorization 헤더에 자격 증명을 담아 보내야 한다.
이럴 떄는 fetch()에 두 번째 인자를 사용한다.
첫 번째 인자는 url을 지정하는 문자열 또는 URL 객체이며, **두 번째 인자는 요청  헤더를 포함해 추가 옵션을 지정하는 객체**이다.
```
let authHeaders = new Headers();
// HTrPS 연결이 아니라면 기본 인증을 쓰면 안 됩니다.
authHeaders.set("Authorization", ‘Basic${btoa('${username):${password}“)}');
fetch("/api/users/", { headers: authHeaders })
  .then()
  ...
```

fetch()의 두 번째 인자에는 다양한 옵션을 쓸 수 있으며, 필요할 때 검색해서 쓰셈

587 페이지의 "응답 바디 분석" 부터 계속
















