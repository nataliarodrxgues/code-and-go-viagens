package com.agencia.menus;

import java.io.PrintStream;
import java.sql.Connection;
import java.util.Scanner;

import com.agencia.dao.DestinosDAO;
import com.agencia.database.DatabaseConnection;
import com.agencia.model.Destinos;
import com.agencia.utils.Colors;

public class DestinosIO {
	   static Connection connection = DatabaseConnection.createConnection();
	   static DestinosDAO destinosDAO;

	   static {
	      destinosDAO = new DestinosDAO(connection);
	   }

	   
	   public static int SubMenuDestinos(Scanner scanner) {
	      int option = Integer.MAX_VALUE;

	      do {
	         System.out.println("MENU DESTINOS\n1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Deletar\n0 - Sair");
	         option = scanner.nextInt();
	         switch (option) {
	            case 1:
	               scanner.nextLine();
	               Destinos destinos = new Destinos();
	               System.out.println("Nome Destino: ");
	               destinos.setNomeDestino(scanner.nextLine());
	               System.out.println("Codigo Destino: ");
	               destinos.setCodigoDestino(scanner.nextLine());
	               System.out.println("Codigo Reserva: ");
	               destinos.setCodigoReserva(scanner.nextLine());
	               destinosDAO.createDestinos(destinos);
	               
	               break;
	            case 2:
	                destinosDAO.readAllDestinos();
	                break;
	             case 3:
	                    Destinos destinosAtualizado = new Destinos();
	                    System.out.println("Digite o ID do destino a ser atualizado: ");
	                    destinosAtualizado.setId_Destino(scanner.nextInt());
	                    scanner.nextLine();
	                    System.out.println("Nome Destino: ");
	                    destinosAtualizado.setNomeDestino(scanner.nextLine());
	                    System.out.println("Codigo Destino: ");
	                    destinosAtualizado.setCodigoDestino(scanner.nextLine());
	                    System.out.println("Codigo Reserva: ");
	                    destinosAtualizado.setCodigoReserva(scanner.nextLine());       
	                    destinosDAO.updateDestinos(destinosAtualizado);
	                    break;
	            case 4:
	                PrintStream var10000 = System.out;
	                String var10001 = Colors.RED.get();
	                var10000.println("Digite o ID do Destino a ser " + var10001 + "DELETADO" + Colors.RESET.get());
	                int id_Destino = scanner.nextInt();
	                destinosDAO.deleteDestinos(id_Destino);
	                break;
	             default:
	                System.out.println("Digite uma opcao valida");
	          }
	       } while(option != 0);

	       return option;
	    }
	 } 


