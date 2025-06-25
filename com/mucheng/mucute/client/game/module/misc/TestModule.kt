package com.mucheng.mucute.client.game.module.misc

import com.mucheng.mucute.client.game.InterceptablePacket
import com.mucheng.mucute.client.game.Module
import com.mucheng.mucute.client.game.ModuleCategory

class TestModule : Module("TestModule", ModuleCategory.Misc) {
    
    //modes
    enum class TestMode {
        Test1,
        Test2
    }
    
    //sets default mode
    private val mode by enumValue("Mode", TestMode.Test2, TestMode::class.java)
    
    private val TrueTest by boolValue("True Test", true)
    private val FalseTest by boolValue("False Test", false)

    private val SliderOne by intValue("Slider1", 1, 1..100)
    private val SliderTwo by floatValue("Slider2", 5.0f, 1.0f..10.0f)

    override fun beforePacketBound(interceptablePacket: InterceptablePacket) {
        if (!isEnabled) {
            return
        }
        val packet = interceptablePacket.packet
        
        //modes
        when (mode) {
            
            //mode "test1"
            TestMode.Test1 -> {
                //add setting or stuff here for "test1"
            }

            //mode "test2"
            TestMode.Test2 -> {
                //add setting or stuff here for "test2"
            }
        }
        if (TrueTest) {
        }
        if (FalseTest) {
        }
    }
}
