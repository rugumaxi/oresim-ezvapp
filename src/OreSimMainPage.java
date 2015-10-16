import java.io.IOException;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.rms.InvalidRecordIDException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;
import javax.microedition.rms.RecordStoreFullException;
import javax.microedition.rms.RecordStoreNotFoundException;
import javax.microedition.rms.RecordStoreNotOpenException;

public class OreSimMainPage extends Canvas implements CommandListener {

	/** 基本背景色 */
	public static final int BG_COLOR = 0x111111;

	public static final int PANEL_BG_COLOR = 0x302070;
	public static final int PANEL_SHADE_COLOR = 0x201A44;
	public static final int PANEL_LIGHT_COLOR = 0x363070;

	public static final int MIDDLE_BOX_COLOR = 0x686098;

	public static final int FG_COLOR = 0xddDDdd;

	public static final int SUB_FG_COLOR = 0x115011;

	public static final Font FONT = Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_SMALL);
	public static final Font S_FONT = Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_SMALL);
	public static final Font CR_FONT = Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_PLAIN, Font.SIZE_SMALL);
	public static final Font L_FONT = Font.getFont(Font.FACE_MONOSPACE, Font.STYLE_PLAIN, Font.SIZE_MEDIUM);

	public static int FONT_HEIGHT = FONT.getHeight();
	public static int S_FONT_HEIGHT = S_FONT.getHeight();
	public static int CR_FONT_HEIGHT = CR_FONT.getHeight();
	public static int L_FONT_HEIGHT = L_FONT.getHeight();

	public static final int FONT_COLOR = 0xddDDdd;

	public static final int SUB_FONT_COLOR = 0xdd4422;

	public static final int SELECT_FONT_COLOR = 0x22ccdd;

	public static int scene = 0;

	public static final int BOX_COLOR = 0x686098;
    public static final int PADDING_LEFT = FONT_HEIGHT;
    public static int BOX_TOP_Y = 0;
    public static int BOX_HEIGHT = 0;
	public static int HEAD_TOP_Y = 0;
	public static int MIDDLE_LEFT_X = 0;
    public static int MIDDLE_TOP_Y = 0;

	public static int selectedMenu = 0;
	public static final String[] MENU_LABEL = new String[]{
		"ステータス初期化",
		"ステ振りログ表示",
		//"ステータス編集",
		"セーブ/ロード",
		"ヘルプ表示",
		"俺シミュ終了"
	};

    public static int MAX_ROWS = 0;
    public static int MAX_LEFT_WIDTH = 0;
	public static int startLine = 0;
	public static boolean maxStartLine = true;
	public static String[] dispLogValue = null;
	public static String[] dispLogLabel = null;
	public static String log = "";

	public static int setting_selected = 0;
	public static int characterIndex = 0;
    public static int styleIndex = 0;
    public static int xienIndex = 0;
    public static int bonusIndex = 3;
    public static boolean allocToChange = false;
	public static final String ON = "ON";
	public static final String OFF = "OFF";
	public static final int[] bonusChoices = new int[] {
		0, 40, 45, 50, 55, 60, 65, 70, 80, 90, 100
	};
	public static final int[] original = new int[] {
		characterIndex, styleIndex, xienIndex, bonusIndex, 0
	};
	public static final String[] SETTING_LABEL = new String[]{
		"キャラクター: ",
		"スタイル: ",
		"Xien: ",
		"Bonus: ",
		"一気振り: "
	};
	public static final String[] value = new  String[] {
		"","","","",OFF
	};

	public static int targetData = 0;
	public static int targetAction = 0;
	public static String[] DATA_LABEL = {
		"NO DATA\n", "NO DATA\n", "NO DATA\n"
	};
	public static int[] DATA_ID = new int[DATA_LABEL.length * 2];
	public static final String[] ACTION_LABEL = {
	    "ロード","セーブ", "削除"
	};

    public static final Command[] commands = new Command[8];

	public OreSimMainPage() {

		if (FONT_HEIGHT < FONT.stringWidth("■") + 2) {
			FONT_HEIGHT += 2;
			S_FONT_HEIGHT += 2;
			CR_FONT_HEIGHT += 2;
			L_FONT_HEIGHT += 2;
		}

		BOX_HEIGHT = FONT_HEIGHT + FONT_HEIGHT * 12;
		BOX_TOP_Y = (getHeight() - BOX_HEIGHT) / 2;

		if (BOX_TOP_Y < 0) {
			BOX_TOP_Y = 0;
		}

		HEAD_TOP_Y = BOX_TOP_Y + FONT_HEIGHT / 2;

		MIDDLE_LEFT_X = getWidth() - FONT.stringWidth("WEIGHT  99999      ");

		MIDDLE_TOP_Y = HEAD_TOP_Y + FONT_HEIGHT + FONT_HEIGHT * 2 + (FONT_HEIGHT / 2);

		commands[0] = new Command("ﾒﾆｭｰ", Command.BACK, 1);
		commands[1] = new Command("設定", Command.SCREEN, 9);
		commands[2] = new Command("戻る", Command.BACK, 1);
		commands[3] = new Command("戻る", Command.SCREEN, 9);
		commands[4] = new Command("適用", Command.BACK, 1);
		commands[5] = new Command("適用", Command.SCREEN, 9);
		commands[6] = new Command("終了", Command.BACK, 1);
		commands[7] = new Command("ｺﾋﾟｰ", Command.SCREEN, 9);

		setCommandListener(this);
	}

	public void changeScene(int scene_index) {

		for(int i = 0; i < commands.length; i++) {
			removeCommand(commands[i]);
		}

		scene = scene_index;
		switch (scene) {
		case 0:
			addCommand(commands[0]);
			addCommand(commands[1]);
			break;

		case 1:
			addCommand(commands[2]);
			break;

		case 2:
			addCommand(commands[2]);
			addCommand(commands[7]);

			MAX_ROWS = (getHeight() / FONT_HEIGHT) - 7;
			MAX_LEFT_WIDTH = getWidth() - FONT.stringWidth("LV 255 - 255 : ");

			dispLogValue = new String[MAX_ROWS];
			dispLogLabel = new String[MAX_ROWS];

			if (OreSim.stm.getLevel() > 1) {

				log = OreSim.stm.getLog();
		   		 startLine = 0;
		   		 for (int i = 0; i < MAX_ROWS; i++) {
		   			dispLogValue[i] = "";
		   			dispLogLabel[i] = "";
		   		 }

			} else {
				return;
			}
            break;

		case 3:
			addCommand(commands[4]);
			addCommand(commands[3]);

	     	characterIndex = OreSim.CHARCTERS.charIndex;
			styleIndex = OreSim.CHARCTERS.getStyleIndex();

			value[0] = OreSim.CHARCTERS.getName();
			value[1] = OreSim.CHARCTERS.getStyleInfo()[styleIndex];

			if(value[2].length() == 0) {

				xienIndex = OreSim.stm.getXienIndex();
				for(int i = 0; i < OreSim.CHARCTERS.getXienInfo().length; i++) {

					if (OreSim.CHARCTERS
					     .getXienInfo()[i].equals(Status.XIEN_NAME[xienIndex])) {
						xienIndex = i;
						break;
					}
				}
				value[2] = OreSim.CHARCTERS.getXienInfo()[xienIndex];
			}
			if(value[3].length() == 0) {

				for(int i = 0; i < bonusChoices.length; i++) {
					if(OreSim.stm.getBonusExpected().equals(String.valueOf(bonusChoices[i]) + "%")) {
						bonusIndex = i;
					}
				}
				value[3] = String.valueOf(bonusChoices[bonusIndex]) + "%";
			}


			if (OreSim.allocToChangePoint) {
				value[4] = ON;
				original[4] = 1;

			} else {
				value[4] = OFF;
				original[4] = 0;
			}

			original[0] = characterIndex;
			original[1] = styleIndex;
			original[2] = xienIndex;
			original[3] = bonusIndex;
            break;

		case 4:
			addCommand(commands[2]);

			RecordStore rs = null;
			try {
				rs = RecordStore.openRecordStore("oresim_label", true);
				RecordEnumeration renum = rs.enumerateRecords(null, null, true);
				if (renum.numRecords() == 0) {

					for(int i = 0; i < DATA_LABEL.length; i++) {

						byte[] data = "NO DATA\n".getBytes();
						DATA_ID[i] = rs.addRecord(data, 0, data.length);
					}
					rs.closeRecordStore();

					rs = RecordStore.openRecordStore("oresim_data", true);
					for(int i = 0; i < DATA_LABEL.length; i++) {

						byte[] data = "00".getBytes();
						DATA_ID[i + DATA_LABEL.length] = rs.addRecord(data, 0, data.length);
					}
					rs.closeRecordStore();

				} else {
					for(int i = 0; i < DATA_LABEL.length; i++) {
						DATA_ID[i] = renum.nextRecordId();
						DATA_LABEL[i] = new String(rs.getRecord(DATA_ID[i]));
					}
					renum.destroy();
					rs.closeRecordStore();

					rs = RecordStore.openRecordStore("oresim_data", true);
					renum = rs.enumerateRecords(null, null, true);
					for(int i = 0; i < DATA_LABEL.length; i++) {
						DATA_ID[i + DATA_LABEL.length] = renum.nextRecordId();
					}
					renum.destroy();
					rs.closeRecordStore();
				}
			} catch (RecordStoreFullException rsfe) {
			} catch (RecordStoreNotFoundException rsnfe) {
			} catch (RecordStoreException rse) {
			} finally {

				try {
					if(rs != null) {
						rs.closeRecordStore();
					}

				} catch (RecordStoreNotOpenException rsnoe) {
				} catch (RecordStoreException rse) {
				}
			}
            break;

		case 5:
			addCommand(commands[2]);
			break;

        case 10:
			addCommand(commands[6]);
			break;
		}
	}

	public void paint(Graphics g) {

		switch(scene) {
		case 0:
			paintAllocationPage(g);
			break;

		case 1:
			paintMenu(g);
			break;

		case 2:
			paintLogPage(g);
			break;

		case 3:
			paintSetting(g);
			break;

		case 4:
			paintDataList(g);
			break;

		case 5:
			paintHelp(g);
			break;

		case 10:
			paintTitlePage(g);
			break;
        }
	}

	private void paintTitlePage(Graphics g) {

		Image titleImage = null;

		try {
			titleImage = Image.createImage("/title.png");

		} catch (IOException ioe) {
		}

		int COPYRIGHT_LEFT_X = (getWidth() - CR_FONT.stringWidth("TalesWeaver is TM of Softmax Co.,Ltd.")) / 2;
        if(COPYRIGHT_LEFT_X < 0) {
        	COPYRIGHT_LEFT_X = 0;
        }

		g.setColor(0x000000);
	    g.fillRect(0, 0, getWidth(), getHeight());

	    if ( titleImage != null) {

	    	g.setColor(SUB_FONT_COLOR);
	    	g.setFont(S_FONT);
		    g.drawString("燃える！ 携帯版", (getWidth() - titleImage.getWidth()) / 2 - FONT.stringWidth("燃"), (getHeight() - S_FONT_HEIGHT) / 2 - titleImage.getHeight() - S_FONT_HEIGHT - S_FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
		    g.drawImage(titleImage, (getWidth() - titleImage.getWidth() - S_FONT.stringWidth("Ver. " + OreSim.VERSION)) / 2, (getHeight() - S_FONT_HEIGHT) / 2 - titleImage.getHeight() - S_FONT_HEIGHT, Graphics.TOP | Graphics.LEFT);

		    g.setColor(FONT_COLOR);
		    g.drawString("Ver. " + OreSim.VERSION, (getWidth() + titleImage.getWidth() - S_FONT.stringWidth("Ver. " + OreSim.VERSION)) / 2, (getHeight() - S_FONT_HEIGHT) / 2 - titleImage.getHeight() +  S_FONT_HEIGHT, Graphics.BOTTOM | Graphics.LEFT);

		    g.setColor(SELECT_FONT_COLOR);
		    g.drawString("PUSH SELECT KEY", (getWidth() - FONT.stringWidth("PUSH SELECT KEY")) /2, (getHeight() - S_FONT_HEIGHT) / 2 + S_FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);

		    g.setFont(CR_FONT);
		    g.setColor(FONT_COLOR);

		    g.drawString("TalesWeaver is TM of Softmax Co.,Ltd.",COPYRIGHT_LEFT_X, (getHeight() - S_FONT_HEIGHT) / 2 + CR_FONT_HEIGHT * 2, Graphics.BOTTOM | Graphics.LEFT);
		    g.drawString("(C) Softmax Co.,Ltd.", COPYRIGHT_LEFT_X, (getHeight() - S_FONT_HEIGHT) / 2 + CR_FONT_HEIGHT * 3, Graphics.BOTTOM | Graphics.LEFT);
		    g.drawString("(C) Nexon Co. & Nexon Japan Co.,Ltd.", COPYRIGHT_LEFT_X, (getHeight() - S_FONT_HEIGHT) / 2 + CR_FONT_HEIGHT * 4, Graphics.BOTTOM | Graphics.LEFT);
		    g.drawString("製作 ルグ鯖某マキシ",COPYRIGHT_LEFT_X, (getHeight() - S_FONT_HEIGHT) / 2 + CR_FONT_HEIGHT * 5 + CR_FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
	    }
	}

	private void paintAllocationPage(Graphics g) {

		g.setColor(BG_COLOR);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(PANEL_LIGHT_COLOR);
		g.fillRoundRect(0, BOX_TOP_Y, getWidth(), BOX_HEIGHT, 8, 8);

		g.setColor(PANEL_SHADE_COLOR);
		g.fillRoundRect(2, BOX_TOP_Y + 2, getWidth() - 2, BOX_HEIGHT - 2, 8, 8);

		g.setColor(PANEL_BG_COLOR);
		g.fillRoundRect(2, BOX_TOP_Y + 2, getWidth() - 4, BOX_HEIGHT - 4, 8, 8);

		g.setColor(PANEL_SHADE_COLOR);
		g.fillRoundRect(4, MIDDLE_TOP_Y, getWidth() - 10, FONT_HEIGHT * 8, 8, 8);


		StringBuffer buf = new  StringBuffer();
		StringBuffer subBuf = new  StringBuffer();


		g.setFont(FONT);
		g.setColor(FG_COLOR);

		buf.setLength(0);
		buf.append(OreSim.CHARCTERS.getName());
		buf.append(" / ");
		buf.append(OreSim.CHARCTERS.getStyleName());

		g.drawString(buf.toString(), PADDING_LEFT, HEAD_TOP_Y + FONT_HEIGHT, Graphics.BOTTOM | Graphics.LEFT);

		g.setFont(FONT);

		buf.setLength(0);
		buf.append("Lv ");
		buf.append(OreSim.stm.getLevel());

		g.drawString(buf.toString(), PADDING_LEFT, HEAD_TOP_Y + FONT_HEIGHT + FONT_HEIGHT, Graphics.BOTTOM | Graphics.LEFT);

		buf.setLength(0);
		buf.append(value[2]);
		g.drawString(buf.toString(), PADDING_LEFT, HEAD_TOP_Y + FONT_HEIGHT + FONT_HEIGHT * 2, Graphics.BOTTOM | Graphics.LEFT);

		buf.setLength(0);
		buf.append(value[3]);

		g.drawString(buf.toString(), MIDDLE_LEFT_X, HEAD_TOP_Y + FONT_HEIGHT + FONT_HEIGHT * 2, Graphics.BOTTOM | Graphics.LEFT);


		/* Middle */

		for (int i = 0; i < 7; i++) {

			buf.setLength(0);
			buf.append(Status.STATUS_NAME[i]);
			for ( int l = 0; l < 4 - Status.STATUS_NAME[i].length(); l++) {
				buf.append(" ");
			}
			buf.append(" ");

			int labelWidth = FONT.stringWidth(buf.toString());
			int valueWidth = FONT.stringWidth("9999999");

			g.setColor(BOX_COLOR);
			g.fillRect(PADDING_LEFT + labelWidth, MIDDLE_TOP_Y + FONT_HEIGHT * (i % 7) + FONT_HEIGHT / 2, valueWidth + 8, FONT_HEIGHT - 1);
			g.setColor(BG_COLOR);
			g.drawRect(PADDING_LEFT + labelWidth, MIDDLE_TOP_Y + FONT_HEIGHT * (i % 7) + FONT_HEIGHT / 2, valueWidth + 8, FONT_HEIGHT - 1);

			buf.append(" ");
			if (OreSim.stm.getStatus()[i] < 100) {
				buf.append(" ");
			}
			if (OreSim.stm.getStatus()[i] < 10) {
				buf.append(" ");
			}
			buf.append(OreSim.stm.getStatus()[i]);
			buf.append(" ");

			subBuf.setLength(0);
			int changeNeeds = (int)(25 - OreSim.stm.getLevel() / 5
                    + (OreSim.stm.getNeedPoints()[i] - OreSim.CHARCTERS.getDefaultNeedPoints()[i]) * 25);

			if (changeNeeds < 100) {
				subBuf.append(" ");
			}
			if (changeNeeds < 10) {
				subBuf.append(" ");
			}
			subBuf.append(changeNeeds);

			g.setColor(SUB_FG_COLOR);
			g.drawString(subBuf.toString(), PADDING_LEFT + FONT.stringWidth(buf.toString()), MIDDLE_TOP_Y + FONT_HEIGHT * ((i % 7) + 1) + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);

			buf.append("    ");

			if (OreSim.allocToChangePoint
					&& OreSim.stm.getStatus()[i] < Status.MAX_STATUS[i]
					&& (OreSim.stm.getLevel() < Status.MAX_LEVEL || OreSim.stm.getNeedPoints()[i] <= OreSim.stm.getStatusPoint())){

				buf.append("≫");

		    } else if (OreSim.stm.isEnableStatusUp(i)) {
				buf.append("▲");

			} else {
				buf.append("　");
			}

			buf.append(OreSim.stm.getNeedPoints()[i]);

			g.setColor(FG_COLOR);
			g.drawString(buf.toString(), PADDING_LEFT , MIDDLE_TOP_Y + FONT_HEIGHT * ((i % 7) + 1)  + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
		}

		for (int i = 7; i < Status.STATUS_NAME.length; i++) {

			buf.setLength(0);
			buf.append(Status.STATUS_NAME[i]);
			for ( int l = 0; l < 6 - Status.STATUS_NAME[i].length(); l++) {
				buf.append(" ");
			}
			buf.append(" ");

			int labelWidth = FONT.stringWidth(buf.toString());
			int valueWidth = FONT.stringWidth("99999");

			g.setColor(BOX_COLOR);
			g.fillRect(labelWidth + MIDDLE_LEFT_X, MIDDLE_TOP_Y + FONT_HEIGHT * (i % 7) + FONT_HEIGHT / 2 + 0, valueWidth + 12, FONT_HEIGHT - 1);
			g.setColor(BG_COLOR);
			g.drawRect(labelWidth + MIDDLE_LEFT_X, MIDDLE_TOP_Y + FONT_HEIGHT * (i % 7) + FONT_HEIGHT / 2 + 0, valueWidth + 12, FONT_HEIGHT - 1);

			buf.append(" ");
			if (OreSim.stm.getStatus()[i] < 10000) {
				buf.append(" ");
			}
			if (OreSim.stm.getStatus()[i] < 1000) {
				buf.append(" ");
			}
			if (OreSim.stm.getStatus()[i] < 100) {
				buf.append(" ");
			}
			if (OreSim.stm.getStatus()[i] < 10) {
				buf.append(" ");
			}
			buf.append(OreSim.stm.getStatus()[i]);

			g.setColor(FG_COLOR);
			g.drawString(buf.toString(), MIDDLE_LEFT_X, MIDDLE_TOP_Y + FONT_HEIGHT * ((i % 7) + 1)  + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
		}

		buf.setLength(0);
		buf.append("POINT ");
		buf.append(OreSim.stm.getStatusPoint());

		g.drawString(buf.toString(), MIDDLE_LEFT_X, MIDDLE_TOP_Y + FONT_HEIGHT * 6 + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);

		buf.setLength(0);
		buf.append("Bns. ");
        buf.append(OreSim.stm.getTotalBonusPoint());
        buf.append("/");
        buf.append(OreSim.stm.getTotalLevelUp());
		buf.append(" ");
		if (OreSim.stm.getTotalLevelUp() > 0) {
            buf.append((int)((OreSim.stm.getTotalBonusPoint() * 100) / OreSim.stm.getTotalLevelUp()));
		} else {
			buf.append(0);
		}
        buf.append("%");


        g.drawString(buf.toString(), MIDDLE_LEFT_X, MIDDLE_TOP_Y + FONT_HEIGHT * 7 + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
	}

	public void paintHelp(Graphics g) {

		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(FG_COLOR);

		int paddingLeft = (getWidth() - S_FONT.stringWidth("[1]    : STAB up  [7]    : DEX up")) / 2;
        int paddingTop = (getHeight() - FONT_HEIGHT - S_FONT_HEIGHT * 10) / 2;

		g.setFont(FONT);
		g.drawString("< キー操作 >", paddingLeft, FONT_HEIGHT + paddingTop, Graphics.BOTTOM | Graphics.LEFT);

		g.setFont(S_FONT);
		g.drawString("[決定] : Level up", paddingLeft, paddingTop + S_FONT_HEIGHT * 3, Graphics.BOTTOM | Graphics.LEFT);
		g.drawString("[1]    : STAB up  [7]    : DEX up", paddingLeft, S_FONT_HEIGHT * 4 + paddingTop, Graphics.BOTTOM | Graphics.LEFT);
		g.drawString("[2]    : HACK up  [8]    : AGI up", paddingLeft, S_FONT_HEIGHT * 5 + paddingTop, Graphics.BOTTOM | Graphics.LEFT);
		g.drawString("[3]    : INT up   [←]   : 戻る", paddingLeft, S_FONT_HEIGHT * 6 + paddingTop, Graphics.BOTTOM | Graphics.LEFT);
		g.drawString("[4]    : DEF up   [→]   : 進む", paddingLeft, S_FONT_HEIGHT * 7 + paddingTop, Graphics.BOTTOM | Graphics.LEFT);
		g.drawString("[5]    : MR up    ", paddingLeft, S_FONT_HEIGHT * 8 + paddingTop, Graphics.BOTTOM | Graphics.LEFT);
		g.drawString("※ 一気振り ON 時（≫を表示）", paddingLeft, S_FONT_HEIGHT * 10 + paddingTop, Graphics.BOTTOM | Graphics.LEFT);
		g.drawString("　必要ポイントが上がるまで振ります", paddingLeft, S_FONT_HEIGHT * 11 + paddingTop, Graphics.BOTTOM | Graphics.LEFT);
	}

	public void paintLogPage(Graphics g) {

		StringBuffer lineBuf = new StringBuffer();
		StringBuffer lineLabelBuf = new StringBuffer();
		StringBuffer tmpBuf = new StringBuffer();
		int row = 0;
		int index = 0;
		for(int i = 0; i < startLine; i++) {
			if (log.indexOf('\n', index ) >= 0 ) {
				index = log.indexOf('\n', index) + 1;

			} else {
				if (i > 0) {
					startLine = i - 1;

				} else {
					startLine = 0;
				}
				break;
			}
		}
		boolean labelFlag = true;
		while (index < log.length() && row < MAX_ROWS) {

			tmpBuf.setLength(0);
			tmpBuf.append(lineBuf.toString());
			tmpBuf.append(log.charAt(index));

			if (FONT.stringWidth(tmpBuf.toString()) > MAX_LEFT_WIDTH) {
				dispLogLabel[row] = lineLabelBuf.toString();
				dispLogValue[row] = lineBuf.toString();

				lineLabelBuf.setLength(0);
				lineBuf.setLength(0);
				lineBuf.append(log.charAt(index));
				row++;
				index++;
				continue;
			}

			if (log.charAt(index) == '\n') {
				dispLogLabel[row] = lineLabelBuf.toString();
				dispLogValue[row] = lineBuf.toString();

				lineLabelBuf.setLength(0);
				lineBuf.setLength(0);
				row++;
				index++;
				continue;
			}

			if (index > 0 && log.charAt(index - 1) == '\n') {
				labelFlag = true;
			}
			if(labelFlag) {
				lineLabelBuf.append(log.charAt(index));

			} else {
				lineBuf.append(log.charAt(index));
			}
			if (log.charAt(index) == ':') {
				labelFlag = false;
			}
			index++;
		}

		g.setColor(BG_COLOR);
		g.fillRect(0,0, getWidth(), getHeight());

		g.setColor(PANEL_SHADE_COLOR);
		g.fillRoundRect(0, FONT_HEIGHT * 4 + FONT_HEIGHT / 2, getWidth(), FONT_HEIGHT * (MAX_ROWS + 2) + FONT_HEIGHT / 2, 8, 8);

		g.setFont(FONT);
		g.setColor(FG_COLOR);

		tmpBuf.setLength(0);
		tmpBuf.append(OreSim.CHARCTERS.getName());
		tmpBuf.append(" / ");
		tmpBuf.append(OreSim.CHARCTERS.getStyleName());
		g.drawString(tmpBuf.toString(), 4, FONT_HEIGHT, Graphics.BOTTOM | Graphics.LEFT);


		tmpBuf.setLength(0);
		tmpBuf.append("Bonus : ");
		tmpBuf.append(OreSim.stm.getTotalBonusPoint());
		tmpBuf.append(" / ");
		tmpBuf.append(OreSim.stm.getTotalLevelUp());
		tmpBuf.append(" Point : ");
		tmpBuf.append(OreSim.stm.getStatusPoint());
		g.drawString(tmpBuf.toString(), 4, FONT_HEIGHT * 2, Graphics.BOTTOM | Graphics.LEFT);

		tmpBuf.setLength(0);
		tmpBuf.append("Lv");
		tmpBuf.append(OreSim.stm.getLevel());
		tmpBuf.append(" STAB ");
		tmpBuf.append(OreSim.stm.getStatus()[0]);
		tmpBuf.append(" HACK ");
		tmpBuf.append(OreSim.stm.getStatus()[1]);
		tmpBuf.append(" INT ");
		tmpBuf.append(OreSim.stm.getStatus()[2]);
		g.drawString(tmpBuf.toString(), 4, FONT_HEIGHT * 3, Graphics.BOTTOM | Graphics.LEFT);

		tmpBuf.setLength(0);
		if (OreSim.stm.getLevel() > 10) {
			tmpBuf.append(" ");
		}
		if (OreSim.stm.getLevel() > 100) {
			tmpBuf.append(" ");
		}
		tmpBuf.append("    DEF ");
		tmpBuf.append(OreSim.stm.getStatus()[3]);
		tmpBuf.append(" MR ");
		tmpBuf.append(OreSim.stm.getStatus()[4]);
		tmpBuf.append(" DEX ");
		tmpBuf.append(OreSim.stm.getStatus()[5]);
		tmpBuf.append(" AGI ");
		tmpBuf.append(OreSim.stm.getStatus()[6]);

		g.drawString(tmpBuf.toString(), 4, FONT_HEIGHT * 4, Graphics.BOTTOM | Graphics.LEFT);

		if(startLine > 0) {
			g.drawString("△", (getWidth() - FONT.stringWidth("△")) / 2, FONT_HEIGHT * 5 + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
		}

		for(int i = 0; i < MAX_ROWS; i++) {
			if (dispLogLabel[i] != null) {
				g.drawString(dispLogLabel[i], 4, FONT_HEIGHT * (6 + i) + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
			}
			if (dispLogValue[i] != null) {
				g.drawString(dispLogValue[i], getWidth() - MAX_LEFT_WIDTH - 4, FONT_HEIGHT * (6 + i) + FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
			}
		}

		maxStartLine = true;
		if(index < log.length() - 1) {
			maxStartLine = false;
			g.drawString("▽", (getWidth() - FONT.stringWidth("▽")) / 2, getHeight() - FONT_HEIGHT / 2, Graphics.BOTTOM | Graphics.LEFT);
		}
	}

	public void paintMenu(Graphics g) {

		g.setColor(BG_COLOR);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setFont(L_FONT);
		for(int i = 0; i < MENU_LABEL.length; i++) {
			g.setColor(FONT_COLOR);
			if(i == selectedMenu) {
				g.fillRect(0, (getHeight() - MENU_LABEL.length * L_FONT_HEIGHT) / 2 + L_FONT_HEIGHT * i, getWidth(), L_FONT_HEIGHT);
				g.setColor(BG_COLOR);
			}
			g.drawString(MENU_LABEL[i], 0, (getHeight() - MENU_LABEL.length * L_FONT_HEIGHT) / 2 + L_FONT_HEIGHT * (1 + i), Graphics.BOTTOM | Graphics.LEFT);
		}
	}

	public void paintSetting(Graphics g) {

		g.setColor(BG_COLOR);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setFont(FONT);
		for(int i = 0; i < SETTING_LABEL.length; i++) {
			g.setColor(FONT_COLOR);
			if(i == setting_selected) {
				g.fillRect(0, (getHeight() - SETTING_LABEL.length * FONT_HEIGHT) / 2 + FONT_HEIGHT * i, getWidth(),FONT_HEIGHT);
				g.setColor(BG_COLOR);
			}
			g.drawString(SETTING_LABEL[i], 0, (getHeight() - SETTING_LABEL.length * FONT_HEIGHT) / 2 + FONT_HEIGHT * (1 + i), Graphics.BOTTOM | Graphics.LEFT);
			g.drawString(value[i], FONT.stringWidth("TWCharacters: "), (getHeight() - SETTING_LABEL.length * FONT_HEIGHT) / 2 + FONT_HEIGHT * (1 + i), Graphics.BOTTOM | Graphics.LEFT);
		}
    }

	public void paintDataList(Graphics g) {

		int HEAD_TOP = (getHeight() - S_FONT_HEIGHT * 10) / 2;
		int MIDDLE_TOP = HEAD_TOP + S_FONT_HEIGHT * 2;

		g.setColor(BG_COLOR);
	    g.fillRect(0, 0, getWidth(), getHeight());

	    g.setFont(S_FONT);

	    for(int i = 0; i < ACTION_LABEL.length; i++) {

	    	g.setColor(SELECT_FONT_COLOR);
	    	if(targetAction == i) {
	    		g.fillRect(S_FONT.stringWidth("  ") + S_FONT.stringWidth("        ") * i, HEAD_TOP, S_FONT.stringWidth(ACTION_LABEL[i]), S_FONT_HEIGHT);
	    	    g.setColor(PANEL_SHADE_COLOR);
	    	}
		    g.drawString(ACTION_LABEL[i], S_FONT.stringWidth("  ") + S_FONT.stringWidth("        ") * i, HEAD_TOP + S_FONT_HEIGHT, Graphics.BOTTOM | Graphics.LEFT);
	    }

	    StringBuffer buf = new StringBuffer();
	    int index = 0;
	    int row = 0;

	    for(int i = 0; i < DATA_LABEL.length; i++) {

		    g.setColor(FONT_COLOR);

		    if( targetData == i) {
	    		g.setColor(FONT_COLOR);
	    		g.fillRect(0, MIDDLE_TOP + S_FONT_HEIGHT * (i * 3), getWidth(), S_FONT_HEIGHT * 3);
	    		g.setColor(PANEL_SHADE_COLOR);
	    	}

		    index = 0;
		    row = 0;
		    while (index < DATA_LABEL[i].length()) {

		    	buf.append(DATA_LABEL[i].charAt(index));
		    	if (DATA_LABEL[i].charAt(index) == '\n') {

				    g.drawString(buf.toString(), S_FONT.stringWidth("  "), MIDDLE_TOP + S_FONT_HEIGHT * (i * 3 + row + 1), Graphics.BOTTOM | Graphics.LEFT);
		    		buf.setLength(0);
		    		row++;
		    	}
		    	index++;
		    }
	    }
	}

	protected void keyPressed(int keyCode) {
		try {
			switch(scene) {
			case 0:
				switch(keyCode) {
				case KEY_NUM1:

					if(OreSim.allocToChangePoint) {
						OreSim.stm.statusUpUntillChange(0);
					} else {
						OreSim.stm.statusUp(0);
					}
					repaint();
					return;

				case KEY_NUM2:

					if(OreSim.allocToChangePoint) {
						OreSim.stm.statusUpUntillChange(1);
					} else {
						OreSim.stm.statusUp(1);
					}
					repaint();
					return;

				case KEY_NUM3:

					if(OreSim.allocToChangePoint) {
						OreSim.stm.statusUpUntillChange(2);
					} else {
						OreSim.stm.statusUp(2);
					}
					repaint();
					return;

				case KEY_NUM4:

					if(OreSim.allocToChangePoint) {
						OreSim.stm.statusUpUntillChange(3);
					} else {
						OreSim.stm.statusUp(3);
					}
					repaint();
					return;

				case KEY_NUM5:

					if(OreSim.allocToChangePoint) {
						OreSim.stm.statusUpUntillChange(4);
					} else {
						OreSim.stm.statusUp(4);
					}
					repaint();
					return;

				case KEY_NUM7:

					if(OreSim.allocToChangePoint) {
						OreSim.stm.statusUpUntillChange(5);
					} else {
						OreSim.stm.statusUp(5);
					}
					repaint();
					return;

				case KEY_NUM8:

					if(OreSim.allocToChangePoint) {
						OreSim.stm.statusUpUntillChange(6);
					} else {
						OreSim.stm.statusUp(6);
					}
					repaint();
					return;
				}
				break;
			}

			if(keyCode == -2147483646 || keyCode == 0 || getKeyName(keyCode).equals("CLEAR") ) {

				if (scene == 0) {
					// クリアキー
					OreSim.stm.init();
					value[2] = OreSim.stm.getXienName();
					repaint();
				}
				return; // au 不具合回避用
			}

			keyCode = getGameAction(keyCode);
			switch(scene) {
			case 10:
				if(keyCode == FIRE) {
					changeScene(0);
					repaint();
				}
				return;

			case 0:
				switch(keyCode) {
				case FIRE :
					OreSim.stm.levelUp();
					repaint();
					return;

				case LEFT :
					OreSim.stm.reverse();
					repaint();
					return;

				case RIGHT :
					synchronized (OreSim.stm) {
						OreSim.stm.progress();
						repaint();
					}
					return;
				}
				break;

			case 1:
				if(keyCode == UP && selectedMenu > 0) {
					selectedMenu--;
					repaint();
				}
				if(keyCode == DOWN && selectedMenu < MENU_LABEL.length - 1) {
					selectedMenu++;
					repaint();
				}
				break;

			case 2:

				switch(keyCode) {
				case UP :
					if ( startLine > 0) {
						startLine--;
						repaint();
					}
					break;

				case DOWN :
					if (!maxStartLine) {
						startLine++;
						repaint();
					}
					break;
				}
				break;

			case 3:

				if(keyCode == FIRE) {
					switch(setting_selected) {
					case 5:
						OreSim.midlet.endApp();
						break;
					}

					value[0] = OreSim.CHARCTERS.getName();
					value[1] = OreSim.CHARCTERS.getStyleInfo()[styleIndex];
					value[2] = OreSim.CHARCTERS.getXienInfo()[xienIndex];
					value[3] = String.valueOf(bonusChoices[bonusIndex]) + "%";

				}
				if(keyCode == RIGHT) {

					switch(setting_selected) {
					case 0:
						characterIndex++;
						characterIndex %= TWCharacters._name.length /* */ -2 /* */;
						styleIndex = 0;

						OreSim.CHARCTERS.charIndex = characterIndex;

						xienIndex = OreSim.CHARCTERS.getDefaultXienIndex(styleIndex);
						for(int i = 0; i < OreSim.CHARCTERS.getXienInfo().length; i++) {

							if (OreSim.CHARCTERS.getXienInfo()[i].equals(Status.XIEN_NAME[xienIndex])) {
								xienIndex = i;
								break;
							}
						}
						break;

					case 1:
						styleIndex++;
						styleIndex %= OreSim.CHARCTERS.getStyleInfo().length;

						xienIndex = OreSim.CHARCTERS.getDefaultXienIndex(styleIndex);
						for(int i = 0; i < OreSim.CHARCTERS.getXienInfo().length; i++) {

							if (OreSim.CHARCTERS.getXienInfo()[i].equals(Status.XIEN_NAME[xienIndex])) {
								xienIndex = i;
								break;
							}
						}
						break;

					case 2:
						xienIndex++;
						xienIndex %= OreSim.CHARCTERS.getXienInfo().length;
						break;

					case 3:
						bonusIndex++;
						bonusIndex %= bonusChoices.length;
						break;

					case 4:
						allocToChange = !allocToChange;
						break;

					}

					value[0] = OreSim.CHARCTERS.getName();
					value[1] = OreSim.CHARCTERS.getStyleInfo()[styleIndex];
					value[2] = OreSim.CHARCTERS.getXienInfo()[xienIndex];
					value[3] = String.valueOf(bonusChoices[bonusIndex]) + "%";

					if (allocToChange) {
						value[4] = ON;

					} else {
						value[4] = OFF;
					}
				}
				if(keyCode == LEFT) {

					switch(setting_selected) {
					case 0:
						characterIndex--;
						characterIndex += TWCharacters._name.length /* */ -2 /* */;
						characterIndex %= TWCharacters._name.length /* */ -2 /* */;
						styleIndex = 0;

						OreSim.CHARCTERS.charIndex = characterIndex;

						xienIndex = OreSim.CHARCTERS.getDefaultXienIndex(styleIndex);
						for(int i = 0; i < OreSim.CHARCTERS.getXienInfo().length; i++) {

							if (OreSim.CHARCTERS.getXienInfo()[i].equals(Status.XIEN_NAME[xienIndex])) {
								xienIndex = i;
								break;
							}
						}
						break;

					case 1:
						styleIndex--;
						styleIndex += OreSim.CHARCTERS.getStyleInfo().length;
						styleIndex %= OreSim.CHARCTERS.getStyleInfo().length;

						xienIndex = OreSim.CHARCTERS.getDefaultXienIndex(styleIndex);
						for(int i = 0; i < OreSim.CHARCTERS.getXienInfo().length; i++) {

							if (OreSim.CHARCTERS.getXienInfo()[i].equals(Status.XIEN_NAME[xienIndex])) {
								xienIndex = i;
								break;
							}
						}
						break;

					case 2:
						xienIndex--;
						xienIndex += OreSim.CHARCTERS.getXienInfo().length;
						xienIndex %= OreSim.CHARCTERS.getXienInfo().length;
						break;

					case 3:
						bonusIndex--;
						bonusIndex += bonusChoices.length;
						bonusIndex %= bonusChoices.length;
						break;

					case 4:
						allocToChange = !allocToChange;
						break;

					}

					value[0] = OreSim.CHARCTERS.getName();
					value[1] = OreSim.CHARCTERS.getStyleInfo()[styleIndex];
					value[2] = OreSim.CHARCTERS.getXienInfo()[xienIndex];
					value[3] = String.valueOf(bonusChoices[bonusIndex]) + "%";

					if (allocToChange) {
						value[4] = ON;

					} else {
						value[4] = OFF;
					}
				}
				if(keyCode == UP && setting_selected > 0) {
					setting_selected--;
					repaint();
				}
				if(keyCode == DOWN && setting_selected < SETTING_LABEL.length - 1) {
					setting_selected++;
					repaint();
				}

				repaint();
				break;

			case 4:

				switch(keyCode) {
				case LEFT :
					if ( targetAction > 0) {
						targetAction--;
						repaint();
					}
					break;

				case RIGHT :
					if (targetAction < ACTION_LABEL.length - 1) {
						targetAction++;
						repaint();
					}
					break;

				case UP :
					if ( targetData > 0) {
						targetData--;
						repaint();
					}
					break;

				case DOWN :
					if (targetData < DATA_LABEL.length - 1) {
						targetData++;
						repaint();
					}
					break;
				}
				break;
			}

		} catch (IllegalArgumentException iae) {
//			if (scene == 0) {
//				// クリアキー
//				OreSim.stm.init();
//				value[2] = OreSim.stm.getXienName();
//				repaint();
//			}
//			return;
		}
	}

	protected void keyReleased(int keyCode) {
		try {
			if( keyCode == -2147483646 || keyCode == 0 || getKeyName(keyCode).equals("CLEAR") ) {

				return; // au 不具合回避用
			}

	     		keyCode = getGameAction(keyCode);

			switch(scene) {
			case 1:

				if(keyCode == FIRE) {

					switch(selectedMenu) {
					case 0:
						OreSim.stm.init();
						value[2] = OreSim.stm.getXienName();
						changeScene(0);
						repaint();
						break;

					case 1:
						changeScene(2);
						repaint();
						break;

//					case 2:
//						OreSim.statusForm.update();
//						Display.getDisplay(OreSim.midlet).setCurrent(OreSim.statusForm);
//						break;
//
					case 2:
						changeScene(4);
						repaint();
						break;

					case 3:
						changeScene(5);
						repaint();
						break;

					case 4:
//						Dialog endDialog = new Dialog(Dialog.DIALOG_YESNO, "俺シミュ終了");
//						endDialog.setText("終了しますか？");
//
//						if(endDialog.show() != Dialog.BUTTON_YES) {
//							break;
//						}
						OreSim.midlet.endApp();
						break;
					}
				}
				break;

			case 4:

				switch(keyCode) {
				case FIRE :

					RecordStore rs = null;
					try {
						switch(targetAction) {
						case 0:
							// Load
//							Dialog loadDialog = new Dialog(Dialog.DIALOG_YESNO, "ロード");
//							loadDialog.setText("ロードしますか？");

							if (!DATA_LABEL[targetData].equals("NO DATA\n") /* && loadDialog.show() == Dialog.BUTTON_YES */ ) {
//								loadDialog = null;

								rs = RecordStore.openRecordStore("oresim_data", true);
								String data = new String(rs.getRecord(DATA_ID[targetData + DATA_LABEL.length]));
								rs.closeRecordStore();

								OreSim.CHARCTERS.charIndex = (data.charAt(0) - '0');
								OreSim.CHARCTERS.setStyleIndex(data.charAt(1) - '0');
								data = data.substring(2);
						    	OreSim.stm.init();
								OreSim.stm.playLog(data);
								changeScene(0);
								repaint();
							}
							break;

						case 1:
							// Save
//							Dialog saveDialog = new Dialog(Dialog.DIALOG_YESNO, "セーブ");
//							saveDialog.setText("セーブしますか？");
//
//							if(saveDialog.show() != Dialog.BUTTON_YES) {
//								break;
//							}

							StringBuffer labelBuf = new StringBuffer();
							labelBuf.append(OreSim.CHARCTERS.getName());
							labelBuf.append(" ");
							labelBuf.append(OreSim.CHARCTERS.getStyleName());
							labelBuf.append(" Lv");
							labelBuf.append(OreSim.stm.getLevel());
							labelBuf.append(" P ");
							labelBuf.append(OreSim.stm.getStatusPoint());
							labelBuf.append("\nSTAB ");
							labelBuf.append(OreSim.stm.getStatus()[0]);
							labelBuf.append(" HACK ");
							labelBuf.append(OreSim.stm.getStatus()[1]);
							labelBuf.append(" INT ");
							labelBuf.append(OreSim.stm.getStatus()[2]);

							if (OreSim.stm.getLevel() > 10) {
								labelBuf.append(" ");
							}
							if (OreSim.stm.getLevel() > 100) {
								labelBuf.append(" ");
							}
							labelBuf.append("\nDEF ");
							labelBuf.append(OreSim.stm.getStatus()[3]);
							labelBuf.append(" MR ");
							labelBuf.append(OreSim.stm.getStatus()[4]);
							labelBuf.append(" DEX ");
							labelBuf.append(OreSim.stm.getStatus()[5]);
							labelBuf.append(" AGI ");
							labelBuf.append(OreSim.stm.getStatus()[6]);
							labelBuf.append("\n");
							DATA_LABEL[targetData] = labelBuf.toString();

							rs = RecordStore.openRecordStore("oresim_label", true);
							rs.setRecord(DATA_ID[targetData], DATA_LABEL[targetData].getBytes(), 0, DATA_LABEL[targetData].getBytes().length);
							rs.closeRecordStore();

							StringBuffer tmpBuf = new StringBuffer();
							tmpBuf.append("0123456789:;<=>?".charAt(OreSim.CHARCTERS.charIndex));
							tmpBuf.append(OreSim.CHARCTERS.getStyleIndex());
							tmpBuf.append(OreSim.stm.allocationBuffer.toString());

							rs = RecordStore.openRecordStore("oresim_data", true);
							rs.setRecord(DATA_ID[targetData + DATA_LABEL.length], tmpBuf.toString().getBytes(), 0, tmpBuf.toString().getBytes().length);
							rs.closeRecordStore();
							break;

						case 2:
							// Delete
//							Dialog delDialog = new Dialog(Dialog.DIALOG_YESNO, "データ削除");
//							delDialog.setText("削除しますか？");
//
//							if(delDialog.show() != Dialog.BUTTON_YES) {
//								break;
//							}

							DATA_LABEL[targetData] = "NO DATA\n";

							rs = RecordStore.openRecordStore("oresim_label", true);
							rs.setRecord(DATA_ID[targetData], DATA_LABEL[targetData].getBytes(), 0, DATA_LABEL[targetData].getBytes().length);
							rs.closeRecordStore();

							rs = RecordStore.openRecordStore("oresim_data", true);
							rs.setRecord(DATA_ID[targetData + DATA_LABEL.length], "00".getBytes(), 0, "00".getBytes().length);
							rs.closeRecordStore();
							break;
						}

					} catch (RecordStoreNotOpenException e) {
					} catch (InvalidRecordIDException e) {
					} catch (RecordStoreFullException e) {
					} catch (RecordStoreException e) {
					} finally {

						try {
							if(rs != null) {
								rs.closeRecordStore();
							}

						} catch (RecordStoreNotOpenException e) {
						} catch (RecordStoreException e) {
						}
					}
					repaint();
					break;
				}
			}
		} catch (IllegalArgumentException iae) {
			return;
		}
	}

	protected void keyRepeated(int keyCode) {
		keyPressed(keyCode);
	}

	public void commandAction(Command command, Displayable displayable) {
		switch(scene) {

		case 4:
		case 5:
			if(command == commands[2]) {
     			changeScene(0);
				repaint();
				break;
			}
			break;

		case 10:
			if(command == commands[6]) {
				OreSim.midlet.endApp();
			}
			break;

		case 0:
			if(command == commands[0]) {
				changeScene(1);
				repaint();
			}
			if(command == commands[1]) {
				changeScene(3);
				repaint();
            }
			break;

		case 1:
			if(command == commands[2]) {
				changeScene(0);
				repaint();
			}
			break;

		case 2:
			if(command == commands[2]) {
				changeScene(0);
				repaint();
			}
			if(command == commands[7]) {
			    Display.getDisplay(OreSim.midlet).setCurrent(OreSim.logForm);
			    OreSim.logForm.update();

				repaint();
			}
			break;

		case 3:

			if(command == commands[4]) {

				if (OreSim.CHARCTERS.charIndex != original[0]) {
					OreSim.CHARCTERS.charIndex = characterIndex;
					OreSim.stm.init();

					value[2] = OreSim.stm.getXienName();
				}
				if (!OreSim.CHARCTERS.getStyleName().equals(value[1])) {
					OreSim.CHARCTERS.setStyleIndex(styleIndex);
					OreSim.stm.init();

					value[2] = OreSim.stm.getXienName();
				}
				for(int i = 0; i < Status.XIEN_NAME.length; i++) {

					if(Status.XIEN_NAME[i].equals(value[2])) {

						if (OreSim.stm.changeXien(i) != i) {
							StringBuffer buf = new StringBuffer(Status.XIEN_NAME[i]);
							buf.append(" の変更に\n必要なレベルに達していません\n  ");

							Alert dialog = new Alert("必要 Lv 不足", buf.toString(), null, AlertType.WARNING);
							Display.getDisplay(OreSim.midlet).setCurrent(dialog, this);

							value[2] = OreSim.stm.getXienName();

							changeScene(0);
						}
					}
				}
				OreSim.stm.changeBonusExpected(bonusChoices[bonusIndex]);
				OreSim.allocToChangePoint = allocToChange;

				changeScene(0);
			}

			if(command == commands[3]) {

				characterIndex = original[0];
				styleIndex = original[1];
				xienIndex = original[2];
				bonusIndex = original[3];
				allocToChange = OreSim.allocToChangePoint;

				OreSim.CHARCTERS.charIndex = characterIndex;
				OreSim.CHARCTERS.setStyleIndex(styleIndex);

				value[0] = OreSim.CHARCTERS.getName();
				value[1] = OreSim.CHARCTERS.getStyleInfo()[styleIndex];
				value[2] = OreSim.CHARCTERS.getXienInfo()[xienIndex];
				value[3] = String.valueOf(bonusChoices[bonusIndex]) + "%";

				changeScene(0);
				repaint();
			}

			repaint();
			break;
		}
	}
}
