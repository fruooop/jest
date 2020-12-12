package fun.nothaving.jest;

public class Commands {
	public Commands() {
		
	}
	
	public void forcedMobDifficulty(CreatureListener cre, String[] args) {
		//Checks to see if command has one or more arguments.
		if(args.length > 0) {
			switch(args[0]) {
				case "easy":
					cre.swMobDifficulty(1);
					break;
				case "medium":
					cre.swMobDifficulty(2);
					break;
				case "hard":
					cre.swMobDifficulty(3);
					break;
				default:
					cre.swMobDifficulty();
					break;
			}
			
		}
		//If the command didnt have more arguments
		else {
			cre.swMobDifficulty();
		}
		
	}
}
