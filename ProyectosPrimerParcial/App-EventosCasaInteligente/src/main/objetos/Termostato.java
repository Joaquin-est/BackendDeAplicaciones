package frc.utn.isi.backend.objetos;

public class Termostato extends Dispositivo {
    private int temperaturaGradosCent;
    private int temperaturaEnergia;

    public Termostato(String id, String nombre, String ubicacion, List<Evento> eventos, int temperaturaGradosCent,
            int temperaturaEnergia) {
        super(id, nombre, ubicacion, eventos);
        this.temperaturaGradosCent = temperaturaGradosCent;
        this.temperaturaEnergia = temperaturaEnergia;
    }

    @Override
    public double temperaturaActual() {
        // return temperaturaGradosCent + temperaturaEnergia;
        return eventos.steam() // Eventos de Termostato (recorda que el miembro/atributo se hereda del padre)
                .filter(e -> e instanceof EventoMedicion)
                .map(e -> (EventoMedicion) e);
    };

    // Metodo rehuse permite tener como entrada el anterior y el siguiente,
    // devolviendo siempre el siguiente
    @Override
    public double temperaturaPromedio() {
        int contTemperatura;
        int sumTemperaturaGradosCent;
        int sumTemperaturaEnergia;

        for (i = 0; i < eventos.size; i++) {
            contTemperatura += 1;
            sumTemperaturaGradosCent += this.temperaturaGradosCent;
            sumTemperaturaEnergia += this.temperaturaEnergia;
        }
        return (sumTemperaturaGradosCent / contTemperatura);
    };

    public double consumoEstimadoWh() {
    };
}
