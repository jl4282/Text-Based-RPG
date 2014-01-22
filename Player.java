
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Player extends Person
{
    public static Player currentPlayer;
    //new variables
    String playerClass;
    boolean knowsIceDale;
    boolean knowsFirefrost;
    boolean knowsAquensKiss;
    boolean knowsHellsWrath;
    boolean hasItems;
    int restoreHealth;
    int iceDale = 10;
    int fireFrost = 10;
    int aquensKiss = 10;
    int hellsWrath = 10;
    int level;
    int experience;
    int stamina;
    int expNeeded;
    int healthMax;
    int totalStamina;
    int attackType;
    int mana;
    int manaTotal;
    public static int [][][] items;
    public static int [][] equippedItems;
    int oldHelmet = 0;
    int oldRobe = 0;
    int oldStaff = 0;
    int oldSword = 0;
    int oldBows = 0;
    int oldHealth = 0;
    int oldStamina = 0;
    int gold;
    boolean hasBow;
    boolean hasStaff;
    boolean hasSword;
    int totalKills = 0;
    char currentQuestDifficulty;
    int totalStaminaPotions =0;
    int totalHealthPotions = 0;


    public Player ()
    {
        this("Default", 1);
    }
    public Player (String newName, int playerType)
    {
        if (playerType == 1)
        {
            health = 150;
            healthMax = 150;
            attack = 10;
            swordA = 20;
            staffA = 15;
            magicA = 10;
            restoreHealth = 20;
            defense = 7;
            rangeA = 5;
            stamina = 15;
            totalStamina = 15;
            playerClass = "Fighter";
            hasSword = true;
            iceDale = 10;
            fireFrost = 10;
            aquensKiss = 10;
            hellsWrath = 10;
            knowsIceDale = false;
            knowsFirefrost = true;
            knowsAquensKiss = false;
            knowsHellsWrath = false;
            mana = 5;
            manaTotal = 5;
        }
        if (playerType == 2)
        {
            health = 100;
            healthMax = 100;
            attack = 10;
            swordA = 10;
            staffA = 15;
            magicA = 20;
            restoreHealth = 25;
            defense = 2;
            rangeA = 10;
            stamina = 7;
            totalStamina = 7;
            playerClass = "Mage";
            hasStaff = true;
            iceDale = 15;
            fireFrost = 15;
            aquensKiss = 25;
            hellsWrath = 20;
            knowsIceDale = true;
            knowsFirefrost = true;
            knowsAquensKiss = true;
            knowsHellsWrath = true;
            mana = 20;
            manaTotal = 20;
        }
        if (playerType == 3)
        {
            health = 75;
            healthMax = 75;
            attack = 10;
            swordA = 5;
            staffA = 10;
            magicA = 20;
            restoreHealth = 20;
            defense = 5;
            rangeA = 25;
            stamina = 10;
            totalStamina = 10;
            playerClass = "Ranger";
            hasBow = true;
            iceDale = 15;
            fireFrost = 15;
            aquensKiss = 10;
            hellsWrath = 10;
            knowsIceDale = false;
            knowsFirefrost = true;
            knowsAquensKiss = true;
            knowsHellsWrath = false;
            mana = 10;
            manaTotal= 10;
        }
        experience = 0;
        level = 1;
        name = newName;
        expNeeded = 200;
        currentPlayer = this;
        nameCheck();
        //second is how many of each you have, last is for stat boost
        items = new int [7][3][1];
        for (int r = 0; r < 7; r++)
        {
            for( int c = 0; c < 3; c ++)
            {
                items[r][c][0] = 0;
            }
        }
        equippedItems = new int [7][1];
        for (int r = 0; r < 7; r++)
        {
            equippedItems[r][0] = 0;
        }
        /*first [] is for what type of thing it is, second is for stats, third is for equipped
         helmets
         * robes increase magic
         * better staff
         * better sword
         * better bow
         * health potion
         * stamina potion
         */
    }
    
    public void getItem()
    {
        //generate type of item
        int r = (int) (Math.random()*7);

        //generate boost
       int boost = 1 + (int) (Player.currentPlayer.level + (Math.random()*14));
       Player.currentPlayer.gold += 1 + (int) (Math.random()*50);
        //determine which equiptment slot is open
        for (int c = 0; c < 3; c ++)
        {
            if ((Player.items[r][c][0]) == 0)
                {
                    Player.items[r][c][0] = boost;
                    break;
                }
            if (c == 2)//items are full
            {
                int min = Player.items[r][0][0];//sets min to first
                int col = 0;//to track which col 
                for (int count = 1; count < 3; count ++)
                {
                    if((Player.items[r][count][0]) < (min))//if boost is greater than min
                    {
                        Player.items[r][count][0] = min;
                        col = count;
                    }
                }
                if ((Player.items[r][col][0]) < boost)
                {
                    Player.items[r][col][0] = boost;
                }
                
            }

        }

        for (int row = 0; row < 7; row ++)
        {
            for (int column = 0; column < 3; column ++)
            {
                System.out.println("Row: " + row + " column: " + column + " matrix: " + Player.items[row][column][0]);
            }
        }
        System.out.println();

        //would need to discard worst item if stats are full
    }

    public static void displayItems()
    {
        
    }
    

    //not sure if this is needed for anything
    public boolean hasItems()
    {
        return hasItems;
    }

    public boolean hasStamina(int cost)
    {
        if (stamina - cost >= 0)
        {
        return true;
        }
        return false;
    }

    public boolean hasMana(int cost)
    {
        if (mana - cost >= 0)
        {
        return true;
        }
        return false;
    }

    public void printStats()
    {
        System.out.println(name + "\nClass: " + playerClass + "\nHealth: " + health +
                "\nLevel: " + level + "\nExperience needed: " + expNeeded);
        System.out.println();
    }

    public String getStats()
    {
        String stats = name + "\nClass: " + playerClass + "\nHealth: " + health +
                "\nLevel: " + level + "\nExperience needed: " + expNeeded;
        return stats;
    }

    public String getPlayerClass()
    {
        return "Class: " + playerClass;
    }

    public String getHealthString()
    {
        return "Health: " + health + "/" + healthMax;
    }

    public String getLevelString()
    {
        return "Level: " + level;
    }

    public String getNameString()
    {
        return name;
    }

    public String getEXPNeeded()
    {
        return "Experience: " + experience + "/" + expNeeded;
    }

    public String getSwordAString()
    {
        return "Sword Attack: "+ swordA + " Cost: 5";
    }

    public String getStaffAString()
    {
        return "Staff Attack: " + staffA + " Cost: 5";
    }

    public String getMagicAString()
    {
        return "Magic Attack: " + magicA;
    }

    public String getRangeAString()
    {
        return "Ranged Attack: " + rangeA + " Cost: 5";
    }

    public String getDefenseString()
    {
        return "Total Defense: " + defense;
    }

    public String getStaminaString()
    {
        return "Stamina: " + stamina + "/" + totalStamina;
    }

    public String getManaString()
    {
        return "Mana: " + mana + "/" + manaTotal;
    }

    public String propertiesIceDale()
    {
        String info = "";
        if (knowsIceDale)
        {
            return "Ice Dale: " + iceDale + " Cost: 6";
        }
        else
        {
            return "Ice Dale Not Known";
        }
    }
    public String propertiesAquensKiss()
    {
        String info = "";
        if (knowsAquensKiss)
        {
            return "Aquens Kiss: " + aquensKiss + " Cost: 6";
        }
        else
        {
            return "Aquens Kiss Not Known";
        }
    }
    public String propertiesHellsWraths()
    {
        String info = "";
        if (knowsHellsWrath)
        {
            return "Hells Wrath: " + hellsWrath + " Cost: 6";
        }
        else
        {
            return "Hells Wrath Not Known";
        }
    }

    public String propertiesFireFrost()
    {
        String info = "";
        if (knowsFirefrost)
        {
            return "Fire Frost: " + fireFrost + " Cost: 5";
        }
        else
        {
            return "Fire Frost Not Known";
        }
    }

    private void nameCheck()
    {
        if (Player.currentPlayer.name.compareToIgnoreCase("Evan") == 0)
        {
            Player.currentPlayer.experience = 100;
            for (int i = 0; i < 9; i ++)
            {
                Player.currentPlayer.levelUp();
            }
        }
    }
    public String getRestoreHealth()
    {
        return "Restore Health: " + restoreHealth;
    }

    public void getBow()
    {
        Player.currentPlayer.hasBow = true;
    }

    public void getSword()
    {
        Player.currentPlayer.hasBow = true;
    }

    public void getStaff()
    {
        Player.currentPlayer.hasStaff = true;
    }

    public void levelUp()
    {
            level ++;
            health = health + level*2;
            healthMax = healthMax + level*2;
            attack = attack + level*2;
            swordA = swordA + level*2;
            staffA = staffA + level*2;
            magicA = magicA + level*2;
            defense = defense + level*2;
            rangeA = rangeA + level*2;
            stamina = stamina + level*2;
            totalStamina = totalStamina + level*2;
            expNeeded = experience*2;
            mana = mana + level*2;
            manaTotal = manaTotal + level*2;

            
    }

    public String getGold()
    {
        return "Gold: " + gold;
    }

    public JPanel getPlayerStats()
        {
            JPanel p1 = new JPanel();
            //a few more for the new things
            p1.setLayout(new GridLayout(18,1));

            //player properties
            p1.add(new JLabel (this.getNameString()));
            p1.add(new JLabel (this.getPlayerClass()));
            p1.add(new JLabel (this.getLevelString()));
            p1.add(new JLabel (this.getGold()));
            p1.add(new JLabel (this.getHealthString()));
            p1.add(new JLabel (this.getEXPNeeded()));
            p1.add(new JLabel (this.getStaminaString()));
            p1.add(new JLabel (this.getManaString()));
            p1.add(new JLabel (this.getSwordAString()));
            p1.add(new JLabel (this.getStaffAString()));
            p1.add(new JLabel (this.getMagicAString()));
            p1.add(new JLabel (this.getRangeAString()));
            p1.add(new JLabel(this.propertiesAquensKiss()));
            p1.add(new JLabel(this.propertiesFireFrost()));
            p1.add(new JLabel(this.propertiesHellsWraths()));
            p1.add(new JLabel(this.propertiesIceDale()));
            p1.add(new JLabel (this.getRestoreHealth()));
            p1.add(new JLabel (this.getDefenseString()));
            return p1;
        }
    public boolean playerDead()
    {
        if (Player.currentPlayer.health <= 0)
        {
        return true;
        }
        return false;
    }
}


