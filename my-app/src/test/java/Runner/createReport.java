package Runner;

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;

public class createReport {

    @Test
    public void testCopyFilesToNewFolder() {
        Path sourceDir = Paths.get("target"); // Source directory
        Path reportsDir = Paths.get("reports"); // Destination directory
        
        // Generate the folder name based on the current date and time
        String dateTime = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        Path targetDir = reportsDir.resolve("cucumberReports_" + dateTime); // New folder path

        try {
            // Ensure the reports directory exists
            if (!Files.exists(reportsDir)) {
                Files.createDirectories(reportsDir);
            }

            // Create the new target directory with the date and time suffix
            Files.createDirectories(targetDir);

            // Traverse the source directory and copy subfolders and files
            Files.walkFileTree(sourceDir, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    // Create corresponding subdirectory in the target directory
                    Path targetSubdir = targetDir.resolve(sourceDir.relativize(dir));
                    if (!Files.exists(targetSubdir)) {
                        Files.createDirectories(targetSubdir);
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    // Copy each file to the corresponding subdirectory in the target
                    Path targetFile = targetDir.resolve(sourceDir.relativize(file));
                    Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }
            });

            System.out.println("Files copied successfully to: " + targetDir.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
