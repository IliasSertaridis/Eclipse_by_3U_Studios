import java.util.ArrayList;
import java.util.List;

public class SkillTree {
    private List<Skill> skills;

    public SkillTree() {
        skills = new ArrayList<>();
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void unlockSkill(Skill skill,PlayableCharacter playableCharacter) {
        if (!skill.hasUnlockedDependencies()) {
            System.out.println("Cannot unlock " + skill.getName() + " yet. Dependencies are not met.");
            return;
        }

        if(skill.getSkillPointNeeded()> playableCharacter.getSkillPoints()){
            System.out.println("Cannot unlock "+ skill.getName()+" yet. You don't have enough skill points.");
            return;
        }
        skill.setLevel(1);
        playableCharacter.setSkillPoints(playableCharacter.getSkillPoints()- skill.getSkillPointNeeded());
        System.out.println(skill.getName() + " unlocked!");

        for (Skill dependentSkill : skills) {
            if (dependentSkill.checkIfDepends(skill)) {
                dependentSkill.removeDependency(skill);
            }
        }
    }
    public void displayAvailableSkills() {
        System.out.println("Available skills to unlock:");
        for (Skill skill : skills) {
            if (skill.getLevel() == 0 && skill.hasUnlockedDependencies()) {
                System.out.println(skill.getName());
            }
        }
    }
}
