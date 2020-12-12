# Jest 0.1.1
---
## Overview
The plugin jest is designed to increase the difficulty of survival Minecraft.
Specifically, hardcore mode.

---
##Installation
Download *"Jest0-1-1.jar"* and put it in the plugins folder of a bukkit server.

---
## Commands
Currently, there are 3 commands:
| Command | Usage |
|---------|-------|
|*-*|Upon first time spawning in a world, it will spawn the player to a random x and z value withing *10000 blocks* of spawn.|
|/setMobDifficulty [easy/medium/hard]|Using this command without parameters will toggle it off and on. **Easy** forces all Zombies to have *Wooden Swords*, forces Creepers to have *Resistance 1*, and Spiders have *Speed 1* and *Resistance 1*. **Medium** forces all Zombies to have *Iron Swords*, forces Skeletons to have *Speed 2*, forces Creepers to have *Resistance 2* and *Speed 1*, and Spiders have *Speed 2* and *Resistance 2*. **Hard** forces all Zombies to have *Diamond Swords*, forces Skeletons to have *Invisibility*, forces Creepers to have *Fire Resistance* *Resistance 4* and *Speed 3*, and Spiders have *Fire Resistance* *Resistance 4* and *Speed 4*.|
|/togglePlayerEffects|Toggles the difficulty player effects on or off. **Running** for *250 ticks* will give the player *Confusion 6* and *Hunger 1* for *100 ticks*. **Swimming** for *100 ticks* will give the player *Blindness 3* for *75 ticks*.|
|/getJestStatus|Shows status of whats enabled, and the difficulty settings if applicable.|

---
## Code Notes
None.

---
