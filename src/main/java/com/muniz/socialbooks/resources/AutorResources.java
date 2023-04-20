package com.muniz.socialbooks.resources;

import com.muniz.socialbooks.domain.Autor;
import com.muniz.socialbooks.services.AutorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorResources {

    @Autowired
    private AutorService autorService;

    @RequestMapping(method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    private ResponseEntity<List<Autor>> finAll() {
        return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    private ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor) {
        autor = autorService.salvar(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    private ResponseEntity<Autor> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(autorService.findById(id));

    }
}
