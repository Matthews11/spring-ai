package com.springgai.openai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springgai.openai.model.ClasificacionTicket;
import com.springgai.openai.model.CodeDto;
import com.springgai.openai.model.CodeExplanation;
import com.springgai.openai.model.InformacionCiudad;
import com.springgai.openai.model.InformacionJson;
import com.springgai.openai.model.Requirement;
import com.springgai.openai.services.AiService;


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
	
	@PostMapping("/chat-expert")
	public String chatExpertoSpring(@RequestBody String prompt) {
		return aiService.chat(prompt);
	}
	
	
	@PostMapping("/generate-code")
	public CodeDto generateCode(@RequestBody Requirement requirement) {
		return aiService.generateCode(requirement);
	}
	
	@PostMapping("/explain-code")
	public String explain(@RequestBody String code) {
		return aiService.explain(code);
	}
	
	@PostMapping("/chat-format")
	public String chatFormat(@RequestBody String prompt) {
		return aiService.chatFormat(prompt);
	}
	
	@PostMapping("/analizar")
	public String analizadorTexto(@RequestBody String prompt) {
		return aiService.analizando(prompt);
	}
	
	@GetMapping("/informacion-ciudad")
	public InformacionCiudad brindarInformacionCiudad(@RequestParam String ciudad) {
		return aiService.informacionCiudades(ciudad);
	}
	
	
	@PostMapping("/clasificacion-ticket")
	public ClasificacionTicket clasificadorTicket(@RequestBody String prompt) {
		return aiService.clasificarTicket(prompt);
	}
	
	
	
	@PostMapping("/informacion-json")
	public InformacionJson brindarInformacionJson(@RequestBody String objetoJson) {
		return aiService.informacionJson(objetoJson);
	}
	
	
	@PostMapping("/explain-code-json")
	public CodeExplanation brindarExplicacionCodigo(@RequestBody String codigo) {
		return aiService.explainCodeType(codigo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
