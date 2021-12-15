package View;

import Controller.GeneroController;
import Model.Genero;

import java.util.List;
import java.util.Scanner;

public class GeneroView {

    GeneroController generoController = new GeneroController();
    Scanner input = new Scanner(System.in);

    public void cadastrarGenero() {
        Genero genero = new Genero();
        Scanner input = new Scanner(System.in);

        System.out.print("Nome do Genero: ");
        genero.setNomeGenero(input.nextLine());

        generoController.cadastrarGenero(genero);
        System.out.println("\n" + "["+ genero.getNomeGenero() + "] cadastrado!");
    }

    public void editarGenero(){
        this.listarGeneros();
        System.out.print("Escolha o genero a ser editado a partir do ID: ");
        Genero generoSelecionada = generoController.selecionarGenero(Long.parseLong(input.nextLine()));
        String aux;
        System.out.print("Novo nome: ");
        aux = input.nextLine();
        if (aux != "") {
            generoSelecionada.setNomeGenero(aux);
        }
        generoController.editarGenero(generoSelecionada);
    }


    public void listarGeneros() {
        List<Genero> generos = generoController.listarGeneros();
        System.out.println("\n- Generos -");
        System.out.println();
        for (int i = 0; i < generos.size(); i++) {
            System.out.println("ID: " + generos.get(i).getIdGenero() +
                    " | Genero: " + generos.get(i).getNomeGenero());
        }
        System.out.println();
    }

}