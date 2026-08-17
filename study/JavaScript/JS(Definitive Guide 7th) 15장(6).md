순회(traaversal) API는 문서를 Element 객체의 트리로 취급하며 Text 노드는 무시한다. 순회 API에는 메서드가 없다.
주어진 요소의 부모, 자식, 형제를 참조하는 Element 객체의 프로퍼티일 뿐이다.

`parentNode`: 요소의 부모를 참조한다.
`children`: 이 노드 리스트는 자식인 요소를 포함하지만, 요소가 자식인 Text 노드와 COmment 노드는 제외한다.
`childElementCount`:  자식 요소 개수 ( == children.length)
`firstElemetnChile`, `lastElementChild`: 요소의 자식 충 첫 번째와 마지막을 각각 참조
이외에도 여러가지가 있다.
이들 프로퍼티를  활용해 문서의 첫 번째 자식 요소의 두 번째 자식요소도 찾을 수 있다.
`document.children[0].children[1]`

다음 함수는 노드 기반 순회 API를 사용해 문서 또는 요소에 포함된 텍스트를 모두 반환한다.

### 15.3.3 속성
HTML 요소는 태그 이름, 속성이라 불리는 이름-값 쌍 세트로 구성된다. 예를 들어 하이퍼링크를 정의하는 <a> 요소의 href 속성 값은 링크의 대상이다.

Element 클래스에는 속성을 검색, 설정, 확인, 제거하는 getAttribute(), setAttribute(), hasAttribute(), removeAttribute() 메서드가 있지만,
표준 HTML 요소의 표준 손성은 모두 그 요소를 나타내는 HTMLElement 객체의 프로퍼티로 존재하며, 다음과 같이 호출한다.
```
<input id="username" type="text" value="윤제">
let psname = document.getElementById("username");

console.log(psname.type);  // "text"
console.log(psname.value); // "윤제"
```

요소에는 id, title, lang, dir과 같이 속성을 나타내는 프로퍼티 뿐 아니라 onclick 같은 이벤트 핸들러 프로퍼티도 있다.(하지만 이벤트 등록은 addEventListener()를 권장한다)
일부 요소에는 그 요소 전용 속성이 존재한다. 예를 들어 이미지의 URL은 <img> 요소를 나타내는 src 프로퍼티에서 얻을 수 있다.

document 객체의 `getElementBy~` 메서드와 `querySelector` 메서드의 차이:
둘 다 DOM에서 HTML 요소를 찾는 방법이지만 차이점이 있다.
1. getElementById(): ID로 찾는다. const box = document.getElementById("box");
2. getElementByTagName(): 태그 이름으로 찾는다. const headings = document.getElementsByTagName("h1");
3. document.querySelectorAll("#box");와 같이 querySelector()은 CSS 선택자 문법으로 찾을 수 있다.

예를 들어 ID만 찾는다면 getElementById()가 명확하지만,  복잡한 조건이 필요하다면 CSS 선택자 하나로 찾을 수 있기 떄문에 querySelector()은 아주 유용하다.
또한 querySelector() 메서드는 document 객체 뿐 아니라 Element에서도 호출할 수 있다.

HTML 요소의 class 속성의 값은 요소에 적용ㄷ되는 CSS 클래스를 공백으로 구분한 리스트이며 요소의 스타일을 결정한다.

**데이터셋 속성** 
이따금 HTML 요소에 추가 정보를 첨부하면 편리할 때가 있다.
HTML은 이름이 소문자이고 data-전치사로 시작하는 속성은 모두 유효한 것으로 간주하며, 어떤 ㅁ ㅗㄱ적으로든 사용할 수 있다. 문서 유효성을 해치지 않고 데이터를 첨부하는 표준 방법이다.
Element 객체의 dataset 프로퍼티에넌 data- 속성에서 전치사를 제거한 프로퍼티가 존재한다.  속성 이름에 하이픈이 들어가 있으면 카멜 케이스로 바뀐다. 예시는 다음과 같다.
```
<h2 id="title'' data-5ection-number="16.1">Attributes</h2>
그러면 다음 코드로 섹션 번호에 접근할 수 있따.
let number = document.querySelector("#title").dataset.sectionNumber;
```

