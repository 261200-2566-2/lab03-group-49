//class ของดาบ
public class Sword {
    private int level;
    private double damage, d;

    //constructor
    Sword(int level, double d) {
        this.level = level; //level ของดาบ
        this.d = d; //พลังโจมตีเริ่มต้นของดาบ
        update_state();
    }

    public int getLevelSword(){
        return level;
    } //level ของดาบ

    public double getDamageSword(){
        return damage;
    } //พลังโจมตีของดาบ

    public void level_up(){ //เพิ่ม level ของดาบ
        level++;
        update_state();
    }

    //update damage ของดาบ (พลังโจมตีของผู้เล่นเพิ่มขึ้น)
    private void update_state(){
        damage = d * (1 + 0.1 * (level - 1));
    }
}
