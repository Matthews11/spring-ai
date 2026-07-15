package com.springgai.openai.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiServiceImpl implements AiService{
	
private final ChatClient chatClient;
	
	public AiServiceImpl (ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.build();
	}
	
	

	@Override
	public String saludar(String nombre) {
		// TODO Auto-generated method stub
		return this.chatClient
				.prompt()
				.system("Responde siempre en espanol y en una sola linea")
				.user("Dime Hola mundo, con mi nombre: %s".formatted(nombre))
				.call()
				.content();
	}



	@Override
	public String chat(String prompt) {
		// TODO Auto-generated method stub
		return chatClient
				.prompt()
				.user(prompt)
				.call()
				.content();
	}

}
