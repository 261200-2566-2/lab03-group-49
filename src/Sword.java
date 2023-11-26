public class Sword {
    private int level;


    private double damage,d;

    Sword(int level, double d) {
        this.level = level;
        this.d = d;
        update_state();
    }

    public int getLevelSword(){
        return level;
    }

    public double getdamageSword(){
        return damage;
    }

    public void level_up(){
        level++;
        update_state();
    }


    private void update_state(){
        damage = d * (1 + 0.1 * (level - 1));
    }
}
