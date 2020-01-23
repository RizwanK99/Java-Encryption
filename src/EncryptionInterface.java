//Rizwan Kassamali

//importing packages
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// The "EncryptionInterface" class.
public class EncryptionInterface extends JFrame implements ActionListener
{
    //declaring variables
    Container frame;
    JTextField txtIn, txtOut;
    JButton btnEnc, btnDeEnc, btnClear;
    JLabel lblIn, lblOut;

    public EncryptionInterface ()
    {
	// Set the frame's name
	super ("Encryption Interface");  

	//set frame
	frame = getContentPane ();

	//set textfeilds
	txtIn = new JTextField ("Input a message.");
	txtOut = new JTextField ("Output.");

	//sets buttons
	btnEnc = new JButton ("Encrypt");
	btnDeEnc = new JButton ("Decrypt");
	btnClear = new JButton ("Clear");

	//adds the action listener to the buttons 
	btnEnc.addActionListener (this);
	btnDeEnc.addActionListener (this);
	btnClear.addActionListener (this);

	//creates labels
	lblIn = new JLabel ("Input");
	lblOut = new JLabel ("Output");

	//layout of the interface
	frame.setLayout (new GridLayout (7, 1));

	//adds the elements to the frame 
	frame.add (lblIn);
	frame.add (txtIn);
	frame.add (lblOut);
	frame.add (txtOut);
	frame.add (btnEnc);
	frame.add (btnDeEnc);
	frame.add (btnClear);

	//Set the frame's size
	setSize (400, 400);   
	//Show the frame
	show ();                
    } // Constructor


    /*
	public void paint (Graphics g)
	{
	    // Place the drawing code here
	} // paint method

    */
    
    
    public void actionPerformed (ActionEvent e)
    {
	//if clear is pressed
	if (e.getSource () == btnClear)
	{
	    //sets the textfeilds to clear
	    txtIn.setText ("");
	    txtOut.setText ("");
	}
	else if (e.getSource () == btnEnc)
	{
	    //declaring varibales
	    String userIn, compOut;

	    //get the input string from the textfeild
	    userIn = txtIn.getText (); 

	    //call encryption method from other program
	    compOut = SpyProgramEncrypt.encrypt (userIn); 

	    //output the encryption on the textfield
	    txtOut.setText (compOut);  


	}
	else if (e.getSource () == btnDeEnc)
	{
	    //declaring variables 
	    String userIn, deOut;

	    // get the input string from textfeild
	    userIn = txtIn.getText (); 

	    //call the decrtpyion method
	    deOut = SpyProgramDecrypt.decrypt (userIn); 

	    //output decryoted message on the textfeild
	    txtOut.setText (deOut);  
	}
    }


    public static void main (String[] args)
    {
	new EncryptionInterface ();     // Create a EncryptionInterface frame
    } // main method
} // EncryptionInterface class
