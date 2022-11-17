package me.aroze.uwucore.command

import me.aroze.uwucore.util.coloured
import me.aroze.uwucore.util.handleTarget
import me.aroze.uwucore.util.isRightless
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object FeedCommand : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender.isRightless("feed")) return true

        val player = handleTarget(sender, args) ?: return true

        if (player !== sender) {
            val mommy = if (sender is Player) sender.name else "console"
            sender.sendMessage("&#ffd4e3You've fed &#eb9bb7${player.name}&#ffd4e3, :flushed:".coloured())
            player.sendMessage("&#ffd4e3You've been fed by mommy &#eb9bb7${mommy}&#ffd4e3, how cute ;3".coloured())
        } else player.sendMessage("&#ffd4e3You've majestically fed yourself".coloured())

        player.foodLevel = 20

        return true

    }

}