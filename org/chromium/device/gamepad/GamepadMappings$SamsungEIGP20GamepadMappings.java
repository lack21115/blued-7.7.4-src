package org.chromium.device.gamepad;

final class GamepadMappings$SamsungEIGP20GamepadMappings extends GamepadMappings {
  private GamepadMappings$SamsungEIGP20GamepadMappings() {}
  
  public final void mapToStandardGamepad(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4) {
    GamepadMappings.access$500(paramArrayOffloat2, paramArrayOffloat4);
    float f1 = paramArrayOffloat4[102];
    float f2 = paramArrayOffloat4[103];
    paramArrayOffloat2[6] = f1;
    paramArrayOffloat2[7] = f2;
    GamepadMappings.access$700(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$800(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$1000(paramArrayOffloat2, paramArrayOffloat3);
    GamepadMappings.access$1100(paramArrayOffloat1, paramArrayOffloat3);
    GamepadMappings.access$1400(paramArrayOffloat1, paramArrayOffloat3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadMappings$SamsungEIGP20GamepadMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */