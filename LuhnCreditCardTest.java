import java.util.Scanner;

import acm.program.ConsoleProgram;

public class LuhnCreditCardTest extends ConsoleProgram{

	static Scanner sc = new Scanner(System.in);
	
	public void run() {
		println("Hey");
		int x = main();
	}
	
	public int main() {
		System.out.print("Enter an interger");
		int x = sc.nextInt();
		System.out.println(x);
		return x;
    }
	
}
