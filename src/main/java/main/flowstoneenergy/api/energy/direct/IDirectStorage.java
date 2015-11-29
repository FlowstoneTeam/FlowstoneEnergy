package main.flowstoneenergy.api.energy.direct;

import net.minecraft.util.EnumFacing;

public interface IDirectStorage {

    int extract(int flow, int force, EnumDirectType type, EnumFacing side, boolean real);
    
    int insert(int flow, int force, EnumDirectType type, EnumFacing side, boolean real);
    
    int getMaxCapacity();
    
    int getCapacity();
}
