public class App {
    public static void main(String[] args) throws Exception {
        import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private String id;
    private List<Libro> librosPrestados;
    private final int LIMITE_LIBROS = 3; 

    public Usuario(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.librosPrestados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }

    public void prestarLibro(Libro libro) throws Exception {

        if (librosPrestados.size() >= LIMITE_LIBROS) {
            throw new Exception("No se pueden prestar más libros. Límite alcanzado.");
        }

        if (libro.isPrestado()) {
            throw new Exception("Este libro no está disponible.");
        }

        libro.prestar();
        librosPrestados.add(libro);
        System.out.println(nombre + " ha tomado prestado: " + libro.getTitulo());
    }

    public void devolverLibro(Libro libro) {

        if (librosPrestados.contains(libro)) {
            libro.devolver();
            librosPrestados.remove(libro);
            System.out.println(nombre + " ha devuelto: " + libro.getTitulo());
        } else {
            System.out.println("Este usuario no tiene prestado ese libro.");
        }
    }
}

    }
}
