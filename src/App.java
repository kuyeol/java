import java.util.Scanner;


public class App {
    public static void main(String[] args)  {

      Scanner scanner = new Scanner(System.in);

        int value;
        do {
            value = scanner.nextInt();
            System.out.println(value);
        } while (value != 0);
}
 }