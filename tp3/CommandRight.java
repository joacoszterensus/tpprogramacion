package nemo;

public class CommandRight extends Command{
	public char key = 'r';
	public boolean canHandle(char command) {
        return command == key;
    }
	public void execute(Nemo nemo) {
		nemo.right();
		
	}
	
}