# 데이터 분석 의뢰 플랫폼

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
<br>

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
<br>

---
## 📊 Database ERD
<br>

---
## 📑 API Reference

### 데이터 분석 API (Analytics)
| Method | URI | Description |
| :--- | :--- | :--- |
| GET | `/api/public/funnel/{payType}` | 결제수단별 주문 단계별 고객 이탈률 조회 |
| GET | `/api/delivery-analysis/datasets` | 사용 가능한 전체 데이터셋 목록 조회 |
| GET | `/api/delivery-analysis/dataset/{dataset}` | 특정 데이터셋의 전체 분석 데이터 반환 |
| GET | `/api/delivery-analysis/delivery-speed` | 배송 속도 구간별 실제 재구매율 조회 |
| GET | `/api/delivery-analysis/delivery-impact` | 배송 기간별 재구매 확률 변화 (ML 예측 데이터) |
| GET | `/api/delivery-analysis/business-metrics` | 핵심 지표(총 고객, 배송속도, 재구매율 등) 일괄 조회 |

### 유저 및 권한 API (User & Auth)
| Method | URI | Description |
| :--- | :--- | :--- |
| POST | `/auth/signup` | 신규 회원가입 |
| POST | `/login` | 로그인 및 JWT 토큰 발급 |
| GET | `/api/member/info` | 로그인된 회원 정보 조회 |
| POST | `/api/member/inquiry` | 신규 분석 의뢰(문의) 등록 |
| GET | `/api/member/inquiry` | 본인의 분석 의뢰 목록 조회 |
| GET | `/api/member/inquiry/{id}` | 특정 분석 의뢰 상세 내용 조회 |

### 관리자 API (Manager)
| Method | URI | Description |
| :--- | :--- | :--- |
| GET | `/api/manager/inquiry` | 전체 유저의 분석 요청 목록 조회 |
| GET | `/api/manager/inquiry/{id}` | 특정 분석 요청 상세 보기 |
| POST | `/api/manager/inquiry/{id}/status` | 분석 상태 및 상담 내용 업데이트 |
