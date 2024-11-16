package interfaceUsuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dados.Acervo;
import dados.Filme;
import negocio.Cliente;
import negocio.Gerente;
import negocio.Transacao;

import java.util.InputMismatchException;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Menu {
	private static LocalDate dataDevolvidoGlobal;
	public static void main(String[] args) {
		int escolha;
		ArrayList<Cliente> clientes = new ArrayList<>();
		ArrayList<Transacao> transacoes = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		Cliente cliente1 = new Cliente("109.109.109-09", "Xuu Lee", "setembr0Amarelo", 11111111, "Xuuessemes@gmail.com", "Xangai", 
				"Matsuya", "Liberdade", 99, 21);
		Cliente cliente2 = new Cliente("171.171.171-71", "Keen Xong", "calmaCalabreso24", 22222222, "Calabresoacalmado@gmail.com", "Xangai",
				"Fubuki", "Liberdade", 32, 41);
		Gerente gerente = new Gerente("123.123.123-12", "Yotra", "esprega#esprega", 
		                               12345678, "yotraesprega@gmail.com", "Xangai",
		                               "Fubuki", "Liberdade", 23, 37, clientes);

		clientes.add(cliente1);
		clientes.add(cliente2);
		
		Acervo acervo = new Acervo();
		
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
				    System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				    String cpfInput;
				    boolean cpfValido = false;
				    boolean cpfEncontrado = false;

				    do {
				        System.out.print("\t 𝝣「 🪪 」➜ CPF (formato ###.###.###-##): ");
				        cpfInput = teclado.nextLine();

				        String cpfRegex = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
				        Pattern pattern = Pattern.compile(cpfRegex);
				        Matcher matcher = pattern.matcher(cpfInput);
				        cpfValido = matcher.matches();

				        if (!cpfValido) {
				            System.out.println("\t 𝝣「 ⚠ 」CPF inválido. Por favor, insira no formato ###.###.###-##.");
				        } else {

				            for (Cliente cliente : clientes) {
				                if (cliente.getCpf().equals(cpfInput)) {
				                    cpfEncontrado = true;
				                    System.out.println("\t 𝝣「 ✔ 」CPF encontrado. Redirecionando para o menu de cliente...");


				                    int opcaoCliente;
				                    do {
				                        atendimentoGerente();  
				                        System.out.print("\t 𝝣「 ✏ 」➜ Escolha: ");
				                        opcaoCliente = teclado.nextInt();
				                        teclado.nextLine();


				                        switch (opcaoCliente) {
				                            case 1:

				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                boolean continuarBuscando;
				                                do {
				                                    System.out.print("\t 𝝣「 ✏ 」➜ Título a ser buscado: ");
				                                    String tituloInputBusca = teclado.nextLine();
				                                    acervo.procurarFilme(tituloInputBusca);
				                                    System.out.print("\t 𝝣「 ↩ 」➜ Deseja buscar outro filme? (true/false): ");
				                                    continuarBuscando = teclado.nextBoolean();
				                                    teclado.nextLine();
				                                } while (continuarBuscando);
				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                break;

				                            case 2:

				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                System.out.print("\t 𝝣「 ✏ 」➜ Digite seu CPF para buscar cadastro: ");  String cpfBusca = teclado.next();
				                                gerente.consultarCadastro(cpfBusca);
				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                break;

				                            case 3: 
				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                System.out.print("\t 𝝣「 ✏ 」➜ Digite sua senha para consultar saldos: ");  
				                                String senhaInput = teclado.nextLine();

				                                if (dataDevolvidoGlobal == null) {
				                                    System.out.println("\t 𝝣「 ✖ 」➜ Nenhuma devolução registrada. Realize um aluguel primeiro.");
				                                } else {
				                                    cliente.consultarSaldos(senhaInput, dataDevolvidoGlobal);
				                                }
				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                break;


				                            case 4:

				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                boolean continuarAlugando;
				                                Transacao transacao = new Transacao(10, 1.5, LocalDate.now(), LocalDate.now().plusDays(15), 0.0, 0, cliente);
				                                do {
				                                    System.out.print("\t 𝝣「 ✏ 」➜ Digite o título do filme que deseja alugar: ");
				                                    String tituloInput = teclado.nextLine();
				                                    transacao.gerarNotaFiscal(tituloInput, acervo);
				                                    System.out.print("\t 𝝣「 ↩ 」➜ Deseja alugar outro filme? (true/false): ");
				                                    continuarAlugando = teclado.nextBoolean();
				                                    teclado.nextLine();
				                                } while (continuarAlugando);
				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                
				                                System.out.print("\t 𝝣「 ✏ 」➜ Digite o título do filme que deseja devolver: "); 
			            				        String tituloInputDevolucao = teclado.nextLine();
			            				        
			            				        Filme filmeF = acervo.procurarFilme(tituloInputDevolucao);
			            				        
			            				        if (filmeF != null) {
			            				            DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			            				            System.out.print("\t 𝝣「 ✏ 」➜ Digite a data que você devolveu (DD/MM/AAAA): "); 
			            				            String data = teclado.next();
			            				            LocalDate dataDevolvido = LocalDate.parse(data, dataFormato);
			            				            dataDevolvidoGlobal = dataDevolvido;
			            				            
			            				            transacao.getDataDevolver();
			            				            if (dataDevolvido.isAfter(transacao.getDataDevolver())) {
			            					            int diasAtraso = (int) ChronoUnit.DAYS.between(transacao.getDataDevolver(), dataDevolvido);
			            					            transacao.setDiasAtraso(diasAtraso);
			            					            double multa = diasAtraso * transacao.getTaxaMultaDiaria();
			            					            transacao.setMulta(multa); 
			            					            gerente.setMultado(true); 
			            					            System.out.printf("\t 𝝣「 ⚠ VEACO ⚠ 」➜ Aviso: Você foi multado! Dias de atraso: %d, Multa: R$ %.2f%n", diasAtraso, multa);
			            					        }
			            				            cliente.devolverFilme(filmeF);
			            				        } else {
			            				            System.out.println("\t 𝝣「 ✖ 」➜ Filme não encontrado!");
			            				            return;
			            				        }
				                                break;
				                            case 5:
				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                cliente.consultarAcervo(acervo);
				                                System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				                                break;
				                            case 6:
				                                System.out.println("\t 𝝣「 ↩ 」➜ Voltando para o menu principal!");
				                                break;
				                            default:
				                                System.out.println("\t 𝝣「 ✖ 」➜ Opção inválida!");
				                                break;
				                        }
				                    } while (opcaoCliente != 6); 
				                    break; 
				                }
				            }
				            if (!cpfEncontrado) {
				                System.out.println("\t 𝝣「 ✖ 」CPF não cadastrado. Retornando ao menu principal...");
				                escolha = 1;
				            }
				        }
				    } while (!cpfValido && !cpfEncontrado); 
				    break;
			   case 4:
				   System.out.println("\t 𝝣「 🖥 」➜ Operação finalizada. Até logo! ");
				   escolha = 3;
				   break;
			   default:
				   System.out.println("\t 𝝣「 ✖ 」➜ Opção inválida! ");
			} 
		} while(escolha != 3);
		teclado.close();
	}
	
	public static void gerarMenu() {
		System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
		System.out.println("\t\t•| ⊱ SELECIONE UMA OPÇÃO ENTRE 1 E 4 ⊰ |•");
		System.out.println("\t 𝝣「 1 」➜ Cadastrar cliente! \t\t");
		System.out.println("\t 𝝣「 2 」➜ Entrar funcionário! \t");
		System.out.println("\t 𝝣「 3 」➜ Entrar cliente! \t");
		System.out.println("\t 𝝣「 4 」➜ Sair do sistema!\t\t");  	
	}
	
	public static Cliente gerarMenuCliente(ArrayList<Cliente> clientes) {
		Scanner teclado = new Scanner(System.in);
		Cliente cliente1 = new Cliente("109.109.109-09", "Xuu Lee", "setembr0Amarelo", 11111111, "Xuuessemes@gmail.com", "Xangai", 
				"Matsuya", "Liberdade", 99, 21);
		Gerente gerente = new Gerente("123.123.123-12", "Yotra", "esprega#esprega", 
		                               12345678, "yotraesprega@gmail.com", "Xangai",
		                               "Fubuki", "Liberdade", 23, 37, clientes);

		ArrayList<Cliente> clientesInput = new ArrayList<>();

		Cliente novoCliente = gerente.criarCadastro(teclado, clientesInput);  
	    clientes.add(novoCliente);  
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
							System.out.print("\t 𝝣「 ↩ 」➜ Deseja buscar outro filme? (true/false): "); continuarBuscando = teclado.nextBoolean();
					        teclado.nextLine();
						} while (continuarBuscando);
					} catch (InputMismatchException e){
						System.out.println("\t 𝝣「 ✖ 」➜ Entrada não booleana!, " + e.getMessage()); teclado.nextLine();
					}
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return novoCliente;
				case 2:
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					System.out.print("\t 𝝣「 ✏ 」➜ Digite seu CPF para buscar cadastro: ");
                    String cpfBusca = teclado.next();
                    gerente.consultarCadastro(cpfBusca);
					System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
					return novoCliente;
				case 3: 
				    System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				    System.out.print("\t 𝝣「 ✏ 」➜ Digite sua senha para consultar saldos: ");  
				    String senhaInput = teclado.nextLine();

				    if (dataDevolvidoGlobal == null) {
				        System.out.println("\t 𝝣「 ✖ 」➜ Nenhuma devolução registrada. Realize um aluguel primeiro.");
				    } else {
				        novoCliente.consultarSaldos(senhaInput, dataDevolvidoGlobal);
				    }
				    System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
				    return novoCliente;

				case 4:
					boolean continuarAlugando;
				    Cliente clienteSelecionado = novoCliente; 

				    Transacao transacao = new Transacao(10, 1.5, LocalDate.now(), LocalDate.now().plusDays(15), 0.0, 0, clienteSelecionado);
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
				    
				    System.out.print("\t 𝝣「 ✏ 」➜ Digite o título do filme que deseja devolver: ");
				    String tituloInputDevolucao = teclado.nextLine();

				    Filme filmeF = acervo.procurarFilme(tituloInputDevolucao);

				    if (filmeF != null) {
				        DateTimeFormatter dataFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				        System.out.print("\t 𝝣「 ✏ 」➜ Digite a data que você devolveu (DD/MM/AAAA): ");
				        String data = teclado.next();
				        LocalDate dataDevolvido = LocalDate.parse(data, dataFormato);
				        dataDevolvidoGlobal = dataDevolvido;
				        
				        if (dataDevolvido.isAfter(transacao.getDataDevolver())) {
				            int diasAtraso = (int) ChronoUnit.DAYS.between(transacao.getDataDevolver(), dataDevolvido);
				            transacao.setDiasAtraso(diasAtraso);
				            double multa = diasAtraso * transacao.getTaxaMultaDiaria();
				            transacao.setMulta(multa); 
				            gerente.setMultado(true); 
				            System.out.printf("\t 𝝣「 ⚠ VEACO ⚠ 」➜ Aviso: Você foi multado! Dias de atraso: %d, Multa: R$ %.2f%n", diasAtraso, multa);
				        }

				       novoCliente.devolverFilme(filmeF); 
				    } else {
				        System.out.println("\t 𝝣「 ✖ 」➜ Filme não encontrado!");
				    }

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
		Gerente gerente = new Gerente("123.123.123-12", "Yotra", "esprega#esprega", 
		                               12345678, "yotraesprega@gmail.com", "Xangai",
		                               "Fubuki", "Liberdade", 23, 37, clientes);

		System.out.println("\n\t「𝝣🎬」============================================================「𝝣🎬」");
		System.out.println("\t\t•| ⊱SELECIONE UMA AÇÃO ENTRE 1 E 6⊰ |•");
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
				"Fubuki", "Liberdade", 32, 41);


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
						System.out.print("\t 𝝣「 ↩ 」➜ Deseja remover outro filme? (true/false): "); continuarRemovendo = teclado.nextBoolean();
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