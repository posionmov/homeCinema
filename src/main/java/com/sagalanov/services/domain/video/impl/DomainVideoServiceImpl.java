package com.sagalanov.services.domain.video.impl;

import com.sagalanov.models.films.Film;
import com.sagalanov.repositories.FilmRepository;
import com.sagalanov.services.domain.security.interfaces.SecurityService;
import com.sagalanov.services.domain.video.interfaces.DomainVideoService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.sagalanov.constants.film.FilmConstants.ATTR_FILE;
import static com.sagalanov.constants.film.FilmConstants.CATALITA_HOME_PROPERTY;
import static com.sagalanov.constants.film.FilmConstants.TMP_FOLDER_NAME;
import static com.sagalanov.constants.film.FilmConstants.REDIRECT;

@Service
public class DomainVideoServiceImpl implements DomainVideoService {

    private FileHandler fileHandler;
    private FilmRepository filmRepository;
    private SecurityService securityService;

    public DomainVideoServiceImpl(FileHandler fileHandler, FilmRepository filmRepository, SecurityService securityService) {
        this.fileHandler = fileHandler;
        this.filmRepository = filmRepository;
        this.securityService = securityService;
    }

    @Override
    public void handleVideoRequest(
            HttpServletRequest request,
            HttpServletResponse response, String fileId) throws ServletException, IOException {
        Film film = filmRepository.findById(fileId).orElse(null);
        if (!ObjectUtils.isEmpty(film)) {
            String fileLocation = film.getFilePath();
            request.setAttribute(ATTR_FILE, fileLocation);
            fileHandler.handleRequest(request, response);
        }
    }

    @Override
    public List<Film> getListOfFilms() {
        return filmRepository.findAll();
    }

    @Override
    public String storeFile(String name, MultipartFile file, String description) {
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String rootPath = System.getProperty(CATALITA_HOME_PROPERTY);
                File dir = new File(rootPath + File.separator + TMP_FOLDER_NAME);
                dir.mkdirs();
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                storeFilm(name, description, dir.getAbsolutePath() + File.separator + name);
                return REDIRECT;
            } catch (IOException e) {
                return REDIRECT;
            }
        } else {
            return REDIRECT;
        }
    }

    @Override
    public Film getFilmById(String id) {
        return filmRepository.findById(id).orElse(null);
    }

    private void storeFilm(String name, String description, String path) {
        Film film = Film.builder()
                .setFilmName(name)
                .setFilmDate(new Date())
                .setFilmUploader(securityService.getCurrentUsername())
                .setFilmFilePath(path)
                .setFilmDescription(description)
                .build();
        this.filmRepository.save(film);
    }

}
