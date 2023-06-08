package edu.examples.java_classes.output;

import java.util.List;

import edu.examples.java_classes.entity.Note;

public class NotebookOutput {

	public static String print(List<Note> notes) {

		if (notes == null || notes.size() <= 0) {
			return "There are no notes";
		}

		StringBuilder stringBuilder = new StringBuilder();

		for (Note n : notes) {
			stringBuilder.append(n.toString());
			stringBuilder.append('\n');
		}
		return stringBuilder.toString();
	}
}
