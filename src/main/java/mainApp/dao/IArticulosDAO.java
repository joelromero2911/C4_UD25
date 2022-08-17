package mainApp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import mainApp.dto.Articulos;

public interface IArticulosDAO extends JpaRepository<Articulos, Long>{
	public List<Articulos> findByNombre(String nombre);
}
