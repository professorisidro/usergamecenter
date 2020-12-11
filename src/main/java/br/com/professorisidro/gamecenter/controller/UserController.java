package br.com.professorisidro.gamecenter.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.professorisidro.gamecenter.dao.UserDAO;
import br.com.professorisidro.gamecenter.model.User;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired 
	UserDAO dao;
	
	
	@GetMapping("/newuser")
	public String criarNovoUsuario(@RequestParam(name="nome")  String nome, 
			 				       @RequestParam(name="email") String email, 
			 				       @RequestParam(name="nick")  String nick) {
		try {
			User user = new User();
			user.setName(nome);
			user.setEmail(email);
			user.setNick(nick);
			
			dao.save(user);
			
			return "S:"+user.getName()+"|"+user.getEmail()+"|"+user.getNick();
			
		}
		catch(Exception ex) {
			return "E:"+"Email or Nickname already taken";
			
		}
	}
	
	@GetMapping("/allusers")
	public ArrayList<User> getAll(){
		return (ArrayList<User>)dao.findAll();
	}
	@GetMapping("/getuser")
	public String recuperarUsuario(@RequestParam(name="email") String email) {
		User user = dao.findByEmail(email);
		if (user == null) {  // nao achei o email
			return "E:User not found";
		}
		else {
			return "S:"+user.getName()+"|"+user.getNick();
		}
	}

}
