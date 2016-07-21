import java.io.File;

public class CommandCd implements ShellCommand {

	private MyShell mShell;
	
	public CommandCd(MyShell newShell) {
		mShell = newShell;
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
					String parent = new File(mShell.getCwd()).getParent();
					if(parent != null) {
						mShell.setCwd(parent);
					}
					break;
				}
			}
		
	}

}
