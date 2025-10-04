package pe.edu.upc.demoSaludPlusNuevo.repositories;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.*;
import pe.edu.upc.demoSaludPlusNuevo.entities.EducacionSalud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.time.LocalDate;

@Repository
public interface EducacionSaludRepository extends JpaRepository<EducacionSalud, Integer> {

    Page<EducacionSalud> findByTipo(Integer tipo, Pageable pageable);

    Page<EducacionSalud> findByFechaPublicacionBetween(LocalDate desde, LocalDate hasta, Pageable pageable);

    Page<EducacionSalud> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
}