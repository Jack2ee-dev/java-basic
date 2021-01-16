package java_basic.ch11_CollectionFrameworks;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx1 {
    
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        ListIterator<Integer> lit = list.listIterator();
        
        while (lit.hasNext()) {
            System.out.println(lit.next());
        }
        
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }
        
    }
}
