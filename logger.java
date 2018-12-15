package me.dannylanssink.logger;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;

import me.dannylanssink.logger.main;

public class logger {
	private static final Logger log = Logger.getLogger("Minecraft");
	private static main plugin = main.getPlugin(main.class);
	private static PluginDescriptionFile pdf = plugin.getDescription();
	private static String pluginname = pdf.getName();
	private static String prefix = pdf.getPrefix();
	
	/**
	 * logging messages for easy debugging.
	 * @param name the name of the class where the input is comming from.
	 * @param message the message that the logger need to log.
	 * @param debug wheter or not it is a debug message.
	 * @since 12/14/2018
	 * @author Danny Lanssink
	 */
	public static void info(String name, String message, boolean debug) {
		if(debug == true) {
			if(pdf.getVersion().contains("dev")) {
				if(prefix != null) {
					log.info("[" + prefix + "]" + " [debug] " + "[" + name + "] " + message);
				}else {
					log.info("[" + pluginname + "]" + " [debug] " + "[" + name + "] " + message);
				}
			}
		} else {
			if(prefix != null) {
				log.info("[" + prefix + "]" + " [" + name + "] " + message);
			}else {
				log.info("[" + pluginname + "]" + " [" + name + "] " + message);
			}
		}
	}
	
	/**
	 * log messages that needs special attention.
	 * @param name the name of the class where the input is comming from.
	 * @param message the message that the logger need to log.
	 * @since 12/15/2018
	 * @author Danny Lanssink
	 */
	public static void warning(String name, String message) {
		if(prefix != null) {
			log.warning("[" + prefix + "]" + " [" + name + "] " + message);
		}else {
			log.warning("[" + pluginname + "]" + " [" + name + "] " + message);
		}
	}
}
