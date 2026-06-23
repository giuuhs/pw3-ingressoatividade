package br.com.etechoracio.ingresso.service;

import br.com.etechoracio.ingresso.dto.FilmeResponseDTO;
import br.com.etechoracio.ingresso.entity.Filme;
import br.com.etechoracio.ingresso.enums.SimNaoEnum;
import br.com.etechoracio.ingresso.mapper.FilmeMapper;
import br.com.etechoracio.ingresso.repository.FilmeRepository;
import br.com.etechoracio.ingresso.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private SessaoRepository sessaoRepository;

    @Autowired
    private FilmeMapper filmeMapper;

    public List<FilmeResponseDTO> findAll() {
        var filmes = filmeRepository.findAll();
        return filmeMapper.toResponseDTOList(filmes);
    }

    public List<FilmeResponseDTO> findEmCartaz() {
        var filmes = filmeRepository.findByEmCartaz(SimNaoEnum.S);
        return filmeMapper.toResponseDTOList(filmes);
    }

    public Filme buscarFilmeComSessoes(Long id) {
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filme.getSessoes().size();
        return filme;
    }

    public Filme buscarFilme(Long id) {
        return filmeRepository.findById(id).orElseThrow();
    }
}
