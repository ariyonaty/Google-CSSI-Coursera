/*
	Ari Yonaty
	Google CSSI
	9.9.2018
	Word Play: Program to transform words from a file into another form,
		such as replacing vowels with an asterix. 
*/

public class WordPlay
{
	// Simple function to test whether certain character is a vowel
	public static boolean isVowel(char ch)
	{

		if ("aeiou".indexOf(Character.toLowerCase(ch)) != -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// Function accepts a string a replaces the vowels with user inputted char
	public static String replaceVowels(String phrase, char ch)
	{
		StringBuilder newPhrase = new StringBuilder(phrase);

		for (int i = 0; i < phrase.length(); i++)
		{
			if (isVowel(newPhrase.charAt(i)))
			{
				newPhrase.setCharAt(i, ch);
			}
		}

		return newPhrase.toString();
	}

	// Function accepts a string, interates thru characters, and replaces specific char with + or *
	public static String emphasize(String phrase, char ch)
	{
		StringBuilder newPhrase = new StringBuilder(phrase);

		for (int i = 0; i < phrase.length(); i++) 
		{
			char currChar = newPhrase.charAt(i);
			currChar = Character.toLowerCase(currChar);

			if (ch == currChar)
				{
				if(i % 2 == 0)
				{
					newPhrase.setCharAt(i, '*');
				}
				else
				{
					newPhrase.setCharAt(i, '+');
				}
			}	
		}

		return newPhrase.toString();
	}

	public static void main(String[] args) 
	{
		System.out.println(isVowel('B'));	
		System.out.println(replaceVowels("Hello", '*'));
		System.out.println(emphasize("Everyone", 'e'));
	}
}