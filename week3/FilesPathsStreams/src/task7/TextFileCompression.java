package task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.AbstractMap;
import java.util.Map.Entry;

public class TextFileCompression {

    private static MapManager manager = new MapManager();
    static {
        if (manager.hasContent()) {
            try {
                manager.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void compress(Path filePath) throws IOException {

        File original = filePath.toFile();
        BufferedReader br = new BufferedReader(new FileReader(original));

        File compressedFile = new File(original + "compr");
        if (!compressedFile.exists()) {
            compressedFile.createNewFile();
        }

        StringBuilder compressed = new StringBuilder();

        String line = new String();
        while ((line = br.readLine()) != null) {
            String[] splitedText = line.split(" ");
            int index = 0;
            for (String word : splitedText) {
                if (!manager.containsKey(word)) {
                    String id = "~" + index;
                    Entry<String, Integer> entry = new AbstractMap.SimpleEntry<>(id, 1);
                    manager.put(word, entry);
                    compressed.append(id + " ");
                    index++;
                } else {
                    Entry<String, Integer> existing = manager.get(word);
                    existing.setValue(existing.getValue() + 1);
                    compressed.append(existing.getKey() + " ");
                }
            }
        }
        br.close();
        original.delete();

        FileWriter fWriter = new FileWriter(compressedFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fWriter);

        bw.write(compressed.toString());
        bw.close();

        manager.score();

        System.out.println("The file is compressed!");

    }

    public static void decompress(Path filePath) throws IOException {

        File compressedFile = filePath.toFile();
        String originalFileName = compressedFile.getName().replace("compr", "");

        File original = new File(originalFileName);
        if (!original.exists()) {
            original.createNewFile();
        }

        BufferedReader br = new BufferedReader(new FileReader(compressedFile));

        StringBuilder contest = new StringBuilder();

        String line = new String();
        while ((line = br.readLine()) != null) {

            String[] keys = line.split(" ");
            for (String key : keys) {
                String word = manager.getKeyFromValue(key);
                contest.append(word + " ");
                Entry<String, Integer> existing = manager.get(word);
                if (existing.getValue() > 1) {
                    existing.setValue(existing.getValue() - 1);
                }

                else {
                    manager.delete(word);
                }

            }
        }

        br.close();
        compressedFile.delete();

        FileWriter fWriter = new FileWriter(original.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fWriter);
        bw.write(contest.toString());
        bw.close();

        System.out.println("The file is decompressed!");

    }

}
