package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CarroDAO;
import br.com.montadora.model.Carro;

public class CarroDeletar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Carro carro = new Carro();
		CarroDAO carrodao = new CarroDAO(con);////////

		carro.setMontadora("FIAT");
		System.out.println(carrodao.deletar(carro));

	}

}
