public class Main {
    public static void main(String[] args) {
        Player Hero1 = new Player("Hero1", 1, 20, 10, 3); //สร้างผู้เล่น Hero1
        Player Hero2 = new Player("Hero2", 1, 35, 10, 2); //สร้างผู้เล่น Hero2
        Sword sw1 = new Sword(5, 50); //สร้างดาบ sw1
        Sword sw2 = new Sword(1, 10); //สร้างดาบ sw2
        Shield sh1 = new Shield(10, 20); //สร้างโล่ sh1

        Hero1.showState(); //แสดงข้อมูลของ Hero1
        Hero2.showState(); //แสดงข้อมูลของ Hero2

        Hero1.equipSword(sw2); //Hero1 ถือดาบ sw2
        Hero1.showState(); //แสดงข้อมูลของ Hero1

        Hero1.attack(Hero2); //Hero1 โจมตี Hero2
        Hero2.showState(); //แสดงข้อมูลของ Hero2

        Hero2.equipSword(sw1); //Hero2 ถือดาบ sw1
        Hero1.equipShield(sh1); //Hero1 ถือโล่ sh1
        Hero1.level_up(); //Hero1 level เพิ่มขึ้น
        sw2.level_up(); //ดาบ sw2 level เพิ่มขึ้น
        Hero1.showState(); //แสดงข้อมูลของ Hero1
        Hero2.showState(); //แสดงข้อมูลของ Hero2

        Hero1.attack(Hero2); //Hero1 โจมตี Hero2
        Hero2.attack(Hero1); //Hero2 โจมตี Hero1
        Hero1.showState(); //แสดงข้อมูลของ Hero1
        Hero2.showState(); //แสดงข้อมูลของ Hero2

        Hero2.unequipSword(); //Hero2 วางดาบ (sw1)
        Hero2.showState(); //แสดงข้อมูลของ Hero2
    }
}