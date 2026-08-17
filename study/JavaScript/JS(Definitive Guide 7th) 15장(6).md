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















