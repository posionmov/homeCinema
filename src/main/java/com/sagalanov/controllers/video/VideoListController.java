package com.sagalanov.controllers.video;

import com.sagalanov.services.web.video.interfaces.WebVideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.sagalanov.constants.film.FilmConstants.FILM_LIST_PATH;

@Controller
public class VideoListController {

    private WebVideoService webVideoService;

    public VideoListController(WebVideoService webVideoService) {
        this.webVideoService = webVideoService;
    }

    @GetMapping(FILM_LIST_PATH)
    public String getListOfFilms(Model model) {
        return webVideoService.getListOfFilms(model);
    }
}
