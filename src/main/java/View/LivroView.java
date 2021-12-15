package View;

import Controller.BibliotecaController;
import Controller.LivroController;
import Model.Biblioteca;
import Model.Livro;

import java.util.List;
import java.util.Scanner;

public class LivroView {

    LivroController livroController = new LivroController();
    Scanner input = new Scanner(System.in);
    GeneroView generoView = new GeneroView();
    BibliotecaView bibliotecaView = new BibliotecaView();

    public void cadastrarLivro() {
        Livro livro = new Livro();

        Scanner input = new Scanner(System.in);
        System.out.print("Nome do livro: ");
        livro.setNomeLivro(input.nextLine());

        generoView.listarGeneros();
        System.out.print("ID do Genero: ");
        livro.setIdGenero(Long.parseLong(input.nextLine()));


        System.out.println("\nProduto adicionado a Categoria Escolhida.");
        bibliotecaView.listarBibliotecas();

        System.out.print("ID da biblioteca: ");
        livro.setIdBiblioteca(Long.parseLong(input.nextLine()));

        livroController.cadastrarLivro(livro);
        System.out.println("\n" + "[" + livro.getNomeLivro() + "] cadastrado!");

    }



    public void listarLivrosPorGenero(){
        generoView.listarGeneros();
        System.out.print("Digite o ID do Genero que deseja listar: ");
        Long idGenero = input.nextLong();

        List<Livro> livros = livroController.listarProdutosPorGenero(idGenero);
        System.out.println();
        System.out.println("---Produtos do Genero " + idGenero +"--------");
        System.out.println();
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("Livro : " + livros.get(i).getNomeLivro()); ;
        }
        System.out.println();
    }


    public void listarLivrosPorBiblioteca(){

        bibliotecaView.listarBibliotecas();
        System.out.print("Digite o ID da biblioteca que deseja listar: ");
        Long idBiblioteca = input.nextLong();

        List<Livro> livros = livroController.listarLivroPorBiblioteca(idBiblioteca);
        System.out.println();
        System.out.println("-Livros desta biblioteca " + idBiblioteca +"--------");
        System.out.println();
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("Livro : " + livros.get(i).getNomeLivro()); ;
        }
        System.out.println();
    }



    public void listarLivros() {

        List<Livro> livros = livroController.listarLivros();
        System.out.println();
        for (int i = 0; i < livros.size(); i++) {
            System.out.println("ID: " + livros.get(i).getIdLivro() + " | Nome: " + livros.get(i).getNomeLivro());
        }
        System.out.println();
    }
}
