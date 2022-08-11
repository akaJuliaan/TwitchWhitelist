package de.jakkoble

import de.jakkoble.Whitelist.isListed
import net.kyori.adventure.text.Component
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class TwitchWhitelist : JavaPlugin(), Listener {
   companion object {
      lateinit var instance: TwitchWhitelist
   }
   private lateinit var twitchBot: TwitchBot
   override fun onEnable() {
      instance = this
      twitchBot = TwitchBot()
      twitchBot.connect()
   }
   override fun onDisable() {
      twitchBot.disconnect()
   }
   override fun onLoad() {
      server.consoleSender.sendMessage("")
      server.consoleSender.sendMessage("")
      server.consoleSender.sendMessage("${ChatColor.LIGHT_PURPLE}TwitchWhitelist")
      server.consoleSender.sendMessage("")
      server.consoleSender.sendMessage("${ChatColor.DARK_PURPLE}Version: ${ChatColor.GRAY}${description.version}")
      server.consoleSender.sendMessage("${ChatColor.DARK_PURPLE}Website: ${ChatColor.GRAY}${description.website}")
      server.consoleSender.sendMessage("${ChatColor.DARK_PURPLE}Author:  ${ChatColor.GRAY}${description.authors.first()}")
      server.consoleSender.sendMessage("")
      server.consoleSender.sendMessage("")
   }
   @EventHandler
   fun onPlayerJoin(event: PlayerJoinEvent) {
      if (!event.player.isListed()) event.player.kick(Component.text(Config().getData("notWhitelistedMessage")))
   }
}