package service;
import entities.Disco;
import java.util.List;
import java.util.stream.IntStream;

public class ListarDiscosService {
    public void listarDiscos(List<Disco> discos){
        if(discos != null && !discos.isEmpty()){
            System.out.println("------------------------------");
            System.out.println("Discos: ");
            discos.forEach(d -> {
                System.out.println("Titulo: " + d.getTitulo() + ", Ano lançamento: " + d.getAnoDeLancamento());
                System.out.println("Faixas:");
                if(d.getFaixas() != null && !d.getFaixas().isEmpty()){
                    IntStream.range(0, d.getFaixas().size()).forEach(f -> System.out.println(f + "- " + d.getFaixas().get(f).getName()));
                }
            });
            System.out.println("------------------------------");
        } else {
            throw new IndexOutOfBoundsException("Não tem discos na lista!!! Adicione para visualizar.");
        }
    }
}
