package task1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {

    private static FileUtils instance = null;
    private FileUtils() {

    }

    public static FileUtils getInstance() {
        if ( instance == null) {
            instance = new FileUtils();
        }

        return instance;
    }

    public String readFrom(File file) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(file));

        StringBuilder str = new StringBuilder();

        String line = null;

        while ((line = br.readLine()) != null) {
             String bytes = new String (line.getBytes("UTF-8"));
             str.append(bytes);
//            str.append(line + "/n");
        }

        br.close();
        return str.toString();
    }

    public String readFrom(Path path) throws IOException {

        File file = path.toFile();
        return readFrom(file);

    }

    public void writeFile(String text) throws IOException {
        File file = new File("result.txt");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fWriter = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fWriter);
        bw.write(text);
        bw.close();
    }

}


