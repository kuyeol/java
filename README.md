# Windows Env 

kafka 실행 Script

> 카프카 위치 경로 확인 후 해당경로에 실행되도록 이동 또는 경로 지정 
> 주키퍼 카프카 순으로 실행
> bat->propertie 참조하니 설정 변경필요할시 해당 디렉토리 구성 수정 하면됨
```SHELL

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties  

.\bin\windows\kafka-server-start.bat .\config\server.properties

```
