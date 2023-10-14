package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Clientes;
import com.agencia.utils.Colors;

public class ClientesDAO {
	private static String sql;
	private final Connection connection;
	public ClientesDAO(Connection connection) {
		this.connection = connection;
	}
 	
	
	// CREATE
	
 public void createClientes(Clientes clientes) {
	 sql = "INSERT INTO clientes (CPFCliente, NomeCliente, TelefoneCliente, EmailCliente, SenhaCliente, EnderecoCliente) VALUES (?,?,?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			 stmt.setString(1, clientes.getCPFCliente());
			 stmt.setString(2, clientes.getNomeCliente());
			 stmt.setString(3, clientes.getTelefoneCliente());
			 stmt.setString(4, clientes.getEmailCliente());	
			 stmt.setString(5, clientes.getSenhaCliente());	 
			 stmt.setString(6, clientes.getEnderecoCliente());
			
		
				stmt.executeUpdate();
				System.out.println(Colors.GREEN.get() + "Cliente criado com sucesso\n" + Colors.RESET.get() + "Nome: "
						+ clientes.getNomeCliente() + "\nCPF: " + clientes.getCPFCliente());
			} catch (SQLException e) {
				System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o cliente." + Colors.RESET.get() +  "Mensagem: " + e.getMessage());

			}
		}

 
	// READ
 
	public void readAllClientes() {
		sql = "SELECT * FROM clientes";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Clientes clientes = new Clientes();
				clientes.setId_Cliente(r.getInt("id_Cliente"));
				clientes.setCPFCliente(r.getString("CpfCliente"));
				clientes.setNomeCliente(r.getString("NomeCliente"));
				clientes.setTelefoneCliente(r.getString("TelefoneCliente"));
				clientes.setEmailCliente(r.getString("EmailCliente"));
				clientes.setSenhaCliente(r.getString("SenhaCliente"));
				clientes.setEnderecoCliente(r.getString("EnderecoCliente"));
				

	System.out.printf("ID: %d\n CPF: %s\n Nome: %s\n Telefone: %s\n Email: %s\n Senha: %s\n Endereco: %s\n", clientes.getId_Cliente(),
	clientes.getCPFCliente(), clientes.getNomeCliente(), clientes.getTelefoneCliente(), clientes.getEmailCliente(), clientes.getSenhaCliente(), clientes.getEnderecoCliente());
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

	public void updateClientes(Clientes clientes) {
		sql = "UPDATE clientes SET cPFCliente = ? , NomeCliente = ?, TelefoneCliente = ?, EmailCliente = ?, SenhaCliente = ? , EnderecoCliente = ?, WHERE id_Cliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, clientes.getCPFCliente());
			stmt.setString(2, clientes.getNomeCliente());
			stmt.setString(3, clientes.getTelefoneCliente());
			stmt.setString(4, clientes.getEmailCliente());
			stmt.setString(5, clientes.getSenhaCliente());
			stmt.setString(6, clientes.getEnderecoCliente());
	

		stmt.executeUpdate();
		System.out.println(Colors.GREEN.get() + "Cliente atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
				+ clientes.getNomeCliente() + "\nCPF: " + clientes.getCPFCliente());

	} catch (SQLException e) {
		System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o cliente." + Colors.RESET.get()
				+ "Mensagem: " + e.getMessage());
	}
}
	
	

	// DELETE
	
	public void deleteClientes(int id) {
		sql = "DELETE FROM clientes WHERE id_Cliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
		System.out.println(Colors.GREEN.get() + "Cliente deletado com sucesso!" + Colors.RESET.get());
	} catch (SQLException e) {
		System.out.println(Colors.RED.get() + "Nao foi possivel deletar o cliente." + Colors.RESET.get()
				+ "Mensagem: " + e.getMessage());
	}
}
}


