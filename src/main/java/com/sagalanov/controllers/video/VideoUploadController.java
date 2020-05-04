package com.sagalanov.controllers.video;

import com.sagalanov.services.web.video.interfaces.WebVideoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import static com.sagalanov.constants.film.FilmConstants.FILM_UPLOAD_PATH;
import static com.sagalanov.constants.film.FilmConstants.FILM_UPLOAD_VIEW;
import static com.sagalanov.constants.film.FilmConstants.FILM_NAME;
import static com.sagalanov.constants.film.FilmConstants.FILM_PART;
import static com.sagalanov.constants.film.FilmConstants.FILM_DESCRIPTION;

@Controller
public class VideoUploadController {

    private WebVideoService webVideoService;

    public VideoUploadController(WebVideoService webVideoService) {
        this.webVideoService = webVideoService;
    }

    @GetMapping(FILM_UPLOAD_PATH)
    public String getUploadPage() {
        return FILM_UPLOAD_VIEW;
    }

    @PostMapping(FILM_UPLOAD_PATH)
    public String uploadFile(@RequestParam(FILM_NAME) String name,
                             @RequestParam(FILM_PART) MultipartFile file,
                             @RequestParam(FILM_DESCRIPTION) String description) {
        return webVideoService.storeFile(name, file, description);
    }

}
