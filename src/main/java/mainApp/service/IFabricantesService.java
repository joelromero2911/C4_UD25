package mainApp.service;

import java.util.List;

import mainApp.dto.Fabricantes;

public interface IFabricantesService {
	//Metodos del CRUD
	public List<Fabricantes> listarFabricantes(); //Listar All 
	
	public Fabricantes guardarFabricante(Fabricantes fabricante);	//Guarda un fabricante CREATE
	
	public Fabricantes fabricanteXID(Long id); //Leer datos de un fabricante READ
	
	public List<Fabricantes> listarFabricantesNombre(String fabricante);//Listar Fabricantes por campo nombre
	
	public Fabricantes actualizarFabricante(Fabricantes fabricante); //Actualiza datos del fabricante UPDATE
	
	public void eliminarFabricante(Long id);// Elimina el fabricante DELETE
}
