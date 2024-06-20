# 포스트맨 api 테스트 정리
> [!CAUTION]
> 저장 후 테스트 실행!

재사용 변수 정의는 env 에서 변수명 지정
상수는  value 정의
변수는  value를 정의하지 않는다
> 변수 value를 parse 하는 스크립트를 해당 리퀘스트에 작성 후 동일 변수명(variable) 을 정의 하면 {{변수명}} 으로 사용

JSON데이터 스크립트 예시

```javascript
var 파스데이터저장객체명 = JSON.parse(responseBody)
pm.environment.set("변수명", 파스데이터저장객체명.가져올데이터키이름);


 var data = JSON.parse(responseBody);
 pm.environment.set("token", data.access_token);

```























<details>


> [!NOTE]
> Useful information that users should know, even when skimming content.

> [!TIP]
> Helpful advice for doing things better or more easily.

> [!IMPORTANT]
> Key information users need to know to achieve their goal.

> [!WARNING]
> Urgent info that needs immediate user attention to avoid problems.

> [!CAUTION]
> Advises about risks or negative outcomes of certain actions.


</details>
