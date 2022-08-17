package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Articulos;
import mainApp.service.ArticulosServiceImpl;
@RestController
@RequestMapping("/api")
public class ArticulosController {
	@Autowired
	ArticulosServiceImpl articulosServiceImpl;
	
	@GetMapping("/articulos")
	public List<Articulos> listarFabricantes(){
		return articulosServiceImpl.listarArticulos();
	}
	
	//listar Articulos por campo nombre
	@GetMapping("/articulos/nombre/{nombre}")
	public List<Articulos> listarArticulosNombre(@PathVariable(name="nombre") String nombre) {
	    return articulosServiceImpl.listarArticuloNombre(nombre);
	}
	
	
	@PostMapping("/articulos")
	public Articulos guardarArticulo(@RequestBody Articulos articulo) {
		return articulosServiceImpl.guardarArticulo(articulo);
	}
	
	
	@GetMapping("/articulos/{codigo}")
	public Articulos articuloXID(@PathVariable(name="codigo") Long codigo) {
		
		Articulos articulo_xid= new Articulos();
		
		articulo_xid=articulosServiceImpl.articuloXID(codigo);
		
		System.out.println("Articulo XID: "+articulo_xid);
		
		return articulo_xid;
	}
	
	@PutMapping("/articulos/{codigo}")
	public Articulos actualizarArticulo(@PathVariable(name="codigo")Long codigo,@RequestBody Articulos articulo) {
		
		Articulos articulo_seleccionado= new Articulos();
		Articulos articulo_actualizado= new Articulos();
		
		articulo_seleccionado= articulosServiceImpl.articuloXID(codigo);
		
		articulo_seleccionado.setNombre(articulo.getNombre());
		articulo_seleccionado.setPrecio(articulo.getPrecio());
		articulo_seleccionado.setFabricante(articulo.getFabricante());
		
		articulo_actualizado = articulosServiceImpl.actualizarArticulos(articulo_seleccionado);
		
		System.out.println("El articulo actualizado es: "+ articulo_actualizado);
		
		return articulo_actualizado;
	}
	
	@DeleteMapping("/articulos/{codigo}")
	public void eliminarArticulos(@PathVariable(name="codigo")Long codigo) {
		articulosServiceImpl.eliminarArticulos(codigo);
	}
}
