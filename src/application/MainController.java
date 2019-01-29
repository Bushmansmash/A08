package application;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainController extends Application implements Initializable {

	@FXML ImageView humanView, computerView;
	@FXML Text humanChoice, computerChoice, result;
	
	
	Image humanImg = new Image("application/human.png");
	Image computerImg = new Image("application/computer.png");
	
	
	@Override
	public void start(Stage primaryStage) {
		try {
			try {
				Parent root = FXMLLoader.load(getClass().getResource("MainView.fxml")); 
				Scene scene = new Scene(root,850,450); //
				primaryStage.setTitle("");
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		humanView.setImage(humanImg);
		computerView.setImage(computerImg);
		humanChoice.setText("");
		computerChoice.setText("");
		result.setText("Result");
	}

	public void newGame(ActionEvent e) {
		initialize(null, null);
		humanChoice.setText("");
		computerChoice.setText("");
		result.setText("Result");
		result.setFill(Color.BLACK);
	}
	
	public void rockBut(ActionEvent e) {
		humanView.setImage(Choice.ROCK.pic);
		humanChoice.setText(Choice.ROCK.name);
		Choice choice = computerRandom();
		computerView.setImage(choice.pic);
		computerChoice.setText(choice.getName());
		
		
		results(humanChoice.getText(),computerChoice.getText());
	}
	
	public void paperBut(ActionEvent e) {
		humanView.setImage(Choice.PAPER.pic);
		humanChoice.setText(Choice.PAPER.name);
		Choice choice = computerRandom();
		computerView.setImage(choice.pic);
		computerChoice.setText(choice.getName());
		
		
		results(humanChoice.getText(),computerChoice.getText());
	}
	
	public void scissorsBut(ActionEvent e) {
		humanView.setImage(Choice.SCISSORS.pic);
		humanChoice.setText(Choice.SCISSORS.name);
		Choice choice = computerRandom();
		computerView.setImage(choice.pic);
		computerChoice.setText(choice.getName());
		
		results(humanChoice.getText(),computerChoice.getText());
	}
	
	public Choice computerRandom() {
		Random rand = new Random();
		int number = rand.nextInt(3);
		
		if (number == 0) {
			return Choice.ROCK;
		} else if (number == 1) {
			return Choice.PAPER;
		} else if (number == 2) {
			return Choice.SCISSORS;
		} else {
			return null;
		}
	}
	
	public void results(String human, String computer) {
		switch (human) {
		case "Rock":
			if (computer == "Rock") {
				result.setText("It's a tie.");
				result.setFill(Color.BLACK);
			} else if (computer == "Paper") {
				result.setText("Computer wins.");
				result.setFill(Color.RED);
			} else {
				result.setText("You won!!");
				result.setFill(Color.GREEN);
			}
			break;
		case "Paper":
			if (computer == "Rock") {
				result.setText("You won!!");
				result.setFill(Color.GREEN);
			} else if (computer == "Paper") {
				result.setText("It's a tie.");
				result.setFill(Color.BLACK);
			} else {
				result.setText("Computer wins.");
				result.setFill(Color.RED);
			}
			break;
		case "Scissors":
			if (computer == "Rock") {
				result.setText("Computer wins.");
				result.setFill(Color.RED);
			} else if (computer == "Paper") {
				result.setText("You won!!");
				result.setFill(Color.GREEN);
			} else {
				result.setText("It's a tie.");
				result.setFill(Color.BLACK);
			}
			break;
		}
	}
	
}
