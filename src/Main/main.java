package Main;

import java.util.Scanner;
import jindongsu.StudentMg;

public class main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num ;
		String name, stNum, phoneNum, age;
		while(true) {
			System.out.println("학생 관리 프로그램");
			System.out.println("1. 한길용 2. 이진원 3. 진동수 4. 이창훈 5. 이동호");
			num = sc.nextInt();
			switch(num) {
			case 1 : break;
			case 2 : break;
			case 3 :
					StudentMg jin = new StudentMg();
					jin.disp();	break;
			case 4 : break;
			case 5 : break;
			}
		}
	}
}
