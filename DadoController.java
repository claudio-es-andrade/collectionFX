package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

// As alterações
import application.TextFieldFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class DadoController {

	@FXML
    private Button btnVRFC;
	
	@FXML
    private Label lblFCE_1;

    @FXML
    private Label lblFCE_2;

    @FXML
    private Label lblFCE_3;

    @FXML
    private Label lblFCE_4;

    @FXML
    private Label lblFCE_5;

    @FXML
    private Label lblFCE_6;
    
    @FXML
    private Label lblMsg;


	@FXML
	private TextField txtFld_VLR;



	@FXML
	void txtFldRLS_VLR(KeyEvent event) {
		
		TextFieldFormatter txtFldFMT = new TextFieldFormatter();
		txtFldFMT.setMask("######");
		txtFldFMT.setCaracteresValidos("0123456789");
		txtFldFMT.setTf(txtFld_VLR);
		txtFldFMT.formatter();
	}
	
	@FXML
	public void onClickedBtn(ActionEvent event) {
	
		String dadoTxtFLD_VLR = txtFld_VLR.getText();
		String dadoNumberOnly = dadoTxtFLD_VLR.replaceAll("[^0-9]", "");
		int valorDaRodada = Integer.parseInt(dadoTxtFLD_VLR  );
		//lblMsg.setText(" Acrescente valores maiores que 100 ");
		
				  
		//System.out.println(" -> converted: " + valorDaRodada);
		Integer  valor = (Integer) valorDaRodada;
		 
		TreeMap<String, Integer> jogadorVisual   =  new TreeMap<>();
		jogadorVisual.putAll( jogarDado(valor)  );
		
		Integer face1 = jogadorVisual.get("Número 1: ");
		Integer face2 = jogadorVisual.get("Número 2: ");
		Integer face3 = jogadorVisual.get("Número 3: ");
		Integer face4 = jogadorVisual.get("Número 4: ");
		Integer face5 = jogadorVisual.get("Número 5: ");
		Integer face6 = jogadorVisual.get("Número 6: ");
		
		String  valor_1 = String.valueOf(face1);
		lblFCE_1.setDisable(false);
		lblFCE_1.setVisible(true);
		lblFCE_1.setTextFill(Color.RED);
		lblFCE_1.setText(valor_1);
		
		String  valor_2 = String.valueOf(face2);
		lblFCE_2.setDisable(false);
		lblFCE_2.setVisible(true);
		lblFCE_2.setTextFill(Color.RED);
		lblFCE_2.setText(valor_2);
		
		String  valor_3 = String.valueOf(face3);
		lblFCE_3.setDisable(false);
		lblFCE_3.setVisible(true);
		lblFCE_3.setTextFill(Color.RED);
		lblFCE_3.setText(valor_3);
		
		String  valor_4 = String.valueOf(face4);
		lblFCE_4.setDisable(false);
		lblFCE_4.setVisible(true);
		lblFCE_4.setTextFill(Color.RED);
		lblFCE_4.setText(valor_4);
		
		String  valor_5 = String.valueOf(face5);
		lblFCE_5.setDisable(false);
		lblFCE_5.setVisible(true);	
		lblFCE_5.setTextFill(Color.RED);
		lblFCE_5.setText(valor_5);
		
		String  valor_6 = String.valueOf(face6);
		lblFCE_6.setDisable(false);
		lblFCE_6.setVisible(true);
		lblFCE_6.setTextFill(Color.RED);
		lblFCE_6.setText(valor_6);
		
	}
	// Algoritmo para transformação dos itens em um Map
	public static TreeMap<String , Integer> jogarDado(int quantidade){

		TreeMap<String , Integer> valoresEncontrados = new TreeMap<>();
		valoresEncontrados.put("Número 1: ", 0);
		valoresEncontrados.put("Número 2: ", 0);
		valoresEncontrados.put("Número 3: ", 0);
		valoresEncontrados.put("Número 4: ", 0);
		valoresEncontrados.put("Número 5: ", 0);
		valoresEncontrados.put("Número 6: ", 0);

		int somatorioUm      = 0;
		int somatorioDois    = 0;
		int somatorioTres    = 0;
		int somatorioQuatro  = 0;
		int somatorioCinco   = 0;
		int somatorioSeis    = 0;
		
		//int quantidadeJogadaMaisErro = quantidade ;
		//System.out.println("Quantidade: " + quantidade);
		
		for (int contadorJogadasMinimo = 1; contadorJogadasMinimo <= quantidade ; contadorJogadasMinimo++ ) {

			int valorEncontrado  = gerarNumerosInteirosAleatorios(1 , 6);
			//System.out.println("Valor Encontrado: " + valorEncontrado);

			switch(valorEncontrado) {
			case (1):{
				somatorioUm += 1;
				valoresEncontrados.put("Número 1: ", somatorioUm  );
				break;
			}
			case (2):{
				somatorioDois += 1;
				valoresEncontrados.put("Número 2: ", somatorioDois  );
				break;
			}
			case (3):{
				somatorioTres += 1;
				valoresEncontrados.put("Número 3: ", somatorioTres  );
				break;
			}
			case (4):{
				somatorioQuatro += 1;
				valoresEncontrados.put("Número 4: ", somatorioQuatro  );
				break;
			}
			case (5):{
				somatorioCinco += 1;
				valoresEncontrados.put("Número 5: ", somatorioCinco   );
				break;
			}
			case (6):{
				somatorioSeis += 1;
				valoresEncontrados.put("Número 6: ", somatorioSeis  );
				break;
			}

			}
		}
		return valoresEncontrados;
	}

	public static int gerarNumerosInteirosAleatorios(int min, int max) {
		Random random = new Random();
		int valorEncontrado = random.nextInt(max  - min) + min;
		//System.out.println("Valor Encontrado dentro de Gerar Numeros Aleatorios " + valorEncontrado);
  		return valorEncontrado;
    }
	
	
}
