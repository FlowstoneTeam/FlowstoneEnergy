package main.flowstoneenergy.core.interfaces;

public interface IPowerable {

    public boolean canAcceptPower();

    public boolean canConnectToCable(); //some things will still require power but be unable to connect to cables
}
