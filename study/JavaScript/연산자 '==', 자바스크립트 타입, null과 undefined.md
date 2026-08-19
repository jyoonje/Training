JavaScript에서 핵심 차이는 **타입 변환을 허용하나**이다.

```
| 연산자   | 의미        | 타입 변환   |
| ----- | --------- | ------- |
| `==`  | 느슨한 동등 비교 | **함**   |
| `===` | 엄격한 동등 비교 | **안 함** |
```

1. `==`: 타입이 다르면 변환해서 비교
```
1 == '1' // true
true == 1 // true
false == 0 // true
```

2. `===` 타입과 값이 모두 같아야 함
```
1 === '1' // /false
          // 1은 number 타입, '1'은 String 타입이기 떄문
```

`==`는 예상하지 못한 타입 변환  때문에 헷갈리는 경우가 많다. 
예를 들어
```
0 == false      // true
"" == false     // true
"0" == false    // true
null == undefined // true
```

null이 undefined랑 같으면 ㅈㄴ짜증나겟지

반면 `===`은 훨씬 직관적이라,
```
0 === false       // false
"" === false      // false
"0" === false     // false
null === undefined // false
```

---

자바스크립트는 Java나 C처럼 변수 선언 시 타입을 명시하지 않지만, 엄연히 타입이 있는 언어이다.

예를 들어, 
```
let a= 10;
let b =  "10";
```
변수 선언할 때는 타입을 쓰지 않지만, 값에는 타입이 존재한다.

```
let a= 10; -> number
let b =  "10";  -> string
```
실제로 확인도 ㄱㄴ
```
type of a; // "number'
```

**JavaScript에는 "변수"가 아니라 "값"에 타입이 있다고 생각하면 편하다**
예를 들어 변수 선언 시 let 뒤에는 타입을 적지 않지만, 실제 값에는 타입이 들어간다.
또한, 초기화된 변수에 다른 타입의 값을 다시 할당할 수도 있다.
```
let x = 10;       // x가 가리키는 값: number
x = "hello";      // x가 가리키는 값: string
x = true;         // x가 가리키는 값: boolean
```

그래서 자바스크립트를 **동적 타입 언어** 라고 한다.

### 그냥 궁금해서 정리하는 null과 undefined

`undefined` = 값이 아직 할당되지 않았거나, 값이 없음을 나타내는 기본값
`null` = 개발자가 "값이 없음"을 명시적으로 넣은 값

1. undefined
변수는 선언되어 있지만 값이 할당되지 않은 경우 대표적으로 undefined가 된다.
```
let a;
console.log(a); // undefined
```
위에서 a는 분명히 선언되어있다.

또한 함수가 아무것도 반환하지 않을 때도 `undefined`가 반환된다.
```
function test() {
}
console.log(test()); // undefined
```

2. null
`null`은 개발자가 "이 변수의 값은 없다" 라고 명시적으로 지정한 것이다.
`let user = null;`
즉, user -> null
라고 개발자가 직접 넣은 것임

예를 들어,
```
let selectedUser = null;
```
이라면, "현재 선택된 사용자가 없다" 라고 해석할 수 있다.

3. 그럼 선언되지 않은 변수는??
다음과 같은 코드가 있다
```
console.log(a); // a는 선언되지 않음
```
그러면 자바스크립트는 `ReferenceError`를  발생시킨다.













