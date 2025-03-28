package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Moto;

public class MotoDAO {

	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public MotoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Moto moto) {
		String sql = "insert into moto(qtdeAdesivos, nome, montadora) values (?, ? ,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1,  moto.getQtdeAdesivos());
			ps.setString(2,  moto.getNome());
			ps.setString(3,  moto.getMontadora());
			if (ps.executeUpdate() > 0) {
				return "Moto inserido com sucesso";
			} else {
				return "Erro inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

}
