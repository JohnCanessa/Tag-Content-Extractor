import java.util.*;

import java.util.regex.*;

/*
 * 
 */
public class Solution {

	/*
	 * <(.+)>	match start tags and save to group 1
	 * ([^<]+)	match all text between the start and end tags
	 * </\\1>	match the contents of the closing with the opening tag (in group 1)
	 */
	public static void regexChecker(String theRegex, String str2Check) {
		
		// ???? ????
		System.out.println("theRegex ==>" + theRegex + "<==");
		System.out.println("str2Check ==>" + str2Check + "<== str2Check.length: " + str2Check.length());
		
		// **** ****
		Pattern pattern = Pattern.compile(theRegex);
		
		// **** ****
		Matcher regexMatcher = pattern.matcher(str2Check);
		
		// **** look for a match ****
		boolean matchFound = false;
		while(regexMatcher.find()) {
			
			// ???? ????
			System.out.println("regexMatcher.groupCount: " + regexMatcher.groupCount());
			
			for (int i = 0; i <= regexMatcher.groupCount(); i++)
				System.out.println("group(" + i + "): " + regexMatcher.group(i));
			
			System.out.println("regexMatcher.start: " + regexMatcher.start());
			System.out.println("regexMatcher.end: " + regexMatcher.end());

			// **** display the contents of the tag ****
			System.out.println(regexMatcher.group(2));
			
			// **** flag that a match was found ****
			matchFound = true;
		}
		
		// **** if match not found ****
		if (!matchFound)
			System.out.println("None");
		
		// ???? ????
		System.out.println();
	}
	
	/*
	 * 
	 */
	public static void main(String[] args) {

		// **** open scanner ****
		Scanner in = new Scanner(System.in);
		
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
			// **** process a line using the specified regular expression ****
//			String theRegex = "<(.+)>([^<]+)</\\1>";
//			String theRegex = "<(.+)>";
//			String theRegex = "<(.+)>([^<]+)";
			String theRegex = "<(.+)>([^<]+)</\\1>";
			regexChecker(theRegex, line);

			testCases--;
		}
		
		// **** close scanner ****
		in.close();

	}

}
