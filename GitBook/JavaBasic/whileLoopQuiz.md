# 와일 루프이용해 퀴즈 생성

<pre class="language-java" data-title="" data-overflow="wrap" data-line-numbers data-full-width="true"><code class="lang-java">
import java.util.Scanner;

public class st {
    public static void main(String[] arg) {
<strong>        // 인트 타입 객체 값 초기화
</strong><strong>        //final 사용해 값이 변경되지 않도록
</strong>        final int NUMBER_OF_QUIZ = 5;
        int correct = 0;
        int count = 0;
<strong>        //문자열초기화
</strong>        String out = " ";
<strong>        //스캐너 객체 생성
</strong>        Scanner in = new Scanner(System.in);

<strong>        //반복문 시작 조건은 count 변수의 int 번호가 QUIZ 변수 전까지
</strong>        while (count &#x3C; NUMBER_OF_QUIZ) {
            // 사용할 인트변수 생성
            int num1 = (int) (Math.random() * 10);
            int num2 = (int) (Math.random() * 10);
            //변수의 입력 내용 안내 메세지 출력
            System.out.println("what" + num1 + "-" + num2 + "?");
<strong>            //스캐너 입력 객체 생성
</strong>            int an = in.nextInt();
<strong>            //if문으로 작업 수행 랜덤 생성 변수 1과2를 뺸수가 인풋 받은 인트와 같다면 바디 출력
</strong>            if (num1 - num2 == an) {
                System.out.println("correct");
                System.out.print("!!" + "next");
                System.out.println("**" + correct + "" + count);
<strong>                //바디가 출력되면 카운트 증가
</strong><strong>                //증가된 카운트크기가 와일 반복 컨디셔너조건과 맞으면 종료
</strong>                correct++;
                count++;
            }
        }
    }
}


</code></pre>
