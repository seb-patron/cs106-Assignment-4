import acm.program.*;

public class LuhnCreditCardTest extends ConsoleProgram{

	private int oddSum;
	private int evenSum;
	private long creditCardNumber;
	private boolean validCreditCard;


	public void run() {
		//while (true) {
			String number = "49927398716";
			println(number);
			creditCardNumber = Long.valueOf(number);
			creditCardNumber = numberReversal();
			println(creditCardNumber);
			testCreditCard();
			checkIfCardIsValid();
			printResult();

		//}
	}
	
	private void numberReversal() {
		long reverseOfN = 0;
		long n = creditCardNumber;
		while (n != 0) {
			reverseOfN = reverseOfN * 10;
			println(reverseOfN);
			reverseOfN = reverseOfN + n%10;
			println(reverseOfN);
			n = n/10;
		}
	}

	/**
	 * Adds each digit to their appropriate sum sum
	 */
	public void testCreditCard() {
		int i = 0;
		while (creditCardNumber > 0 ) {
			if (i%2 != 0) {
				oddSumCalculation();
				println("the new odd sum is " + oddSum);
			} else {
				evenSumCalulation();
				println("the new evenSum is " + evenSum);
			}
			creditCardNumber = creditCardNumber/10;
			println("Credit card number is now" + creditCardNumber);
			i++;
		}
	}

	/**
	 * checks to see if the last digit from the result of adding @oddSum and @evenSum
	 * is 0. If it is 0 it gives the @validCreditCard variable a true value
	 */
	public void checkIfCardIsValid() {
		int test = oddSum + evenSum;
		if (test%10 == 0) {
			validCreditCard = true;
		} else {
			validCreditCard = false;
		}
	}

	public void oddSumCalculation() {
		int x = (int) (creditCardNumber%10);
		oddSum += x;
	}

	public void evenSumCalulation() {
		int x = (int) ((creditCardNumber%10) *2);
		evenSum += x;
	}

	public void printResult() {
		if (validCreditCard == true) {
			println("The credit card number is valid");
		} else {
			println("Not a valid card number");
		}
	}
}



//import java.util.Scanner;
//
//public class LuhnCreditCardTest{
//
//	static Scanner sc = new Scanner(System.in);
//
//	private int evenSum;
//	private int oddSum;
//
//
//	public static void main(String[] args) {
//		while (true) {
//			System.out.println("Enter a credit card number to be validated");
//			String str = sc.nextLine();
//			boolean validCreditCard = luhnTest(str);
//			if (validCreditCard == false) {
//				System.out.println("Fagoot");
//			}
//		}
//	}
//
//	public static boolean luhnTest(String str) {
//		
//		String reverse = reverseString(str);
//		for (int i = 0; i < reverse.length(); i++) {
//			if (i%10 = 0) {
//				evenSum = (reverse.charAt(i)*2) ;
//			}
//			
//		}
//		return false;
//
//	} 
//	
//	public String reverseString(String str) {
//		
//		return result;
//	}
//}
