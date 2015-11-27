package main.flowstoneenergy.api.energy.direct;

import net.minecraft.util.EnumFacing;

public interface IDirectItemStorage {
    
    int extract(int flow, EnumDirectType type, EnumFacing side, boolean real);
    
    int insert(int flow, EnumDirectType type, EnumFacing side, boolean real);
    
    int getMaxCapacity();
    
    int getCapacity();
}
