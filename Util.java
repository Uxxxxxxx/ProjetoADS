package com.projeto.ads.util;

import java.util.UUID;

public class Util {
	public static String generateToken() {
		// Gere um UUID aleatório
		UUID uuid = UUID.randomUUID();
		// Converta o UUID em uma string removendo os hifens e convertendo para letras
		// minúsculas
		String token = uuid.toString().replaceAll("-", "").toLowerCase();
		return token;
	}
}
