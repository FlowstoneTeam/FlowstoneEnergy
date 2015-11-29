package main.flowstoneenergy.api.energy.alternating;

import net.minecraft.util.EnumFacing;

public interface IAlternatingGenerator extends IAlternatingSocket {

    int extract(int flow, int force, EnumAlternatingPhase phase, EnumFacing side, boolean real);
}
