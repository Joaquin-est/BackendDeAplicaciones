package frc.utn.isi.backend.objetos;

public class EventoMedicion extends Evento {
    private double valor;
    private String unidad;

    public EventoMedicion(LocalDateTime timestamp, String deviceId, double valor, String unidad) {
        super(timestamp, deviceId);
        this.valor = valor;
        this.unidad = unidad;
    }

    public String descripcion() {
        return valor + unidad;
    }

    public Boolean esCritico() {
        return false;
    }
}
// se debe determinar el tiempo de duracion mediante timeStamp