package com.gamesense.client.module.modules.exploits;

import com.gamesense.api.setting.values.DoubleSetting;
import com.gamesense.api.setting.values.IntegerSetting;
import com.gamesense.client.module.Category;
import com.gamesense.client.module.Module;

/*
* @author hausemasterissue
* @since 1/11/2021
*/

@Module.Declaration(name = "TickShift", category = Category.Exploits)
public class TickShift extends Module {
	
    IntegerSetting disableTicks = registerInteger("DisableTicks", 10, 1, 100);
    DoubleSetting multiplier = registerDouble("Multiplier", 3.0, 1.0, 10.0);
	
    private int ticksPassed = 0;
	
    public void onEnable() {
	   mc.timer.tickLength = ((float)(50.0 / multiplier.getValue()));
    }
	
    public void onUpdate() {
	    ticksPassed++;
	   
	    if(ticksPassed >= disableTicks.getValue()) {
		    ticksPassed = 0;
		    disable();	
	    }
    }
	
    public void onDisable() {
	    mc.timer.tickLength = 50f;    
    }
  


}
