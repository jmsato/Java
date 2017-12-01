package notes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test 
{
	public static String guess = "";
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		String repeat = "";
		
		do {
		System.out.println("Welcome to \"Bulls and Cows\"");
		System.out.println("Which option do you want to play? 3, 4, or 5 digits?");
		int codeLength = input.nextInt();
		input.nextLine();
		String code = generateRandomCode(codeLength);
		System.out.println(code);
		
		
		
		do
		{
		System.out.println("Enter guess: ");
		guess = input.nextLine();
		checkLength(guess, code, codeLength);
		
		System.out.println(checkBulls(guess,code,codeLength) + " bulls");
		System.out.println(checkCows(guess,code,codeLength) + " cows");
		//System.out.println("Guess again");
		//guess = input.next();
		
		}while(checkBulls(guess, code, codeLength) != codeLength);
		
		System.out.println("Good job!");
		System.out.println("Do you want to continue?");
		//System.out.println(" ");
		repeat = input.nextLine();
		
		}while(repeat.equalsIgnoreCase("Yes") || repeat.equals("y"));
		
		input.close();
	}
		
	public static void checkLength(String g, String code, int length)
	{
		Scanner in = new Scanner(System.in);
		do
		{
		if(g.length() > code.length())
		{
			System.out.println("Guess must be " + length + " digits.");
			System.out.println("Guess again");
			guess = in.nextLine();
		} 
		if(g.length() == code.length()-1)
		{
			guess = addZero(guess);
		}
		if(g.length() <= code.length()-2)
		{
			System.out.println("Each digit must be different. Two zeroes.");
			System.out.println("Guess again");
			guess = in.nextLine();
		}
		
		if(checkRepeat(g)==-1)
		{
			System.out.println("Each digit must be different.");
			System.out.println("Guess again");
			guess = in.nextLine();
		}
		}while(!(code.length()==guess.length()));//(checkRepeat(guess)==-1) || (guess.length() > code.length()) || (guess.length() < code.length() || (guess.length() == code.length()-2)));

}
	
	public static String addZero(String g)
	{
		guess = "0" + g;
		System.out.println(guess);
		return guess;
	}
	
	public static int checkRepeat(String guess)
	{
		for(int i=0; i<guess.length(); i++)
		{
			for(int j=i+1; j<guess.length(); j++)
			{
				if(guess.charAt(i) == guess.charAt(j))
				{
					return -1;
				}
			}
		}
		return 0;
	}	
	
	public static int checkBulls(String guess, String code, int length)
	{
		int bulls = 0;
		
		for(int i=0; i<length; i++)
		{
			if(guess.charAt(i) == code.charAt(i))
			{
				bulls++;
			}
		}
		return bulls;
	}
	
	public static int checkCows(String guess, String code, int length)
	{
		int cows = 0;
		for(int i=0; i<code.length(); i++)
		{
			for(int j=0; j<code.length(); j++)
			{
				if((code.charAt(i)) == (guess.charAt(j)))
				{
					cows++;
				}
			}
		}
		cows = cows-checkBulls(guess, code, length);
		return cows;
	}	
		
	public static String generateRandomCode(int codeLength)
	{
	    List<Integer> numbers = new ArrayList<>();
	    for(int i = 0; i < 10; i++){
	        numbers.add(i);
	    }

	    Collections.shuffle(numbers);

	    String code = "";
	    for(int i = 0; i < codeLength; i++){
	        code += numbers.get(i).toString();
	    }
	    //System.out.println(code);  // uncomment this to see the code during your development. 
		   return code;
	}

}
