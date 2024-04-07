import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class KeyController extends KeyAdapter {
	private Presentation presentation;

	// Constructor
	public KeyController(Presentation p) {
		presentation = p;
	}

	// Called when a key is pressed
	public void keyPressed(KeyEvent keyEvent) {
		switch (keyEvent.getKeyCode()) {
			case KeyEvent.VK_PAGE_DOWN:
			case KeyEvent.VK_DOWN:
			case KeyEvent.VK_ENTER:
			case '+':
				presentation.nextSlide();
				break;
			case KeyEvent.VK_PAGE_UP:
			case KeyEvent.VK_UP:
			case '-':
				presentation.prevSlide();
				break;
			case 'q':
			case 'Q':
				System.exit(0);
				break; // Probably never reached!!
			default:
				break;
		}
	}
}