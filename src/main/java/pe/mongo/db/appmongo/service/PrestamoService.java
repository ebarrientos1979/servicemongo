package pe.mongo.db.appmongo.service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pe.mongo.db.appmongo.dto.PrestamoDto;
import pe.mongo.db.appmongo.model.Prestamo;
import pe.mongo.db.appmongo.repository.PrestamoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {
    PrestamoRepository prestamoRepository;

    public PrestamoService(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    public List<PrestamoDto> obtenerPrestamos() {
        List<PrestamoDto> listRespuesta = new ArrayList<PrestamoDto>();
        List<Prestamo> prestamos = prestamoRepository.findAll();

        prestamos.forEach(prestamo -> {
            listRespuesta.add(PrestamoDto.builder()
                    .id(prestamo.getId())
                    .nombre(prestamo.getNombre())
                    .apellido(prestamo.getApellido())
                    .dni(prestamo.getDni())
                    .monto(prestamo.getMonto())
                    .fecha(prestamo.getFecha())
                    .estado(prestamo.getEstado())
                    .build());
        });
        return listRespuesta;
    }

    public void guardarPrestamo(PrestamoDto prestamoDto) {

        Prestamo prestamo = Prestamo.builder()
                .id(prestamoDto.getId())
                .nombre(prestamoDto.getNombre())
                .apellido(prestamoDto.getApellido())
                .dni(prestamoDto.getDni())
                .monto(prestamoDto.getMonto())
                .fecha(prestamoDto.getFecha())
                .estado(prestamoDto.getEstado())
                .build();
        prestamoRepository.save(prestamo);
    }
}
