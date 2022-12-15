package org.araujo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EntregadorTest {

    public static final Endereco endereco = new Endereco(
        "36090-300",
        "Rua Martins Barbosa",
        "300",
        null,
        "Benfica",
        "Juiz de Fora",
        "MG"
    );

    @Test
    void deveNotificarUmEntregador() {
        Empresa empresa = new Empresa("Empresa", endereco);
        Entregador entregador = new Entregador("Entregador 1");
        entregador.vincular(empresa);
        empresa.chamarEntregadores();
        assertEquals("Entregador 1, nova solicitação Empresa{nome='Empresa'endereco=Endereco{cep='36090-300', logradouro='Rua Martins Barbosa', numero='300', complemento='null', bairro='Benfica', cidade='Juiz de Fora', uf='MG'}}", entregador.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunos() {
        Empresa empresa = new Empresa("Empresa", endereco);
        Entregador entregador1 = new Entregador("Entregador 1");
        Entregador entregador2 = new Entregador("Entregador 2");
        entregador1.vincular(empresa);
        entregador2.vincular(empresa);
        empresa.chamarEntregadores();
        assertEquals("Entregador 1, nova solicitação Empresa{nome='Empresa'endereco=Endereco{cep='36090-300', logradouro='Rua Martins Barbosa', numero='300', complemento='null', bairro='Benfica', cidade='Juiz de Fora', uf='MG'}}", entregador1.getUltimaNotificacao());
        assertEquals("Entregador 2, nova solicitação Empresa{nome='Empresa'endereco=Endereco{cep='36090-300', logradouro='Rua Martins Barbosa', numero='300', complemento='null', bairro='Benfica', cidade='Juiz de Fora', uf='MG'}}", entregador2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarAluno() {
        Empresa empresa = new Empresa("Empresa", endereco);
        Entregador entregador1 = new Entregador("Entregador 1");
        empresa.chamarEntregadores();
        assertEquals(null, entregador1.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunoTurmaA() {
        Empresa empresaA = new Empresa("Empresa A", endereco);
        Empresa empresaB = new Empresa("Empresa B", endereco);
        Entregador entregador1 = new Entregador("Entregador 1");
        Entregador entregador2 = new Entregador("Entregador 2");
        entregador1.vincular(empresaA);
        entregador2.vincular(empresaB);
        empresaA.chamarEntregadores();
        assertEquals("Entregador 1, nova solicitação Empresa{nome='Empresa A'endereco=Endereco{cep='36090-300', logradouro='Rua Martins Barbosa', numero='300', complemento='null', bairro='Benfica', cidade='Juiz de Fora', uf='MG'}}", entregador1.getUltimaNotificacao());
        assertEquals(null, entregador2.getUltimaNotificacao());
    }
}