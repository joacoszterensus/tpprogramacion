package nemo;

public class CommandUp extends Command{
	public char key = 'u';
	public boolean canHandle(char command) {
        return command == key;
    }
	public void execute(Nemo nemo) {
		nemo.ascend();
		
	}

}