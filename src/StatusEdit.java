import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextField;

public class StatusEdit extends Form implements ItemStateListener, CommandListener {

	private static TextField levelTxt = new TextField("Lv", "", 3, TextField.NUMERIC );
	
	private static TextField[] statusTxt;
	
	private static TextField pointTxt = new TextField("POINT", "", 4, TextField.NUMERIC );
	
	private static TextField[] xienTxt;
	
	private static int[] values;
	
	private static final Command APPLY_COMMAND = new Command("適用", Command.OK, 9);

	private static final Command CANCEL_COMMAND = new Command("ｷｬﾝｾﾙ", Command.CANCEL, 1);

	public StatusEdit() {
		
		super("ステータス編集");
		
		append(levelTxt);
		
		statusTxt = new TextField[Status.STATUS_NAME.length];
		for(int i = 0; i < Status.STATUS_NAME.length; i++) {
			statusTxt[i] = new TextField(Status.STATUS_NAME[i], String.valueOf(OreSim.stm.getStatus()[i]), 4, TextField.NUMERIC);
		    append(statusTxt[i]);
		}
		
		append(pointTxt);
		
		xienTxt = new TextField[Status.XIEN_NAME.length];
		for(int i = 0; i < Status.XIEN_NAME.length; i++) {
			xienTxt[i] = new TextField(Status.XIEN_NAME[i], String.valueOf(OreSim.stm.getXien()[i]), 2, TextField.NUMERIC);
		    append(xienTxt[i]);
		}
		
		setItemStateListener(this);
		
		values = new int[statusTxt.length + xienTxt.length + 2];
		
		addCommand(APPLY_COMMAND);
		addCommand(CANCEL_COMMAND);
		setCommandListener(this);
	}
	
	public void update() {
		levelTxt.setString(String.valueOf(OreSim.stm.getLevel()));
		
		for(int i = 0; i < statusTxt.length; i++) {
			statusTxt[i].setString(String.valueOf(OreSim.stm.getStatus()[i]));
		}
		
		pointTxt.setString(String.valueOf(OreSim.stm.getStatusPoint()));

		for(int i = 0; i < xienTxt.length; i++) {
			xienTxt[i].setString(String.valueOf(OreSim.stm.getXien()[i]));
		}
		while((statusTxt.length + 2) < size()) {
			delete(statusTxt.length + 2);
		}
		for(int i = 0; i < Status.XIEN_NAME.length; i++) {
			
			for(int l = 0; l < OreSim.CHARCTERS.getXienInfo().length; l++) {
				if(OreSim.CHARCTERS.getXienInfo()[l].equals(Status.XIEN_NAME[i])) {
					append(xienTxt[i]);
					break;
				}
			}
		}
	}

	public void itemStateChanged(Item item) {
		
		try {

			/* 最大値矯正 */
			if(Integer.parseInt(levelTxt.getString()) > Status.MAX_LEVEL) {
				levelTxt.setString(String.valueOf(Status.MAX_LEVEL));
			}

			for(int i = 0; i < statusTxt.length; i++) {
				if (Integer.parseInt(statusTxt[i].getString()) > Status.MAX_STATUS[i]) {
					statusTxt[i].setString(String.valueOf(Status.MAX_STATUS[i]));
				}
			}
			
			if(Integer.parseInt(pointTxt.getString()) > 9999) {
				pointTxt.setString("9999");
			}

			for(int i = 0; i < xienTxt.length; i++) {
				if (Integer.parseInt(xienTxt[i].getString()) > 99) {
					xienTxt[i].setString("99");
				}
			}
			
			/* 最小値矯正 */
			if(Integer.parseInt(levelTxt.getString()) < 1) {
				levelTxt.setString("1");
			}

			for(int i = 0; i < statusTxt.length; i++) {
				if (Integer.parseInt(statusTxt[i].getString()) < 1) {
					statusTxt[i].setString("1");
				}
			}
			
			if(Integer.parseInt(pointTxt.getString()) < 0) {
				pointTxt.setString("0");
			}

			for(int i = 0; i < xienTxt.length; i++) {
				if (Integer.parseInt(xienTxt[i].getString()) < 0) {
					xienTxt[i].setString("0");
				}
			}
		} catch (NumberFormatException nfe) {
		}
		
    }

	public void commandAction(Command command, Displayable displayable) {

		if (command.getCommandType() == Command.CANCEL) {
			OreSim.statusPage.changeScene(0);
		    Display.getDisplay(OreSim.midlet).setCurrent(OreSim.statusPage);
		}
		if (command.getCommandType() == Command.OK) {

			/* 空白修正 */
			if(levelTxt.getString().length() == 0) {
				levelTxt.setString(String.valueOf(OreSim.stm.getLevel()));
			}
			values[0] = Integer.parseInt(levelTxt.getString());

			for(int i = 0; i < statusTxt.length; i++) {
				if (statusTxt[i].getString().length() == 0) {
					statusTxt[i].setString(String.valueOf(OreSim.stm.getStatus()[i]));
				}
				values[1 + i] = Integer.parseInt(statusTxt[i].getString());
			}
			
			if(pointTxt.getString().length() == 0) {
				pointTxt.setString(String.valueOf(OreSim.stm.getStatusPoint()));
			}
			values[statusTxt.length + 1] = Integer.parseInt(pointTxt.getString());

			for(int i = 0; i < xienTxt.length; i++) {
				if (xienTxt[i].getString().length() == 0) {
					xienTxt[i].setString(String.valueOf(OreSim.stm.getXien()[i]));
				}
				values[statusTxt.length + 2 + i] = Integer.parseInt(xienTxt[i].getString());
			}
			OreSim.stm.changeStatus(values);
			OreSim.stm.logStatus(values);
			
			OreSim.statusPage.changeScene(0);
		    Display.getDisplay(OreSim.midlet).setCurrent(OreSim.statusPage);
		}
	}
}