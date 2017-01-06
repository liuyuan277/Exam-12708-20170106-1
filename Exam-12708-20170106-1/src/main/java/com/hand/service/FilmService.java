package com.hand.service;

import java.util.List;

import com.hand.dto.Film;
import com.hand.dto.Language;
import com.hand.dto.Page;
import com.hand.dto.ResponseData;


public interface FilmService {
	int insert(Film film);

	ResponseData<Film> query(Page arg);

	int delete(Integer id);

	List<Language> queryLanguage();

	Film selectById(Integer id);

	int update(Film film);

}
