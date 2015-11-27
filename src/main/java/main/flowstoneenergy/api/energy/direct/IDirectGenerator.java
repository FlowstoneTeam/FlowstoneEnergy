package main.flowstoneenergy.api.energy.direct;

import net.minecraft.util.EnumFacing;

public interface IDirectGenerator {

    int extract(int flow, EnumDirectType type, EnumFacing side, boolean real);
}
