//class ของโล่
public class Shield {
    private int level;
    private double defense, s;

    //constructor
    Shield(int level, int s){
        this.level = level; //level ของโล่
        this.s = s; //พลังป้องกันเริ่มต้นของโล่
        update_state();
    }

    public int getLevelShield(){
        return level;
    } //level ของโล่

    public double getDefenseShield(){
        return defense;
    } //พลังป้องกันของโล่

    public void level_up(){ //เพิ่ม level ของโล่
        level++;
        update_state();
    }

    //update defense ของโล่ (พลังป้องกันของผู้เล่นเพิ่มขึ้น)
    private void update_state(){ defense = s * (1 + 0.05 * (level - 1)); }
}
