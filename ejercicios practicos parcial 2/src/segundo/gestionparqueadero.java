public class App {
    public static void main(String[] args) throws Exception {
        import java.util.ArrayList;
import java.util.List;

public class GestionParqueadero {

    private List<Vehiculo> vehiculosRegistrados;
    private List<EspacioParqueadero> espacios;

    public GestionParqueadero() {
        vehiculosRegistrados = new ArrayList<>();
        espacios = new ArrayList<>();
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculosRegistrados.add(vehiculo);
        System.out.println("Vehículo registrado: " + vehiculo.getPlaca());
    }

    public void registrarEspacio(EspacioParqueadero espacio) {
        espacios.add(espacio);
        System.out.println("Espacio " + espacio.getNumero() + " registrado.");
    }

    public void mostrarEspaciosDisponibles() {
        System.out.println("\nEspacios disponibles:");

        for (EspacioParqueadero e : espacios) {
            if (!e.isOcupado()) {
                System.out.println(" - Espacio " + e.getNumero() +
                                   " (para " + e.getTipoPermitido() + ")");
            }
        }
    }

    public void asignarEspacio(String placa) {

        Vehiculo vehiculo = vehiculosRegistrados.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);

        if (vehiculo == null) {
            System.out.println("Vehículo no encontrado.");
            return;
        }

        for (EspacioParqueadero e : espacios) {
            if (!e.isOcupado() && e.getTipoPermitido().equals(vehiculo.getTipo())) {
                try {
                    e.asignarVehiculo(vehiculo);
                    return;
                } catch (Exception ex) {
                    System.out.println("No se pudo asignar: " + ex.getMessage());
                }
            }
        }

        System.out.println("No hay espacios disponibles para este tipo de vehículo.");
    }
}

    }
}
