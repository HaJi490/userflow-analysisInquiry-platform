# 🚀 데이터 분석 의뢰 플랫폼

## 🛠 Tech Stack

### Backend
- **Language**: Java 17
- **Framework**: Spring Boot 3.5.0
- **Build Tool**: Maven
- **Database**: MySQL
- **ORM**: Spring Data JPA

### Security & Authentication
- **Spring Security**: 보안 아키텍처 적용
- **OAuth2 Client**: 소셜 로그인 (Social Login) 구현
- **JWT (JSON Web Token)**: `com.auth0:java-jwt` 라이브러리를 활용한 토큰 기반 인증 및 인가 처리

---

## 📌 주요 기능 (Key Features)

- **RESTful API**: Spring Web을 활용한 효율적인 API 설계 및 구축
- **Database 연동**: JPA를 사용하여 객체 지향적인 데이터 관리 및 MySQL 연동
- **보안 및 인증 시스템**: 
    - OAuth2를 이용한 간편 로그인 기능
    - JWT 토큰 기반의 무상태(Stateless) 인증 체계 구축
    - 사용자 권한에 따른 접근 제어 (Spring Security)
- **테스트 코드**: `spring-boot-starter-test` 및 `spring-security-test`를 활용한 단위 및 통합 테스트 수행
- **코드 최적화**: Lombok을 활용하여 보일러플레이트 코드 최소화
