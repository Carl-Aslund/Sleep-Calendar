package frontEnd;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class GUI {

	protected Shell shell;
	private Text text;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUI window = new GUI();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Label lblGreetings = new Label(shell, SWT.NONE);
		lblGreetings.setBounds(85, 40, 59, 14); // X-cord, Y-cord, width, height
		lblGreetings.setText("Greetings");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(98, 82, 64, 19); // X-cord, Y-cord, width, height
		text.setText("Type here");
		
		Button btnPressMe = new Button(shell, SWT.NONE);
		btnPressMe.setBounds(168, 73, 94, 28);
		btnPressMe.setText("Press Me"); // X-cord, Y-cord, width, height

	}
}
