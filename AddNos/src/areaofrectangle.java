import javax.swing.JOptionPane;

public class areaofrectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String Breadth;
		Breadth = JOptionPane.showInputDialog("Breadth of a Rectangle : ");

		String Height;
		Height = JOptionPane.showInputDialog("Height of a Rectangle : ");


		float area = Float.parseFloat(Breadth) * Float.parseFloat(Height);

		JOptionPane.showMessageDialog(null, "Area=" + area,"", JOptionPane.WARNING_MESSAGE);

		System.exit(0);


	}

}
