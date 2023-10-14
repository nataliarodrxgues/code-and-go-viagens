package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Destinos;
import com.agencia.utils.Colors;

public class DestinosDAO {
	private static String sql;
	private final Connection connection;
	public DestinosDAO(Connection connection) {
		this.connection = connection;
	}
 	
	
	// CREATE
	
 public void createDestinos(Destinos destinos) {
	 sql = "INSERT INTO (destinos NomeDestino, CodigoDestino, CodigoRerserva) VALUES (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			 stmt.setString(1, destinos.getNomeDestino());
			 stmt.setString(1, destinos.getCodigoDestino());
			 stmt.setString(2, destinos.getCodigoReserva());
				stmt.executeUpdate();
				System.out.println(Colors.GREEN.get() + "Destino criado com sucesso\n" + Colors.RESET.get() + "Destino: "
						+ destinos.getNomeDestino() + "\nCodigo Reserva: " + destinos.getCodigoReserva());
			} catch (SQLException e) {
				System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o destino." + Colors.RESET.get() +  "Mensagem: " + e.getMessage());

			}
		}

 
	// READ
 
	public void readAllDestinos() {
		sql = "SELECT * FROM destinos";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Destinos destinos = new Destinos();
				destinos.setId_Destino(r.getInt("id_Destino"));
				destinos.setNomeDestino(r.getString("NomeDestino"));
				destinos.setCodigoDestino(r.getString("CodigoDestino"));
				destinos.setCodigoReserva(r.getString("CodigoReserva"));
			
				

	System.out.printf("ID: %d\n CPF: %s\\n NomeDestino: %s\n CodigoDestino: %s\\n\" CodigoReserva: %s\n", destinos.getId_Destino(),
	destinos.getNomeDestino(), destinos.getCodigoDestino(), destinos.getCodigoReserva());
			}
			if (!r.next()) {
				System.out.println(Colors.PURPLE_BOLD_BRIGHT.get() + "NAO HA DADOS" + Colors.RESET.get());
			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	
	// UPDATE 

	public void updateDestinos(Destinos destinos) {
		sql = "UPDATE cliente SET NomeDestino = ? , CodigoDestino = ?, CodigoReserva = ? WHERE id_Destinos = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNomeDestino());
			stmt.setString(2, destinos.getCodigoDestino());
			stmt.setString(3, destinos.getCodigoReserva());
		
		stmt.executeUpdate();
		System.out.println(Colors.GREEN.get() + "Destino atualizado com sucesso\n" + Colors.RESET.get() + "Nome Destino: "
				+ destinos.getNomeDestino() + "\nCodigo Resrva: " + destinos.getCodigoReserva());

	} catch (SQLException e) {
		System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o destino." + Colors.RESET.get()
				+ "Mensagem: " + e.getMessage());
	}
}
	
	

	// DELETE
	
	public void deleteDestinos(int id) {
		sql = "DELETE FROM destinos WHERE id_Destinos = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
		System.out.println(Colors.GREEN.get() + "Destino deletado com sucesso!" + Colors.RESET.get());
	} catch (SQLException e) {
		System.out.println(Colors.RED.get() + "Nao foi possivel deletar o destino." + Colors.RESET.get()
				+ "Mensagem: " + e.getMessage());
	}
}
}


