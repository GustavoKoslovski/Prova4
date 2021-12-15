package View;
import Controller.GeneroController;
import Controller.LivroController;
import DAO.*;
import Model.Biblioteca;
import Model.Genero;

import java.util.Scanner;

public class Menu {


    BibliotecaDAO bibliotecaDAO = new BibliotecaDAO();
    LivroDAO livroDAO = new LivroDAO();
    GeneroDAO generoDAO = new GeneroDAO();
    BibliotecaView bibliotecaView = new BibliotecaView();
    LivroView livroView = new LivroView();
    GeneroView generoView = new GeneroView();
    Scanner input = new Scanner(System.in);

    public void menuPrincipal() {

        while (true) {

            System.out.println("1 > Cadastrar biblioteca");
            System.out.println("2 > Cadastrar genero");
            System.out.println("3 > Editar genero");
            System.out.println("4 > Cadastrar livro");
            System.out.println("5 > Listar livros por biblioteca");
            System.out.println("6 > listar livros por genero");

            int escolha = input.nextInt();
            switch (escolha) {

                case 1:
                    bibliotecaDAO.criarTabelaBiblioteca();
                    bibliotecaView.cadastrarBiblioteca();
                    this.menuPrincipal();
                    break;
                case 2:
                    generoDAO.criarTabelaGenero();
                    generoView.cadastrarGenero();
                    this.menuPrincipal();
                    break;
                case 3:
                    generoView.editarGenero();
                    this.menuPrincipal();
                    break;
                case 4:
                    livroDAO.criarTabelaLivros();
                    livroView.cadastrarLivro();
                    this.menuPrincipal();
                    break;
                case 5:
                    livroView.listarLivrosPorBiblioteca();
                    break;
                case 6:
                    livroView.listarLivrosPorGenero();
                    break;
            }
        }
    }
}
