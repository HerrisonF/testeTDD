package br.com.alura.leilao.model;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LeilaoTest {

    public static final double DELTA = 0.0001;
    private final Leilao CONSOLE = new Leilao("Console");
    private final Usuario USER1 = new Usuario("user1");

    @Test
    public void deve_DevolverDescricao_QuandoRecebeDescricao() {
        //executar uma ação
        String descricaoDevolvida = CONSOLE.getDescricao();
        //teste o resultado esperado
        assertEquals("Console", descricaoDevolvida);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeApenasUmLance() {

        CONSOLE.propoe(new Lance(USER1, 200.0));

        double maiorLance = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLance, DELTA);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeApenasUmLance() {

        CONSOLE.propoe(new Lance(USER1, 100.0));

        double menorLance = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLance, DELTA);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){
        CONSOLE.propoe(new Lance(USER1, 100.0));
        CONSOLE.propoe(new Lance( new Usuario("user2"), 200.0));

        double maiorLanceComputador = CONSOLE.getMaiorLance();

        assertEquals(200.0, maiorLanceComputador, DELTA);
    }

    @Test
    public void deve_DevolverMaiorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){
        CONSOLE.propoe(new Lance(USER1, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("user2"), 9000.0));

        double maiorLanceCarro = CONSOLE.getMaiorLance();

        assertEquals(10000.0, maiorLanceCarro, DELTA);
    }


    @Test
    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemCrescente(){

        CONSOLE.propoe(new Lance(USER1, 100.0));
        CONSOLE.propoe(new Lance(new Usuario("user2"), 200.0));

        double menorLanceComputador = CONSOLE.getMenorLance();

        assertEquals(100.0, menorLanceComputador, DELTA);
    }

    @Test
    public void deve_DevolverMenorLance_QuandoRecebeMaisDeUmLanceEmOrdemDecrescente(){

        CONSOLE.propoe(new Lance(USER1, 10000.0));
        CONSOLE.propoe(new Lance(new Usuario("user2"), 9000.0));

        double menorLanceCarro = CONSOLE.getMenorLance();

        assertEquals(9000.0, menorLanceCarro, DELTA);
    }

    @Test
    public void deve_DevolverTresMaioresLances_QuandoRecebeExatosTresLances(){
        CONSOLE.propoe(new Lance(USER1, 200.0));
        CONSOLE.propoe(new Lance(USER1, 300.0));
        CONSOLE.propoe(new Lance(USER1, 400.0));

        List<Lance> tresMaioresLancesDevolvidos = CONSOLE.tresMaioresLances();

        assertEquals(3, tresMaioresLancesDevolvidos.size());
        assertEquals(400.0, tresMaioresLancesDevolvidos.get(0).getValor(), DELTA);
        assertEquals(300.0, tresMaioresLancesDevolvidos.get(1).getValor(), DELTA);
        assertEquals(200.0, tresMaioresLancesDevolvidos.get(2).getValor(), DELTA);

    }


}