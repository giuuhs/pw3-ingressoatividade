package br.com.etechoracio.ingresso.repository;

import br.com.etechoracio.ingresso.entity.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    List<Sessao> findByFilmeId(Long filmeid);
}