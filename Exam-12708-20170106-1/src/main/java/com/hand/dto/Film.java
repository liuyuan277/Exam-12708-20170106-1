package com.hand.dto;

public class Film {
	private Integer film_id;
	private String title;
	private String description;
	private int language_id;
	
	private Language language;
																																																																																																																																																																																																																																		
	public Film() {
		super();
	}

	public Film(Integer film_id) {
		super();
		this.film_id = film_id;
	}

	public Film(Integer film_id, String title, String description, int language_id) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.language_id = language_id;
	}

	public Film(String title, String description, int language_id) {
		super();
		this.title = title;
		this.description = description;
		this.language_id = language_id;
	}
		
	public Language getLanguage() {
		return language;
	}
	public void setLanguage(Language language) {
		this.language = language;
	}
	public Integer getFilm_id() {
		return film_id;
	}
	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLanguage_id() {
		return language_id;
	}
	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}
	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", language_id="
				+ language_id + ", language=" + language + "]";
	}

}
