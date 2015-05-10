package task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertiesFileParse {

    private static PropertiesFileParse instance = null;

    private PropertiesFileParse() {

    }

    public static PropertiesFileParse getInstance() {
        if (instance == null) {
            instance = new PropertiesFileParse();
        }
        return instance;
    }

    public void stringToList(String line, List<Character> list) {

        for (int i = 0; i < line.length(); i++) {
            list.add(line.charAt(i));
        }
    }

    public static void trimList(List<Character> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == ' ') {
                list.remove(i);
            }
        }
    }

    public String getKey(List<Character> list) {

        trimList(list);

        StringBuilder key = new StringBuilder();
        int i = 0;
        if (list.get(0) != '#') {
            while (list.get(i) != '=') {
                key.append(list.get(i));
                i++;
            }
            return key.toString();
        }
        return null;
    }

    public String getValue(List<Character> list) {

        trimList(list);
        int valueStartIndex = list.indexOf('=');
        StringBuilder value = new StringBuilder();
        for (int i = valueStartIndex + 1; i < list.size(); i++) {
            value.append(list.get(i));
        }
        return value.toString();
    }

    public Map<String, String> parseProperties(File file) throws IOException {

        Map<String, String> resultMap = new HashMap<String, String>();
        List<Character> line = new ArrayList<Character>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String stringLine = new String();
        while ((stringLine = br.readLine()) != null) {
            stringToList(stringLine, line);

            if (getKey(line) != null) {
                resultMap.put(getKey(line), getValue(line));
            }

            line.clear();
        }

        br.close();
        return resultMap;
    }

}
