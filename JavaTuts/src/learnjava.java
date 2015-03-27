import java.util.Scanner;

public class learnjava {

	public static void main(String[] args) {
		System.out.println("Please enter your name here!!");
		Scanner name = new Scanner(System.in);
		System.out.println("Bonjour " +name.nextLine());

		System.out.println("Please enter your age: ");
		Scanner age = new Scanner(System.in);
		System.out.println("Your age is : " +age.nextLine());


//		Scanner names = new Scanner(System.in);
		newclass newclassObject = new newclass("Bonney Kotak");
		newclass newclassObject2 = new newclass("Lovely Grover");

		newclassObject.saying();
		newclassObject2.saying();




		}

	}


