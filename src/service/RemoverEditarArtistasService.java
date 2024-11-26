package service;

import entities.enums.GenerosMusicais;
import repository.ArtistaRepository;

import java.util.Scanner;
import java.util.stream.IntStream;

public class RemoverEditarArtistasService {

    public void removerOuEditar(Scanner sc, ArtistaRepository artistaRepository) {
        System.out.println("""
                ------------------------------
                Remover ou editar Artista
                
                Escolha a opção que deseja:
                
                1- Editar nome.
                2- Editar genero musical.
                3- Remover artista.
                """);

        int opcaoEscolhida = sc.nextInt();

        switch (opcaoEscolhida) {
            case 1:
                System.out.println("Digite o numero do nome do artista que deseja editar o nome: ");
                IntStream.range(0, artistaRepository.listarArtistasArmazenados().size()).forEach(i -> System.out.println(i + "- " + artistaRepository.listarArtistasArmazenados().get(i).getNome()));
                int artistaNomeEditado = sc.nextInt();
                System.out.println("Digite o novo nome: ");
                sc.nextLine();
                artistaRepository.listarArtistasArmazenados().get(artistaNomeEditado).setNome(sc.nextLine());
                break;
            case 2:
                System.out.println("Digite o numero do nome do artista que deseja editar o genero musical: ");
                IntStream.range(0, artistaRepository.listarArtistasArmazenados().size()).forEach(i -> System.out.println(i + "- " + artistaRepository.listarArtistasArmazenados().get(i).getNome() + '\n'
                        + "Genero Musical: " + artistaRepository.listarArtistasArmazenados().get(i).getGenerosMusicais()));
                int artistaGeneroEditado = sc.nextInt();

                System.out.println("Escolha o numero do genero musical que deseja mudar: ");
                GenerosMusicais generoMusicalAtual = artistaRepository.listarArtistasArmazenados().get(artistaGeneroEditado).getGenerosMusicais();
                for (GenerosMusicais generosMusicais : GenerosMusicais.values()) {
                    int index = generosMusicais.ordinal();
                    System.out.println(index + "- " + generosMusicais.name());
                }
                int artistaGeneroNovo = sc.nextInt();

                GenerosMusicais generoMusicalEscolhido = null;

                if (generoMusicalEscolhido != generoMusicalAtual) {
                    while (generoMusicalEscolhido != generoMusicalAtual) {
                        switch (artistaGeneroNovo) {
                            case 0:
                                generoMusicalEscolhido = GenerosMusicais.POP;
                                break;
                            case 1:
                                generoMusicalEscolhido = GenerosMusicais.ROCK;
                                break;
                            case 2:
                                generoMusicalEscolhido = GenerosMusicais.FUNK;
                                break;
                            case 3:
                                generoMusicalEscolhido = GenerosMusicais.ROMANCE;
                                break;
                            case 4:
                                generoMusicalEscolhido = GenerosMusicais.SERTANEJO;
                                break;
                            case 5:
                                generoMusicalEscolhido = GenerosMusicais.PAGODE;
                                break;
                            default:
                                System.out.println("Opção invalida :(");
                        }

                        if (generoMusicalAtual == generoMusicalEscolhido) {
                            System.out.println("O genero que voce escolheu é o mesmo, escolha um diferente.");
                        }
                    }
                }
                break;
            case 3:
                System.out.println("Digite o nome do artista você deseja remover: ");
                IntStream.range(0, artistaRepository.listarArtistasArmazenados().size()).forEach(i -> System.out.println(i + "- " + artistaRepository.listarArtistasArmazenados().get(i).getNome()));
                artistaRepository.listarArtistasArmazenados().remove(sc.nextInt());
                break;
        }
        System.out.println("------------------------------");
    }
}
