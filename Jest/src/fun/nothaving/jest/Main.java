package fun.nothaving.jest;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	//When the plugin starts
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		PlayerListener pListen = new PlayerListener(this);
		getLogger().info("Jest has been enabled.");
		pm.registerEvents(pListen, this);
	}
	
	//When the plugin ends/disables
	@Override
	public void onDisable() {
		getLogger().info("Jest has been disabled.");
	}
	
	
}
