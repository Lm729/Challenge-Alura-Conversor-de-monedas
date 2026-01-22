package Datos;

import java.util.Map;

public record DatosMoneda(String base_code, String target_code, double conversion_rate, double conversion_result) {
}
