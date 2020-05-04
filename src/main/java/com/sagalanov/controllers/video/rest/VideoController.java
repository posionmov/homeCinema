package com.sagalanov.controllers.video.rest;

import com.sagalanov.services.web.video.interfaces.WebVideoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.sagalanov.constants.film.FilmConstants.FILM_ID;
import static com.sagalanov.constants.film.FilmConstants.PATH_FILM_BYTES;

@RestController
public class VideoController {

    private WebVideoService videoService;

    public VideoController(WebVideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping(PATH_FILM_BYTES)
    public void byteRange(HttpServletRequest request,
                          HttpServletResponse response,
                          @RequestParam(value = FILM_ID, required = false) String fileId) throws Exception {
        videoService.handleVideoRequest(request, response, fileId);
    }
}
