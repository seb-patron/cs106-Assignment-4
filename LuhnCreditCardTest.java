import java.util.Scanner;

public class LuhnCreditCardTest{

	static Scanner sc = new Scanner(System.in);




	public static void main(String[] args) {
		while (true) {
			System.out.println("Enter a credit card number to be validated");
			String str = sc.nextLine();
			boolean validCreditCard = luhnTest(str);
			if (validCreditCard == false) {
				println("Fagoot");
			}
		}
	}

	public boolean luhnTest(String str) {
		return false;

	} 
}
