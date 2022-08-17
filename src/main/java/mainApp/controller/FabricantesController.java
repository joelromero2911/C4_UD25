package mainApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mainApp.dto.Fabricantes;
import mainApp.service.FabricantesServiceImpl;

@RestController
@RequestMapping("/api")
public class FabricantesController {
	@Autowired
	FabricantesServiceImpl fabricantesServiceImpl;
	
	@GetMapping("/fabricantes")
	public List<Fabricantes> listarFabricantes(){
		return fabricantesServiceImpl.listarFabricantes();
	}
	
	//listar Fabricantes por campo nombre
	@GetMapping("/fabricantes/nombre/{nombre}")
	public List<Fabricantes> listarFabricantesNombre(@PathVariable(name="nombre") String nombre) {
	    return fabricantesServiceImpl.listarFabricantesNombre(nombre);
	}
	
	
	@PostMapping("/fabricantes")
	public Fabricantes guardarFabricante(@RequestBody Fabricantes fabricante) {
		return fabricantesServiceImpl.guardarFabricante(fabricante);
	}
	
	
	@GetMapping("/fabricantes/{codigo}")
	public Fabricantes fabricanteXID(@PathVariable(name="codigo") Long codigo) {
		
		Fabricantes fabricante_xid= new Fabricantes();
		
		fabricante_xid=fabricantesServiceImpl.fabricanteXID(codigo);
		
		System.out.println("Fabricante XID: "+fabricante_xid);
		
		return fabricante_xid;
	}
	
	@PutMapping("/fabricantes/{codigo}")
	public Fabricantes actualizarTrabajador(@PathVariable(name="codigo")Long codigo,@RequestBody Fabricantes fabricante) {
		
		Fabricantes fabricante_seleccionado= new Fabricantes();
		Fabricantes fabricante_actualizado= new Fabricantes();
		
		fabricante_seleccionado= fabricantesServiceImpl.fabricanteXID(codigo);
		
		fabricante_seleccionado.setNombre(fabricante.getNombre());
		
		fabricante_actualizado = fabricantesServiceImpl.actualizarFabricante(fabricante_seleccionado);
		
		System.out.println("El fabricante actualizado es: "+ fabricante_actualizado);
		
		return fabricante_actualizado;
	}
	
	@DeleteMapping("/fabricantes/{codigo}")
	public void eliminarFabricante(@PathVariable(name="codigo")Long codigo) {
		fabricantesServiceImpl.eliminarFabricante(codigo);
	}
}
