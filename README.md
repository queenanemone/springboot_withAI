**코드와 readme 전부 Claude로 작성되었음을 미리 알립니다**

# 📋 Spring Boot 게시판 프로젝트

Spring Boot와 JPA를 활용한 간단한 CRUD 게시판 애플리케이션입니다.

## 🛠️ 기술 스택

### Backend
- **Java 17**
- **Spring Boot 3.5.6**
- **Spring Data JPA** - ORM 및 데이터베이스 접근
- **Spring Web MVC** - 웹 애플리케이션 프레임워크
- **H2 Database** - 내장 데이터베이스

### Frontend
- **Thymeleaf** - 서버 사이드 템플릿 엔진
- **HTML5 / CSS3**

### Build Tool
- **Maven**

### 기타
- **Lombok** - 보일러플레이트 코드 제거
- **Spring Boot DevTools** - 개발 편의성

## 📁 프로젝트 구조

```
src/
├── main/
│   ├── java/com/example/board/
│   │   ├── controller/
│   │   │   └── BoardController.java        # HTTP 요청 처리
│   │   ├── service/
│   │   │   └── BoardService.java           # 비즈니스 로직
│   │   ├── repository/
│   │   │   └── BoardRepository.java        # 데이터베이스 접근
│   │   ├── entity/
│   │   │   └── Board.java                  # 엔티티 (테이블 매핑)
│   │   └── BoardApplication.java           # 메인 클래스
│   │
│   └── resources/
│       ├── templates/                       # Thymeleaf 템플릿
│       │   ├── list.html                   # 게시글 목록
│       │   ├── write.html                  # 게시글 작성
│       │   ├── detail.html                 # 게시글 상세
│       │   └── edit.html                   # 게시글 수정
│       └── application.yml                  # 설정 파일
│
└── pom.xml                                  # Maven 의존성 관리
```

## 🏗️ 아키텍처

```
┌─────────────┐
│   Browser   │ ← 사용자
└──────┬──────┘
       │ HTTP Request
       ↓
┌─────────────┐
│ Controller  │ ← @GetMapping, @PostMapping
└──────┬──────┘
       │
       ↓
┌─────────────┐
│  Service    │ ← @Transactional, 비즈니스 로직
└──────┬──────┘
       │
       ↓
┌─────────────┐
│ Repository  │ ← JpaRepository, SQL 자동 생성
└──────┬──────┘
       │
       ↓
┌─────────────┐
│   Entity    │ ← @Entity, 테이블 매핑
└──────┬──────┘
       │
       ↓
┌─────────────┐
│  Database   │ ← H2
└─────────────┘
```

## 🚀 시작하기

### 필요 사항
- **JDK 17** 이상
- **Maven 3.6** 이상
- **IntelliJ IDEA** (권장) 또는 다른 IDE

### 설치 및 실행

1. **저장소 클론**
```bash
git clone https://github.com/your-username/board.git
cd board
```

2. **의존성 설치**
```bash
mvn clean install
```

3. **애플리케이션 실행**
```bash
mvn spring-boot:run
```

또는 IDE에서 `BoardApplication.java`의 `main` 메서드 실행

4. **브라우저에서 접속**
```
http://localhost:8080/board/list
```

## 📌 주요 기능

### ✅ CRUD 기능
- **Create** - 게시글 작성
- **Read** - 게시글 목록 조회 및 상세 보기
- **Update** - 게시글 수정
- **Delete** - 게시글 삭제

### 📊 추가 기능
- 조회수 자동 증가
- 작성일/수정일 자동 기록
- 최신순 정렬

## 🔗 API 엔드포인트

| 기능 | HTTP | URL | 설명 |
|-----|------|-----|------|
| 목록 조회 | GET | `/board/list` | 전체 게시글 목록 |
| 작성 폼 | GET | `/board/write` | 게시글 작성 페이지 |
| 작성 처리 | POST | `/board/write` | 게시글 등록 |
| 상세 조회 | GET | `/board/detail/{id}` | 게시글 상세 보기 |
| 수정 폼 | GET | `/board/edit/{id}` | 게시글 수정 페이지 |
| 수정 처리 | POST | `/board/edit/{id}` | 게시글 수정 |
| 삭제 | POST | `/board/delete/{id}` | 게시글 삭제 |

