
public class JavaStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1 = "Kaushal Chetan Shah";
		String str2 = "CHANDNI KAUSHAL SHAH";

		System.out.println(str1);

		String newstr1;
		newstr1 = str1.toUpperCase();

		System.out.println(newstr1);

		System.out.println(str2);

		String newstr2;
		newstr2 = str2.toLowerCase();

		System.out.println(newstr2);

		String s1;
		s1 = "APP";

		String s2;
		s2 = "APP";

		int CStr;
		CStr = s1.compareTo(s2);

		if (CStr > 0){
			System.out.println("The s1 comes first when compared to s2");
		}

		else if (CStr < 0){
			System.out.println("The s2 comes first when compared to s1");
		}

		else if (CStr == 0){
			System.out.println("Both are the same...yaaaay!!");
		}

		char atsign = '@';
		String email_add = "abc@xyz.com";

		int answer;
		answer = email_add.indexOf(atsign);

		if (answer == -1){

		System.out.println("This is an invalid email address!!");

	}
		else{
			System.out.println("The email adress is valid!!");
		}

		String str3 = "";


		str3 = str1.substring(0, 3);
		System.out.println(str3);
	}
}
