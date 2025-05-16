package puransinh.ExtentReports;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class reverse_string{
	public static StringBuilder reverseString() {
		String name="Puran";
		StringBuilder reverse=new StringBuilder();
		for(int i=name.length()-1;i>=0;i--) {
			reverse.append(name.charAt(i));
		
		}
		return reverse;
		
	}
	
	public static StringBuilder reverseKey() {
		String name="Puran";
		StringBuilder sb=new StringBuilder(name);
		return sb.reverse();

		}
	
	public static String userInput () {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Your Name");
		String name=scanner.nextLine();
		return "Hello "+name;
		
		}
	public static ArrayList<Integer> ordeString() {
		ArrayList<Integer> list=new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		Collections.sort(list,Collections.reverseOrder());
		return list;
		
	}
	public static ArrayList<Integer> minmaxNumber() {
		ArrayList<Integer> list=new ArrayList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(3);
		list.add(Collections.min(list));
		list.add(Collections.max(list));
		list.add(Collections.frequency(list, 3));
		return list;
		
	}
	
	public static void main(String [] args) {
		System.out.println(minmaxNumber());
		
	}
}