import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Gerenciador {

	public static String PATH_RAIZ = System.getProperty("user.dir") + "\\";
	
	/**
	 * Cria um diretorio, localizado no diretorio raiz do projeto
	 */
	public void criaDiretorio(Scanner sc) {
		
		System.out.println("Informe o nome do diretorio");
		System.out.print(">>>> ");
		
		String nome = sc.nextLine();
		
		System.out.println();
		
		File file = new File(PATH_RAIZ+nome);

		try {
			if (file.mkdir()) {
				System.out.println("Diretorio criado com sucesso");
			} else {
				System.out.println("Não foi possivel criar o diretorio");
			}
		} catch (SecurityException e) {
			System.out.println("Sem permissão para criar o diretorio");
		}
	}
	
	/**
	 * Remove um arquivo no caminho informado a partir do caminho do diretorio raiz do projeto
	 */
	public void deletaArquivo(Scanner sc) {
		
		System.out.println("Informe o caminho do arquivo");
		System.out.print(">>>> ");
		
		String nome = sc.nextLine();
		
		System.out.println();
		
		File file = new File(PATH_RAIZ+nome);

		try {
			if (file.delete()) {
				System.out.println("Arquivo deletado!");
			} else {
				System.out.println("Erro ao deletar arquivo!");
			}
		} catch (SecurityException e) {
			System.out.println("Erro de permissão ao deletar arquivo!");
		}
	}
	
	/**
	 * Copia um arquivo da origem informada dentro do computador para um caminho dentro do projeto.
	 */
	public static void insereArquivo(Scanner sc) {
		
		System.out.println("Informe a origem do arquivo");
		System.out.print(">>>> ");
		
		String origem = sc.nextLine();
		
		System.out.println();
		
		System.out.println("Informe o destino mais o nome do arquivo dentro do projeto");
		System.out.print(">>>> ");
		
		String destino = sc.nextLine();
		
		System.out.println();
		
		try {
			File srcFile = new File(origem);
			File dstFile = new File(PATH_RAIZ+destino);

			FileInputStream srcFileInStream = new FileInputStream(srcFile);
			FileOutputStream dstFileOutStream = new FileOutputStream(dstFile);

			byte [] buffer = new byte[4096];
			
			int lido = 0;
			do {
				lido = srcFileInStream.read(buffer);
				if (lido > 0) {
					dstFileOutStream.write(buffer,0,lido);
				}
			} while (lido > 0);

			srcFileInStream.close();
			dstFileOutStream.close();
			System.out.println("Arquivo copiado com sucesso!");
			
		} catch (FileNotFoundException e) {
			System.out.println("arquivo não encontrado!");
			
		} catch (IOException e) {
			System.out.println("Erro ao inserir o arquivo!");
		}
	}
	
	/**
	 * Exibe o conteudo de um arquivo texto especificado pelo caminho informado.
	 */
	public static void leConteudoArquivoTexto(Scanner sc) {
		
		System.out.println("Informe o caminho do arquivo texto");
		System.out.print(">>>> ");
		
		String caminho = sc.nextLine();
		
		System.out.println();
		
		try {
			FileReader file = new FileReader(PATH_RAIZ+caminho);
			BufferedReader bufReader = new BufferedReader(file);
			String linha = "";

			do {
				linha = bufReader.readLine();
				if (linha != null) {
					System.out.println(linha);
				}
			} while (linha != null);

			bufReader.close();
			file.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado!");
			
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo!");
		}
	}
	
	/**
	 * Lista o conteudo do diretorio informado.
	 * Primeiro os diretorios, depois os arquivos, listados em ordem alfabetica.
	 */
	public static void listaConteudoDiretorio(Scanner sc) {
		
		System.out.println("Informe o caminho do diretorio (Se não for informado, ele vai interpretar como se fosse para o diretorio raiz)");
		System.out.print(">>>> ");
		
		String path = sc.nextLine();
		
		System.out.println();

		File file = new File(PATH_RAIZ+path);
		String[] rawFileList = null;
		TreeSet<String> dirList  = new TreeSet<String>();
		TreeSet<String> fileList = new TreeSet<String>();
		
		try {
			rawFileList = file.list();
		} catch (SecurityException e) {
			System.out.println("Erro de permissão!");
			return;
		}
		
		if (rawFileList == null || rawFileList.length == 0) {
			System.out.println("Diretorio vazio!");
			return;
		}
		
		for (String item : rawFileList) {
			file = new File(path + File.separator + item);
			if (file.isDirectory()) {
				dirList.add("Diretorio: " + item);
			} else {
				fileList.add("Arquivo: " + item);
			}
		}
		
		for (String item : dirList) {
			System.out.println(item);
		}
		for (String item : fileList) {
			System.out.println(item);
		}
	}
	
}