<img width="784" height="491" alt="image" src="https://github.com/user-attachments/assets/da42754d-b100-4bf3-aeac-1ff183315958" />

**HTML의 요소 콘텐츠**
요소의 innerHTML 프로퍼티는 요소 콘텐츠를 마크업 문자열로 반환한다. 이 프로퍼티의 값을 설정하면 웹 브라우저 파서를 호출해서 요소의 현재 콘텐츠를 새로운 문자열을 분석한 값으로 교체한다.
콘솔에서 다음 명령을 내리면,
document.body.innerHTML = "<h1>Oops</h1>";
웹 페이지 전체가 사라지고 Oops 라는 제목 하나만 보일 것이다. 웹 브라우저는 HTML 분석에 최적화 되어있으며 innerHTML 설정은 보통 아주 효율적ㅇ이다.
하지만  += 연산자로 innerHTML 프로퍼티에 텍스트를 추가하면 요소 컨텐츠를 문자열로 변환하는 직렬화 단계, 새로운 문자열을 요소 콘텐츠로 변환하는 분석 단계를 모두 거쳐야 하므로 효율적이지 않다.

새로운 요소를 생성할 때는 Document 클래스의 createElement() 메서드를, 요소에 문자열이나 다른 요소를 삽입할 때는 appendd(), prepend() 메서드를 사용한다.

요소는 문서의 한 곳에만 존재할 수 있다. 이미 문서에 존재하는 요소를 새로운 위치에 삽입하면 그 위치로 이동할 뿐 복사되지 않는다.
`greetings.before(paragraph); //이 요소 다음에 문단을 삽입했었지만 이제는 이 요소 앞으로 이동했다.`

before(), after() 같은 DOM 삽입 메서드로는 복사할 수 없지만, cloneNode() 메서드로 복사할 수 있다. 이나로 true를 전달하면 콘텐츠 전체가 함께 복사된다.
`greetings.after(paragraph.cloneNode(true)); // 문단을 복사해서 greetings 다음에 삽입한다.`

위와 같은 DOM API 같은 것을 전부 외우는 것은 불필요하고, **DOM을 자바스크립트 객체를 통해 조작한다**는 원리를  이해하는 것이 중요하다.
API는 필요할 때 찾아쓰면되고, "Element의 메서드를 외우는 것"보다 "이 요소를 다른 요소로 교체해야 한다" 같은 생각이 들었을 때 문서를 찾아보면 된다.

**Window의 load와 DOMContentLoaded의 차이**
둘 다 문서가 로딩되는 과정에서 발생하는 이벤트이다.

`DOMContentLoaded`
HTML 문서를 파싱하고 DOM을 완성하면 발생

`load`
문서와 그에 포함된 리소스까지 모두 로딩이  끝났을 때 발생

대략
HTML 다운로드 -> HTML 파싱 -> <script> 발견 -> JS 실행 -> DOM 생성 -> DOMContentLoadaed 발생 -> 이미지, 폰트 등의 리소스 로딩 -> load 발생

`defer` 키워드는 HTML 파싱을 막지 않기 때문에 DOM 생성과 DOM 생성 이후, DOMContentLoaded가 발생하기 전에 실행된다.
`async` 키워드는 <script>가 발견되면 바로 실행되지만, HTML 파싱 과정 중간에 실행될 수도 있고, 경우에 따라 예측하기 힘들다.

offset: "기준점에서 얼마나 떨어져 있는가"를 나타내는 

15장은 API 설명이 너무 많아서 중단, ㅊ처음부터 읽는 중.

### 13장 비동기 자바스크립트

콜백 함수: 특정 함수에 매개변수로 전달되는 함수로, 호출 함수 내에서 실행되는 매개변수 함수이다. 주로 비동기 함수에 인자로 전달되며, 비동기 응답이 도착했을 시 해당 응답을 기반으로 실행되는 경우가 많다.

