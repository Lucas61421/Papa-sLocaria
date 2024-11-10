package interfaceUsuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import dados.Acervo;
import negocio.Cliente;
import negocio.Filme;
import negocio.Gerente;
import negocio.Transacao;

import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter;


public class Menu {

	public static void main(String[] args) {
		int escolha;
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Transacao> transacoes = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		Cliente cliente1 = new Cliente("109.109.109-09", "Xuu Lee", "setembr0Amarelo", 11111111, "Xuuessemes@gmail.com", "Xangai", 
				"Matsuya", "Liberdade", 99);
		Cliente cliente2 = new Cliente("171.171.171-71", "Keen Xong", "calmaCalabreso24", 22222222, "Calabresoacalmado@gmail.com", "Xangai",
				"Fubuki", "Liberdade", 32);
		Gerente gerente = new Gerente("123.123.123-12", "Yotra", "esprega#esprega", 12345678, "yotraesprega@gmail.com", "Xangai",
				"Fubuki", "Liberdade", 23);
		clientes.add(cliente1);
		clientes.add(cliente2);
		
		do {
			
			gerarMenu(); 
			System.out.print("\t 𝝣「 ✏ 」➜ Escolha: "); escolha = teclado.nextInt();
			teclado.nextLine();
			
			switch (escolha) {
			   case 1:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					System.out.println("\t\t 𝝣「 👸🏿 Gerente " + gerente.getNome() + " 」➜ Farei seu cadastro yotras coisas!");
					System.out.println("\t\t•| ⊱PREENCHA OS CAMPOS PARA CADASTRO DE CLIENTE⊰ |•");
				   	Cliente clientesInput = gerarMenuCliente(clientes);   
				   	System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				    break;
			   case 2:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					System.out.println("\t\t•| ⊱ Bem-vinda, gerente: " + gerente.getNome() + " ⊰ |•");
					entrarGerente();
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				   	break; 
			   case 3:
				   System.out.println("\t 𝝣「 🖥 」➜ Operação finalizada. Até logo! ");
				   break;
			   default:
				   System.out.println("\t 𝝣「 ✖ 」➜ Opção inválida! ");
				   
				   
			} 
		} while(escolha != 3);
		teclado.close();
	}
	
	public static void gerarMenu() {
		System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
		System.out.println("\t\t•| ⊱ SELECIONE UMA OPÇÃO ENTRE 1 E 3 ⊰ |•");
		System.out.println("\t 𝝣「 1 」➜ Cadastrar cliente! \t\t");
		System.out.println("\t 𝝣「 2 」➜ Entrar funcionário! \t");
		System.out.println("\t 𝝣「 3 」➜ Sair do sistema!\t\t");  	
	}
	
	public static Cliente gerarMenuCliente(ArrayList<Cliente> clientes) {
		Scanner teclado = new Scanner(System.in);
		Cliente cliente1 = new Cliente("109.109.109-09", "Xuu Lee", "setembr0Amarelo", 11111111, "Xuuessemes@gmail.com", "Xangai", 
				"Matsuya", "Liberdade", 99);
		Gerente gerente = new Gerente("123.123.123-12", "Yotra", "esprega#esprega", 12345678 , "yotraesprega@gmail.com", 
				"Xangai", "Fubuki", "Liberdade", 23);
		ArrayList<Cliente> clientesInput = new ArrayList<>();

		Cliente novoCliente = gerente.criarCadastro(teclado, clientesInput);  
	    clientes.add(novoCliente);  
	    System.out.println("\n\t 𝝣「 ✔ 」➜ Cliente já cadastrado! Redirecionando para o menu de seleções.");
		atendimentoGerente();

		System.out.print("\t 𝝣「 ✏ 」➜ Escolha: "); int escolha = teclado.nextInt();
		teclado.nextLine();
	    Acervo acervo = new Acervo();
	    Filme filme;
	    
		do {
			switch (escolha) {
				case 1:
					boolean continuarBuscando;
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					try {
						do {
							System.out.print("\t 𝝣「 ✏ 」➜ Título a ser buscado: "); String tituloInputBusca = teclado.nextLine();
							acervo.procurarFilme(tituloInputBusca);
							System.out.print("\t 𝝣「 ↩ 」➜ Deseja buscar outro filme? (s/n): "); continuarBuscando = teclado.nextBoolean();
					        teclado.nextLine();
						} while (continuarBuscando);
					} catch (InputMismatchException e){
						System.out.println("\t 𝝣「 ✖ 」➜ Entrada não booleana!, " + e.getMessage()); teclado.nextLine();
					}
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return novoCliente;
				case 2:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					System.out.print("\t 𝝣「 ✏ 」➜ Digite seu CPF para buscar cadastro: "); String cpfInput = teclado.next();
					gerente.consultarCadastro(cpfInput);
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return novoCliente;
				case 3:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					System.out.print("\t 𝝣「 ✏ 」➜ Digite sua senha para consultar saldos: "); String senhaInput = teclado.next();
					novoCliente.consultarSaldos(senhaInput, gerente.isMultado());
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return novoCliente;
				case 4:
					boolean continuarAlugando;
				    Cliente clienteSelecionado = novoCliente; 
				    Transacao transacao = new Transacao(10, LocalDate.now(), LocalDate.now().plusDays(15), 0.0, 0, clienteSelecionado);
				    System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				    try {
				    	do {
					        System.out.print("\t 𝝣「 ✏ 」➜ Digite o título do filme que deseja alugar: "); 
					        String tituloInput = teclado.nextLine();
					        transacao.gerarNotaFiscal(tituloInput, acervo);
					        System.out.print("\t 𝝣「 ↩ 」➜ Deseja alugar outro filme? (true/false): "); continuarAlugando = teclado.nextBoolean();
					        System.out.println();
					        teclado.nextLine();
					    } while (continuarAlugando);
				    } catch (InputMismatchException e){
						System.out.println("\t 𝝣「 ✖ 」➜ Entrada não booleana!, " + e.getMessage()); teclado.nextLine();
					}
				    
				    String continuarDevolvendo;
				    do {
				        System.out.print("\t 𝝣「 ✏ 」➜ Digite o título do filme que deseja devolver: "); 
				        String tituloInputDevolucao = teclado.nextLine();
				        
				        Filme filmeF = acervo.procurarFilme(tituloInputDevolucao);
				        
				        if (filmeF != null) {
				            DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				            System.out.print("\t 𝝣「 ✏ 」➜ Digite a data que você devolveu (DD/MM/AAAA): "); 
				            String data = teclado.next();
				            LocalDate dataDevolvido = LocalDate.parse(data, dataFormato);
				            transacao.getDataDevolver();
				            if (dataDevolvido.isAfter(transacao.getDataDevolver())) {
				                gerente.setMultado(true);
				                System.out.print("\t 𝝣「 ⚠VEACO⚠ 」➜ Aviso! Você foi multado"); 
				            }
				            novoCliente.devolverFilme(filmeF);
				        } else {
				            System.out.println("\t 𝝣「 ✖ 」➜ Filme não encontrado!");
				        } 
				        continuarDevolvendo = teclado.nextLine();
				    } while (continuarDevolvendo.equalsIgnoreCase("s")); 
				    System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				    return novoCliente;
				case 5:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				    cliente1.consultarAcervo(acervo); 
				    System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return novoCliente;
				case 6:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					System.out.println("\t 𝝣「 ↩ 」➜ Voltando para o menu principal! ");
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					break;
				default:
					System.out.println("\t 𝝣「 ✖ 」➜ Opção inválida! ");

			}
		} while(escolha != 6);
		return novoCliente;
	}
	
