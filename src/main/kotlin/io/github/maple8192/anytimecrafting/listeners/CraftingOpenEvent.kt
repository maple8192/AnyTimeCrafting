package io.github.maple8192.anytimecrafting.listeners

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot

class CraftingOpenEvent : Listener {
    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        val player = event.player
        val action = event.action
        val item = event.item

        // 右クリックだったら
        if (action.isRightClick) {
            // 多重検知防止
            if (event.hand != EquipmentSlot.HAND) return

            // 作業台を持っていたら
            if (item != null && item.type == Material.CRAFTING_TABLE) {
                // スニーク中だったらスルー
                if (player.isSneaking) return

                // 作業台が設置されるのを阻止
                event.isCancelled = true

                // 作業台を開く
                player.openWorkbench(null, true)
            }
        }
    }
}