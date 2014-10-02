package main.flowstoneenergy.core.utils;

import org.lwjgl.input.Keyboard;

public class KeyboardHelper {
    public static boolean isShiftDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT);
    }

    public static boolean isControlDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_RCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
    }

    public static boolean isVDown() {
        return Keyboard.isKeyDown(Keyboard.KEY_V);
    }
}