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
    System.out.println("2) Look up a film by a search keyword");
    System.out.println("3) Exit");
    
    String userInput = input.nextLine();
    
    switch(userInput) {
    case "1":
    	searchFilmById();
    	break;
    case "2":
    	searchFilmByKeyword();
    	break;
    case "3":
    	break;
    default:
    	System.out.println("Invalid input, please try again");
    	break;
    }
  }
  
  private void searchFilmById() {
	  
  }
  
  private void searchFilmByKeyword() {
	  
  }

}
