package com.example.controller;

import com.example.dao.CategoriaDao;
import com.example.model.Categoria;

import java.util.List;


public class CategoriasController {

    public CategoriaDao dao;

    public CategoriasController() {
        this.dao = new CategoriaDao();
    }

    public List<Categoria> getCategorias() {
        return this.dao.getCategorias();
    }
}
