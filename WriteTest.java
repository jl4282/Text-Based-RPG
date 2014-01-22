
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class WriteTest {

    WriteTest()
    {
    try
    {
        BufferedWriter out = new BufferedWriter(new FileWriter("TestFile"));
        out.write(Player.currentPlayer.name + " " + Player.currentPlayer.playerClass +
                " " + Player.currentPlayer.health + " " +
                Player.currentPlayer.healthMax + " " + Player.currentPlayer.level + " " +
                Player.currentPlayer.mana + " " + Player.currentPlayer.manaTotal + " " +
                Player.currentPlayer.stamina + " " + Player.currentPlayer.totalStamina + " " +
                Player.currentPlayer.attack + " " + Player.currentPlayer.magicA + " " + 
                Player.currentPlayer.rangeA + " " + Player.currentPlayer.staffA + " " +
                Player.currentPlayer.swordA + " " + Player.currentPlayer.restoreHealth + " " +
                Player.currentPlayer.aquensKiss + " " + Player.currentPlayer.fireFrost + " " +
                Player.currentPlayer.hellsWrath + " " + Player.currentPlayer.iceDale + " " +
                Player.currentPlayer.experience + " " + Player.currentPlayer.expNeeded + " " +
                Player.currentPlayer.defense);
        if (Player.currentPlayer.knowsAquensKiss)
        {
            out.write(" true");
        }
        else out.write(" false");
        if (Player.currentPlayer.knowsFirefrost)
        {
            out.write(" true");
        }
        else out.write(" false");
        if (Player.currentPlayer.knowsHellsWrath)
        {
            out.write(" true");
        }
        else out.write(" false");
        if (Player.currentPlayer.knowsIceDale)
        {
            out.write(" true");
        }
        else out.write(" false");
        
        if (Player.currentPlayer.hasBow)
        {
            out.write(" true");
        }
        else out.write(" false");
        if (Player.currentPlayer.hasStaff)
        {
            out.write(" true");
        }
        else out.write(" false");
        if (Player.currentPlayer.hasSword)
        {
            out.write(" true");
        }
        else out.write(" false");
        out.write(" " + Player.currentPlayer.gold);
        out.write(" " + Player.currentPlayer.totalHealthPotions);
        out.write(" " + Player.currentPlayer.totalKills);
        out.write(" " + Player.currentPlayer.totalStaminaPotions);
        out.close();
    }
    catch (IOException e)
    {
    }
    
}


}
