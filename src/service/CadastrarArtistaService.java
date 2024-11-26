package service;

import entities.Artista;
import entities.enums.GenerosMusicais;
import excecoes.ItemNaoCadastradoException;
import repository.ArtistaRepository;

import java.util.List;
import java.util.Scanner;

public class CadastrarArtistaService {
    public Artista cadastrarArtistas(Scanner sc, List<Artista> artistas) {
        System.out.println("------------------------------");
        System.out.println("Castrado Artista");
        System.out.println("Digite o nome do Artista: ");
        sc.nextLine();
        String nomeArtista = sc.nextLine();

        if (!artistas.isEmpty()) {
            for (Artista artistasContidosLista : artistas) {
                if (artistasContidosLista.getNome().contains(nomeArtista)) {
                    throw new ItemNaoCadastradoException("Falha no cadastro, já existe este artista cadastrado!!");
                }
            }
        }

        System.out.println("Escolha o genero de musica: ");
        for (GenerosMusicais generosMusicais : GenerosMusicais.values()) {
            int index = generosMusicais.ordinal();
            System.out.println(index + ": " + generosMusicais);
        }

        System.out.println("Digite o numero da opção que deseja: ");
        int opcaoGeneroMusical = sc.nextInt();
        GenerosMusicais generoMusical = null;

        switch (opcaoGeneroMusical) {
            case 0:
                generoMusical = GenerosMusicais.POP;
                break;
            case 1:
                generoMusical = GenerosMusicais.ROCK;
                break;
            case 2:
                generoMusical = GenerosMusicais.FUNK;
                break;
            case 3:
                generoMusical = GenerosMusicais.ROMANCE;
                break;
            case 4:
                generoMusical = GenerosMusicais.SERTANEJO;
                break;
            case 5:
                generoMusical = GenerosMusicais.PAGODE;
                break;
            default:
                System.out.println("Opção invalida :(");
        }


        System.out.println("------------------------------");
        Artista artista;
        return artista = new Artista(nomeArtista, generoMusical);
    }
}
