# 🤖 Spring Boot 게시판 시스템 (AI-Assisted Development)

[![Built with AI](https://img.shields.io/badge/Built%20with-AI%20Assistance-blue?style=for-the-badge&logo=anthropic)](https://www.anthropic.com)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.6-brightgreen?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)](https://www.oracle.com/java/)

> 💡 **AI와 함께 만든 프로젝트**  
> 이 프로젝트는 Anthropic의 Claude AI를 페어 프로그래밍 파트너로 활용하여 개발되었습니다.

## 📌 프로젝트 소개

Spring Boot, JPA, Thymeleaf를 활용한 기본 CRUD 게시판 시스템입니다.  
**AI 기술을 적극 활용**하여 학습과 개발을 동시에 진행했습니다.

### 🎯 주요 특징
- ✅ 완전한 CRUD 기능 (Create, Read, Update, Delete)
- ✅ JPA를 활용한 데이터베이스 관리
- ✅ Thymeleaf 템플릿 엔진으로 동적 웹 페이지 구현
- ✅ RESTful한 URL 구조
- ✅ 반응형 UI 디자인
- ✅ H2 인메모리 데이터베이스 사용
- 🤖 **AI 기반 코드 생성 및 최적화**

## 🛠️ 기술 스택

### Backend
- **Java 17**: 프로그래밍 언어
- **Spring Boot 3.5.6**: 애플리케이션 프레임워크
- **Spring Data JPA**: ORM (Object-Relational Mapping)
- **H2 Database**: 인메모리 데이터베이스

### Frontend
- **Thymeleaf**: 템플릿 엔진
- **HTML5 / CSS3**: 마크업 및 스타일
- **JavaScript**: 동적 기능

### Build Tool
- **Maven**: 의존성 관리 및 빌드

## 🤖 AI 활용 내역

이 프로젝트는 **Claude AI (Anthropic)**와의 협업으로 개발되었습니다.

### AI가 도운 작업들

#### 1. 아키텍처 설계
```
✓ MVC 패턴 설계
✓ 계층형 아키텍처 구현
✓ Entity-DTO 구조 설계
✓ Repository 패턴 적용
```

#### 2. 코드 작성 및 리뷰
```
✓ Controller, Service, Repository 구현
✓ JPA 엔티티 설계
✓ 비즈니스 로직 작성
✓ 코드 품질 개선 제안
```

#### 3. 문제 해결
```
✓ 에러 디버깅 및 해결
✓ 타입 미스매치 문제 해결
✓ 의존성 주입 이슈 해결
✓ Firebase 연동 트러블슈팅
```

#### 4. UI/UX 구현
```
✓ 반응형 웹 디자인
✓ 네비게이션 바 구현
✓ 애니메이션 효과
✓ 사용자 경험 최적화
```

#### 5. 학습 지원
```
✓ Spring Boot 개념 설명
✓ JPA 동작 원리 이해
✓ Bean 생성 과정 학습
✓ 실무 베스트 프랙티스 습득
```

### 💡 AI와 함께한 개발의 장점

1. **빠른 학습 속도**: 실시간으로 질문하고 답변 받으며 학습
2. **코드 품질 향상**: 베스트 프랙티스를 즉시 적용
3. **생산성 증대**: 반복적인 코드 작성 시간 단축
4. **깊은 이해**: 단순 복사가 아닌 원리 이해 중심 학습
5. **즉각적인 피드백**: 코드 리뷰와 개선사항을 실시간으로 받음

## 📁 프로젝트 구조

```
board/
├── src/main/
│   ├── java/com/example/board/
│   │   ├── BoardApplication.java       # 메인 클래스
│   │   ├── controller/
│   │   │   ├── HomeController.java     # 메인, 소개, 문의 페이지
│   │   │   └── BoardController.java    # 게시판 CRUD
│   │   ├── service/
│   │   │   ├── BoardService.java       # 비즈니스 로직
│   │   │   └── FirebaseService.java    # Firebase 연동 (선택)
│   │   ├── repository/
│   │   │   └── BoardRepository.java    # JPA Repository
│   │   ├── entity/
│   │   │   └── Board.java              # 게시글 엔티티
│   │   └── config/
│   │       └── FirebaseConfig.java     # Firebase 설정 (선택)
│   │
│   └── resources/
│       ├── application.yml             # 애플리케이션 설정
│       └── templates/
│           ├── index.html              # 메인 페이지
│           ├── about.html              # 프로젝트 소개
│           ├── contact.html            # 문의하기
│           ├── list.html               # 게시글 목록
│           ├── write.html              # 게시글 작성
│           ├── detail.html             # 게시글 상세
│           └── edit.html               # 게시글 수정
│
└── pom.xml                             # Maven 설정
```

## 🚀 실행 방법

### 1. 프로젝트 클론
```bash
git clone https://github.com/your-username/board.git
cd board
```

### 2. 실행
```bash
# Maven을 사용하는 경우
./mvnw spring-boot:run

# IDE (STS, IntelliJ)에서 실행
# BoardApplication.java의 main 메서드 실행
```

### 3. 접속
```
http://localhost:8080
```

## 📱 주요 기능

### 1. 게시글 관리
- **목록 조회**: 작성일 기준 최신순 정렬
- **상세 조회**: 조회수 자동 증가
- **작성**: 제목, 내용, 작성자 입력
- **수정**: 제목, 내용 수정 가능
- **삭제**: 확인 후 삭제

### 2. 자동 기능
- 작성일/수정일 자동 기록 (`@CreatedDate`, `@LastModifiedDate`)
- 조회수 자동 증가
- ID 자동 생성

### 3. 웹 페이지
- **메인 페이지**: 프로젝트 소개 및 네비게이션
- **게시판 페이지**: 게시글 CRUD
- **소개 페이지**: 기술 스택 및 AI 활용 내역
- **문의 페이지**: 연락처 및 문의 폼

## 🗄️ 데이터베이스

### H2 Console 접속
```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:~/board
Username: sa
Password: (공백)
```

### Board 테이블 구조
```sql
CREATE TABLE board (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    writer VARCHAR(100) NOT NULL,
    view_count INT DEFAULT 0,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);
```

## 🎓 학습 내용

이 프로젝트를 통해 배운 내용:

### Spring Boot
- Spring Boot 기본 구조와 설정
- Component Scan과 Bean 등록
- 의존성 주입 (Dependency Injection)
- `@Autowired` 생략 조건

### JPA
- Entity 설계 및 매핑
- Repository 인터페이스
- Query Method
- `@Transactional` 트랜잭션 관리

### 웹 개발
- Thymeleaf 템플릿 엔진
- RESTful URL 설계
- MVC 패턴
- HTTP 요청/응답 처리

### 데이터베이스
- H2 인메모리 데이터베이스
- JPA를 통한 데이터 관리
- CRUD 작업

## 🔄 개발 과정

### 1단계: 프로젝트 초기 설정 (AI 지원)
```
✓ Spring Initializr로 프로젝트 생성
✓ 의존성 추가 (JPA, H2, Thymeleaf)
✓ application.yml 설정
```

### 2단계: Entity 및 Repository 구현 (AI 지원)
```
✓ Board Entity 설계
✓ BoardRepository 인터페이스 생성
✓ Query Method 작성
```

### 3단계: Service 계층 구현 (AI 지원)
```
✓ BoardService 비즈니스 로직
✓ 트랜잭션 관리
✓ 예외 처리
```

### 4단계: Controller 구현 (AI 지원)
```
✓ BoardController CRUD 매핑
✓ HomeController 페이지 매핑
✓ Model 데이터 전달
```

### 5단계: View 구현 (AI 지원)
```
✓ Thymeleaf 템플릿 작성
✓ UI/UX 디자인
✓ 반응형 웹 구현
```

### 6단계: 테스트 및 디버깅 (AI 지원)
```
✓ 기능 테스트
✓ 에러 해결
✓ 코드 최적화
```

## 🤝 기여하기

프로젝트에 기여하고 싶으시다면:
1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 라이센스

이 프로젝트는 MIT 라이센스 하에 있습니다.

## 👤 개발자

**형석** (with Claude AI)

- GitHub: [@your-username](https://github.com/your-username)
- Email: your-email@example.com

## 🙏 감사의 말

- **Anthropic (Claude AI)**: AI 페어 프로그래밍 파트너로서 큰 도움을 주었습니다
- **Spring Boot Team**: 훌륭한 프레임워크를 제공해주셔서 감사합니다
- **오픈소스 커뮤니티**: 학습 자료와 영감을 제공해주셔서 감사합니다

---

⭐ 이 프로젝트가 도움이 되었다면 Star를 눌러주세요!

**Built with 🤖 AI Assistance - Powered by Claude (Anthropic)**