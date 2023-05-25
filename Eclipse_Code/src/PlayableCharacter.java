import java.util.ArrayList;
import java.util.List;

public class PlayableCharacter extends Character{
    private int money;
    private int level;
    private double equipLoad;
    private double defenceModifier;

    public PlayableCharacter(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, int money, int level, double equipLoad, double defenceModifier) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.money = money;
        this.level = level;
        this.equipLoad = equipLoad;
        this.defenceModifier = defenceModifier;
    }

    public PlayableCharacter(){
        super();
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getEquipLoad() {
        return equipLoad;
    }

    public void setEquipLoad(double equipLoad) {
        this.equipLoad = equipLoad;
    }

    public double getDefenceModifier() {
        return defenceModifier;
    }

    public void setDefenceModifier(double defenceModifier) {
        this.defenceModifier = defenceModifier;
    }

    public List<Double> getPlayerStats(){
        List<Double> playerStats = new ArrayList<Double>();
        playerStats.add((double)getHp());
        playerStats.add((double) getStrength());
        playerStats.add((double) getDexterity());
        playerStats.add((double) getVitality());
        playerStats.add((double) getIntelligence());
        playerStats.add((double) getWisdom());
        playerStats.add((double) getLevel());
        playerStats.add(getEquipLoad());
        playerStats.add(getDefenceModifier());
        return playerStats;
    }


}
