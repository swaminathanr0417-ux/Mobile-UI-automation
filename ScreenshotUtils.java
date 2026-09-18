package utils;

import base.DriverFactory;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtils {
    public static String capture(String name) {
        try {
            File dir = new File("reports/screenshots");
            dir.mkdirs();
            String ts = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            File source = DriverFactory.getDriver().getScreenshotAs(org.openqa.selenium.OutputType.FILE);
            File target = new File(dir, name + "_" + ts + ".png");
            Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return target.getPath();
        } catch (Exception e) {
            return "Screenshot failed: " + e.getMessage();
        }
    }
}
