public class Console {

	public static void main(String[] args) {
		MyShell shell = new MyShell();
		
		shell.installCommand("prompt", new CommandPrompt(shell));
		
		shell.runShell();
	}
}
