package nemo;

public class CommandForward extends Command{
	public char key = 'f';
	public boolean canHandle(char command) {
        return command == key;
    }
	public void execute(Nemo nemo) {
		nemo.forward();
		
	}

}