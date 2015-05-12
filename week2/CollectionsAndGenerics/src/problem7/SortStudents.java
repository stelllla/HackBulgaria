package problem7;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class SortStudents {
    private List<Student> list = new ArrayList<Student>();

    public SortStudents(List<Student> list) {
        this.list = list;
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public void sort () {
        
        TreeSet<Student> treeSet = new TreeSet<Student> ();
        treeSet.addAll(list);
        list.clear();
        list.addAll(treeSet);
        
        System.out.println(list);
        
    }
    
//    public void sortStudents() {
//        System.out.println(list);
//        TreeMap<Integer, TreeSet<String>> mapStudents = new TreeMap<>();
//
//        for (Student s : list) {
//            TreeSet<String> names = new TreeSet<>();
//            if (mapStudents.containsKey(s.getGrade())) {
//                names = mapStudents.get(s.getGrade());
//                
//            }
//            names.add(s.getName());
//            mapStudents.put(s.getGrade(), names);
//        }
//
//        
//        System.out.println(mapStudents);
//    }
}
