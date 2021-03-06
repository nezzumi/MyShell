
public class CommandPrompt implements ShellCommand {

	private MyShell mShell;
	
	public CommandPrompt(MyShell newShell) {
		mShell = newShell;
	}
	
	@Override
	public void execute() {		
		String[] arg = mShell.getImputs();	
		if( arg.length > 2 ) {
			System.out.println("Prompt : to many arguments");
		} else if( arg.length == 1 ) {
			System.out.println("Prompt : not enough arguments ");
		} else {
			switch( arg[1] ) {
				case "reset": {
					mShell.setPrompt("$");
					break;
				}
				case "$cwd": {
					mShell.setPromptCwd();
					break;
				}
				default: {
					mShell.setPrompt(arg[1]);
					break;
				}
			}
		}
	}
}
