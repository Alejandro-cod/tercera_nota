public class App {
    public static void main(String[] args) throws Exception {
        public class EspacioParqueadero {

    private int numero;
    private String tipoPermitido; 
    private boolean ocupado;
    private Vehiculo vehiculoAsignado;

    public EspacioParqueadero(int numero, String tipoPermitido) {
        this.numero = numero;
        this.tipoPermitido = tipoPermitido.toLowerCase();
        this.ocupado = false;
        this.vehiculoAsignado = null;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipoPermitido() {
        return tipoPermitido;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public Vehiculo getVehiculoAsignado() {
        return vehiculoAsignado;
    }

    public void asignarVehiculo(Vehiculo vehiculo) throws Exception {

        if (ocupado) {
            throw new Exception("El espacio ya está ocupado.");
        }

        if (!vehiculo.getTipo().equals(tipoPermitido)) {
            throw new Exception("Tipo de vehículo no permitido en este espacio.");
        }

        this.vehiculoAsignado = vehiculo;
        this.ocupado = true;

        System.out.println("Vehículo " + vehiculo.getPlaca() + " asignado al espacio " + numero);
    }

    public void liberarEspacio() {
        this.ocupado = false;
        this.vehiculoAsignado = null;

        System.out.println("Espacio " + numero + " liberado.");
    }
}

    }
}
