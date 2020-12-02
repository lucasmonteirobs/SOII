import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

public enum Opcoes {
	SAIR(0, "Sair"),
	CRIA_DIRETORIO(1, "Cria diretorio"),
	LISTA_DIRETORIO(2, "Lista o conteudo do diretorio"),
	DELETA_ARQUIVO(3, "Deleta arquivo"),
	INSERE_ARQUIVO(4, "Insere arquivo"),
	EXIBIR_CONTEUDO(5, "Exibir conteudo de arquivo texto");
	
	private Integer codigo;
	private String descricao;
	private static Map<Integer, Opcoes> mapOpcoes = getMapOpcoes();
	
	Opcoes(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	private static Map<Integer, Opcoes> getMapOpcoes() {
		HashMap<Integer, Opcoes> mapOpcoes = new HashMap<Integer, Opcoes>();
		
		for(Opcoes opcao : values()) {
			mapOpcoes.put(opcao.getCodigo(), opcao);
		}
		
		return mapOpcoes;
	}
	
	public static Opcoes getOpcao(Integer codigo) {
		return mapOpcoes.get(codigo);
	}

	public static void imprimeOpcoes() {
		
		pulaLinha();
		
		imprimeLinha();
		
		for(Opcoes opcao : values()) {
			opcao.imprime();
		}
		
		imprimeLinha();
		
		imprimeSeta();
	}
	
	private static void pulaLinha() {
		System.out.println();
	}

	private static void imprimeLinha() {
		System.out.println("-------------------------------------------");
	}
	
	public void imprime() {
		System.out.println(MessageFormat.format("{0} - {1}", codigo, descricao));
	}
	
	private static void imprimeSeta() {
		System.out.print("--> ");
	}
	
}
