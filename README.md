# SpringFrameworkHelloWorld (Spring 학습용)

이 레포는 **초보자가 Spring Framework / Spring Boot / RESTful / RPC / gRPC를 “동작하는 코드”로 이해**할 수 있도록 만든 학습 프로젝트입니다.

문서: `documents/` 참고

---

## 요구 사항 정리
- `documents/00_requirements.md`

---

## 모듈 구성(Maven)

- `spring-di-example`: Spring Framework DI(컨테이너/Bean/주입) 콘솔 예제
- `spring-boot-rest-example`: Spring Boot로 REST API + RPC 스타일 엔드포인트 예제
- `grpc-example`: gRPC(.proto + 코드 생성 + 서버/클라이언트) 최소 예제

---

## 실행 방법(로컬)

### 1) Spring Framework DI 예제 실행

```bash
cd {project_root}
mvn -q -pl spring-di-example exec:java
```

### 2) Spring Boot REST/RPC 예제 실행

```bash
cd {project_root}
mvn -q -pl spring-boot-rest-example spring-boot:run
```

호출 예시:

```bash
curl -s http://localhost:8080/hello
curl -s http://localhost:8080/users/1
curl -s -X POST http://localhost:8080/rpc/add -H 'Content-Type: application/json' -d '{"a":1,"b":2}'
```

### 3) gRPC 예제 실행

서버 실행(터미널 1):

```bash
cd {project_root}
mvn -q -pl grpc-example -Dexec.mainClass=com.helloworld.grpc.server.GreeterServer exec:java
```

클라이언트 실행(터미널 2):

```bash
cd {project_root}
mvn -q -pl grpc-example -Dexec.mainClass=com.helloworld.grpc.client.GreeterClient -Dexec.args=Alice exec:java
```


