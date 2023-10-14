package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Contatos;
import com.agencia.utils.Colors;

public class ContatosDAO {
	private static String sql;

	private final Connection connection;

	public ContatosDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	
 public void createContatos(Contatos contatos) {
	 sql = "INSERT INTO cliente (Assunto, NomeContato, EmailContato, Mensagem) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, contatos.getAssunto());
			stmt.setString(2, contatos.getNomeContato());
			stmt.setString(3, contatos.getEmailContato());
			stmt.setString(4, contatos.getMensagem());
			
		
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Contato feito com sucesso\n" + Colors.RESET.get() + "Nome: "
			+ contatos.getNomeContato() + "\nAssunto: " + contatos.getAssunto());
			} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel entrar em contato." + Colors.RESET.get() +  "Mensagem: " + e.getMessage());

			}
		}

 
	// READ
 
	public void readAllContatos() {
		sql = "SELECT * FROM contatos";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Contatos contatos = new Contatos();
				contatos.setId_Contato(r.getInt("id_Contato"));
				contatos.setAssunto(r.getString("Assunto"));
				contatos.setNomeContato(r.getString("NomeContato"));
				contatos.setEmailContato(r.getString("EmailContato"));
				contatos.setMensagem(r.getString("Mensagem"));
				
				

	System.out.printf("ID: %d\n Assunto: %s\\n Nome: %s\n Email: %s\\n\" Mensagem: %s\n",
			contatos.getId_Contato(), contatos.getAssunto(), contatos.getNomeContato(), contatos.getEmailContato(),contatos.getMensagem());
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

	public void updateContatos(Contatos contatos) {
		sql = "UPDATE contatos SET Assunto = ? , NomeContato = ?, EmailContato = ?, Mensagem = ? WHERE id_Contato = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, contatos.getAssunto());
			stmt.setString(2, contatos.getNomeContato());
			stmt.setString(3, contatos.getEmailContato());
			stmt.setString(4, contatos.getMensagem());
		
	

		stmt.executeUpdate();
		System.out.println(Colors.GREEN.get() + "Contato atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
				+ contatos.getNomeContato() + "\nAssunto: " + contatos.getAssunto());

	} catch (SQLException e) {
		System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o contato." + Colors.RESET.get()
				+ "Mensagem: " + e.getMessage());
	}
}
	
	

	// DELETE
	
	public void deleteContatos(int id) {
		sql = "DELETE FROM contatos WHERE id_Contato = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
		System.out.println(Colors.GREEN.get() + "Contato deletado com sucesso!" + Colors.RESET.get());
	} catch (SQLException e) {
		System.out.println(Colors.RED.get() + "Nao foi possivel deletar o contato." + Colors.RESET.get()
				+ "Mensagem: " + e.getMessage());
	}
}
}
	
