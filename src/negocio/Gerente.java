package negocio;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Gerente extends Cliente {
	private boolean multado;

	private ArrayList<Cliente> clientes;

	
	public Gerente(String cpf, String nome, String senha, long telefone, String email, String cidade, String rua, String bairro, int numCasa) {
		super(cpf, nome, senha, telefone, email, cidade, rua, bairro, numCasa);
		this.multado = false;
		this.clientes = new ArrayList<>();
	}
	
	
	public boolean isMultado() { return multado; }
	public void setMultado(boolean multado) { this.multado = multado; }

	public ArrayList<Cliente> getClientes() { return clientes; }
	public void setClientes(ArrayList<Cliente> clientes) { this.clientes = clientes; }


	public Cliente criarCadastro(Scanner teclado, ArrayList<Cliente> clientesInput) {
	    System.out.println("\t「𝝣🎬」============================================================「𝝣🎬」");
	    
	    String cpfInput;
	    boolean cpfValido;
	    do {
	        System.out.print("\t 𝝣「 🪪 」➜ CPF (formato ###.###.###-##): ");  cpfInput = teclado.nextLine();

	        String cpfRegex = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$";
	        Pattern pattern = Pattern.compile(cpfRegex);
	        Matcher matcher = pattern.matcher(cpfInput);
	        cpfValido = matcher.matches();

	        if (!cpfValido) {
	            System.out.println("\t 𝝣「 ⚠ 」CPF inválido. Por favor, insira no formato ###.###.###-##.");
	        }
	    } while (!cpfValido);

	    String nomeInput;
	    boolean nomeValido;
	    do {
	        System.out.print("\t 𝝣「 ✍ 」➜ Nome: ");  nomeInput = teclado.nextLine();

	        String nomeRegex = "^[a-zA-Z\\s]+$";
	        Pattern patternNome = Pattern.compile(nomeRegex);
	        Matcher matcherNome = patternNome.matcher(nomeInput);
	        nomeValido = matcherNome.matches() && !nomeInput.trim().isEmpty();

	        if (!nomeValido) {
	            System.out.println("\t 𝝣「 ⚠ 」Nome inválido. Por favor, use apenas letras e espaços.");
	        }
	    } while (!nomeValido);

	    String senhaInput;
	    boolean senhaValida;
	    do {
	        System.out.print("\t 𝝣「 🔍 」➜ Senha (mínimo de 6 caracteres): ");  senhaInput = teclado.nextLine();
	        senhaValida = senhaInput.length() >= 6;

	        if (!senhaValida) {
	            System.out.println("\t 𝝣「 ⚠ 」Senha inválida. Ela deve ter pelo menos 6 caracteres.");
	        }
	    } while (!senhaValida);

	    String telefoneInput;
	    boolean telefoneValido;
	    do {
	        System.out.print("\t 𝝣「 📞 」➜ Telefone (formato (##) #####-####): ");  telefoneInput = teclado.nextLine();

	        String telefoneRegex = "^\\(\\d{2}\\) \\d{5}-\\d{4}$";
	        Pattern patternTelefone = Pattern.compile(telefoneRegex);
	        Matcher matcherTelefone = patternTelefone.matcher(telefoneInput);
	        telefoneValido = matcherTelefone.matches();

	        if (!telefoneValido) {
	            System.out.println("\t 𝝣「 ⚠ 」Telefone inválido. Por favor, insira no formato (##) #####-####.");
	        }
	    } while (!telefoneValido);

	    String emailInput;
	    boolean emailValido;
	    do {
	        System.out.print("\t 𝝣「 📧 」➜ Email: ");  emailInput = teclado.nextLine();

	        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
	        Pattern patternEmail = Pattern.compile(emailRegex);
	        Matcher matcherEmail = patternEmail.matcher(emailInput);
	        emailValido = matcherEmail.matches();

	        if (!emailValido) {
	            System.out.println("\t 𝝣「 ⚠ 」Email inválido. Por favor, insira no formato correto (ex: usuario@dominio.com).");
	        }
	    } while (!emailValido);

	    String cidadeInput;
	    boolean cidadeValida;
	    do {
	        System.out.print("\t 𝝣「 🌉 」➜ Cidade: ");  cidadeInput = teclado.nextLine();

	        String cidadeRegex = "^[a-zA-Z\\s]+$";
	        Pattern patternCidade = Pattern.compile(cidadeRegex);
	        Matcher matcherCidade = patternCidade.matcher(cidadeInput);
	        cidadeValida = matcherCidade.matches() && !cidadeInput.trim().isEmpty();

	        if (!cidadeValida) {
	            System.out.println("\t 𝝣「 ⚠ 」Cidade inválida. Por favor, use apenas letras e espaços.");
	        }
	    } while (!cidadeValida);

	    String ruaInput;
	    boolean ruaValida;
	    do {
	        System.out.print("\t 𝝣「 🛣 」➜ Rua: ");  ruaInput = teclado.nextLine();

	        String ruaRegex = "^[a-zA-Z\\s]+$";
	        Pattern patternRua = Pattern.compile(ruaRegex);
	        Matcher matcherRua = patternRua.matcher(ruaInput);
	        ruaValida = matcherRua.matches() && !ruaInput.trim().isEmpty();

	        if (!ruaValida) {
	            System.out.println("\t 𝝣「 ⚠ 」Rua inválida. Por favor, use apenas letras e espaços.");
	        }
	    } while (!ruaValida);

	    String bairroInput;
	    boolean bairroValido;
	    do {
	        System.out.print("\t 𝝣「 🌆 」➜ Bairro: ");  bairroInput = teclado.nextLine();

	        String bairroRegex = "^[a-zA-Z\\s]+$";
	        Pattern patternBairro = Pattern.compile(bairroRegex);
	        Matcher matcherBairro = patternBairro.matcher(bairroInput);
	        bairroValido = matcherBairro.matches() && !bairroInput.trim().isEmpty();

	        if (!bairroValido) {
	            System.out.println("\t 𝝣「 ⚠ 」Bairro inválido. Por favor, use apenas letras e espaços.");
	        }
	    } while (!bairroValido);

	    int numCasaInput = -1;
	    boolean numCasaValido = false;
	    do {
	        System.out.print("\t 𝝣「 🔢 」➜ Nº Casa: ");
	        
	        try {
	            numCasaInput = teclado.nextInt();
	            teclado.nextLine();
	            numCasaValido = numCasaInput > 0;

	            if (!numCasaValido) {
	                System.out.println("\t 𝝣「 ⚠ 」Número da casa inválido. Ele deve ser um número positivo.");
	            }
	        } catch (InputMismatchException e) {
	            System.out.println("\t 𝝣「 ⚠ 」Entrada inválida. Por favor, insira apenas números.");
	            teclado.nextLine(); // Limpa o buffer para evitar um loop infinito
	        }
	    } while (!numCasaValido);

	    System.out.println("\t「𝝣🎬」============================================================「𝝣🎬」");

	    Cliente novoCliente = new Cliente(
	        cpfInput,
	        nomeInput,
	        senhaInput,
	        Long.parseLong(telefoneInput.replaceAll("[^0-9]", "")),
	        emailInput,
	        cidadeInput,
	        ruaInput,
	        bairroInput,
	        numCasaInput
	    );

	    this.clientes.add(novoCliente);

	    System.out.print("\t 𝝣「 " + nomeInput + " 」➜ foi cadastrado(a)! ");
	    return novoCliente;
	}
	
	public void removerCadastro(Scanner teclado) {
	    System.out.print("\t 𝝣「 🪪 」➜ CPF do cliente a ser removido: "); 
	    String cpfInput = teclado.nextLine();

	    Cliente clienteRemover = null;

	    for (Cliente cliente : clientes) {
	        if (cliente.getCpf().equals(cpfInput)) {
	            clienteRemover = cliente;
	            break;
	        }
	    }

	    if (clienteRemover != null) {

	        clientes.remove(clienteRemover);
	        System.out.println("\t 𝝣「 " + clienteRemover.getNome() + " 」➜ Cadastro removido com sucesso!");
	    } else {

	        System.out.println("\t 𝝣「 " + cpfInput + " 」➜ Cliente não encontrado!");
	        
	        System.out.print("\t 𝝣「 ➕ 」➜ Deseja cadastrar um novo cliente com esse CPF? (s/n): ");
	        String resposta = teclado.nextLine();

	        if (resposta.equalsIgnoreCase("s")) {
	            Cliente novoCliente = criarCadastro(teclado, clientes);
	            System.out.println("\t 𝝣「 " + novoCliente.getNome() + " 」➜ Cadastro criado com sucesso!");
	        } else {
	            System.out.println("\t 𝝣「 ❌ 」➜ Nenhum cliente foi cadastrado.");
	        }
	    }
	}
	
	public Cliente consultarCadastro(String cpfInput) { 
		for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpfInput)) {
            	System.out.println("\t 𝝣「 📋 」➜ Cadastro: ");
        		System.out.print("\n\t 𝝣「 🪪 」➜ CPF: " + cliente.getCpf());
        		
            	System.out.print("\n\t 𝝣「 ✍ 」➜ Nome: " + cliente.getNome()); 
        		
        		System.out.print("\n\t 𝝣「 🔍 」➜ Senha: " + cliente.getSenha()); 
        		
        		System.out.print("\n\t 𝝣「 📞 」➜ Telefone: " + cliente.getTelefone()); 
                
        		System.out.print("\n\t 𝝣「 📧 」➜ Email: " + cliente.getEmail()); 
        		 
        		
        		System.out.print("\n\t 𝝣「 🌉 」➜ Cidade: " + cliente.getCidade()); 
        		
        		System.out.print("\n\t 𝝣「 🛣 」➜ Rua: " + cliente.getRua()); 
        		
        		System.out.print("\n\t 𝝣「 🌆 」➜ Bairro: " + cliente.getBairro()); 
        		
        		System.out.print("\n\t 𝝣「 🔢 」➜ Nº Casa: " + cliente.getNumCasa()); 	
            }
		}
		return null;
  }
}