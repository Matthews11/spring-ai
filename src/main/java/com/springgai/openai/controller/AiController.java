package com.springgai.openai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springgai.openai.services.AiService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class AiController {

	
	 private final AiService aiService;
	 
	 public AiController(AiService aiService) {
		// TODO Auto-generated constructor stub
		 this.aiService = aiService;
	}
	
	@GetMapping("/saludar")
	public String saludar(@RequestParam(defaultValue="Jared")String nombre) {
		return aiService.saludar(nombre);
	}
	
	
	@PostMapping("/chat")
	public String chat(@RequestBody String prompt) {
		
		return aiService.chat(prompt);
		
	}
	
}
