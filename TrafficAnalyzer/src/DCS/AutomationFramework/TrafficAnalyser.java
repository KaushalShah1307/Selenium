package DCS.AutomationFramework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class TrafficAnalyser {

	private Collection seleniumRequests;
	//__________________________________________________________________________________________________
	public TrafficAnalyser(Collection seleniumRequests)
	{ this.seleniumRequests = seleniumRequests;
	}//end function TrafficAnalyser //__________________________________________________________________________________________________
	public int get_num_requests() { return seleniumRequests.size(); }//end function get_num_requests //__________________________________________________________________________________________________
	public int get_content_size() { int totalContentSize = 0; for (Iterator iterator = seleniumRequests.iterator(); iterator.hasNext();)
	{ HTMLRequestFromSelenium hr = (HTMLRequestFromSelenium) iterator.next(); totalContentSize += hr.bytes; } return totalContentSize; }//end function get_content_size //___________________________________________________________________________________________________
	public HashMap get_http_status_codes() { HashMap statusCodes = new HashMap(); for (Iterator iterator = seleniumRequests.iterator(); iterator.hasNext();)
	{ HTMLRequestFromSelenium hr = (HTMLRequestFromSelenium) iterator.next();
	if(statusCodes.containsKey(hr.statusCode)) { statusCodes.put(hr.statusCode, statusCodes.get(hr.statusCode +1)); } else { statusCodes.put(hr.statusCode, 1); } } return statusCodes; }//end function get_http_status_codes //___________________________________________________________________________________________________
	public HashMap get_file_extension_stats() { HashMap extensions = new HashMap(); for (Iterator iterator = seleniumRequests.iterator(); iterator.hasNext();)
	{ HTMLRequestFromSelenium hr = (HTMLRequestFromSelenium) iterator.next(); URL url = null;
	try { url = new URL(hr.url); String file_extension; double size = hr.bytes/1000.0; file_extension=""; String doc = url.getPath(); if(doc.contains("."))
	{ file_extension = doc.substring(doc.indexOf(".")+1).trim(); }
	if(file_extension.compareTo("")==0) { file_extension = "unknown"; }
	if(extensions.containsKey(file_extension)) { Object[] stats = (Object[]) extensions.get(file_extension); stats[0] = (Integer)stats[0] +1; stats[1] = (Double)stats[1] + size; extensions.put(file_extension, stats); }
	else { Object[] stats = new Object[2]; stats[0] = 1; stats[1] = size; extensions.put(file_extension, stats); } } catch (MalformedURLException e) { } } return extensions; }//end function get_file_extension_stats }//end class TrafficAnalyser


}
