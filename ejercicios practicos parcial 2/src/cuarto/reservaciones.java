import java.util.*; 

class EspacioRecreacional {
    private String nombre;
    private String tipo;
    private int capacidad;
    private Map<String, Integer> horariosDisponibles;

    public EspacioRecreacional(String nombre, String tipo, int capacidad, List<String> horarios) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.horariosDisponibles = new HashMap<>();

        for (String h : horarios) {
            horariosDisponibles.put(h, 0);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void mostrarDisponibilidad() {
        System.out.println("Disponibilidad de: " + nombre);
        for (String h : horariosDisponibles.keySet()) {
            int ocupados = horariosDisponibles.get(h);
            int disponibles = capacidad - ocupados;
            System.out.println(" - " + h + ": " + disponibles + " cupos disponibles");
        }
        System.out.println();
    }

    public boolean reservar(String horario) {
        if (!horariosDisponibles.containsKey(horario)) {
            System.out.println("❌ Horario no existe.");
            return false;
        }

        int ocupados = horariosDisponibles.get(horario);
        if (ocupados < capacidad) {
            horariosDisponibles.put(horario, ocupados + 1);
            System.out.println("✔ Reserva exitosa en " + nombre + " a las " + horario);
            return true;
        } else {
            System.out.println("❌ No hay cupos en ese horario.");
            return false;
        }
    }

    public boolean cancelar(String horario) {
        if (!horariosDisponibles.containsKey(horario)) {
            System.out.println("❌ Horario no existe.");
            return false;
        }

        int ocupados = horariosDisponibles.get(horario);
        if (ocupados > 0) {
            horariosDisponibles.put(horario, ocupados - 1);
            System.out.println("✔ Reserva cancelada en " + nombre + " para el horario " + horario);
            return true;
        } else {
            System.out.println("❌ No hay reservas para cancelar.");
            return false;
        }
    }
}
class Estudiante {
    private String nombre;
    private String id;

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
    }

    public void reservarEspacio(EspacioRecreacional espacio, String horario) {
        System.out.println("El estudiante " + nombre + " intenta reservar...");
        espacio.reservar(horario);
    }

    public void cancelarReserva(EspacioRecreacional espacio, String horario) {
        System.out.println("El estudiante " + nombre + " intenta cancelar...");
        espacio.cancelar(horario);
    }
}


class GestionRecreacional {
    private List<EspacioRecreacional> espacios = new ArrayList<>();

    public void registrarEspacio(EspacioRecreacional espacio) {
        espacios.add(espacio);
        System.out.println("✔ Espacio registrado: " + espacio.getNombre());
    }

    public EspacioRecreacional buscarEspacio(String nombre) {
        for (EspacioRecreacional e : espacios) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        System.out.println("❌ Espacio no encontrado.");
        return null;
    }
}   
public class Main {
    public static void main(String[] args) {

        GestionRecreacional gestion = new GestionRecreacional();

        EspacioRecreacional cancha = new EspacioRecreacional(
                "Cancha Sintética",
                "Cancha",
                5,
                Arrays.asList("8am", "10am", "2pm", "4pm")
        );

        EspacioRecreacional juegos = new EspacioRecreacional(
                "Sala de Juegos",
                "Sala",
                10,
                Arrays.asList("9am", "1pm", "3pm")
        );

        gestion.registrarEspacio(cancha);
        gestion.registrarEspacio(juegos);

        Estudiante s1 = new Estudiante("Carlos Pérez", "1001");
        Estudiante s2 = new Estudiante("Ana Torres", "1002");

        cancha.mostrarDisponibilidad();

        s1.reservarEspacio(cancha, "10am");
        s2.reservarEspacio(cancha, "10am");
        s1.reservarEspacio(cancha, "10am");
        s2.cancelarReserva(cancha, "10am");

        cancha.mostrarDisponibilidad();
    }
}
