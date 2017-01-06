package com.hand.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hand.dto.Film;
import com.hand.dto.Language;
import com.hand.dto.Page;
import com.hand.dto.ResponseData;
import com.hand.service.FilmService;


@Controller
@RequestMapping("/film")
public class FilmController {
	@Autowired
    private FilmService filmService;
	
    @ResponseBody
    @RequestMapping(path = "", method = RequestMethod.GET)
    public ResponseData<Film> query(@RequestParam(name = "film_id", required = false) Integer film_id,
    		@RequestParam(name = "title", required = false, defaultValue = "") String title,
                              @RequestParam(name = "description", required = false, defaultValue = "") String description,
                              @RequestParam(name = "currentPage",required = false, defaultValue = "1") int page,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    	
    //	System.out.println(film_id);
    	Film film=new Film(film_id,title,description,1);
    	Page arg = new Page().setPage(page).setPageSize(pageSize).setEntity(film);
        return filmService.query(arg);	
    }
	
	//DELETE
    @ResponseBody
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable("id")Integer id){
		int t=filmService.delete(id);
		//return "redirect:/index.html";
		return t+"";
	}

	@ResponseBody
	@RequestMapping(path="/queryLanguage",method=RequestMethod.GET)
	public List<Language> queryLanguage(){
		//System.out.println("FilmController"+filmService.queryLanguage());
		return filmService.queryLanguage();
	}
	
	@ResponseBody
    @RequestMapping(path = "/insert", method = RequestMethod.GET)
    public String insert(@RequestParam(name = "title", required = false, defaultValue = "") String title,
                              @RequestParam(name = "description", required = false, defaultValue = "") String description,
                              @RequestParam(name = "language",required = false, defaultValue = "1") int language_id) {
    	System.out.println("INSERT:"+title +" "+description);
		Film film=new Film(title,description,language_id);
        int t=filmService.insert(film);
        return t+"";
    }
	
	//UPDATE
	@ResponseBody
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public Film update(@PathVariable("id")Integer id){
        Film film=filmService.selectById(id);
        System.out.println("update:"+film.toString());
		return film;
	}
	
	@ResponseBody
	@RequestMapping(value="/updateFilm",method=RequestMethod.GET)
	public String updateFilm(@RequestParam(name = "film_id", required = false, defaultValue = "") int film_id,
			@RequestParam(name = "title", required = false, defaultValue = "") String title,
            @RequestParam(name = "description", required = false, defaultValue = "") String description,
            @RequestParam(name = "language",required = false, defaultValue = "1") int language_id){
		Film film=new Film(film_id,title,description,language_id);
		int t=filmService.update(film);
		return ""+t;
	}
	
}
