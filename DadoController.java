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
    private TextField txtLBL_1;

    @FXML
    private TextField txtLBL_2;

    @FXML
    private TextField txtLBL_3;

    @FXML
    private TextField txtLBL_4;

    @FXML
    private TextField txtLBL_5;

    @FXML
    private TextField txtLBL_6;


	@FXML
	private TextField txtFld_VLR;



	@FXML
	void txtFldRLS_VLR(KeyEvent event) {
		
		TextFieldFormatter txtFldFMT = new TextFieldFormatter();
		txtFldFMT.setMask("###");
		txtFldFMT.setCaracteresValidos("0123456789");
		txtFldFMT.setTf(txtFld_VLR);
		txtFldFMT.formatter();
	}
	
	@FXML
	public void onClickedBtn(ActionEvent event) {
		
		String dadoTxtFLD_VLR = txtFld_VLR.getText();
		
		String dadoNumberOnly = dadoTxtFLD_VLR.replaceAll("[^0-9]", "");
	
		int valorDaRodada = Integer.parseInt(dadoTxtFLD_VLR  );
		  
		System.out.print(" -> converted: " + valorDaRodada);
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
		txtLBL_1.setDisable(false);
		txtLBL_1.setVisible(true);
		txtLBL_1.setText(valor_1);
		
		String  valor_2 = String.valueOf(face2);
		txtLBL_2.setDisable(false);
		txtLBL_2.setVisible(true);
		txtLBL_2.setText(valor_2);
		
		String  valor_3 = String.valueOf(face3);
		txtLBL_3.setDisable(false);
		txtLBL_3.setVisible(true);
		txtLBL_3.setText(valor_3);
		
		String  valor_4 = String.valueOf(face4);
		txtLBL_4.setDisable(false);
		txtLBL_4.setVisible(true);
		txtLBL_4.setText(valor_4);
		
		String  valor_5 = String.valueOf(face5);
		txtLBL_5.setDisable(false);
		txtLBL_5.setVisible(true);		
		txtLBL_5.setText(valor_5);
		
		String  valor_6 = String.valueOf(face6);
		txtLBL_6.setDisable(false);
		txtLBL_6.setVisible(true);
		txtLBL_6.setText(valor_6);
		
	}
	// Algoritmo para transformação dos itens em um Map
	public static TreeMap<String , Integer> jogarDado(int quantidade){

		TreeMap<String , Integer> valoresEncontrados = new TreeMap<>();

		int somatorioUm = 0;
		int somatorioDois = 0;
		int somatorioTres = 0;
		int somatorioQuatro = 0;
		int somatorioCinco = 0;
		int somatorioSeis = 0;
		int quantidadeJogada = quantidade + 6;
		for (int i = 0; i < quantidadeJogada; i++) {
			int valorEncontrado  = gerarNumerosInteirosAleatorios(1 , 6);
			switch(valorEncontrado) {
			case (1):{
				valoresEncontrados.put("Número 1: ", somatorioUm++);
				break;
			}
			case (2):{
				valoresEncontrados.put("Número 2: ", somatorioDois++);
				break;
			}
			case (3):{
				valoresEncontrados.put("Número 3: ", somatorioTres++);
				break;
			}
			case (4):{
				valoresEncontrados.put("Número 4: ", somatorioQuatro++);
				break;
			}
			case (5):{
				valoresEncontrados.put("Número 5: ", somatorioCinco++);
				break;
			}
			case (6):{
				valoresEncontrados.put("Número 6: ", somatorioSeis++);
				break;
			}

			}

		}
		
		return valoresEncontrados;
	}
	
	public static int gerarNumerosInteirosAleatorios(int min, int max) {
    	Random random = new Random();
    	int valorEncontrado = random.nextInt((max + 1) - min) + min;
  		return valorEncontrado;
    }
	
	
}
