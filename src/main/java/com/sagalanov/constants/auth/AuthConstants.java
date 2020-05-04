package com.sagalanov.constants.auth;

public class AuthConstants {

    // URL
    public static final String PATH_REGISTRATION = "/registration";
    public static final String PATH_LOGIN = "/login";
    public static final String VIEW_REGISTRATION = "registration";
    public static final String VIEW_LOGIN = "login";
    public static final String VIEW_INDEX = "mainPage";
    public static final String REDIRECT = "redirect:/";
    public static final String ROOT = "/";

    // left side pages
    public static final String PAGES_KEY = "pages";
    public static final String LIST = "list";
    public static final String LIST_VALUE = "/film/list";
    public static final String UPLOAD = "upload";
    public static final String UPLOAD_VALUE = "/film/upload";

    // user form
    public static final String USER_FORM = "userForm";

    // roles
    public static final String ROLE_PREFIX = "ROLE_";
    public static final String DEFAULT_ROLE = "USER";

    // validation
    public static final String ERROR = "error";
    public static final String ERROR_VALUE = "Incorrect login or password";

    public static final String MESSAGE = "message";
    public static final String MESSAGE_VALUE = "Logout successful";

    // user vars
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String PASSWORD_CONFIRM = "passwordConfirm";

    public static final String USERNAME_EMPTY = "user.name.empty";
    public static final String USERNAME_ALREADY_EXIST = "user.name.exist";
    public static final String PASSWORD_EMPTY = "user.password.empty";
    public static final String PASSWORD_COMFIRM = "user.password.confirm";
    public static final String PASSWORD_COMFIRM_EMPTY = "user.password.confirm.empty";
}
