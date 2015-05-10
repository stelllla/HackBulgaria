package bonus;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatingFiles {

    private static Map<Long, List<Path>> groups = new HashMap<Long, List<Path>>();
    private static List<Path> paths = new ArrayList<Path>();
    
    public static void putKey(Path path, List<Path> listOfPaths, File file) throws IOException {
        byte[] bytes = Files.readAllBytes(path);
        long hashCode = Arrays.hashCode(bytes);
        
        if (!groups.containsKey(hashCode)) {
            listOfPaths = new ArrayList<Path>();
            listOfPaths.add(file.toPath());
            groups.put(hashCode, listOfPaths);
        }else {
            groups.get(hashCode).add(file.toPath());
            groups.put(hashCode, groups.get(hashCode));
        }
    }
    
    public static Map<Long, List<Path>> findAllDuplicates (String path) throws IOException {
        File[] files = new File(path.toString()).listFiles();

        for (File file : files) {
            if (file.isFile() && file.length()< 512000 ) {
                if (Files.isSymbolicLink(file.toPath())) {
                    Path symlink = Files.readSymbolicLink(file.toPath());
                    if (Files.exists(symlink)) {
                        putKey(symlink, paths, file);
                    } else {
                        continue;
                    }
                }
                if (!Files.isRegularFile(file.toPath())) {
                    continue;
                }
                putKey(file.toPath(), paths, file);
                
            } if (file.isDirectory()) {
                findAllDuplicates(file.getAbsolutePath());
            }
        }
        return groups;
    }
}