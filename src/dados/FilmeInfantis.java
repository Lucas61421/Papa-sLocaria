package dados;

public class FilmeInfantis extends Filme {

    public FilmeInfantis(String titulo, String genero, String sinopse, int classificacaoIndicativa, int anoLancamento, boolean dublado, boolean disponivel) {
        super(titulo, genero, sinopse, classificacaoIndicativa, anoLancamento, dublado, disponivel);
    }

    @Override
    public boolean podeSerAlugadoPor(int idadeCliente) {
        return true;
    }
}
