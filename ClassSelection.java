import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ClassSelection extends JFrame {
    
    public ClassSelection(char death)
    {

        // Create panel p1 for the buttons and set GridLayout
        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(1, 3));

        //add images to panel
        ImageIcon mageIcon = new ImageIcon ("mageImage.jpg");
        ImageIcon fighterIcon = new ImageIcon ("fighterImage.jpg");
        ImageIcon rangerIcon = new ImageIcon ("rangerImage.jpg");
        p1.add(new JLabel (mageIcon));
        p1.add(new JLabel (fighterIcon));
        p1.add(new JLabel (rangerIcon));

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 3));

        // Add buttons to the panel
        JButton mage = new JButton("Mage");

        p3.add(mage);
        JButton fighter = new JButton("Fighter");
        p3.add(fighter);
        JButton ranger = new JButton("Ranger");
        p3.add(ranger);

        //add listeners
        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.SOUTH);
        p4.add(p1, BorderLayout.CENTER);
        ActionListener listener = new CharacterSelectionListener();

        JPanel p2 = new JPanel(new BorderLayout());
        JButton load = new JButton ("Load Game");

        if (death == 'd')
        {
            add(new JLabel("Congrats! You Died! Now Get Back Into the Fight..."),BorderLayout.NORTH);
        }
        else
            add(new JLabel("Select Your Class"),BorderLayout.NORTH);
     

        add(p4, BorderLayout.CENTER);
        add(load, BorderLayout.SOUTH);
        if (death == 'd')
        {
            
        }
        load.addActionListener((ActionListener) listener);

        mage.addActionListener(listener);
        fighter.addActionListener((ActionListener) listener);
        ranger.addActionListener((ActionListener) listener);

        //add window event- when go to a dif screen goes invisible
    }


  /** Main method */

  public static void main(String[] args) {
    //MainFrame frame = new MainFrame(new ClassSelection());
    ClassSelection frame = new ClassSelection('m');
      //ClassSelection frame = new ClassSelection();
    frame.setTitle("Select Class");
    //frame.currentPanel.setPreferredSize(new Dimension(700,700));

    frame.setSize(700, 700);

    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);
    //need to make frames public-- need to make them static?
    //frame.invisibleFrame(frame); 


  }
}
class CharacterSelectionListener implements ActionListener{

    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand()).equalsIgnoreCase("Load Game")) {
            Player player = new Player(); //createts new player which overrides saved file
            new LoadPlayer2();
            MainScreen frame = new MainScreen();

            frame.setTitle("Main Screen");

            frame.setSize(700, 700);

            frame.setLocationRelativeTo(null); // Center the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JComponent x = (JComponent) e.getSource();
            JFrame oldFrame = (JFrame) x.getRootPane().getParent();
            oldFrame.dispose();
            frame.setVisible(true);

        }
        else{
            JFrame frame;
            if ((e.getActionCommand()).equalsIgnoreCase("mage")) {
                //need the new
                frame = new enterNameScreenMage();
            }else if ((e.getActionCommand()).equalsIgnoreCase("fighter")) {
                frame = new enterNameScreenFighter();

            }else{// if ((e.getActionCommand()).equalsIgnoreCase("ranger")) {
                frame = new enterNameScreenRanger();
            }
            frame.setTitle("Enter Name");
            frame.setSize(700, 700);

            frame.setLocationRelativeTo(null); // Center the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JComponent x = (JComponent) e.getSource();
            JFrame oldFrame = (JFrame) x.getRootPane().getParent();
            oldFrame.dispose();
            frame.setVisible(true);
        }

    }
   
}
class ListenerCharacter implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    //calls the right name screen depending on which was clicked
    
    if((e.getActionCommand()).equalsIgnoreCase("store"))
    {
        StoreDisplay frame = new StoreDisplay();
        frame.setTitle("Store");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("Buy Bow: 50 Gold"))
    {
        if(Player.currentPlayer.gold - 50 >= 0)
        {
            Player.currentPlayer.hasBow = true;
            Player.currentPlayer.gold = Player.currentPlayer.gold -  50;
        }
        MainScreen frame = new MainScreen();
        frame.setTitle("Main Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("Buy staff: 50 Gold"))
    {
        if(Player.currentPlayer.gold - 50 >= 0)
        {
            Player.currentPlayer.hasStaff = true;
            Player.currentPlayer.gold = Player.currentPlayer.gold -  50;
        }
        MainScreen frame = new MainScreen();
        frame.setTitle("Main Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("Buy Sword: 50 Gold"))
    {
        if(Player.currentPlayer.gold - 50 >= 0)
        {
            Player.currentPlayer.hasSword = true;
            Player.currentPlayer.gold = Player.currentPlayer.gold -  50;
        }
        MainScreen frame = new MainScreen();
        frame.setTitle("Main Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("Buy Aquens Kiss: 100 Gold"))
    {
        if(Player.currentPlayer.gold - 100 >= 0)
        {
            Player.currentPlayer.knowsAquensKiss = true;
            Player.currentPlayer.gold = Player.currentPlayer.gold -  100;
        }
        MainScreen frame = new MainScreen();
        frame.setTitle("Main Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("Buy Fire Frost: 100 Gold"))
    {
        if(Player.currentPlayer.gold - 100 >= 0)
        {
            Player.currentPlayer.knowsFirefrost = true;
            Player.currentPlayer.gold = Player.currentPlayer.gold -  100;
        }
        MainScreen frame = new MainScreen();
        frame.setTitle("Main Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("Buy Hells Wrath: 100 Gold"))
    {
        if(Player.currentPlayer.gold - 100 >= 0)
        {
            Player.currentPlayer.knowsHellsWrath = true;
            Player.currentPlayer.gold = Player.currentPlayer.gold -  100;
        }
        MainScreen frame = new MainScreen();
        frame.setTitle("Main Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("Buy Ice Dale: 100 Gold"))
    {
        if(Player.currentPlayer.gold - 100 >= 0)
        {
            Player.currentPlayer.knowsIceDale = true;
            Player.currentPlayer.gold = Player.currentPlayer.gold -  100;
        }
        MainScreen frame = new MainScreen();
        frame.setTitle("Main Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("inventory"))
    {
        DisplayItemsMain frame = new DisplayItemsMain('m');
        frame.setTitle("Inventory Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if((e.getActionCommand()).equalsIgnoreCase("stats"))
    {
        StatsScreen frame = new StatsScreen();
        frame.setTitle("Stats Screen");

        frame.setSize(800, 500);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    if((e.getActionCommand()).equalsIgnoreCase("inventory and potions"))
    {
        DisplayItemsMain frame = new DisplayItemsMain('c');
        frame.setTitle("Inventory Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    if((e.getActionCommand()).equalsIgnoreCase("quest")||(e.getActionCommand()).equalsIgnoreCase("Retreat"))
    {
        //open quest screen
        QuestScreen frame = new QuestScreen();
        frame.setTitle("Quest Screen");

        frame.setSize(700, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if ((e.getActionCommand()).equalsIgnoreCase("Back to the Battle!"))
    {   //input fight screen
        FightScreen frame = new FightScreen();
        frame.setTitle("Fight Screen");
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    if ((e.getActionCommand()).equalsIgnoreCase("easy Quest"))
    {
        //can add another depth [][][] and make the first one indicate what type of enemy it is
        EnemyArray eArray = new EnemyArray('e');
        int orcArray [][] = EnemyArray.enemyArrayFinal;

        FightScreen frame = new FightScreen();
        frame.setTitle("Easy Quest");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        Player.currentPlayer.currentQuestDifficulty = 'e';
    }
    if ((e.getActionCommand()).equalsIgnoreCase("medium Quest"))
    {   //input fight screen

        EnemyArray eArray = new EnemyArray('m');
        int combatArray [][] = EnemyArray.enemyArrayFinal;
        FightScreen frame = new FightScreen();
        frame.setTitle("Medium Quest");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        Player.currentPlayer.currentQuestDifficulty = 'm';

    }
    if ((e.getActionCommand()).equalsIgnoreCase("hard Quest"))
    {
        //input hard quest
        EnemyArray eArray = new EnemyArray('h');
        int combatArray [][] = EnemyArray.enemyArrayFinal;
        FightScreen frame = new FightScreen();
        frame.setTitle("Hard Quest");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        Player.currentPlayer.currentQuestDifficulty = 'h';
    }
    if ((e.getActionCommand()).equalsIgnoreCase("back")||((e.getActionCommand()).equalsIgnoreCase("continue"))||((e.getActionCommand()).equalsIgnoreCase("save game")))
    {
        if ((e.getActionCommand()).equalsIgnoreCase("save game"))
        {
            new WriteTest();
        }
        MainScreen frame = new MainScreen();

        frame.setTitle("Main Screen");

        frame.setSize(700, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
    if ((e.getActionCommand()).equalsIgnoreCase("staff melee"))
    {
        Player.currentPlayer.attackType = 1;
        //call method to ask which enemy to attack
        whichEnemyMethod(Player.currentPlayer);
         
    }
    if ((e.getActionCommand()).equalsIgnoreCase("bow"))
    {
        Player.currentPlayer.attackType = 2;
        //call method to ask which enemy to attack
        whichEnemyMethod(Player.currentPlayer);

    }
    if ((e.getActionCommand()).equalsIgnoreCase("sword"))
    {
        Player.currentPlayer.attackType = 3;
        //call method to ask which enemy to attack
        whichEnemyMethod(Player.currentPlayer);
    }
    if ((e.getActionCommand()).equalsIgnoreCase("ice dale"))
    {
        Player.currentPlayer.attackType = 4;
        //call method to ask which enemy to attack
        whichEnemyMethod(Player.currentPlayer);
    }
    if ((e.getActionCommand()).equalsIgnoreCase("hells wrath"))
    {
        Player.currentPlayer.attackType = 5;
        //call method to ask which enemy to attack
        whichEnemyMethod(Player.currentPlayer);
    }
    if ((e.getActionCommand()).equalsIgnoreCase("aquens kiss"))
    {
        Player.currentPlayer.attackType = 6;
        //call method to ask which enemy to attack
        whichEnemyMethod(Player.currentPlayer);
    }
    if ((e.getActionCommand()).equalsIgnoreCase("fire frost"))
    {
        Player.currentPlayer.attackType = 7;
        //call method to ask which enemy to attack
        whichEnemyMethod(Player.currentPlayer);
    }
    if ((e.getActionCommand()).equalsIgnoreCase("restore health"))
    {

        Player.currentPlayer.health = Player.currentPlayer.health + Player.currentPlayer.restoreHealth;
        if (Player.currentPlayer.health > Player.currentPlayer.healthMax)
        {
            Player.currentPlayer.health = Player.currentPlayer.healthMax;
        }
        for(int i = 0; i < EnemyArray.enemyArrayFinal.length; i ++)
        {
            if (EnemyArray.enemyArrayFinal[i][0] > 0)
            {
                EnemyArray.enemyArrayFinal[i][0] += 5;
            }
        }
        FightScreen frame = new FightScreen();
        frame.setTitle("Enter Name");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);

    }
    if ((e.getActionCommand()).equalsIgnoreCase("enemy 1")||(e.getActionCommand()).equalsIgnoreCase("enemy 2")||(e.getActionCommand()).equalsIgnoreCase("enemy 3"))
    {//method for fighting
        int enemyNum = 0;
        if ((e.getActionCommand()).equalsIgnoreCase("enemy 1"))
        {
            enemyNum = 0;
        }
        if ((e.getActionCommand()).equalsIgnoreCase("enemy 2"))
        {
            enemyNum = 1;
        }
        if ((e.getActionCommand()).equalsIgnoreCase("enemy 3"))
        {
            enemyNum = 2;
            
        }
        int [][] combatArray = EnemyArray.enemyArrayFinal;
       switch (Player.currentPlayer.attackType)
       {
            case 1: //staff
                if(Player.currentPlayer.hasStamina(5))
                {
                    EnemyArray.enemyArrayFinal[enemyNum][0]= EnemyArray.enemyArrayFinal[enemyNum][0] - (Player.currentPlayer.staffA - EnemyArray.enemyArrayFinal[enemyNum][3]);
                    Player.currentPlayer.stamina= Player.currentPlayer.stamina - 5;
                }
                break;
            case 2: //bow
                if(Player.currentPlayer.hasStamina(5))
                {
                    EnemyArray.enemyArrayFinal[enemyNum][0]= EnemyArray.enemyArrayFinal[enemyNum][0] - (Player.currentPlayer.rangeA - EnemyArray.enemyArrayFinal[enemyNum][3]);
                    Player.currentPlayer.stamina= Player.currentPlayer.stamina - 5;
                }
                break;
            case 3: //sword
                if(Player.currentPlayer.hasStamina(5))
                {
                    EnemyArray.enemyArrayFinal[enemyNum][0]= EnemyArray.enemyArrayFinal[enemyNum][0] - (Player.currentPlayer.swordA - EnemyArray.enemyArrayFinal[enemyNum][3]);
                    Player.currentPlayer.stamina= Player.currentPlayer.stamina - 5;
                }
                break;
            case 4: //ice dale
                if (Player.currentPlayer.hasMana(6))
                {
                    EnemyArray.enemyArrayFinal[enemyNum][0]= EnemyArray.enemyArrayFinal[enemyNum][0] - (Player.currentPlayer.iceDale - EnemyArray.enemyArrayFinal[enemyNum][3]);
                    Player.currentPlayer.mana = Player.currentPlayer.mana - 6;
                }
                break;
            case 5: //hells wrath
                if (Player.currentPlayer.hasMana(6))
                {
                    EnemyArray.enemyArrayFinal[enemyNum][0]= EnemyArray.enemyArrayFinal[enemyNum][0] - (Player.currentPlayer.hellsWrath - EnemyArray.enemyArrayFinal[enemyNum][3]);
                    Player.currentPlayer.mana = Player.currentPlayer.mana - 6;
                }
                
                break;
            case 6: //aquens kiss
                if (Player.currentPlayer.hasMana(6))
                {
                    EnemyArray.enemyArrayFinal[enemyNum][0]= EnemyArray.enemyArrayFinal[enemyNum][0] - (Player.currentPlayer.aquensKiss - EnemyArray.enemyArrayFinal[enemyNum][3]);
                    Player.currentPlayer.mana = Player.currentPlayer.mana - 6;
                }
                break;
            case 7: //fire frost
                if (Player.currentPlayer.hasMana(5))
                {
                    EnemyArray.enemyArrayFinal[enemyNum][0]= EnemyArray.enemyArrayFinal[enemyNum][0] - (Player.currentPlayer.fireFrost - EnemyArray.enemyArrayFinal[enemyNum][3]);
                    Player.currentPlayer.mana = Player.currentPlayer.mana - 5;
                }
                break;
            
        }

        //method for couter attack
        Player.currentPlayer.health = Player.currentPlayer.health - (EnemyArray.enemyArrayFinal[enemyNum][1] - Player.currentPlayer.defense);
        boolean playerDead = Player.currentPlayer.playerDead();
        if (playerDead)
        {
            ClassSelection frame = new ClassSelection('d');
            //ClassSelection frame = new ClassSelection();
            frame.setTitle("Select Class");
            //frame.currentPanel.setPreferredSize(new Dimension(700,700));

            frame.setSize(700, 700);

            frame.setLocationRelativeTo(null); // Center the frame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setVisible(true);
        }
        else
        {
            boolean dead = false;
            dead = EnemyArray.enemiesDead();
            if (dead)
            {

                new VictoryScreenMethod();
                //go to main screen or screen that says defeated enemies
                //check for experience to level up
            }
            else
            {
                Player.currentPlayer.stamina += 3;
                if(Player.currentPlayer.stamina > Player.currentPlayer.totalStamina)
                {
                    Player.currentPlayer.stamina = Player.currentPlayer.totalStamina;
                }
                Player.currentPlayer.mana += 2;
                if(Player.currentPlayer.mana > Player.currentPlayer.manaTotal)
                {
                    Player.currentPlayer.mana = Player.currentPlayer.manaTotal;
                }
                fightScreenMethod(Player.currentPlayer, combatArray, 3);
            }
        }
        
        
    }
        JComponent x = (JComponent) e.getSource();
        JFrame oldFrame = (JFrame) x.getRootPane().getParent();
        oldFrame.dispose();
  }


  public void fightScreenMethod(Player player, int [][] combatArray, int enemyToAttack)
  {
        FightScreen frame = new FightScreen();
        frame.setTitle("Fight Screen");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
  }
  public void whichEnemyMethod(Player player)
  {
        EnemySelect frame = new EnemySelect();
        frame.setTitle("Select Enemy to Attack");

        frame.setSize(850, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
  }
}

class enterNameScreenMage extends JFrame
{
    public enterNameScreenMage()
    {
        JPanel nameScreen = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(2,1));
        p1.add(new JLabel("The mage, an excellent choice!", SwingConstants.CENTER));
        p1.add(new JLabel("Hailing from the West the mage uses the power of the Gods to defeat his enemies in battle.", SwingConstants.CENTER));
        //JLabel title = new JLabel("The mage, an excellent choice! Hailing from the West the mage uses the power of the Gods to defeat his enemies in battle.");
        add(p1,BorderLayout.CENTER);
        JTextField newName = new JTextField();
        nameFieldMage nameListener = new nameFieldMage();
        String  text  = newName.getText();
        newName.addActionListener(nameListener);
        add(newName,BorderLayout.SOUTH);
        
    }
    
}

class enterNameScreenFighter extends JFrame
{
    public enterNameScreenFighter()
    {
        JPanel nameScreen = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(2,1));
        p1.add(new JLabel("The Fighter, an excellent choice!", SwingConstants.CENTER));
        p1.add(new JLabel("Hailing from the Imperial City the Fighter uses his muscle to decapitate his enemies.", SwingConstants.CENTER));
        //JLabel title = new JLabel("The mage, an excellent choice! Hailing from the West the mage uses the power of the Gods to defeat his enemies in battle.");
        add(p1,BorderLayout.CENTER);
        JTextField newName = new JTextField();
        nameFieldFighter nameListener = new nameFieldFighter();
        String  text  = newName.getText();
        newName.addActionListener(nameListener);
        add(newName,BorderLayout.SOUTH);

    }
}

class enterNameScreenRanger extends JFrame
{
    public enterNameScreenRanger()
    {
        JPanel nameScreen = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(2,1));
        p1.add(new JLabel("The Ranger, an excellent choice!", SwingConstants.CENTER));
        p1.add(new JLabel("Hailing from the Woodland Realm of Ebony the Ranger uses his bow to pierce the enemy.", SwingConstants.CENTER));
        //JLabel title = new JLabel("The mage, an excellent choice! Hailing from the West the mage uses the power of the Gods to defeat his enemies in battle.");
        add(p1,BorderLayout.CENTER);
        JTextField newName = new JTextField();
        nameFieldRanger nameListener = new nameFieldRanger();
        String  text  = newName.getText();
        newName.addActionListener(nameListener);
        add(newName,BorderLayout.SOUTH);

    }
}

class nameFieldMage implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    Player player = new Player(e.getActionCommand(),2);
    player.getStats();
    MainScreen frame = new MainScreen();

    frame.setTitle("Main Screen");

    frame.setSize(700, 700);

    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);
    JComponent x = (JComponent) e.getSource();
    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
    oldFrame.dispose();
  }


}

class nameFieldFighter implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    Player player = new Player(e.getActionCommand(),1);
    player.getStats();
    MainScreen frame = new MainScreen();

    frame.setTitle("Main Screen");

    frame.setSize(700, 700);

    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);
    JComponent x = (JComponent) e.getSource();
    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
    oldFrame.dispose();
  }
}

class nameFieldRanger implements ActionListener {

  public void actionPerformed(ActionEvent e) {
    Player player = new Player(e.getActionCommand(),3);
    player.getStats();
    MainScreen frame = new MainScreen();

    frame.setTitle("Main Screen");

    frame.setSize(700, 700);

    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);
    //insert method to show stats in a new option- method should work for all the

    JComponent x = (JComponent) e.getSource();
    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
    oldFrame.dispose();
  }
}

class VictoryScreenMethod
{
    VictoryScreenMethod()
    {
        for (int i = 0; i < 3; i ++)
        {
            Player.currentPlayer.getItem();
        }
        VictoryScreen frame = new VictoryScreen();
        frame.setTitle("Victory!");
        frame.setSize(700, 700);

        frame.setLocationRelativeTo(null); // Center the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
        
    }
}


class MainScreen extends JFrame
{
    public MainScreen()
    {
        JPanel p1 = Player.currentPlayer.getPlayerStats();

        //p1.add(new JLabel (player.));
        // add all stats in here

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 4));

        // Add buttons to the panel
        JButton quest = new JButton("Quest");
        p3.add(quest);
        JButton inventory = new JButton("Inventory");
        p3.add(inventory);
        JButton save = new JButton("Save Game");
        p3.add(save);
        JButton store = new JButton("Store");
        p3.add(store);
        JButton stats = new JButton("Stats");
        p3.add(stats);
        // put stats with other stuff on left
        //JButton stats = new JButton("Stats");
        //p3.add(stats);

        //add listeners

        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.SOUTH);
        p4.add(p1, BorderLayout.CENTER);
        JPanel p5 = new JPanel();
        ImageIcon questing = new ImageIcon ("questing.jpg");
        p5.add(new JLabel (questing));
        p4.add(p5, BorderLayout.EAST);


        // Create panel p2 to hold a text field and p1
        JPanel p2 = new JPanel(new BorderLayout());

        add(new JLabel("Main Screen"),

          BorderLayout.NORTH);

        add(p4, BorderLayout.CENTER);

        //make new listener class -- or add them to the current class
        ListenerCharacter listener = new ListenerCharacter();
        quest.addActionListener(listener);
        inventory.addActionListener((ActionListener) listener);
        save.addActionListener((ActionListener) listener);
        store.addActionListener((ActionListener) listener);
        stats.addActionListener((ActionListener) listener);
        
        
        

    }
    
}

//screen for questing -- select which quest to go on
class QuestScreen extends JFrame
{
    public QuestScreen()
    {
        JPanel p1 = Player.currentPlayer.getPlayerStats();


        //p1.add(new JLabel (player.));
        // add all stats in here

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 2));

        JButton easyQuest = new JButton ("Easy Quest");
        p3.add(easyQuest);

        JButton mediumQuest = new JButton ("Medium Quest");
        p3.add(mediumQuest);

        JButton hardQuest = new JButton ("Hard Quest");
        p3.add(hardQuest);
        
        JButton inventory = new JButton("Inventory");
        p3.add(inventory);

        //will link back to main screen
        JButton backToMain = new JButton ("Back");
        p3.add(backToMain);
        // put stats with other stuff on left
        //JButton stats = new JButton("Stats");
        //p3.add(stats);

        //add listeners

        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.SOUTH);
        p4.add(p1, BorderLayout.CENTER);
        JPanel p5 = new JPanel();
        ImageIcon questing = new ImageIcon ("goblin.jpg");
        p5.add(new JLabel (questing));
        p4.add(p5, BorderLayout.EAST);


        // Create panel p2 to hold a text field and p1
        JPanel p2 = new JPanel(new BorderLayout());

        add(new JLabel("Quest Screen"),

          BorderLayout.NORTH);

        add(p4, BorderLayout.CENTER);

        //make new listener class -- or add them to the current class
        ListenerCharacter listener = new ListenerCharacter();
        easyQuest.addActionListener(listener);
        hardQuest.addActionListener((ActionListener) listener);
        backToMain.addActionListener((ActionListener) listener);
        inventory.addActionListener((ActionListener) listener);
        mediumQuest.addActionListener((ActionListener) listener);

    }
}

class FightScreen extends JFrame
{
    //embed different methods to know which enemy to display
    public FightScreen()
    {
        JPanel p1 = Player.currentPlayer.getPlayerStats();


        //p1.add(new JLabel (player.));
        // add all stats in here

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 2));
        ListenerCharacter listener = new ListenerCharacter();
        // Add buttons to the panel 3
        if (Player.currentPlayer.knowsAquensKiss)
        {
            JButton aquensKiss = new JButton("Aquens Kiss");
            p3.add(aquensKiss);
            aquensKiss.addActionListener((ActionListener) listener);
        }
        if (Player.currentPlayer.knowsFirefrost)
        {
            JButton fireFrost = new JButton ("Fire Frost");
            p3.add(fireFrost);
            fireFrost.addActionListener((ActionListener) listener);
        }
        if(Player.currentPlayer.knowsHellsWrath)
        {
            JButton hellsWrath = new JButton ("Hells Wrath");
            p3.add(hellsWrath);
            hellsWrath.addActionListener((ActionListener) listener);
        }
        if(Player.currentPlayer.knowsIceDale)
        {
            JButton iceDale = new JButton ("Ice Dale");
            p3.add(iceDale);
            iceDale.addActionListener((ActionListener) listener);
        }

        JButton restoreHealth = new JButton ("Restore Health");
        p3.add(restoreHealth);
        restoreHealth.addActionListener((ActionListener) listener);

        //can also add || has staff equipped or in inventory
        if(Player.currentPlayer.hasStaff)
        {
            JButton staff = new JButton ("Staff Melee");
            p3.add(staff);
            staff.addActionListener((ActionListener) listener);
        }
        if(Player.currentPlayer.hasBow)
        {
            JButton bow = new JButton ("Bow");
            p3.add(bow);
            bow.addActionListener((ActionListener) listener);
        }
        if(Player.currentPlayer.hasSword)
        {
            JButton sword = new JButton ("Sword");
            p3.add(sword);
            sword.addActionListener((ActionListener) listener);
        }


        //will go to inventory screen
        JButton inventory = new JButton("Inventory and Potions");
        p3.add(inventory);
        inventory.addActionListener((ActionListener) listener);

        //will link back to main screen
        JButton retreat = new JButton ("Retreat");
        p3.add(retreat);
        retreat.addActionListener((ActionListener) listener);

        //input enemy data
        JPanel p5 = new JPanel(new GridLayout(13, 0));
        for (int r = 0; r < EnemyArray.enemyArrayFinal.length; r++)
        {
            if (EnemyArray.enemyArrayFinal[r][0] > 0)
            {
                if (EnemyArray.enemyArrayFinal[r][5] == 0)
                {
                    p5.add(new JLabel("Orc " + (r+1) + " Health: " + EnemyArray.enemyArrayFinal[r][0]));
                }
                else
                    p5.add(new JLabel("Goblin " + (r+1) + " Health: " + EnemyArray.enemyArrayFinal[r][0]));
            
            }
        }

        //add button group to select enemies
        


        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.SOUTH);
        p4.add(p1, BorderLayout.WEST);
        p4.add(p5, BorderLayout.EAST);
        JPanel p6 = new JPanel();
        ImageIcon questing = new ImageIcon ("orcEasy.jpg");
        p6.add(new JLabel (questing));
        p4.add(p6, BorderLayout.CENTER);



        // Create panel p2 to hold a text field and p1
        JPanel p2 = new JPanel(new BorderLayout());

        add(new JLabel("Fight Screen"),

          BorderLayout.NORTH);

        add(p4, BorderLayout.CENTER);

        //make new listener class -- or add them to the current class


    }
}

class EnemySelect extends JFrame{
    public EnemySelect()
    {

        JPanel p1 = Player.currentPlayer.getPlayerStats();


        //p1.add(new JLabel (player.));
        // add all stats in here

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(2, 2));
        ListenerCharacter listener = new ListenerCharacter();
        // Add buttons to the panel 3
        if (EnemyArray.enemyArrayFinal[0][0] > 0)
        {
            JButton enemy1 = new JButton("Enemy 1");
            p3.add(enemy1);
            enemy1.addActionListener((ActionListener) listener);
        }
        if (EnemyArray.enemyArrayFinal[1][0] > 0)
        {

            JButton enemy2 = new JButton("Enemy 2");
            p3.add(enemy2);
            enemy2.addActionListener((ActionListener) listener);
        }
        if (EnemyArray.enemyArrayFinal[2][0] > 0)
        {
            JButton enemy3 = new JButton ("Enemy 3");
            p3.add(enemy3);
            enemy3.addActionListener((ActionListener) listener);
        }

        //will go to inventory screen
        JButton inventory = new JButton("Inventory and Potions");
        p3.add(inventory);
        inventory.addActionListener((ActionListener) listener);

        //will link back to main screen
        JButton retreat = new JButton ("Retreat");
        p3.add(retreat);
        retreat.addActionListener((ActionListener) listener);

        //input enemy data
        JPanel p5 = new JPanel(new GridLayout(13, 0));
        for (int r = 0; r < EnemyArray.enemyArrayFinal.length; r++)
        {
            if (EnemyArray.enemyArrayFinal[r][0] > 0)
            {
                if (EnemyArray.enemyArrayFinal[r][5] == 0)
                {
                    p5.add(new JLabel("Orc " + (r+1) + " Health: " + EnemyArray.enemyArrayFinal[r][0]));
                }
                else
                    p5.add(new JLabel("Goblin " + (r+1) + " Health: " + EnemyArray.enemyArrayFinal[r][0]));
            }
        }

        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.SOUTH);
        p4.add(p1, BorderLayout.WEST);
        p4.add(p5, BorderLayout.EAST);
        JPanel p6 = new JPanel();
        ImageIcon questing = new ImageIcon ("orc2.jpg");
        p6.add(new JLabel (questing));
        p4.add(p6, BorderLayout.CENTER);



        // Create panel p2 to hold a text field and p1
        JPanel p2 = new JPanel(new BorderLayout());

        add(new JLabel("Fight Screen"),

          BorderLayout.NORTH);

        add(p4, BorderLayout.CENTER);
    }
}

class VictoryScreen extends JFrame
{
    public VictoryScreen()
    {
        Player.currentPlayer.health = Player.currentPlayer.healthMax;
        Player.currentPlayer.stamina = Player.currentPlayer.totalStamina;
        Player.currentPlayer.mana = Player.currentPlayer.manaTotal;
        JPanel nameScreen = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel();
        p1.add(new JLabel("You Are Victorious! Check Out Your New Loot!", SwingConstants.CENTER));
        p1.add(new JLabel("You Earned " + EnemyArray.exp + " Experience!", SwingConstants.CENTER));
        if (Player.currentPlayer.experience > Player.currentPlayer.expNeeded)
        {
            Player.currentPlayer.levelUp();
            p1.add(new JLabel("You Are Now Level " + Player.currentPlayer.level, SwingConstants.CENTER));
        }
        JPanel p5 = new JPanel();
        ImageIcon questing = new ImageIcon ("victory.jpg");
        p5.add(new JLabel (questing));
        p1.add(p5, BorderLayout.CENTER);
        add(p1,BorderLayout.CENTER);
        JButton cont = new JButton("Continue");
        ListenerCharacter listener = new ListenerCharacter();
        cont.addActionListener((ActionListener) listener);
        add(cont,BorderLayout.SOUTH);


        
    }
}

class DisplayItemsMain extends JFrame
{
    public static char context2;
    public DisplayItemsMain(char context)
    {
        context2 = context;
        JPanel p1 = Player.currentPlayer.getPlayerStats();
        JPanel p3 = new JPanel();
        if (context == 'm')
        {
            p3.setLayout(new GridLayout(5, 4));
        }
        else
        {
            p3.setLayout(new GridLayout(7, 4));
        }

        ListenerCharacter listener = new ListenerCharacter();
        // Add buttons to the panel 3


            JLabel helmets = new JLabel("Helmets: ");
            p3.add(helmets);
            JButton helmet1 = new JButton (Integer.toString(Player.items[0][0][0]));
            helmet1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.defense = Player.currentPlayer.defense - Player.currentPlayer.oldHelmet;
                    Player.equippedItems[0][0] = Player.items[0][0][0];
                    Player.currentPlayer.oldHelmet = Player.equippedItems[0][0];
                    Player.currentPlayer.defense += Player.equippedItems[0][0];
                    EquipScreen frame = new EquipScreen(0,0,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[0][0]);

                }
            });


            p3.add(helmet1);
            JButton helmet2 = new JButton (Integer.toString(Player.items[0][1][0]));
            helmet2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.defense = Player.currentPlayer.defense - Player.currentPlayer.oldHelmet;
                    Player.equippedItems[0][0] = Player.items[0][1][0];
                    Player.currentPlayer.oldHelmet = Player.equippedItems[0][0];
                    Player.currentPlayer.defense += Player.equippedItems[0][0];
                    EquipScreen frame = new EquipScreen(0,1,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[0][0]);
                    }
            });
            p3.add(helmet2);
            JButton helmet3 = new JButton (Integer.toString(Player.items[0][2][0]));
            helmet3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.defense = Player.currentPlayer.defense - Player.currentPlayer.oldHelmet;
                    Player.equippedItems[0][0] = Player.items[0][2][0];
                    Player.currentPlayer.oldHelmet = Player.equippedItems[0][0];
                    Player.currentPlayer.defense += Player.equippedItems[0][0];
                    EquipScreen frame = new EquipScreen(0,2,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[0][0]);
                    }
            });
            p3.add(helmet3);

            JLabel robes = new JLabel("Robes: ");
            p3.add(robes);
            JButton robe1 = new JButton (Integer.toString(Player.items[1][0][0]));
            robe1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.aquensKiss = Player.currentPlayer.aquensKiss - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.fireFrost = Player.currentPlayer.fireFrost - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.iceDale = Player.currentPlayer.iceDale - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.hellsWrath = Player.currentPlayer.hellsWrath - Player.currentPlayer.oldRobe;
                    Player.equippedItems[1][0] = Player.items[1][0][0];
                    Player.currentPlayer.oldRobe = Player.equippedItems[1][0];
                    Player.currentPlayer.aquensKiss += Player.equippedItems[1][0];
                    Player.currentPlayer.fireFrost += Player.equippedItems[1][0];
                    Player.currentPlayer.iceDale += Player.equippedItems[1][0];
                    Player.currentPlayer.hellsWrath += Player.equippedItems[1][0];
                    EquipScreen frame = new EquipScreen(1,0,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[1][0]);
                    }
            });
            p3.add(robe1);
            JButton robe2 = new JButton (Integer.toString(Player.items[1][1][0]));
            robe2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.aquensKiss = Player.currentPlayer.aquensKiss - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.fireFrost = Player.currentPlayer.fireFrost - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.iceDale = Player.currentPlayer.iceDale - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.hellsWrath = Player.currentPlayer.hellsWrath - Player.currentPlayer.oldRobe;
                    Player.equippedItems[1][0] = Player.items[1][2][0];
                    Player.currentPlayer.oldRobe = Player.equippedItems[1][0];
                    Player.currentPlayer.aquensKiss += Player.equippedItems[1][0];
                    Player.currentPlayer.fireFrost += Player.equippedItems[1][0];
                    Player.currentPlayer.iceDale += Player.equippedItems[1][0];
                    Player.currentPlayer.hellsWrath += Player.equippedItems[1][0];
                    EquipScreen frame = new EquipScreen(1,2,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Robe: " + Player.equippedItems[1][0]);
                    }
            });
            p3.add(robe2);
            JButton robe3 = new JButton (Integer.toString(Player.items[1][2][0]));
            robe3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.aquensKiss = Player.currentPlayer.aquensKiss - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.fireFrost = Player.currentPlayer.fireFrost - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.iceDale = Player.currentPlayer.iceDale - Player.currentPlayer.oldRobe;
                    Player.currentPlayer.hellsWrath = Player.currentPlayer.hellsWrath - Player.currentPlayer.oldRobe;
                    Player.equippedItems[1][0] = Player.items[1][2][0];
                    Player.currentPlayer.oldRobe = Player.equippedItems[1][0];
                    Player.currentPlayer.aquensKiss += Player.equippedItems[1][0];
                    Player.currentPlayer.fireFrost += Player.equippedItems[1][0];
                    Player.currentPlayer.iceDale += Player.equippedItems[1][0];
                    Player.currentPlayer.hellsWrath += Player.equippedItems[1][0];
                    EquipScreen frame = new EquipScreen(1,2,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[1][0]);
                    }
            });
            p3.add(robe3);

            JLabel staffs = new JLabel("Staffs: ");
            p3.add(staffs);
            JButton staff1 = new JButton (Integer.toString(Player.items[2][0][0]));
            staff1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.staffA = Player.currentPlayer.staffA - Player.currentPlayer.oldStaff;
                    Player.equippedItems[2][0] = Player.items[2][0][0];
                    Player.currentPlayer.oldStaff = Player.equippedItems[2][0];
                    Player.currentPlayer.staffA += Player.equippedItems[2][0];
                    EquipScreen frame = new EquipScreen(2,0,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[2][0]);
                    }
            });
            p3.add(staff1);
            JButton staff2 = new JButton (Integer.toString(Player.items[2][1][0]));
            staff2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.staffA = Player.currentPlayer.staffA - Player.currentPlayer.oldStaff;
                    Player.equippedItems[2][0] = Player.items[2][1][0];
                    Player.currentPlayer.oldStaff = Player.equippedItems[2][0];
                    Player.currentPlayer.staffA += Player.equippedItems[2][0];
                    EquipScreen frame = new EquipScreen(2,1,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[2][0]);
                    }
            });
            p3.add(staff2);
            JButton staff3 = new JButton (Integer.toString(Player.items[2][2][0]));
            staff3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.staffA = Player.currentPlayer.staffA - Player.currentPlayer.oldStaff;
                    Player.equippedItems[2][0] = Player.items[2][2][0];
                    Player.currentPlayer.oldStaff = Player.equippedItems[2][0];
                    Player.currentPlayer.staffA += Player.equippedItems[2][0];
                    EquipScreen frame = new EquipScreen(2,2,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[2][0]);
                    }
            });
            p3.add(staff3);
            
            JLabel swords = new JLabel("Swords: ");
            p3.add(swords);
            JButton sword1 = new JButton (Integer.toString(Player.items[3][0][0]));
            sword1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.swordA = Player.currentPlayer.swordA - Player.currentPlayer.oldSword;
                    Player.equippedItems[3][0] = Player.items[3][0][0];
                    Player.currentPlayer.oldSword = Player.equippedItems[3][0];
                    Player.currentPlayer.swordA += Player.equippedItems[3][0];
                    EquipScreen frame = new EquipScreen(3,0,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[3][0]);
                    }
            });
            p3.add(sword1);
            JButton sword2 = new JButton (Integer.toString(Player.items[3][1][0]));
            sword2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.swordA = Player.currentPlayer.swordA - Player.currentPlayer.oldSword;
                    Player.equippedItems[3][0] = Player.items[3][1][0];
                    Player.currentPlayer.oldSword = Player.equippedItems[3][0];
                    Player.currentPlayer.swordA += Player.equippedItems[3][0];
                    EquipScreen frame = new EquipScreen(3,1,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[3][0]);
                    }
            });
            p3.add(sword2);
            JButton sword3 = new JButton (Integer.toString(Player.items[3][2][0]));
            sword3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.swordA = Player.currentPlayer.swordA - Player.currentPlayer.oldSword;
                    Player.equippedItems[3][0] = Player.items[3][2][0];
                    Player.currentPlayer.oldSword = Player.equippedItems[3][0];
                    Player.currentPlayer.swordA += Player.equippedItems[3][0];
                    EquipScreen frame = new EquipScreen(3,2,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[3][0]);
                    }
            });
            p3.add(sword3);

            JLabel bows = new JLabel("Bows: ");
            p3.add(bows);
            JButton bow1 = new JButton (Integer.toString(Player.items[4][0][0]));
            bow1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.rangeA = Player.currentPlayer.rangeA - Player.currentPlayer.oldBows;
                    Player.equippedItems[4][0] = Player.items[4][0][0];
                    Player.currentPlayer.oldBows = Player.equippedItems[4][0];
                    Player.currentPlayer.rangeA += Player.equippedItems[4][0];
                    EquipScreen frame = new EquipScreen(4,0,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[4][0]);
                    }
            });
            p3.add(bow1);
            JButton bow2 = new JButton (Integer.toString(Player.items[4][1][0]));
            bow2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.rangeA = Player.currentPlayer.rangeA - Player.currentPlayer.oldBows;
                    Player.equippedItems[4][0] = Player.items[4][1][0];
                    Player.currentPlayer.oldBows = Player.equippedItems[4][0];
                    Player.currentPlayer.rangeA += Player.equippedItems[4][0];
                    EquipScreen frame = new EquipScreen(4,1,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[4][0]);
                    }
            });
            p3.add(bow2);
            JButton bow3 = new JButton (Integer.toString(Player.items[4][2][0]));
            bow3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.rangeA = Player.currentPlayer.rangeA - Player.currentPlayer.oldBows;
                    Player.equippedItems[4][0] = Player.items[4][2][0];
                    Player.currentPlayer.oldBows = Player.equippedItems[4][0];
                    Player.currentPlayer.rangeA += Player.equippedItems[4][0];
                    EquipScreen frame = new EquipScreen(4,2,0,'c');
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[4][0]);
                    }
            });
            p3.add(bow3);
            if (context == 'c')
            {
                JLabel healthPotions = new JLabel("Health Potions: ");
                p3.add(healthPotions);
                JButton healthPotion1 = new JButton (Integer.toString(Player.items[5][0][0]));
                healthPotion1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.health = Player.currentPlayer.health - Player.currentPlayer.oldHealth;
                    Player.equippedItems[5][0] = Player.items[5][0][0];
                    Player.currentPlayer.oldHealth = Player.equippedItems[5][0];
                    Player.currentPlayer.health += Player.equippedItems[5][0];
                    Player.currentPlayer.totalHealthPotions += 1;
                    EquipScreen frame = new EquipScreen(5,0,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[5][0]);
                    }
                });
                p3.add(healthPotion1);
                JButton healthPotion2 = new JButton (Integer.toString(Player.items[5][1][0]));
                healthPotion2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.health = Player.currentPlayer.health - Player.currentPlayer.oldHealth;
                    Player.equippedItems[5][0] = Player.items[5][1][0];
                    Player.currentPlayer.oldHealth = Player.equippedItems[5][0];
                    Player.currentPlayer.health += Player.equippedItems[5][0];
                    Player.currentPlayer.totalHealthPotions += 1;
                    EquipScreen frame = new EquipScreen(5,1,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[5][0]);
                    }
                });
                p3.add(healthPotion2);
                JButton healthPotion3 = new JButton (Integer.toString(Player.items[5][2][0]));
                healthPotion3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.health = Player.currentPlayer.health - Player.currentPlayer.oldHealth;
                    Player.equippedItems[5][0] = Player.items[5][2][0];
                    Player.currentPlayer.oldHealth = Player.equippedItems[5][0];
                    Player.currentPlayer.health += Player.equippedItems[5][0];
                    Player.currentPlayer.totalHealthPotions += 1;
                    EquipScreen frame = new EquipScreen(5,2,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[5][0]);
                    }
                });
                p3.add(healthPotion3);

                JLabel staminaPotions = new JLabel("Stamina Potions: ");
                p3.add(staminaPotions);
                JButton staminaPotion1 = new JButton (Integer.toString(Player.items[6][0][0]));
                staminaPotion1.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.stamina = Player.currentPlayer.stamina - Player.currentPlayer.oldStamina;
                    Player.equippedItems[6][0] = Player.items[6][0][0];
                    Player.currentPlayer.oldStamina = Player.equippedItems[6][0];
                    Player.currentPlayer.stamina += Player.equippedItems[6][0];
                    Player.currentPlayer.totalStaminaPotions += 1;
                    EquipScreen frame = new EquipScreen(6,0,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[5][0]);
                    }
                });
                p3.add(staminaPotion1);
                JButton staminaPotion2 = new JButton (Integer.toString(Player.items[6][1][0]));
                staminaPotion2.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.stamina = Player.currentPlayer.stamina - Player.currentPlayer.oldStamina;
                    Player.equippedItems[6][0] = Player.items[6][1][0];
                    Player.currentPlayer.oldStamina = Player.equippedItems[6][0];
                    Player.currentPlayer.stamina += Player.equippedItems[6][0];
                    Player.currentPlayer.totalStaminaPotions += 1;
                    EquipScreen frame = new EquipScreen(6,1,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[5][0]);
                    }
                });
                p3.add(staminaPotion2);
                JButton staminaPotion3 = new JButton (Integer.toString(Player.items[6][2][0]));
                staminaPotion3.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    Player.currentPlayer.stamina = Player.currentPlayer.stamina - Player.currentPlayer.oldStamina;
                    Player.equippedItems[6][0] = Player.items[6][1][0];
                    Player.currentPlayer.oldStamina = Player.equippedItems[6][0];
                    Player.currentPlayer.stamina += Player.equippedItems[6][0];
                    Player.currentPlayer.totalStaminaPotions += 1;
                    EquipScreen frame = new EquipScreen(6,1,0,DisplayItemsMain.context2);
                    frame.setTitle("You've Equiped...");

                    frame.setSize(700, 700);

                    frame.setLocationRelativeTo(null); // Center the frame
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    frame.setVisible(true);
                    JComponent x = (JComponent) e.getSource();
                    JFrame oldFrame = (JFrame) x.getRootPane().getParent();
                    oldFrame.dispose();
                    System.out.println("Equiped Helmet: " + Player.equippedItems[5][0]);
                    }
                });
                p3.add(staminaPotion3);
            }
            

            //will only show back to battle if during combat, and if not will show back and it will go to the main menu. will only show potions if coming from battle


        //back to main screen
        JPanel p5;
        if (context == 'm')
        {
            p5 = new JPanel(new GridLayout(1, 2));
            JButton save = new JButton ("Save Game");
            p5.add(save);
            save.addActionListener((ActionListener) listener);
            JButton back = new JButton("Back");
            p5.add(back);
            back.addActionListener((ActionListener) listener);
        }
        else {
            p5 = new JPanel(new GridLayout(1, 1));
            JButton back = new JButton("Back to the Battle!");
            p5.add(back);
            back.addActionListener((ActionListener) listener);
        }
        
        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.CENTER);
        p4.add(p1, BorderLayout.WEST);
        p4.add(p5, BorderLayout.SOUTH);



        // Create panel p2 to hold a text field and p1
        JPanel p2 = new JPanel(new BorderLayout());

        add(new JLabel("Inventory"), BorderLayout.NORTH);

        add(p4, BorderLayout.CENTER);

        //make new listener class -- or add them to the current class

    }
}

