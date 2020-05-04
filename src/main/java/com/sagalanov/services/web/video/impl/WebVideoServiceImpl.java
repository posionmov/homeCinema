package com.sagalanov.services.web.video.impl;

import com.sagalanov.models.films.Film;
import com.sagalanov.services.domain.video.interfaces.DomainVideoService;
import com.sagalanov.services.web.video.interfaces.WebVideoService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.sagalanov.constants.film.FilmConstants.FILM_LIST_ATTRIBUTE;
import static com.sagalanov.constants.film.FilmConstants.FILM_LIST_VIEW;
import static com.sagalanov.constants.film.FilmConstants.FILM_NAME;
import static com.sagalanov.constants.film.FilmConstants.FILM_DESCRIPTION;
import static com.sagalanov.constants.film.FilmConstants.FILM_VIEW;

@Service
public class WebVideoServiceImpl implements WebVideoService {

    private DomainVideoService domainVideoService;

    public WebVideoServiceImpl(DomainVideoService domainVideoService) {
        this.domainVideoService = domainVideoService;
    }

    @Override
    public void handleVideoRequest(
            HttpServletRequest request,
            HttpServletResponse response,
            String fileId) throws ServletException, IOException {
        domainVideoService.handleVideoRequest(request, response, fileId);
    }

    @Override
    public String getListOfFilms(Model model) {
        List<Film> films = domainVideoService.getListOfFilms();
        model.addAttribute(FILM_LIST_ATTRIBUTE, films);
        return FILM_LIST_VIEW;
    }

    @Override
    public String storeFile(String name, MultipartFile file, String description) {
        return domainVideoService.storeFile(name, file, description);
    }

    @Override
    public String getVideoView(Model model, String fileId) {
        Film film = domainVideoService.getFilmById(fileId);
        model.addAttribute(FILM_NAME, film.getFilmName());
        model.addAttribute(FILM_DESCRIPTION, film.getDescription());
        return FILM_VIEW;
    }
}
