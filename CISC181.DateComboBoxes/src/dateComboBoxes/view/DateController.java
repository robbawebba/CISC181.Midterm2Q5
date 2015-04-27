package dateComboBoxes.view;

import java.util.Calendar;
import java.util.Date;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import dateComboBoxes.MainApp;

public class DateController {

	private MainApp mainApp;

	@FXML
	private ComboBox<String> monthBox;
	@FXML 
	private ComboBox<String> dayBox;
	@FXML
	private ComboBox<String> yearBox;

	private Calendar now = Calendar.getInstance();

	private ObservableList<String> days31 = FXCollections.observableArrayList(
			"1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15",
			"16", "17", "18", "19", "20", "21","22","23","24","25","26","27","28",
			"29", "30", "31");
	private ObservableList<String> days30 = FXCollections.observableArrayList(
			"1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15",
			"16", "17", "18", "19", "20", "21","22","23","24","25","26","27","28",
			"29", "30");
	private ObservableList<String> days28 = FXCollections.observableArrayList(
			"1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15",
			"16", "17", "18", "19", "20", "21","22","23","24","25","26","27","28");
	private ObservableList<String> days29 = FXCollections.observableArrayList(
			"1", "2", "3", "4", "5", "6","7","8","9","10","11","12","13","14","15",
			"16", "17", "18", "19", "20", "21","22","23","24","25","26","27","28",
			"29");
	private ObservableList<String> months = FXCollections.observableArrayList(
			"January", "February", "March", "April", "May", "June", "July", 
			"August", "September", "October", "November", "December");
	private ObservableList<String> years = FXCollections.observableArrayList(
			"2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", 
			"2018", "2019", "2020");

	public DateController() {
	}

	@FXML
	public void initialize() {
		monthBox.setItems(months);
		monthBox.setValue(monthSwitch(1+now.get(Calendar.MONTH)));
		yearBox.setItems(years);		
		yearBox.setValue(""+now.get(Calendar.YEAR)+"");
		handleMonth();
		handleYear();
		dayBox.setValue(""+now.get(Calendar.DATE)+"");
	}
	

	@FXML
	private void handleMonth() {
		if(monthBox.getValue().equals("January") || 
				monthBox.getValue().equals("March") || 
				monthBox.getValue().equals("May") ||
				monthBox.getValue().equals("July") || 
				monthBox.getValue().equals("August") || 
				monthBox.getValue().equals("October") ||
				monthBox.getValue().equals("December")) {
			dayBox.setItems(days31);
		}
		else if(monthBox.getValue().equals("September") || 
				monthBox.getValue().equals("April") || 
				monthBox.getValue().equals("June") ||
				monthBox.getValue().equals("November")) {
			dayBox.setItems(days30);
		}
		else if(monthBox.getValue().equals("February")) {
			daysFebruary();
		}
		
		

	}

	private void daysFebruary() {
		if(yearBox.getValue().equals("2012") || 
				yearBox.getValue().equals("2016") ||
				yearBox.getValue().equals("2020")) {
			dayBox.setItems(days29);
		} else dayBox.setItems(days28);
		
	}

	@FXML
	private void handleYear() {
		daysFebruary();
	}

	public void setMainApp(MainApp main) {
		mainApp = main;	
	}

	private String monthSwitch(int month) {
		switch (month) {
		case 1:  return "January";
		case 2:  return "February";
		case 3:  return "March";
		case 4:  return "April";
		case 5:  return "May";
		case 6:  return "June";
		case 7:  return "July";
		case 8:  return "August";
		case 9:  return "September";
		case 10: return "October";
		case 11: return "November";
		case 12: return "December";
		}
		return null;
	}

}
