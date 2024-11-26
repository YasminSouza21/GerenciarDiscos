package service;
import entities.Artista;
import java.util.List;
import java.util.stream.IntStream;

public class ListarArtistasService {
    public void listarArtistas(List<Artista> artistas){
        if(artistas != null && !artistas.isEmpty()){
            System.out.println("------------------------------");
            System.out.println("Artistas");
            IntStream.range(0, artistas.size()).forEach(i -> System.out.println(i + "- " + artistas.get(i).getNome() + ", Genero Musical: " +
                    artistas.get(i).getGenerosMusicais()));
            System.out.println("------------------------------");
        } else {
            throw new IndexOutOfBoundsException("Não tem artistas na lista!!! Adicione para visualizar.");
        }
    }
}
