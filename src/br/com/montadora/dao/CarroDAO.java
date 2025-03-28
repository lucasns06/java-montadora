package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Carro;

public class CarroDAO {
	
	private Connection con = null;

	
	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public CarroDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Carro carro) {
		String sql = "insert into carro(qtde, nome, montadora) values (?, ? ,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1,  carro.getQtdePortas());
			ps.setString(2,  carro.getNome());
			ps.setString(3,  carro.getMontadora());
			if (ps.executeUpdate() > 0) {
				return "Carro inserido com sucesso";
			} else {
				return "Erro inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
