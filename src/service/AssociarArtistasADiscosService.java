package service;

import entities.Artista;
import entities.Disco;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class AssociarArtistasADiscosService {
    private final Map<Artista, Disco> discoArtistas = new HashMap<>();

    public Map<Artista, Disco> getDiscoArtistas() {
        return discoArtistas;
    }

    public void associarArtistaADisco(List<Artista> artistas, List<Disco> discos, Scanner sc){
        System.out.println("------------------------------");
        System.out.println("Associar Aristas a discos");
        System.out.println("Deseja associar artistas a algum disco? (0 = nao, 1 = sim)");
        int opniao = sc.nextInt();

        if(opniao == 1){
            IntStream.range(0, artistas.size()).forEach(i -> {
                System.out.println(i + " - " + artistas.get(i).getNome());
            });
            System.out.println("Digite o numero do artista deseja vincular a um disco: ");
            int artistaEscolhido = sc.nextInt();
            IntStream.range(0, discos.size()).forEach(i -> {
                System.out.println(i + " - " + discos.get(i).getTitulo());
            });
            System.out.println("Agora digite o numero do disco que deseja associar ao artista: ");
            int discoEscolhido = sc.nextInt();
            discoArtistas.put(artistas.get(artistaEscolhido),  discos.get(discoEscolhido));
        }
        System.out.println("------------------------------");
    }

    public void listarAssociacoes(List<Artista> artistas){
        if(!discoArtistas.isEmpty()) {
            discoArtistas.forEach((k, v) -> {
                System.out.println("Artista: " + k.getNome() + ", discos: " + v.getTitulo());

                if (v.getFaixas() != null && !v.getFaixas().isEmpty()) {
                    System.out.println("Faixa deste disco:");
                    IntStream.range(0, v.getFaixas().size()).forEach(i -> System.out.println(i + "- " + v.getFaixas().get(i).getName()));
                } else {
                    System.out.println("Não existe faixa nesse disco");
                }
            });
        } else {
            System.out.println("Não existe associações armazenadas!!");
        }
    }
}
