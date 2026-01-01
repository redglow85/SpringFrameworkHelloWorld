# 01. Spring Framework (초보자용)

## 1) Spring Framework가 뭐예요?

Spring Framework는 **자바로 애플리케이션을 만들 때 “부품(객체)들을 깔끔하게 조립하고 관리”하도록 도와주는 프레임워크**입니다.

- 우리가 직접 “new”로 객체를 만들고 연결하는 대신,
- Spring이 객체를 만들어주고(생성), 필요한 곳에 넣어주고(주입), 전체 생명주기를 관리해줍니다.

한 문장으로 줄이면:
- **Spring = “객체 조립/관리(컨테이너) + 웹 개발/데이터 처리 등 개발에 필요한 기반 기능”을 제공하는 큰 도구상자**

---

## 2) Spring Framework로 뭘 만들 수 있어요?

초보자가 많이 헷갈리는 부분이라, “Spring으로 실제로 뭘 만들 수 있나?”를 먼저 정리합니다.

### 2.1 BE(백엔드) / API 서버
- **REST API 서버**를 만들 수 있어요. (가장 흔한 사용)
- 요청을 받고(Controller) → 로직 처리(Service) → 결과(JSON 등) 응답하는 구조를 쉽게 구성합니다.

### 2.2 웹 애플리케이션(서버가 HTML을 만들어주는 방식, SSR)
- Spring은 **서버에서 HTML을 만들어서** 브라우저에 내려주는 방식도 지원합니다.
  - 예: Thymeleaf 같은 템플릿 엔진과 함께 사용
- 이건 “React/Vue 같은 FE 프레임워크”와는 결이 다르고,
  - **서버가 화면을 만들어주는 웹**이라고 이해하면 쉬워요.

### 2.3 리액티브(비동기) API 서버
- 트래픽이 많거나 I/O가 많은 상황에서 **리액티브 방식(WebFlux)**으로 API 서버를 만들 수도 있습니다.
  - 초보자는 일단 “가능하다” 정도만 알고, REST(Spring MVC)부터 익히는 걸 추천합니다.

### 2.4 배치/스케줄링/백그라운드 작업
- “매일 새벽 정산” 같은 **배치 작업**이나 **주기적 작업(스케줄링)**에도 많이 사용합니다.

### 2.5 FE(프론트엔드)는?
- Spring 자체는 보통 React/Vue처럼 “브라우저 UI를 만드는 FE 프레임워크” 역할은 아닙니다.
- 대신 현실적인 조합은 아래 중 하나예요.
  - **FE(SPA)는 따로** 만들고, Spring은 **BE/API 서버**로 동작
  - FE 정적 파일을 Spring 서버가 **서빙**하고, API도 같이 제공(단일 배포)

---

## 3) 핵심 개념 4개만 먼저 잡기

### 2.1 IoC (Inversion of Control: 제어의 역전)
**원래는 내가 객체 생성/연결을 직접 제어**합니다.

```java
Car car = new Car(new Engine());
```

Spring을 쓰면, **누가 무엇을 만들고 연결할지 “Spring이 대신” 결정**합니다.

즉, “제어(컨트롤)가 나 → Spring 컨테이너로 넘어갔다”가 IoC의 핵심입니다.

### 2.2 DI (Dependency Injection: 의존성 주입)
DI는 IoC를 “구체적으로 구현하는 방식” 중 하나로 보면 쉽습니다.

- `OrderService`가 `DiscountPolicy`가 필요하다고 할 때,
- `OrderService`가 직접 `new FixDiscountPolicy()`를 만들지 않고,
- Spring이 **필요한 구현체를 “주입”**해줍니다.

### 2.3 Bean / ApplicationContext
- **Bean**: Spring이 관리하는 객체(부품)
- **ApplicationContext**: Bean들을 담고 있는 “컨테이너/공장/관리자” 같은 존재

### 2.4 AOP (관점 지향 프로그래밍) - 맛보기
AOP는 “핵심 로직”과 “공통 로직”을 분리하는 기술입니다.

- 핵심 로직: 주문 처리
- 공통 로직: 로깅, 트랜잭션, 보안 체크

공통 로직을 코드 여기저기 붙이지 않고, “관점(Aspect)”으로 분리해 적용합니다.

---

## 4) 기본 구조(어떤 부품들로 구성되나요?)

초보자 기준으로 가장 많이 보는 구성은 아래처럼 “역할별로 나누기”입니다.

- **Controller**: 요청을 받는 입구(웹)
- **Service**: 비즈니스 로직(규칙/흐름)
- **Repository**: DB 접근(저장/조회)
- **Configuration**: 어떤 Bean을 만들지 정의

그리고 Spring이 Bean을 찾고 등록하는 대표 방식은:
- **컴포넌트 스캔**: `@Component`, `@Service` 같은 애너테이션을 붙인 클래스를 자동으로 Bean으로 등록
- **자바 설정(@Configuration)**: 코드로 “이 객체를 Bean으로 써라”라고 명시

---

## 5) 기본 동작 방식(애플리케이션 시작 시 무슨 일이 일어나나요?)

아래 흐름만 기억하면 됩니다.

1. **ApplicationContext(컨테이너) 생성**
2. **Bean 등록**
   - 컴포넌트 스캔 or 설정 클래스(@Configuration) 기반 등록
3. **의존성 주입(DI)**
   - 생성자 주입 등으로 필요한 Bean을 연결
4. **애플리케이션 준비 완료**

---

## 6) 예제(이 레포에서 확인할 코드)

이 레포에서는 “DI가 실제로 어떻게 일어나는지”를 콘솔 출력으로 확인하는 최소 예제를 제공합니다.

- 예: `OrderService`가 `DiscountPolicy`를 주입받아 할인 금액을 계산
- 실행하면 콘솔에 “어떤 구현체가 주입됐는지”가 출력되도록 구성

### 5.1 코드 위치
- 모듈: `spring-di-example`
- 엔트리 포인트: `com.helloworld.di.DiExampleApplication`

### 5.2 실행 방법

```bash
cd {project_root}
mvn -q -pl spring-di-example exec:java
```

실행하면 대략 아래처럼 “어떤 구현체가 주입됐는지”와 계산 결과가 콘솔에 출력됩니다.
- `[DI] DefaultOrderService created with discountPolicy=FixDiscountPolicy`
- `[ORDER] ...`
- `[RESULT] ...`

---

## 참고자료(출처)
- Spring Framework Reference Documentation: `https://docs.spring.io/spring-framework/reference/`
- Spring Core(Beans/Context): `https://docs.spring.io/spring-framework/reference/core/beans.html`
- Spring Web MVC: `https://docs.spring.io/spring-framework/reference/web/webmvc.html`
- Spring WebFlux: `https://docs.spring.io/spring-framework/reference/web/webflux.html`


