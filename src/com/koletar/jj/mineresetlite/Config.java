package com.koletar.jj.mineresetlite;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author jjkoletar
 */
public class Config {
    private Config() {}
    private static boolean broadcastInWorldOnly = false;
    private static boolean broadcastNearbyOnly = false;
    private static boolean checkForUpdates = true;
    private static String locale = "en";
    private static int resetDelay = 20; // in ticks.
    private static int resetBlocksPerStep = 256;
    private static int resetTaskInterval = 3; // in ticks.
    private static boolean mineResetAtStart = false;
    private static int bufferSaveDelay = 60;

    public static int getResetBlocksPerStep() {
        return resetBlocksPerStep;
    }
    public static void setResetBlocksPerStep(int resetBlocksPerStep) {
        Config.resetBlocksPerStep = resetBlocksPerStep;
    }
    private static void writeResetBlocksPerStep(BufferedWriter out) throws IOException {
        out.write("# This option defines the number of blocks to be reset at the time.");
        out.newLine();
        out.write("reset-blocks-per-step: 256");
        out.newLine();
    }

    public static int getResetTaskInterval() {
        return resetTaskInterval;
    }

    public static void setResetTaskInterval(int resetTaskInterval) {
        Config.resetTaskInterval = resetTaskInterval;
    }
    private static void writeResetTaskInterval(BufferedWriter out) throws IOException {
        out.write("# This option defines the delay (in ticks , 20 ticks = 1 sec) between the gradual reset steps.");
        out.newLine();
        out.write("reset-task-interval: 3");
        out.newLine();
    }

    public static int getResetDelay() {
        return resetDelay;
    }
    
    public static void setResetDelay(int resetDelay) {
        Config.resetDelay = resetDelay;
    }
    
    private static void writeResetDelay(BufferedWriter out) throws IOException {
        out.write("# This option defines the delay (in ticks , 20 ticks = 1 sec) between the issue of reset command");
        out.newLine();
        out.write("# and the actual execution of the reset action.  If you have large explosions in the mine, you might need to ");
        out.newLine();
        out.write("# increase this value to make sore the explosion action completes before the reset process commences.");
        out.newLine();
        out.write("reset-delay: 20");
        out.newLine();
    }

    static boolean getBroadcastInWorldOnly() {
        return broadcastInWorldOnly;
    }

    static boolean getBroadcastNearbyOnly() {
        return broadcastNearbyOnly;
    }

    private static void setBroadcastInWorldOnly(boolean broadcastInWorldOnly) {
        Config.broadcastInWorldOnly = broadcastInWorldOnly;
    }

    private static void setBroadcastNearbyOnly(boolean broadcastNearbyOnly) {
        Config.broadcastNearbyOnly = broadcastNearbyOnly;
    }

    private static void writeBroadcastInWorldOnly(BufferedWriter out) throws IOException {
        out.write("# If you have multiple worlds, and wish for only the worlds in which your mine resides to receive");
        out.newLine();
        out.write("# reset notifications, and automatic reset warnings, set this to true.");
        out.newLine();
        out.write("broadcast-in-world-only: false");
        out.newLine();
    }

    private static void writeBroadcastNearbyOnly(BufferedWriter out) throws IOException {
        out.write("# If you only want players nearby the mines to receive reset notifications,");
        out.newLine();
        out.write("# and automatic reset warnings, set this to true. Note: Currently only broadcasts to players in the mine");
        out.newLine();
        out.write("broadcast-nearby-only: false");
        out.newLine();
    }

    public static boolean getCheckForUpdates() {
        return checkForUpdates;
    }

    private static void setCheckForUpdates(boolean checkForUpdates) {
        Config.checkForUpdates = checkForUpdates;
    }
    
    private static void writeCheckForUpdates(BufferedWriter out) throws IOException {
        out.write("# When true, this config option enables update alerts. I do not send any extra information along when ");
        out.newLine();
        out.write("# checking, and query a static file hosted on Dropbox. ");
        out.newLine();
        out.write("check-for-updates: true");
        out.newLine();
    }

    static String getLocale() {
        return locale;
    }

    private static void setLocale(String locale) {
        Config.locale = locale;
    }

    private static void writeLocale(BufferedWriter out) throws IOException {
        out.write("# MineResetLite supports multiple languages. Indicate the language to be used here.");
        out.newLine();
        out.write("# Languages available at the time this config was generated: Danish (thanks Beijiru), Spanish (thanks enetocs), Portuguese (thanks FelipeMarques14), Italian (thanks JoLong)");
        out.newLine();
        out.write("# Use the following values for these languages: English: 'en', Danish: 'da', Spanish: 'es', Portuguese: 'pt', Italian: 'it', French: 'fr', Dutch: 'nl', Polish: 'pl'");
        out.newLine();
        out.write("# A fully up-to-date list of languages is available at http://dev.bukkit.org/server-mods/mineresetlite/pages/internationalization/");
        out.newLine();
        out.write("locale: en");
        out.newLine();
    }

    public static Effect getLuckyEffect() {
        return luckyEffect;
    }
    
