//import java.awt.Button;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class NationalParksMain extends JPanel {

	private static final long serialVersionUID = 7501243922894787112L;
	private static String[] urls = new String[99];
	private int index = -1;
	private JLabel label1 = new JLabel();
	private ImageIcon icon;

	public NationalParksMain() throws IOException {
		// fill the URL array.
		initializeImages();

		// TODO create a button listener to pause teh slideshow and resume it
//		Button b = new Button();

		// timer to switch images every X seconds
		Timer timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				if (label1 != null) {
					// this whole block is my attempt to free up memory usage.
					// I don't think this works the way I thought it would.
					// if there is a label (which there will be unless it's the
					// very beginning of the program)
					// remove it, set it to null, call garbage collector, any
					// other shots in the dark I could think of.
					remove(label1);
					label1 = null;
					index++;
					icon = null;
					// I read about this online but it doesn't seem to do
					// anything
					System.gc();
					// icon.dispose(); doesn't work. gotta read more on this.

					if (index == urls.length - 1) {
						// loops the images back to the beginning
						// if we reached the end of the url array
						index = 0;
					}

				}

				try {
					// pull the image from the URL into an image icon
					if (ImageIO.read(new URL(urls[index])) != null) {

						icon = new ImageIcon(new ImageIcon(ImageIO.read(new URL(urls[index]))).getImage()
								.getScaledInstance(1200, 700, Image.SCALE_SMOOTH));
						// add it to the jlabel
						label1 = new JLabel(icon, JLabel.CENTER);
						label1.setSize(1200, 700);

//						label1.addMouseListener(new MouseAdapter() {
//							@Override
//							public void mouseClicked(MouseEvent mouseEvent) {
//								Timer timer = new Timer(10000, new ActionListener() {
//									public void actionPerformed(ActionEvent evt) {
//										System.out.println("Wait 10 seconds");
//									}
//								});
//								timer.start();
//							}
//						});

						// TODO add the name of the national park to the label
						// as well

						// TODO Add a timer to show when the image is going to
						// change?

						add(label1);
						repaint();
						revalidate();
					} else {
						System.out.println("Null pointer on this URL: " + urls[index].toString());
						index++;
					}
				} catch (IOException e) {
					// sometimes the webcams are down, so print hte stack trace
					// but then continue through
					// the rest of the images.
					e.printStackTrace();
					return;
				}

				// then do it all again in 5 seconds.
			}
		});

		timer.start();
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event dispatch thread.
	 * 
	 * @throws IOException
	 */
	private static void createFrame() throws IOException {
		// Create and set up the window.
		JFrame frame = new JFrame("National Parks Slideshow");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1200, 700);

		if (ImageIO.read(new URL("https://d30y9cdsu7xlg0.cloudfront.net/png/16025-200.png")) != null) {
			ImageIcon icon = new ImageIcon(
					ImageIO.read(new URL("https://d30y9cdsu7xlg0.cloudfront.net/png/16025-200.png")));
			frame.setIconImage(icon.getImage());
		}

		// add the jpanel
		frame.add(new NationalParksMain());
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// Schedule a job for the event dispatch thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					createFrame();
				} catch (IOException e) {
					// print stack
					e.printStackTrace();
				}
			}
		});

	}

	private static void initializeImages() {
		// System.out.println("glassy air");
		urls[0] = "https://www.nps.gov/webcams-glac/aplocam.jpg";
		urls[1] = "https://www.nps.gov/webcams-glac/middleforkcam.jpg";
		urls[2] = "https://www.nps.gov/webcams-glac/apvccam.jpg";
		urls[3] = "https://www.nps.gov/webcams-glac/mcdcam1.jpg";
		urls[5] = "https://www.nps.gov/webcams-glac/mcdcam.jpg";
		urls[4] = "https://www.nps.gov/webcams-glac/flathead.jpg";
		urls[5] = "https://www.nps.gov/webcams-glac/tmcam.jpg";
		urls[6] = "https://www.nps.gov/webcams-glac/mgcam.jpg";
		urls[7] = "https://www.nps.gov/webcams-glac/hqcam.jpg";
		// urls[8] = "https://www.nps.gov/webcams-glac/smcam.jpg"; out of
		// service

		// System.out.println("denali");
		urls[8] = "https://www.nps.gov/webcams-dena/alpine.jpg";
		urls[9] = "https://www.nps.gov/webcams-dena/depotimage.jpg";
		// urls[11] =
		// "http://www.nature.nps.gov/air/WebCams/parks/denacam/dena.jpg"; out
		// of service

		// System.out.println("arches");
		urls[10] = "https://www.nps.gov/webcams-arch/arch_traffic.jpg";

		// System.out.println("bryce");
		urls[11] = "https://www.nature.nps.gov/air/WebCams/parks/brdacam/brda.jpg";

		// System.out.println("canyonlands");
		urls[12] = "http://eldesierto.org/Isky.jpg";

		// System.out.println("crater lake");
		urls[13] = "https://www.nps.gov/webcams-crla/camera0.jpg";
		urls[14] = "https://www.nps.gov/webcams-crla/cameraHQ.jpg";
		urls[15] = "https://www.nps.gov/webcams-crla/camerasinnott.jpg";

		// System.out.println("glacier bay");
		urls[16] = "https://www.nps.gov/webcams-glba/BartlettLagoon.jpg";
		urls[17] = "https://www.nps.gov/webcams-glba/BartlettDock.jpg";
		urls[18] = "https://www.nps.gov/webcams-glba/TlingitTrail.jpg";
		urls[19] = "https://www.nps.gov/webcams-glba/LowerBay.jpg";

		// System.out.println("grand canyon");
		urls[20] = "https://www.nature.nps.gov/air/webcams/parks/grcacam/grca.jpg";

		// System.out.println("grand teton");
		urls[21] = "https://www.nature.nps.gov/air/webcams/parks/grtecam/grtelarge.jpg";
		urls[22] = "http://www.americanalpineclub.org.php56-21.dfw3-2.websitetestlink.com/images/gtcr_webcam/webcam.jpg";
		urls[23] = "http://webcams.alltrips.com/grandteton/grandteton.jpg";
		// urls[28] = "http://www.lostcreek.com/webcam.jpg";

		// System.out.println("great sand dunes");
		urls[24] = "https://www.nps.gov/webcams-grsa/img001.jpg";

		// System.out.println("great smoky mtns");
		urls[25] = "https://www.nature.nps.gov/air/webcams/parks/grsmcam/grsm.jpg";
		urls[26] = "https://www.nature.nps.gov/air/webcams/parks/grsmpkcam/grpk.jpg";

		// System.out.println("hawaii volcano np");
		urls[27] = "https://www.nature.nps.gov/air/WebCams/parks/havocam/HAVO.JPG";
		urls[28] = "https://hvo.wr.usgs.gov/cams/K2cam/images/M.jpg";
		urls[29] = "https://hvo.wr.usgs.gov/cams/KIcam/images/M.jpg";
		urls[30] = "https://hvo.wr.usgs.gov/cams/MLcam/images/PAN.jpg";
		urls[31] = "https://hvo.wr.usgs.gov/cams/POcam/images/PAN.jpg";

		// System.out.println("isle royale?");
		urls[32] = "https://www.nps.gov/webcams-isro/thimage.jpg";
		urls[33] = "https://www.nps.gov/webcams-isro/image.jpg";

		// System.out.println("joshua");
		urls[34] = "https://www.nature.nps.gov/air/webcams/parks/jotrcam/jotr.jpg";

		// System.out.println("katmai");
		// all live webcams

		// System.out.println("lassen volcanic");
		urls[35] = "https://www.nps.gov/webcams-lavo/kyvc_webcam1.jpg";
		urls[36] = "https://www.nps.gov/webcams-lavo/ml_webcam.jpg";

		// System.out.println("mammoth cave");
		urls[37] = "https://www.nature.nps.gov/air/webcams/parks/macacam/maca.jpg";

		// System.out.println("mesa verde");
		urls[38] = "https://www.nps.gov/webcams-meve/sprucetree000M.jpg";
		urls[39] = "http://eldesierto.org/Mverde.jpg";

		// System.out.println("mt ranier");
		urls[40] = "https://www.nps.gov/webcams-mora/carbon.jpg";
		urls[41] = "https://www.nps.gov/webcams-mora/gh.jpg";
		urls[42] = "https://www.nps.gov/webcams-mora/longmire.jpg";
		urls[43] = "https://www.nps.gov/webcams-mora/east.jpg";
		urls[44] = "https://www.nps.gov/webcams-mora/west.jpg";
		urls[45] = "https://www.nps.gov/webcams-mora/tatoosh.jpg";
		urls[46] = "https://www.nps.gov/webcams-mora/mountain.jpg";
		urls[47] = "https://nature.nps.gov/air/WebCams/parks/moracam/mora.jpg";

		// System.out.println("north cascades");
		urls[48] = "https://www.nature.nps.gov/air/webcams/parks/nocacam/noca.jpg";

		// System.out.println("olympic");
		urls[49] = "https://www.nps.gov/webcams-olym/current_ridgecam.jpg";
		urls[50] = "https://www.nps.gov/webcams-olym/northcam.jpg";
		urls[51] = "https://www.nature.nps.gov/air/WebCams/parks/olymcam/olym.JPG";

		// System.out.println("rocky mtn np");
		urls[52] = "https://www.nps.gov/webcams-romo/alpine_visitor_center.jpg";
		urls[53] = "https://www.nps.gov/webcams-romo/bme.jpg";
		urls[54] = "https://www.nps.gov/webcams-romo/fre.jpg";
		urls[55] = "https://www.nps.gov/webcams-romo/glacier_basin.jpg";
		urls[56] = "https://www.nps.gov/webcams-romo/kawuneeche_valley.jpg";
		urls[57] = "https://www.nps.gov/webcams-romo/longs_peak.jpg";

		// System.out.println("seqoiua");
		urls[58] = "https://www.nature.nps.gov/air/WebCams/parks/sekicam/seki.jpg";
		urls[59] = "https://www.nps.gov/webcams-seki/oak_canopy.jpg";

		// System.out.println("shenandoah");
		urls[60] = "http://wwc.instacam.com/instacamimg/LRAY1/LRAY1_l.jpg";
		urls[61] = "https://www.nps.gov/webcams-shen/bvc_1920x1080.jpg";
		urls[62] = "https://www.nps.gov/webcams-shen/pinnacles.jpg";

		// System.out.println("painted canyon");
		urls[63] = "https://www.nature.nps.gov/air/webcams/parks/throcam/thro.jpg";

		// System.out.println(" yeller");
		urls[64] = "https://www.nps.gov/webcams-yell/oldfaithvc.jpg";
		urls[65] = "https://www.nps.gov/webcams-yell/mtwashburn.jpg";
		urls[66] = "https://www.nps.gov/webcams-yell/washburn2.jpg";
		urls[67] = "https://www.nps.gov/webcams-yell/mammothcam2.jpg";
		urls[68] = "https://www.nps.gov/webcams-yell/mammoth1.jpg";
		urls[69] = "https://www.nps.gov/webcams-yell/mammoth3.jpg";
		urls[70] = "https://www.nps.gov/webcams-yell/mammoth4.jpg";
		urls[71] = "https://www.nps.gov/webcams-yell/westent1.jpg";
		urls[72] = "https://www.nps.gov/webcams-yell/westent2.jpg";

		// System.out.println("yosemite");
		urls[73] = "http://pixelcaster.com/yosemite/webcams/ahwahnee2.jpg";
		urls[74] = "http://pixelcaster.com/yosemite/webcams/turtleback.jpg";
		urls[75] = "https://maps.ca.water.usgs.gov/webcams/happyisles-latest.jpg";
		urls[76] = "http://pixelcaster.com/yosemite/webcams/sentinel.jpg";
		urls[77] = "https://www.nature.nps.gov/air/webcams/parks/yosecam/yose.jpg";
		urls[78] = "http://pixelcaster.com/yosemite/webcams/yosfalls.jpg";

		// System.out.println("zion");
		urls[79] = "https://www.nps.gov/webcams-zion/camera.jpg";

		// System.out.println("colordado national monument");
		urls[80] = "https://www.nps.gov/webcams-colm/camera0.jpg";

		// System.out.println("lapush beach");
		urls[81] = "http://webcam.forkswa.com/webcam1/netcam.jpg";

		// System.out.println("glenn canyon bullfrog");
		urls[82] = "https://www.nps.gov/webcams-glca/bf1.jpg";
		urls[83] = "https://www.nps.gov/webcams-glca/dr1.jpg";
		urls[84] = "https://www.nps.gov/webcams-glca/hc1.jpg";
		urls[85] = "https://www.nps.gov/webcams-glca/hi1.jpg";
		urls[86] = "https://www.nps.gov/webcams-glca/po1.jpg";
		urls[87] = "https://www.nps.gov/webcams-glca/ww2.jpg";
		urls[88] = "https://www.nps.gov/webcams-glca/ww3.jpg";

		// System.out.println("gulf islands");
		urls[89] = "https://www.nps.gov/webcams-guis/pkbeach/perdidokey000M.jpg";
		urls[90] = "https://www.nps.gov/webcams-guis/pkbeach/bayoucam000M.jpg";

		// System.out.println("john day");
		urls[91] = "https://www.nps.gov/webcams-joda/sheeprockcam.jpg";

		// System.out.println("mt st helends");
		urls[92] = "https://www.fs.fed.us/gpnf/volcanocams/msh/images01/volcanocamhd.jpg";
		urls[93] = "https://www.fs.fed.us/gpnf/volcanocams/msh/images02/volcanocamhd.jpg";

		// System.out.println("new river gorge");
		urls[94] = "https://www.nps.gov/webcams-neri/nericrvc1.jpg";

		// System.out.println("padre island");
		urls[95] = "https://www.nps.gov/webcams-pais/PAIS_WC.jpg";

		// System.out.println("point reyes");
		urls[96] = "https://www.nature.nps.gov/air/WebCams/parks/porecam/pore.jpg";

		// System.out.println("santa monica mountains");
		urls[97] = "http://hpwren.ucsd.edu/anim-a2/SAMO_CASTRO_CANON/SAMO_CASTRO_CANON.jpg";

		// System.out.println("whiskeytown visitor center");
		urls[98] = "https://www.nps.gov/webcams-whis/WHIS-VC_camera.jpg";
		
	}
}