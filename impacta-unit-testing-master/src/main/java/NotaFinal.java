public class NotaFinal {
    private double notaFinal;
    private double mediaFinal;
    private int qtddNotas;
    private String situacao;

    public NotaFinal() { iniciaNota(); }

    private void iniciaNota() { notaFinal = 0; }

    private int getQtddNotas() {
        return qtddNotas;
    }

    private void setNotaFinal(double nota) {
        this.notaFinal = nota;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public String mediaFinal(double nota) {
        if (nota >= 0) {
            if (nota >= 0 && nota <= 10) {
                setNotaFinal(getNotaFinal() + nota);
                qtddNotas++;
            }
            else
                setNotaFinal(nota);
        }
        else
            setNotaFinal(nota);
        return getSituacao();
    }

    public String getSituacao() {
        mediaFinal = getNotaFinal();
        if (mediaFinal >= 0) {
            int qtd = getQtddNotas();
            if (qtd >= 1) {
                mediaFinal = mediaFinal / qtd;
            }
            if (mediaFinal < 6) {
                situacao = Double.toString(mediaFinal) + " - " + "Reprovado";
            } else if (mediaFinal >= 6 && mediaFinal < 7) {
                situacao = Double.toString(mediaFinal) + " - " + "Recuperação";
            } else if (mediaFinal >= 7 && mediaFinal <= 10) {
                situacao = Double.toString(mediaFinal) + " - " + "Aprovado";
            } else
                situacao = "Nota com valor maior que 10, favor verificar !";
        } else
            situacao = "Nota com valor negativo, favor verificar !";
        return situacao;
    }
}