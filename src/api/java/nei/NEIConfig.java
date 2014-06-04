package api.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import main.flowstoneenergy.ModInfo;

public class NEIConfig implements IConfigureNEI{
    @Override
    public void loadConfig() {
        API.registerRecipeHandler(new MachineWorkbenchHandler());
        API.registerUsageHandler(new MachineWorkbenchHandler());
    }

    @Override
    public String getName() {
        return ModInfo.NAME;
    }

    @Override
    public String getVersion() {
        return ModInfo.VERSION;
    }
}