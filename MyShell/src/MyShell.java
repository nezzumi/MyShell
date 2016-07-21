import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MyShell {
	
	private String 				mName;		//shellname
	private StringBuilder			mPrompt;		//prompt
	private String[]				mInputs;		//user imputs convert to array
	private StringBuilder			mCwd;		//current working dir
	private boolean 				mIsActive;	//running after false
	private Map<String, ShellCommand> 	mCommands;	//all supported commands
	
	
	public MyShell() {
		mName = "[MyShell]";
		mPrompt = new StringBuilder("$");
		mCwd = new StringBuilder(System.getProperty("user.dir"));
		mIsActive = true;
		mCommands = new HashMap<String, ShellCommand>();
	}
	
	public void setPrompt(String newPrompt) {
		mPrompt.replace(0, mPrompt.length(), newPrompt);
	}

	public void setCwd(String newCwd) {
		mCwd.replace(0, mCwd.length(), newCwd);
	}

	public void setPromptCwd() {
		mPrompt = mCwd;
	}

	
	public String[] getImputs() {
		return mInputs;
	}

	public String getShellName() {
		return mName;
	}
	
	public String getCwd() {
		return mCwd.toString();
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
			System.out.print(this.toString() + '>');
			mInputs = input.nextLine().split(" ");
			parseInput();
		}
		input.close();
	}
	
	private void parseInput() {
		if( mCommands.containsKey(mInputs[0])) {
			mCommands.get(mInputs[0]).execute();
		} else {
			System.out.println(mInputs[0] +" : unkown command");
		}
	}

	public String toString() {
		return mName + ' ' + mPrompt;
	}

}
