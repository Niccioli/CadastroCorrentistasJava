import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class LeituraArquivo {
	
	public void lerArquivo() {
		
		String enderecoArquivo = "c:\\Users\\Rafael\\Documents\\Cadastro_Correntista.txt";
		File arquivoGravado = new File(enderecoArquivo);

		if (arquivoGravado.exists()) {
			String mostrar = "Arquivo - " + enderecoArquivo + ", aberto com sucesso" +"\n" + "\n";
			
			try {
				FileReader reader = new FileReader(enderecoArquivo);
				BufferedReader leitor = new BufferedReader(reader);
				while (true) {
					String linha = leitor.readLine();
					System.out.println(linha);
					if (linha == null)
						break;
					mostrar += linha + "\n";
				}
			} catch (Exception erro) {}
			JOptionPane.showMessageDialog(null, mostrar, "Arquivo...", 1);
		} else
			JOptionPane.showMessageDialog(null, "Arquivo Inexistente", "Erro", 0);		
	}
}
