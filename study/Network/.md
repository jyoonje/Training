`fetch()`의 첫 번째 비동기 결과인 `response`는 HTTP 응답 전체에 대한 정보를 담은 `Response` 객체이고, 그 안에있는 응답 바디에 접근할 수 있는 `body`가 포함되어 있다.

**HTTP 요청과 응답의 전체 구조**
```
HTTP 요청
┌─────────────────────────┐
│ Request Line            │  ← GET /api/users HTTP/1.1
├─────────────────────────┤
│ Request Headers         │  ← Host, Cookie, Content-Type ...
├─────────────────────────┤
│                         │
│ Request Body            │  ← POST/PUT 등에 데이터가 들어감
│                         │
└─────────────────────────┘

             ↓↓↓

             서버

             ↓↓↓

HTTP 응답
┌─────────────────────────┐
│ Status Line             │  ← HTTP/1.1 200 OK
├─────────────────────────┤
│ Response Headers        │  ← Content-Type, Set-Cookie ...
├─────────────────────────┤
│                         │
│ Response Body           │  ← 실제 데이터
│                         │
└─────────────────────────┘
```


**HTTP 요청**

예를ㄷ 들어 브라우저에서
```
fetch("/api/users");
```
요청을 보냈다고 가정하면

기본적으로 fetch()는 GET 요청을 보낸다.

개념적으로 ㅅ ㅓ버에는 이런 요청이 도착함
```
GET /api/users HTTP/1.1
Host: example.com
Accept: */*
Cookie: sessionId=abc123
```

해당 요청은 크게 세 부분으로 나뉜다.

```
GET /api/users HTTP/1.1
↑
Request Line

Host: example.com
Accept: */*
Cookie: sessionId=abc123
↑
Request Headers

Request Body
↑
GET에서는 일반적으로 없음
```

**Request Line**
HTTP 요청의 첫 번째 줄이다.
구조: HTTP 메서드 + 요청 대상 + HTTP 버전

**Request Header**
헤더는 요청에 대한 부가 정보/메타데이터다.
```
Content-Type: application/json
Authorization: Bearer eyJ...
Accept: application/json
Cookie: sessionId=abc123
```
`Content-Type`: 요청 Body의 데이터 형식을 알려줌

**Request Body**
Content-Type에서 명시된 타입의 데이터가 들어있다. 여기서는 JSON 데이터이다
```
{
    "name": "홍길동",
    "age": 30
}
```

JavaScript의 Fetch() API에서는
```
fetch("/api/users", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({
        name: "홍길동",
        age: 30
    })
});
```
이런식으로 보낼 수 있다.

JavaScript 객체 -> JSON으로 변환(`JSON.stringify`) -> JSON 문자열 -> HTTP Request Body -> Spring Boot(서버)

**HTTP 응답**
서버가 응답한다.
```
HTTP/1.1 200 OK
Content-Type: application/json
Content-Length: 58

[
    {
        "id": 1,
        "name": "홍길동"
    }
]
```

응답도 크게 세 가지 부분으로 나뉜다.

**Status Line**
```
HTTP/1.1 200 OK
```
여기서 중요한 것은  HTTP 상태 코드이다.
- 2xx: 성공, 4xx: 클라이언트 측 문제, 5xx: 서버 측 문제 

**Response Header**
**응답에 대한 메타데이터이다.**

대표적으로
```
Content-Type: application/json
Content-Length: 1234
Set-Cookie: sessionId=abc123
Cache-Control: no-cache
Location: /api/users/10
```
`Content-Type`: Response Body의 데이터 형식을 알려줌(ex: `Content-Type: application/json`, `Content-Type: text/html`, `Content-Type: text/plain`...)


**Response Body**
**실제 데이터이다.**

Request와 마찬가지로 Content-Type에 명시된 형식의 실제 데이터가 들어있다.
```
[
    {
        "id": 1,
        "name": "홍길동"
    },
    {
        "id": 2,
        "name": "김철수"
    }
]
```



fetch()의 response 객체를 좀 더 알아보자면,
```
const response = await fetch("/api/users");
```
위의  fetch()가 반환하는 Promise가 이행되면 response에 들어오는 것은
**HTTP 응답의 여러 정보를 다루기 위한 Response 객체로,**

개념적으로 다음과 같은  구조이다.
```
response
│
├── status       → 200
├── ok           → true
├── headers      → Response Headers
├── body         → Response Body
└── ...
```
그리고 위의 구조에 따라서 모두 조회할 수 있다.
`response.status` -> HTTP 상태 코드(ex: `response.ok`)
`response.headers` -> Response Headers
`response.body` -> Response Body를 읽을 수 있는 스트림



**여기서 중요한 부분**
서버가: 
```
{
    "name": "홍길동",
    "age": 30
}
```
을 Body로 보내도 response 자체가 JSON 객체가 되는 것은 아니다.
`const response = await fetch("/api/user");`
하면, 
`response -> Response 객체` 이다.

그리고 Body를 JSON으로 읽으려면: 
`const user = await response.json();`  // user 정보를 GET 요청했다고 가정
의 과정을 이행해야 한다.

그림으로 요약하자면,,
```
HTTP 응답
    │
    ├── Status
    ├── Headers
    │
    └── Body
          ↓
     response.json()
          ↓
     JSON 파싱
          ↓
     JavaScript 객체
```
즉 response.json() 은 사실상 다음과 같은 의미이다: "이 Response 객체가 가지고 있는 Body를 읽어서 JSON으로 해석해줘."
-> 결론: response.body.json()이 아닌 response.json()을 쓰는 이유는, response 객체의 json() 함수가 "Response Body를 역직렬화 하도록 구현된 함수" 이기 때문이다....



















