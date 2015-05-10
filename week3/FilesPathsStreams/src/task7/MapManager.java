package task7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapManager {

    private Map<String, Entry<String, Integer>> map = new HashMap<String, Entry<String, Integer>>();

    public MapManager() {
    }

    public void put(String key, Entry<String, Integer> value) {
        map.put(key, value);
    }

    public Entry<String, Integer> get(Object key) {
        return map.get(key);
    }

    public void delete(Object key) {
        map.remove(key);
    }

    public String getKeyFromValue(String id) {

        for (Entry<String, Entry<String, Integer>> entry : map.entrySet()) {
            if (id.equals(entry.getValue().getKey())) {
                return entry.getKey();
            }
        }
        return null;
    }

    // file->map
    public void load() throws IOException {
        File archiveFile = new File("archiveFile");

        BufferedReader br = new BufferedReader(new FileReader(archiveFile));
        String line = new String();
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(" ");
            Integer valueEntry = Integer.parseInt(arr[2]);
            Entry<String, Integer> entry = new AbstractMap.SimpleEntry<String, Integer>(arr[1], valueEntry);
            map.put(arr[0], entry);

        }

        br.close();
    }

    // map -> file
    public void score() throws IOException {

        File archiveFile = new File("archiveFile");
        if (!archiveFile.exists()) {
            archiveFile.createNewFile();
        }

        FileWriter fWriter = new FileWriter(archiveFile.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fWriter);

        StringBuilder str = new StringBuilder();

        Iterator<Entry<String, Entry<String, Integer>>> iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry<String, Entry<String, Integer>> curr = iter.next();
            str.append(curr.getKey() + " ");
            str.append(curr.getValue().getKey() + " " + curr.getValue().getValue() + "\n");
            
        }
        bw.write(str.toString());
        bw.close();
    }

    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    public boolean hasContent() {
        File file = new File("archiveFile");
        if (!file.exists() || file.length() < 1) {
            return false;
        } else {
            return true;
        }
    }

}
