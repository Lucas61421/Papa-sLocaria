package projeto;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Transacao {
	private int aluguelQuinzenal;
	private double taxaMultaDiaria;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolver;
	private double multa;
	private int diasAtraso;
	private Cliente cliente;
	
	public Transacao(int aluguelQuinzenal, LocalDate dataEmprestimo, LocalDate dataDevolver, 
			 double multa, int diasAtraso, Cliente cliente) {
		this.aluguelQuinzenal = 10;
		this.taxaMultaDiaria = 0.75;
		this.dataEmprestimo = LocalDate.now();
		this.dataDevolver = dataEmprestimo.plusDays(15);
		this.multa = 0.0;
		this.diasAtraso = 0;
		this.cliente = cliente;
	}

	public double getAluguelQuinzenal() { return aluguelQuinzenal; }
	public void setAluguelQuinzenal(int aluguelQuinzenal) { this.aluguelQuinzenal = aluguelQuinzenal; }

	public LocalDate getDataEmprestimo() { return dataEmprestimo; }
	public void setDataEmprestimo(LocalDate dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

	public LocalDate getDataDevolver() { return dataDevolver; }
	public void setDataDevolver(LocalDate dataDevolver) { this.dataDevolver = dataDevolver; }

	public double getMulta() { return multa; }
	public void setMulta(double multa) { this.multa = multa; }

	public int getDiasAtraso() { return diasAtraso; }
	public void setDiasAtraso(int diasAtraso) { this.diasAtraso = diasAtraso; }

	
	public double calcularMulta() {
		if (dataDevolver.isAfter(dataEmprestimo)) {
			diasAtraso = (int) ChronoUnit.DAYS.between(dataEmprestimo, dataDevolver);
			if (diasAtraso > 0) {
				multa = diasAtraso * taxaMultaDiaria;
				multa += aluguelQuinzenal;
			}
		}
		return multa;
	}
	
	
	public void gerarNotaFiscal(String tituloInput, Acervo acervo) {
		Filme filme = acervo.procurarFilme(tituloInput);
		if (filme != null && filme.isDisponivel()) {
	        boolean multado = false;
	        cliente.alugarFilme(filme, multado);
	        
	        System.out.println("\t 𝝣「 📧 」➜ CPF: " + cliente.getCpf());
	        System.out.println("\t 𝝣「 📧 」➜ Nome: " + cliente.getNome());
	        System.out.println("\t 𝝣「 📧 」➜ Email: " + cliente.getEmail());
	        System.out.println("\t 𝝣「 📧 」➜ Data de Empréstimo: " + dataEmprestimo);
	        System.out.println("\t 𝝣「 📧 」➜ Data para Devolver: " + dataDevolver);
		} else {
	        System.out.println("\t 𝝣「 ✖ 」➜ Filme indisponível ou não encontrado.");
	    }
	}

}