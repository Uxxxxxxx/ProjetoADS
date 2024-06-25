package com.projeto.ads.service;

import java.util.Calendar; import java.util.Date; import org.springframework.beans.factory.annotation.Autowired; import org.springframework.stereotype.Service; import com.projeto.ads.model.Aluno; import com.projeto.ads.repository.AlunoRepository;

@Service public class AlunoService {

 
@Autowired
AlunoRepository alunoRepository; 

public String geraMatricula(Long id) {
	Date data = new Date();
	Calendar calendario = Calendar.getInstance();
	calendario.setTime(data);
	int ano = calendario.get(Calendar.YEAR);
	return "SENAC" + ano + "" + (id + 1);
}// fim matricula

public String cadastrarAluno(Aluno aluno) {
	Aluno alunoAux = alunoRepository.findByCpf(aluno.getCpf());
	if(alunoAux != null) {
		return "Já existe um aluno com esse cpf!!";
	} else {
		Aluno lastAluno = alunoRepository.findLastInsertedAluno();
		if(lastAluno == null) {// é o primeiro aluno na base
			aluno.setMatricula(this.geraMatricula((long) 0));
		} else {
			aluno.setMatricula(this.geraMatricula(lastAluno.getId()));
		}
		alunoRepository.save(aluno);
	}
	return null;
}

public String AlterarAluno(Aluno aluno, Long id) {
	Aluno alunoExistente = alunoRepository.findByCpf(aluno.getCpf());
	if((alunoExistente != null) && (alunoExistente.getId() == id) || alunoExistente == null) {
		alunoRepository.save(aluno);
	} else {
		return "Já existe um aluno cadastrado com o mesmo CPF!!";
	}
	return null;
}

public void deleteById(Long id) {
}



public Aluno findById(Long id) {
	return null;
}

public Object findAllOrderedById() {
	
	return null;
}
}