package kg.megacom.okhttptest.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import kg.megacom.okhttptest.helper.DbHelper;
import kg.megacom.okhttptest.http.HttpClientHelper;
import kg.megacom.okhttptest.models.Lot;
import kg.megacom.okhttptest.models.StatusDto;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LotHttpRequestCtrl {
    private Stage stage;
    private Lot lot;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Lot> cmbxGetField;

    @FXML
    private TextField txtGetValue;

    @FXML
    private TextField txtHttpGetServerAddress;

    @FXML
    private TableView<Lot> tbGet;

    @FXML
    private TableColumn<Lot, String> colmName;

    @FXML
    private TableColumn<Lot, Double> colmMinPrice;

    @FXML
    private TableColumn<Lot, Double> colmPrice;

    @FXML
    private TableColumn<Lot, Date> colmStartDate;

    @FXML
    private TableColumn<Lot, Date> colmEndDate;

    @FXML
    private TableColumn<Lot, Double> colmStep;

    @FXML
    private TextField txtHttpPostServerAddress;

    @FXML
    private TextField txtPostName;

    @FXML
    private TextField txtPostMinPrice;

    @FXML
    private TextField txtPostPrice;

    @FXML
    private TextField txtPostStep;

    @FXML
    private TextField txtPostStartDate;

    @FXML
    private TextField txtPostEndDate;

    @FXML
    private ComboBox<StatusDto> cmbxStatus;


    @FXML
    private Button btnPost;

    @FXML
    private Button btnGet;

    @FXML
    private Button btnCencel;

    @FXML
    void OnButtonClicked(ActionEvent event) throws IOException {
        if (event.getSource().equals(btnGet)){
            onGetButton();
        }else if (event.getSource().equals(btnPost)){
            try {
                onPostButton();
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (event.getSource().equals(btnCencel)){
            onCencelButton();
        }

    }

    private void onCencelButton() {
        if (stage!=null){
            stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
        }
    }

    private void onPostButton() throws IOException, ParseException {
        Lot lot=new Lot();
        String httpPostServer=txtHttpPostServerAddress.getText();
        System.out.println(httpPostServer);

        lot.setLotName(txtPostName.getText());
        lot.setMinPrice(Double.parseDouble(txtPostMinPrice.getText()));
        lot.setLotPrice(Double.parseDouble(txtPostPrice.getText()));
        lot.setStep(Double.parseDouble(txtPostStep.getText()));
        lot.setStartDate(new SimpleDateFormat("dd/MM/yyyy").parse(txtPostStartDate.getText()));
        lot.setEndDate(new SimpleDateFormat("dd/MM/yyyy").parse(txtPostEndDate.getText()));
        lot.setStatusDto(cmbxStatus.getSelectionModel().getSelectedItem());
        System.out.println("До INSTANCE: "+lot);
        HttpClientHelper.INSTANCE.saveLot(lot, httpPostServer);

    }

    private void onGetButton() throws IOException {
        String httpGetServer=txtHttpGetServerAddress.getText();
        int id=Integer.parseInt(txtGetValue.getText());
        Lot lot=HttpClientHelper.INSTANCE.getLot(id, httpGetServer);
        List<Lot> list= Arrays.asList(lot);
        ObservableList<Lot> observableList=FXCollections.observableList(list);
        tbGet.setItems(observableList);

    }

    @FXML
    void initialize() {
        List<StatusDto> list = DbHelper.INSTANCE.getStatus();
        ObservableList<StatusDto> observableList = FXCollections.observableList(list);
        cmbxStatus.setItems(observableList);

        //Fill table view

        colmName.setCellValueFactory(new PropertyValueFactory<Lot, String>("lotName"));
        colmPrice.setCellValueFactory(new PropertyValueFactory<Lot, Double>("lotPrice"));
        colmMinPrice.setCellValueFactory(new PropertyValueFactory<Lot, Double>("minPrice"));
        colmStartDate.setCellValueFactory(new PropertyValueFactory<Lot, Date>("startDate"));
        colmEndDate.setCellValueFactory(new PropertyValueFactory<Lot, Date>("endDate"));
        colmStep.setCellValueFactory(new PropertyValueFactory<Lot, Double>("step"));

    }

    /*Callback<ListView<StatusDto>, ListCell<StatusDto>> cellFactory = new Callback<ListView<StatusDto>, ListCell<StatusDto>>() {

        @Override
        public ListCell<StatusDto> call(ListView<StatusDto> l) {
            return new ListCell<StatusDto>() {

                @Override
                protected void updateItem(StatusDto item, boolean empty) {
                    super.updateItem(item, empty);
                    if (item == null || empty) {
                        setGraphic(null);
                    } else {
                        setText(*//*item.getId() + "    " +*//* item.getName());
                    }
                }
            } ;
        }
    };*/
}
