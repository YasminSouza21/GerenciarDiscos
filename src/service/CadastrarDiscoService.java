package service;

import entities.Disco;
import entities.Faixa;
import excecoes.ItemNaoCadastradoException;

import java.time.Year;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CadastrarDiscoService {

    public Disco cadastrarDisco(Scanner sc, List<Disco> discos) {
            int interacao = 0;
            String opcao = "sim";

            System.out.println("------------------------------");
            System.out.println("Castrado disco");

            System.out.println("Digite o nome do titulo do disco: ");
            sc.nextLine();
            String nomeDisco = sc.nextLine();

            if (!discos.isEmpty()) {
                for (Disco discoContidosLista : discos) {
                    if (discoContidosLista.getTitulo().contains(nomeDisco)) {
                        throw new ItemNaoCadastradoException("Falha no cadastro, já existe este disco cadastrado!!");
                    }
                }
            }

            System.out.println("Digite o ano de lançamento do disco: ");
            int anoLancamentoDisco = sc.nextInt();

            Disco disco = new Disco(nomeDisco, Year.of(anoLancamentoDisco), new ArrayList<>());

            while (!opcao.equals("nao")) {
                System.out.println("Digite o nome de uma faixa que tem no disco: ");
                if(interacao == 0){
                    sc.nextLine();
                }
                interacao++;
                String nomeFaixa = sc.nextLine();
                disco.getFaixas().add(new Faixa(nomeFaixa));
                System.out.println("Deseja digitar mais uma faixa? (sim/nao)");
                opcao = sc.nextLine();
            }

            System.out.println("Cadastro realizado com Sucesso!!");
            System.out.println("------------------------------");
            return disco;
        }
}
