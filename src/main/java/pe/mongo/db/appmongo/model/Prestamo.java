package pe.mongo.db.appmongo.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document(collection = "prestamos")
public class Prestamo {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private String dni;
    private double monto;
    private Date fecha;
    private String estado;
}
