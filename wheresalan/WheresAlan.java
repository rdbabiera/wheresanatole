package wheresalan;

import java.util.Scanner;

public class WheresAlan {
	static Scanner userPrompt = new Scanner(System.in);
	public static int temp;
	public static int sizeAlan = 1;
	public static int sizeTony = 1;
	
	public static void main(String[] args) {
		System.out.printf("Welcome to Where's Alan! Please "
				+ "input the number of teammates Alan will have (Max 5): \n");
		temp = userPrompt.nextInt();
		while ((temp < 0) || (temp > 5)) {
			System.out.printf("Invalid Parameter. Try Again...\n");
			temp = userPrompt.nextInt();
		}
		sizeAlan += temp;
		System.out.printf("Please input the number of disciplinary commitee "
				+ "members present (Max 5): \n");
		temp = userPrompt.nextInt();
		while ((temp < 0) || (temp > 5)) {
			System.out.printf("Invalid Parameter. Try Again...\n");
			temp = userPrompt.nextInt();
		}
		sizeTony += temp;
	}
}
