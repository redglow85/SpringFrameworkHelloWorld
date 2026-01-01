# 02. Spring Boot (초보자용)

## 1) Spring Boot가 뭐예요?

Spring Boot는 **Spring으로 웹 애플리케이션을 “빨리, 쉽게” 만들게 해주는 도구(프로젝트 템플릿 + 자동 설정)**입니다.

Spring Framework만으로도 개발은 가능하지만, 처음에는 설정이 많고 복잡해지기 쉽습니다.
Boot는 그 “귀찮고 헷갈리는 설정”을 많이 줄여줍니다.

---

## 2) Spring Boot가 해주는 핵심 3가지

### 2.1 자동 설정(Auto Configuration)
의존성을 추가하면, Boot가 “보통 이렇게 쓰니까 이렇게 설정해줄게”를 자동으로 해줍니다.

예)
- `spring-boot-starter-web`을 넣으면
  - 웹 서버(톰캣 등)와 Spring MVC 설정이 자동으로 준비됨

### 2.2 스타터(Starter) 의존성
자주 같이 쓰는 라이브러리를 “묶음”으로 제공합니다.

예)
- `spring-boot-starter-web`
- `spring-boot-starter-test`

### 2.3 내장 서버(Embedded Server)
예전에는 톰캣을 따로 설치해서 배포하기도 했지만,
Boot는 **애플리케이션 안에 서버가 들어있어서** 실행만 하면 바로 뜹니다.

---

## 3) 기본 구조(프로젝트가 보통 어떻게 생기나요?)

### 3.1 엔트리 포인트: `@SpringBootApplication`
Boot 앱은 보통 아래처럼 시작합니다.

- `@SpringBootApplication` 하나로
  - 컴포넌트 스캔
  - 자동 설정
  - 여러 기본 설정
이 한꺼번에 켜진다고 생각하면 편합니다.

### 3.2 설정 파일: `application.yml` / `application.properties`
- 서버 포트, 로그 레벨, DB 설정 같은 “환경 설정”을 적는 곳입니다.

### 3.3 패키지 구조(권장)
초보자 기준으로는 “역할별 계층”이 이해가 쉽습니다.

- `controller/`
- `service/`
- `repository/`
- `domain/`

---

## 4) 기본 동작 방식(실행하면 어떤 일이 벌어지나요?)

1. `main()` 실행
2. Spring Boot가 ApplicationContext 생성
3. 자동 설정(Auto Configuration) 적용
4. 컴포넌트 스캔으로 Bean 등록
5. 내장 서버가 뜨고(웹 앱이라면)
6. 요청을 받을 준비가 끝남

---

## 5) 예제(이 레포에서 제공할 코드)

Boot로 아주 간단한 REST API를 띄워봅니다.

- `GET /hello` → `"hello"`
- `GET /users/{id}` → JSON 응답(간단 DTO)
- `POST /rpc/add` → RPC 스타일로 덧셈 요청/응답(JSON)

### 5.1 코드 위치
- 모듈: `spring-boot-rest-example`
- 엔트리 포인트: `com.helloworld.bootrest.BootRestApplication`

### 5.2 실행 방법

```bash
cd /Users/matrix/repositories_local/spring/SpringFrameworkHelloWorld
mvn -q -pl spring-boot-rest-example spring-boot:run
```

호출 예시:

```bash
curl -s http://localhost:8080/hello
curl -s http://localhost:8080/users/1
curl -s -X POST http://localhost:8080/rpc/add -H 'Content-Type: application/json' -d '{"a":1,"b":2}'
```

---

## 참고자료(출처)
- Spring Boot Reference Documentation: `https://docs.spring.io/spring-boot/docs/current/reference/html/`
- Spring Boot Features(Auto Configuration): `https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-auto-configuration`


