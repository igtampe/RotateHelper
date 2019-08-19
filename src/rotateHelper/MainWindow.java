package rotateHelper;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class MainWindow {

	private JFrame frmRotatehelper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmRotatehelper.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRotatehelper = new JFrame();
		frmRotatehelper.setResizable(false);
		
		frmRotatehelper.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/RotateHelperIcon.png")));
		
		frmRotatehelper.setTitle("RotateHelper");
		
		
		frmRotatehelper.setBounds(100, 100, 319, 531);
		frmRotatehelper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRotatehelper.getContentPane().setLayout(null);
		
		JLabel MirrorHelperLabel = new JLabel("");
		MirrorHelperLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/RotateHelperLogo.png")));
		MirrorHelperLabel.setBounds(0, 0, 313, 97);
		MirrorHelperLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MirrorHelperLabel.setFont(new Font("Arial", Font.BOLD, 30));
		frmRotatehelper.getContentPane().add(MirrorHelperLabel);
		
		JLabel lblCoordinate = new JLabel("Coord. 2");
		lblCoordinate.setBounds(10, 137, 62, 14);
		frmRotatehelper.getContentPane().add(lblCoordinate);
		
		JLabel lblCoord = new JLabel("Coord. 1");
		lblCoord.setBounds(10, 108, 62, 14);
		frmRotatehelper.getContentPane().add(lblCoord);
		
		JLabel lblPasteCoordinate = new JLabel("Paste Coord.");
		lblPasteCoordinate.setBounds(10, 162, 83, 14);
		frmRotatehelper.getContentPane().add(lblPasteCoordinate);
		
		JTextPane Coord1TXB = new JTextPane();
		Coord1TXB.setText("X,Y,Z");
		Coord1TXB.setBounds(103, 108, 200, 20);
		frmRotatehelper.getContentPane().add(Coord1TXB);
		
		JTextPane Coord2TXB = new JTextPane();
		Coord2TXB.setText("X,Y,Z");
		Coord2TXB.setBounds(103, 133, 200, 20);
		frmRotatehelper.getContentPane().add(Coord2TXB);
		
		JTextPane PasteCoordTXB = new JTextPane();
		PasteCoordTXB.setToolTipText("REMEMBER: LOWEST NORTH WESTERN POINT");
		PasteCoordTXB.setText("X,Y,Z");
		PasteCoordTXB.setBounds(103, 156, 200, 20);
		frmRotatehelper.getContentPane().add(PasteCoordTXB);
		
		JRadioButton ClockwiseRButton = new JRadioButton("Clockwise");
		ClockwiseRButton.setHorizontalAlignment(SwingConstants.CENTER);
		ClockwiseRButton.setBounds(6, 436, 133, 23);
		JRadioButton CounterClockwiseRButton = new JRadioButton("Counterclockwise");
		CounterClockwiseRButton.setHorizontalAlignment(SwingConstants.CENTER);
		CounterClockwiseRButton.setBounds(170, 436, 133, 23);
		
		//before we add them to the form, lets make sure they're in the same group:
		ButtonGroup Doot = new ButtonGroup();
		Doot.add(CounterClockwiseRButton);
		Doot.add(ClockwiseRButton);
				
		frmRotatehelper.getContentPane().add(CounterClockwiseRButton);
		frmRotatehelper.getContentPane().add(ClockwiseRButton);
		
		JComboBox FirstOption = new JComboBox();
		FirstOption.setBounds(103, 286, 79, 20);
		FirstOption.addItem("replace");
		FirstOption.addItem("masked");
		FirstOption.setToolTipText("<html>"
				+ "<b>Replace:</b> Replace all blocks in the way <br>"
				+ "<b>Masked:</b> Only mirror non-air blocks<br>"
				+ "</html>");
		frmRotatehelper.getContentPane().add(FirstOption);
		
		JComboBox SecondOption = new JComboBox();
		SecondOption.setBounds(200, 286, 79, 20);
		SecondOption.addItem("normal");
		SecondOption.addItem("move");
		SecondOption.addItem("force");
		SecondOption.setToolTipText("<html>"
				+ "<b>Normal:</b> A normal clone <br>"
				+ "<b>Move:</b> Move all blocks to the mirrored copy<br>"
				+ "<b>Force:</b> Force the mirror, even if the areas overlap. <b> BE VERY CAUTIOUS WHEN USING THIS OPTION </b><br>"
				+ "</html>");
		frmRotatehelper.getContentPane().add(SecondOption);
		
		JButton btnNewButton = new JButton("Rotate!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//oh so this happens when the action is performed mmm que lindo
				
				echo("It's Big Brain Time");
				
				String[] Coord1;
				String[] Coord2;
				String[] PasteCoord;
				int Coord1X;
				int Coord1Y;
				int Coord1Z;
				int Coord2X;
				int Coord2Y;
				int Coord2Z;
				int PasteCoordX;
				int PasteCoordY;
				int PasteCoordZ;
				
				//ok now we've got to parse the coordinates into three sets
				try {					
					Coord1 = Coord1TXB.getText().split(",");
					Coord2 = Coord2TXB.getText().split(",");
					PasteCoord = PasteCoordTXB.getText().split(",");
				} catch (Exception e) {
					ErrorWindow.Generate(0, "An Error Happened", "I couldn't split the coordinates.", true, e.toString());
					echo("Coordinates could not be split. \n \n ");
					e.printStackTrace();
					return;
					
				}
				
				//Convert all of this stuff into Integers.
				try {
					Coord1X = Integer.parseInt(Coord1[0]);
					Coord1Y = Integer.parseInt(Coord1[1]);
					Coord1Z = Integer.parseInt(Coord1[2]);
					Coord2X = Integer.parseInt(Coord2[0]);;
					Coord2Y = Integer.parseInt(Coord2[1]);;
					Coord2Z = Integer.parseInt(Coord2[2]);;
					PasteCoordX = Integer.parseInt(PasteCoord[0]);;
					PasteCoordY = Integer.parseInt(PasteCoord[1]);;
					PasteCoordZ = Integer.parseInt(PasteCoord[2]);;
					
				} catch (Exception e) {
					ErrorWindow.Generate(0, "An Error Happened", "I couldn't parse the coordinates", true, e.toString());
					echo("Coordinates could not be converted to Integers. \n \n ");
					e.printStackTrace();
					return;
				}
				
				echo("OK I should have the coords now");
				
				//then we've got to check which way we're mirroring
				String Mode;
				Mode="none";
				if (ClockwiseRButton.isSelected()) Mode="CW";
				if (CounterClockwiseRButton.isSelected()) Mode="CCW";

				
				String[] Commands;
				String CommandsTemp;
				
				
				//if it's X, the highest X on the original goes to the lowest X on the copy
				//then second highest goes to second lowest and so on and so forth
				//the same with Z
				
				int CurrentOriginalX;
				int CurrentOriginalZ;
				
				int MaxOriginalX;
				int MaxOriginalZ;
				
				int MinOriginalX;
				int MinOriginalZ;
				
				int CurrentCopyX;
				int CurrentCopyZ;
				
				
				if (Coord1X>Coord2X) {
					CurrentOriginalX=Coord1X;
					MaxOriginalX=Coord1X;
					MinOriginalX=Coord2X;
				}
				else {
					CurrentOriginalX=Coord2X;
					MaxOriginalX=Coord2X;
					MinOriginalX=Coord1X;
				}
				
				if (Coord1Z>Coord2Z) {
					CurrentOriginalZ=Coord1Z;
					MaxOriginalZ=Coord1Z;
					MinOriginalZ=Coord2Z;
				}
				else {
					CurrentOriginalZ=Coord2Z;
					MaxOriginalZ=Coord2Z;
					MinOriginalZ=Coord1Z;
				}
				
				CurrentCopyX=PasteCoordX;
				CurrentCopyZ=PasteCoordZ;
				CommandsTemp="";
				
				switch (Mode) {
					
				case "CW":
					echo("Rotating Clockwise");
					
					//Clockwise

					//(MinX,MaxZ) goes to (PMinX,PMinZ)
					//(MinX,MaxZ-1) goes to (PMinX+1,PMinZ)
					//(MinX,MaxZ-2) goes to (PMinX+2,PMinZ)

					//(MinX+1,MaxZ) goes to (PMinX,PMinZ+1)
					//(MinX+1,MaxZ-1) goes to (PMinX+1,PMinZ+1)
					//(MinX+1,MaxZ-2) goes to (PMinX+2,PMinZ+1)
					
					CurrentOriginalX=MinOriginalX;
					while(CurrentOriginalX<=MaxOriginalX) {
						CurrentOriginalZ=MaxOriginalZ;
						CurrentCopyX=PasteCoordX;
						
						while(CurrentOriginalZ>=MinOriginalZ) {
							CommandsTemp=CommandsTemp + "/clone " + CurrentOriginalX + " " + Coord1Y + " " + CurrentOriginalZ + " " + CurrentOriginalX + " " + Coord2Y + " " + CurrentOriginalZ + " " + CurrentCopyX + " " + PasteCoordY + " " + CurrentCopyZ + " " + FirstOption.getSelectedItem().toString() + " " + SecondOption.getSelectedItem().toString()+"~";
							CurrentOriginalZ--;
							CurrentCopyX++;
						}
						
						CurrentOriginalX++;
						CurrentCopyZ++;
					}					
					
					//"/clone <Dynamic1> coord1Y coord1Z"
					
					break;
				case "CCW":
					echo("Rotating Counterclockwise");
					
//					CounterClockwise
	//				(MaxX,MaxZ) goes to (PMinX,PMinZ)
		//			(MaxX,MaxZ+1) goes to (PMinX+1,PMinZ)
			//		(MaxX,MaxZ+2) goes to (PMinX+2,PMinZ)
//
	//				(MaxX-1,MinZ) goes to (PMinX,PMinZ+1)
		//			(MaxX-1,MinZ+1) goes to (PMinX+1,PMinZ+1)
			//		(MaxX-1,MinZ+2) goes to (PMinX+2,PMinZ+1)

					CurrentOriginalZ=MinOriginalZ;
					
					while(CurrentOriginalX>=MinOriginalX) {
						CurrentOriginalZ=MinOriginalZ;
						CurrentCopyX=PasteCoordX;
						
						while(CurrentOriginalZ<=MaxOriginalZ) {
							CommandsTemp=CommandsTemp + "/clone " + CurrentOriginalX + " " + Coord1Y + " " + CurrentOriginalZ + " " + CurrentOriginalX + " " + Coord2Y + " " + CurrentOriginalZ + " " + CurrentCopyX + " " + PasteCoordY + " " + CurrentCopyZ + " " + FirstOption.getSelectedItem().toString() + " " + SecondOption.getSelectedItem().toString()+"~";
							CurrentOriginalZ++;
							CurrentCopyX++;
						}
						
						CurrentOriginalX--;
						CurrentCopyZ++;
					}					
					
					break;
				default:
					ErrorWindow.Generate(1, "b o b o", "You didn't select a mode", false, null);
					echo("User did not select a mode, and thus he is a bobo.");
					return;
					
				}
				
				//Put the commands temp into an array
				Commands=CommandsTemp.split("~");
				
				//call the copy window using the array, so it can output it.
				CopyWindow.main(Commands);
				System.out.println("haha you has pressed the button");
			}
		});
		btnNewButton.setBounds(10, 466, 293, 23);
		frmRotatehelper.getContentPane().add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(MainWindow.class.getResource("/Clockwise.png")));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(180, 346, 83, 83);
		frmRotatehelper.getContentPane().add(label_1);
		
		JLabel lblOR = new JLabel("OR");
		lblOR.setHorizontalAlignment(SwingConstants.CENTER);
		lblOR.setBounds(136, 187, 46, 14);
		frmRotatehelper.getContentPane().add(lblOR);
		
		JTextPane CloneCommandTXB = new JTextPane();
		CloneCommandTXB.setText("/clone X1 Y1 Z1 X2 Y2 Z2 PX PY PZ");
		CloneCommandTXB.setBounds(10, 212, 293, 20);
		frmRotatehelper.getContentPane().add(CloneCommandTXB);
		
		JButton btnParseCloneCommand = new JButton("Parse Clone Command");
		btnParseCloneCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String[] CloneCommand=CloneCommandTXB.getText().split(" ");
			Coord1TXB.setText(CloneCommand[1] + "," + CloneCommand[2] + "," + CloneCommand[3]);
			Coord2TXB.setText(CloneCommand[4] + "," + CloneCommand[5] + "," + CloneCommand[6]);
			PasteCoordTXB.setText(CloneCommand[7] + "," + CloneCommand[8] + "," + CloneCommand[9]);
			}
		});
		btnParseCloneCommand.setBounds(68, 243, 195, 23);
		frmRotatehelper.getContentPane().add(btnParseCloneCommand);
		
		JLabel lblCloneOptions = new JLabel("Clone Options:");
		lblCloneOptions.setBounds(10, 286, 83, 20);
		frmRotatehelper.getContentPane().add(lblCloneOptions);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainWindow.class.getResource("/Counterclockwise.png")));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(37, 346, 83, 83);
		frmRotatehelper.getContentPane().add(label);
		
		JLabel lblRotationDirection = new JLabel("Rotation Direction:");
		lblRotationDirection.setBounds(10, 317, 172, 20);
		frmRotatehelper.getContentPane().add(lblRotationDirection);
		
		
		
		
		
		
	}
	
	
	
	public void echo(String Doot) {
		System.out.println(Doot);
	}
}
