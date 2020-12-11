package br.com.professorisidro.gamecenter.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.professorisidro.gamecenter.model.User;


public interface UserDAO extends CrudRepository<User, Integer>{
	
	public User findByEmail(String email);

}
