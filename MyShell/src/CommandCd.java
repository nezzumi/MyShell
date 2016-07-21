import java.io.File;

public class CommandCd implements ShellCommand {

	private MyShell mShell;
	
	public CommandCd(MyShell newShell) {
		mShell = newShell;
	}
	
	private void goToParent() {
		String parent = new File(mShell.getCwd()).getParent();
		if(parent != null) {
			mShell.setCwd(parent);
		}		
	}
	
	private void switchDir(String arg) {
		File file = new File(mShell.getCwd()+'\\'+arg);
		if( file.exists() ) {
			mShell.setCwd(file.getPath());
		} else {
			System.out.println(arg + " : director not exist");
		}
	}
	
	@Override
	public void execute() {
		String[] arg = mShell.getImputs();
		if( arg.length > 2)
			System.out.println("cd : to many arguments");
		else if( arg.length < 1 )
			System.out.println("cd : not enough");
		else 
			switch( arg[1] ) {
				case "..": {
					goToParent();
					break;
				}
				default: {
					switchDir(arg[1]);
					break;
				}
			}
	}

}
