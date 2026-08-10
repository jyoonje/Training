### Maven Lifecycle: maven이 자바 프로젝트를 빌드하고 배포하기 위해 거치는 표준 작업 순서

예를 들어  개발자가 
```
mvn package
```
명령어를 실행하면 Maven은 package 작업 하나만 하는 것이 아니라 실제로는
```
compile - > test -> package
```
를 순서대로 실행함.

즉, 규정된 앞의 작업들을 전부 수행

---

### Maven Lifecycle
대표적인 3개의 라이프사이클:
```
clean
default
site
```

- default lifecycle의 핵심 단계
```
validate
   ↓
compile
   ↓
test
   ↓
package
   ↓
verify
   ↓
install
   ↓
deploy
```

각각 의미:
| 단계         | 의미                       |
| ---------- | ------------------------ |
| `validate` | 프로젝트 설정이 정상인지 확인         |
| `compile`  | Java 소스 컴파일              |
| `test`     | 테스트 실행                   |
| `package`  | JAR/WAR 생성               |
| `verify`   | 패키지가 정상인지 추가 검증          |
| `install`  | 로컬 Maven Repository에 설치  |
| `deploy`   | 원격 Maven Repository에 업로드 |



### package와 install의 차이
`mvn package`: 
소스코드 -> 빌드 -> target/xxx.war
: 결과물읠 프로젝트의  `target`에 만듦

`mvn install`: 
소스코드 -> 빌드 -> target/xxx.war -> Maven Local Repository
: 결과물을 Maven Repository에도 등록함. 즉 **다른 maven 프로젝트에서도 참조할  있게 로컬 저장소에 저장**

### clean
일반적으로 `mvn clean` 시, `target/` 을 삭제함. -> 즉, 깨끗하게 다시 빌드함.


즉 각각의 모듈을 mvn install하는 과정은 maven/repoistory 경로에 위치시키기 위함이며, 각 모듈이 서로의 패키징된 war 파일의 위치(Local Repository)를 알고 참조할 수 있는 이유는 maven/settins.xml을 확인해보면 된다.
그리고 pom.xml은 어떤 의존성이 필요한지 작성되어있음.

```
settings.xml
    ↓
"Local Repository가 어디인지"

pom.xml
    ↓
"어떤 dependency가 필요한지"

Maven
    ↓
settings.xml을 보고 Repository 위치 확인
    ↓
pom.xml을 보고 dependency 확인
    ↓
Repository에서 dependency 검색
```
