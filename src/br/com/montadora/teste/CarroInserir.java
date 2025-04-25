package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CarroDAO;
import br.com.montadora.model.Carro;

public class CarroInserir {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Carro carro = new Carro();
		CarroDAO carrodao = new CarroDAO(con);////////

		carro.setMontadora("FORD");
		carro.setNomeCarro("Eco Sport");
		carro.setQuantidadePortas(4);
		System.out.println(carrodao.inserir(carro));

	}

}
