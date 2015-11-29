package main.flowstoneenergy.api.energy.direct;

import net.minecraft.util.EnumFacing;

public interface IDirectSocket {
    
    public boolean canAttach(EnumDirectType type, EnumFacing side);

}
