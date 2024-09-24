package pe.mongo.db.appmongo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.mongo.db.appmongo.dto.PrestamoDto;
import pe.mongo.db.appmongo.service.PrestamoService;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/prestamo")
public class PrestamoController {
    PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @GetMapping("/getPrestamo")
    public ResponseEntity<List<PrestamoDto>> getPrestamo() {
        return ok(this.prestamoService.obtenerPrestamos());
    }

    @PostMapping("/savePrestamo")
    public void savePrestamo(PrestamoDto prestamoDto) {
        this.prestamoService.guardarPrestamo(prestamoDto);
    }

}
