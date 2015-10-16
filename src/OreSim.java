

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

public class OreSim extends MIDlet {

	public static final String VERSION = "0.15";

    /** ステータスシミュレータ */
    public static Status stm = new Status();

    public static boolean allocToChangePoint = false;

    public static OreSimMainPage statusPage = new OreSimMainPage();
    public static OreLog logForm = new OreLog();

	public static final String RS_LABEL = "oresim_label";
	public static int[] RS_LABEL_ID = new int[]{
		-1, -1, -1
	};

	public static TWCharacters CHARCTERS = new TWCharacters();

	public static final String RS_DATA = "oresim_data";
	public static int[] RS_DATA_ID = new int[]{
		-1, -1, -1
	};

	public static OreSim midlet = null;

	public OreSim() {
        midlet = this;

		changeCharacter(0);
		statusPage.changeScene(3);
		statusPage.changeScene(10);

		Display.getDisplay(this).setCurrent(statusPage);
	}

	private void changeCharacter(int index) {

		if ( CHARCTERS.charIndex == index ) {
            return;
        }

		CHARCTERS.charIndex = index;
		CHARCTERS.init();
        stm._character = CHARCTERS;
        stm.init();
	}

	protected void startApp() throws MIDletStateChangeException {
	}


	protected void pauseApp() {
	}


	protected void destroyApp(boolean flag) throws MIDletStateChangeException {
	}

	public void endApp() {
		try {
			destroyApp(false);
			notifyDestroyed();

		} catch (MIDletStateChangeException midsce) {
		}
	}
}
