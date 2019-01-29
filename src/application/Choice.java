package application;

import javafx.scene.image.Image;

public enum Choice {
	ROCK("Rock"),
	PAPER("Paper"),
	SCISSORS("Scissors");
	
	String name;
	Image pic;
	
	
	// I am using JavaFX, therefore I use Image instead of ImageIcon
	Choice(String name) {
		this.name = name;
		picture(name);
	}
	
	public void picture(String name) {
		if (name == "Rock") {
			this.pic = new Image("application/rock.png");
		} else if (name == "Paper") {
			this.pic = new Image("application/paper.png");
		} else {
			this.pic = new Image("application/scissors.png");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
