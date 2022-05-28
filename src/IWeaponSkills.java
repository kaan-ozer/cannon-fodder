import java.util.ArrayList;

public interface IWeaponSkills {

    public abstract void attack(Character chosenEnemy, Character chosenCharacter);
    public abstract void SpecialAction(Character chosenEnemy, ArrayList<Character> characters);
}
