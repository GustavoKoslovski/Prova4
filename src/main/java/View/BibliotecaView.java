package View;

import Controller.BibliotecaController;
import Model.Biblioteca;
import Model.Genero;

import java.util.List;
import java.util.Scanner;

public class BibliotecaView {

    BibliotecaController bibliotecaController = new BibliotecaController();
    Scanner input = new Scanner(System.in);

    public void cadastrarBiblioteca() {
        Biblioteca biblioteca = new Biblioteca();
        Scanner input = new Scanner(System.in);

        System.out.print("Nome da biblioteca: ");
        biblioteca.setNomeBiblioteca(input.nextLine());

        bibliotecaController.cadastrarBiblioteca(biblioteca);
        System.out.println("\n" + "[" + biblioteca.getNomeBiblioteca() + "] cadastrada!");
    }

    public void listarBibliotecas() {
        List<Biblioteca> bibliotecas = bibliotecaController.listarBibliotecas();
        System.out.println("\n- bibliotecas -");
        System.out.println();
        for (int i = 0; i < bibliotecas.size(); i++) {
            System.out.println("ID: " + bibliotecas.get(i).getIdBiblioteca() +
                    " | biblioteca: " + bibliotecas.get(i).getNomeBiblioteca());
        }
        System.out.println();
    }


}
