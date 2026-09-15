package com.frc.utn.isi.backend.pagos.mappers;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.frc.utn.isi.backend.pagos.entidades.Pago;
import com.frc.utn.isi.backend.pagos.fabrica.PagoFactory;

public class PagosMapper {

    public List<Pago> importarPagos(URL folderPath) {
        List<Pago> pagos = new ArrayList<>();
        Path archivo;

        try {
            archivo = Path.of(folderPath.toURI());
            try (BufferedReader br = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
                String linea = null;
                boolean primera = true;
                while ((linea = br.readLine()) != null) {
                    if (primera) {
                        primera = false;
                        continue;
                    }
                    long diasAleatorios = ThreadLocalRandom.current().nextLong(0, 15);
                    Pago pago = procesarLinea(diasAleatorios, linea);
                    pagos.add(pago);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return pagos;
    }

    private Pago procesarLinea(long diasAleatorios, String linea) {
        String[] tokens = linea.split(",", -1);

        String transaccion = tokens[0];
        String monto = tokens[1];
        String tipoPago = tokens[2];
        String recibido = tokens[3];
        String cbu = tokens[4];
        String banco = tokens[5];
        String token = tokens[6];
        String marca = tokens[7];
        String cuotas = tokens[8];
        String fecha = LocalDateTime.now().minusDays(diasAleatorios).toString();

        return PagoFactory.crearPago(tipoPago, transaccion, monto, fecha, recibido, cbu, banco, token, marca, cuotas);
    }

}
