package br.com.montadora.teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.CarroDAO;
import br.com.montadora.model.Carro;

public class CarroSelecionar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con = Conexao.abrirConexao();

		//Carro carro = new Carro();
		CarroDAO carrodao = new CarroDAO(con);////////

		ArrayList<Carro> lista = carrodao.retornarDados();
		
		if(lista != null) {
			for(Carro carro: lista) {
				System.out.println("Montadora: " + carro.getMontadora() + 
						"| Nome carro " + carro.getNomeCarro() +
						"| Quantidade de portas " + carro.getQuantidadePortas()
						
						);
				//System.out.println("Nome carro " + carro.getNomeCarro());
				//System.out.println("Quantidade de portas " + carro.getQuantidadePortas());
			}
		}
	}

}
