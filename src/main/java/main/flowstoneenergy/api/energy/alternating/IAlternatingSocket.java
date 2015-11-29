package main.flowstoneenergy.api.energy.alternating;

import net.minecraft.util.EnumFacing;

public interface IAlternatingSocket {

    public boolean canAttach(EnumAlternatingPhase phase, EnumFacing side);
}
