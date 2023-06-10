import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Inventory inventory=new Inventory();
        RestingPoint restingPoint1= new RestingPoint();
        PlayableCharacter takhs = new PlayableCharacter("Takhs",12,20,9,40,80,7,3009,19,230.4,0.9);
        Item flask = new Item("takhs"," he is not here", Item.rarityType.Common);
        Weapon sword= new Weapon("excalibur","The sword of king Arthur", Item.rarityType.Common,13 ,10,0.3,Weapon.TypeOfDamage.Slashing,Weapon.TypeOfWeapon.Sword, Weapon.TypeOfScaling.INT);
        Weapon sword2= new Weapon("Zangetsu","The sword of Ichigo", Item.rarityType.Legendary,13 ,10,0.3,Weapon.TypeOfDamage.Slashing,Weapon.TypeOfWeapon.Sword,Weapon.TypeOfScaling.DEX);
        HealthPotion hp1=new HealthPotion("Flask","very old", Item.rarityType.Rare,12);
        BuffPotion bp2=new BuffPotion("Chad Juice","You get stronger", Item.rarityType.Rare,10, BuffPotion.StatForModifing.STR);
        BuffPotion bp1=new BuffPotion("Milk","makes you stronger", Item.rarityType.Unique,3, BuffPotion.StatForModifing.STR);
        Recipe recipe1=new Recipe("MAKE A TOAST","Gives you MILK just to troll you", Item.rarityType.Common,bp1,flask,hp1,bp2);
        Armor head1= new Armor("kefali","its noice", Item.rarityType.Common,13, Armor.TypeOfArmor.Head,1);
        Armor head2= new Armor("KARANIO","its HUGE", Item.rarityType.Legendary,13, Armor.TypeOfArmor.Head,1);
        Armor chest1= new Armor("sti8os","its noice", Item.rarityType.Rare,13, Armor.TypeOfArmor.Chest,1);
        Armor hands1= new Armor("xeria","its noice", Item.rarityType.Legendary,13, Armor.TypeOfArmor.Hands,1);
        Armor legs1= new Armor("podia","its noice", Item.rarityType.Unique,13, Armor.TypeOfArmor.Legs,1);
        Skill skill1= new Skill("STRONGER", Skill.TypeOfBoosting.STR,1,1);
        Skill skill2= new Skill("STRONGER+1", Skill.TypeOfBoosting.STR,1,2);
        Skill skill3= new Skill("STRONGER+2", Skill.TypeOfBoosting.STR,1,3);
        takhs.setSkillPoints(3);
        skill2.addDependency(skill1);
        skill3.addDependency(skill2);
        SkillTree skillTree=new SkillTree();
        skillTree.addSkill(skill1);
        skillTree.addSkill(skill2);
        skillTree.addSkill(skill3);
        skillTree.unlockSkill(skill1,takhs);
        skillTree.unlockSkill(skill2,takhs);
        skillTree.unlockSkill(skill3,takhs);
        restingPoint1.setSkillTree(skillTree);
        restingPoint1.setPlayableCharacter(takhs);
        restingPoint1.setMain(hp1);
        restingPoint1.setRestoreAmount(5);

        PlayerStatus playerStatus=new PlayerStatus();
        takhs.setMaxHP(20);
        takhs.setPlayerStatus(playerStatus);
        playerStatus.setInventory(inventory);
        inventory.setPlayer(takhs);
        playerStatus.getInventory().addItemToInventory(flask);
        playerStatus.getInventory().addItemToInventory(head1);
        playerStatus.getInventory().addItemToInventory(recipe1);
        playerStatus.getInventory().addItemToInventory(head2);
        playerStatus.getInventory().addItemToInventory(hands1);
        playerStatus.getInventory().addItemToInventory(sword2);
        playerStatus.getInventory().addItemToInventory(sword);
        playerStatus.getInventory().addItemToInventory(bp1);
        playerStatus.getInventory().addItemToInventory(hp1);
        playerStatus.getInventory().addItemToInventory(hp1);
        playerStatus.getInventory().addItemToInventory(bp2);
        System.out.println(playerStatus.getInventory().getItems());
        playerStatus.getInventory().removeItemFromInventory(hp1);
        System.out.println(playerStatus.getInventory().getItems());
        playerStatus.setPlayer(takhs);
        CurrentEquipment eq1=new CurrentEquipment(head1,chest1,hands1,legs1,sword,sword);
        takhs.setCurrentEquipment(eq1);
        playerStatus.setEquipment(eq1);

    //    System.out.println(eq1.getCurrentEquipment()+" phase 1");

    /*   List<Equipment> equipment = eq1.getCurrentEquipment();
        System.out.println("Equipment of the player:");
        for (Equipment head : equipment) {
            System.out.println("- " + head.getName() + ", Disc: " + head.getDescription());
        }*/
        /*System.out.println("-----------------------------------------------");
        List<Armor> armor = eq1.getCurrentArmor();
        System.out.println("Armor of the player:");
        for (Armor pen : armor) {
            System.out.println("- " + pen.getName() + ", Disc: " + pen.getDescription()  );
        }
        System.out.println("-----------------------------------------------");
        System.out.println(playerStatus.player.getName()+" "+playerStatus.player.getHp());
        */
        //System.out.println("The hp OF TAKHS IS "+takhs.getHp());
        restingPoint1.interact();
      //  playerStatus.getInventory().openInventory();
     //   playerStatus.getInventory().openInventory();
      //  System.out.println(playerStatus.getInventory().getItems());
      // playerStatus.openPlayerStatus();
       /* List<Equipment> equipment1 = eq1.getCurrentEquipment();
        System.out.println("Equipment of the player:");
        for (Equipment head : equipment1) {
            System.out.println("- " + head.getName() + ", Disc: " + head.getDescription());
        }*/


    }
}