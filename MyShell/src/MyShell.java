
public class MyShell {
	
	private String mName;
	private String mPrompt;
	private String[] mInput;
	private String mCwd;
	private boolean mIsActive;
	
	public MyShell() {
		mName = "[MyShell]";
		mPrompt = "$>";
		mCwd = System.getProperty("user.dir");
		mIsActive = true;
	}
}
