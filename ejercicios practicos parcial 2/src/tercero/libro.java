public class App {
    public static void main(String[] args) throws Exception {
        public class Libro {

    private String titulo;
    private String autor;
    private String isbn;
    private boolean prestado;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void prestar() throws Exception {
        if (prestado) {
            throw new Exception("El libro ya está prestado.");
        }
        prestado = true;
        System.out.println("Libro prestado: " + titulo);
    }

    public void devolver() {
        prestado = false;
        System.out.println("Libro devuelto: " + titulo);
    }

    @Override
    public String toString() {
        return titulo + " - " + autor + " (ISBN: " + isbn + ")";
    }
}

    }
}
