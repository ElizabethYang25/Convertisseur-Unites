package application;
//Elizabeth Yang; Mars 5, 2021
//Description: Code pour convertir des unités

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EvalController implements Initializable {

    @FXML
    private ComboBox<String> cboLong1;

    @FXML
    private ComboBox<String> cboLong2;

    @FXML
    private ComboBox<String> cboVol2;
    
    @FXML
    private ComboBox<String> cboVol1;

    @FXML
    private TextField txtLong1;

    @FXML
    private TextField txtVol2;

    @FXML
    private TextField txtVol1;

    @FXML
    private TextField txtM1;

    @FXML
    private TextField txtLong2;

    @FXML
    private TextField txtM2;

    @FXML
    private TextField txtVit2;

    @FXML
    private TextField txtVit1;

    @FXML
    private ComboBox<String> cboM2;

    @FXML
    private ComboBox<String> cboM1;

    @FXML
    private ComboBox<String> cboVit2;

    @FXML
    private ComboBox<String> cboVit1;

    @FXML
    private TextField txtEn1;

    @FXML
    private TextField txtEn2;

    @FXML
    private ComboBox<String> cboEn1;

    @FXML
    private ComboBox<String> cboEn2;

    //longueurs
    private ObservableList<String> listL=(ObservableList<String>)FXCollections.observableArrayList("Yard","Foot","Inches","Mètre","Centimètre","Millimètre");

    double []tabLong= {1.0,3.0,36,0.9144,91.44,914.4};
    
    //Volume
    private ObservableList<String> listV=(ObservableList<String>)FXCollections.observableArrayList("Litre","Millilitre","Gallon","Fluid Ounce");

    double []tabVol= {1.0,1000.0,0.219969,35.1951};
    
    //Énergy
    private ObservableList<String> listE=(ObservableList<String>)FXCollections.observableArrayList("Joule","Kilojoule","Kilocalorie","Gram Calorie");

    double []tabEn= {1.0,0.001,0.000239006,0.239006};
    
    //Masse
    private ObservableList<String> listM=(ObservableList<String>)FXCollections.observableArrayList("Kilogram","Gram","Milligram","Tonne","Pound","Ounce");

    double []tabMas= {1.0,1000,1000000,0.001,2.20462,35.274};
    
    //Vitesse
    private ObservableList<String> listVit=(ObservableList<String>)FXCollections.observableArrayList("Meters per second","Kilometer per second","Miles per hour","Foot per second");

    double []tabVit= {1.0,3.6,2.23694,3.28084};
    
    
    
    
    public void initialize(URL location, ResourceBundle resources) 
		{
    		//longueur
    		cboLong1.setItems(listL);
    		cboLong2.setItems(listL);
    		cboLong1.getSelectionModel().selectFirst();
    		cboLong2.getSelectionModel().selectFirst();
			
			//volume
    		cboVol1.setItems(listV);
			cboVol2.setItems(listV);
			cboVol1.getSelectionModel().selectFirst();
			cboVol2.getSelectionModel().selectFirst();
			
			//température
			cboEn1.setItems(listE);
			cboEn2.setItems(listE);
			cboEn1.getSelectionModel().selectFirst();
			cboEn2.getSelectionModel().selectFirst();
			
			//masse
			cboM1.setItems(listM);
			cboM2.setItems(listM);
			cboM1.getSelectionModel().selectFirst();
			cboM2.getSelectionModel().selectFirst();
			
			//vitesse
			cboVit2.setItems(listVit);
			cboVit1.setItems(listVit);
			cboVit2.getSelectionModel().selectFirst();
			cboVit1.getSelectionModel().selectFirst();
			
		} 
    
    //longueur
    @FXML
	void calculerLong1()	
	{
		Convertir(txtLong1,txtLong2,cboLong1,cboLong2,tabLong);			
	}
	
	@FXML
	void calculerLong2()	
	{
		Convertir(txtLong1,txtLong2,cboLong1,cboLong2,tabLong);
	}
    
	 //volume
    @FXML
	void calculerVol1()	
	{
		Convertir(txtVol1,txtVol2,cboVol1,cboVol2,tabVol);			
	}
	
	@FXML
	void calculerVol2()	
	{
		Convertir(txtVol1,txtVol2,cboVol1,cboVol2,tabVol);
	}
	
	 //température
    @FXML
	void calculerTemp1()	
	{
		Convertir(txtEn1,txtEn2,cboEn1,cboEn2,tabEn);		
	}
	
	@FXML
	void calculerTemp2()	
	{
		Convertir(txtEn1,txtEn2,cboEn1,cboEn2,tabEn);
	}
	
	//masse
	@FXML
	void calculerMasse1()	
	{
		Convertir(txtM1,txtM2,cboM1,cboM2,tabMas);			
	}
	
	@FXML
	void calculerMasse2()	
	{
		Convertir(txtM1,txtM2,cboM1,cboM2,tabMas);
	}
	
	//vitesse
	@FXML
	void calculerVitesse1()	
	{
		Convertir(txtVit1,txtVit2,cboVit1,cboVit2,tabVit);		
	}
		
	@FXML
	void calculerVitesse2()	
	{
		Convertir(txtVit1,txtVit2,cboVit1,cboVit2,tabVit);
	}
	
	
	
	public void Convertir(TextField txtA, TextField txtB, ComboBox boxA, ComboBox boxB,double [] tab)
    {
    	verifNum(txtA);
    	
    	int item1=boxA.getSelectionModel().getSelectedIndex();
		int item2=boxB.getSelectionModel().getSelectedIndex();
		try
		{
			double taux=tab[item2]/tab[item1];
			double res=taux*(Double.parseDouble(txtA.getText()));
			txtB.setText(Double.toString(res));
		}catch (NumberFormatException e)
		{
			txtB.setText("");
		}
    }

	 //Gestion numérique - accepter des caractères numériques seulement
    public void verifNum(TextField a)
    {
    	if(a.getText().equals("")) a.setText("");
    	a.textProperty().addListener((observable,oldValue,newValue)->
    	{
    		if(!newValue.matches("^[0-9](\\.[0-9]+)?$")) 
    			{
    				a.setText(newValue.replaceAll("[^\\d*\\.]", ""));
    			}
    	});
    	
    }
    
    
    
}

