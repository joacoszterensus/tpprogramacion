package nemo;

public class CommandCapsule extends Command {
	char key = 'm';
	
	public boolean canHandle(char comando) {
		return key == comando;
	}
	public void execute(Nemo nemo) {
		nemo.launchCapsule();
		
	}

	
	

}
