package edu.examples.java_classes.input.command.impl;

import java.util.Scanner;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.input.command.Command;

public class ConsoleFindItemByDate implements Command{

	private Controller controller = Controller.getInstance();
	
	@Override
	public void execute() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter date in format dd.mm.yyyy > ");
		String date = sc.nextLine();

		String request = "FIND_BY_DATE date=" + date;

		String response;

		response = controller.doAction(request);

		System.out.println(response);
	
		
	}

}
