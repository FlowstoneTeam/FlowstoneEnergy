package main.flowstoneenergy.api.energy.direct;

import net.minecraft.util.EnumFacing;

public interface IDirectAppliance extends IDirectSocket {
    
    int insert(int flow, int force, EnumDirectType type, EnumFacing side, boolean real);
}
