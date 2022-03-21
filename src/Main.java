
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {

		ArrayList<Cliente> listaClientes = new ArrayList<>();

		Scanner teclado = new Scanner(System.in);

		while (true) {
			System.out.println("==========================");
			System.out.println("");
			System.out.println("Selecione a opção desejada");
			System.out.println("");
			System.out.println("==========================");
			System.out.println("");
			System.out.println("1 - CADASTRAR CLIENTES");
			System.out.println("2 - LISTAR CLIENTES");
			System.out.println("3 - GRAVAR EM ARQUIVO DE TEXTO");
			System.out.println("4 - CONSULTAR ARQUIVO DE TEXTO");
			System.out.println();

			int opcao = teclado.nextInt();
			System.out.println();

			switch (opcao) {
			case 1:
				System.out.println("Quantos clientes deseja cadastrar?");
				int quantidadeCliente = teclado.nextInt();
				System.out.println();

				for (int i = 0; i < quantidadeCliente; i++) {
					Cliente cliente = new Cliente();
					System.out.println("Nome:");
					cliente.setNome(teclado.next());
					System.out.println();

					System.out.println("e-mail:");
					cliente.setEmail(teclado.next());
					System.out.println();
				
					System.out.println("Telefone:");
					cliente.setTelefone(teclado.next());
					System.out.println();
					
					System.out.println("Agência:");
					cliente.setAgencia(teclado.next());
					System.out.println();
					
					System.out.println("Conta:");
					cliente.setConta(teclado.next());
					System.out.println();
					
					System.out.println("Saldo:");
					cliente.setSaldo(teclado.nextDouble());
					System.out.println();
	
						listaClientes.add(cliente);
				}

				System.out.println("Cadastro finalizado!");
				System.out.println();
				Thread.sleep(1000);
				break;

			case 2:
				for (Cliente cliente : listaClientes) {
					System.out.println("Cliente: " +cliente.getNome()+ "\n" + "e-mail: " +cliente.getEmail()+ "\n" + 
					"Telefone: " +cliente.getTelefone()+ "\n" + "Agência: " +cliente.getAgencia()+ "\n" + "Conta: " +cliente.getConta()+ 
					"\n" + "Saldo: " +String.format("%.2f", cliente.getSaldo()));
					System.out.println("==================");
				}
				Thread.sleep(1000);
				break;

			case 3:
				FileWriter arquivo = new FileWriter("c:\\Users\\Rafael\\Documents\\Cadastro_Correntista.txt");
				PrintWriter gravando = new PrintWriter(arquivo);

				gravando.printf("Cadastro Clientes Correntistas" + "%n");
				gravando.printf("------------------------------" + "%n");
				System.out.println();

				
				for (Cliente cliente : listaClientes) {
					gravando.println("Cliente: " +cliente.getNome()+ "\n" + "e-mail: " +cliente.getEmail()+ "\n" + 
										"Telefone: " +cliente.getTelefone()+ "\n" + "Agência: " +cliente.getAgencia()+ "\n" + "Conta: " +cliente.getConta()+ 
										"\n" + "Saldo: " +String.format("%.2f", cliente.getSaldo()));
					gravando.println("==================");
				}

				arquivo.close();
				System.out.println("Arquivo salvo na unidade c:\\Users\\Rafael\\Documents\\Cadastro_Correntista.txt");
				Thread.sleep(1000);
				break;

			case 4:
				LeituraArquivo leituraArquivo = new LeituraArquivo();
				leituraArquivo.lerArquivo(); 
				break;

			default:
				System.out.println("Opção inválida! Digite uma opção válida");
				Thread.sleep(1000);
			}
		}

	}

}
