import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class DocumentationGenerator {
	public static int max = 200;

	public static void main(String[] arghs) throws IOException {

		drawFirstLine();
		readFile();
		// /**
		// * First line
		// */

	}

	public static void drawFirstLine() {
		for (int i = 2; i < 204; i++) {

			System.out.print('_');
		}
		System.out.println();
	}

	public static void draw(String[] headerName, int columnSpacing) {
		int count = 0;
		int i = 0;
		// System.out.println(headerName[3].length());

		System.out.println(
				"|" + String.format("%-" + 29 + "s", headerName[0]) + "|" + String.format("%-29s", headerName[1]) + "|"
						+ String.format("%-29s", headerName[2]) + "|" + String.format("%-110s", headerName[3]) + "|");

	}

	public static void readFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
		String s = " ";
		int i = 1;
		ArrayList<String> col1 = new ArrayList<String>();
		ArrayList<String> col2 = new ArrayList<String>();
		ArrayList<String> col3 = new ArrayList<String>();
		ArrayList<String> col4 = new ArrayList<String>();

		while ((s = br.readLine()) != null) {
			// System.out.println(s);
			s = s.replaceAll("\t", "    ");
			if (s.compareTo("####") == 0) {

				int maxCols = Math.max(col1.size(), Math.max(col2.size(), Math.max(col3.size(), col4.size())));
				String rowArray[] = new String[4];
				for (int j = 0; j < maxCols; j++) {
					if (j < col1.size())
						rowArray[0] = col1.get(j);
					else
						rowArray[0] = "";
					if (j < col2.size())
						rowArray[1] = col2.get(j);
					else
						rowArray[1] = "";
					if (j < col3.size())
						rowArray[2] = col3.get(j);
					else
						rowArray[2] = "";
					if (j < col4.size())
						rowArray[3] = col4.get(j);
					else
						rowArray[3] = "";
					draw(rowArray, 25);
				}

				col1 = new ArrayList<String>();
				col2 = new ArrayList<String>();
				col3 = new ArrayList<String>();
				col4 = new ArrayList<String>();
				i = 1;
				printBottom();

			} else if (s.compareTo("##") == 0) {
				i++;

			} else {
				if (s.length() * 5 > max)
					max = s.length();
				if (i == 1)
					col1.add(s);
				if (i == 2)
					col2.add(s);
				if (i == 3)
					col3.add(s);
				if (i == 4)
					col4.add(s);

			}

		}
	}

	public static void printBottom() {

		String s = "|" + String.format("%-" + 29 + "s", "") + "|" + String.format("%-29s", "") + "|"
				+ String.format("%-29s", "") + "|" + String.format("%-110s", "") + "|";
		s = s.replaceAll(" ", "_");
		System.out.println(s);

	}
}
