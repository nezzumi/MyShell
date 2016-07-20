import java.io.File;

public class CommandDir implements ShellCommand {

	private MyShell mShell;
	
	public CommandDir(MyShell newShell) {
		mShell = newShell;
	}

	@Override
	public void execute() {
		File[] files = new File(mShell.getCwd()).listFiles();
		System.out.println("Content of " + mShell.getCwd());
		
		for(File file : files) {
			if( file.isFile() ) {
				System.out.println("FILE\t" + file.getName());
			} else {
				System.out.println("DIR\t" + file.getName());
			}
		}
	}
}
