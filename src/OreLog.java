import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemStateListener;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;

public class OreLog extends TextBox implements CommandListener {

	public static final Font S_FONT = Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_SMALL);
	
	public static final int S_FONT_HEIGHT = S_FONT.getHeight() + 2;

	private static final Command CANCEL_COMMAND = new Command("ñﬂÇÈ", Command.CANCEL, 1);

	public OreLog() {
		
		super("Å´ëIëå„∫Àﬂ∞Ç≈Ç´Ç‹Ç∑","",3000,TextField.ANY);
		
		setCommandListener(this);
		
		addCommand(CANCEL_COMMAND);
		setCommandListener(this);
	}
	
	public void update() {
		
		StringBuffer tmpBuf = new StringBuffer(OreSim.stm.getLog());
		tmpBuf.append(OreSim.CHARCTERS.getName());
		tmpBuf.append(" / ");
		tmpBuf.append(OreSim.CHARCTERS.getStyleName());

		tmpBuf.append(" Bonus : ");
		tmpBuf.append(OreSim.stm.getTotalBonusPoint());
		tmpBuf.append(" / ");
		tmpBuf.append(OreSim.stm.getTotalLevelUp());
		tmpBuf.append(" Point : ");
		tmpBuf.append(OreSim.stm.getStatusPoint());

		tmpBuf.append("\nLV:");
		tmpBuf.append(OreSim.stm.getLevel());
		tmpBuf.append(" STAB ");
		tmpBuf.append(OreSim.stm.getStatus()[0]);
		tmpBuf.append(" HACK ");
		tmpBuf.append(OreSim.stm.getStatus()[1]);
		tmpBuf.append(" INT ");
		tmpBuf.append(OreSim.stm.getStatus()[2]);
		tmpBuf.append(" DEF ");
		tmpBuf.append(OreSim.stm.getStatus()[3]);
		tmpBuf.append(" MR ");
		tmpBuf.append(OreSim.stm.getStatus()[4]);
		tmpBuf.append(" DEX ");
		tmpBuf.append(OreSim.stm.getStatus()[5]);
		tmpBuf.append(" AGI ");
		tmpBuf.append(OreSim.stm.getStatus()[6]);
		
		this.setString(tmpBuf.toString());
		
	}


	public void commandAction(Command command, Displayable displayable) {

		if (command.getCommandType() == Command.CANCEL) {
			OreSim.statusPage.changeScene(0);
		    Display.getDisplay(OreSim.midlet).setCurrent(OreSim.statusPage);
		}
	}
}