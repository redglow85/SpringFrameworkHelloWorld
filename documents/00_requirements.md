# 00. 요구사항 정리 (Requirements)

이 프로젝트는 **초보자가 “Spring(Framework) / Spring Boot / RESTful / RPC / gRPC”를 아주 쉽게 이해**할 수 있도록,
**설명 문서 + 동작 확인 가능한 최소 예제 코드**를 함께 제공하는 것을 목표로 한다.

---

## 1) 최종 목표(Outcome)

- **문서**: 개념을 쉬운 말로 풀어쓴 설명 + 그림/흐름(텍스트 기반) + 비교표 + 언제 무엇을 쓰는지(Use-case)
- **코드**: 로컬에서 실행/호출해보며 “동작 방식”을 직접 확인할 수 있는 최소 예제
- **대상 독자**: Java/Spring을 처음 접하는 초보자
- **문서 위치**: `documents/` 하위에 단계별로 정리

---

## 2) Spring Framework 파트 요구사항

### 2.1 기본 설명(필수)
- Spring Framework가 무엇인지(한 문장 정의 → 쉬운 비유 → 왜 쓰는지)
- 핵심 개념을 초보자 눈높이로 설명
  - IoC(Inversion of Control)
  - DI(Dependency Injection)
  - Bean / ApplicationContext
  - AOP(관점 지향 프로그래밍) 개념 맛보기

### 2.2 기본 구조(필수)
- “애플리케이션이 어떻게 구성되는지”를 구조 관점에서 설명
  - 구성요소: `@Configuration`, `@Component`, `@Service`, `@Repository`, `@Controller`
  - Bean 생성/등록 흐름
  - 패키지 구조 예시(권장)

### 2.3 기본 동작 방식(필수)
- 애플리케이션 시작 시 Spring이 하는 일(초보자 관점 단계별)
  - 컴포넌트 스캔 → Bean 등록 → 의존성 주입 → 실행 준비
- DI가 실제로 어떻게 연결되는지 작은 예제로 확인

### 2.4 예제 코드(필수)
- “Spring DI 동작”을 확인 가능한 최소 예제
  - 예: `OrderService`가 `DiscountPolicy` 구현체를 주입받아 동작
  - 실행 결과(콘솔 출력)로 “주입이 일어났다”를 확인

---

## 3) Spring Boot 파트 요구사항

### 3.1 기본 설명(필수)
- Spring Boot가 무엇인지(“Spring을 더 쉽게 쓰게 해주는 도구/환경” 관점)
- 왜 Boot를 쓰는지(설정 자동화, 내장 서버, 스타터 의존성 등)

### 3.2 기본 구조(필수)
- 일반적인 Spring Boot 프로젝트 구조
  - `@SpringBootApplication`
  - `application.yml` 또는 `application.properties`
  - 계층 구조(Controller/Service/Repository) 예시

### 3.3 기본 동작 방식(필수)
- 애플리케이션 실행 시 Boot가 하는 일
  - Auto Configuration(자동 설정) 개념
  - Embedded Server(내장 톰캣 등) 개념
  - Starter 의존성으로 무엇이 달라지는지

### 3.4 예제 코드(필수)
- Spring Boot로 REST API를 하나 띄워서 호출 가능해야 함
  - 예: `GET /hello` → `"hello"`
  - 예: `GET /users/{id}` → 간단한 JSON 응답

---

## 4) 통신 방식 파트 요구사항 (RESTful / RPC / gRPC)

### 4.1 공통 요구사항(필수)
- 각 방식에 대해 아래를 반드시 포함
  - **기본 개념 설명(초보자용)**
  - **동작 방식(요청/응답 흐름)**
  - **간단 예시**(가능하면 “호출 방법”까지)
  - **장단점**
  - **어디에 쓰는지(Use-case)**
  - **서로의 차이점 비교표**

### 4.2 RESTful (필수)
- 리소스 중심, HTTP Method 의미, 상태 코드 등
- 예시
  - `GET /users/1`
  - `POST /users`
  - 간단한 JSON 예/응답

### 4.3 RPC (필수)
- “함수/메서드를 원격에서 호출한다” 관점
- REST와 비교했을 때의 특징(행위 중심/엔드포인트 스타일)
- 간단 예시(텍스트/코드 중 최소 1개)
  - 예: `POST /rpc/add` 요청으로 `add(a,b)` 실행 느낌

### 4.4 gRPC (필수)
- Protocol Buffers(.proto), stub, HTTP/2, 스트리밍 개념(초보자용)
- 간단 예시(최소)
  - `.proto` 정의(Hello/Greeter 등)
  - 서버 1개, 클라이언트 1개 호출 흐름

### 4.5 비교/선택 가이드(필수)
- REST vs RPC vs gRPC 비교표(학습자 관점)
  - 개발 난이도, 성능, 브라우저 친화성, 타입 안정성, 스트리밍, 디버깅/툴링 등
- 언제 무엇을 쓰면 좋은지 “상황별 추천”

---

## 5) 문서/코드 산출물(Deliverables)

### 5.1 문서(예시 목차, 추후 확정)
- `documents/01_spring_framework.md`
- `documents/02_spring_boot.md`
- `documents/03_restful.md`
- `documents/04_rpc.md`
- `documents/05_grpc.md`
- `documents/06_comparison.md`

### 5.2 코드(원칙)
- “복잡한 기능”보다 “동작 방식이 눈에 보이는 최소 예제”가 우선
- 문서에서 설명한 내용을 코드에서 바로 확인 가능해야 함
- 실행/테스트 방법을 문서에 포함(예: curl, grpcurl 등)

---

## 6) 품질 기준(초보자 친화)
- 용어는 **한 번 더 쉬운 말로 풀어서** 설명(한 문장 정의 → 예시 → 정리)
- 단계별 흐름(“1→2→3”)을 자주 사용
- 가능하면 “왜?”를 한 줄이라도 붙이기
- 예시는 작은 입력/출력으로 즉시 이해 가능해야 함


