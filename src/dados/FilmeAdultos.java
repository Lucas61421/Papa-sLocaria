package dados;

public class FilmeAdultos extends Filme {

    public FilmeAdultos(String titulo, String genero, String sinopse, int classificacaoIndicativa, int anoLancamento, boolean dublado, boolean disponivel) {
        super(titulo, genero, sinopse, classificacaoIndicativa, anoLancamento, dublado, disponivel);
    }

    @Override
    public boolean podeSerAlugadoPor(int idadeCliente) {
        return idadeCliente >= 18;
    }
}