import java.time.LocalDateTime;

public abstract class Evento {
    private LocalDateTime timestamp;
    private String deviceId;

    public Evento(LocalDateTime timestamp, String deviceId) {
        this.timestamp = timestamp;
        this.deviceId = deviceId;
    }

    public getTimestamp(){
        return timestamp;
    }

    public abstract String descripcion();

    public abstract Boolean esCritico();
}
