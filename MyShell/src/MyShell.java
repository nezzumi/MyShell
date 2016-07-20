import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MyShell {
	
	private String 				mName;		//shellname
	private String 				mPrompt;		//prompt
	private String[]				mInputs;		//user imputs convert to array
	private String 				mCwd;		//current working dir
	private boolean 				mIsActive;	//running after false
	private Map<String, ShellCommand> 	mCommands;	//all supproted commands
	
	
	public MyShell() {
		mName = "[MyShell]";
		mPrompt = "$>";
		mCwd = System.getProperty("user.dir");
		mIsActive = true;
		mCommands = new HashMap<String, ShellCommand>();
	}
	
	public void setPrompt(String newPrompt) {
		mPrompt = newPrompt;
	}

	public void setCwd(String newCwd) {
		mCwd = newCwd;
	}

	public String[] getImputs() {
		return mInputs;
	}

	public void installCommand(String name, ShellCommand newCommand) {
		
		if( mCommands.get(name) != null ) {
			System.out.println(name + ": command already installed" );
		} else {
			mCommands.put(name, newCommand);
		}
	}

	public void quitShell() {
		mIsActive = false;
	}
	
	public void runShell() {
		
		Scanner input = new Scanner(System.in);
		
		while(mIsActive) {
			System.out.print(this);
			mInputs = input.nextLine().split(" ");
		}
		
		input.close();
	}


}
