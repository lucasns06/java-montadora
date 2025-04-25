package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CarroDAO;
import br.com.montadora.model.Carro;

public class CarroAlterar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con = Conexao.abrirConexao();

		Carro carro = new Carro();
		CarroDAO carrodao = new CarroDAO(con);////////

		carro.setMontadora("FIAT");
		carro.setNomeCarro("Uno");
		System.out.println(carrodao.modificar(carro));
	}
}
