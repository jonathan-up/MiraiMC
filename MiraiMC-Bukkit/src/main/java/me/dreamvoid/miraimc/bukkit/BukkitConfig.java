package me.dreamvoid.miraimc.bukkit;

import static me.dreamvoid.miraimc.internal.Config.*;

public class BukkitConfig {
    private final BukkitPlugin plugin;
    private static BukkitConfig Instance;

    public BukkitConfig(BukkitPlugin plugin){
        Instance = this;
        this.plugin = plugin;
        PluginDir = plugin.getDataFolder();
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();

        Gen_AllowBstats = plugin.getConfig().getBoolean("general.allow-bStats",true);
        Gen_DisableSafeWarningMessage = plugin.getConfig().getBoolean("general.disable-safe-warning-message",false);
        Gen_MiraiWorkingDir = plugin.getConfig().getString("general.mirai-working-dir","default");
        Gen_AddProperties_MiraiNoDesktop = plugin.getConfig().getBoolean("general.add-properties.mirai.no-desktop",true);
        Gen_AddProperties_MiraiSliderCaptchaSupported = plugin.getConfig().getBoolean("general.add-properties.mirai.slider.captcha.supported",true);

        Bot_DisableNetworkLogs = plugin.getConfig().getBoolean("bot.disable-network-logs",false);
        Bot_DisableBotLogs = plugin.getConfig().getBoolean("bot.disable-bot-logs",false);
        Bot_UseBukkitLogger_BotLogs = plugin.getConfig().getBoolean("bot.use-bukkit-logger.bot-logs",true);
        Bot_UseBukkitLogger_NetworkLogs = plugin.getConfig().getBoolean("bot.use-bukkit-logger.network-logs",true);
        Bot_LogEvents = plugin.getConfig().getBoolean("bot.log-events",true);
        Bot_ContactCache_EnableFriendListCache = plugin.getConfig().getBoolean("bot.contact-cache.enable-friend-list-cache",false);
        Bot_ContactCache_EnableGroupMemberListCache = plugin.getConfig().getBoolean("bot.contact-cache.enable-group-member-list-cache",false);
        Bot_ContactCache_SaveIntervalMillis = plugin.getConfig().getLong("bot.contact-cache.save-interval-millis",60000);

        DB_Type = plugin.getConfig().getString("database.type","sqlite").toLowerCase();
        DB_MySQL_Address = plugin.getConfig().getString("database.mysql.address","localhost");
        DB_MySQL_Username = plugin.getConfig().getString("database.mysql.username", "miraimc");
        DB_MySQL_Password = plugin.getConfig().getString("database.mysql.password", "miraimc");
        DB_MySQL_Database = plugin.getConfig().getString("database.mysql.database", "miraimc");
        DB_MySQL_Poll_ConnectionTimeout = plugin.getConfig().getInt("database.mysql.pool.connectionTimeout",30000);
        DB_MySQL_Poll_IdleTimeout = plugin.getConfig().getInt("database.mysql.pool.connectionTimeout",600000);
        DB_MySQL_Poll_MaxLifetime = plugin.getConfig().getInt("database.mysql.pool.maxLifetime",1800000);
        DB_MySQL_Poll_MaximumPoolSize = plugin.getConfig().getInt("database.mysql.pool.maximumPoolSize",15);
        DB_MySQL_Poll_KeepaliveTime = plugin.getConfig().getInt("database.mysql.pool.keepaliveTime",0);
        DB_MySQL_Poll_MinimumIdle = plugin.getConfig().getInt("database.mysql.pool.minimumIdle",0);
    }

    public static void reloadConfig() {
        Instance.loadConfig();
    }
}