package net.AzureWare.mod.mods.PLAYER;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.darkmagician6.eventapi.EventTarget;

import net.AzureWare.events.EventChat;
import net.AzureWare.events.EventRender2D;
import net.AzureWare.events.EventUpdate;
import net.AzureWare.mod.Mod;
import net.AzureWare.mod.mods.COMBAT.AntiBot;
import net.AzureWare.ui.notification.Notification;
import net.AzureWare.utils.ClientUtil;
import net.AzureWare.utils.PlayerUtil;
import net.AzureWare.utils.TimeHelper;
import net.AzureWare.value.Value;
import net.minecraft.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class BanCheck extends Mod {

	public static String[] modlist = new String[] { "mxu", "zofia", "��������", "heav3ns", "chrisan", "С����", "chen_xixi",
			"��ɪ", "tanker_01", "bingmo", "crazyforlove", "SnowDay", "�컯������", "Owenkill", "chen_duxiu", "Lyra2REv2",
			"ʱ�����ϲ�������", "hefew", "��ʿ��", "minikloon" , "StartOver_"};
	private String modname;
	private TimeHelper timer = new TimeHelper();
	private List<String> offlinemod = new ArrayList();
	private List<String> onlinemod = new ArrayList();
	private Value<Boolean> blockwdmessage = new Value("ModChecker_BlockWatchdogMessage", false);
	private Value<Boolean> showOffline = new Value("ModChecker_ShowOffline", true);
	private Value<Boolean> showOnline = new Value("ModChecker_ShowOnline", true);
	private Value<Boolean> checkwho = new Value("ModChecker_HackerWarning", true);
	private int counter;
	private boolean isFinished;
	public static String[] hackMessage = new String[] { "���", "�ڿ�", "��G", "���", "��", "�ܷ�", "�Զ�����", "ɱ¾�⻷", "ɱ¾",
			"hack", "hacker", "hax", "G", "�Ҹ�", "reach", "������", "����", "���޵з���", "ˢ��Դ", "�޵з���", "���", "����", "�¶�", "�ұ�",
			"�ұ�", "��bug", "�ܺ���", "�����Ҵ�·", "�Ӷ���", "�Զ���·" };

	public BanCheck() {
		super("ModChecker", Category.PLAYER);
	}
	@EventTarget
	public void onRender(EventRender2D e) {
		FontRenderer font = mc.fontRendererObj;
		List<String> listArray = Arrays.asList(modlist);
		listArray.sort((o1, o2) -> {
			return font.getStringWidth(o2) - font.getStringWidth(o1);
		});
		int counter2 = 0;
		for (String mods : listArray) {
			if (offlinemod.contains(mods) && showOffline.getValueState()) {
				font.drawStringWithShadow(mods, 5, 135 + counter2 * 10, Color.RED.getRGB());
				counter2++;
			}
			if (onlinemod.contains(mods) && showOnline.getValueState()) {
				font.drawStringWithShadow(mods, 5, 135 + counter2 * 10, Color.GREEN.getRGB());
				counter2++;
			}

		}
	}

	@EventTarget
	public void onChat(EventChat e) {
		if (blockwdmessage.getValueState()) {
			if (e.getMessage().contains("[WATCHDOG] Thanks for your report!") || e.getMessage().contains("[WATCHDOG] You reported")) {
				e.setCancelled(true);
			}
		}
		
		if (checkwho.getValueState()) {
			for (String s : hackMessage) {
				if (e.getMessage().contains(s) && !e.getMessage().contains("WATCHDOG") && !e.getMessage().contains("AzureWare")) {
					ClientUtil.sendClientMessage("Someone Called You Hacker!", Notification.Type.WARNING);
					break;
				}
			}
		}
		if (e.getMessage().contains("���ӵ�����"))
			mc.thePlayer.sendChatMessage("/chat a");
		if (e.getMessage().contains("������Ҳ����ߣ�") || e.getMessage().contains("That player is not online!")) {
			e.setCancelled(true);
			if (onlinemod.contains(modname)) {
				PlayerUtil.tellPlayer("\247b[AzureWare]\247c" + modname + "\247a�����ߣ�");
				onlinemod.remove(modname);
				offlinemod.add(modname);
				return;
			}
			if (!offlinemod.contains(modname)) {
				PlayerUtil.tellPlayer("\247b[AzureWare]\247c" + modname + "\247a�����ߣ�");
				offlinemod.add(modname);
			}
		}

		if (e.getMessage().contains("You cannot message this player.") || e.getMessage().contains("���ӵ�����")) {
			e.setCancelled(true);
			if (offlinemod.contains(modname)) {
				PlayerUtil.tellPlayer("\247b[AzureWare]\247c" + modname + "\247a�����ߣ�");
				offlinemod.remove(modname);
				onlinemod.add(modname);
				return;
			}
			if (!onlinemod.contains(modname)) {
				PlayerUtil.tellPlayer("\247b[AzureWare]\247c" + modname + "\247a���ߣ�");
				onlinemod.add(modname);
			}
		}

		if (e.getMessage().contains("�Ҳ�����Ϊ \"" + modname + "\" �����")) {
			System.out.println(modname + "�����ڣ�");
			e.setCancelled(true);
		}
	}

	@EventTarget
	public void onUpdate(EventUpdate e) {
		if (timer.isDelayComplete(isFinished ? 15000L : 8000L)) {
			if (counter >= modlist.length) {
				counter = -1;
				if (!isFinished) {
					isFinished = true;
				}

			}
			counter++;
			modname = modlist[counter];
			mc.thePlayer.sendChatMessage("/message " + modname);
			timer.reset();
		}
	}

	public String getRandomMessage() {
		String[] helloMessage = new String[] { "hi", "����", "�ڲ�", "�ڲ���", "�ڲ��ڰ�", "�ܹ�����", "hello", "�п�û", "������", "����",
				"������", "����������", "�кڿ�", "�ܲ��ܹ���һ��", "�ٱ�", "��ô�ٱ�", "���ǹ�����", "���ǿͷ���", "�ܾٱ���", "�ܴ�����", "��ban����" };

		String playerName = "����";
		for (Entity e : mc.theWorld.loadedEntityList) {
			if (e instanceof EntityPlayer && !AntiBot.isBot(e) && !Teams.isOnSameTeam(e)
					&& e != mc.thePlayer) {
				playerName = new Random().nextBoolean() ? e.getName() : e.getName().toLowerCase();
			}
		}

		String resultMessage = helloMessage[new Random().nextInt(helloMessage.length - 1)]
				+ (new Random().nextBoolean() ? " " : ",") + playerName + (new Random().nextBoolean() ? " " : ",")
				+ hackMessage[new Random().nextInt(hackMessage.length - 1)];

		return resultMessage;
	}
}
