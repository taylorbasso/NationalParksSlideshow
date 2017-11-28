import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class NationalParksMain extends JPanel {

	private final String[] urls = { "https://www.nps.gov/webcams-glac/aplocam.jpg",
			"https://www.nps.gov/webcams-glac/middleforkcam.jpg", "https://www.nps.gov/webcams-glac/apvccam.jpg",
			"https://www.nps.gov/webcams-glac/mcdcam1.jpg", "https://www.nps.gov/webcams-glac/flathead.jpg",
			"https://www.nps.gov/webcams-glac/tmcam.jpg", "https://www.nps.gov/webcams-glac/mgcam.jpg",
			"https://www.nps.gov/webcams-glac/hqcam.jpg", "https://www.nps.gov/webcams-glac/smcam.jpg",
			"https://www.nps.gov/webcams-dena/alpine.jpg", "https://www.nps.gov/webcams-dena/depotimage.jpg",
			"http://www.nature.nps.gov/air/WebCams/parks/denacam/dena.jpg",
			"https://www.nps.gov/webcams-arch/arch_traffic.jpg",
			"https://www.nature.nps.gov/air/WebCams/parks/brdacam/brda.jpg", "http://eldesierto.org/Isky.jpg",
			"https://www.nps.gov/webcams-crla/camera0.jpg", "https://www.nps.gov/webcams-crla/cameraHQ.jpg",
			"https://www.nps.gov/webcams-crla/camerasinnott.jpg", "https://www.nps.gov/webcams-glba/BartlettLagoon.jpg",
			"https://www.nps.gov/webcams-glba/BartlettDock.jpg", "https://www.nps.gov/webcams-glba/TlingitTrail.jpg",
			"https://www.nps.gov/webcams-glba/LowerBay.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/grcacam/grca.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/grtecam/grtelarge.jpg",
			"http://www.americanalpineclub.org.php56-21.dfw3-2.websitetestlink.com/images/gtcr_webcam/webcam.jpg",
			"http://webcams.alltrips.com/grandteton/grandteton.jpg", "http://www.lostcreek.com/webcam.jpg",
			"https://www.nps.gov/webcams-grsa/img001.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/grsmcam/grsm.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/grsmpkcam/grpk.jpg",
			"https://www.nature.nps.gov/air/WebCams/parks/havocam/HAVO.JPG",
			"https://hvo.wr.usgs.gov/cams/K2cam/images/M.jpg", "https://hvo.wr.usgs.gov/cams/KIcam/images/M.jpg",
			"https://hvo.wr.usgs.gov/cams/MLcam/images/PAN.jpg", "https://hvo.wr.usgs.gov/cams/POcam/images/PAN.jpg",
			"https://www.nps.gov/webcams-isro/thimage.jpg", "https://www.nps.gov/webcams-isro/image.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/jotrcam/jotr.jpg",
			"https://www.nps.gov/webcams-lavo/kyvc_webcam1.jpg", "https://www.nps.gov/webcams-lavo/ml_webcam.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/macacam/maca.jpg",
			"https://www.nps.gov/webcams-meve/sprucetree000M.jpg", "http://eldesierto.org/Mverde.jpg",
			"https://www.nps.gov/webcams-mora/carbon.jpg", "https://www.nps.gov/webcams-mora/gh.jpg",
			"https://www.nps.gov/webcams-mora/longmire.jpg", "https://www.nps.gov/webcams-mora/east.jpg",
			"https://www.nps.gov/webcams-mora/west.jpg", "https://www.nps.gov/webcams-mora/tatoosh.jpg",
			"https://www.nps.gov/webcams-mora/mountain.jpg",
			"https://nature.nps.gov/air/WebCams/parks/moracam/mora.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/nocacam/noca.jpg",
			"https://www.nps.gov/webcams-olym/current_ridgecam.jpg", "https://www.nps.gov/webcams-olym/northcam.jpg",
			"https://www.nature.nps.gov/air/WebCams/parks/olymcam/olym.JPG",
			"https://www.nps.gov/webcams-romo/alpine_visitor_center.jpg", "https://www.nps.gov/webcams-romo/bme.jpg",
			"https://www.nps.gov/webcams-romo/fre.jpg", "https://www.nps.gov/webcams-romo/glacier_basin.jpg",
			"https://www.nps.gov/webcams-romo/kawuneeche_valley.jpg", "https://www.nps.gov/webcams-romo/longs_peak.jpg",
			"https://www.nature.nps.gov/air/WebCams/parks/sekicam/seki.jpg",
			"https://www.nps.gov/webcams-seki/oak_canopy.jpg", "http://wwc.instacam.com/instacamimg/LRAY1/LRAY1_l.jpg",
			"https://www.nps.gov/webcams-shen/bvc_1920x1080.jpg", "https://www.nps.gov/webcams-shen/pinnacles.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/throcam/thro.jpg",
			"https://www.nps.gov/webcams-yell/oldfaithvc.jpg", "https://www.nps.gov/webcams-yell/mtwashburn.jpg",
			"https://www.nps.gov/webcams-yell/washburn2.jpg", "https://www.nps.gov/webcams-yell/mammothcam2.jpg",
			"https://www.nps.gov/webcams-yell/mammoth1.jpg", "https://www.nps.gov/webcams-yell/mammoth3.jpg",
			"https://www.nps.gov/webcams-yell/mammoth4.jpg", "https://www.nps.gov/webcams-yell/westent1.jpg",
			"https://www.nps.gov/webcams-yell/westent2.jpg", "http://pixelcaster.com/yosemite/webcams/ahwahnee2.jpg",
			"http://pixelcaster.com/yosemite/webcams/turtleback.jpg",
			"https://maps.ca.water.usgs.gov/webcams/happyisles-latest.jpg",
			"http://pixelcaster.com/yosemite/webcams/sentinel.jpg",
			"https://www.nature.nps.gov/air/webcams/parks/yosecam/yose.jpg",
			"http://pixelcaster.com/yosemite/webcams/yosfalls.jpg", "https://www.nps.gov/webcams-zion/camera.jpg",
			"https://www.nps.gov/webcams-colm/camera0.jpg", "http://webcam.forkswa.com/webcam1/netcam.jpg",
			"https://www.nps.gov/webcams-glca/bf1.jpg", "https://www.nps.gov/webcams-glca/dr1.jpg",
			"https://www.nps.gov/webcams-glca/hc1.jpg", "https://www.nps.gov/webcams-glca/hi1.jpg",
			"https://www.nps.gov/webcams-glca/po1.jpg", "https://www.nps.gov/webcams-glca/ww2.jpg",
			"https://www.nps.gov/webcams-glca/ww3.jpg", "https://www.nps.gov/webcams-guis/pkbeach/perdidokey000M.jpg",
			"https://www.nps.gov/webcams-guis/pkbeach/bayoucam000M.jpg",
			"https://www.nps.gov/webcams-joda/sheeprockcam.jpg",
			"https://www.fs.fed.us/gpnf/volcanocams/msh/images01/volcanocamhd.jpg",
			"https://www.fs.fed.us/gpnf/volcanocams/msh/images02/volcanocamhd.jpg",
			"https://www.nps.gov/webcams-neri/nericrvc1.jpg", "https://www.nps.gov/webcams-pais/PAIS_WC.jpg",
			"https://www.nature.nps.gov/air/WebCams/parks/porecam/pore.jpg",
			"http://hpwren.ucsd.edu/anim-a2/SAMO_CASTRO_CANON/SAMO_CASTRO_CANON.jpg",
			"https://www.nps.gov/webcams-whis/WHIS-VC_camera.jpg" };
	private int index = -1;
	private JLabel label1 = new JLabel();
	private ImageIcon icon;

	public NationalParksMain() {

		// timer to switch images every X seconds
		Timer timer = new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				if (label1 != null) {
					remove(label1);
					label1 = null;
					index++;
					icon = null;
					if (index == urls.length - 1) {
						index = 0;
					}
				}

				try {
					// pull the image from the URL into an image icon
					BufferedImage image = ImageIO.read(new URL(urls[index]));
					if (image != null) {
						icon = new ImageIcon(image.getScaledInstance(1200, 700, Image.SCALE_SMOOTH));
						// add it to the jlabel
						label1 = new JLabel(icon, JLabel.CENTER);
						label1.setSize(1200, 700);

						add(label1, 0, 0);
						repaint();
						revalidate();
					} else {
						System.out.println("Null pointer on this URL: " + urls[index].toString());
						index++;
					}
				} catch (Exception e) {
					e.printStackTrace();
					index++;
					return;
				}
			}
		});

		timer.start();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.fillRect(0, 700, 1200, 20);
		g.setColor(Color.BLACK);
		if (index != -1) {
			g.drawString(urls[index], 0, 715);
		} else {
			g.drawString(urls[index + 1], 0, 715);
		}
	}
}