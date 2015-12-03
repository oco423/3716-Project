 import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class electionPanel {

	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			electionPanel window = new electionPanel();
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
		shell.setSize(702, 501);
		shell.setText("SWT Application");
		
		Label lblMunSocieties = new Label(shell, SWT.NONE);
		lblMunSocieties.setBounds(286, 34, 120, 35);
		lblMunSocieties.setText("MUN Societies");
		
		Label lblElectionPanel = new Label(shell, SWT.NONE);
		lblElectionPanel.setBounds(286, 63, 100, 35);
		lblElectionPanel.setText("Election Panel");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(239, 273, 220, 23);
		
		Label lblWhoAreYou = new Label(shell, SWT.NONE);
		lblWhoAreYou.setBounds(30, 276, 166, 23);
		lblWhoAreYou.setText("Who are you voting for?");
		
		Button btnVote = new Button(shell, SWT.NONE);
		btnVote.setBounds(93, 373, 90, 30);
		btnVote.setText("Vote");
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setBounds(30, 134, 70, 20);
		lblName.setText("Name: ");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(239, 131, 220, 26);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(239, 200, 220, 26);
		
		Label lblStudentId = new Label(shell, SWT.NONE);
		lblStudentId.setBounds(30, 206, 70, 20);
		lblStudentId.setText("Student ID");
		
		Button btnBack = new Button(shell, SWT.NONE);
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnBack.setBounds(418, 373, 90, 30);
		btnBack.setText("Back");

	}
}
