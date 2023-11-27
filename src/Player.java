//class ของผู้เล่น
public class Player {
    private String name;
    private int level;
    private double max_hp, hp, max_mana, mana, d, damage, r, max_speed, s, defense;
    private Shield e_shield;
    private Sword e_sword;

    //constructor
    public Player(String name,int level,double d, double s,double r){
        this.name = name; //ชื่อของผู้เล่น
        this.level = level; //level ของผู้เล่น
        this.d = d; //พลังโจมตีของผู้เล่น
        this.s = s; //พลังป้องกันของผู้เล่น
        this.r = r; //ค่าความเร็วพื้นฐานของผู้เล่น (base speed)
        hp = 100 + 10*(level-1); //ค่าพลังชีวิตของผู้เล่น
        mana = 50 + 2*(level-1); //ค่าพลังเวทมนตร์ของผู้เล่น
        e_sword = null; //ไม่ถือดาบ
        e_shield = null; //ไม่ถือโล่
    }

    public void level_up() { level++;} //เพิ่ม level ของผู้เล่น

    private void update_state(){ //update ข้อมูลของผู้เล่น
        max_hp = 100 + 10*(level-1); //ค่า max hp ของผู้เล่น
        max_mana = 50 + 2*(level-1); //ค่า max mana ของผู้เล่น
        max_speed = r + (r * (0.1 + 0.03*(level-1))); //ค่า max speed ของผู้เล่น
        damage = d * (1 + 0.1*(level-1)); //ค่า damage (โจมตี)
        defense = s * (1 + 0.05*(level-1)); //ค่า defense (ป้องกัน)
        if(e_sword != null){ //ถ้าผู้เล่นถือดาบ
            damage = damage + e_sword.getDamageSword(); //พลังโจมตีเพิ่มขึ้น
            max_speed -= (0.1 + 0.04*e_sword.getLevelSword()); //ค่า max speed ลดลง
        }
        if(e_shield != null){ //ถ้าผู้เล่นถือโล่
            defense = defense + e_shield.getDefenseShield(); //พลังป้องกันเพิ่มขึ้น
            max_speed -= (0.1 + 0.08*e_shield.getLevelShield()); //ค่า max speed ลดลง
        }
        if(max_speed < 0 ){ //ถ้าค่า max speed น้อยกว่า 0
            max_speed = 0; //set max speed = 0
        }
    }

    public void showState(){ //บอกข้อมูลของผู้เล่น
        update_state(); //เรียกใช้ function update_state() เพื่อ update ค่าต่างๆ แล้วแสดงค่านั้น
        System.out.println("|------------------------------|");
        System.out.println("    Name : " + name + " (Level " + level + ")");
        System.out.println("    HP/Max Hp : " + hp + "/" + max_hp);
        System.out.println("    Mana/Max Mana : " + mana + "/" + max_mana);
        System.out.println("    Base Speed : " + r);
        System.out.println("    Max Speed : " + max_speed);
        System.out.println("    Damage : " + damage);
        System.out.println("    Defense : " + defense);
        if(e_sword != null){ //ถ้าผู้เล่นถือดาบ
            System.out.println("    equipSword");
        }
        if(e_shield != null){ //ถ้าผู้เล่นถือโล่
            System.out.println("    equipShield");
        }
        System.out.println("|------------------------------|");
        System.out.println(" ");

    }


    public void equipSword(Sword sword){ //function ถือดาบ
        unequipSword(); //เรียกใช้ function unequipSword() ก่อน (วางดาบก่อน)
        e_sword = sword;
    }


    public void unequipSword() { e_sword = null;} //function วางดาบ


    public void equipShield(Shield shield){ //function ถือโล่
        unequipShield(); //เรียกใช้ function unequipShield() ก่อน (วางโล่ก่อน)
        e_shield = shield;
    }

    public void unequipShield() { e_shield = null;} //function วางโล่

    public void attack(Player p) { p.takeDamage(damage);} //function โจมตี

    private void takeDamage(double d){ //function แสดงค่าพลังชีวิตของผู้เล่นหลังจากถูกโจมตี
        double dam = defense - d; //ค่าความเสียหาย = ค่าพลังป้องกัน - ค่าพลังโจมตีที่ได้รับ
        if(dam > 0){ //ถ้าค่าความเสียหาย > 0 (defense > d)
            dam = 0; //ให้ค่าความเสียหายเป็น 0
        }
        hp += dam; //ค่าพลังชีวิตลดลง (ค่าความเสียหายต้องติดลบ เนื่องจากถูกโจมตี)
        if(hp < 0){ //ถ้าค่าพลังชีวิต น้อยกว่า 0
            hp = 0; //ให้ค่าพลังชีวิตเหลือ 0
        }
    }
}