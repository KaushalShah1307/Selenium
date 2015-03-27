import javax.swing.JOptionPane;
public class UserInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String first_name;
		first_name = JOptionPane.showInputDialog("First Name: ", "Enter your First Name here");

		String last_name;
		last_name = JOptionPane.showInputDialog("Last Name: ", "Enter your Last Name here");

		String full_name;
		full_name = "You are : "+ first_name +" "+ last_name;

		JOptionPane.showMessageDialog(null, full_name);


	}

}
