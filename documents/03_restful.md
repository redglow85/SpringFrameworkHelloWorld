# 03. RESTful (초보자용)

## 1) RESTful이 뭐예요?

RESTful은 “웹에서 자원을 다루는 방법”을 **규칙처럼 정리한 스타일**입니다.

핵심은 이겁니다:
- **자원(Resource)**을 “주소(URL)”로 표현하고
- **행동(동작)**은 “HTTP Method(GET/POST/PUT/DELETE …)”로 표현합니다.

즉, “무엇(자원)을” + “어떻게(메서드)”로 말하는 방식이에요.

---

## 2) 기본 동작 방식(요청/응답 흐름)

1. 클라이언트(브라우저/앱)가 HTTP 요청을 보냅니다.
2. 서버(Spring Boot)가 Controller에서 요청을 받습니다.
3. Service에서 로직을 처리하고 결과를 만듭니다.
4. 서버가 HTTP 응답을 돌려줍니다.
   - 상태코드(200/404/500 등)
   - 바디(JSON 등)

---

## 3) REST에서 자주 보는 요소들

### 3.1 URL은 “자원”을 가리키기
- 좋은 예: `/users/1` (1번 유저라는 자원)
- 덜 REST스러운 예: `/getUser?id=1` (행동이 URL에 섞임)

### 3.2 Method는 “행동”을 의미하기
- `GET` : 조회
- `POST`: 생성
- `PUT`/`PATCH`: 수정
- `DELETE`: 삭제

### 3.3 상태 코드로 결과를 말하기(아주 자주 봄)
- `200 OK`: 성공
- `201 Created`: 생성 성공
- `400 Bad Request`: 요청이 이상함(검증 실패 등)
- `404 Not Found`: 자원이 없음
- `500 Internal Server Error`: 서버 내부 오류

---

## 4) 간단 예시(요청/응답 예)

### 4.1 유저 조회
요청:
- `GET /users/1`

응답 예(200):

```json
{
  "id": 1,
  "name": "Alice"
}
```

### 4.2 유저 생성
요청:
- `POST /users`

요청 바디 예:

```json
{
  "name": "Bob"
}
```

응답 예(201):

```json
{
  "id": 2,
  "name": "Bob"
}
```

---

## 5) 언제 RESTful을 쓰면 좋아요?

- 브라우저/모바일 앱 등 **HTTP 기반 통신이 자연스러운 경우**
- 외부에 공개할 API를 만들 때(표준/도구가 많음)
- “자원 중심”으로 모델링하기 쉬운 도메인

---

## 참고자료(출처)
- RFC 9110: HTTP Semantics: `https://www.rfc-editor.org/rfc/rfc9110`
- MDN Web Docs - HTTP methods: `https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods`


