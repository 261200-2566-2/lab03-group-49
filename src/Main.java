/.../
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Player Hero1 = new Player(name: "Hero", level:1, d:20, s:10, r:3);
        Player Hero2 = new Player(name:"Hero2", level:1, d:35, s:10, r:2);
        Sword E = new Sword(level:5, d:50);
        Sword B = new Sword(level:1, d:10);
        Shield D = new Shield(level:10, s:20);

        Hero1.showstate();
        Hero2.showstate();
        Hero1.equipSword(B);
        Hero1.showstate();

        Hero1.attack(Hero2);
        Hero2.showstate();

        Hero2.equipSword(E);
        Hero1.equipShield(D);
        Hero1.level_up();
        B.level_up();
        Hero1.showstate();
        Hero2.showstate();

        Hero1.attack(Hero2);
        Hero2.attack(Hero1);

        Hero1.showstate();
        Hero2.showstate();

    }
}