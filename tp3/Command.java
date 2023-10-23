package nemo;

import java.util.List;



public abstract class Command{
	 
	public static List<Command> commands = List.of(
            new CommandCapsule(),
            new CommandRight(),
            new CommandUp(),
            new CommandDown(),
            new CommandForward(),
            new CommandLeft()
    );
	public abstract void execute(Nemo nemo);
	public abstract boolean canHandle(char comando);
	
	
	
	public static Command CommandFor(char comando) {
		return  commands.stream()
					.filter(command -> command.canHandle(comando))
					.findFirst()
					.get();
					
		
	}
}

