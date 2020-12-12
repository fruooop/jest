package fun.nothaving.jest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	CreatureListener cListen = new CreatureListener(this);
	PlayerListener pListen = new PlayerListener(this);
	
	//When the plugin starts
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
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
			
			//if player is opped
			if(steve.isOp()) {
				//Command switch statement
				switch(commandStr) {
				
				case "setMobDifficulty":
					//modifies mob difficulty
					com.forcedMobDifficulty(cListen, args);
					return true;
				case "togglePlayerEffects":
					//modifies player effects
					pListen.swPlayerEffects();
					return true;
				case "getJestStatus":
					//Gets status from listeners
					Bukkit.broadcastMessage(ChatColor.BLUE + "" +ChatColor.BOLD +"----------------------");
					Bukkit.broadcastMessage(ChatColor.BLUE + "" +ChatColor.BOLD +"[Jest Current Status]");
					pListen.getInfo();
					cListen.getInfo();
					Bukkit.broadcastMessage(ChatColor.BLUE + "" +ChatColor.BOLD +"----------------------");
					return true;
				default:
					steve.sendMessage("Your command was not recognized.");
					return true;
			
				}
			}
			else {
				steve.sendMessage("Your command was denied. Are you OP'ed?");
				return true;
			}
			
		}
		
		
		return false;
	}
	
	
}
