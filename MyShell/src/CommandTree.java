import java.io.File;

public class CommandTree implements ShellCommand {
	
	private MyShell mShell;
	
	public CommandTree(MyShell newShell) {
		mShell = newShell;
	}
	
	private void searchTree( File file, int depth ) {
		File[] files = file.listFiles();
		String _depth = new String(new char[depth]).replace('\0', '-');
		if ( files != null ) {
			for( File _file:files ) {
				if( (_file.isDirectory())) {
					System.out.println(_depth + _file.getName());
					searchTree(_file, depth+1);
				}
			}
		}
	}

	@Override
	public void execute() {
		File file = new File(mShell.getCwd());
		System.out.println(file.getName());
		searchTree( file, 1);
	}

}
