package io.github.maple8192.anytimecrafting

import io.github.maple8192.anytimecrafting.listeners.CraftingOpenEvent
import org.bukkit.plugin.java.JavaPlugin

class AnyTimeCrafting : JavaPlugin() {
    override fun onEnable() {
        registerEventListeners()
    }

    /**
     * イベントハンドラを登録します。
     */
    private fun registerEventListeners() {
        val pluginManager = server.pluginManager

        pluginManager.registerEvents(CraftingOpenEvent(), this)
    }
}