프라미스: 비동기 프로그래밍을 단순홯라도ㅓ록 설계된 코어 기능으로, 비동기 작업의 결과를 나타내는 객체이다. 프라미스의 ㄱ ㅏㅄ을 동기적으로 가져올 수는 없으며, 값이 준비됐을 때 콜백 함ㅁ수를 호출하도록 프라미스에 요청할 수 있다..

**13.2.1 프라미스 사용**
자바스크립트 코어에 프라미스가 포함되면서 웹 브라우저에서 프라미스 기반 API를 지원하기 시작했다.

예시를 들면 다음과 같다.
- 기본 콜백 함수 방식
```
getCurrentVersionNumber((err, version) => {
    if (err) {
        console.error(err);
        return;
    }

    console.log(version);
});

console.log("다음 코드");
```
HTTP 요청이 끝나기 전에 getCurrentVersionNumber()가 종료된다.
따라서, 다음과 같이
const version = getCurrentVersionNumber();
console.log(version); // 실제 버전이 아님

함수를 호출한 외부에서 호출 값을 다룰 수 없다. 비동기 작업의 결과가 나중에 나오기 때문이다.

Promise는 이 문제를 해결하기 위해 나온 객체이다.
| Promise: "지금은 결과가 없지만, 나중에 비동기 작업의 결과를 제공하겠다"는 약속을 나타내는 객체

Promise는 결과 그 자체가 아니다.
코드 `const result = fetch("/api/user");`에서, result는 사용자 데이터가 아니다.
result -> Promise 객체 ->  나중에 HTTP 요청 결과를 준다는 약속

실제 데이터는 나중에 도착한다.
fetch() -> Promise 반환 -> 다음 코드 실행 -> ... -> HTTP 응답 도착 -> Promise 완료 -> 실제 데이터 사용

Promise는 크게 3가지 상태를 가진다: Pending, 성공(Fulfilled), 실패(Rejected)

- Pending: 아직 작업이 끝나지 않은 상태 ex) 아직 HTTP 응답 안옴
- Fulfilled: 비동기 작업이 성공적으로 완료된 상태 ex) HTTP 응답 받아서 데이터 있음ㅁ
- Rejected: 비동기 작업이 실패한 상태 ex) HTTP 요청 실

.then() 으로 결과를 받을 수 있다.
```
fetch("/api/user")
    .then(response => {
        return response.json();
    })
    .then(user => {
        console.log(user);
    });
```
위의 코드에서 fetch("api/user"); 가 Promise를 반환한다. Promise가 성공적으로 완료되면 .then() 구문에 정의된 함수가 실행된다. 즉, 콜백과 연관되어있다.
.then() 구문 뒤에서 .catch() 구문을 작성하며, Promise가 실패 시 실행되는 구문이다.

다음과 같은 코드가 있다. getCurrentVersionNumber() 함수는 Promise를 반환하는 비동기 함수이다.
```
const version = getCurrentVersionNumber();
console.log(version); // 실제 버전이 아님
```
변수 version은 Promise 객체이고, `console.log(version);`을 실행하는 시점에는 Promise의 상태가 무엇이든 간에 "Promise 객체 자체"가 출력된다.
실제 결과 값을 얻고 싶다면 다음과 같이 사용하면 된다.
```
const version = await getCurrentVersionNumber();
console.log(version);
```

콜백 함수가 아닌 PRomise를 사용하는 주요 이유는, 콜백 함수는 함수 외부에서 응답 값과 같은 변수를 사용할 수 없ㄷ다는 ㄱ것이다.
```
getCurrentVersionNumber((error, version) => {
    console.log(version);
});
```
-> version을 함수 외부에서  사용할 수 없다.

Promise를 사용하면  
```
function getCurrentVersionNumber() {
    return new Promise((resolve, reject) => {

        // HTTP 요청

        request.onload = function () {
            if (request.status === 200) {
                resolve(currentVersion);
            } else {
                reject(new Error("요청 실패"));
            }
        };
    });
}

const promise = getCurrentVersionNumber();
```
getCurrentVersionNumber() 함수는 당장 버전을 반환할 수 없은니 Promise를 반환하고, 반환한 Promise를 외부에서 사용할 수 있다.
```
const promise = getCurrentVersionNumber();

promise.then(version => {
    console.log(version);
});

console.log("다음 코드");
```

