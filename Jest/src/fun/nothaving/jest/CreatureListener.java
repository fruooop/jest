package fun.nothaving.jest;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class CreatureListener implements Listener{
	
	boolean enableMobDiff = true;
	int weapMode = 2;
	
	public CreatureListener(Main plugin) {
		
	}
	
	//------------------------------------------------------------
	//Active listener methods
	//------------------------------------------------------------
	
	//When a mob spawns
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event) {
		LivingEntity creature = event.getEntity();
		
		//If enableMobDifficulty is enabled
		if(enableMobDiff) {
			//Forces mobs to spawn with added attributes
			setMobDifficulty(creature);
		}
		
	}
	
	
	//------------------------------------------------------------
	//Methods to help keep main methods easier to read, and shorter
	//------------------------------------------------------------
	
	public void setMobDifficulty(LivingEntity creature) {
		//Pre: A LivingEntity Entity
		//Post: Manipulates the mobs in different ways
		
		//If the entity is a zombie
		if(creature.getType() == EntityType.ZOMBIE) {
			
			//Switch for the different weapon modes
			switch(weapMode) {
				case 1:
					//Equips zombies with wooden swords
					creature.getEquipment().setItemInMainHand(new ItemStack(Material.WOODEN_SWORD, 1));
					break;
				case 2:
					//Equips zombies with iron swords
					creature.getEquipment().setItemInMainHand(new ItemStack(Material.IRON_SWORD, 1));
					break;
				case 3:
					//Equips zombies with diamond swords
					creature.getEquipment().setItemInMainHand(new ItemStack(Material.DIAMOND_SWORD, 1));
					break;
				default:
					//This should not happen
					creature.getEquipment().setItemInMainHand(new ItemStack(Material.CARROT_ON_A_STICK, 1));
					break;
			}
		}
		
		
		//If the entity is a Spider
		if(creature.getType() == EntityType.SPIDER) {
					
			//Switch for the different weapon modes
			switch(weapMode) {
				case 1:
					//Gives Spider potions
					creature.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 1, true, false));
					creature.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 1, true, false));
					break;
				case 2:
					//Equips zombies with iron swords
					creature.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2, true, false));
					creature.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2, true, false));
					break;
				case 3:
					//Equips zombies with diamond swords
					creature.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, Integer.MAX_VALUE, 2, true, false));
					creature.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 4, true, false));
					creature.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 4, true, false));
					break;
				default:
					//This should not happen
					creature.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, Integer.MAX_VALUE, 20, true, false));
					break;
			}
		}
		
	}
	
	//------------------------------------------------------------
	//getters and setters
	//------------------------------------------------------------
	
	public void swMobDifficulty() {
		//Inverts enableMobDiff's value
		enableMobDiff = !enableMobDiff;
	}
	public void swMobDifficulty(int mode) {
		if(!enableMobDiff) {
			swMobDifficulty();
		}
		weapMode = mode;
		switch(mode) {
			case 1:
				//Easy Mode
				Bukkit.broadcastMessage("[Easy Mode Enabled]");
				break;
			case 2:
				//Medium Mode
				Bukkit.broadcastMessage("[Medium Mode Enabled]");
				break;
			case 3:
				//Hard Mode
				Bukkit.broadcastMessage("[Hard Mode Enabled]");
				break;
			default:
				break;
		}
	}
}
