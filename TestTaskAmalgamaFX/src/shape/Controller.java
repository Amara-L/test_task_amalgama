package shape;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import process.IntersectionsProcessing;
import process.IntervalsProcessing;

import javax.swing.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea printIntersections;

    @FXML
    private Button buttonPahtFile;

    @FXML
    private Button enterData;

    @FXML
    private TextField printNumb;

    @FXML
    private TextField pathFile;

    @FXML
    private TextField errorLabel;

    @FXML
    private TextField numb;

    private File fileIntersections;

    @FXML
    void initialize() {

        buttonPahtFile.setOnAction(event -> {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                fileIntersections = fileopen.getSelectedFile();
                pathFile.setText(fileIntersections.getPath());
            }
        });

        enterData.setOnAction(event -> {
            if (!numb.getText().equals("")) {
                if (!pathFile.getText().equals("")){
                    printIntersections.setText("");
                    actionsPressEnterButton();
                } else {
                    printIntersections.setText("Вы не указали адресс списка");
                }
            } else {
                printIntersections.setText("Вы не ввели число");
            }
        });

    }

    public void actionsPressEnterButton() {
        IntersectionsProcessing intersectionsProcessing
                = new IntersectionsProcessing();

        try {
            ArrayList<String> arrayListIntersections = intersectionsProcessing
                    .getListIntersections(new IntervalsProcessing()
                            .readingListIntervals(pathFile.getText()));

            printNumb.setText(intersectionsProcessing.getNearestNumberInIntersection(
                    arrayListIntersections,
                    Integer.parseInt(numb.getText())) + "");

            String intersectionsText = "";
            for (String intersections : arrayListIntersections) {
                intersectionsText += intersections + "\n";
            }

            printIntersections.setText(intersectionsText);

        } catch (NullPointerException e) {
            printIntersections.setText("Пересечения отсутствуют");
        }

    }
}
