<h1>스프링부트 백엔드 프로그래밍</h1>

> 다음 블로그의 내용으로 진행한 코딩 실습
https://brunch.co.kr/@springboot/530

<br><br>

[TOC]

# 🐾 개발도구
  - STS
  - PostMan

# ❗ 중요 Point

## AutoConfiguration

- 스프링부트는 개발자가 따로 설정하지 않아도 기본 설정이 자동 구성된다.
ex) 포트번호 : 8080
- 아래 링크에서 기본 설정 및 다양할 설정들을 입맛에 맛게 변경하는 방법에 대해서 알 수 있다.

https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties

## Active Profiles

Spring Boot의 profile은 각각의 환경 정보들을 의미한다.

### Profile

기본적인 Profile 정보는
- application.properties

이지만, 특정 규칙에 만족하는 파일 ```application-{환경}.proierties``` 을 만들어 다양한 환경의 Profile 설정을 사용할 수 있다.
- ex) application-dev.properties

### Profile 변경

STS -> Boot dashboard -> 설정할 Project 우클릭 -> Open Config
-> Spring Boot 탭의 Profile을 설정할 파일의 환경 명으로 지정

Profile을 변경하면 <b>application.properties</b>의 설정도 사용하며,
<b>application.properties</b>와 <b>설정할 profile의 properties파일</b>에 똑같은 변수를 작성하였다면,
<b>설정할 profile의 properties의 변수</b>를 최종 값으로 사용한다.

# 🤔 개발 중 오류
## STS Lombok 미적용
**1. lombok 설치파일 실행**

STS 좌측 project explorer -> Project and External Dependencies(jar파일 폴더)
-> lombok.jar파일 우클릭 -> Run as -> Java Application -> lombok 실행

**2. lombok 설치**

Specify location... 클릭 -> STS 실행파일 선택 -> 사용하는 프로그램만 선택 -> Install / Update

**3. STS 재실행**

>참고 사이트
>https://leti-lee.tistory.com/28




# 🤗 참조
https://brunch.co.kr/@springboot/530
