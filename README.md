# Toy Project
##개발환경
###B-E
* IDE : intelliJ
* Spring boot : 2.4.4
* DataBase : MariaDb
* Orm : JPA(queryDsl)
* JDK : 1.8
* Tomcat : embedded Tomcat

###F-E
* IDE : Visual Studio Code
* Framework : React (17.0.0-12adaffef)
* node version : v14.18.1

##실행방법
###B-E
* 프로젝트 환경 설정 후, ToyApplication Start
* DataBase의 경우, AWS RDS 사용
###F-E
* 프로젝트 내려 받은 후, terminal 에 npm run start 실행하여 서버 구동

##문제 해결 전략
* 고객의 문의에 대하여 상태를 답변대기 / 상담원 지정완료 / 답변완료 3가지로 나누었으며
상담원 지정 후, 특정기간내에 답변을 하지 못할 경우, 다시 답변 대기 상태로 두어, 다른 상담원에게 지정이 가능하도록
구성함.
* (실제 코드내에서 기간 체크가 구성되어있지는 않음.)
* 상담원 등록의 경우, 계정등록 이후 슈퍼관리자에 의해 계정의 활성화여부를 설정할 수 있도록 설계함.
* (실제 코드내에선 Active로 설정하지만, 슈퍼관리자까지 염두해둠)
* 상담원의 문의 리스트는 답변대기 상태와 본인에게 지정된 상태의 문의만 조회하며
이미 답변이 완료된 문의에 대해서는 조회하지 않음.
* 각 API별 결과코드는 프로젝트 내에서 지정하였으며, 해당 코드에 따라 정상/실패 여부를 판단할 수 있도록 지정함.
* 이미 답변이 된 문의에 대해서도 재답변을 할 수 있도록 답변등록 API는 구성하였으나,  미답변 목록만 조회한다는 조건이 있어
답변은 한개만 등록할 수 있음.
* 유효성 체크는 server를 통해 이루어지며, 그에 따른 결과코드를 가지고 client에서 동작함.