class EquipScreen extends JFrame
{
    public EquipScreen(int r, int c, int m, char context)
    {
        JPanel nameScreen = new JPanel(new BorderLayout());
        JPanel p1 = new JPanel(new GridLayout(3,1));
        String item = "";
        String skill = "";
        String increase = "";
        switch (r)
        {
            case 0:
            {
                item = "helmet";
                skill = "defense";
                increase = "Your new " + skill + " is " + Player.currentPlayer.defense;
                break;
            }
            case 1:
            {
                item = "robe";
                skill = "magic";
                increase = "All spells have gone up by " + Player.items[r][c][m];
                break;
            }
            case 2:
            {
                item = "staff";
                skill = "staff attack";
                increase = "Your new " + skill + " is " + Player.currentPlayer.staffA;
                break;
            }
            case 3:
            {
                item = "sword";
                skill = "sword attack";
                increase = "Your new " + skill + " is " + Player.currentPlayer.swordA;
                break;
            }
            case 4:
            {
                item = "bow";
                skill = "ranged attack";
                increase = "Your new " + skill + " is " + Player.currentPlayer.rangeA;
                break;
            }
            case 5:
            {
                item = "health potion";
                skill = "health";
                increase = "Your new " + skill + " is " + Player.currentPlayer.health;
                break;
            }
            case 6:
            {
                item = "stamina potion";
                skill = "stamina";
                increase = "Your new " + skill + " is " + Player.currentPlayer.stamina;
                break;
            }
        }
        
        p1.add(new JLabel("You have taken a " + item + " raising your " + skill + " by " + Player.items[r][c][m] + " points.", SwingConstants.CENTER));
        p1.add(new JLabel(increase, SwingConstants.CENTER));
        add(p1,BorderLayout.CENTER);
        JButton cont;
        if (context == 'm')
        {
            cont = new JButton("Continue");
        }
        else{
            cont = new JButton("Back to the Battle!");
        }
        
        ListenerCharacter listener = new ListenerCharacter();
        cont.addActionListener((ActionListener) listener);
        add(cont,BorderLayout.SOUTH);




    }
}

