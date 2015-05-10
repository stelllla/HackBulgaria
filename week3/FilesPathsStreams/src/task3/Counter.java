package task3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Counter {

    public class WordCountResult {

        private int wordCounter = 0;
        private int lineCounter = 0;
        private int charCounter = 0;

        public WordCountResult(int ch, int w, int l) {
            charCounter = ch;
            wordCounter = w;
            lineCounter = l;
        }
        
        public void print () {
            System.out.println("chars:" + charCounter + " " + 
                               "words:" + wordCounter + " " + 
                               "lines:" + lineCounter);
        }
    }

   private WordCountResult counters;

    public WordCountResult wordCount(File file) throws IOException {

        int lines = 0, words = 0, chars = 0;
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line = null;
        while ((line = br.readLine()) != null) {
            lines++;

            String[] arr = line.split(" ");
            words += arr.length;

            int c = 0;
            for (int i = 0; i < arr.length; i++) {
                c += arr[0].length();
            }
            chars += c;

        }
        
        br.close();

        WordCountResult result = new WordCountResult(chars, words, lines);

        return result;
    }
    
    public WordCountResult wordCount(Path path) throws IOException {
        File file = path.toFile();
        return wordCount(file);
    }
    
    public void printCounters () {
        counters.print();
        
    }
}
