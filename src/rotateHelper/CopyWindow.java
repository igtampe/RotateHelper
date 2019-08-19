package rotateHelper;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Object;
public class CopyWindow {

	//private static final long serialVersionUID = 1L;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyWindow window = new CopyWindow(args);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CopyWindow(String[] args) {
		initialize(args);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize(String[] args) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		
		//String[] doot= { "Value 1", "Value 2", "Value 3", "Value 4", "Value 5", "Value 2", "Value 3", "Value 4", "Value 5", "Value 2", "Value 3", "Value 4", "Value 5", "Value 2", "Value 3", "Value 4", "Value 5", "Value 2", "Value 3", "Value 4", "Value 5", "Value 2", "Value 3", "Value 4", "Value 5", "Value 2", "Value 3", "Value 4", "Value 5", "Value 2", "Value 3", "Value 4", "Value 5" };
		//String[] doot= { "Value 4", "Value 5" };
		Object[] data=  args;
		//bject[] data=  doot;
		JList list = new JList(data);
		
		
		list.setLocation(10, 10);
		list.setSize(400, 420);
		frame.getContentPane().add(list);
		JScrollPane ScrollPane = new JScrollPane(list);
		ScrollPane.setSize(424,420);
		ScrollPane.setLocation(10,10);
		ScrollPane.setAutoscrolls(true);
		frame.getContentPane().add(ScrollPane);
		
		JButton btnOk = new JButton("OK");
		btnOk.setMnemonic('O');
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frame.dispose();
			}
		});
		btnOk.setBounds(345, 442, 89, 23);
		frame.getContentPane().add(btnOk);
		
		JButton btnNextCommand = new JButton("Next Command");
		btnNextCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Get the selected index
				int TheOneWeGot = list.getSelectedIndex();
				
				//Check if we've reached the end, and if so, reset our position to the top.
				if (TheOneWeGot==data.length-1) {
					TheOneWeGot=-1;
				}
				
				//Move us down one
				TheOneWeGot++;
				
				//Select the new index.
				list.setSelectedIndex(TheOneWeGot);
				
				//Get the Text
				String CommandtoCopy = list.getSelectedValue().toString();
				
				//
				
				
				//Output the text.
				System.out.println(CommandtoCopy);
				
				//Outut it, but this time to the Clipboard.
				StringSelection selection = new StringSelection(CommandtoCopy);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(selection, selection);
			
			}
		});
		btnNextCommand.setMnemonic('N');
		btnNextCommand.setBounds(10, 442, 325, 23);
		frame.getContentPane().add(btnNextCommand);
		
		
	}
}
