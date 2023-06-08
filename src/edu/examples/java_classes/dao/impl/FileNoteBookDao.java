package edu.examples.java_classes.dao.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

	@Override
	public void save(Note n) throws DaoException {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("resources/my_notes.txt", true));
			writer.write(n.toString());
			writer.newLine();

		} catch (IOException e) {
			throw new DaoException("Notepad data not saved.", e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DaoException("Notepad data not saved.", e);
			}
		}
	}

	@Override
	public List<Note> allNotes() throws DaoException {
		List<Note> allNotes = new ArrayList<Note>();

		try {

			BufferedReader reader = new BufferedReader(new FileReader("resources/my_notes.txt"));

			String line;

			while ((line = reader.readLine()) != null) {

				allNotes.add(formText(line));
			}

		} catch (IOException e) {
			throw new RuntimeException("Somthing Wrong!");
		} finally {
			BufferedReader reader = null;
		}
		
		return allNotes;

	}

	public Note formText(String line) throws IOException {
		String[] params = line.split("\\s+", 5);

		String title = params[2].split("=")[1];
		String content = params[3].split("=")[1];

		Note note = new Note(title, content);
		return note;
	}

}
