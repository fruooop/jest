package fun.nothaving.jest;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerListener implements Listener{
	boolean togglePlayerEffects = true;
	double timeSprint=0;
	double timeSwim=0;
	
	public PlayerListener(Main plugin) {

	}
	//------------------------------------------------------------
	//Active listener methods
	//------------------------------------------------------------
	
	//When a player joins
	@EventHandler
	public void onPlayerJoined(PlayerJoinEvent event) {
		Player steve = event.getPlayer();
		if(togglePlayerEffects) {
			ifFirstJoin(steve, event);
		}
		
	}
	
	
	//When a player moves
	@EventHandler
	public void movementCheck(PlayerMoveEvent event) {
		Player steve = event.getPlayer();
		if(togglePlayerEffects) {
			hasOverSprinted(steve, event);
			hasOverSwam(steve, event);
		}
		
	}
	
	
	//------------------------------------------------------------
	//Methods to help keep main methods easier to read, and shorter
	//------------------------------------------------------------
	
	public void ifFirstJoin(Player steve, PlayerJoinEvent event) {
		//Pre: Player, and a PlayerJoinEvent entity
		//Post: if its the first join, do the following:
		//1.)Teleport to a random x and z coordinate (Locked y-value to prevent getting stuck in wall)
		//	1a.)Adds 
		
		Random random = new Random();
		
		final int x = 10000; //Max x-value to teleport player
		final int y = 200; //y-value to teleport player
		final int z = 10000; //Max z-value to teleport player
		final int duration = 125; //Duration of slow falling potion effect
		
		//If player has NOT joined before
		if(!steve.hasPlayedBefore()) {
			//Teleport player to random x and z coordinate
			steve.teleport(new Location(steve.getWorld(), random.nextInt(x), y, random.nextInt(z)));
			steve.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 20, true, false));
		}
		
		//For testing randomized distances. Should be commented in release versions!
		//steve.teleport(new Location(steve.getWorld(), random.nextInt(x), y, random.nextInt(z)));
		//steve.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 20, true, false));
		
		
	}
	
	public void hasOverSprinted(Player steve, PlayerMoveEvent event) {
		//Pre: Player, and a PlayerMoveEvent entity
		//Post: Checks if player sprints for more than a certain time (x)
		
		final int x = 250; //Time limit Variable
		final int y = 100; //Potion Time Variable
		final int z = 6; //Potion Amplifier Variable
		
		//If the player is sprinting
		if(steve.isSprinting()) {
			//If the start of sprint - current time is greater than the time variable
			if(steve.getPlayerTime() - timeSprint > x) {
				steve.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, y, z));
				steve.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, y, 1));
				timeSwim = steve.getPlayerTime();
			}
		}
		//set or reset player time
		else {
			timeSprint = steve.getPlayerTime();
		}
	}
	
	public void hasOverSwam(Player steve, PlayerMoveEvent event) {
		//Pre: Player, and a PlayerMoveEvent entity
		//Post: Checks if player swims for more than a certain time (x)
		
		final int x = 100; //Time limit Variable
		final int y = 75; //Potion Time Variable
		final int z = 3; //Potion Amplifier Variable
		
		//If the player is swimming
		if(steve.isSwimming()) {
			//If the start of swim - current time is greater than the time variable
			if(steve.getPlayerTime() - timeSwim > x) {
				steve.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, y, z));
				timeSwim = steve.getPlayerTime();
			}
		}
		//set or reset player time
		else {
			timeSwim = steve.getPlayerTime();
		}
	}
	
	public void swPlayerEffects() {
		//switches playerEffects
		togglePlayerEffects = !togglePlayerEffects;
		if(togglePlayerEffects) {
			Bukkit.broadcastMessage(ChatColor.BLUE + "" +ChatColor.BOLD +"   Player Effects are ON");
		}
		else {
			Bukkit.broadcastMessage(ChatColor.BLUE + "" +ChatColor.BOLD +"   Player Effects are OFF");
		}
		
	}
	
	public void getInfo() {
		Bukkit.broadcastMessage(ChatColor.BLUE + "" +ChatColor.BOLD +"   togglePlayerEffects = " + togglePlayerEffects);
	}
	

	
}
