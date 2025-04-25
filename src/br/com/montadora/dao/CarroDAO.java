package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	// Método inserir da DAO

	public String inserir(Carro carro) {
		String sql = "insert into carro(montadora, nomecarro, quantidadeportas) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMontadora());
			ps.setString(2, carro.getNomeCarro());
			ps.setDouble(3, carro.getQuantidadePortas());
			if (ps.executeUpdate() > 0) {
				return "Carro inserido com sucesso";
			} else {
				return "Erro inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método deletar

	public String deletar(Carro carro) {
		String sql = "delete from carro where montadora = (?)";
		// String sql = "delete from professor where curso = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMontadora());
			if (ps.executeUpdate() > 0) {
				return "Carro deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método alterar da DAO

	public String modificar(Carro carro) {
		String sql = "update carro set montadora = (?) where nomecarro = (?)";
		// String sql = "update professor set salario = (?) where nome = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, carro.getMontadora());
			ps.setString(2, carro.getNomeCarro());
			if (ps.executeUpdate() > 0) {
				return "Carro alterado com sucesso";
			} else {
				return "Erro ao alterar";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	// Método selecionar

	public ArrayList<Carro> retornarDados() {
		String sql = "select * from carro";
		ArrayList<Carro> retornarCarro = new ArrayList<Carro>();

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {////////////////////////////
					Carro carro = new Carro();
					carro.setMontadora(rs.getString(1));
					carro.setNomeCarro(rs.getString(2));
					carro.setQuantidadePortas(rs.getInt(3));
					retornarCarro.add(carro);
				}
				return retornarCarro;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	}
}
