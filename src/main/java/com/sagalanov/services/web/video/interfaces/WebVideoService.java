package com.sagalanov.services.web.video.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface WebVideoService {

    void handleVideoRequest(HttpServletRequest request, HttpServletResponse response, String fileId) throws ServletException, IOException;

    String getListOfFilms(Model model);

    String storeFile(String name, MultipartFile file, String description);

    String getVideoView(Model model, String fileId);
}
