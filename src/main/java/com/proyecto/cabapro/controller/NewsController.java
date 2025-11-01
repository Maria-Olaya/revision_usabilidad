package com.proyecto.cabapro.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.cabapro.model.NewsArticle;
import com.proyecto.cabapro.service.NoticiasApiProvider;
import com.proyecto.cabapro.service.NoticiasMockProvider;
import com.proyecto.cabapro.service.NoticiasProvider;

@RestController
@RequestMapping("/news")
public class NewsController {

    private final NoticiasProvider noticiasApi;
    private final NoticiasProvider noticiasMock;

    // Nota: Inyectamos las implementaciones concretas, pero el controlador depende solo de la interfaz
    public NewsController(NoticiasApiProvider noticiasApi, NoticiasMockProvider noticiasMock) {
        this.noticiasApi = noticiasApi;
        this.noticiasMock = noticiasMock;
    }

    @GetMapping("/nba-api")
    public List<NewsArticle> noticiasDesdeApi() {
        return noticiasApi.obtenerNoticias();
    }

    @GetMapping("/nba-mock")
    public List<NewsArticle> noticiasDesdeMock() {
        return noticiasMock.obtenerNoticias();
    }
}
