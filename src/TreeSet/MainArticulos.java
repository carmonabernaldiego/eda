package TreeSet;

        import java.util.Iterator;
        import java.util.Random;
        import java.util.TreeSet;

public class MainArticulos {
    public static void main(String[] args) {
        int min = 1000;
        int max = 9999;

        Random random = new Random();

        int value = random.nextInt(max + min) + min;
        System.out.println(value);

        TreeSet<Integer> arbol = new TreeSet<Integer>();

        Articulos[] articulos = new Articulos[5];

        articulos[0] = new Articulos(2083, "Coca Cola", "Refresco sabor cola", 15.00);
        articulos[1] = new Articulos(3145, "Mamut", "Galleta con malvavisco", 7.00);
        articulos[2] = new Articulos(9737, "Takis", "Sabrita con picante", 12.00);
        articulos[3] = new Articulos(7732, "Tortillinas Tia Rosa", "Tortillas de harina", 18.00);
        articulos[4] = new Articulos(1029, "Sopa Nissin", "Sopa instantanea", 9.80);

        int j = 0;

        for (Articulos num : articulos) {
            arbol.add(articulos[j].id);
            j++;
        }

        Iterator<Integer> i= arbol.iterator();

        while(i.hasNext()) {
            int comparar = i.next();

            for (Articulos key : articulos) {
                if (key.id == comparar) {
                    System.out.println(key.toString());

                }
            }
        }

        if(arbol.contains(2083)) {
            System.out.println("\nUsuario existente.");
        }

        if(arbol.remove(1029)) {
            System.out.println("\nUsuario eliminado.");
        }

        Iterator<Integer> x= arbol.iterator();

        while(x.hasNext()) {
            int comparar = x.next();

            for (Articulos key : articulos) {
                if (key.id == comparar) {
                    System.out.println(key.toString());

                }
            }
        }
    }
}