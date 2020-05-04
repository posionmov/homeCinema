package com.sagalanov.constants.film;

import com.sagalanov.services.domain.video.impl.FileHandler;

public class FilmConstants {

    // URL
    public static final String FILM_LIST_PATH = "/film/list";
    public static final String FILM_LIST_ATTRIBUTE = "filmList";
    public static final String FILM_LIST_VIEW = "films/filmList";

    public static final String FILM_UPLOAD_PATH = "/film/upload";
    public static final String FILM_UPLOAD_VIEW = "films/filmUpload";

    public static final String PATH_FILM_BYTES = "/film/byterange";

    public static final String FILM_VIEW = "films/filmView";
    public static final String FILM_PATH = "/film/view";

    public static final String REDIRECT = "redirect:/";


    // film vars
    public static final String FILM_ID = "filmId";
    public static final String FILM_NAME = "name";
    public static final String FILM_PART = "file";
    public static final String FILM_DESCRIPTION = "description";
    public static final String CATALITA_HOME_PROPERTY = "catalina.home";
    public static final String TMP_FOLDER_NAME = "tmpFiles";

    public static final String ATTR_FILE = FileHandler.class.getName() + ".file";
}
