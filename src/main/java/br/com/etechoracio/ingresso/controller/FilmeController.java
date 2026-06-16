package br.com.etechoracio.ingresso.controller;

import br.com.etechoracio.ingresso.dto.FilmeResponseDTO;
import br.com.etechoracio.ingresso.entity.Filme;
import br.com.etechoracio.ingresso.entity.Sessao;
import br.com.etechoracio.ingresso.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
@CrossOrigin("*")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public List<FilmeResponseDTO> findAll(){
        return filmeService.findAll();
    }

    @GetMapping("/em-cartaz")
    public List<FilmeResponseDTO> findEmCartaz(){
        return filmeService.findEmCartaz();
    }

    @GetMapping("/{id}/com-sessoes")
    public ResponseEntity<FilmeComSessaoDTO> getFilmeComSessoes() {
        return getFilmeComSessoes(null);
    }

    @GetMapping("/{id}/com-sessoes")
    public ResponseEntity<FilmeComSessaoDTO> getFilmeComSessoes(@PathVariable Long id) {
        Filme filme = filmeService.buscarFilmeComSessoes(id);
        List<SessaoDTO> sessoesDTO = filme.getSessoes().stream()
                .map(s -> new SessaoDTO(s.getId(), s.getPreco(), s.getHorario(), s.getSala))
                .toList();
    }

    @PostMapping("/{id}/sessoes")
    public ResponseEntity<Sessao> criarSessao(@PathVariable Long id, @RequestBody Sessao sessao) {
        Filme filme = filmeService.buscarFilme(id);
        sessao.setFilme(filme);
        return ResponseEntity.ok(sessaoRepository.save(sessao));
    }
}
