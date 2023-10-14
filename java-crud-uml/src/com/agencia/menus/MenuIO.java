package com.agencia.menus;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.agencia.utils.Colors;

public class MenuIO {
    public MenuIO() {
    }

    public static int menu(Scanner scanner) {
        int choice;
        do {
            System.out.println(Colors.BLUE_BOLD.get() + "Escolha uma opção de 1 - 6\n" + Colors.RESET.get() + "1 - Cliente\n2 - Pedidos\n3 - Destinos\n4 - Promoções\n5 - Contato\n6 - Sair");
            try {
                choice = scanner.nextInt();
                if (choice < 1 || choice > 6) {
                    System.out.println(Colors.RED.get() + "Opção inválida. Escolha um número de 1 a 6." + Colors.RESET.get());
                }
            } catch (InputMismatchException e) {
                System.out.println(Colors.RED.get() + "Entrada inválida. Insira um número de 1 a 6." + Colors.RESET.get());
                scanner.next(); 
                choice = 0;
            }
        } while (choice < 1 || choice > 6);

        System.out.println("Você escolheu a opção " + choice);
        return choice;
    }
}
