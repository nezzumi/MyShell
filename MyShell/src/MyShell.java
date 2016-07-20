import java.util.HashMap;
import java.util.Map;


public class MyShell {
	
	private String 				mName;		//shellname
	private String 				mPrompt;		//prompt
	private String[] 				mInputs;		//user imputs convert to array
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
	
	
}
