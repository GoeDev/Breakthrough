package breakthroughPP.game.base;

import java.util.*;
import java.util.regex.*;

/**
 * This is a class for starting the Application.
 *
 */
public class StartGame {
	private static Set<String> args;
	public static boolean      debug;

	/**
	 * the function takes the args array and parses the inputs, sets Settings accordingly to the arguments and eventually starts the application.
	 * @param args the array that's imported from the command line.
	 */
	public static void main(String[] input)
	{
		Pattern pat_dimx, pat_dimy, pat_help;
		String  str_dim  = "([:=])(\\d)";
		String  str_dimx = "([-]*)([Xx])" + str_dim;
		String  str_dimy = "([-]*)([Yy])" + str_dim;
		String  str_help = "(-*)([h])";

		pat_dimx = Pattern.compile(str_dimx);
		pat_dimy = Pattern.compile(str_dimy);
		pat_help = Pattern.compile(str_help);
		int dimX, dimY;
		args = new HashSet<String>(Arrays.asList(input));
		if (args.contains("-d") || args.contains("--debug")) { debug = true; System.out.println("Debug"); }
		for (String s:args)
		{
			if (args.isEmpty() || pat_help.matcher(s).matches())
			{
				System.out.print("Usage: \n
													\t -d --debug : Use for debugging, enables output on the Commandline.\n
													\t -h -- help : Use to display this message.\n"                                                                              );
			}
			if (pat_dimx.matcher(s).matches())
			{
				String[] arr = s.split("().*)(:)(\\d)");
				dimX = Integer.parseInt(arr[3]);
			}
			if (pat_dimy.matcher(s).matches())
			{
				String[] arr = s.split("().*)(:)(\\d)");
				dimX = Integer.parseInt(arr[3]);
			}
		}
	}
}
