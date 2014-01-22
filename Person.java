/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NYU User
 */
public class Person {
// all are set to 0 as backup so that I don't get null exception
    int health = 0;
    int attack = 0;
    int swordA = 0;
    int staffA = 0;
    int magicA = 0;
    int defense = 0;
    int rangeA = 0;
    String name;
    String weakness;
    
    public Person()
    {
        this("Default");
        
    }
    
    public Person( String newName )
    {
        health = 100;
        attack = 10;
        swordA = 10;
        staffA = 10;
        magicA = 10;
        defense = 25;
        rangeA = 25;
        name = newName;
    }
    
    public int getAttack()
    {
        return attack;
    }

    public int getHealth()
    {
        return health;
    }

    public void addHealth(int newHealth)//used for battles as well
    {
        health = health + newHealth;
    }

    public boolean isDead()
    {
        if (health < 0)
            return true;
        return false;
    }
    public void boostAttack(int stat, int mult)
    {
        switch (stat)
        {
            case 1:
            {
                attack = attack * mult;
                break;
            }
            case 2:
            {
                swordA = swordA * mult;
                break;
            }
            case 3:
            {
                staffA = staffA * mult;
                break;
            }
            case 4:
            {
                magicA = magicA * mult;
                break;
            }
            case 5:
            {
                rangeA = rangeA * mult;
                break;
            }
        }//end switch
    }//end boost attack

    public void printStats()
    {
        System.out.println(name + ":");
        System.out.println("Health:" + health);
        System.out.println("Attack:" + attack);
        System.out.println();
    }
}
