package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

//this will be only class that talks to sql

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		String user = "student";
		String pass = "student";
		Film film = null;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT film.id, film.title, film.description, film.release_year, film.rating, language.name FROM  film JOIN language ON language.id = film.language_id WHERE film.id = ?;";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setReleaseYear(rs.getString("release_year"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				film.setActors(findActorsByFilmId(filmId));

				
			}
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

	@Override
	public Actor findActorById(int actorId) {
		String user = "student";
		String pass = "student";
		Actor actor = null;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, actorId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				actor = new Actor(); 
			    actor.setId(rs.getInt("id"));
			    actor.setFirstName(rs.getString("first_name"));
			    actor.setLastName(rs.getString("last_name"));
			    
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		String user = "student";
		String pass = "student";
		List<Actor> actors = new ArrayList<>();
		Actor actor;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT actor.id, actor.first_name, actor.last_name \n"
					+ "FROM film_actor JOIN actor ON actor.id = film_actor.actor_id\n"
					+ "                JOIN film ON film_actor.film_id = film.id\n"
					+ "                WHERE film_actor.film_id = ?;";
			stmt = conn.prepareStatement(sqltxt);

			stmt.setInt(1, filmId);
			rs = stmt.executeQuery();

			while (rs.next()) {
				actor = new Actor(); 
			    actor.setId(rs.getInt("id"));
			    actor.setFirstName(rs.getString("first_name"));
			    actor.setLastName(rs.getString("last_name"));
			    actors.add(actor);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}
	
	public List<Film> findFilmByKeyword(String keyword) {
		String user = "student";
		String pass = "student";
		List<Film> films =  new ArrayList<>();
		Film film = null;
		Connection conn;
		String sqltxt;
		PreparedStatement stmt;
		ResultSet rs;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			sqltxt = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?;";
			stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, "%" + keyword + "%");
			stmt.setString(2, "%" + keyword + "%");
			rs = stmt.executeQuery();

			while (rs.next()) {
				film = new Film();
				film.setId(rs.getInt("id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguageId(rs.getInt("language_id"));
				film.setRentalDuration(rs.getInt("rental_duration"));
				film.setRentalRate(rs.getDouble("rental_rate"));
				film.setLength(rs.getInt("length"));
				film.setReplacementCost(rs.getDouble("replacement_cost"));
				film.setRating(rs.getString("rating"));
				film.setSpecialFeatures(rs.getString("special_features"));
				int id = film.getId();
				film.setActors(findActorsByFilmId(id));
				films.add(film);

				
			}
			rs.close();
			stmt.close();
			conn.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

		return films;
		
	}

}
