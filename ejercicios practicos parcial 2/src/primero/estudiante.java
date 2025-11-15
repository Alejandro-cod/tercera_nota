public class App {
    public static void main(String[] args) throws Exception {
       import java.util.HashMap;
import java.util.Map;

public class Estudiante {

    private String nombre;
    private String id;
    private Map<Materia, String> materiasInscritas; 

    public Estudiante(String nombre, String id) {
        this.nombre = nombre;
        this.id = id;
        this.materiasInscritas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getId() {
        return id;
    }

    public Map<Materia, String> getMateriasInscritas() {
        return materiasInscritas;
    }

    
    public void inscribirMateria(Materia materia, String horario) throws Exception {

        if (!materia.getHorariosDisponibles().contains(horario)) {
            throw new Exception("El horario seleccionado no está disponible para esta materia.");
        }

        for (String h : materiasInscritas.values()) {
            if (h.equals(horario)) {
                throw new Exception("Conflicto de horario: ya tienes una materia en ese horario.");
            }
        }

        materiasInscritas.put(materia, horario);
        System.out.println("Materia " + materia.getNombre() + " inscrita en horario " + horario);
    }

    public void mostrarHorarioCompleto() {
        System.out.println("\nHorario del estudiante " + nombre + ":");

        if (materiasInscritas.isEmpty()) {
            System.out.println("No tienes materias inscritas.");
            return;
        }

        for (Map.Entry<Materia, String> entry : materiasInscritas.entrySet()) {
            System.out.println(" - " + entry.getKey().getNombre() + " → " + entry.getValue());
        }
    }
}
      }    