## 🗄️ 데이터베이스

### H2 Console 접속
```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:~/board
Username: sa
Password: (공백)
```

### Board 테이블 구조
| 컬럼명 | 타입 | 설명 |
|--------|------|------|
| id | BIGINT | 기본키 (자동 증가) |
| title | VARCHAR(200) | 제목 |
| content | TEXT | 내용 |
| writer | VARCHAR(50) | 작성자 |
| view_count | INTEGER | 조회수 (기본값: 0) |
| created_at | TIMESTAMP | 작성일 (자동 생성) |
| updated_at | TIMESTAMP | 수정일 (자동 갱신) |

## ⚙️ 설정

### application.yml
```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:~/board
    driver-class-name: org.h2.Driver
    username: sa
    password:
  
  jpa:
    hibernate:
      ddl-auto: update  # 테이블 자동 생성/수정
    show-sql: true      # SQL 쿼리 출력
```

## 🎓 학습 포인트

이 프로젝트를 통해 다음을 학습할 수 있습니다:

### Spring Boot 핵심 개념
- **의존성 주입 (DI)** - `@RequiredArgsConstructor`
- **계층 구조** - Controller → Service → Repository
- **트랜잭션 관리** - `@Transactional`
- **자동 설정** - Spring Boot Auto Configuration

### JPA/Hibernate
- **엔티티 매핑** - `@Entity`, `@Id`, `@Column`
- **Repository 패턴** - `JpaRepository`
- **메서드 네이밍 쿼리** - `findAllByOrderByCreatedAtDesc()`
- **변경 감지 (Dirty Checking)** - 자동 UPDATE

### Thymeleaf
- **템플릿 문법** - `th:text`, `th:each`, `th:href`
- **모델 바인딩** - Controller에서 View로 데이터 전달
- **폼 처리** - `th:action`, `th:value`

### 웹 개발 패턴
- **MVC 패턴** - Model-View-Controller 분리
- **RESTful URL 설계** - `/board/list`, `/board/detail/{id}`
- **PRG 패턴** - Post-Redirect-Get (중복 제출 방지)

## 🔧 개발 환경 설정

### IntelliJ IDEA 설정

1. **Lombok 플러그인 설치**
   - File → Settings → Plugins → "Lombok" 검색 및 설치

2. **Annotation Processing 활성화**
   - File → Settings → Build, Execution, Deployment → Compiler → Annotation Processors
   - "Enable annotation processing" 체크

3. **자동 재시작 (DevTools)**
   - 코드 수정 후 `Ctrl+F9` (Build Project) → 자동 재시작

## 📝 코드 스타일

- **들여쓰기**: 탭 (Tab)
- **중괄호 스타일**: BSD 스타일
```java
public void method()
{
	// 코드
}
```

## 🐛 트러블슈팅

### 포트 충돌
```yaml
# application.yml에서 포트 변경
server:
  port: 8081
```

### Lombok 인식 불가
```bash
# IntelliJ 재시작 또는
File → Invalidate Caches → Invalidate and Restart
```

### H2 데이터베이스 연결 실패
```yaml
# JDBC URL 확인
spring.datasource.url: jdbc:h2:~/board
```

## 📚 참고 자료

- [Spring Boot 공식 문서](https://spring.io/projects/spring-boot)
- [Spring Data JPA 문서](https://spring.io/projects/spring-data-jpa)
- [Thymeleaf 문서](https://www.thymeleaf.org/)
- [H2 Database 문서](https://www.h2database.com/)

## 📄 라이선스

This project is open source and available under the [MIT License](LICENSE).

## 👤 작성자

**Your Name**
- GitHub: [@your-username](https://github.com/your-username)

## 🙏 감사의 말

Spring Boot와 IntelliJ IDEA를 학습하며 만든 첫 게시판 프로젝트입니다.
