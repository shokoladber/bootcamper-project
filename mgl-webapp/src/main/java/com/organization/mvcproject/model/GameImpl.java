package com.organization.mvcproject.model;

import com.organization.mvcproject.api.model.Game;
import org.springframework.stereotype.Component;

@Component
public class GameImpl implements Game {

	private Long id;
	private String name;
	private String genre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString(){
		return
				(
						"Name: " + this.getName() + "\n" +
						"Genre: " + this.getGenre() +
						"ID: " + this.getId()

				);
	};

}
