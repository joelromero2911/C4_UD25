package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Fabricantes;

public interface IFabricantesDAO extends JpaRepository<Fabricantes, Long>{
	public List<Fabricantes> findByNombre(String nombre);
}
