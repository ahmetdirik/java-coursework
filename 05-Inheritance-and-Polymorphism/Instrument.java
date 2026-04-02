
public class Instrument {
	
	void playSound() {
		System.out.println("Some generic instrument sound");
	}

	public static void main(String[] args) {
		Guitar guitar = new Guitar();
		Drum drum = new Drum();
		
		Instrument[] instrument = {guitar,drum};
		
		for(int i=0;i<instrument.length;i++) {
			instrument[i].playSound();
		}
	}

}

class Guitar extends Instrument{
	@Override
	void playSound() {
		System.out.println("Guitar: Strum");
	}
}


class Drum extends Instrument{
	@Override
	void playSound() {
		System.out.println("Drum: Boom ");
	}
}