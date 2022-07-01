package org.chromium.device.gamepad;

final class GamepadMappings$PS3SixAxisGamepadMappings extends GamepadMappings {
  private GamepadMappings$PS3SixAxisGamepadMappings() {}
  
  public final void mapToStandardGamepad(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4) {
    float f1 = paramArrayOffloat4[96];
    float f2 = paramArrayOffloat4[97];
    float f3 = paramArrayOffloat4[99];
    float f4 = paramArrayOffloat4[100];
    paramArrayOffloat2[0] = f3;
    paramArrayOffloat2[1] = f4;
    paramArrayOffloat2[2] = f1;
    paramArrayOffloat2[3] = f2;
    GamepadMappings.access$600(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$700(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$1500(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$800(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$1300(paramArrayOffloat2, paramArrayOffloat3);
    GamepadMappings.access$1100(paramArrayOffloat1, paramArrayOffloat3);
    GamepadMappings.access$1200(paramArrayOffloat1, paramArrayOffloat3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadMappings$PS3SixAxisGamepadMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */