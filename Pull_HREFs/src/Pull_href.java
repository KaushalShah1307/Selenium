import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import javax.swing.text.html.parser.Element;


public class Pull_href {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		String html = "http://www-staging-2.forbes.com/best-domestic-business-schools/";
		Document document = Jsoup.parse(html); // Can also take an URL.
		for (Element element : document.getElementsByTag("a")) {
		    System.out.println(element.attr("href"));*/

		String webPage = "www.wikipedia.com";

		Pattern p = Pattern.compile("<a +href=\"([a-zA-z0-9\\:\\-\\/\\.]+)\">");
		Matcher m = p.matcher(webPage);

		ArrayList<String> foundUrls = new ArrayList<String>();

		while(m.find()) {
		  foundUrls.add(m.group(1));
		}
		}

	}


