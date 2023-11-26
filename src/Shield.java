public class Shield {
    private int level;

    private double defense,s;


    Shield(int level, int s){
        this.level = level;
        this.s = s;
        update_state();
    }

    public int getLevelShield(){
        return level;
    }

    public double getdefenseShield(){
        return defense;
    }

    public void level_up(){
        level++;
        update_state();
    }


    private void update_state(){
        defense = s * (1 + 0.05 * (level - 1));
    }
}
