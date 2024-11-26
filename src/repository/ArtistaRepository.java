package repository;

import entities.Artista;
import entities.Disco;
import entities.Faixa;

import java.util.ArrayList;
import java.util.List;

public class ArtistaRepository {
    private final List<Artista> artistasArmazenados = new ArrayList<>();

    public List<Artista> getArtistasArmazenados() {
        return artistasArmazenados;
    }

    public void armazenarArtistas(Artista artista){
        this.artistasArmazenados.add(artista);
    }
    public List<Artista> listarArtistasArmazenados(){
        return this.artistasArmazenados;
    }



}
