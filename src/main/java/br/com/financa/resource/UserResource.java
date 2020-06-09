package br.com.financa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.financa.model.UserModel;
import br.com.financa.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	UserRepository ur;

	@GetMapping
	public List<UserModel> ListAllUsers(){
		return ur.findAll();
	}
	
	@PostMapping
	public ResponseEntity<UserModel> SaveUser(@RequestBody UserModel userModel){
		UserModel um = ur.save(userModel);
				
		return ResponseEntity.ok().body(um);
	}	
}
