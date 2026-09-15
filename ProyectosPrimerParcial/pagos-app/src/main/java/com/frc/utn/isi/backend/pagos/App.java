package com.frc.utn.isi.backend.pagos;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import com.frc.utn.isi.backend.pagos.iterables.Pagos;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        URL resourceUrl = App.class.getResource("resources/data/pagos_importar.csv");

        Pagos losPagos = new Pagos(resourceUrl);

        Map<LocalDateTime, Integer> res = losPagos.cantidadPagosPorFecha();
        for (Map.Entry<LocalDateTime, Integer> item : res.entrySet()) {
            System.out.println("Fecha de Pago" + item.getKey() + " cantidad de pagos " + item.getValue());
        }

        System.out.println(losPagos.informeRecibosMayorPromedio());

        Set<Map.Entry<String, Double>> frecuencia = losPagos.totalPorTipoDePago().entrySet();
        System.out.println("Total Acumulado por Tipos de Pagos");
        for (Map.Entry<String, Double> entry : frecuencia) {
            System.out.println("Tipo de Pago" + entry.getKey() + " total $" + entry.getValue());
        }

    }
}
