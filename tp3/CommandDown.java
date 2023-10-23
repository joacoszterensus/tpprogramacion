package nemo;

public class CommandDown extends Command{
	public char key = 'd';
	public boolean canHandle(char command) {
        return command==key;
    }
	public void execute(Nemo nemo) {
		nemo.descend();
		
	}
	
} 