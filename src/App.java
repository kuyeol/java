//import java.util.Scanner;
//
//public class App {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int sum = 0;
//        while (true) {
//            int num = scanner.nextInt();
//            if (num == 0) {
//                break;
//            }
//            sum += num;
//        }
//        System.out.println("The sum of the sequence is: " + sum);
//    }
//}

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int num;
        do {
            num = scanner.nextInt();
            if (num != 0) {
                sum += num;
            }
        } while (num != 0);
        System.out.println("The sum of the sequence is: " + sum);
    }
}