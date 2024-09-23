package projeto;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Cliente {
	private boolean multado;
	private boolean devolvido;
	private ArrayList<Cliente> clientes;

	
	public Gerente(String cpf, String nome, String senha, long telefone, String email, String cidade, String rua, String bairro, int numCasa) {
		super(cpf, nome, senha, telefone, email, cidade, rua, bairro, numCasa);
		this.multado = false;
		this.devolvido = false;
		this.clientes = new ArrayList<>();
	}
	
	
	public boolean isMultado() { return multado; }
	public void setMultado(boolean multado) { this.multado = multado; }
	
	public boolean isDevolvido() { return devolvido; }
	public void setDevolvido(boolean devolvido) { this.devolvido = devolvido; }
	
	public ArrayList<Cliente> getClientes() { return clientes; }
	public void setClientes(ArrayList<Cliente> clientes) { this.clientes = clientes; }


	public Cliente criarCadastro(Scanner teclado, ArrayList<Cliente> clientesInput) {
		System.out.println("\t「𝝣🎬」============================================================「𝝣🎬」");
		System.out.print("\t 𝝣「 🪪 」➜ CPF: "); String cpfInput = teclado.nextLine();
		
		System.out.print("\t 𝝣「 ✍ 」➜ Nome: "); String nomeInput = teclado.nextLine();
		
		System.out.print("\t 𝝣「 🔍 」➜ Senha: "); String senhaInput = teclado.nextLine();
		
		System.out.print("\t 𝝣「 📞 」➜ Telefone: "); long telefoneInput = teclado.nextLong();
        teclado.nextLine();  
        
		System.out.print("\t 𝝣「 📧 」➜ Email: "); String emailInput = teclado.nextLine();
		
		System.out.print("\t 𝝣「 🌉 」➜ Cidade: "); String cidadeInput = teclado.nextLine();
		
		System.out.print("\t 𝝣「 🛣 」➜ Rua: "); String ruaInput = teclado.nextLine();
		
		System.out.print("\t 𝝣「 🌆 」➜ Bairro: "); String bairroInput = teclado.nextLine();
		
		System.out.print("\t 𝝣「 🔢 」➜ Nº Casa: "); int numCasaInput = teclado.nextInt();
        teclado.nextLine();  
        System.out.println("\t「𝝣🎬」============================================================「𝝣🎬」");

        Cliente novoCliente = new Cliente(cpfInput, nomeInput, senhaInput, telefoneInput, emailInput, cidadeInput, ruaInput, bairroInput, numCasaInput);
        
        this.clientes.add(novoCliente);

        System.out.print("\t 𝝣「 "+nomeInput+" 」➜ foi cadastrado(a)! ");
        return novoCliente;
    }
	
	public void removerCadastro(Cliente cliente) {
		clientes.remove(cliente);
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