package code.examples;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ParagraphFormatDate {

	public static void main(String[] args) {
		String paragraph = "Format date 03/25/2017";
		System.out.println(formatParagraphDate(paragraph));
		
	}
	
	public static String formatParagraphDate(String paragraph) {

		String vals[] = paragraph.split(" ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		for(String obj : vals)
			if(obj.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}")) {
				
				String newDate = null;
				try {
					Date dt = new SimpleDateFormat("MM/dd/yyyy").parse(obj);
					newDate = dateFormat.format(dt);
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				paragraph = paragraph.replace(obj, newDate);
				
			}
		
		return paragraph;
	}
	
}
