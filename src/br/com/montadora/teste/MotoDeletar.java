package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CarroDAO;
import br.com.montadora.dao.MotoDAO;
import br.com.montadora.model.Carro;
import br.com.montadora.model.Moto;

public class MotoDeletar {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Moto moto = new Moto();
		MotoDAO motodao = new MotoDAO(con);////////

		moto.setMontadora("Honda");
		System.out.println(motodao.deletar(moto));

	}

}
