# 데이터 분석 의뢰 플랫폼

## 🛠 Tech Stack

### Backend
- **Language**: Java 17
- **Framework**: Spring Boot 3.5.0
- **Build Tool**: Maven
- **Security**: Spring Security, JWT, OAuth2 Client
- **Database**: MySQL
- **ORM**: Spring Data JPA
- **Library**: Lombok (코드 간소화)
- **Testing**: JUnit 5, AssertJ, Mockito (via Spring Boot Starter Test)

### Frontend
- **Library:** React
- **Visualization:** Recharts
- **State Management:** Axios (API Communication)

### Data
- [Brazilian E-Commerce Public Dataset by Olist](https://www.kaggle.com/datasets/olistbr/brazilian-ecommerce?select=olist_order_items_dataset.csv)
<br>

---

## 👥 Collaboration & Role
본 프로젝트는 프론트엔드 담당자와 협업하여 제작되었습니다.

- **My Role (Fullstack)**
    1. Backend (Main)
    - **보안 및 인증**: Spring Security + JWT + OAuth2 기반의 통합 인증 아키텍처 설계 및 구현.
    - **비즈니스 로직**: 문의(Inquiry) 등록, 상태 관리, 히스토리 추적 로직 설계 및 구현.
    - **데이터 집계 API**: 대규모 주문 데이터를 가공하여 결제수단별 퍼널/전환율 산출 로직 구현.
    - **데이터베이스 설계**: 서비스 운영 및 분석 데이터 통합 스키마 설계.

    2. Frontend
    - **인증 페이지**: 로그인, 회원가입(유효성 검사 포함), 회원 정보 수정 및 탈퇴 UI 구현.
    - **문의 시스템**: 유저용 분석 의뢰 작성/조회 페이지 및 매니저용 관리 대시보드 UI 개발.

- **Teammate's Role (Frontend & Data Analysis)**
    - **데이터 전처리**: 대규모 CSV 데이터 분석 및 머신러닝 모델링 수행.
    - **시각화 대시보드**: Recharts를 활용한 분석 결과 시각화 및 프론트엔드 UI/UX 구현.
    - **데이터 분석 API 설계**: 분석 결과 데이터 제공을 위한 엔드포인트 구성 보조.
<br>

---

## 📌 주요 기능 (Key Features)

1. 보안 및 인증 (Auth & Security)
- **JWT 기반 인증 시스템:** Stateless한 토큰 기반 인증으로 보안성 강화.
- **OAuth2 소셜 로그인:** 구글 등 소셜 계정 연동을 통한 사용자 접근성 향상.
- **프론트엔드 유효성 검사:** 정규표현식을 활용한 ID(4자 이상), PW(대소문자/숫자/특수문자 조합 8자 이상) 검증 로직 구현.

2. 데이터 및 집계 API (Data Analytics)
- **RDBMS 스키마 설계:** 서비스 운영을 위한 '유저 데이터'와 비즈니스 흐름 기록을 위한 '문의/상태 히스토리' 테이블 간의 관계(1:N)를 정규화하여 데이터 무결성 보장.
- **대규모 데이터 스키마 설계 및 관리:** 약 96,000건의 분석용 대용량 CSV 데이터를 관계형 데이터베이스(MySQL)의 특성에 맞춰 테이블 구조화.
- **비즈니스 KPI 집계 로직 구현:** DB의 로우 데이터를 가공하여 단계별 전환율(Conversion Rate) 및 이탈률(Churn Rate) 산출 API 구현.
- **ML 예측 모델 결과 연계:** 머신러닝 모델을 통해 산출된 배송 기간별 재구매 확률 예측 데이터를 데이터베이스로부터 조회하여 프론트엔드에 전달하는 API 구축.

3. 테스트 및 데이터 관리 (Testing & Data Management)
- **Spring Boot Test:** 실제 애플리케이션 컨텍스트를 로드하여 계층 간 협합 테스트 수행.
- **BCrypt 보안 테스트:** PasswordEncoder를 연동하여 비밀번호 암호화 저장 및 일치 여부 검증.
- **Repository 검증:** Pageable을 활용한 페이징 처리 및 데이터 정렬 기능이 JPA를 통해 정상 작동하는지 확인.
- **대규모 데이터 조회 테스트:** 약 96,000건의 분석 데이터를 안정적으로 조회하고 처리할 수 있는지 검증.
- **Dummy Data 생성:** 시연을 위한 매니저 및 10명 이상의 사용자 데이터를 MemberRepository를 통해 자동 생성하는 로직 구축.


4. 분석 의뢰 및 관리 시스템 (Inquiry Management)
- **사용자:** 분석 의뢰 등록, 진행 상황(미확인/진행중/완료) 실시간 조회, 회원 정보 수정 및 탈퇴 기능.
- **매니저:** 전체 의뢰 목록 필터링(상태별), 실시간 상담 기록 업데이트 및 의뢰 상태 관리 기능.

5. 데이터 시각화 대시보드 (Visualization)
- Recharts 활용: 백엔드에서 가공된 JSON 데이터를 차트와 그래프로 시각화하여 사용자에게 인사이트 전달.
<br>

---
## 📊 Database ERD

```mermaid
erDiagram
    MEMBER ||--o{ INQUIRY : "creates"
    INQUIRY ||--o{ INQUIRY_STATUS_HISTORY : "tracks"
    
    MEMBER {
        string id PK "아이디"
        string username "이름"
        string password "비밀번호"
        string role "USER, MANAGER"
        datetime create_date "가입일"
    }

    INQUIRY {
        long id PK "문의 ID"
        long member_id FK "작성자 ID"
        string title "문의 제목"
        string content "문의 내용"
        string organization "기관명"
        string status "승인, 미확인, 진행중, 완료, 거절"
        datetime inquiry_date "적성일"
    }

    INQUIRY_STATUS_HISTORY {
        long id PK "히스토리 ID"
        long inquiry_id FK "문의 ID"
        string status "상태"
        string comment "상담 내용"
        datetime modified_at "수정일"
    }
```
<br>

---

## 📂 Project Structure (MVC 기반 레이어드 아키텍처)
```text
root/
├── backend/                    # Spring Boot 기반 REST API 서버
│   ├── src/main/java/edu/pnu   # 비즈니스 로직 및 API 컨트롤러
│   │   ├── config/             # Security 설정 클래스
│   │   ├── controller/         # REST API 엔드포인트 (Controller)
│   │   ├── service/            # 비즈니스 로직 및 데이터 가공 (Service)
│   │   ├── persistence/        # JPA Repository 인터페이스 (Persistence)
│   │   ├── domain/             # Entity 클래스 (Model)
│   │   └── util/               # 공통 유틸리티 기능
│   ├── src/test/java/edu/pnu   # 테스트
│   └── pom.xml                 # 프로젝트 의존성 관리
└── frontend/                   # React 기반 클라이언트 앱
    ├── src/                    # UI 컴포넌트 
    └── package.json            # 프론트엔드 라이브러리 관리
```
<br>

---

## 📑 API Reference

### 데이터 분석 API (Analytics)
| Method | Endpoint | Description | 
| :--- | :--- | :--- |
| GET | `/api/public/funnel/{payType}` | 결제수단별 주문 단계별 고객 이탈률 조회 |
| GET | `/api/delivery-analysis/datasets` | 사용 가능한 전체 데이터셋 목록 조회 |
| GET | `/api/delivery-analysis/dataset/{dataset}` | 특정 데이터셋의 전체 분석 데이터 반환 |
| GET | `/api/delivery-analysis/delivery-speed` | 배송 속도 구간별 실제 재구매율 조회 |
| GET | `/api/delivery-analysis/delivery-impact` | 배송 기간별 재구매 확률 변화 (ML 예측 데이터) |

### 유저 및 권한 API (User & Auth)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| POST | `/auth/signup` | 신규 회원가입 |
| POST | `/login` | 로그인 및 JWT 토큰 발급 |
| GET | `/api/member/info` | 로그인된 회원 정보 조회 |
| POST | `/api/member/update` | 회원 정보 수정 |
| POST | `/api/member/delete` | 회원 탈퇴 |
| POST | `/api/member/inquiry` | 신규 분석 의뢰(문의) 등록 |
| GET | `/api/member/inquiry` | 본인의 분석 의뢰 목록 조회 |
| GET | `/api/member/inquiry/{id}` | 특정 분석 의뢰 상세 내용 조회 |

### 관리자 API (Manager)
| Method | Endpoint | Description |
| :--- | :--- | :--- |
| GET | `/api/manager/inquiry` | 전체 유저의 분석 요청 목록 조회 |
| GET | `/api/manager/inquiry/{id}` | 특정 분석 요청 상세 보기 |
| POST | `/api/manager/inquiry/{id}/status` | 분석 상태 및 상담 내용 업데이트 |
