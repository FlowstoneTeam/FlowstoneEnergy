package main.flowstoneenergy.api.energy.alternating;

import net.minecraft.util.EnumFacing;

public interface IAlternatingAppliance extends IAlternatingSocket {

    int insert(int flow, int force, EnumAlternatingPhase phase, EnumFacing side, boolean real);
}
