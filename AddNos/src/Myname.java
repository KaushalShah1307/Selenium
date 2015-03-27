import java.util.Scanner;


public class Myname {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*		String first_name, last_name;

		first_name = "Kaushal";
		last_name = "Shah";

		System.out.println(first_name + "(Awesome)" + last_name);*/

		Scanner user_input = new Scanner (System.in);

		String first_name;
		System.out.println("Enter you First Name : ");
		first_name = user_input.next();

		String middle_name;
		System.out.println("Enter you Middle Name : ");
		middle_name = user_input.next();

		String last_name;
		System.out.println("Enter you Last Name : ");
		last_name = user_input.next();

		String full_name;
		full_name = first_name + " " + middle_name + " " + last_name;

		System.out.println("Your full name is : " + full_name );
	}

}
