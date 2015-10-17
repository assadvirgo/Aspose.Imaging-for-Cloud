package com.aspose.imaging.cloud.examples;

import com.aspose.imaging.api.ImagingApi;
import com.aspose.storage.api.StorageApi;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.logging.Logger;

public class Utils {

    public static final String API_SID = null;
    public static final String API_KEY = null;

    static {
        if (API_SID == null || API_KEY == null) {
            throw new RuntimeException("Both API_SID and API_KEY must not be null");
        }
    }
    public static final String STORAGE = null;
    public static final String BASE_PATH = null;
    public static final String FOLDER = null;

    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    public static Path getPath(Class example, String filename) {
        Path p = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "src", "main", "resources");
        p = FileSystems.getDefault().getPath(p.toString(), example.getName().split("\\."));
        if (filename != null) {
            p = FileSystems.getDefault().getPath(p.toString(), filename);
            LOGGER.info(String.format("Using file %s", p));
        } else {
            LOGGER.info(String.format("Using directory %s", p));
        }

        return p;
    }

    public static ImagingApi getImagingSdk() {
        ImagingApi c = new ImagingApi(API_KEY, API_SID);
        if (BASE_PATH != null) {
            c.setBasePath(BASE_PATH);
        }
        return c;
    }

    public static StorageApi getStorageSdk() {
        StorageApi c = new StorageApi(API_KEY, API_SID);
        if (BASE_PATH != null) {
            c.setBasePath(BASE_PATH);
        }
        return c;
    }
}
