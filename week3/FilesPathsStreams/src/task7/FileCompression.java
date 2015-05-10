package task7;

// FileCompression with a mapFile for every compressed file.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FileCompression {

    public static void writeMapInFile(Map<String, String> map, File mapFile) throws IOException {
        FileWriter fWriter = new FileWriter(mapFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fWriter);

        StringBuilder str = new StringBuilder();

        Iterator<Entry<String, String>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, String> curr = iter.next();
            str.append(curr.getKey() +" " + curr.getValue() + "\n");
        }
        bw.write(str.toString());
        bw.close();
    }

    public static void getMapFromFile(Map<String, String> map, File mapFile) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(mapFile));
        String line = new String();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(" ");
            map.putIfAbsent(arr[0], arr[1]);
        }
        br.close();
    }

    public static String getKeyFromValue(Map<String, String> map, String value) {

        for (Entry<String, String> curr : map.entrySet()) {
            if (value.equals(curr.getValue())) {
                return curr.getKey();
            }
        }
        return null;
    }

    public static void compress(Path filePath) throws IOException {

        File original = filePath.toFile();
        BufferedReader br = new BufferedReader(new FileReader(original));

        File compressedFile = new File(original + "compr");
        if (!compressedFile.exists()) {
            compressedFile.createNewFile();
        }

        File mapFile = new File(original + "mapFile");
        if (!mapFile.exists()) {
            mapFile.createNewFile();
        }

        Map<String, String> map = new HashMap<String, String>();

        StringBuilder compressed = new StringBuilder();

        String line = new String();
        while ((line = br.readLine()) != null) {
            String[] splitedText = line.split(" ");
            int index = 0;
            for (String word : splitedText) {
                if (!map.containsValue(word)) {
                    String key = "~" + index;
                    map.put(key, word);
                    compressed.append(key + " ");
                    index++;
                } else {
                    compressed.append(getKeyFromValue(map, word));
                }
            }
        }
        br.close();
        original.delete();

        FileWriter fWriter = new FileWriter(compressedFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fWriter);

        bw.write(compressed.toString());
        bw.close();

        writeMapInFile(map, mapFile);

        System.out.println("The file is compressed!");

    }

    public static void decompress(Path filePath) throws IOException {

        File compressedFile = filePath.toFile();
        String originalFileName = compressedFile.getName().replace("compr", "");

        File original = new File(originalFileName);
        if (!original.exists()) {
            original.createNewFile();
        }

        File mapFile = new File(original + "mapFile");
        Map<String, String> map = new HashMap<>();

        getMapFromFile(map, mapFile);

        BufferedReader br = new BufferedReader(new FileReader(compressedFile));

        StringBuilder contest = new StringBuilder();

        String line = new String();
        while ((line = br.readLine()) != null) {

            String[] keys = line.split(" ");
            for (String key : keys) {
                contest.append(map.get(key) + " ");
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
