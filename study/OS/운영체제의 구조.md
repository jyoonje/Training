## 운영체제의 구조

## 커널
- OS의 핵심 부분 (메모리에 상주)
- 가장 빈번하게 사용되는기능들 담당
 - 시스템 관리(processor, memory, Etc) 등
- 동의어: 핵, 관리자 프로그램, 상주 프로그램, 제어 프로그램 

- 유틸리티
  - 비상주 프로그램
  - UI등 서비스 프로그램
 
### 커널의 핵심 역할
1. 자원 관리
- 하드웨어 자원 관리
  - 프로세서, 메모리, I/O 장치 등
- 소프트웨어 자원 관리
  - 파일, 메세지 등

 ---
 
## 운영체제의 구조
- 단일 구조
  
<img width="1060" height="418" alt="image" src="https://github.com/user-attachments/assets/606a3983-9941-405f-a963-a7077c3c0138" />

  - 장점
    - 커널 내 모듈간 직접 통신: 효율적 자원 관리 및 사용
  - 단점
    - 커널의 거대화
      - 오류 및 버그, 추가 기능 구현 등 유지보수가 어려움
      - 동일 메모리에 모든 기능이 있어, 한 모듈의 문제가 전체 시스템에 영향
     
- 계층 구조

<img width="450" height="400" alt="image" src="https://github.com/user-attachments/assets/3d9101c2-23d5-4836-866b-9cc46f7b67eb" />

  - 장점
    - 모듈화
      - 계층간 검증 및 수정 용의
    - 설계 및 구현의 단순화
  - 단점
    - 단일 구조 대비 성능 저하
      - 원하는 기능 수행을 위해 여러 계층을 거쳐야 함

- 마이크로 커널 구조

  <img width="810" height="436" alt="image" src="https://github.com/user-attachments/assets/da9e7fba-13eb-4d7c-b27e-53e5f9a78af3" />

  - 커널의 크기 최소화
     - 필수 기능만 포함
     - 기타 기능은 사용자 영역에서 수행
   
