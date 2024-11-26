import excecoes.ItemNaoCadastradoException;
import repository.ArtistaRepository;
import repository.DiscoRepository;
import service.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DiscoRepository armazenarDiscos = new DiscoRepository();
        ArtistaRepository armazenarArtistas = new ArtistaRepository();
        CadastrarArtistaService cadastrarArtista = new CadastrarArtistaService();
        CadastrarDiscoService cadastrarDisco = new CadastrarDiscoService();
        AssociarArtistasADiscosService associarArtistasADiscos = new AssociarArtistasADiscosService();
        RemoverEditarDiscosService removerEditarDiscos = new RemoverEditarDiscosService();
        RemoverEditarArtistasService removerEditarArtistas = new RemoverEditarArtistasService();
        ListarDiscosService listarDiscos = new ListarDiscosService();
        ListarArtistasService listarArtistas = new ListarArtistasService();
        int interacaoMenu = 0;

        System.out.println("""
                1- Cadastrar novo disco
                2- Cadastrar novo artista
                3- Associar artistas a discos
                4- Listar Discos
                5- Litar Artistas
                6- Listar Associações entre Artistas e Discos
                7- Editar ou Remover Discos
                8- Editar ou Remover Artistas
                9- Sair
                """);

        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Digite a opção que deseja: ");
            int opcaoEscolhida = sc.nextInt();

            do {
                switch (opcaoEscolhida) {
                    case 1:
                        try {
                            armazenarDiscos.armazenarDisco(cadastrarDisco.cadastrarDisco(sc, armazenarDiscos.listarDiscosArmazenados()));
                        } catch (ItemNaoCadastradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try {
                            armazenarArtistas.armazenarArtistas(cadastrarArtista.cadastrarArtistas(sc, armazenarArtistas.listarArtistasArmazenados()));
                        } catch (ItemNaoCadastradoException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        associarArtistasADiscos.associarArtistaADisco(armazenarArtistas.listarArtistasArmazenados(), armazenarDiscos.listarDiscosArmazenados(), sc);
                        break;
                    case 4:
                        try {
                            listarDiscos.listarDiscos(armazenarDiscos.listarDiscosArmazenados());
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        try {
                            listarArtistas.listarArtistas(armazenarArtistas.listarArtistasArmazenados());
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 6:
                        associarArtistasADiscos.listarAssociacoes(armazenarArtistas.listarArtistasArmazenados());
                        break;
                    case 7:
                        removerEditarDiscos.removerOuEditar(sc, armazenarDiscos);
                        break;
                    case 8:
                        removerEditarArtistas.removerOuEditar(sc, armazenarArtistas);
                        break;
                    case 9:
                        Thread.sleep(5);
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Esta opcao nao existe");
                        Thread.sleep(5);
                        System.out.println("Saindo...");
                        break;
                }
                interacaoMenu++;
                if (opcaoEscolhida <= 8 && interacaoMenu >= 1) {
                    System.out.println("Digite a opcao que deseja do menu: ");
                    System.out.println("""
                            1- Cadastrar novo disco
                            2- Cadastrar novo artista
                            3- Associar artistas a discos
                            4- Listar Discos
                            5- Litar Artistas
                            6- Listar Associações entre Artistas e Discos
                            7- Editar ou Remover Discos
                            8- Editar ou Remover Artistas
                            9- Sair
                            """);
                    opcaoEscolhida = sc.nextInt();
                }
            } while (opcaoEscolhida < 9);
        } catch (InputMismatchException e) {
            System.out.println("ERRO!! Apenas digite valores numéricos!!");
        }
    }
}
