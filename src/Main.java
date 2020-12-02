import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Opcoes opcao = null;
		Gerenciador gerenciador = new Gerenciador();
		
		do {
			Opcoes.imprimeOpcoes();
			opcao = Opcoes.getOpcao(sc.nextInt());
			executa(opcao, sc, gerenciador);
		} while(!Opcoes.SAIR.equals(opcao));
		
		sc.close();
		
		imprimeDespedida();
	}

	private static void imprimeDespedida() {
		System.out.println();
		System.out.println("Programa encerrado");
	}
	
	private static void executa(Opcoes opcao, Scanner sc, Gerenciador gerenciador) {
		
		System.out.println();
		sc.nextLine();
		
		switch(opcao) {
		case CRIA_DIRETORIO:
			gerenciador.criaDiretorio(sc);
			break;
		case DELETA_ARQUIVO:
			gerenciador.deletaArquivo(sc);
			break;
		case INSERE_ARQUIVO:
			Gerenciador.insereArquivo(sc);
			break;
		case EXIBIR_CONTEUDO:
			Gerenciador.leConteudoArquivoTexto(sc);
			break;
		case LISTA_DIRETORIO:
			Gerenciador.listaConteudoDiretorio(sc);
			break;
		default:
			break;
		
		}
	}
	
	
}
