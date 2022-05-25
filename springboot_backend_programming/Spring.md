# Spring 내용 정리


<br><br>

## 목차
- [AutoConfiguration](#-AutoConfiguration)
- [Active Profiles](#-Active-Profiles)
- [Annotation](#-Profiles)

## AutoConfiguration

- 스프링부트는 개발자가 따로 설정하지 않아도 기본 설정이 자동 구성된다.
ex) 포트번호 : 8080
- 아래 링크에서 기본 설정 및 다양할 설정들을 입맛에 맛게 변경하는 방법에 대해서 알 수 있다.

> https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#appendix.application-properties

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

## Annotation
### Spring
| 제목 | 설명 |
| --- | --- |
| @Controller| 주로 View를 반환하기 위해 사용하며, 클라이언트가 요청한 ViewName에 해당하는 View를 찾아, ViewResolver를 통해 사용자에게 반환한다. |
| @ResponseBody | 메소드에 @ResponseBody 로 어노테이션이 되어 있다면 메소드에서 리턴되는 값은 View 를 통해서 출력되지 않고 HTTP Response Body 에 직접 쓰여지게 된다.
| @RestController |  @Controller에 @ResponseBody가 추가되어 RestController의 주용도는 Json 형태로 객체 데이터를 반환한다.  |
| @RequestMapping |  요청에 대해 어떤 Controller, 어떤 Method가 처리할지를 매핑하기 위한 어노테이션  |
| @GetMapping | RequestMapping의 요청방식이 GET인 어노테이션 |
| @Service | 해당 클래스를 루트 컨테이너에서 자바 로직을 처리할 빈 객체로 생성해주는 어노테이션 |
| @Compoment |  루트 컨테이너에 빈 객체로 생성해주는 어노테이션
| @Configuration | @Bean과 함께 사용되며, 해당 클래스에 Bean을 등록하고 설정하는 어노테이션
| @SpringBootApplication | 스프링 부트의 가장 기본적인 설정을 선언해주는 어노테이션
<br>

### lombok
| 제목 | 설명 |
| --- | --- |
| @Getter |  멤버 변수들의 Getter 메소드를 이용할 수 있다.
| @Setter |  멤버 변수들의 Setter 메소드를 이용할 수 있다.
| @Data |  Lombok의 모든 어노테이션을 포함하는 어노테이션
| @Builder | 빌더패턴을 적용 시킨 방법으로 객체를 생성 할 수 있다.
<br>

> **출처**
Annotation 정리
https://dev.to/composite/-40c0
@Controller, @RestController, @RestController
https://mangkyu.tistory.com/49
@ResponseBody
https://ismydream.tistory.com/140
@RequestMapping, @GetMapping
https://eunoia3jy.tistory.com/58
@Service, @Component
https://codevang.tistory.com/258
@SpringBootApplicatoin
https://velog.io/@jwkim/spring-boot-springapplication-annotation
Lombok
https://gardeny.tistory.com/4
