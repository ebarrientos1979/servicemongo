package pe.mongo.db.appmongo.dto;
import lombok.*;

import java.util.Date;

 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
 @Getter
 @Setter
 @ToString
public class PrestamoDto {
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private double monto;
    private Date fecha;
    private String estado;
}
