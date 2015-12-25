package com.happydesk.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;



public class CommonUtil {
	
	public static String trimHtmlTags(String htmlText) {
		Document doc = Jsoup.parse(htmlText);
		String filteredText = Jsoup.clean(doc.body().html(), basicWithoutRel());
		return filteredText;
	}
	
	private static Whitelist basicWithoutRel() {
		return new Whitelist().addTags(new String[] { "a", "b", "blockquote", "br", "cite", "code", "dd", "dl", "dt", "em", "i", "li", "ol", "p", "pre", "q", "small", "strike", "strong", "sub", "sup", "u", "ul" }).addAttributes("a", new String[] { "href" }).addAttributes("blockquote", new String[] { "cite" }).addAttributes("q", new String[] { "cite" }).addProtocols("a", "href", new String[] { "ftp", "http", "https", "mailto" }).addProtocols("blockquote", "cite", new String[] { "http", "https" }).addProtocols("cite", "cite", new String[] { "http", "https" });
	}
	
	public static String trimAllHtmlTagsExceptBr(String htmlText) {
		Document doc = Jsoup.parse(htmlText);
		String filteredText = Jsoup.clean(doc.body().html(), removeAllExceptBr());
		return filteredText;
	}
	
	private static Whitelist removeAllExceptBr() {
		return new Whitelist().addTags(new String[] {"br"});
	}
	
	public static String removeHTML(String filterString)
	{
		String ret=filterString.replaceAll("\\<.*?\\>", "").replaceAll("&.*?;"," ");
		return ret;
	}
	
	public static String removeHTMLForSearch(String filterString)
	{
		String ret=filterString.replaceAll("<em>", "--em--").replaceAll("<em/>", "--em/--").replaceAll("\\<.*?\\>", "").replaceAll("&.*?;"," ").replaceAll("--em--", "<em>").replaceAll("--em/--", "<em/>");
		return ret;
	}
	
	public static String removeBlockTag(String filterString) {
		String ret=filterString.replaceAll("</?((?i)div|p|span).*?>", "").replaceAll("</?((?i)div|p|span)","");
		return ret;
	}
	
	
	public static int ignoreHTML(String filterString){
		boolean startFlag=false;
		int actualCharCount=0;
		int count=0;
       for(int i=0;i<filterString.length();++i){
    	   if(!startFlag && filterString.charAt(i)=='<'){
    		   startFlag=true;
    		   continue;
    	   }
    	   if (startFlag && filterString.charAt(i) == '>'){
       			startFlag = false;
				continue;
			}
		 if (!startFlag) {
			 actualCharCount++;
			}
		 count=count+1;
		 if(actualCharCount >= 600){
			 return count;
		 }
       }
       return filterString.length();
	}
	
	public static String removeHtmlIncompleteTag(String comment) {
		String commentTag = removeHTML(comment);
		if(commentTag.contains("</")) {
			String tempComment = commentTag.replace(commentTag.substring(commentTag.indexOf("</")), "..........");
			return tempComment.trim();
		}
		return comment;
		
	}
	

	public static boolean isMobileUserAgent(HttpServletRequest request){
		if(request == null){
			return false;
		}
		String userAgent = request.getHeader("User-Agent");
		if(userAgent == null || userAgent.length() == 0) {
			return false;
		}
		else if((userAgent.toLowerCase().contains("mobile")||userAgent.toLowerCase().contains("symbianos")) && !userAgent.toLowerCase().contains("ipad") ){
			return true;
		}
		return false;
	}
	
	public static boolean isAndroidUserAgent(HttpServletRequest request){
		
		if(request == null){
			return false;
		}
		String userAgent = request.getHeader("User-Agent");
		if(userAgent == null || userAgent.length() == 0) {
			return false;
		}
		else if((userAgent.toLowerCase().contains("mobile") && userAgent.toLowerCase().contains("android"))){
			return true;
		}
		return false;
	}

	public static String hideConfidentialDetailsFromTestimonial(String desc){
		String arr[] = desc.split("(?<=[\\s])");
		String email_regex =  "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		String returnString = "";
		Pattern regex = Pattern.compile("\\d{6}");
		for(String s:arr){
			Matcher match = regex.matcher(s);
			if(s.trim().length()>5 && (s.trim().matches("^[-+]?[0-9]*\\.?[0-9]+$") || s.trim().matches("^[-+]?[0-9]*\\.")  || s.trim().matches("^[-+]?[0-9]*\\,") || s.trim().matches("^[-+]?[0-9]*\\,?[0-9]+$"))){
				String temp = s.substring(0,2)+"-"+s.substring(s.length()-2,s.length());
				String star="";
					for(int i=0;i<s.length()-4;i++)
						star+="*";
				temp = temp.replace("-", star);
				s = " "+temp;
			}else if(s.trim().length()>6 && s.trim().matches(email_regex)){
				String	replaceString=s.substring(1, s.indexOf("@"));
				String star = "";
					for(int i=0;i<replaceString.length();i++) 
						star +="*";
				String rep = s.replace(replaceString, star);
				s = s.replace(s, rep);
			}else if(match.find()){
				s = s.replaceAll("[0-9]", "*");
			}
		returnString = returnString+s;
	}
   return returnString;
  }
	
	public static String makeUrlFromText(String text) throws Exception {
		if(StringUtils.isNotEmpty(text)) {
			String regex = "^(http://?|https://?|ftp://|file://|www.)[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
			Pattern p = Pattern.compile(regex);
			String[] tempText = text.split(" ");
			List<String> tempTextList = new ArrayList<String>(tempText.length);
			for (String string : tempText) {
				Matcher matcher = p.matcher(string);
				while (matcher.find()) {
					if(string.startsWith("www")) {
						string =  "<a href=\"http://" + string + "\" target=\"_blank\" style='color: #3B8CB5'>"+string+"</a>";
					} else {
						string =  "<a href=\"" + string + "\" target=\"_blank\" style='color: #3B8CB5'>"+string+"</a>";
					}
				}
				tempTextList.add(string);
			}
			StringBuilder textBuilder=new StringBuilder();
			for (String tempStr : tempTextList) {
				textBuilder.append(tempStr).append(" ");
			}
			return textBuilder.toString();
		}
		
		return text;
	}
	
}
