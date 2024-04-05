#auth #fillter #map #hash #vaild

해싱알고리즘  로직 확인 코드

package org.example;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Scanner;

public class PasswordStorageWithSalt {

    private static final String SALT_SEPARATOR = ":";


    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);
        System.out.println("입력");
        String username = sc.nextLine();
        System.out.println("입력");
        String password = sc.nextLine();

        try {
            // Generate a salt
            String salt = generateSalt();
            System.out.println("라인32:main ##"+salt);
            // Hash the password with the salt
            String hashedPassword = hashPassword(password, salt);
            System.out.println("라인35:main ##"+username+ hashedPassword+ salt);
            // Store the user in the database
            storeUserInDatabase(username, hashedPassword, salt);
            System.out.println("라인35:main ##"+username+ hashedPassword+ salt);
            System.out.println("main----------User stored successfully with hashed password and salt.------------##");
            System.out.println("라인40: hashPassword솔트 패스워드## "+ password+SALT_SEPARATOR+salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static void storeUserInDatabase(String userName, String hashedPassword, String salt) {
        List<String> userMap=new ArrayList<>();
        System.out.println("라인47: storeUserInDatabase 맵 추가\"+ ##"+userMap);
       userMap.add(userName);
        System.out.println("라인49: storeUserInDatabase 맵 추가\": ##"+userMap);
       userMap.add(hashedPassword);
        System.out.println("라인51: storeUserInDatabase 맵 추가\" ##"+userMap);
       userMap.add(salt);
        System.out.println("라인53: storeUserInDatabase 맵 추가##"+userMap);


    }

    // Method to generate a salt
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[64];
        System.out.println("라인62:generateSalt 바이트배열 솔트 객체 생성 ##"+salt);
        random.nextBytes(salt);
        System.out.println("라인64:generateSalt 솔트 바이트 랜덤 메서드추가 ##"+salt);
        return Base64.getEncoder().encodeToString(salt);

    }

    // Method to hash the password with SHA-256 and a salt
    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        System.out.println("라인72: hashPassword다이제스트 ##"+digest);
        String saltedPassword = password + SALT_SEPARATOR + salt;
        System.out.println("라인74: hashPassword솔트 패스워드 -----"+saltedPassword +"----"+ password+"-----"+SALT_SEPARATOR+
                "------"+salt);
        byte[] hash = digest.digest(saltedPassword.getBytes(StandardCharsets.UTF_8));
        System.out.println("라인76: hashPassword해쉬 다이제스트 ##"+hash);
        return Base64.getEncoder().encodeToString(hash);
    }

    // Method to store the user in the database

}