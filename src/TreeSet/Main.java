package TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<String> arbol = new TreeSet<String>();

        arbol.add("Elena");
        arbol.add("Pedro");
        arbol.add("Juan");
        arbol.add("Pablo");
        arbol.add("Ana");

        Iterator<String> i= arbol.iterator();
        while(i.hasNext()) {
            System.out.println(i.next());
        }
    }
}