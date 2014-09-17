package net.chilimod.mod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import net.chilimod.mod.items.ChiliFoods;

public class VersionCheck {
	public static void CheckVersion()
	{
		try {
			String location = "http://chilimod.alaxcis.com/chilimod-versions.txt";
			HttpURLConnection conn = null;
			while (location != null && !location.isEmpty()) {
				URL url = new URL(location);

				if (conn != null) {
					conn.disconnect();
				}

				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.0; ru; rv:1.9.0.11) Gecko/2009060215 Firefox/3.0.11 (.NET CLR 3.5.30729)");
				conn.connect();
				location = conn.getHeaderField("Location");
			}

			if (conn == null) {
				throw new NullPointerException();
			}

			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			String line;
			String minecraftVersion = ChiliMod.proxy.getMinecraftVersion();
			String lastestVersion;
			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(":");
				if (minecraftVersion.matches(tokens[0])) {
					lastestVersion = tokens[1];
					if (ChiliMod.version.matches(tokens[1])) {
						System.out.println("Using the latest version of ChiliMod for Minecraft " + minecraftVersion);
						return;
					}
				}
			}

			System.out.println("There is an update for Chili Mod.");

			conn.disconnect();
			reader.close();
		} catch (Exception e) {
			System.out.println("Could not read version file");
		}
	}
}
