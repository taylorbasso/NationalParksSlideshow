import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NationalParksSlideshow extends JFrame {
	public NationalParksSlideshow() {
		setTitle("National Park Slideshow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 740);
		add(new NationalParksMain());
		setVisible(true);
	}

	public static void main(String[] args) {
		new NationalParksSlideshow();
	}
}
