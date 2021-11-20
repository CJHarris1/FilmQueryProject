package com.skilldistillery.filmquery.database;

import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
	public Film findFilmById(String filmId);

	public Actor findActorById(String actorId);

	public List<Actor> findActorsByFilmId(String filmId);
	
	public List<Film> findFilmByKeyword(String keyword);
}
