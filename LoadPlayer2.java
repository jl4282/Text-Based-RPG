import java.util.*;
import java.util.Scanner;
import java.io.*;

public class LoadPlayer2

//reads a file but does not count null line
{
	final static int BIG = 1;
	final static int MAX = 33;
	static  int  count;
        Database[] dv = new Database[BIG];



	LoadPlayer2()
	//read the database into the array
	{
		String line;


		File file = new File("TestFile");
		Scanner fileReader = null;

		try
		{
		    fileReader = new Scanner (file);
		}
		catch (Exception e)
		{
		    System.out.print("file " + file + " does not exisit");
		    System.exit(0);
		}

		count = 0;
		Database data;
		do
		{
			line = fileReader.nextLine();
			System.out.println(line);
			if(line != null && line.trim().length() != 0)//&& short circuits
			{
				data = new Database();
				readRecord(line, data);//deconstruct the line into elements of item
				dv[count] = data;
				count++;
			}
		} while(fileReader.hasNextLine());
		System.out.println("count is " + count);
                printArray(dv);
                loadCharacter();
	}

	public static void readRecord(String line, Database data)
	{
		StringTokenizer toke = new StringTokenizer(line);
		int k = 0;
		while( toke.hasMoreTokens() )
		{
			if (toke.countTokens() == 1) //this is the last token -- the integer
				data.item[k] = toke.nextToken();
			else
				data.item[k] = toke.nextToken();  //A string

			k++;
		}
	}

	public static void printArray(Database[] dv)
	{
		for(int j = 0; j < count; j++)
		{
			System.out.print (dv[j]);//prints the four elements
		}

	}

        public void loadCharacter()
        {
                Player.currentPlayer.name = (String) (dv[0].item[0]);
                Player.currentPlayer.playerClass = (String) (dv[0].item[1]);
                Player.currentPlayer.health = Integer.parseInt((String)(dv[0].item[2]));
                Player.currentPlayer.healthMax = Integer.parseInt((String)(dv[0].item[3]));
                Player.currentPlayer.level = Integer.parseInt((String)(dv[0].item[4]));
                Player.currentPlayer.mana = Integer.parseInt((String)(dv[0].item[5]));
                Player.currentPlayer.manaTotal = Integer.parseInt((String)(dv[0].item[6]));
                Player.currentPlayer.stamina = Integer.parseInt((String)(dv[0].item[7]));
                Player.currentPlayer.totalStamina = Integer.parseInt((String)(dv[0].item[8]));
                Player.currentPlayer.attack = Integer.parseInt((String)(dv[0].item[9]));
                Player.currentPlayer.magicA = Integer.parseInt((String)(dv[0].item[10]));
                Player.currentPlayer.rangeA = Integer.parseInt((String)(dv[0].item[11]));
                Player.currentPlayer.staffA = Integer.parseInt((String)(dv[0].item[12]));
                Player.currentPlayer.swordA = Integer.parseInt((String)(dv[0].item[13]));
                Player.currentPlayer.restoreHealth = Integer.parseInt((String)(dv[0].item[14]));
                Player.currentPlayer.aquensKiss = Integer.parseInt((String)(dv[0].item[15]));
                Player.currentPlayer.fireFrost = Integer.parseInt((String)(dv[0].item[16]));
                Player.currentPlayer.hellsWrath = Integer.parseInt((String)(dv[0].item[17]));
                Player.currentPlayer.iceDale = Integer.parseInt((String)(dv[0].item[18]));
                Player.currentPlayer.experience = Integer.parseInt((String)(dv[0].item[19]));
                Player.currentPlayer.expNeeded = Integer.parseInt((String)(dv[0].item[20]));
                Player.currentPlayer.defense = Integer.parseInt((String)(dv[0].item[21]));
                if ((dv[0].item[22]).compareTo("false") == 0)
                {
                    Player.currentPlayer.knowsAquensKiss = false;
                }
                else{
                    Player.currentPlayer.knowsAquensKiss = true;
                }
                if ((dv[0].item[23]).compareTo("false") == 0)
                {
                    Player.currentPlayer.knowsFirefrost = false;
                }
                else{
                    Player.currentPlayer.knowsFirefrost = true;
                }
                if ((dv[0].item[24]).compareTo("false") == 0)
                {
                    Player.currentPlayer.knowsHellsWrath = false;
                }
                else{
                    Player.currentPlayer.knowsHellsWrath = true;
                }
                if ((dv[0].item[25]).compareTo("false") == 0)
                {
                    Player.currentPlayer.knowsIceDale = false;
                }
                else{
                    Player.currentPlayer.knowsIceDale = true;
                }
                if ((dv[0].item[26]).compareTo("false") == 0)
                {
                    Player.currentPlayer.hasBow = false;
                }
                else{
                    Player.currentPlayer.hasBow = true;
                }
                if ((dv[0].item[27]).compareTo("false") == 0)
                {
                    Player.currentPlayer.hasStaff = false;
                }
                else{
                    Player.currentPlayer.hasStaff = true;
                }
                if ((dv[0].item[28]).compareTo("false") == 0)
                {
                    Player.currentPlayer.hasSword = false;
                }
                else{
                    Player.currentPlayer.hasSword = true;
                }
                Player.currentPlayer.gold = Integer.parseInt((String)(dv[0].item[29]));
                Player.currentPlayer.totalHealthPotions = Integer.parseInt((String)(dv[0].item[30]));
                Player.currentPlayer.totalKills = Integer.parseInt((String)(dv[0].item[31]));
                Player.currentPlayer.totalStaminaPotions = Integer.parseInt((String)(dv[0].item[32]));

        }


}

class Database
{
	final static int MAX = 33;
    Comparable[] item = new Comparable[MAX];

    public String toString ()
	{
		String s = "";
		for(int j = 0; j < MAX; j++)
		{
			s += item[j] + " ";
		}
		return s + "\n";
	}

}


