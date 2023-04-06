package com.muniz.socialbooks.resources;

import com.muniz.socialbooks.domain.Autor;
import com.muniz.socialbooks.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autor")
public class AutorResources {

    @Autowired
    private AutorService autorService;

    @RequestMapping(method = RequestMethod.GET)
    private ResponseEntity<List<Autor>> finAll() {
        return ResponseEntity.status(HttpStatus.OK).body(autorService.findAll());
    }

}
