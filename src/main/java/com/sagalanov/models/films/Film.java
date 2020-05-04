package com.sagalanov.models.films;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Film {

    @Id
    private String id;
    private String filmName;
    private Date filmDate;
    private String uploader;
    private String filePath;
    private String description;

    public Film() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public Date getFilmDate() {
        return filmDate;
    }

    public void setFilmDate(Date filmDate) {
        this.filmDate = filmDate;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static FilmBuilder builder() {
        return new Film().new FilmBuilder();
    }

    public class FilmBuilder {

        private FilmBuilder() {}

        public FilmBuilder setFilmName(String filmName) {
            Film.this.filmName = filmName;
            return this;
        }

        public FilmBuilder setFilmDate(Date filmDate) {
            Film.this.filmDate = filmDate;
            return this;
        }

        public FilmBuilder setFilmUploader(String uploader) {
            Film.this.uploader = uploader;
            return this;
        }

        public FilmBuilder setFilmFilePath(String filePath) {
            Film.this.filePath = filePath;
            return this;
        }

        public FilmBuilder setFilmDescription(String description) {
            Film.this.description = description;
            return this;
        }

        public Film build() {
            return Film.this;
        }
    }
}
