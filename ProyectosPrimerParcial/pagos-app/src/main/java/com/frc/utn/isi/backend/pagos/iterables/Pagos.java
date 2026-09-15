package com.frc.utn.isi.backend.pagos.iterables;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.frc.utn.isi.backend.pagos.entidades.Pago;
import com.frc.utn.isi.backend.pagos.mappers.PagosMapper;

public class Pagos {
    private List<Pago> items;

    public Pagos(URL folderPath) {
        PagosMapper mapper = new PagosMapper();
        items = mapper.importarPagos(folderPath);
    }

    public double netoTotalIngresado() {
        double total = 0;
        for (Pago pago : items) {
            pago.procesar();
            total += pago.netoIngresado();
        }
        return total;
    }

    public Map<LocalDateTime, Integer> cantidadPagosPorFecha() {
        Map<LocalDateTime, Integer> mapeo = new HashMap<>();
        for (Pago pago : items) {
            LocalDateTime key = pago.getFecha();
            if (mapeo.containsKey(key)) {
                Integer value = mapeo.get(key);
                value += 1;
                mapeo.put(key, value);
            } else {
                mapeo.put(key, 1);
            }
        }
        return mapeo;
    }

    public Map<String, Double> totalPorTipoDePago() {
        mapeo = Collect(collect -> (p -> getName));
        Map<String, Double> mapeo = new HashMap<>();
        for (Pago pago : items) {
            String key = pago.getClass().getName();
            mapeo.put(key, mapeo.getOrDefault(key, 0d) + pago.getMonto());
        }
        return mapeo;
    }

    public String informeRecibosMayorPromedio() {
        double promedio = this.getMontoPromedioPago();
        StringBuilder builder = new StringBuilder("Recibos Mayores al Promedio\n");
        for (Pago pago : items) {
            if (pago.getMonto() > promedio)
                builder.append(pago.generarRecibo()).append("\n");
        }
        return builder.toString();
    }

    private double getMontoPromedioPago() {
        double total = 0;
        int cantidad = this.items.size();

        if (cantidad == 0)
            throw new ArithmeticException("Error: No se puede calcular una division por cero");

        for (Pago pago : items) {
            total += pago.getMonto();
        }
        return total / cantidad;
    }
}
