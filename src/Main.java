import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {

        SecureRandom randomNumber = new SecureRandom();

        Character fighter1 = new Fighter(randomNumber);

        fighter1.showInfos();




    }

}
