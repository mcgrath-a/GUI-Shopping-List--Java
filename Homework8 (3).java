package homework8;



import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Homework8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Homework8Interface();
	}

}

class Homework8Interface implements ActionListener{
	
	// Create the frame object
	JFrame frame = new JFrame();
	
	
	/*
	 * Define all the instance variables here.
	 */
	String nextItem = "";
	String text = "";
	int multiplier = 0;
	Hashtable<String, Integer> items = new Hashtable <> ();
	
	// Create all the UI components
	
	
	JButton btnAdd = new JButton("Add "); // button should display "Add"
	JButton btnRemove = new JButton("Remove "); // button should display "Remove"
	
	JLabel shopType = new JLabel("Type shopping item here"); 
	JLabel ntbLabel = new JLabel("Need to buy:"); // label should display "Tip" by default
	JLabel listOfItems = new JLabel(""); // label should display "Total" by default
	
	
	JTextField shopTypetext = new JTextField("hello"); 
	
	
	
	/*
	 * Make sure to call the methods inside of the constructor.
	 */
	Homework8Interface(){
		prepareGUI();
		setLabels();
		setTextInput();
		setButtons();
	}
	
	/* prepareGUI()
	   Make sure to:
	 		1. Set the title of the frame to "Homework 8";
	 		2. Set the bounds to have a width of 800 and a height of 400;
	 		3. Set the default close operation to EXIT_ON_CLOSE.
	 */
	
	public void prepareGUI() {
		frame.setTitle("Homework 8");
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
			
		frame.setBounds(200, 200, 800, 400);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	// setLabels: sets all the labels properties
	/* setLabels()
	   Make sure to:
	   		1. Set the bounds for both labels;
	   		2. Add both labels to the frame.
	 
	 */
	public void setLabels() {
		shopType.setBounds(50, 50, 500, 50);
		frame.add(shopType);
		

		ntbLabel.setBounds(475, 50, 500, 50);
		frame.add(ntbLabel);
		
		listOfItems.setBounds(475, 100, 325, 300);
		frame.add(listOfItems);
		
		listOfItems.setVerticalAlignment(JLabel.TOP);
		
	
	}
	//x, y, width, height) 
	/* setTextInput()
	   Make sure to:
	   		1. Set the bounds for the text field;
	   		2. Add the text field to the frame.
	 */
	public void setTextInput() {
		
		shopTypetext.setBounds(50, 85, 375, 35);
		frame.add(shopTypetext);
		
		
	}
	
	/* setButtons()
	   Make sure to:
	   		1. Set the bounds for both buttons;
	   		2. Add both buttons to the frame;
	   		3. Add action listener for both buttons.
	 */
	public void setButtons() {
		btnAdd.setBounds(50, 150, 100, 50);
		frame.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnRemove.setBounds(175, 150, 100, 50);
		frame.add(btnRemove);
		btnRemove.addActionListener(this);
		
	
	}


	
 
	public void actionPerformed(ActionEvent e) {
		//ADD button
		if (e.getSource() == btnAdd) {
			nextItem = shopTypetext.getText().toLowerCase();
			 
				 System.out.println(true);
				 if (items.get(nextItem) != null) {
						items.put(nextItem, items.get(nextItem) + 1);
					}else {
						if (!nextItem.isBlank()   ) {
						items.put(nextItem, 1);
						}
					}
					
				 	text = "";
					for (String key:  items.keySet() ) {
						text += key + "" + " x" + items.get(key) +  "\n" ;
					}
			
		}
		//REMOVE button
		if (e.getSource() == btnRemove) {
			nextItem = shopTypetext.getText().toLowerCase();
			
				 if (items.get(nextItem) != null) {
						if (items.get(nextItem) == 1) {
							items.remove(nextItem);
							System.out.println(items.get(nextItem));
						}else {
							items.put(nextItem, items.get(nextItem) - 1);
						}
					}
				 
					
				 	text = "";
					for (String key:  items.keySet() ) {
						System.out.println(key);
						text += key + "" + "x" + items.get(key) +  "\n" ;
				}
			
		}
		
		listOfItems.setText("<html>" + text.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
		//found at (https://stackoverflow.com/questions/1090098/newline-in-jlabel)
	}
}
	