    private static void setLuckyEffect(Effect effect) {
        luckyEffect = effect;
    }
    
    public static Sound getLuckySound() {
        return luckySound;
    }
    
    private static void setLuckySound(Sound sound) {
        luckySound = sound;
    }
    
    private static Effect luckyEffect;
    private static Sound luckySound;
    private static void writeLuckyEffect(BufferedWriter out) throws IOException {
        out.write("# This option specifies the visual effect played when a player mines a lucky block.");
        out.newLine();
        out.write("lucky_block_effect: MOBSPAWNER_FLAMES");
        out.newLine();
    }
    private static void writeLuckySound(BufferedWriter out) throws IOException {
        out.write("# This option specifies the sound effect played when a player mines a lucky block.");
        out.newLine();
        out.write("lucky_block_sound: AMBIENCE_THUNDER");
        out.newLine();
    }

    public static boolean getMineResetAtStart() {
        return Config.mineResetAtStart;
    }
    private static void setMineResetAtStart(boolean mineResetAtStart) {
        Config.mineResetAtStart = mineResetAtStart;
    }

    private static void writeMineResetAtStart(BufferedWriter out) throws IOException {
        out.write("# When true, all mines are reset at the server startup.");
        out.newLine();
        out.write("mine-reset-at-start: true");
        out.newLine();
    }

    public static int getBufferSaveDelay() {
        return Config.bufferSaveDelay;
    }
    private static void setBufferSaveDelay(int bufferSaveDelay) {
        Config.bufferSaveDelay = bufferSaveDelay;
    }

    private static void writeBufferSaveDelay(BufferedWriter out) throws IOException {
        out.write("# Time in second indicating the delay in saving the mine changes you made.");
        out.newLine();
        out.write("buffer-save-delay: 60");
        out.newLine();
    }

    static void initConfig(File dataFolder) throws IOException {
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }
        File configFile = new File(dataFolder, "config.yml");
        if (!configFile.exists()) {
            configFile.createNewFile();
            BufferedWriter out = new BufferedWriter(new FileWriter(configFile));
            out.write("# MineResetLite Configuration File");
            out.newLine();
            Config.writeBroadcastInWorldOnly(out);
            Config.writeBroadcastNearbyOnly(out);
            Config.writeCheckForUpdates(out);
            Config.writeLocale(out);
            Config.writeResetDelay(out);
            Config.writeLuckyEffect(out);
            Config.writeLuckySound(out);
            out.close();
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(configFile);
        BufferedWriter out = new BufferedWriter(new FileWriter(configFile, true));
        if (config.contains("broadcast-in-world-only")) {
            Config.setBroadcastInWorldOnly(config.getBoolean("broadcast-in-world-only"));
        } else {
            Config.writeBroadcastInWorldOnly(out);
        }
        if (config.contains("broadcast-nearby-only")) {
            Config.setBroadcastNearbyOnly(config.getBoolean("broadcast-nearby-only"));
        } else {
            Config.writeBroadcastNearbyOnly(out);
        }
        if (config.contains("check-for-updates")) {
            Config.setCheckForUpdates(config.getBoolean("check-for-updates"));
        } else {
            Config.writeCheckForUpdates(out);
        }
        if (config.contains("locale")) {
            Config.setLocale(config.getString("locale"));
        } else {
            Config.writeLocale(out);
        }
        if (config.contains("reset-delay")) {
            Config.setResetDelay(config.getInt("reset-delay", 20));
        } else {
            Config.writeResetDelay(out);
        }
        if (config.contains("reset-task-interval")) {
            Config.setResetTaskInterval(config.getInt("reset-task-interval", 5));
        } else {
            Config.writeResetTaskInterval(out);
        }
        if (config.contains("reset-blocks-per-step")) {
            Config.setResetBlocksPerStep(config.getInt("reset-blocks-per-step", 256));
        } else {
            Config.writeResetBlocksPerStep(out);
        }

        if (config.contains("lucky_block_effect")) {
            try {
                Config.setLuckyEffect(Effect.valueOf(config.getString("lucky_block_effect", "MOBSPAWNER_FLAMES")));
            } catch (Throwable ignore) {
                Config.setLuckyEffect(null);
            }
        } else {
            Config.writeLuckyEffect(out);
        }
        if (config.contains("lucky_block_sound")) {
            try {
                Config.setLuckySound(Sound.valueOf(config.getString("lucky_block_sound", "AMBIENCE_THUNDER")));
            } catch (Throwable ignore) {
                Config.setLuckySound(null);
            }
        } else {
            Config.writeLuckySound(out);
        }
        if (config.contains("mine-reset-at-start")) {
            Config.setMineResetAtStart(config.getBoolean("mine-reset-at-start", true));
        } else {
            Config.writeMineResetAtStart(out);
        }

        if (config.contains("buffer-save-delay")) {
            Config.setBufferSaveDelay(config.getInt("buffer-save-delay", 60));
        } else {
            Config.writeBufferSaveDelay(out);
        }
        out.close();
    }
}
