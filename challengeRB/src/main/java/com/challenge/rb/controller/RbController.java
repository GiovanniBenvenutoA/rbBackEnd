package com.challenge.rb.controller;


import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.rb.model.Authentication;
import com.challenge.rb.model.Response;
import com.challenge.rb.services.IRbImplementService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping({ "/api" })
public class RbController {
	
	private static Logger log = LoggerFactory.getLogger(RbController.class);
	
	@Autowired
	IRbImplementService rbImplement;
	
	
	@PostMapping("/Authentication/{idNumber}/{password}")
	public Response getAutenthication(@PathVariable String idNumber, @PathVariable String password) throws InterruptedException, ExecutionException {
		
		log.info("Ingresando a Servicio de Identificacion");
		Response response = new Response();
		Authentication auth = new Authentication();
		auth =rbImplement.validationAuth(idNumber, password);
		if(auth!=null) {
			log.info("exito");
			response.setValor(true);
			response.setMensaje("Ingreso Exitoso");
			response.setAuth(auth);
		}else {
			response.setValor(false);
			log.info("fracaso");
			response.setMensaje("Error usuario y/o clave incorrectos");
		}
		return response;
		
	}
	
	@PostMapping("/RecoveryPass/{idNumber}")
	public Response getRecoveryPass(@PathVariable String idNumber) throws InterruptedException, ExecutionException {
		
		log.info("Ingresando a Servicio de Recuperacion");
		Authentication recovery = new Authentication();
		Response response = new Response();
		
		recovery =rbImplement.RecoveryPass(idNumber);
		if(recovery!=null) {
			response.setValor(true);
			response.setMensaje("Recuperacion Exitosa");
			response.setAuth(recovery);
		}else {
			response.setValor(false);
			response.setMensaje("Usuario no Registrado Favor Validar");
			
		}
		
		
		return response;
		
	}

}
