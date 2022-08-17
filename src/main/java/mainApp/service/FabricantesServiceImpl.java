package mainApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mainApp.dao.IFabricantesDAO;
import mainApp.dto.Fabricantes;

@Service
public class FabricantesServiceImpl implements IFabricantesService{
	
	@Autowired
	IFabricantesDAO iFabricantesDAO;
	
	@Override
	public List<Fabricantes> listarFabricantes() {
		return iFabricantesDAO.findAll();
	}

	@Override
	public Fabricantes guardarFabricante(Fabricantes fabricante) {
		return iFabricantesDAO.save(fabricante);
	}

	@Override
	public Fabricantes fabricanteXID(Long codigo) {
		return iFabricantesDAO.findById(codigo).get();
	}

	@Override
	public List<Fabricantes> listarFabricantesNombre(String fabricante) {
		return iFabricantesDAO.findByNombre(fabricante);
	}

	@Override
	public Fabricantes actualizarFabricante(Fabricantes fabricante) {
		return iFabricantesDAO.save(fabricante);
	}

	@Override
	public void eliminarFabricante(Long codigo) {
		iFabricantesDAO.deleteById(codigo);
	}

}
