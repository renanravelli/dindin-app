package br.com.ravellitecnologia.ports.driven;

import br.com.ravellitecnologia.domain.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaborRepository extends JpaRepository<Sabor, Long> {
}
