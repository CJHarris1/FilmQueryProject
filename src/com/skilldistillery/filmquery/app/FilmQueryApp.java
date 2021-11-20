package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		System.out.println("Welcome to Movies on Command...line!");
//    app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		Actor actor = db.findActorById(1);
		System.out.println(film);
		System.out.println(actor);
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("What would you like to do?");
		System.out.println("1) Look up a film by its id");
		System.out.println("2) Look up films by a search keyword");
		System.out.println("3) Exit");

		String userInput = input.nextLine();
		System.out.println();

		switch (userInput) {
		case "1":
			searchFilmById(input);
			break;
		case "2":
			searchFilmByKeyword(input);
			break;
		case "3":
			System.out.println("Enjoy your movie!");
			break;
		default:
			System.out.println("Invalid input, please try again");
			System.out.println();
			break;
		}
	}

	private void searchFilmById(Scanner input) {
			System.out.println("Please enter the Id of the film you wish to view:");
			int id = input.nextInt();
			input.nextLine();
			System.out.println();
			if (db.findFilmById(id) == null) {
				System.out.println("Invalid movie id!");
			} else {
				System.out.println(db.findFilmById(id));
				System.out.println();
			}
			searchByIdAgain(input);
	}

	private void searchByIdAgain(Scanner input) {
		boolean validInput = false;
		while(!validInput) {
			System.out.println("Would you like to search for another movie with an id?");
			System.out.println("1) Yes, let me search another movie using id");
			System.out.println("2) No, take me back to the main menu");
			String userInput = input.nextLine();
			System.out.println();
		
			switch (userInput) {
			case "1":
				searchFilmById(input);
				validInput = true;
				break;
			case "2":
				startUserInterface(input);
				validInput = true;
				break;
			default:
				System.out.println("Invalid input, please try again");
				break;
			}
		}
	}

	private void searchFilmByKeyword(Scanner input) {
		System.out.println("Please enter the keyword of the film you wish to view:");
		String keyword = input.nextLine();
		
		System.out.println();
		if (db.findFilmByKeyword(keyword)==null) {
			System.out.println("Invalid movie id!");
		} else {
			for (Film movie : db.findFilmByKeyword(keyword)) {
				System.out.println(movie);
			}
			System.out.println();
		}
		searchByKeywordAgain(input);
	}
	
	private void searchByKeywordAgain(Scanner input) {
		boolean validInput = false;
		while(!validInput) {
			System.out.println("Would you like to search for another movie using a keyword?");
			System.out.println("1) Yes, let me search another movie using a keyword");
			System.out.println("2) No, take me back to the main menu");
			String userInput = input.nextLine();
			System.out.println();
		
			switch (userInput) {
			case "1":
				searchFilmByKeyword(input);
				validInput = true;
				break;
			case "2":
				startUserInterface(input);
				validInput = true;
				break;
			default:
				System.out.println("Invalid input, please try again");
				break;
			}
		}
	}

}
