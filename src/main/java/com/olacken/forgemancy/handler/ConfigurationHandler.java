package com.olacken.forgemancy.handler;


import com.olacken.forgemancy.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler {
    public static Configuration configuration;

    public static boolean configValue = false;

    public static void initConfigs(File configFile) {
        //Create the configuration object from the configuration file
        if (configuration == null) {
            configuration = new Configuration(configFile);
        }
    }


    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfiguration();
        }
    }

    public void loadConfiguration() {

        configValue = configuration.get(Configuration.CATEGORY_GENERAL, "configValue", true, "This is an example of basic config").getBoolean(true);

        if (configuration.hasChanged()) {
            configuration.save();
        }

    }

}
