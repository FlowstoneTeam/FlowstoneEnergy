package main.flowstoneenergy.api.energy;

import main.flowstoneenergy.api.energy.alternating.IAlternatingGenerator;
import main.flowstoneenergy.api.energy.direct.IDirectAppliance;

public interface IFlowInverter extends IDirectAppliance, IAlternatingGenerator{

}
