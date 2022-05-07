import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {

        SecureRandom randomNumber = new SecureRandom();

        Character fighter1 = new Fighter(6+randomNumber.nextInt(10),6+randomNumber.nextInt(10),6+randomNumber.nextInt(10) );

        fighter1.showInfos();




    }

}
