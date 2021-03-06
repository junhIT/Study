# Spring 내용 정리


<br><br>

## 목차
- [AutoConfiguration](#autoconfiguration)
- [Active Profiles](#active-profiles)
- [Annotation](#annotation)
- [Bean Life Cycle](#bean-life-cycle)
- [AOP (Aspect-Oriented Programming)](#aop--aspect-oriented-programming-)

# AutoConfiguration

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
|@EnableAutoConfiguration|스프링 부트의 AutoConfiguration 기능을 사용하겠다는 설정|
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


## Bean Life Cycle
### 1. 스프링 IoC 컨테이너 생성
### 2. Component-Scan으로 IoC컨테이너 안에  Bean 등록
- @Configuration, @Controller, @Service 등 Bean으로 등록할 수 있는 어노테이션들과 설정 파일들을 읽여 Bean으로 등록
### 3. 의존성 주입
- 생성자 주입 : 객체의 생성, 의존관계 주입이 동시에 일어남
- 수정자 주입 : 객체의 생성 -> 의존관계 주입으로 라이프 사이클이 나누어져 있음
### 4. 초기화 콜백
- 빈이 생성되고, 빈의 의존관계 주 완료된 후 호출
- 초기화 인터페이스 : @PostConstruct
### 5. 소멸 전 콜백
- 빈이 소멸되기 직전에 호출
- 소멸 인터페이스 : @PreConstructor
### 6. 스프링 종료



  ### - DI ( 의존성 주입 )의 다양한 방법
  #### 1.  생성자 주입 ( Constructor Injection )
``` java
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MemberService memberService;

    public UserServiceImpl(UserRepository userRepository, MemberService memberService) {
        this.userRepository = userRepository;
        this.memberService = memberService;
    }
}
```
  - 생성자의 호출 시점에 1회 호출되는 것을 보장
  - 주입받은 객체가 변하지 않거나, 반드시 객체의 주입이 필요한 경우에 강제하기 위해 사용
  - 생성자가 1개만 있을 경우 @Autowired를 생략해도 주입이 가능

#### 2. 수정자 주입 ( Setter 주입, Setter Injection )

``` Java
  @Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private MemberService memberService;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
}
```
  - 주입받는 객체가 변경될 가능성이 있는 경우

#### 3. 필드 주입 ( Field Injection )

``` Java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MemberService memberService;
}
```
  - 외부에서 접근이 불가능하다는 단점
  - 필드 주입은 반드시 DI 프레임워크가 존재



> **출처**
BeanLifeCycle
https://devlog-wjdrbs96.tistory.com/321
생성자 주입
https://mangkyu.tistory.com/125

# AOP (Aspect-Oriented Programming)
- 관점 지향 프로그래밍으로 인프라 혹은 부가기능을 모듈화
ex) 로깅, 트랜잭션, 보안 등

## AOP 용어
### 타겟(Target)
- 부가기능을 부여할 대상

### 애스펙트(Aspect)
- 부가기능 모듈을 애스펙트라고 부르며, 핵심 기능에 부가되어 특별한 의미를 갖는 모듈

### 어드바이스(Advice)
- 실직적으로 부가기능을 담은 구현체로, 애스펙트가 '무엇을', '언제' 할지를 정의함

### 조인포인트(JoinPoint)
-   어드바이스가 적용될 수 있는 위치

### 프록시(Proxy)
- 타겟을 감싸서 타겟의 요청을 대신 받아주는 랩핑(Wrapping) 오브젝트

### 인트로덕션(Introduction)
- 타겟 클래스에 코드 변경없이 신규 메소드나 멤버변수를 추가하는 기능

### 위빙(Weaving)
- 지정된 객체에 애스팩트를 적용해서 새로운 프록시 객체를 생성하는 과정

> **출처**
https://jojoldu.tistory.com/71
