package com.aspose.imaging.cloud.examples.manipulate;

import com.aspose.imaging.cloud.examples.Utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class ResizeImageWithFormatChange {

    public static void main(String... args) throws IOException {
        String input = "Sample1.png";
        String output = "Sample2.jpg";
        Path inputFile = Utils.getPath(ResizeImageWithFormatChange.class, input);
        Path outputFile = Utils.getPath(ResizeImageWithFormatChange.class, output);

        Integer newWidth = 200;
        Integer newHeight = 200;
        String format = "jpg";
        String outPath = "";

        com.aspose.imaging.model.ResponseMessage apiResponse
                = Utils.getImagingSdk().PostChangeImageScale(
                        format,
                        newWidth,
                        newHeight,
                        outPath,
                        inputFile.toFile()
                );

        Files.copy(apiResponse.getInputStream(), outputFile, StandardCopyOption.REPLACE_EXISTING);

    }
}
