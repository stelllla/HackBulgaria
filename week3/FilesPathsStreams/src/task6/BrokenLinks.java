package task6;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BrokenLinks {

    public void printBadLinks(Path path) throws IOException {

        File searchFile = path.toFile();

        if (!Files.isSymbolicLink(path)) {
            System.out.println(Files.readSymbolicLink(path));
        }

        if (searchFile.isDirectory()) {
            File[] listOfFiles = searchFile.listFiles();
            for (File f : listOfFiles) {
                printBadLinks(f.toPath());
            }
        }

    }
}
