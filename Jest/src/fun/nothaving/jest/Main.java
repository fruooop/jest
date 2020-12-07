package fun.nothaving.jest;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	@Override
	public void onEnable() {
		getLogger().info("Jest has been enabled.");
	}
	@Override
	public void onDisable() {
		getLogger().info("Jest has been disabled.");
	}
}
