package negocio;
import java.util.ArrayList;

import dados.Acervo;
import dados.Filme;
import interfaceUsuario.Menu;

public class Cliente {
	private String cpf;
	private String nome;
	private String senha;
	private long telefone;
	private String email;
	private String cidade;
	private String rua;
	private String bairro;
	private int numCasa;
	private int idade;
	private ArrayList<Transacao> transacoes;
	
	public Cliente(String cpf, String nome, String senha, long telefone, String email, String cidade, String rua, String bairro, int numCasa, int idade) {
		this.cpf = cpf;
		this.nome = nome;
		this.senha = senha;
		this.telefone = telefone;
		this.email = email;
		this.cidade = cidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numCasa = numCasa;
		this.idade = idade;
		this.transacoes = new ArrayList<>();
	}

	public String getCpf() { return cpf; }
	public void setCpf(String cpf) { this.cpf = cpf; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public String getSenha() { return senha; }
	public void setSenha(String senha) { this.senha = senha; }
	
	public long getTelefone() { return telefone; }
	public void setTelefone(long telefone) { this.telefone = telefone; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	
	public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }
    
    public String getRua() { return rua; }
    public void setRua(String rua) { this.rua = rua; }
    
    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }
    
    public int getNumCasa() { return numCasa; }
    public void setNumCasa(int numCasa) { this.numCasa = numCasa; }
    
    public int getIdade() {return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public ArrayList<Transacao> getTransacoes() { return transacoes; }
    public void setTransacoes(ArrayList<Transacao> transacoes) { this.transacoes = transacoes; }
	
	
    public void alugarFilme(Filme filme, boolean multado) {
        if (filme.isDisponivel() && !multado) {

            if (filme.podeSerAlugadoPor(this.idade)) {
                filme.setDisponivel(false);
                System.out.println("\t 𝝣「 ✔ 」➜ Filme alugado com sucesso!");
            } else {
                System.out.println("\n\t 𝝣「 ✖ 」➜ Idade insuficiente para alugar este filme.\n");
                Menu.gerarMenuCliente(null);
            }
        } else {
            System.out.println("\t 𝝣「 ✖ 」➜ Lamentamos, mas o filme está indisponível e/ou você está multado!");
        }
    }
	
	public void devolverFilme(Filme filme) { 
		if (!filme.isDisponivel()) {
			filme.setDisponivel(true);
		}
	}
	
	public void consultarAcervo(Acervo acervo) { 
		if (acervo.getFilmes().isEmpty()) {
	        System.out.println("\t 𝝣「 ✖ 」➜ Não há filmes disponíveis no acervo.");
	    } else {
	        System.out.println("\t 𝝣「 🎬 」➜ Títulos Disponíveis:");
	        for (Filme filme : acervo.getFilmes()) {
	            System.out.println("\t 𝝣「 ⛩ 」➜ : " + filme.getTitulo());
	        }
	    }
	}
	
	public double consultarSaldos(String senhaInput, boolean multado) { 
		double saldoTotal = 0.0;
		if (this.getSenha().trim().equals(senhaInput.trim())) {
			Transacao transacao = null;
			saldoTotal = transacao.calcularMulta(); 
			multado = true;
			System.out.println("\t 𝝣「 🧾 」➜ Multa: " + saldoTotal);
			return saldoTotal;
        }
		else {
			System.out.println("\t 𝝣「 ✖ 」➜ Senha incorreta! ");
            return 0.0;
		}
	}
}