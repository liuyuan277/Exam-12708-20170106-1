package com.hand.mapper;

import java.util.List;

import com.hand.dto.Film;
import com.hand.dto.Language;
import com.hand.dto.Page;

public interface FilmMapper {

	public int insertFilm(Film film);
	
    List<Film> select(Page<Film> dto);
    int selectCount(Film film);

	int delete(Integer id);

    List<Language> queryLanguage();
    
    Film selectById(int id);

	int update(Film film);
}
