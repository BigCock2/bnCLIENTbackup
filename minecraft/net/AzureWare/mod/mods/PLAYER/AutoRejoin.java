package net.AzureWare.mod.mods.PLAYER;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import javax.swing.JOptionPane;

import com.darkmagician6.eventapi.EventTarget;

import net.AzureWare.events.EventChat;
import net.AzureWare.mod.Mod;
import net.minecraft.Wrapper;

public class AutoRejoin extends Mod {

	public AutoRejoin() {
		super("AutoRejoin", Category.PLAYER);
		// TODO �Զ����ɵĹ��캯�����
	}
	@EventTarget
	public void onChat(EventChat e) {
		if(e.getMessage().contains("����������ӳ���С����")) mc.thePlayer.sendChatMessage("/rejoin");
	}
}
