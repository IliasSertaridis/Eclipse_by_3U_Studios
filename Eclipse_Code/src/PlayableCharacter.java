import java.util.*;

public class PlayableCharacter extends Character{
    private int money;
    private int level;
    private double equipLoad;
    private int defenceModifier;
    private CurrentEquipment currentEquipment;
    private PlayerStatus playerStatus;
    private Race race;
    public PlayableCharacter(String name, int hp, int strength, int dexterity, int vitality, int intelligence, int wisdom, int money, int level, double equipLoad) {
        super(name, hp, strength, dexterity, vitality, intelligence, wisdom);
        this.money = money;
        this.level = level;
        this.equipLoad = equipLoad;
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

    public int getDefenceModifier() {
        return defenceModifier;
    }

    public void setDefenceModifier(int defenceModifier) {
        this.defenceModifier = defenceModifier;
    }

    public CurrentEquipment getCurrentEquipment() {
        return currentEquipment;
    }

    public void setCurrentEquipment(CurrentEquipment currentEquipment) {
        this.currentEquipment = currentEquipment;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        this.playerStatus = playerStatus;
    }

    public Map<String, Integer> getPlayerStats(){
        Map<String, Integer> playerStats = new HashMap<>();
        playerStats.put(getName(),getHp());
        return playerStats;
    }

    //function that takes the race of a merchant and returns the reputation of the character with that merchant
    public int getReputationWithTypeOfMerchant(Merchant merchant){
        String raceofmerch = String.valueOf(merchant.getRace());
        //loop for accessing the map with the reputation of the character with the different races of merchants
        //and when it finds the one we want it returns it
        for(Map.Entry<String, Integer> entry : race.getReputationWithMerchantRaces().entrySet()){
            // if the key value of the map is the same with the race of the merchant,return the reputation with that
            //race, else return 0
            if(raceofmerch == entry.getKey()){
                return entry.getValue();
            }
        }
        return 0;
    }

    public void setDefenceMod(){
        this.defenceModifier = currentEquipment.getTotalDefense();
    }

    public void setBaseStats(PlayableCharacter pc){
        boolean setStats = false;
        int str=0;
        int dex=0;
        int vit=0;
        int intel=0;
        int wis=0;
        int count=0;
        System.out.println("You have 55 points to distribute between the following 5 stats:");
        System.out.println("1. Strength: affects your equipload and the ability to use some weapons");
        System.out.println("2. Dexterity: affects your speed");
        System.out.println("3. Vitality: affects your resistance to status effects");
        System.out.println("4. Intelligence: affects your ability to use spells that scale with this stat");
        System.out.println("5. Wisdom: affects your ability to use spells that scale with this stat");
        System.out.println("To add a point first write 'add' and then the number associated with the stat as presented above.");
        System.out.println("To remove a point first write 'remove' and then the number associated with the stat as presented above.");
        System.out.println("Whenever you feel satisfied with your stats, type 'done'.");
        System.out.println("If you wish to see how you have distributed your points type 'show'.");
        Scanner scanner = new Scanner(System.in);
        while (!setStats){
            String choice = scanner.nextLine();
            if (choice=="add"){
                int stat = scanner.nextInt();
                switch (stat){
                    case 1:
                        str = str + 1;
                        count++;
                        pc.setStrength(str);
                        break;
                    case 2:
                        dex = dex + 1;
                        count++;
                        pc.setDexterity(dex);
                        break;
                    case 3:
                        vit = vit + 1;
                        count++;
                        pc.setVitality(vit);
                        break;
                    case 4:
                        intel = intel + 1;
                        count++;
                        pc.setIntelligence(intel);
                        break;
                    case 5:
                        wis = wis + 1;
                        count++;
                        pc.setWisdom(wis);
                        break;
                    default:
                        System.out.println("You typed a false number. please try again, and make sure to type 'add' first.");
                }
            } else if (choice=="remove") {
                int stat = scanner.nextInt();
                switch (stat){
                    case 1:
                        str = str - 1;
                        count--;
                        pc.setStrength(str);
                        break;
                    case 2:
                        dex = dex - 1;
                        count--;
                        pc.setDexterity(dex);
                        break;
                    case 3:
                        vit = vit - 1;
                        count--;
                        pc.setVitality(vit);
                        break;
                    case 4:
                        intel = intel - 1;
                        count--;
                        pc.setIntelligence(intel);
                        break;
                    case 5:
                        wis = wis - 1;
                        count--;
                        pc.setWisdom(wis);
                        break;
                    default:
                        System.out.println("You typed a false number. please try again, and make sure to type 'remove' first.");
                }
            } else if (choice=="done") {
                if (count<55){
                    System.out.println("You have not distributed all the available points. Do you wish to end this process?");
                    System.out.println("For 'Yes' type 1, for 'No' type 2.");
                    int yer = scanner.nextInt();
                    if (yer==1) setStats = true;
                    else if (yer==2) {
                        break;
                    } else {
                        System.out.println("The input you provided is incorrect. Please try again.");
                    }
                } else {
                    setStats = true;
                }
            } else if (choice=="show") {
                System.out.println("Your current stats are: ");
                System.out.println("Strength: " + pc.getStrength());
                System.out.println("Dexterity: " + pc.getDexterity());
                System.out.println("Vitality: " + pc.getVitality());
                System.out.println("Intelligence: " + pc.getIntelligence());
                System.out.println("Wisdom: " + pc.getWisdom());
            } else {
                System.out.println("The input you provided is incorrect. Please try again.");
            }
            if (count==55){
                System.out.println("You have distributed all the available points. Your current stats are: ");
                System.out.println("Strength: " + pc.getStrength());
                System.out.println("Dexterity: " + pc.getDexterity());
                System.out.println("Vitality: " + pc.getVitality());
                System.out.println("Intelligence: " + pc.getIntelligence());
                System.out.println("Wisdom: " + pc.getWisdom());
                System.out.println("If you are satisfied with your current stats, type 'done'.");
                String in = scanner.nextLine();
                if (in=="done") setStats = true;
                else System.out.println("The input you provided is incorrect. Please try again.");
            }
        }
    }
}
