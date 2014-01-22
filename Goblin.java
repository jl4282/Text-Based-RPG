
public class Goblin extends Person {
    public static int orcArray[][];
    static String sOName;
    static int sOHealth;
    static int sOAttack;
    static int sOSwordA;
    static String sOWeakness;
    static int sODefense;
    static int sEXP;

    public Goblin()
    {
        this(1);
    }
    public Goblin(int level)
    {
        if (level <= 1)
        {
            level = 1;
            name = "Goblin Level " + level;
            health = 80;
            attack = 25;
            swordA = 25;
            defense = 5;
            weakness = "Fire";
            sEXP = 20;


        }
        else
        {
        name = "Goblin Level " + level;
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

    public Goblin(String man)
    {
        name = sOName;
        health = sOHealth;
        attack = sOAttack;
        swordA = sOSwordA;
        weakness = sOWeakness;
        defense = sODefense;
    }

    public int [][] Goblin(char difficulty)
    {
        int [][] goblinArray = new int [2][5];
        if ((difficulty == 'e' )||(difficulty == 'E' ))
        {
           Goblin goblin = new Goblin (Player.currentPlayer.level - ((int)(Math.random()*3)));

            //make array

            goblinArray [0][0] = goblin.sOHealth;
            goblinArray [0][1] = goblin.sOAttack;
            goblinArray [0][2] = goblin.sOSwordA;
            goblinArray [0][3] = goblin.sODefense;
            goblinArray [0][4] = goblin.sEXP;

            Goblin goblin2 = new Goblin (Player.currentPlayer.level - ((int)(Math.random()*3)));
            goblinArray [1][0] = goblin2.sOHealth;
            goblinArray [1][1] = goblin2.sOAttack;
            goblinArray [1][2] = goblin2.sOSwordA;
            goblinArray [1][3] = goblin2.sODefense;
            goblinArray [1][4] = goblin2.sEXP;

        }
        return orcArray;
    }

}//end orc
