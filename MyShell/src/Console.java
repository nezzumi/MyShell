public class Console {

	public static void main(String[] args) {
		MyShell shell = new MyShell();
		
		shell.installCommand("prompt",new CommandPrompt(shell));
		shell.installCommand("dir", 	new CommandDir(shell));
		shell.installCommand("tree", 	new CommandTree(shell));

		shell.runShell();
	}
}
