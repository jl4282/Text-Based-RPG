
public class Orc extends Person {
    public static int orcArray[][];
    static String sOName;
    static int sOHealth;
    static int sOAttack;
    static int sOSwordA;
    static String sOWeakness;
    static int sODefense;
    static int sEXP;

    public Orc()
    {
        this(1);
    }
    public Orc(int level)
    {
        if (level <= 1)
        {
            level = 1;
            name = "Orc Level " + level;
            health = 100;
            attack = 10;
            swordA = 10;
            defense = 5;
            weakness = "Fire";
            sEXP = 10;
            
    
        }
        else
        {
        name = "Orc Level " + level;
        health = 100 + level*2;
        attack = 10 + level*2;
        swordA = 10 + level*2;
        defense = 5 + level*2;
        weakness = "Fire";
        sEXP = 10 + level*2;
        }
        
        sOName = name;
        sOHealth = health;
        sOAttack = attack;
        sOSwordA = swordA;
        sOWeakness = weakness;
        sODefense = defense;
    }
    
    public Orc(String man)
    {
        name = sOName;
        health = sOHealth;
        attack = sOAttack;
        swordA = sOSwordA;
        weakness = sOWeakness;
        defense = sODefense;
    }

}//end orc
