package com.agencia.menus;

import java.io.PrintStream;
import java.sql.Connection;
import java.util.Scanner;

import com.agencia.dao.PedidosDAO;
import com.agencia.database.DatabaseConnection;
import com.agencia.model.Pedidos;
import com.agencia.utils.Colors;

public class PedidosIO {
	   static Connection connection = DatabaseConnection.createConnection();
	   static PedidosDAO pedidosDAO;

	   static {
	      pedidosDAO = new PedidosDAO(connection);
	   }

	   
	   public static int SubMenuPedidos(Scanner scanner) {
	      int option = Integer.MAX_VALUE;

	      do {
	         System.out.println("MENU PEDIDOS\n1 - Cadastrar\n2 - Listar\n3 - Atualizar\n4 - Deletar\n0 - Sair");
	         option = scanner.nextInt();
	         switch (option) {
	            case 1:
	               scanner.nextLine();
	               Pedidos pedidos = new Pedidos();
	               System.out.println("ID Cliente: ");
	               pedidos.setId_Cliente(scanner.nextLine());
	               System.out.println("Nome Destino: ");
	               pedidos.setNomeDestino(scanner.nextLine());
	               System.out.println("Nome Promoção: ");
	               pedidos.setNomePromocao(scanner.nextLine());
	               System.out.println("Status Pedido: ");
	               pedidos.setStatusPedido(scanner.nextLine());
	               System.out.println("Valor Compra: ");
	               pedidos.setValorCompra(scanner.nextLine());
	               pedidosDAO.createPedidos(pedidos);
	               
	               break;
	            case 2:
	                pedidosDAO.readAllPedidos();
	                break;
	             case 3:
	                    Pedidos pedidosAtualizado = new Pedidos();
	                    System.out.println("Digite o ID do pedido a ser atualizado: ");
	                    pedidosAtualizado.setId_Pedidos(scanner.nextInt());
	                    scanner.nextLine();
	                    System.out.println("Nome Destino: ");
	                    pedidosAtualizado.setNomeDestino(scanner.nextLine());
	                    System.out.println("Nome Promoção: ");
	                    pedidosAtualizado.setNomePromocao(scanner.nextLine());
	                    System.out.println("Status Pedido: ");
	                    pedidosAtualizado.setStatusPedido(scanner.nextLine());
	                    System.out.println("Valor Compra: ");
	                    pedidosAtualizado.setValorCompra(scanner.nextLine()); 
	                    pedidosDAO.updatePedidos(pedidosAtualizado);
	                    
	                    break;
	            case 4:
	                PrintStream var10000 = System.out;
	                String var10001 = Colors.RED.get();
	                var10000.println("Digite o ID do Pedido a ser " + var10001 + "DELETADO" + Colors.RESET.get());
	                int id_Pedidos = scanner.nextInt();
	                pedidosDAO.deletePedidos(id_Pedidos);
	                break;
	             default:
	                System.out.println("Digite uma opcao valida");
	          }
	       } while(option != 0);

	       return option;
	    }
	 } 
