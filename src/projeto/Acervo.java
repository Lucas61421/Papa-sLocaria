package projeto;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.Normalizer;
import java.util.regex.Pattern;

public class Acervo {
	private ArrayList<Filme> filmes;
	
	public Acervo() {
		this.filmes = new ArrayList<>();
		adicionarFilmesIniciais();
	}
	
	public static String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return textoNormalizado.replaceAll("[^\\p{ASCII}]", "");
    }
	
	public ArrayList<Filme> getFilmes() { return filmes; }
	public void setFilmes(ArrayList<Filme> filmes) { this.filmes = filmes; }
	
	 private void adicionarFilmesIniciais() {
	        filmes.add(new Filme("A Culpa é das Estrelas", "Romance", "Dois adolescentes com câncer se apaixonam.", "12 anos", 2014, false, true));
	        filmes.add(new Filme("Corra", "Suspense", "Um jovem negro descobre segredos sinistros sobre sua namorada e sua família.", "16 anos", 2017, false, true));
	        filmes.add(new Filme("Rec", "Terror", "Uma repórter e seu cinegrafista ficam presos em um prédio infectado.", "18 anos", 2007, false, true));
	        filmes.add(new Filme("Pé de Chinesa", "Drama", "Uma jovem chinesa enfrenta desafios culturais ao se mudar para o Brasil.", "14 anos", 2023, true, true));
	        filmes.add(new Filme("Todo Mundo em Pânico", "Comédia", "Uma paródia de filmes de terror e suspense.", "14 anos", 2000, true, true));
	        filmes.add(new Filme("Deadpool", "Ação", "Um mercenário busca vingança após ganhar habilidades sobre-humanas.", "18 anos", 2016, false, true));
	        filmes.add(new Filme("Central do Brasil", "Drama", "Uma mulher ajuda um garoto a encontrar seu pai.", "12 anos", 1998, true, true));
	        filmes.add(new Filme("Avatar", "Ficção Científica", "Um soldado paraplégico é enviado a Pandora e se envolve em uma guerra.", "12 anos", 2009, true, true));
	        filmes.add(new Filme("A Noiva Cadáver", "Animação", "Um jovem acidentalmente propõe casamento a uma noiva morta no submundo.", "Livre", 2005, true, true));
	    }
	
	 /*
	    public void adicionarFilme(Filme filme) {
        filmes.add(filme);}
	  */
	public void adicionarFilme(Filme filme, Scanner teclado) { 
        
		System.out.println("\t「𝝣🎬」============================================================「𝝣🎬」");

		if (!(filme.getTitulo().equalsIgnoreCase(tituloInput))){
			System.out.print("\t 𝝣「 🔍 」➜ Gênero: "); String generoInput = teclado.next();

			System.out.print("\t 𝝣「 📞 」➜ Sinopse: "); String sinopseInput = teclado.next();

			System.out.print("\t 𝝣「 📧 」➜ Classificação Indicativa: "); int classificacaoIndicativaInput = teclado.nextInt();
			teclado.nextLine();
			
			System.out.print("\t 𝝣「 🪪 」➜ Ano Lançamento: "); int anoLancamentoInput = teclado.nextInt();
			teclado.nextLine();
			
			System.out.print("\t 𝝣「 🌉 」➜ Dublado(true/false): "); boolean dubladoInput = teclado.nextBoolean();
			
			System.out.print("\t 𝝣「 🛣 」➜ Disponível(true/false): "); boolean disponivelInput = true;
			
	        teclado.nextLine();  
	        System.out.println("\t「𝝣🎬」============================================================「𝝣🎬」");
	        
			filmes.add(filme); 
			}
		else {
			System.out.print("\t 𝝣「 " +tituloInput+ " 」➜ Já está cadastrado! "); 
			}
		}
	
	public void removerFilme(Filme filme) { filmes.remove(filme); }
	
	
	public Filme procurarFilme(String tituloInputBusca) {
		String tituloNormalizadoBusca = removerAcentos(tituloInputBusca);
		boolean encontrado = false;
        for (Filme filme : filmes) {
        	String tituloNormalizadoFilme = removerAcentos(filme.getTitulo());
            if (tituloNormalizadoFilme.equalsIgnoreCase(tituloNormalizadoBusca)) {
            	System.out.println("\t 𝝣「 " +filme.getTitulo()+ " 」➜ Disponível" + "\n" + filme.exibirInfoFilme());
                return filme;
            }
        }
        System.out.println("\t 𝝣「 " +tituloInputBusca+ " 」➜ Indisponível");
        return null;
    }

}