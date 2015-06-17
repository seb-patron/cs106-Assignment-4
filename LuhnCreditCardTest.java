import java.util.Scanner;

public class LuhnCreditCardTest{

	static Scanner sc = new Scanner(System.in);

	private int evenSum;
	private int oddSum;


	public static void main(String[] args) {
		while (true) {
			System.out.println("Enter a credit card number to be validated");
			String str = sc.nextLine();
			boolean validCreditCard = luhnTest(str);
			if (validCreditCard == false) {
				System.out.println("Fagoot");
			}
		}
	}

	public static boolean luhnTest(String str) {
		
		String reverse = reverseString(str);
		for (int i = 0; i < reverse.length(); i++) {
			if (i%10 = 0) {
				evenSum = (reverse.charAt(i)*2) ;
			}
			
		}
		return false;

	} 
	
	public String reverseString(String str) {
		
		return result;
	}
}
