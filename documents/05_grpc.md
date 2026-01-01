# 05. gRPC (초보자용)

## 1) gRPC가 뭐예요?

gRPC는 **서비스(함수)를 호출하기 위한 “고성능 RPC 프레임워크”**입니다.

REST처럼 사람이 읽기 쉬운 JSON/HTTP를 주로 쓰는 방식과 달리,
gRPC는 보통 아래 특징을 가집니다.

- **.proto(Protocol Buffers)** 파일로 “요청/응답 메시지”와 “서비스 메서드”를 정의
- **코드 생성(Code Generation)** 으로 클라이언트/서버 코드를 자동 생성(타입 안정성 ↑)
- **HTTP/2** 기반(성능/스트리밍 지원 등)

---

## 2) 기본 동작 방식(요청/응답 흐름)

1. 개발자가 `.proto`에 서비스와 메시지를 정의
2. 빌드 단계에서 `.proto`로부터 코드가 자동 생성됨
   - 서버 쪽: “이 메서드를 구현하세요”라는 뼈대
   - 클라이언트 쪽: “이 메서드를 호출하세요”라는 스텁(stub)
3. 서버는 생성된 인터페이스(또는 추상 클래스)를 구현하고 실행
4. 클라이언트는 스텁을 통해 메서드를 호출
5. 내부적으로는 HTTP/2 위에서 바이너리(Protobuf)로 통신

---

## 3) 아주 작은 `.proto` 예시

예를 들어 “인사(Hello)” 서비스를 만든다고 하면:

```proto
syntax = "proto3";

package hello;

service Greeter {
  rpc SayHello(HelloRequest) returns (HelloReply);
}

message HelloRequest {
  string name = 1;
}

message HelloReply {
  string message = 1;
}
```

여기서 중요한 건:
- **service + rpc**: “원격 호출할 메서드”
- **message**: “요청/응답 데이터 구조”

---

## 4) gRPC의 장점/단점(초보자 관점)

### 장점
- **타입 안정성**: 요청/응답 구조가 강하게 고정됨
- **성능**: HTTP/2 + Protobuf로 효율적
- **스트리밍**: 서버/클라이언트 스트리밍 지원

### 단점
- 브라우저에서 바로 호출하기는 REST보다 불편(추가 구성 필요)
- 디버깅이 “텍스트(JSON)”보다 직관적이지 않을 수 있음
- 빌드/코드생성(플러그인) 개념을 알아야 해서 초보자에겐 진입장벽이 있음

---

## 5) 언제 gRPC를 쓰면 좋아요?

- 내부 서비스 간 통신에서 **성능/타입/계약**이 중요할 때
- 스트리밍(실시간 데이터)을 깔끔하게 다루고 싶을 때
- 여러 언어(Go/Java/Python 등) 팀이 함께 “같은 계약(.proto)”으로 협업할 때

---

## 6) 이 레포에서 실행해보기

### 6.1 코드 위치
- 모듈: `grpc-example`
- proto: `grpc-example/src/main/proto/hello.proto`
- 서버: `com.helloworld.grpc.server.GreeterServer`
- 클라이언트: `com.helloworld.grpc.client.GreeterClient`

### 6.2 실행 방법

서버 실행(터미널 1):

```bash
cd /Users/matrix/repositories_local/spring/SpringFrameworkHelloWorld
mvn -q -pl grpc-example -Dexec.mainClass=com.helloworld.grpc.server.GreeterServer exec:java
```

클라이언트 실행(터미널 2):

```bash
cd /Users/matrix/repositories_local/spring/SpringFrameworkHelloWorld
mvn -q -pl grpc-example -Dexec.mainClass=com.helloworld.grpc.client.GreeterClient -Dexec.args=Alice exec:java
```

---

## 참고자료(출처)
- gRPC 공식 문서: `https://grpc.io/docs/`
- Protocol Buffers 공식 문서: `https://protobuf.dev/`


