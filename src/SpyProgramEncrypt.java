//Rizwan Kassamali

//importing packages
import javax.swing.*;
import java.math.*;
import java.util.Random;
import java.lang.Character;

// The "SpyProgramEncrypt" class.
public class SpyProgramEncrypt
{
    public static void main (String[] args)
    {

	//self test

	//asks user in input a phrase to be encrypted
	String test = JOptionPane.showInputDialog ("Enter the phrase to be encrypted.");

	//gets encrypted string
	String output = encrypt (test);

	//oupts encrypted string
	JOptionPane.showMessageDialog (null, output);

    } // main method


    public static String encrypt (String unenc)
    {
	//new string to input encrypted letters
	String newEnc = "";

	//string for random throw off letters
	String randLetters = "";

	//string for final sendback
	String finalEnc = "";

	//new char for temp use
	char let;

	//varible for length of the word
	int length = unenc.length () - 1;

	//this loop adds random characters to the start of every string based upon the letters in the word (it only adds letters and random symbols, not numbers)
	for (int r = 0 ; r <= length ; r++)
	{
	    //random number generator
	    int randNum = (int) (Math.random () * ((127 - 58) + 1)) + 58;

	    //converts num to char
	    let = (char) (randNum);

	    //adds to randome letts string
	    randLetters = randLetters + let;
	}

	// convert chars to integers, then pus into a string
	for (int i = 0 ; i <= length ; i++)
	{
	    //finding ascii val and adding 52
	    int ascii = ((int) unenc.charAt (i)) + 53;

	    //string with all Ascii vals
	    newEnc = newEnc + ascii;
	}
	//random number generator
	int randMult = (int) (Math.random () * ((9 - 1) + 1)) + 1;

	String first, second, third;

	// multiplies the number by a single digit number that is not 0
	first = new BigDecimal (newEnc).multiply (new BigDecimal (randMult)).toString ();

	//converts to oct numbere systm
	second = new BigDecimal (first).toBigInteger ().toString (8);

	//reverses the oct string of numbers
	third = new StringBuffer (second).reverse ().toString ();

	//makes the final string by addeding the random letters the multiplier, the number string and the first char
	finalEnc = randLetters + randMult + third + third.charAt (0);

	//return the final encritpion
	return finalEnc;

    } //encryption method
} // SpyProgramEncrypt class