	public static void atendimentoGerente() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		Gerente gerente = new Gerente("123.123.123-12", "Yotra", "esprega#esprega", 12345678 , "yotraesprega@gmail.com",
				"Xangai", "Fubuki", "Liberdade", 23);
		System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
		System.out.println("\t\t•| ⊱SELECIONE UMA AÇÃO ENTRE 1 E 7⊰ |•");
		System.out.println("\t 𝝣「 1 」➜ Procurar filme! ");
		System.out.println("\t 𝝣「 2 」➜ Consultar cadastro de cliente! ");
		System.out.println("\t 𝝣「 3 」➜ Consultar saldos! ");
		System.out.println("\t 𝝣「 4 」➜ Alugar filme(s)! ");
		System.out.println("\t 𝝣「 5 」➜ Consultar acervo! ");
		System.out.println("\t 𝝣「 6 」➜ Voltar ao menu principal! "); 
	}
	public static void entrarGerente() {
		int escolha;
	    Acervo acervo = new Acervo();
		Scanner teclado = new Scanner(System.in);
		Cliente cliente = new Cliente("171.171.171-71", "Keen Xong", "calmaCalabreso24", 22222222, "Calabresoacalmado@gmail.com", "Xangai",
				"Fubuki", "Liberdade", 32);
		Gerente gerente = new Gerente("123.123.123-12","Yotra", "esprega#esprega", 12345678 , "yotraesprega@gmail.com", 
				"Xangai", "Fubuki", "Liberdade", 23);

		System.out.println("\t\t•| ⊱SELECIONE UMA AÇÃO ENTRE 1 E 4⊰ |•");
		System.out.println("\t 𝝣「 1 」➜ Adicionar filme! \t\t");
		System.out.println("\t 𝝣「 2 」➜ Remover filme! \t\t");
		System.out.println("\t 𝝣「 3 」➜ Voltar ao menu! \t\t");
		
		System.out.print("\t 𝝣「 ✏ 」➜ Escolha: "); escolha = teclado.nextInt();
		do {
			switch (escolha) {
				case 1:
					boolean continuarAdicionando;
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					try {
						do {
							acervo.adicionarFilme(); 
							System.out.print("\t 𝝣「 ↩ 」➜ Deseja adicionar outro filme? (true/false): "); continuarAdicionando = teclado.nextBoolean();
						} while (continuarAdicionando);
					} catch (InputMismatchException e){
						System.out.println("\t 𝝣「 ✖ 」➜ Entrada não booleana!, " + e.getMessage()); teclado.nextLine();
					}
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return;
				case 2:
					boolean continuarRemovendo;
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					cliente.consultarAcervo(acervo);
				try {
					do {
						acervo.removerFilme();
						cliente.consultarAcervo(acervo);
						System.out.print("\t 𝝣「 ↩ 」➜ Deseja remover outro filme? (s/n): "); continuarRemovendo = teclado.nextBoolean();
						teclado.nextLine();
					} while (continuarRemovendo);
				} catch (InputMismatchException e) { 
                    System.out.println("\t 𝝣「 ✖ 」➜ Entrada não booleana!, " + e.getMessage()); teclado.nextLine(); 
                }
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return;
				case 3:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					System.out.println("\t 𝝣「 ↩ 」➜ Voltando para o menu principal! ");
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					break;
				default:
					System.out.println("\t 𝝣「 ✖ 」➜ Opção inválida! ");
					break;
			}
		} while(escolha != 3);
		
	}
}