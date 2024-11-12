package dados;

public class Filme {
	private String titulo;
	private String genero;
	private String sinopse;
	private int classificacaoIndicativa;
	private int anoLancamento;
	private boolean dublado;
	private boolean disponivel;
	
	public Filme(String titulo, String genero, String sinopse, int classificacaoIndicativa, int anoLancamento, boolean dublado, boolean disponivel) {
		this.titulo = titulo;
		this.genero = genero;
		this.sinopse = sinopse;
		this.classificacaoIndicativa = classificacaoIndicativa;
		this.anoLancamento = anoLancamento;
		this.dublado = dublado;
		this.disponivel = true;
	}


	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }

	public String getGenero() { return genero; }
	public void setGenero(String genero) { this.genero = genero; }

	public String getSinopse() { return sinopse; }
	public void setSinopse(String sinopse) { this.sinopse = sinopse; }

	public int getClassificacaoIndicativa() { return classificacaoIndicativa; }
	public void setClassificacaoIndicativa(int classificacaoIndicativa) { this.classificacaoIndicativa = classificacaoIndicativa; }

	public int getAnoLancamento() { return anoLancamento; }
	public void setAnoLancamento(int anoLancamento) { this.anoLancamento = anoLancamento; }

	public boolean isDublado() { return dublado; }
	public void setDublado(boolean dublado) { this.dublado = dublado; }

	public boolean isDisponivel() { return disponivel; }
	public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

	
	public String exibirInfoFilme() {
        return String.format(
            "\t 𝝣「 ✍ 」➜ Título: %s\n\t 𝝣「 🔍 」➜ Gênero: %s\n\t 𝝣「 📞 」➜ Sinopse: %s\n\t 𝝣「 📧 」➜ Classificação Indicativa(em anos, onde 0 = livre): %s\n\t 𝝣「 🪪 」➜ Ano Lançamento: %d\n\t 𝝣「 🌉 」➜ Dublado(true/false): %s\n\t 𝝣「 🛣 」➜ Disponível(true/false): %s ",
            titulo, genero, sinopse, classificacaoIndicativa, anoLancamento,
            dublado ? "Sim" : "Não", disponivel ? "Sim" : "Não" );
    }
	
	public boolean podeSerAlugadoPor(int idadeCliente) {
        return idadeCliente >= this.classificacaoIndicativa;
    }
}
