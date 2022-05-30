import java.util.ArrayList;

public interface IWeaponSkills {

    public abstract void attack(Character chosenEnemy, Character chosenCharacter);
    public abstract void SpecialAction(ArrayList<Character> characters, ArrayList<Enemy> enemies, Character chosenCharacter);
}
