package com.hand.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.dto.Film;
import com.hand.dto.Language;
import com.hand.dto.Page;
import com.hand.dto.ResponseData;
import com.hand.mapper.FilmMapper;
import com.hand.service.FilmService;
@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmMapper filmMapper;
	
	@Override
	public int insert(Film film) {
		int t=filmMapper.insertFilm(film);
		System.out.println("Insert Film id ="+film.getFilm_id());
		return t;
	}

	@Override
	public ResponseData<Film> query(Page page) {
        ResponseData<Film> responseData = new ResponseData<>();
        responseData.setRows(filmMapper.select(page));
        responseData.setTotal(filmMapper.selectCount((Film) page.getEntity()));
		return responseData;
	}

	@Override
	public int delete(Integer id) {
		int t=filmMapper.delete(id);	
		System.out.println("Delete Film id ="+id);
		return t;
	}

	@Override
	public List<Language> queryLanguage() {
		
		return filmMapper.queryLanguage();
	}

	@Override
	public Film selectById(Integer id) {		
		return filmMapper.selectById(id);
	}

	@Override
	public int update(Film film) {
		
		return filmMapper.update(film);
	}


}
