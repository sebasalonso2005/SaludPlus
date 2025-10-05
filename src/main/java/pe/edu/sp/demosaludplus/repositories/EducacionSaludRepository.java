package pe.edu.sp.demosaludplus.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.sp.demosaludplus.Entities.EducacionSalud;

import java.time.LocalDate;

@Repository
public interface EducacionSaludRepository extends JpaRepository<EducacionSalud, Integer> {

    Page<EducacionSalud> findByTipo(Integer tipo, Pageable pageable);

    Page<EducacionSalud> findByFechaPublicacionBetween(LocalDate desde, LocalDate hasta, Pageable pageable);

    Page<EducacionSalud> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);
}