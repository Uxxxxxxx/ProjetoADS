package com.projeto.ads.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.ads.model.Usuario;
import com.projeto.ads.repository.UserRepository;
import java.time.LocalDate;
@Service
public class UserService {

	@Autowired
	UserRepository userRepository; 
	/*
	 * Se houver um error de regra de negócio
	 * retorna esse erro
	 * se não houver erro, retorne null
	 * 
	 * 
	 */
	public String validaErros(Usuario user, String confirmPassword, String dataNascimentoString ) {
		String error= null;
		// Verificar se a senha e a confirmação da senha correspondem
		if (!user.getPassword().equals(confirmPassword)) {
			error= "As senhas não correspondem!";
			return error;
		}//
		if(user.getPassword().length() < 8) {
			error="A senha precisa ter no mínimo 8 caracteres!";
			return error;
		}
		String email = user.getEmail();
		Usuario retorno= userRepository.findByEmail(email);
		if(retorno !=null) {//achou um usuario na base de dados relacionado a esse email
			error="Esse email já está cadastrado na aplicação!";
			return error;
		}
		if(!this.data(dataNascimentoString)) {
			error="Data de nascimento é inválida!";
			return error;
		}
		return error;
	}//fim validaErros
	
	/*return true se a data tiver dentro do esperado
		return false caso a dataNasc esteja maior do que a data corrente
	*/
	public boolean data(String datasNasc) {
		LocalDate hoje = LocalDate.now();//pega a data corrente
        int dia = hoje.getDayOfMonth();// pega o dia 
        int ano = hoje.getYear(); //pega o ano
        int mes = hoje.getMonthValue(); // pega o mes
        String[] partes = datasNasc.split("-"); //"2024-02-17" partes[0]= 2024 partes[1]= 02 partes[2]=17 
        // Extrair o ano, mês e dia
        int anoNasc = Integer.parseInt(partes[0]);
        int mesNasc = Integer.parseInt(partes[1]);
        int diaNasc = Integer.parseInt(partes[2]);
        if(anoNasc < ano)
        {
        	return true;
        }
        else 
        { //anoNasc = ano
        	if(mesNasc < mes) 
        	{
        		return true;
        	}
        	else 
        	{ //mesNasc = mes
        		if(diaNasc <= dia)
        		{
        			return true;
        		}
        	}
        }//fim else
        return false;// indica que a data nao está correta
	}
	
}
