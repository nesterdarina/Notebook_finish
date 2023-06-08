package edu.examples.java_classes.input.command.impl;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.input.command.Command;

public class ConsoleShowAllNotes implements Command {

	private Controller controller = Controller.getInstance();

	@Override
	public void execute() {

		System.out.println("show all notes");

		String request = "SHOW_ALL_NOTES";

		String response;

		response = controller.doAction(request);

		System.out.println(response);

	}

}