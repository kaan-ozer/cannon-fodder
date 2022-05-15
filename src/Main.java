import java.security.SecureRandom;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        SecureRandom randomNumber = new SecureRandom();

       Fighter fighter1 = new Fighter(randomNumber);
       Healer healer1 = new Healer(randomNumber);
       Tank tank1 = new Tank(randomNumber);

        ArrayList<Character> characters = new ArrayList<>();
        characters.add(fighter1);
        characters.add(healer1);
        characters.add(tank1);

        for(Character character : characters) {
            character.showInfos();
            System.out.println("----------------------------------");
        }




    }

}
