1. MVC란?
MVC는 애플리케이션을 세 가지 역할로 나누는 설계 방식이다.
```
M = Model
V = View
C = Controller
```
각각의 책임을 분리하는 게 핵심이다.
```
사용자 -> Controller -> Model -> View -> 사용자
```

다만 Spring MVC에서는 실제 흐름이 조금 더 복잡하다.

2. Controller
Controller는 HTTP 요청을 받아서 어떤 작업을 수행할 지 결정하는 역할이다.
예를 들어:
```
@Controller
public class MemberController {

    @GetMapping("/members")
    public String members(Model model) {

        List<Member> members = memberService.findMembers();

        model.addAttribute("members", members);

        return "members";
    }
}
```
를 요청하면 COntroller가 해당 요청을 받는다. 그리고 여기서 중요한 점:
```
memberService.findMembers();
```
처럼 컨트롤러가 DB에 직접 접근하는 것이 아니라 Service에게 비즈니스 로직을 위임하는게 일반적이다.

3. Model
Model은 MVC에서 조금 헷갈리는 개념으로, Spring MVC에서는 크게 View에 전달할 데이터를 담는 역할이다.
```
model.addAttribute("members", members);
```
그러면 View에서: 
`members -> [철수, 영희, 민수]`
라는 데이터를 사용할 수 있다. 다만, "Model == DB"는 아니다.
```
DB
 ↓
Repository
 ↓
Service
 ↓
Controller
 ↓
Model
 ↓
View
```
Model은 DB 자체가 아니라 View에 전달되는 데이터/상태를 의미한다고 이해하면 좋다.

4. View
View는 사용자에게 보여줄 화면을 만드는 역할이다.
예를들면 JSP:
`members.jsp`가 View가 될 수 있다.

5. 그런데 Spring MVC에서는 중요한 객체가 하나 더 있다.
Spring MVC 에서는:
**DispatcherServlet**이라는 핵심 컴포넌트가 존재한다.

사용자의 요청이 Controller로 바로 가지 않는다.
```
브라우저
   ↓
HTTP 요청
   ↓
DispatcherServlet
   ↓
Controller
```

6. 실제 요청 흐름
사용자가 `GET/members`를 요청했다고 해보자.
전체적인 흐름은:
```
브라우저
   │
   │ GET /members
   ↓
DispatcherServlet
   │
   │ "이 URL을 처리할 Controller가 누구지?"
   ↓
HandlerMapping
   │
   │ MemberController의 members() 발견
   ↓
MemberController
   │
   │ memberService.findMembers()
   ↓
MemberService
   │
   ↓
MemberRepository
   │
   ↓
DB
```
DB에서 데이터를 가져오면 다시:
```
DB
 ↓
Repository
 ↓
Service
 ↓
Controller
 ↓
Model
 ↓
View
 ↓
DispatcherServlet
 ↓
HTML
 ↓
브라우저
```

그래서 실제 Spring MVC 구조는:
```
                 HTTP 요청
                    ↓
              DispatcherServlet
                    ↓
               Controller
                    ↓
                 Service
                    ↓
               Repository
                    ↓
                    DB
                    ↑
               Repository
                    ↑
                 Service
                    ↑
               Controller
                    ↓
                  Model
                    ↓
                  View
                    ↓
              DispatcherServlet
                    ↓
                 HTTP 응답
                    ↓
                 브라우저
```

























