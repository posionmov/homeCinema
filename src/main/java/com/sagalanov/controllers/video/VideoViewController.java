package com.sagalanov.controllers.video;

import com.sagalanov.services.web.video.interfaces.WebVideoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.sagalanov.constants.film.FilmConstants.FILM_ID;
import static com.sagalanov.constants.film.FilmConstants.FILM_PATH;

@Controller
public class VideoViewController {

    private WebVideoService videoService;

    public VideoViewController(WebVideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping(FILM_PATH)
    public String getVideoViewPage(
            Model model,
            @RequestParam(value = FILM_ID, required = false) String fileId) {
        return videoService.getVideoView(model, fileId);
    }
}
