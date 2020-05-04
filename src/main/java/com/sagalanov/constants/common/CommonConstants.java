package com.sagalanov.constants.common;

import java.util.Arrays;

public class CommonConstants {

    // cache
    private static final String NO_CACHE = "no-cache";
    private static final String NO_STORE = "no-store";
    private static final String MUST_REVALIDATE = "must-revalidate";
    public static final String RESULT_CACHE_HEADERS
            = String.join(",", Arrays.asList(NO_CACHE, NO_STORE, MUST_REVALIDATE));
}
