package task4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FixSubtitles {

    public void fixEncoding(Path path) throws IOException {

        File file = path.toFile();
        byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));

        File newFile = new File("encoded.srt");
        if ( !newFile.exists()) {
            newFile.createNewFile();
        }

        OutputStreamWriter opsw = new OutputStreamWriter(new FileOutputStream(newFile), "UTF-8");
        try (BufferedWriter bw = new BufferedWriter(opsw)) {
            bw.write(new String(encoded, "Windows-1251"));
            bw.close();
        }
        
       

    }
}
