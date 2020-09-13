package wheresanatole;

import java.util.Scanner;

public class WheresAnatole {
	static Scanner userPrompt = new Scanner(System.in);
	public static int temp;
	public static int sizeAnatole = 1;
	public static int sizeToby = 1;
	
	public static void main(String[] args) {
		System.out.printf("Welcome to Where's Anatole! Please "
				+ "input the number of teammates Anatole will have (Max 5): \n");
		temp = userPrompt.nextInt();
		while ((temp < 0) || (temp > 5)) {
			System.out.printf("Invalid Parameter. Try Again...\n");
			temp = userPrompt.nextInt();
		}
		sizeAnatole += temp;
		System.out.printf("Please input the number of disciplinary commitee "
				+ "members present (Max 5): \n");
		temp = userPrompt.nextInt();
		while ((temp < 0) || (temp > 5)) {
			System.out.printf("Invalid Parameter. Try Again...\n");
			temp = userPrompt.nextInt();
		}
		sizeToby += temp;
	}
}
