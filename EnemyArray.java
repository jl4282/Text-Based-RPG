/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NYU User
 */
public class EnemyArray {
    public static int enemyArrayFinal[][];
    public int enemyArray[][];
    public static int exp = 0;
    public static int killed = 0;
    public static int turnCount = 0; //can keep track of how many turns in the fighting sequence --> to add bleeding and damage per turn ---> time limits on restore health and other spells
    public EnemyArray(char difficulty)
    {

        enemyArray = new int [3][6];
        if ((int)(Math.random()*10)> 5)
        {
            if ((difficulty == 'e' )||(difficulty == 'E' ))
            {
               Orc orc = new Orc (Player.currentPlayer.level - ((int)(Math.random()*3)));

                //make array

                enemyArray [0][0] = orc.sOHealth;
                enemyArray [0][1] = orc.sOAttack;
                enemyArray [0][2] = orc.sOSwordA;
                enemyArray [0][3] = orc.sODefense;
                enemyArray [0][4] = orc.sEXP;
                enemyArray [0][5] = 0; //code for which enemy

                Orc orc2 = new Orc (Player.currentPlayer.level - ((int)(Math.random()*3)));
                enemyArray [1][0] = orc2.sOHealth;
                enemyArray [1][1] = orc2.sOAttack;
                enemyArray [1][2] = orc2.sOSwordA;
                enemyArray [1][3] = orc2.sODefense;
                enemyArray [1][4] = orc2.sEXP;
                enemyArray [0][5] = 0;
                enemyArrayFinal = new int [3][6];
            }
            if ((difficulty == 'm' )||(difficulty == 'M' ))
            {
               Orc orc = new Orc (Player.currentPlayer.level);

                //make array

                enemyArray [0][0] = orc.sOHealth;
                enemyArray [0][1] = orc.sOAttack;
                enemyArray [0][2] = orc.sOSwordA;
                enemyArray [0][3] = orc.sODefense;
                enemyArray [0][4] = orc.sEXP;
                enemyArray [0][5] = 0;

                Orc orc2 = new Orc (Player.currentPlayer.level - ((int)(Math.random()*3)));
                enemyArray [1][0] = orc2.sOHealth;
                enemyArray [1][1] = orc2.sOAttack;
                enemyArray [1][2] = orc2.sOSwordA;
                enemyArray [1][3] = orc2.sODefense;
                enemyArray [1][4] = orc.sEXP;
                enemyArray [1][5] = 0;
                enemyArrayFinal = new int [3][6];
            }
            if ((difficulty == 'h' )||(difficulty == 'H' ))
            { //make orc array
                Orc orc = new Orc (Player.currentPlayer.level);
                enemyArray [0][0] = orc.sOHealth;
                enemyArray [0][1] = orc.sOAttack;
                enemyArray [0][2] = orc.sOSwordA;
                enemyArray [0][3] = orc.sODefense;
                enemyArray [0][4] = orc.sEXP;
                enemyArray [0][5] = 0;

                Orc orc2 = new Orc (Player.currentPlayer.level + ((int)(Math.random()*3)));
                enemyArray [1][0] = orc2.sOHealth;
                enemyArray [1][1] = orc2.sOAttack;
                enemyArray [1][2] = orc2.sOSwordA;
                enemyArray [1][3] = orc2.sODefense;
                enemyArray [1][4] = orc.sEXP;
                enemyArray [1][5] = 0;

                Goblin goblin = new Goblin (Player.currentPlayer.level + 2);
                enemyArray [2][0] = goblin.sOHealth;
                enemyArray [2][1] = goblin.sOAttack;
                enemyArray [2][2] = goblin.sOSwordA;
                enemyArray [2][3] = goblin.sODefense;
                enemyArray [2][4] = goblin.sEXP;
                enemyArray [2][5] = 1;
                enemyArrayFinal = new int [3][6];
            }
        }
        else
        {
            if ((difficulty == 'e' )||(difficulty == 'E' ))
            {
               Goblin goblin = new Goblin (Player.currentPlayer.level - ((int)(Math.random()*3)));

                //make array

                enemyArray [0][0] = goblin.sOHealth;
                enemyArray [0][1] = goblin.sOAttack;
                enemyArray [0][2] = goblin.sOSwordA;
                enemyArray [0][3] = goblin.sODefense;
                enemyArray [0][4] = goblin.sEXP;
                enemyArray [0][5] = 1;

                Goblin goblin2 = new Goblin (Player.currentPlayer.level - ((int)(Math.random()*3)));
                enemyArray [1][0] = goblin2.sOHealth;
                enemyArray [1][1] = goblin2.sOAttack;
                enemyArray [1][2] = goblin2.sOSwordA;
                enemyArray [1][3] = goblin2.sODefense;
                enemyArray [1][4] = goblin2.sEXP;
                enemyArray [1][5] = 1;
                enemyArrayFinal = new int [3][6];
            }
            if ((difficulty == 'm' )||(difficulty == 'M' ))
            {
               Goblin goblin = new Goblin (Player.currentPlayer.level);

                //make array

                enemyArray [0][0] = goblin.sOHealth;
                enemyArray [0][1] = goblin.sOAttack;
                enemyArray [0][2] = goblin.sOSwordA;
                enemyArray [0][3] = goblin.sODefense;
                enemyArray [0][4] = goblin.sEXP;
                enemyArray [0][5] = 1;

                Goblin goblin2 = new Goblin (Player.currentPlayer.level - ((int)(Math.random()*3)));
                enemyArray [1][0] = goblin2.sOHealth;
                enemyArray [1][1] = goblin2.sOAttack;
                enemyArray [1][2] = goblin2.sOSwordA;
                enemyArray [1][3] = goblin2.sODefense;
                enemyArray [1][4] = goblin2.sEXP;
                enemyArray [1][5] = 1;
                enemyArrayFinal = new int [3][6];
            }
            if ((difficulty == 'h' )||(difficulty == 'H' ))
            { //make orc array
                Orc orc = new Orc (Player.currentPlayer.level);
                enemyArray [0][0] = orc.sOHealth;
                enemyArray [0][1] = orc.sOAttack;
                enemyArray [0][2] = orc.sOSwordA;
                enemyArray [0][3] = orc.sODefense;
                enemyArray [0][4] = orc.sEXP;
                enemyArray [0][5] = 0;

                Goblin goblin2 = new Goblin (Player.currentPlayer.level + ((int)(Math.random()*3)));
                enemyArray [1][0] = goblin2.sOHealth;
                enemyArray [1][1] = goblin2.sOAttack;
                enemyArray [1][2] = goblin2.sOSwordA;
                enemyArray [1][3] = goblin2.sODefense;
                enemyArray [1][4] = goblin2.sEXP;
                enemyArray [1][5] = 1;

                Goblin goblin3 = new Goblin (Player.currentPlayer.level + 2);
                enemyArray [2][0] = goblin3.sOHealth;
                enemyArray [2][1] = goblin3.sOAttack;
                enemyArray [2][2] = goblin3.sOSwordA;
                enemyArray [2][3] = goblin3.sODefense;
                enemyArray [2][4] = goblin3.sEXP;
                enemyArray [2][5] = 1;
                enemyArrayFinal = new int [3][6];
            }
        }
        

    for (int r =0; r < enemyArray.length;r++ )
    {
        for (int c = 0; c < 6; c ++)
        {
            enemyArrayFinal[r][c] = enemyArray[r][c];
        }
    }
    }

    EnemyArray(int num)
    {
        enemyArray = enemyArrayFinal;
    }

  static public boolean enemiesDead()
  {
    exp = 0;
    int count = 0;
    boolean dead = false;
    for (int i =0; i < enemyArrayFinal.length; i++)
    {
        if (enemyArrayFinal[i][0] <= 0)
        {
            count++;
        }
    }
    if (count == enemyArrayFinal.length)
    {
        for (int b =0; b < enemyArrayFinal.length; b++)
        {
            exp += enemyArrayFinal[b][4];
            exp += (int)(Math.random()*25);
        }
        Player.currentPlayer.experience += exp;
        if((Player.currentPlayer.currentQuestDifficulty == 'e')||(Player.currentPlayer.currentQuestDifficulty == 'm'))
            Player.currentPlayer.totalKills += 2;
        else Player.currentPlayer.totalKills += 3;
        dead = true;
    }
    return dead;
  }

}
