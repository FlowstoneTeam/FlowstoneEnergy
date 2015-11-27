package main.flowstoneenergy.api.energy.direct;

import net.minecraft.util.EnumFacing;

public interface IDirectAppliance {
    
    int insert(int flow, EnumDirectType type, EnumFacing side, boolean real);
}
