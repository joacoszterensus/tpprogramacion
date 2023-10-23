package nemo;

public class CommandLeft extends Command{
	public char key = 'l';
	
	public boolean canHandle(char command) {
        return command == key;
    }
	
	public void execute(Nemo nemo) {
		nemo.left();
		
	}
}