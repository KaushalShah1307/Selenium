import javax.swing.JOptionPane;

public class IfStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*int Age;
		Age = JOptionPane.showInputDialog("Enter your Age here : ");*/

		int Age = 18;
/*
		if (Age < 18){
			System.out.println("Son you are Young as hell!!");
		}
			else if (Age > 24){

				System.out.println("Son you are no younger anymore!!");
			}


		}*/

		switch (Age){
		case 18:
			System.out.println("Damn young you are brother!!");
			break;

		case 23:
			System.out.println("Almost There!!");
			break;

		case 26:
			System.out.println("1 year old you are now:P");
			break;

		default:
			System.out.println("Its the silver jubilee");
		}
	}
}
