# 1. 테스트케이스 작성 순서

![](https://cafeptthumb-phinf.pstatic.net/MjAyMDAzMTFfMjA0/MDAxNTgzOTE2MjgwMTkw.Oa4MsZx_lt5m_GeEtu1B098obQTE1C3ZhZZfptV-mBEg.8w-bP9A4YSc4G-upBmA1UtUUb9LAYTgO6ywrY1Pj2TQg.JPEG/111.JPG?type=w800)



자!(료확보)
우(선순위)리
요(구사항정의) 

방법(결정)으로
테스트 케이스의 (정의)가
타당한지 (확인)해보자



가 -> 다 -> 나 -> 라 -> 바 -> 마



# 2. 흐름 설계 수행 절차

가.UI설계안의 적정성 확인

나. 화면에 표현되어야 할 기능 및 비기능적 요구사항 검토

다. 화면의 입력 요소 및 유스케이스를 통한 UI 요구사항 확인

라. (1) 설계

UI요구사항을 바탕으로 (2)별 시나리오 구상 -> UI 요구사항으로 (2) 세분화 -> UI (3) 설계

마. 기능 및 양식 확인

InputBox, ComboBox, (3), ChecBkxo에 대한 확인, 규칙 정의

(1) :  유스케이스

(2) :  액터

(3) : Radio Box



# 3. 기능적 요구사항, 비기능적 요구사항

기능적 요구사항 : 

- 각 부서별 담당자가 홈페이지 게시물을 작성할 수 있도록 관리자 페이지가 제공되어야 한다
- 콘텐츠관리자가 예약정보를 입력하고 예약 현황을 파악할 수 있도록 다양한 통계와 관리 메뉴를 제공해야 한다.
- 특정 게시물에서 해당 예약 접수 화면으로 이동할 수 있는 링크나 삽입 기능을 제공해야 한다.
- 회원 예약은 마이페이지에서 예약 진행사항 및 이용내역을 확인할 수 있어야 한다.

비기능적 요구사항 :

- 특정 함수의 호출시간은 5초를 넘기지 말아야 한다.
- 시스템 자원의 평균사용률은 최대 70%를 초과하지 않도록 구현해야 한다.



기능 : 시스템이 제공하는 기술, 서비스 등등

비기능 : 시스템이 수행하는 기능 이외에 제약사항 및 요구사항.



# 4. 유스케이스 다이어그램



![](https://cafeptthumb-phinf.pstatic.net/MjAyMDAzMTZfMTk2/MDAxNTg0MzUwNzA5NTAx.zgfbmNmUo0FR8X9Yj3j46L9HrG7Wxw0_p8S_T-PTOLMg.2kg_-Sbl6BSU5apzwEGtUnZoi5iYShnKbUOoNmO58-8g.JPEG/%EC%9C%A0%EC%8A%A4%EC%BC%80%EC%9D%B4%EC%8A%A4.JPG?type=w800)



- 관리자는 시스템 구동을 할 수 있다.
- 관리자는 시스템 종료를 할 수 있다.
- 시스템 구동 및 시스템 종료를 수행하려면 사용자 인증을 수행해야 한다.

(1) 시스템 구동

(2) 시스템 종료

(3) <<include>>



두 개 이상의 유스케이스에 공통적으로 적용되는 기능을 분리하여 새로운 유스케이스로 만든 경우, 원래의 유스케이스와 새롭게 분리된 유스케이스와의 관계를 <<include>> (포함) 관계라고 한다.



# 5. 라우팅 알고리즘

(거리 벡터) 알고리즘은 인접 라우터와 정보를 공유해 목적지까지의 거리와 방향을 결정하는 라우팅 프로토콜이다
(링크 상태) 알고리즘은 링크 상태 정보를 모든 라우터에 전달해 최단 경로 트리를 구성하는 라우팅 프로토콜 알고리즘이다.



거리 벡터 : RIG, IGRP

링크상태 : OSPF



# 6.웹서비스



![](https://cafeptthumb-phinf.pstatic.net/MjAyMDAzMjBfMTg1/MDAxNTg0NjgwMjAwMDg2.9tdo9s-YUaoKD7yWhXUi1p0SogpZ64anWkAxvpwUYCAg.8_z0O9LrPTy0IV02OaNDXNzd5vjpl0XyRVNnd_SdQY0g.JPEG/1111.JPG?type=w800)



①. UDDI: 웹 서비스에 대한 정보인 **WSDL을 등록하고 검색하기 위한 저장소**로 공개적으로 **접근, 검색이 가능한 레지스트리**이다.

②. WSDL: 웹 서비스명, 제공 위치, 메시지 포맷, 프로토콜 정보 등 **웹 서비스에 대한 상세 정보가 기술**된 **XML 형식으로 구현되어 있는 언어**이다.

③. SOAP: HTTP, HTTPS, SMTP 등을 사용하여 **XML 기반의 메시지를 네트워크 상태에서 교환하는 프로토콜**이다.



# 7. 결함 관리 프로세스

[보기]

가. 에러 발견  마. 에러 분석

나. 에러 등록  바. 결함 확정

다. 결함 할당  사. 결함 조치 검토 및 승인

라. 결함 조치





정답) 가->나->마->바->다->라->사

두음 : **발등 분확할 조검**







------

출처 : https://cafe.naver.com/soojebi