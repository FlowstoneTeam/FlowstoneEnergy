package main.flowstoneenergy.api.energy;

import main.flowstoneenergy.api.energy.alternating.IAlternatingAppliance;
import main.flowstoneenergy.api.energy.direct.IDirectGenerator;

public interface IFlowRectifier extends IDirectGenerator, IAlternatingAppliance  {

}
