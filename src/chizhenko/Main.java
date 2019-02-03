package chizhenko;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int dec1 = 0;
		int dec2 = 0;
		ArrayList<StringBuilder> list = new ArrayList<>();
		StringBuilder bin1;
		StringBuilder bin2;		
		int maxLength = 0;
		//int temp = 0;
		int counter = 0;
		char ch1;
		char ch2;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("введите первое число");
		dec1 = sc.nextInt();
		System.out.println("введите второе число");
		dec2 = sc.nextInt();
		sc.close();
		bin1 = getBinar(dec1);
		bin2 = getBinar(dec2);
		
		list.add(bin1);
		list.add(bin2);
		
		maxLength = Math.max(bin1.length(), bin2.length());
		
		for (StringBuilder el:list) {
			if (el.length() != maxLength) {
				for (int i=0;i<=maxLength-el.length();i++) {
					el.insert(0, "0");
				}
			}
		}
		
		for (int i=0;i<maxLength;i++) {
			ch1 = list.get(0).toString().charAt(i);
			ch2 = list.get(1).toString().charAt(i);
			
			if (ch1 != ch2) {
				counter++;
			}
		}
		
		System.out.println(list.get(0).toString());
		System.out.println(list.get(1).toString());
		System.out.println(counter);

	}

	public static StringBuilder getBinar(int pDecimal) {

		StringBuilder sb = new StringBuilder();

		while (pDecimal > 0) {
			
			if (pDecimal == 1) {
				sb.append("1");
				break;
			} else {
				sb.append(Integer.toString(pDecimal % 2));
				pDecimal = pDecimal / 2;	
			}	
		}

		sb.reverse();

		return sb;
	}

}
