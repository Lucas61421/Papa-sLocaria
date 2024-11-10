package dados;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import negocio.Filme;

import java.text.Normalizer;


public class Acervo {
	private ArrayList<Filme> filmes;
	private ArrayList<String> generos;
	
	public Acervo() {
		this.filmes = new ArrayList<>();
		this.generos = new ArrayList<>();
		
		this.generos.add("comédia");
        this.generos.add("romance");
        this.generos.add("terror");
        this.generos.add("suspense");
        this.generos.add("drama");
        this.generos.add("ficção científica");
        this.generos.add("animação");
        this.generos.add("floptok");
        
		adicionarFilmesIniciais();
	}
	Scanner teclado = new Scanner(System.in);
	
	public static String removerAcentos(String texto) {
        String textoNormalizado = Normalizer.normalize(texto, Normalizer.Form.NFD);
        return textoNormalizado.replaceAll("[^\\p{ASCII}]", "");
    }
	
	public ArrayList<Filme> getFilmes() { return filmes; }
	public void setFilmes(ArrayList<Filme> filmes) { this.filmes = filmes; }
	
	
	
	 private void adicionarFilmesIniciais() {
	        filmes.add(new Filme("A Culpa é das Estrelas", "Romance", "Dois adolescentes com câncer se apaixonam.", 12, 2014, false, true));
	        filmes.add(new Filme("Corra", "Suspense", "Um jovem negro descobre segredos sinistros sobre sua namorada e sua família.", 16, 2017, false, true));
	        filmes.add(new Filme("Rec", "Terror", "Uma repórter e seu cinegrafista ficam presos em um prédio infectado.", 18, 2007, false, true));
	        filmes.add(new Filme("Pé de Chinesa", "Floptok", "Uma jovem chinesa enfrenta desafios culturais ao se mudar para o Brasil.", 14, 2023, true, true));
	        filmes.add(new Filme("Todo Mundo em Pânico", "Comédia", "Uma paródia de filmes de terror e suspense.", 14, 2000, true, true));
	        filmes.add(new Filme("Deadpool", "Ação", "Um mercenário busca vingança após ganhar habilidades sobre-humanas.", 18, 2016, false, true));
	        filmes.add(new Filme("Central do Brasil", "Drama", "Uma mulher ajuda um garoto a encontrar seu pai.", 12, 1998, true, true));
	        filmes.add(new Filme("Avatar", "Ficção Científica", "Um soldado paraplégico é enviado a Pandora e se envolve em uma guerra.", 12, 2009, true, true));
	        filmes.add(new Filme("A Noiva Cadáver", "Animação", "Um jovem acidentalmente propõe casamento a uma noiva morta no submundo.", 0, 2005, true, true));
	    }
	
	 public void adicionarFilme() { 
		    System.out.println("\t「𝝣🎬」============================================================「𝝣🎬」");

		    System.out.print("\t 𝝣「 🔍 」➜ Título: "); String tituloInput = teclado.next();  
		    teclado.nextLine();
		    boolean filmeExiste = false;
		    
		    for (Filme f : filmes) {
		        if (f.getTitulo().equalsIgnoreCase(tituloInput)) {
		            filmeExiste = true;
		            break;
		        }
		    }

		    if (!filmeExiste) {
	            String generoInput;
	            do {
	                System.out.print("\t 𝝣「 🔍 」➜ Gênero: ");
	                generoInput = teclado.nextLine().toLowerCase();
	                if (!generos.contains(removerAcentos(generoInput))) {
	                    System.out.println("\t 𝝣「 ⚠ 」Gênero inválido. Tente novamente com um dos gêneros: " + generos);
	                }
	            } while (!generos.contains(removerAcentos(generoInput)));
		       
		        System.out.print("\t 𝝣「 📞 」➜ Sinopse: "); String sinopseInput = teclado.nextLine();

		        System.out.print("\t 𝝣「 📧 」➜ Classificação Indicativa(em anos, onde 0 = livre): ");  int classificacaoIndicativaInput = teclado.nextInt();
		        teclado.nextLine();  

		        System.out.print("\t 𝝣「 🪪 」➜ Ano Lançamento: "); int anoLancamentoInput = teclado.nextInt();
		        teclado.nextLine(); 

		        System.out.print("\t 𝝣「 🌉 」➜ Dublado(true/false): "); boolean dubladoInput = teclado.nextBoolean();

		        System.out.print("\t 𝝣「 🛣 」➜ Disponível(true/false): true");  boolean disponivelInput = true; 

 
		        System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");


		        Filme filmeAdicionado = new Filme(tituloInput, generoInput, sinopseInput, classificacaoIndicativaInput, anoLancamentoInput, dubladoInput, disponivelInput);

		        this.filmes.add(filmeAdicionado);
		        
		        System.out.println("\t 𝝣「 " + tituloInput + " 」➜ Filme adicionado com sucesso! ");
		    } else {
		        System.out.println("\t 𝝣「 " + tituloInput + " 」➜ Já está cadastrado! "); 
		    }
		}

	
	 public void removerFilme() { 
		    System.out.print("\t 𝝣「 🔍 」➜ Título a ser removido: "); String tituloRemove = teclado.nextLine(); 
		    String tituloNormalizadoRem = removerAcentos(tituloRemove);
		    
		    boolean filmeEncontrado = false;
		    
		    Iterator<Filme> iterator = filmes.iterator();
		    
		    while (iterator.hasNext()) {
		        Filme filme = iterator.next();
		        String tituloNormalizadoFilme = removerAcentos(filme.getTitulo());
		        

		        if (tituloNormalizadoRem.equalsIgnoreCase(tituloNormalizadoFilme)) {
		            iterator.remove();  
		            filmeEncontrado = true;
		            System.out.println("\t 𝝣「 " + filme.getTitulo() + " 」➜ Filme removido com sucesso!");
		            System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
		            break;  
		        }
		    }
		    
		    if (!filmeEncontrado) {
		        System.out.println("\t 𝝣「 " + tituloRemove + " 」➜ Não consta no acervo!");
		        System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
		    }
		}
	
	
	public Filme procurarFilme(String tituloInputBusca) {
		String tituloNormalizadoBusca = removerAcentos(tituloInputBusca);
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