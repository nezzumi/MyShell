
public class CommandPrompt implements ShellCommand {

	MyShell mShell;
	
	public CommandPrompt(MyShell newShell) {
		mShell = newShell;
	}
	
	@Override
	public void execute() {		
		String[] arg = mShell.getImputs();
		
		if( arg.length > 2 ) {
			System.out.println("Prompt : to many arguments");
		} else {
			switch( arg[1] ) {
				case "reset": {
					mShell.setCwd("$");
					break;
				}
				case "$cwd": {
					System.out.println(mShell.getShellName() +' '+mShell.getCwd() );
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
