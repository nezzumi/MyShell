
public class CommandExit implements ShellCommand {

	private MyShell mShell;
	
	public CommandExit(MyShell shell) {
		mShell = shell;
	}
	
	@Override
	public void execute() {
		mShell.quitShell();
	}

}
