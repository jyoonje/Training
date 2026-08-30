Java static은 한마디로 말하면:
**이 멤버를 객체마다 따로 가지지 말고, 클래스에 하나만 두자.** 라고 이해하면 쉽다.

1. 일반 필드와 static 필드의 차이
일반 필드:
```
public class Person{
  String name;
}
```
객체를 3개 만들면:
Person1 p1 = new Person();
Person1 p2 = new Person();
Person1 p3 = new Person();
각 객체가 name을 각각 하나씩 갖는다. 
p1 -> name="철수"
p2 -> name="영희"
p3 -> name="민수"

반면,
```
public class Person{
  static int count;
}
```
이면 count는 객체마다 존재하는게 아니라 Person 클래스에 하나만 존재한다.
그래서 보통 `Person.count`와 같이 접근한다.

2. 왜 static을 사용하는가
가장 중요한 이유는 객체와 무관하게 클래스 차원에서 공유해야 하는 값이나 기능이 있기 떄문이다.
대표적인 예가 공통된 값을 관리하는 경우이다. 모둔 User가 하나의 count를 공유해서, count 객체가 모든 사용자의 수를 늘리는 것과 같은 역할을 할 때이다.

3. 메서드에도 static을 붙일 수 잇다.
```
public class MathUtil {

    public static int add(int a, int b) {
        return a + b;
    }
}
```
객체를 만들 필요 없이, `int result = MathUtil.add(10,20);`
과 같이 호출할 수 있다. 왜냐하면 add()가 특정 MathUtil 객체의 상태를 필요로 하지 않기 떄문이다.

4. 그래서 static의 핵심은 "객체가 없어도 된다"이다.
일반적인 인스턴스 멤버:
```
Person person - new Person();
person.getName();
```
getName() 메서드는 특정 person 객체의 이름을 알아야 하기 때뭉네 객체가 필요하다.
반면 Math.max(10,20)은 특정 Math 객체의 상태에 영향을 받지 않기 때문에, static으로 선언한다.

5. 하지만 static은 "메모리를 아끼려고 쓰는 것"이라고 이해하면 안된다.
이러한 설명을 자주 볼 수 있다: "static을 사용하면 객체를 여러 개 생성할 필요가 없기 떄문에 메모리를 절약할 수 있다."
부분적으로는 맞지만, 핵심은 아니다.

핵심은: 그 데이터나 기능이 특정 객체에 속할 필요가 없고, 클래스 전체에서 하나를 공유하는 것이 의미상 맞기 때문이다.

static은 크게 두 가지 용도로 자주 사용된다.
1. 모든 인스턴스가 공유해야 하는 값
예를 들어: static in count= 0;
count는 객체마다 따로 존재하지 않고 클래스에 하나만 존재해서, 객체가 몇 개 만들어졌는지 세거나, 모든 인스턴스의 호출을 계산하는 용도 등으로 사용된다.

2. 특정 객체의 상태가 필요없는 메서드
예를 들어:
```
public class Calculator {

    public static int add(int a, int b) {
        return a + b;
    }
}
```
add() 메서드는 특정 name, count와 같은 인스턴스 상태가 필요 없다.

결론적으로, **객체마다 따로 만들 필요 없이 클래스 자체에 소속시키는 것이 적절하기 때문**이다.