class StoreDisplay extends JFrame
{
    public StoreDisplay()
    {
        JPanel p1 = Player.currentPlayer.getPlayerStats();

        //p1.add(new JLabel (player.));
        // add all stats in here
        ListenerCharacter listener = new ListenerCharacter();
        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(7,1));

        // Add buttons to the panel
        if (!Player.currentPlayer.hasBow)
        {
            JButton bow = new JButton("Buy Bow: 50 Gold");
            p3.add(bow);
            bow.addActionListener(listener);
        }
        if (!Player.currentPlayer.hasStaff)
        {
            JButton staff = new JButton("Buy Staff: 50 Gold");
            p3.add(staff);
            staff.addActionListener(listener);
        }
        if (!Player.currentPlayer.hasSword)
        {
            JButton sword = new JButton("Buy Sword: 50 Gold");
            p3.add(sword);
            sword.addActionListener(listener);
        }
        if (!Player.currentPlayer.knowsAquensKiss)
        {
            JButton kiss = new JButton("Buy Aquens Kiss: 100 Gold");
            p3.add(kiss);
            kiss.addActionListener(listener);
        }
        if (!Player.currentPlayer.knowsFirefrost)
        {
            JButton frost = new JButton("Buy Fire Frost: 100 Gold");
            p3.add(frost);
            frost.addActionListener(listener);
        }
        if (!Player.currentPlayer.knowsHellsWrath)
        {
            JButton wrath = new JButton("Buy Hells Wrath: 100 Gold");
            p3.add(wrath);
            wrath.addActionListener(listener);
        }
        if (!Player.currentPlayer.knowsIceDale)
        {
            JButton dale = new JButton("Buy Ice Dale: 100 Gold");
            p3.add(dale);
            dale.addActionListener(listener);
        }
        
