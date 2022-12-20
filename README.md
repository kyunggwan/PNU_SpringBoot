## Mission 1.

list 데이터를 생성해서 요청하는 정보를 제공하는 버전
기본 구조는 Controller - Service로 구성되어 있다. - MemberController.java - MemberService.java
list 데이터는 Service에서 생성해서 가지고 있다가 요청에 따른 데이터를 제공한다.


## Mission 2.

H2 Database에 저장된 데이터를 제공하는 버전
Mission1과 비교해서 Dao 계층이 하나 더 추가된다.
구조는 Controller - Service - Dao 로 수정된다.
MemberController.java
MemberService.java
MemberDao.java


## Mission 3.

Mission1과 Mission2를 통합한 버전
Mission2의 MemberDao를 MemberDaoH2Impl로 변경하고
MemberDaoH2Impl2에서 MemberDao로 인터페이스를 추출
Mission1의 MemberService에서 list 데이터를 제공하던 것을 MemberDao 구현체인 MemberDaoListImpl을 만들어서 정보를 제공


## Mission 4.

Mission3에서 Dao 객체를 하나 더 추가한 버전
추가한 Dao는 Log를 남기는 기능을 가지며
인터페이스 LogDao와 DB 저장 구현체 LogDaoH2Impl과 파일 저장 구현체 LogDaoFileImpl로 구성된다.


## Mission 5.

Mission4에서 어노테이션을 이용해서 의존성 주입이 되도록 수정한 버전


## Mission 51.

Mission5에서 jdbc Connection을 만들어서 사용하는 방식을
JdbcTemplate를 이용하는 방식으로 변경한 버전


## Practice

Mission을 연습하는 WorkSpace
