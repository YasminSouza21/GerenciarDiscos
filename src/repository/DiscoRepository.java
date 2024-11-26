package repository;

import entities.Disco;
import entities.Faixa;

import java.util.ArrayList;
import java.util.List;

public class DiscoRepository {
    private List<Disco> discosArmazenados = new ArrayList<>();

    public void armazenarDisco(Disco disco){
        this.discosArmazenados.add(disco);
    }

    public List<Disco> listarDiscosArmazenados(){
        return this.discosArmazenados;
    }

    public List<Disco> getDiscosArmazenados() {
        return discosArmazenados;
    }
}
