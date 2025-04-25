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

	//Método inserir da DAO
	
	public String inserir(Moto moto) {
		String sql = "insert into moto(montadora, nomecarro, quantidadeadesivos) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  moto.getMontadora());
			ps.setString(2, moto.getNomeCarro());
			ps.setDouble(3, moto.getQuantidadeAdesivos());
			if (ps.executeUpdate() > 0) {
				return "Moto inserido com sucesso";
			} else {
				return "Erro inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	//deletar
	
	public String deletar(Moto moto) {
		String sql =   "delete from moto where montadora = (?)";
		//String sql = "delete from carro where montadora = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  moto.getMontadora());
			if (ps.executeUpdate() > 0) {
				return "Moto deletado com sucesso";
			} else {
				return "Erro ao deletar a motinho";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
