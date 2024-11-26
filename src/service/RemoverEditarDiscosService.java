package service;

import repository.DiscoRepository;

import java.time.Year;
import java.util.Scanner;
import java.util.stream.IntStream;

public class RemoverEditarDiscosService {
    public void removerOuEditar(Scanner sc, DiscoRepository discoRepository){
        if(!discoRepository.listarDiscosArmazenados().isEmpty()){
            System.out.println("""
                ------------------------------
                Remover ou editar Disco
                
                Digite a opção que deseja:
                
                1- Remover um disco.
                2- Editar um disco.
                """);

            int opcaoEscolhida = sc.nextInt();

            switch (opcaoEscolhida){
                case 1:
                    IntStream.range(0, discoRepository.getDiscosArmazenados().size()).forEach(i -> System.out.println(i + "- " +
                            "Titulo: " + discoRepository.getDiscosArmazenados().get(i).getTitulo()
                    ));
                    System.out.println("Digite numero do disco você deseja remover?");
                    int numeroDiscoRemovido = sc.nextInt();
                    discoRepository.getDiscosArmazenados().remove(numeroDiscoRemovido);
                    System.out.println("Disco removido com sucesso!!");
                    break;
                case 2:
                    IntStream.range(0, discoRepository.getDiscosArmazenados().size()).forEach(i -> System.out.println(i + "- " +
                            "Titulo: " + discoRepository.getDiscosArmazenados().get(i).getTitulo() + '\n' +
                            "Ano lançamento: " + discoRepository.getDiscosArmazenados().get(i).getAnoDeLancamento()
                    ));
                    System.out.println("Digite numero do disco você deseja editar?");
                    int numeroDiscoEditado = sc.nextInt();
                    System.out.println("""
                        Você deseja editar oque no disco?
                        
                        1- Titulo.
                        2- Ano de lançamento.
                        """);
                    int opcaoEscolhidaEditarDisco = sc.nextInt();

                    if(opcaoEscolhidaEditarDisco == 1){
                        System.out.println("Digite o novo o titulo do disco: ");
                        sc.nextLine();
                        discoRepository.getDiscosArmazenados().get(numeroDiscoEditado).setTitulo(sc.nextLine());
                        System.out.println("Titulo do disco editado com sucesso!!");
                    } else if (opcaoEscolhidaEditarDisco == 2) {
                        System.out.println("Digite a nova data de lancamento do disco");
                        discoRepository.getDiscosArmazenados().get(numeroDiscoEditado).setAnoDeLancamento(Year.of(sc.nextInt()));
                        System.out.println("Ano de lançamento do disco editado com sucesso!!");
                    }
            }
        } else {
            System.out.println("Erro!! Não existe discos para serem removidos ou editados!!");
        }

        System.out.println("------------------------------");
    }
}
