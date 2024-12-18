package kr.co.dong.practice.a51_60;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class A54_AnimalQuiz {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		FileWriter writer = null;
		String fwname = "save.txt";
		
		try {
			writer = new FileWriter(fwname);
			int count = 1;
			int score = 100;
			
			while(true) {
				System.out.println(count+"번째 시도");
				if(count==1) {
					System.out.println("(육지에 삽니다)");
				} else if(count==3) {
					System.out.println("(Hint - 포유류)");
				} else if (count ==5) {
					System.out.println("(Hint - 귀여움)");
				} else if (count ==7) {
					System.out.println("(Hint - 야옹)");
				}
				System.out.print("이 동물은 무엇일까요? > ");
				String input = scan.nextLine();
				writer.write(input+"%n");
				
				if(input.equals("고양이")) {
					System.out.println("정답입니다.");
					score-=(count-1)*10;
					System.out.println(score+"점 획득!");
					break;
				} 
				count++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				writer.close();
				scan.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
