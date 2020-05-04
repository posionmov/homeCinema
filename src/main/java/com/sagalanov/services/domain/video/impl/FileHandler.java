package com.sagalanov.services.domain.video.impl;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import static com.sagalanov.constants.film.FilmConstants.ATTR_FILE;

@Service
public class FileHandler extends ResourceHttpRequestHandler {

    @Override
    protected Resource getResource(HttpServletRequest request) {
        final File file = new File((String)request.getAttribute(ATTR_FILE));
        return new FileSystemResource(file);
    }
}
