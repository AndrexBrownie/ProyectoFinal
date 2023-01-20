package com.example.demo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.Login;
import com.example.demo.repository.LoginRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProyectoprincipalApplicationTests {

	@Autowired
	private LoginRepository repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@Test
	public void crearUsuarioTest() {
	  Login us=new Login();
	  us.setId(3);
	  us.setUsuario("Juan");
	  us.setClave(encoder.encode("769"));
	  //us.setPass("456");
	  repo.save(us);

	  Login retorno=repo.save(us);
	  assertTrue(retorno.getClave().equals(us.getClave()));
	}
}
