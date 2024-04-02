# 와일 루프이용해 퀴즈 생성

```java

import java.util.Scanner;

public class st {
    public static void main(String[] arg) {
        final int NUMBER_OF_QUIZ = 5;
        int correct = 0;
        int count = 0;

        long start = System.currentTimeMillis();
        String out = " ";
        Scanner in = new Scanner(System.in);

        //반복문 시작 조건은 count 변수의 int 번호가 QUIZ 변수 전까지
        while (count < NUMBER_OF_QUIZ) {
            // 사용할 인트변수 생성
            int num1 = (int) (Math.random() * 10);
            int num2 = (int) (Math.random() * 10);
            //변수의 입력 내용 안내 메세지 출력
            System.out.println("what" + num1 + "-" + num2 + "?");
            //스캐너 입력 객체 생성
            int an = in.nextInt();
            //if문으로 작업 수행 랜덤 생성 변수 1과2를 뺸수가 인풋 받은 인트와 같다면 바디 출력
            if (num1 - num2 == an) {
                System.out.println("correct");
                System.out.print("!!" + "next");
                System.out.println("**" + correct + "" + count);
                //바디가 출력되면 카운트 증가
                //증가된 카운트크기가 와일 반복 컨디셔너조건과 맞으면 종료
                correct++;
                count++;
            }
        }
    }
}


```
