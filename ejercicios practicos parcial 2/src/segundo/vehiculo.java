public class App {
    public static void main(String[] args) throws Exception {
        public class Vehiculo {

    private String placa;
    private String tipo;       // "carro" o "moto"
    private String propietario;

    public Vehiculo(String placa, String tipo, String propietario) {
        this.placa = placa;
        this.tipo = tipo.toLowerCase();
        this.propietario = propietario;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPropietario() {
        return propietario;
    }
}

    }
}
