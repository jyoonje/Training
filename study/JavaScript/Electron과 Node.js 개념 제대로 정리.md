핵심부터 말하면:
 ** Electron은 Chromium과 Node.js를 묶어서 JavaScript로 데스크톱 애플리케이션을 만들 수 있게 해주는 프레임 워크이며,
  Node.js는 JavaScript 실행 환경(Runtime)이다.**

1. Node.js
자바스크립트를 브라우저 밖에서도 실행할 수 있게 해주는 JavaScript Runtime이다.
원래 자바스크립트는 주로 브라우저에서 실행된다:
```
Chrome
┌─────────────────────────┐
│ JavaScript              │
│                         │
│ document                │
│ window                  │
│ DOM                     │
│ fetch()                 │
└─────────────────────────┘
```

Node.js는 자바스크립트를 OS 위에서 실행할 수 있게 한다.
```
Windows
   │
Node.js
   │
JavaScript
   │
   ├─ 파일 읽기/쓰기
   ├─ 네트워크 통신
   ├─ 프로세스 실행
   └─ OS 기능 접근
```

그래서 Node.js를 이용해 웹 서버를 만들다보니, Node.js == 백엔드 라는 인식이 생겼는데, 정확히는 틀렸다.


2. Electron
Electron은 크롬 + Node.js라고 생각하면 편하다.
```
┌──────────── Electron Application ────────────┐
│                                             │
│              Electron                       │
│                                             │
│   ┌─────────────────┐  ┌─────────────────┐  │
│   │    Chromium     │  │     Node.js     │  │
│   │                 │  │                 │  │
│   │ HTML            │  │ File System     │  │
│   │ CSS             │  │ Network         │  │
│   │ JavaScript      │  │ OS API          │  │
│   │ DOM             │  │ Process         │  │
│   └─────────────────┘  └─────────────────┘  │
│                                             │
└─────────────────────────────────────────────┘
                    │
                 Windows
```

실제로 내부적으로 크롬이 들어있다.

일렉트론에서 중요한 개념이 Main Process와 Renderer Process이다.
```
Electron Application
│
├── Main Process
│      │
│      └── Node.js 환경
│
│          파일 시스템
│          OS 기능
│          창 생성
│          네트워크
│          알림
│          트레이 아이콘
│          ...
│
└── Renderer Process
       │
       └── Chromium 환경

           HTML
           CSS
           JavaScript
           DOM
           화면 렌더링
```

```
JavaScript
   │
   ├─ Browser
   │    └─ 웹 페이지의 JS 실행
   │
   └─ Node.js
        └─ 브라우저 밖에서 JS 실행


Electron
   │
   ├─ Chromium
   │    └─ UI / 웹 화면
   │
   └─ Node.js
        └─ OS / 파일 / 네트워크 등의 기능
```

물론 브라우저에서도 네트워크 통신이 가능하다.
```
fetch('https://api.example.com/users');

const ws = new WebSocket('wss://example.com/socket');
```
같은 통신이 가능하지만, 브라우저는 보안 때문에 허용된 고수준 네트워크 API만 가능하다.

예를들어 fetch()를 호출한다고 해서, JavaScript 개발자가 직접 TCP 소켓을 만들지는 못한다.
개발자는 HTTP 요청을 요구할 뿐, 그 아래 TCP/TLS 등 처리는 브라우저가 담당한다.

Node.js에서는 더 낮은 수준까지 접근할 수 있다.
TCP 소켓을 다룰 수도 잇고, TLS 연결을 직접 만들 수도 있다.

앞에서 계속 말했던 **런타임** (ex: Node.js는 JavaScript Runtime이다.) 의 의미는,
"내가 작성한 프로그램을 실제로 실행시켜주는 환경" 이다.

일반 JS는 브라우저가 런타임이며, Node.js는 브라우저 밖에서 실행하는,  OS가 런타임이 된다.
정리하면,
```
JavaScript → 프로그래밍 언어
Node.js → JavaScript를 브라우저 밖에서 실행하는 런타임
React → JavaScript 기반 UI 라이브러리
Express → Node.js에서 웹 서버를 만들기 위한 프레임워크
Electron → Chromium + Node.js를 이용해 데스크톱 앱을 만드는 프레임워크
Chrome → 웹 브라우저이면서 JavaScript가 실행될 수 있는 환경
```

또한, Electron 프레임워크에서 Node.js를 사용하는 이유는 
Electron은 단순한 웹 페이지가 아니라 데스크톱 애플리케이션을 만드는 것이기 때문에, 브라우저의 보안 제약을 넘어 클라이언트의 OS 기능을 사용하기 위해 Node.js를 함께 사용하는 것이다.













