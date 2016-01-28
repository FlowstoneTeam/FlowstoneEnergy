package main.flowstoneenergy.core.utils;

public class Vector3f {
    
    public float x;
    public float y;
    public float z;

    public Vector3f() {
      x = y = z = 0.0F;
    }
    
    public void add(float xIncrement, float yIncrement, float zIncrement){
        x += xIncrement;
        y += yIncrement;
        z += zIncrement;
    }
}
