package lotto;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller implements Initializable {

//<editor-fold defaultstate="collapsed" desc="Class variables">
    private final int MAX = 35;
    private final int MIN = 1;

    private int genNum1;
    private int genNum2;
    private int genNum3;
    private int genNum4;
    private int genNum5;
    private int genNum6;
    private int genNum7;

    private int selNum1;
    private int selNum2;
    private int selNum3;
    private int selNum4;
    private int selNum5;
    private int selNum6;
    private int selNum7;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="FXML items import">
    @FXML
    private Pane basePane;
    @FXML
    private Pane alertPane;
    @FXML
    private Button alertButton;
    @FXML
    private Label alertText;

    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label resultLabel;

    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
    @FXML
    private TextField input6;
    @FXML
    private TextField input7;
//</editor-fold>

    @FXML
    private void handleAlertButton(ActionEvent event) {
        basePane.setDisable(false);
        basePane.setOpacity(1);
        alertPane.setVisible(false);
        alertText.setText("");
        System.out.println("Visszatérés a programhoz.");
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        //We are generating numbers.
        genNum1 = 0;
        genNum2 = 0;
        genNum3 = 0;
        genNum4 = 0;
        genNum5 = 0;
        genNum6 = 0;
        genNum7 = 0;

        genNum1 = getRandomNumber();
        genNum2 = getRandomNumber();
        genNum3 = getRandomNumber();
        genNum4 = getRandomNumber();
        genNum5 = getRandomNumber();
        genNum6 = getRandomNumber();
        genNum7 = getRandomNumber();

        calculate();
    }

    private void calculate() {
        //Are they numbers?
        try {
            selNum1 = Integer.parseInt(input1.getText());
            selNum2 = Integer.parseInt(input2.getText());
            selNum3 = Integer.parseInt(input3.getText());
            selNum4 = Integer.parseInt(input4.getText());
            selNum5 = Integer.parseInt(input5.getText());
            selNum6 = Integer.parseInt(input6.getText());
            selNum7 = Integer.parseInt(input7.getText());
        } catch (Exception e) {
            alert("Nem jó számot adtál meg!");
            System.out.println(e);
            return;
        }

        //Are they unique?
        HashSet<Integer> selectedNumbers = new HashSet<>();
        selectedNumbers.add(selNum1);
        selectedNumbers.add(selNum2);
        selectedNumbers.add(selNum3);
        selectedNumbers.add(selNum4);
        selectedNumbers.add(selNum5);
        selectedNumbers.add(selNum6);
        selectedNumbers.add(selNum7);

        if (selectedNumbers.size() < 7) {
            alert("Mind a hét számnak különbözőnek kell lennie!");
            return;
        }

        ArrayList<Integer> userNumbers = new ArrayList<>(selectedNumbers);

        //Are they between 1 and 35?
        for (Integer number : userNumbers) {
            if (number < MIN || number > MAX) {
                alert("Minden számnak 1 és 35 között kell lennie!");
                return;
            }
        }

        //We are setting the generated numbers to the labels.
        label1.setText(String.valueOf(genNum1));
        label2.setText(String.valueOf(genNum2));
        label3.setText(String.valueOf(genNum3));
        label4.setText(String.valueOf(genNum4));
        label5.setText(String.valueOf(genNum5));
        label6.setText(String.valueOf(genNum6));
        label7.setText(String.valueOf(genNum7));

        resultCheck(userNumbers);
    }

    private void resultCheck(ArrayList<Integer> userNumbers) {

        int result = 0;
        int i;
        for (i = 0; i < userNumbers.size(); i++) {
            if (userNumbers.get(i) == genNum1 || userNumbers.get(i) == genNum2
                    || userNumbers.get(i) == genNum3 || userNumbers.get(i) == genNum4
                    || userNumbers.get(i) == genNum5 || userNumbers.get(i) == genNum6
                    || userNumbers.get(i) == genNum7) {
                result++;
            }
        }

        switch (result) {
            case 0:
                resultLabel.setText("Sajnos nem nyertél semmit.");
                break;
            case 1:
                resultLabel.setText("Gratulálunk, " + result + " találata lett!");
                break;
            case 2:
                resultLabel.setText("Gratulálunk, " + result + " találata lett!");
                break;
            case 3:
                resultLabel.setText("Gratulálunk, " + result + " találata lett!");
                break;
            case 4:
                resultLabel.setText("Gratulálunk, " + result + " találata lett!");
                break;
            case 5:
                resultLabel.setText("Gratulálunk, " + result + " találata lett!");
                break;
            case 6:
                resultLabel.setText("Gratulálunk, " + result + " találata lett!");
                break;
            case 7:
                resultLabel.setText("Gratulálunk, " + result + " találata lett!");
                break;
        }
    }

    private void alert(String actualAlert) {
        basePane.setDisable(true);
        basePane.setOpacity(0.3);
        alertPane.setVisible(true);
        alertText.setText(actualAlert);
    }

    private int getRandomNumber() {
        int random = (int) ((Math.random() * MAX) + MIN);

        if (random == genNum1 || random == genNum2
                || random == genNum3 || random == genNum4
                || random == genNum5 || random == genNum6 || random == genNum7) {
            return getRandomNumber();
        }

        return random;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("A program sikeresen elindult.");
    }

}
