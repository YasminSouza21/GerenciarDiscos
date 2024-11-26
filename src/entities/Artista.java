package entities;

import entities.enums.GenerosMusicais;

import java.util.List;

public class Artista {
    private String nome;
    private GenerosMusicais generosMusicais;
    private List<Disco> discos;

    public Artista(){}

    public Artista(String nome, GenerosMusicais generosMusicais) {
        this.nome = nome;
        this.generosMusicais = generosMusicais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public GenerosMusicais getGenerosMusicais() {
        return generosMusicais;
    }

    public void setGenerosMusicais(GenerosMusicais generosMusicais) {
        this.generosMusicais = generosMusicais;
    }

    public List<Disco> getDiscos() {
        return discos;
    }

    public void setDiscos(List<Disco> discos) {
        this.discos = discos;
    }
}
