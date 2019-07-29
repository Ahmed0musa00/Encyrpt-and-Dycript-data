/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucrity;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 *
 * @author dbah
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private TextArea encrypt_text_area;
    @FXML
    private TextArea decrypt_text_area;
    @FXML
    private Button encrypt_button;
    @FXML
    private TextField key_caecier;
    @FXML
    private AnchorPane asd;
    @FXML
    private Text warn_text;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private TextField alphabitc_key;
    @FXML
    private Button clear_button;

    @FXML
    private void clear(ActionEvent event) {
        encrypt_text_area.setText("");
        decrypt_text_area.setText("");
        key_caecier.setText("");
        alphabitc_key.setText("");
    }

    @FXML
    private void encrypt(ActionEvent event) {
        caeser_cipher c = new caeser_cipher();

        switch (choice.getValue()) {

            case "Caeser Cipher":

                try {
                    warn_text.setText("");
                    int y = Integer.parseInt(key_caecier.getText());
                    String s = c.Encrypted(encrypt_text_area.getText(), y);

                    decrypt_text_area.setText("");
                    encrypt_text_area.setText("");

                    decrypt_text_area.setText(s);
                } catch (Exception e) {

                    warn_text.setText(" key must be number !");

                    System.out.println("err" + e);

                }
                break;
            //----------------- Vigenere Cipher---------------------------------------
            case "Vigenere Cipher":

                try {
                    char ch1[] = key_caecier.getText().toCharArray();
                    System.out.println(Character.isLetter(ch1[0]));
                    warn_text.setText("");
                    if (!Character.isLetter(ch1[0])) {
                        try {
                            throw new Exception("enter string");
                        } catch (Exception e) {
                            encrypt_text_area.setText("");
                            warn_text.setText(" key must be letter !");
                        }

                    }

                    String s = Vigenere_Cipher.encrypt(encrypt_text_area.getText(), key_caecier.getText());
                    encrypt_text_area.setText("");

                    decrypt_text_area.setText("");
                    decrypt_text_area.setText(s);
                } catch (Exception e) {

                    System.out.println("err" + e);
                }
                break;
            //--------------------Atbash-------------------------
            case "Atbash":

                try {

                    key_caecier.setVisible(false);
                    warn_text.setText("");
                    String s = Atbash.Encryption(encrypt_text_area.getText());
                    encrypt_text_area.setText("");

                    decrypt_text_area.setText("");
                    decrypt_text_area.setText(s);

                } catch (Exception e) {

                    warn_text.setText(" key must be number !");

                    System.out.println("err" + e);

                }
                break;

            //-----------------------------------
            case "Custom Cipher":

                try {

                    char ch1[] = alphabitc_key.getText().toCharArray();
                    System.out.println(Character.isLetter(ch1[0]));
                    warn_text.setText("");
                    System.out.println(Character.isLetter(ch1[0]));
                    if (!Character.isLetter(ch1[0])) {
                        try {
                            throw new Exception("enter string");
                        } catch (Exception e) {
                            encrypt_text_area.setText("");
                            warn_text.setText(" key must be letter !");
                        }
                    }
                    // code
                    warn_text.setText("");
                    int y = Integer.parseInt(key_caecier.getText());

                    String s = c.Encrypted(encrypt_text_area.getText(), y);
                    System.out.println("s_encrypt" + s);

                    String v = Vigenere_Cipher.encrypt(s, alphabitc_key.getText());
                    System.out.println("v_encrypt" + v);
                    String ab = Atbash.Encryption(v);
                    encrypt_text_area.setText("");

                    decrypt_text_area.setText("");
                    decrypt_text_area.setText(ab);
                    System.out.println("ab_encrypt" + ab);

                } catch (Exception e) {

                    warn_text.setText(" key must be number !");

                    System.out.println("err" + e);

                }

        }

    }

    @FXML
    private void decrypt(ActionEvent event) {
        caeser_cipher c = new caeser_cipher();

        switch (choice.getValue()) {

            case "Caeser Cipher":

                try {

                    warn_text.setText("");
                    int y = Integer.parseInt(key_caecier.getText());
                    String s = c.decrypt(decrypt_text_area.getText(), y);
                    encrypt_text_area.setText("");
                    decrypt_text_area.setText("");
                    encrypt_text_area.setText(s);
                } catch (Exception e) {

                    warn_text.setText(" key must be number !");

                    System.out.println("err" + e);

                }

                break;
            //-----------------------  Vigenere Cipher-----------------------
            case "Vigenere Cipher":

                try {
                    char ch1[] = key_caecier.getText().toCharArray();
                    System.out.println(Character.isLetter(ch1[0]));
                    warn_text.setText("");
                    if (!Character.isLetter(ch1[0])) {
                        try {
                            throw new Exception("enter string");
                        } catch (Exception e) {
                            encrypt_text_area.setText("");
                            warn_text.setText(" key must be letter !");
                        }

                    }
                    String s = Vigenere_Cipher.decrypt(decrypt_text_area.getText(), key_caecier.getText());
                    decrypt_text_area.setText("");

                    encrypt_text_area.setText("");
                    encrypt_text_area.setText(s);
                } catch (Exception e) {

                    System.out.println("err" + e);

                }
                break;

            //-------------------------Atbash------------------------------------
            case "Atbash":

                try {

                    warn_text.setText("");

                    String s = Atbash.Decryption(decrypt_text_area.getText());
                    decrypt_text_area.setText("");

                    encrypt_text_area.setText("");
                    encrypt_text_area.setText(s);
                } catch (Exception e) {

                    warn_text.setText(" key must be letter !");

                    System.out.println("err" + e);

                }
                break;

            //---------------------------------
            case "Custom Cipher":

                try {
                    char ch1[] = alphabitc_key.getText().toCharArray();
                    warn_text.setText("");
                    if (!Character.isLetter(ch1[0])) {
                        try {
                            throw new Exception("enter string");
                        } catch (Exception e) {
                            encrypt_text_area.setText("");
                            warn_text.setText(" key must be letter !");
                        }

                    }
                    warn_text.setText("");

                    String s = Atbash.Decryption(decrypt_text_area.getText());
                    System.out.println("s :" + s);
                    String v = Vigenere_Cipher.decrypt(s, alphabitc_key.getText());
                    System.out.println("v: " + v);
                    int y = Integer.parseInt(key_caecier.getText());
                    v = v.toLowerCase();
                    String ce = c.decrypt(v, y);
                    System.out.println("ce:" + ce);
                    encrypt_text_area.setText("");
                    decrypt_text_area.setText("");

                    encrypt_text_area.setText(ce);

                } catch (Exception e) {

                    warn_text.setText(" key must be letter !");

                    System.out.println("err" + e);

                }

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        alphabitc_key.setVisible(false);

        choice.getItems().addAll("Caeser Cipher", "Vigenere Cipher", "Atbash", "Custom Cipher");
        choice.setValue("Caeser Cipher");

        choice.getSelectionModel().selectedItemProperty().addListener((v, old, ne)
                -> {
            decrypt_text_area.setText("");
            encrypt_text_area.setText("");
            key_caecier.setText("");

            if (choice.getValue() == "Atbash") {
                key_caecier.setVisible(false);
                alphabitc_key.setVisible(false);
            } else if (choice.getValue() == "Custom Cipher") {
                alphabitc_key.setVisible(true);
                key_caecier.setVisible(true);

            } else {
                alphabitc_key.setVisible(false);
                key_caecier.setVisible(true);

            }

        });
    }

}
