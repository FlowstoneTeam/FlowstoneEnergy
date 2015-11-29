package main.flowstoneenergy.api.energy.direct;

import net.minecraft.util.EnumFacing;

public interface IDirectGenerator extends IDirectSocket {

    int extract(int flow, int force, EnumDirectType type, EnumFacing side, boolean real);
}
