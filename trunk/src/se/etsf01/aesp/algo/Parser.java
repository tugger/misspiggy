package se.etsf01.aesp.algo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Parser {
	protected File file;

	/**
	 * Initiates the class with the designated filepath.
	 * 
	 * @param filepath
	 *            Name and path of the file to be parsed.
	 */
	public Parser(String filepath) {
		file = new File(filepath);
	}

	/**
	 * Parses the initiated file and returns a list of the projects parsed.
	 * 
	 * @return A ProjectList object containing all the projects parsed.
	 */
	public ProjectList parseFile() {
		try {
			Scanner scanner = new Scanner(new FileReader(file));

			ProjectList pl = new ProjectList();
			try {
				int i = 1;
				while (scanner.hasNextLine()) {
					Project project = processLine(scanner.nextLine());
					project.setIdentifier("Project " + i);
					i++;
					pl.add(project);
				}
			} finally {
				scanner.close();
			}
			return pl;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Parses a line from the initiated file. Returns a project with the parsed
	 * attributes.
	 * 
	 * @param aLine
	 *            A String containing the line with all the attributes for a
	 *            given project.
	 * @return A Project object containing the attributes contained in the line.
	 */
	protected Project processLine(String aLine) {
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter(",");
		Project project = new Project();
		Map<Attribute, Rating> attributes = project.attributes();
		try {
			for (Attribute attr : Attribute.values()) {
				String ratingStr = scanner.next();
				ratingStr = ratingStr.trim();
				attributes.put(attr, Rating.fromString(ratingStr));
			}
			String locStr = scanner.next().trim();
			project.setLinesOfCode(Integer.valueOf(locStr));

			String actualEffortStr = scanner.next().trim();
			float actualEffortFloat = Float.valueOf(actualEffortStr);
			Effort actualEffort = Effort
					.instantiatePersonHours(actualEffortFloat);
			project.setActualEffort(actualEffort);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
		return project;
	}

}
