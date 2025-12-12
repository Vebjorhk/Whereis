package com.vebbern.whereis

import org.bukkit.plugin.java.JavaPlugin

class Whereis : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        logger.info("Whereis is enabled")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
