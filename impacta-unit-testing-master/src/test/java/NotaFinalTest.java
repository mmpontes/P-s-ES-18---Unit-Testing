import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(NotaFinal.class)
public class NotaFinalTest {

    //region Uma Nota ( 5 Testes)

    @Test
    public void notaComValorPositivo(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "7.0 - Aprovado";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(7);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void notaComValorPositivoMaiorque10(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "Nota com valor maior que 10, favor verificar !";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(12);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void notaComValorNegativo(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "Nota com valor negativo, favor verificar !";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(-7);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void notaComValorZero(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "0.0 - Reprovado";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(0);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void notaComValorPositivoReprovado(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "2.0 - Reprovado";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(2);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void notaComValorPositivoRecuperacao(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "6.5 - Recuperação";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(6.5);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    //endregion

    //region Mais De Uma Nota ( 5 Testes)

    @Test
    public void duasNotasComValoresPositivo(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "8.5 - Aprovado";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(9);
        atual = notaFinal.mediaFinal(8);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void duasNotasComUmaNotaNegativo(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "Nota com valor negativo, favor verificar !";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(8);
        atual = notaFinal.mediaFinal(-7);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void duasNotasComUmaNotaZero(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "4.5 - Reprovado";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(9);
        atual = notaFinal.mediaFinal(0);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void duasNotasComUmaNotaMaiorQueDez(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "Nota com valor maior que 10, favor verificar !";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(7);
        atual = notaFinal.mediaFinal(12);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    @Test
    public void variasNotasComValoresMisturados(){
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        String esperado = "6.25 - Recuperação";
        String atual = "";

        //Act
        atual = notaFinal.mediaFinal(3);
        atual = notaFinal.mediaFinal(9);
        atual = notaFinal.mediaFinal(6);
        atual = notaFinal.mediaFinal(7);

        //Assert
        Assert.assertEquals(esperado, atual);
    }

    //endregion

    //region Teste com PowerMockito ( 5 Testes)

    @Test
    public void NotasComValoresPositivoMediaAprovado() throws Exception{
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        final String METHOD="getNotaFinal";
        final String METHOD2="getQtddNotas";
        NotaFinal spy = PowerMockito.spy(notaFinal);
        PowerMockito.when(spy, METHOD).thenReturn((Double) 33.00);
        PowerMockito.when(spy, METHOD2).thenReturn((int) 4);

        String esperado = "8.25 - Aprovado";
        String atual = "";

        //Act
        atual = spy.getSituacao();

        //Assert
        Assert.assertEquals(esperado, atual);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD2);
    }

    @Test
    public void NotasComValoresPositivoMediaRecureracao() throws Exception{
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        final String METHOD="getNotaFinal";
        final String METHOD2="getQtddNotas";
        NotaFinal spy = PowerMockito.spy(notaFinal);
        PowerMockito.when(spy, METHOD).thenReturn((Double) 27.00);
        PowerMockito.when(spy, METHOD2).thenReturn((int) 4);

        String esperado = "6.75 - Recuperação";
        String atual = "";

        //Act
        atual = spy.getSituacao();

        //Assert
        Assert.assertEquals(esperado, atual);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD2);
    }

    @Test
    public void NotasComValoresPositivoMediaReprovado() throws Exception{
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        final String METHOD="getNotaFinal";
        final String METHOD2="getQtddNotas";
        NotaFinal spy = PowerMockito.spy(notaFinal);
        PowerMockito.when(spy, METHOD).thenReturn((Double) 20.00);
        PowerMockito.when(spy, METHOD2).thenReturn((int) 4);

        String esperado = "5.0 - Reprovado";
        String atual = "";

        //Act
        atual = spy.getSituacao();

        //Assert
        Assert.assertEquals(esperado, atual);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD2);
    }

    @Test
    public void NotasComValoresPositivoMediaZero() throws Exception{
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        final String METHOD="getNotaFinal";
        final String METHOD2="getQtddNotas";
        NotaFinal spy = PowerMockito.spy(notaFinal);
        PowerMockito.when(spy, METHOD).thenReturn((Double) 0.00);
        PowerMockito.when(spy, METHOD2).thenReturn((int) 7);

        String esperado = "0.0 - Reprovado";
        String atual = "";

        //Act
        atual = spy.getSituacao();

        //Assert
        Assert.assertEquals(esperado, atual);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD2);
    }

    @Test
    public void NotasComValoresPositivoMediaMaiorQueDez() throws Exception{
        //Arrange
        NotaFinal notaFinal = new NotaFinal();
        final String METHOD="getNotaFinal";
        final String METHOD2="getQtddNotas";
        NotaFinal spy = PowerMockito.spy(notaFinal);
        PowerMockito.when(spy, METHOD).thenReturn((Double) 35.00);
        PowerMockito.when(spy, METHOD2).thenReturn((int) 3);

        String esperado = "Nota com valor maior que 10, favor verificar !";
        String atual = "";

        //Act
        atual = spy.getSituacao();

        //Assert
        Assert.assertEquals(esperado, atual);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD);

        PowerMockito.verifyPrivate(spy,
                Mockito.times(1))
                .invoke(METHOD2);
    }
    //endregion
}
