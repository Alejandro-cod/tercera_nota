import java.util.*;

class Comida {
    private String nombre;
    private String tipo;
    private int disponibilidad;

    public Comida(String nombre, String tipo, int disponibilidad) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.disponibilidad = disponibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public String getTipo() {
        return tipo;
    }

    
    public boolean servir() {
        if (disponibilidad > 0) {
            disponibilidad--;
            System.out.println("✔ Se sirvió una porción de: " + nombre);
            return true;
        } else {
            System.out.println("❌ No queda disponibilidad de: " + nombre);
            return false;
        }
    }


    public void reponer(int cantidad) {
        if (cantidad > 0) {
            disponibilidad += cantidad;
            System.out.println("✔ Se repusieron " + cantidad + " unidades de " + nombre);
        }
    }

    public String toString() {
        return nombre + " (" + tipo + ") - Disponibilidad: " + disponibilidad;
    }
}
class Estudiante {
    private String nombre;
    private String id;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }
    public void seleccionarComida(Comida comida) {
        System.out.println(nombre + " intenta seleccionar " + comida.getNombre() + "...");
        comida.servir();
    }
}


class GestionComedor {
    private List<Comida> comidas = new ArrayList<>();
    private int totalComidasServidas = 0;


    public void registrarComida(Comida comida) {
        comidas.add(comida);
        System.out.println("✔ Comida registrada: " + comida.getNombre());
    }

    
    public void mostrarDisponibilidad() {
        System.out.println("\n📌 Disponibilidad de comidas:");
        for (Comida c : comidas) {
            System.out.println(" - " + c);
        }
        System.out.println();
    }

    
    public void registrarConsumo(Comida comida) {
        if (comida.getDisponibilidad() >= 0) {
            totalComidasServidas++;
        }
    }

    public int getTotalComidasServidas() {
        return totalComidasServidas;
    }

    
    public Comida buscarComida(String nombre) {
        for (Comida c : comidas) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        System.out.println("❌ Comida no encontrada.");
        return null;
    }
}
public class Main {
    public static void main(String[] args) {

        GestionComedor gestion = new GestionComedor();

        
        Comida c1 = new Comida("Arroz con pollo", "Estándar", 5);
        Comida c2 = new Comida("Ensalada verde", "Vegana", 3);
        Comida c3 = new Comida("Pasta sin carne", "Vegetariana", 4);

        gestion.registrarComida(c1);
        gestion.registrarComida(c2);
        gestion.registrarComida(c3);

        gestion.mostrarDisponibilidad();

        
        Estudiante e1 = new Estudiante("Carlos Gómez", "101");
        Estudiante e2 = new Estudiante("María Torres", "102");

    
        e1.seleccionarComida(c1);
        e2.seleccionarComida(c1);
        e1.seleccionarComida(c2);
        e2.seleccionarComida(c3);

        gestion.mostrarDisponibilidad();

        
        c2.reponer(2);

        gestion.mostrarDisponibilidad();

        System.out.println("🍽 Total comidas servidas: " + gestion.getTotalComidasServidas());
    }
}
