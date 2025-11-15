public class App {
    public static void main(String[] args) throws Exception {
        import java.util.ArrayList;
import java.util.List;

public class GestionBiblioteca {

    private List<Libro> libros;
    private List<Usuario> usuarios;
    private List<String> historialPrestamos;

    public GestionBiblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
        historialPrestamos = new ArrayList<>();
    }

    public void registrarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro registrado: " + libro.getTitulo());
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario registrado: " + usuario.getNombre());
    }

    public Libro buscarLibro(String isbn) {
        return libros.stream()
                .filter(l -> l.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    public Usuario buscarUsuario(String id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void prestarLibro(String idUsuario, String isbn) {
        Usuario usuario = buscarUsuario(idUsuario);
        Libro libro = buscarLibro(isbn);

        if (usuario == null || libro == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }

        try {
            usuario.prestarLibro(libro);
            historialPrestamos.add(usuario.getNombre() + " prestó: " + libro.getTitulo());
        } catch (Exception e) {
            System.out.println("No se pudo prestar el libro: " + e.getMessage());
        }
    }

    public void devolverLibro(String idUsuario, String isbn) {
        Usuario usuario = buscarUsuario(idUsuario);
        Libro libro = buscarLibro(isbn);

        if (usuario == null || libro == null) {
            System.out.println("Usuario o libro no encontrado.");
            return;
        }

        usuario.devolverLibro(libro);
        historialPrestamos.add(usuario.getNombre() + " devolvió: " + libro.getTitulo());
    }

    public void mostrarHistorial() {
        System.out.println("\nHistorial de préstamos:");
        for (String evento : historialPrestamos) {
            System.out.println(" - " + evento);
        }
    }

    public void mostrarDisponibles() {
        System.out.println("\nLibros disponibles:");
        for (Libro l : libros) {
            if (!l.isPrestado()) {
                System.out.println(" - " + l);
            }
        }
    }
}

    }
}
