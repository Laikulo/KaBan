package guru.haun.kaban;

import guru.haun.kaban.commands.KabanCmdGroup;
import guru.haun.kaban.listener.KabanPreLoginListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import org.bukkit.plugin.java.JavaPlugin;

public class KaBan extends JavaPlugin {
	private static String kabanVersion;
	public KaBanMessenger messenger;
	
	
	public List<KaBanBanList> banlist = new ArrayList<KaBanBanList>();
	
	
	@Override
	public void onEnable(){
		messenger = new KaBanMessenger("KaBan");
		kabanVersion = this.getDescription().getVersion();
		this.getLogger().log(Level.WARNING, "This is a development version of KaBan, USE AT YOUR OWN RISK!");
		
		KaBanBanList testentry = new KaBanBanList();
		testentry.banned = UUID.fromString("65e697b0e1104f27911fa64b1eb47463");
		testentry.banner = UUID.fromString("718cf67190844e78b91f033e80aa11bf");
		testentry.bannedName = "DrkBahamut";
		testentry.bannerName = "KJ4IPS";
		testentry.bannedTime.setTime(5);
		testentry.bannedTime.setTime(0);
		testentry.reason = "We do what we must because we can";
		
		this.getCommand("kaban").setExecutor(new KabanCmdGroup(this));
		this.getServer().getPluginManager().registerEvents(new KabanPreLoginListener(this), this);
	}
	
	public void onDisable(){
		
	}
	
	public String getKabanVersion(){
		return kabanVersion;
	}
}