반환된 promise를 사용해서 version 값을 사용할 수도 있다. **참고로, .then()은  현재 코드를 멈추고 기다리는 것이 아니다.** 이 차이가 동기적 프로그래밍과 promise를 사용한 비동기 프로그래밍의 차이이다. 위의 코드 블락을  실행하면 다음과 ㄱ ㅏㅌ은 순서이다.
```
getCurrentVersionNumber()
        ↓
HTTP 요청 시작
        ↓
Promise 반환
        ↓
then()에 콜백 등록
        ↓
"다음 코드" 실행
        ↓
       ...
   서버 응답 도착
        ↓
then()의 콜백 실행
```
출력 값: 
```
다음 코드
v.1.1.3
```

**Promise는 비동기 작업의 미래 결과를 나타내는 객체이고, async는 이 함수가 Promise를 반환하도록 만드는 키워드 이다. await은 그 Promise의 결과를 받는 지점이다.**

async란 함수 앞에 붙이는 키워드로, 중요한 특징이 하나 있다.
async 함수는 무조건 Promise를 반환하다.
```
function getData() { return "hello"; }
const result = getData();
console.log(result); // hello 출력
```
하지만 async가 붙으면, 
```
async function getData() { return "hello"; }
const result = getData();
console.log(result); // Promise { "hello" } 출력
```
처럼 Promise 객체를 반환한다.
**하지만 async 자체가 비동기 작업을 만드는건 아니다.**
코드 예시를 보면
```
async function hello() {
    return "hello";
}
```
여기에는 HTTP 요청도 없고 ㅅ ㅣ간이 걸리는 작업도 없다. 그런데도 Promise를 반환한다.
즉, async의 직접적인 역할은 "이 함수의 반환값을 Promise로 감싸는 것" 이다.
Promise로 감싸져 있는 반환 값에서 실제 데이터를 얻기 위해 등장한 키워드가 await 이다.

여기서 조심해야 할 점: await은 정말 기다리는 것처럼 보인다. 마치 Promise를 반환하지만, Promise가 필요 없는 동기 함수인 것처럼 보이지만, 중요한 차이가 있다.

await은 async 함수 내부에서 사용한다. 즉, 
```
function main() {
    const version = await getVersion(); // ❌
}
```
와 같이 사용할 수 없으며, main 함수의 function 키워드 앞에 async 키워드가 포함되어야 한다.
await을 사용하기 위해, async가 필요하고, async 함수는 Promise를 반환한다.

**await은 JavaScript 전체를 멈추는 것이 아니다.** await은 현재 실행중인 async 함수의 실행을 잠시 중단한다. await 키워드가 포함된 async 함수를 잠시 멈출 뿐, async 함수를 호출한 코드 외부 블락은 await을 기다리지 않고 실행된다.

**async 함수는 Prmise 객체를 반환하는 함수이지, 이 함수가 비동기 작업을 수행함을 보장하는 키워드가 아니다.** 하지만 개발자는 코드를 분석할 때 promise 객체를 반환하는 코드가 있다면 암묵적으로 비동기 작업을 수행한다는 것을 예측할 수 있다. 

프라미스 객체가 반환된 후에 프라미스를 반환하는 함수 내부의 동작이 이루어지므로 예외 발생 시 캐치할 수 있는 예외 처리가 필요하다. .then()에 전달하는 함수가 대안을 제시한다.
프라미스 긱반 비동기 작업은 정상적으로 완료되면 then()의 첫 번째 인자인 함수에 결과를 전달하고, 예외가 발생하면 두 번째 인자인 함수에 전달한다.

위와 같이 할 수도 있지만 다음과 같이 에러 처리 코드를 만드는 경우가 더 흔하다.
`getJ S얘 ( ' /api/u se r/p rof ile'' ) ‘ then ( displayUse rP rof ile ) . catch ( hand leP rof ileE r ro r ) ;`


13.2.5 병렬 프라미스 부터 계속

















