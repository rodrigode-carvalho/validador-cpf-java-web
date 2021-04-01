package com.concrete.ValidadorCPF;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.concrete.ValidadorCPF.models.Cliente;


@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	@DisplayName("Quando eu passar um cpf válido o valor precisa ser verdadeiro")
	void paraValidarCPF() {
		Cliente leandro = new Cliente("Leandro Santos", "43545768058");
		// Cliente leandro = new Cliente();
		// leandro.setNome("Leandro Santos");
		// leandro.setCpf("43545768058");
		assertEquals(true, leandro.validarCPF());
	}

		
	@DisplayName("Quando eu passar um cpf inválido o valor precisa ser falso")
	@Test
	void paraValidarCPFInvalido() {
		Cliente cliente = new Cliente("Leandro Santos","43545768059");
		assertEquals(false, cliente.validarCPF());
	}

	@DisplayName("Quando eu passar um cpf inválido formatado o valor precisa ser falso")
	@Test
	void paraValidarCPFInvalidoFormatado() {
		Cliente cliente = new Cliente("Leandro Santos","435.457.680-50");
		assertEquals(false, cliente.validarCPF());
	}

	@DisplayName("Quando eu passar um cpf válido formatado o valor precisa ser verdadeiro")
	@Test
	void paraValidarCPFvalidoFormatado() {
		Cliente cliente = new Cliente("Leandro Santos","435.457.680-58");
		assertEquals(true, cliente.validarCPF());
	}
}