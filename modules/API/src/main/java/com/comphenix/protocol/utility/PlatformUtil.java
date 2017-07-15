package com.comphenix.protocol.utility;

import org.bukkit.Server;

public class PlatformUtil {

    private static Boolean glowstone;

    public static boolean isGlowstone() {
        if (glowstone != null) {
            return glowstone;
        }
        try {
            Class.forName("net.glowstone.GlowServer");
        } catch (ClassNotFoundException e) {
            glowstone = false;
            return false;
        }
        glowstone = true;
        return true;
    }

    public static String getMinecraftVersion(Server server) {
        if (isGlowstone()) {
            // Glowstone has a static field for game version
            return server.getName() + " (MC: " + net.glowstone.GlowServer.GAME_VERSION + ")";
        }
        return server.getVersion();
    }

}
