package entities;
import java.time.Year;
import java.util.List;
import java.util.stream.IntStream;

public class Disco {
    private String titulo;
    private Year anoDeLancamento;
    private List<Faixa> faixas;

    public Disco(){};

    public Disco(String titulo, Year anoDeLancamento, List<Faixa> faixas) {
        this.titulo = titulo;
        this.anoDeLancamento = anoDeLancamento;
        this.faixas = faixas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Year getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(Year anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public List<Faixa> getFaixas() {
        return faixas;
    }

    public void setFaixas(List<Faixa> faixas) {
        this.faixas = faixas;
    }

    @Override
    public String toString() {
        return "Disco{" +
                "titulo='" + titulo + '\'' +
                ", anoDeLancamento=" + anoDeLancamento +
                ", faixas=" + faixas +
                '}';
    }
}
