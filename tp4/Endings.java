package linea;

import java.util.List;



public abstract class Endings {
		
		 public abstract boolean execute();
		 public abstract char getCaracter();
		 
		 public static List<Endings> Types = List.of(
				 	new VictoryTypeA('A'),
		 			new VictoryTypeB('B'),
		 			new VictoryTypeC('C')
				 );
		 
		
		public static boolean EndingFor(char Gamemode) {		
		 Endings matchingVictoryType=Types.stream()
				 		 .filter(Type->Type.getCaracter()==Gamemode)
						 .findFirst()
						 .orElseThrow(()->new Error ("Gamemode Not Found"));
		
		return  matchingVictoryType.execute()||Linea.draw();
		

	}
	
			
		

}
