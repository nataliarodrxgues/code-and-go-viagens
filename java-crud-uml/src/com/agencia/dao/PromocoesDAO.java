package com.agencia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.agencia.model.Promocoes;
import com.agencia.utils.Colors;

public class PromocoesDAO {
	private static String sql;
	private final Connection connection;
	public PromocoesDAO(Connection connection) {
		this.connection = connection;
	}
	
		// CREATE
		
		 public void createPromocoes(Promocoes promocoes) {
			 sql = "INSERT INTO cliente (id_promo, promoViagens, promoPacotes, codigoViagens, codigoPacotes, codigoReserva) VALUES (?,?,?,?,?,?)";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					 stmt.setInt(1, promocoes.getId_promo());
					 stmt.setString(2, promocoes.getPromoViagens());
					 stmt.setString(3, promocoes.getPromoPacotes());	
					 stmt.setString(4, promocoes.getCodigoViagens());	 
					 stmt.setString(5, promocoes.getCodigoPacotes());
					 stmt.setString(5, promocoes.getCodigoReserva());
						stmt.executeUpdate();
						System.out.println(Colors.GREEN.get() + "Promocao reservada com sucesso\n" + Colors.RESET.get() + "Id da Promoção: "
								+ promocoes.getId_promo() + "Codigo da Reserva\n: " + promocoes.getCodigoReserva());
					} catch (SQLException e) {
						System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o pedido." + Colors.RESET.get() +  "Mensagem: " + e.getMessage());

					}
				}

		 
			// READ
		 
			public void readAllPromocoes() {
				sql = "SELECT * FROM promocoes";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					ResultSet r = stmt.executeQuery();
					while (r.next()) {
						Promocoes promocoes = new Promocoes();
						promocoes.setId_promo(r.getInt("id_Promo"));
						promocoes.setPromoViagens(r.getString("PromoViagens"));
						promocoes.setPromoPacotes(r.getString("PromoPacotes"));
						promocoes.setCodigoViagens(r.getString("CodigoViagens"));
						promocoes.setCodigoPacotes(r.getString("CodigoPacotes"));
						promocoes.setCodigoReserva(r.getString("CodigoReserva"));
						

			System.out.printf("ID: %d\n Promo viagens: %s\\n PromoPacotes: %s\n CodigoViagens: %s\\n\" CodigoPacotes: %s\n CodigoReserva: %s\n", 
					promocoes.getId_promo(), promocoes.getPromoViagens(), promocoes.getPromoPacotes(), promocoes.getCodigoViagens(), promocoes.getCodigoPacotes(), promocoes.getCodigoReserva());
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

			public void updatePromocoes(Promocoes promocoes) {
				sql = "UPDATE promocoes SET promoViagens = ? , promoPacotes = ?, codigoViagens = ?, codigoPacotes = ?, codigoReserva = ? , WHERE id_promo = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					stmt.setString(1, promocoes.getPromoViagens());
					stmt.setString(2, promocoes.getPromoPacotes());
					stmt.setString(3, promocoes.getCodigoViagens());
					stmt.setString(4, promocoes.getCodigoPacotes());
					stmt.setString(5, promocoes.getCodigoReserva());
					
			

				stmt.executeUpdate();
				System.out.println(Colors.GREEN.get() + "Promoção atualizada com sucesso\n" + Colors.RESET.get() + "ID da Promoção: "
						+ promocoes.getId_promo() + "\nCodigo da Reserva: " + promocoes.getCodigoReserva());

			} catch (SQLException e) {
				System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar a promoção." + Colors.RESET.get()
						+ "Mensagem: " + e.getMessage());
			}
		}
			
			

			// DELETE
			
			public void deletePromocoes(int id) {
				sql = "DELETE FROM pedido WHERE Id_promo = ?";
				try (PreparedStatement stmt = connection.prepareStatement(sql)) {
					stmt.setInt(1, id  );

					stmt.executeUpdate();
				System.out.println(Colors.GREEN.get() + "Promoção deletada com sucesso!" + Colors.RESET.get());
			} catch (SQLException e) {
				System.out.println(Colors.RED.get() + "Nao foi possivel deletar a promoção." + Colors.RESET.get()
						+ "Mensagem: " + e.getMessage());
			}
		}
		}


