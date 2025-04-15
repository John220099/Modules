package com.mucheng.mucute.client.game.module.misc

import com.mucheng.mucute.client.game.InterceptablePacket
import com.mucheng.mucute.client.game.Module
import com.mucheng.mucute.client.game.ModuleCategory
import org.cloudburstmc.protocol.bedrock.packet.PlayStatusPacket
import org.cloudburstmc.protocol.bedrock.packet.PlayStatusPacket.Status
/*
Very unfinished :D
*/
class ForceConnectModule : Module("forceconnect", ModuleCategory.Misc) {
    
    private val ForcePlayerSpawn by boolValue("force_player_spawn", false)

    override fun beforePacketBound(interceptablePacket: InterceptablePacket) { 
        if (!isEnabled) {
            return
        }
        val packet = interceptablePacket.packet
        
       if (packet is PlayStatusPacket) {
            packet.status = Status.LOGIN_SUCCESS
        }
       if (packet is PlayStatusPacket) {
       if (ForcePlayerSpawn) {  
           packet.status = Status.PLAYER_SPAWN
            }    
        }
    }
}
