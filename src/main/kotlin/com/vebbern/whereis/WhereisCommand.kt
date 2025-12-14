package com.vebbern.whereis

import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.command.*

class WhereisCommand : CommandExecutor, TabCompleter {

    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {

        if (args.isEmpty()) {
            sender.sendMessage("§cUsage: /$label <player>")
            return true
        }

        val target = Bukkit.getPlayerExact(args[0])
        if (target == null) {
            sender.sendMessage("§cPlayer not found.")
            return true
        }

        val loc = target.location
        val world = loc.world ?: return true

        val worldName = when (world.environment) {
            World.Environment.NORMAL -> "Overworld"
            World.Environment.NETHER -> "Nether"
            World.Environment.THE_END -> "End"
            World.Environment.CUSTOM -> "Custom World"
        }
        sender.sendMessage("§a${target.name} is at ${loc.x.toInt()}, ${loc.y.toInt()}, ${loc.z.toInt()} in the $worldName")
        return true
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        alias: String,
        args: Array<out String>
    ): MutableList<String>? {

        if (args.size == 1) {
            val prefix = args[0].lowercase()
            return Bukkit.getOnlinePlayers()
                .map { it.name }
                .filter { it.lowercase().startsWith(prefix) }
                .toMutableList()
        }

        return mutableListOf()
    }
}