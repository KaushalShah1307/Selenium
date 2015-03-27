import java.util.ArrayList;
import java.util.Iterator;

public class ArrayIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList AList = new ArrayList();

		AList.add("Chandni");
		AList.add("Kaushal");
		AList.add("Shah");

		Iterator It = AList.iterator();

		while (It.hasNext()){
				System.out.println(It.next());
	}
			System.out.println("Whole list is: " +AList);

			System.out.println("The 1st Position is: " +AList.get(0));
			System.out.println("The 2nd Position is: " +AList.get(1));
			System.out.println("The 3rd Position is: " +AList.get(2));

			System.out.println("Chandni`s full name is: " +AList.get(0)+ " "+AList.get(1)+ " "+AList.get(2));

}
}