        // put stats with other stuff on left
        //JButton stats = new JButton("Stats");
        //p3.add(stats);

        //add listeners

        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.EAST);
        p4.add(p1, BorderLayout.CENTER);
        JButton back = new JButton("Back");
        p4.add(back, BorderLayout.SOUTH);
        back.addActionListener(listener);

        // Create panel p2 to hold a text field and p1
        JPanel p2 = new JPanel(new BorderLayout());

        add(new JLabel("Main Screen"), BorderLayout.NORTH);

        add(p4, BorderLayout.CENTER);
        
    }

}

class StatsScreen extends JFrame
{
    StatsScreen()
    {


        // Create panel p1 for the buttons and set GridLayout
        JPanel p1 = new JPanel();

        p1.setLayout(new GridLayout(1, 3));
        p1.add(new JLabel ("Total Kills: " + Player.currentPlayer.totalKills, SwingConstants.CENTER));
        p1.add(new JLabel ("Total Stamina Potions Drunk: " + Player.currentPlayer.totalStaminaPotions, SwingConstants.CENTER));
        p1.add(new JLabel ("Total Health Potions Drunk: " + Player.currentPlayer.totalHealthPotions, SwingConstants.CENTER));

        JPanel p3 = new JPanel();
        p3.setLayout(new GridLayout(1, 3));

        ImageIcon kills = new ImageIcon ("kills.jpg");
        ImageIcon stamina = new ImageIcon ("greenPotion.jpg");
        ImageIcon health = new ImageIcon ("redPotion.jpg");
        p3.add(new JLabel (kills));
        p3.add(new JLabel (stamina));
        p3.add(new JLabel (health));

        //add listeners
        //continue building panel
        JPanel p4 = new JPanel(new BorderLayout());
        p4.add(p3, BorderLayout.SOUTH);
        p4.add(p1, BorderLayout.CENTER);
        ActionListener listener = new ListenerCharacter();

        JPanel p2 = new JPanel(new BorderLayout());
        JButton back = new JButton ("Back");

        add(p4, BorderLayout.CENTER);
        add(back, BorderLayout.SOUTH);

        back.addActionListener((ActionListener) listener);

        //add window event- when go to a dif screen goes invisible

    }
}
