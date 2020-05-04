package com.sagalanov.services.domain.video.interfaces;

import com.sagalanov.models.films.Film;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface DomainVideoService {

    void handleVideoRequest(HttpServletRequest request, HttpServletResponse response, String fileId) throws ServletException, IOException;

    List<Film> getListOfFilms();

    String storeFile(String name, MultipartFile file, String description);

    Film getFilmById(String id);
}
