
public class newclass {

		private String gfName;

		public newclass(String thename){
			gfName = thename;
		}

		public String getName(){
			return gfName;
		}

		public void saying(){
			System.out.printf("The name of your gf was : %s", getName());
		}

		public void printmyname(String thename){
			System.out.println("Namaste " +thename);
		}
}
