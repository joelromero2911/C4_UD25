package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IArticulosDAO;
import mainApp.dto.Articulos;

@Service
public class ArticulosServiceImpl implements IArticulosService{
	
	@Autowired
	IArticulosDAO iArticulosDAO;

	@Override
	public List<Articulos> listarArticulos() {
		return iArticulosDAO.findAll();
	}

	@Override
	public Articulos guardarArticulo(Articulos articulo) {
		return iArticulosDAO.save(articulo);
	}

	@Override
	public Articulos articuloXID(Long codigo) {
		return iArticulosDAO.findById(codigo).get();
	}

	@Override
	public List<Articulos> listarArticuloNombre(String articulo) {
		return iArticulosDAO.findByNombre(articulo);
	}

	@Override
	public Articulos actualizarArticulos(Articulos articulo) {
		return iArticulosDAO.save(articulo);
	}

	@Override
	public void eliminarArticulos(Long codigo) {
		iArticulosDAO.deleteById(codigo);
	}

}
