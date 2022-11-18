package me.aroze.uwucore

import me.aroze.uwucore.command.*
import me.aroze.uwucore.listener.PlayerListener
import org.bukkit.plugin.java.JavaPlugin

class UwUCore : JavaPlugin() {

    companion object {
        fun getInstance() : UwUCore { return getPlugin(UwUCore::class.java) }
    }

    override fun onEnable() {
        getCommand("gamemode")?.setExecutor(GamemodeCommand)
        getCommand("heal")?.setExecutor(HealCommand)
        getCommand("kittycannon")?.setExecutor(KittyCannonCommand)
        getCommand("feed")?.setExecutor(FeedCommand)
        getCommand("smite")?.setExecutor(SmiteCommand)
        getCommand("ping")?.setExecutor(PingCommand)
        getCommand("flyspeed")?.setExecutor(FlySpeedCommand)

        server.pluginManager.registerEvents(PlayerListener, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}