//Rizwan Kassamali

//importing packages
import javax.swing.*;
import java.math.*;
import java.util.Random;
import java.lang.Character;

// The "SpyProgramDecrypt" class.
public class SpyProgramDecrypt
{
    public static void main (String[] args)
    {
	
       //self test

	//asks user in input a phrase to be encrypted
	String test = JOptionPane.showInputDialog ("Enter the phrase to be decrypted.");

	//gets encrypted string
	String output = decrypt (test);

	//oupts encrypted string 
	JOptionPane.showMessageDialog (null, output);

    
    } // main method
    
	public static String decrypt (String enc)
    {
	//length of the encrypted string
	int len = enc.length () - 1;

	//char for the multiplier 
	char mult = '0';

	//removes the last char
	String unenc = enc.substring (0, enc.length () - 1);

	//string for the random letters 
	String randLets = "";

	//this loop finds the first number (the multiplier), and remvoes all the random leters
	for (int l = 0 ; l <= len ; l++)
	{
	    //gets char at each instence
	    char keyChar = unenc.charAt (l);

	    //if the char is a digit
	    if (Character.isDigit (keyChar) == true)
	    {
		//then we know the multiplier is ther first number
		mult = unenc.charAt (l);

		//breaks the loop
		break;
	    }
	    //if char is not a number then adds the char to the string of random leters 
	    else
	    {
		//adds char to string of random letters 
		randLets = randLets + keyChar;
	    }
	}

	//string for the multiplier value
	String multVal = "";

	//adds the multiplier value to string 
	multVal = multVal + mult;

	//converts the multiplier into and integer
	int multInt = Integer.parseInt (multVal);

	//length of the random characters 
	int lenRL = randLets.length ();

	//remvoves the random characters to start and the multiplier value
	String raw = unenc.substring (lenRL + 1);

	//undos the reverse
	raw = new StringBuffer (raw).reverse ().toString ();

	//divides by the random multiplier and converts back to deciaml from oct 
	String stringAsc = new BigDecimal (new BigInteger (raw, 8)).divide (new BigDecimal (multInt), 0).toString ();

	//length of the ascii string
	int asLen = stringAsc.length ();

	//string for final output
	String done = "";

	//loop to check all the ascii values and convernt the string of numbers back into words 
	for (int h = 0 ; h < asLen ; h++)
	{
	    //variable to receive the letter from the ascii value
	    char let = ' '; 

	    //declaring int variables, value is the ascii value for the char (+52 due to shift), check is used to find if the ascii is 2 or 3 digits
	    int value = 0, check = 0;
	    
	    //gets the number value at each instence
	    check = Character.getNumericValue (stringAsc.charAt (h)); 

	    //if the value is one, then the ascii value is triple digit
	    if (check == 1) 
	    {
		//this adds the following two digits, but not mathematically just after each other
		value = Integer.parseInt (String.valueOf (stringAsc.charAt (h)) + String.valueOf (stringAsc.charAt (h + 1)) + String.valueOf (stringAsc.charAt (h + 2)));
		
		//since 2 extra chars were used we can skip the next 2 chars
		h += 2; 
	    }
	    
	    //the rest of the ascii vals would be 2 digits 
	    else  
	    {
		//since the ascii value is 2 digits, we add the current and next value, but after each other not matjematically 
		value = Integer.parseInt (String.valueOf (stringAsc.charAt (h)) + String.valueOf (stringAsc.charAt (h + 1))); 
		h += 1; 
	    }

	    //gets the letter from the ascii value, i have to minus 52 bevuase 52 was added in the encryption
	    let = (char) (value - 53);

	    //adds all new letters to string
	    done = done + let;
	}

	//return the user's original input
	return done;

    }//decryption method
    
    
} // SpyProgramDecrypt class
