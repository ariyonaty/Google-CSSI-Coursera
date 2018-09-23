/*
	Ari Yonaty
	Google CSSI
	9.9.2018
	Caesar Cipher: Implementation of Caesar Cipher. Entered text is decrypted by key.
*/

public class CaesarCipher
{
	public static String encrypt(String input, int key)
	{

		// Declaring variables
		StringBuilder encrypted = new StringBuilder(input);
		String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
		String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		String shiftedLower = alphabetLower.substring(key) + alphabetLower.substring(0, key);
		String shiftedUpper = alphabetUpper.substring(key) + alphabetUpper.substring(0, key);

		// Loops through each character of String encrypted
		for (int i = 0; i < encrypted.length(); i++)
		{
			char currChar = encrypted.charAt(i);

			// Conditional - if lower case, swaps current Character for location in shifted lowercase alphabet
			if (Character.isLowerCase(currChar))
			{
				int idx = alphabetLower.indexOf(currChar);

				if (idx != -1)
				{
					char newChar = shiftedLower.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}
			else
			{
				int idx = alphabetUpper.indexOf(currChar);

				if (idx != -1)
				{
					char newChar = shiftedUpper.charAt(idx);
					encrypted.setCharAt(i, newChar);
				}
			}
			
		}

		return encrypted.toString();
	}


	// Encrypts string using two Caesar keys. 
	public static String encryptTwoKeys(String input, int keyOne, int keyTwo)
	{
		// Declaring two pairs of everything; one for each key
		StringBuilder encrypted = new StringBuilder(input);
		String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
		String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		String shiftedLower = alphabetLower.substring(keyOne) + alphabetLower.substring(0, keyOne);
		String shiftedLower2 = alphabetLower.substring(keyTwo) + alphabetLower.substring(0, keyTwo);
		String shiftedUpper = alphabetUpper.substring(keyOne) + alphabetUpper.substring(0, keyOne);
		String shiftedUpper2 = alphabetUpper.substring(keyTwo) + alphabetUpper.substring(0, keyTwo);


		for (int i = 0; i < encrypted.length(); i++)
		{
			char currChar = encrypted.charAt(i);
			
			// Conditional to test case of current character
			if (Character.isLowerCase(currChar))
			{
				int idx = alphabetLower.indexOf(currChar);

				if (idx != -1)
				{
					// Conditional to test whether to use first or second key
					if (idx % 2 != 0)
					{
						char newChar = shiftedLower.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
					else
					{
						char newChar = shiftedLower2.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
				}
			}

			else
			{
				int idx = alphabetUpper.indexOf(currChar);

				if (idx != -1)
				{
					if (idx % 2 != 0)
					{
						char newChar = shiftedUpper.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
					else
					{
						char newChar = shiftedUpper2.charAt(idx);
						encrypted.setCharAt(i, newChar);
					}
				}
			}
		}

		return encrypted.toString();
	}

	public static void main (String[] args) 
	{
		System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
		System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
	}
}