# Windows Env 
### 에러나면 에러메세지 출려된 경로 먼저 확인해보자!

## kafka 실행 Script

> 카프카 위치 경로 확인 후 해당경로에 실행되도록 이동 또는 경로 지정 
> 주키퍼 카프카 순으로 실행
> bat->propertie 참조하니 설정 변경필요할시 해당 디렉토리 구성 수정 하면됨
```SHELL

.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties  

.\bin\windows\kafka-server-start.bat .\config\server.properties

```



## 카프카 이벤트 스트림 콘솔 테스팅
```
bin/windows/kafka-console-consumer.bat --topic wordcount-output --from-beginning --bootstrap-server localhost:9092  --property print.key=true

bin/windows/kafka-topics.bat --create --topic quickstart-events --bootstrap-server localhost:9092

bin/windows/kafka-topics.bat --describe --topic quickstart-events --bootstrap-server localhost:9092

bin/windows/kafka-console-producer.bat --topic quickstart-events --bootstrap-server localhost:9092

bin/windows/kafka-console-consumer.bat --topic quickstart-events --from-beginning --bootstrap-server localhost:9092

```


