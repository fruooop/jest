package fun.nothaving.jest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	CreatureListener cListen = new CreatureListener(this);
	
	//When the plugin starts
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		PlayerListener pListen = new PlayerListener(this);
		getLogger().info("Jest has been enabled.");
		pm.registerEvents(pListen, this);
		pm.registerEvents(cListen, this);
	}
	
	//When the plugin ends/disables
	@Override
	public void onDisable() {
		getLogger().info("Jest has been disabled.");
	}
	
	//When command is typed
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player steve = (Player) sender;
		Commands com = new Commands();
		
		//if the command is sent by a player
		if(sender instanceof Player) {
			//gets command string
			String commandStr = cmd.getName();
			
			//Command switch statement
			switch(commandStr) {
				
				case "setMobDifficulty":
					//modifies mob difficulty
					com.forcedMobDifficulty(cListen, args);
					return true;
				default:
					steve.sendMessage("Your command was not recognized.");
					return true;
			
			}
		}
		
		
		return false;
	}
	
	
}
