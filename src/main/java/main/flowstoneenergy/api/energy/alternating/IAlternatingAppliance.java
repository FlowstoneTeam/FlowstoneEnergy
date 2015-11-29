package main.flowstoneenergy.api.energy.alternating;

import net.minecraft.util.EnumFacing;

public interface IAlternatingAppliance extends IAlternatingSocket {

    int insert(int flow, EnumAlternatingPhase phase, EnumFacing side, boolean real);
}
