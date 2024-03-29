package br.com.feirasverdes.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.feirasverdes.backend.entidade.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario,Long>{
	@Transactional
    @Modifying
    @Query(value = "select * from usuario u where nome like '%?1%'", nativeQuery = true)
	List<Usuario>pesquisarPorNome(String nome);

	Usuario getOne(long id);
	
	void delete(Usuario entity);
	
	void deleteById(Long id);
	
	List<Usuario> findAll();
	
}
