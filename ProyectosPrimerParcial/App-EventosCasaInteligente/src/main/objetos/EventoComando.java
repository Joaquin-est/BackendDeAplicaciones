package frc.utn.isi.backend.objetos;

public class EventoComando extends Evento {
    private String accion;

    public EventoComando(LocalDateTime timestamp, String deviceId, String accion) {
        super(timestamp, deviceId);
        this.accion = accion;
    }

    public String descripcion() {
        return "comando " + accion;
    }

    public Boolean esCritico() {
        return false;
    }
}
