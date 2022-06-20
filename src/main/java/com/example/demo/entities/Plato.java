/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Gerardo
 */
public final class Plato {
    
    private long id;
    private String nombre;
    private double precio;
    private String rubro;
    private String imagenPath;
    private String urlImagenPath;

    private List<PlatoIngrediente> ingredientesPlato;
    //transient
    private List<IngredienteCantidad> ingredientes;
   
    
    public Plato(){
    }

    
    
    public Plato(HttpServletRequest request){
        this.setId(Long.parseLong(request.getParameter("id")));
        this.setNombre(request.getParameter("nombre"));
        this.setImagenPath(request.getParameter("imagenPath"));
        this.setPrecio(Double.parseDouble(request.getParameter("precio")));
        this.setRubro(request.getParameter("rubro"));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getImagenPath() {
        return imagenPath;
    }

    public void setImagenPath(String imagenPath) {
        this.imagenPath = imagenPath;
    }

    public List<PlatoIngrediente> getIngredientesPlato() {
        return ingredientesPlato;
    }

    public void setIngredientesPlato(List<PlatoIngrediente> ingredientesPlato) {
        this.ingredientesPlato = ingredientesPlato;
    }

    public void addIngredientePlato(PlatoIngrediente platoIngrediente){
        if(this.ingredientesPlato == null){
            this.ingredientesPlato = new ArrayList<PlatoIngrediente>();
        }
        this.ingredientesPlato.add(platoIngrediente);
    }
    
    public List<IngredienteCantidad> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteCantidad> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    public void addIngrediente(IngredienteCantidad ingrediente){
        if(this.ingredientes == null){
            this.ingredientes = new ArrayList<IngredienteCantidad>();
        }
        this.ingredientes.add(ingrediente);
    }
    
    public String getUrlImagenPath() {
        if(imagenPath != null && imagenPath.startsWith("http")){
            urlImagenPath = imagenPath;
            return urlImagenPath;
        }
        //react
        //urlImagenPath = "http://localhost:3000/images/" + imagenPath;
        //angular
        urlImagenPath = "assets/img/" + imagenPath;
        return urlImagenPath;
    }

    public void setUrlImagenPath(String urlImagenPath) {
        this.urlImagenPath = urlImagenPath;
    }
}
