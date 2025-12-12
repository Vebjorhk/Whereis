package com.vebbern.whereis

import org.bukkit.plugin.java.JavaPlugin

class Whereis : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        val locateCmd = WhereisCommand() // create ONE instance

        val cmd = getCommand("whereis")!!
        cmd.setExecutor(locateCmd)
        cmd.tabCompleter = locateCmd

        logger.info("Whereis is enabled")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
