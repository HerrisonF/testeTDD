package br.com.alura.leilao.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class LeilaoTest {

    @Test
    public void testGetDescricao() {
        //Criando o cenário
        Leilao leilao = new Leilao("Console");
        //executar uma ação
        String descricaoDevolvida = leilao.getDescricao();
        //teste o resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void getMaiorLanceQuandoRecebeApenasUmLanceDevolveMaiorLance() {
        Leilao console = new Leilao("Console");

        console.propoe(new Lance(new Usuario("Teste1"), 200.0));

        double maiorLance = console.getMaiorLance();

        assertEquals(200.0, maiorLance, 0.0001);
    }

    @Test
    public void getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemCrescenteDevolveMaiorLance(){
        Leilao computador = new Leilao("Computador");
        computador.propoe(new Lance(new Usuario("Teste2"), 100.0));
        computador.propoe(new Lance(new Usuario("Teste22"), 200.0));

        double maiorLanceComputador = computador.getMaiorLance();

        assertEquals(200.0, maiorLanceComputador, 0.0001);
    }

    @Test
    public void getMaiorLanceQuandoRecebeMaisDeUmLanceEmOrdemDecrescenteDevolveMaiorLance(){
        Leilao carro = new Leilao("Carro");
        carro.propoe(new Lance(new Usuario("Teste3"), 10000.0));
        carro.propoe(new Lance(new Usuario("Teste33"), 9000.0));

        double maiorLanceCarro = carro.getMaiorLance();

        assertEquals(10000.0, maiorLanceCarro, 0.0001);
    }

}