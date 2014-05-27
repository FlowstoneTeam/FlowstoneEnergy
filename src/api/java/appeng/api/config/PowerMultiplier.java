package appeng.api.config;

public enum PowerMultiplier
{
	ONE, CONFIG;

	private double multiplier = 1.0;

	public double multiply(double in)
	{
		return in * multiplier;
	}

	public double divide(double in)
	{
		return in / multiplier;
	}
}
