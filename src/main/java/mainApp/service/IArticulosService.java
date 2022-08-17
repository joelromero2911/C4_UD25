package mainApp.service;

import java.util.List;

import mainApp.dto.Articulos;

public interface IArticulosService {
	//Metodos del CRUD
	public List<Articulos> listarArticulos(); //Listar All 
	
	public Articulos guardarArticulo(Articulos articulo);	//Guarda un articulo CREATE
	
	public Articulos articuloXID(Long codigo); //Leer datos de un articulo READ
	
	public List<Articulos> listarArticuloNombre(String articulo);//Listar Articulo por campo nombre
	
	public Articulos actualizarArticulos(Articulos articulo); //Actualiza datos del articulo UPDATE
	
	public void eliminarArticulos(Long codigo);// Elimina el articulo DELETE
}
