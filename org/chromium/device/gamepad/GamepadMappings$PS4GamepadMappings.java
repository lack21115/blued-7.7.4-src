package org.chromium.device.gamepad;

final class GamepadMappings$PS4GamepadMappings extends GamepadMappings {
  public final void mapToStandardGamepad(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4) {
    float f1 = paramArrayOffloat4[96];
    float f2 = paramArrayOffloat4[97];
    float f3 = paramArrayOffloat4[98];
    float f4 = paramArrayOffloat4[99];
    paramArrayOffloat2[0] = f2;
    paramArrayOffloat2[1] = f3;
    paramArrayOffloat2[2] = f1;
    paramArrayOffloat2[3] = f4;
    f1 = paramArrayOffloat4[100];
    f2 = paramArrayOffloat4[101];
    paramArrayOffloat2[4] = f1;
    paramArrayOffloat2[5] = f2;
    f1 = paramArrayOffloat3[12];
    f2 = paramArrayOffloat3[13];
    paramArrayOffloat2[6] = 1.0F - (1.0F - f1) / 2.0F;
    paramArrayOffloat2[7] = 1.0F - (1.0F - f2) / 2.0F;
    f1 = paramArrayOffloat4[104];
    f2 = paramArrayOffloat4[105];
    paramArrayOffloat2[8] = f1;
    paramArrayOffloat2[9] = f2;
    f1 = paramArrayOffloat4[109];
    f2 = paramArrayOffloat4[108];
    paramArrayOffloat2[10] = f1;
    paramArrayOffloat2[11] = f2;
    paramArrayOffloat2[16] = paramArrayOffloat4[110];
    GamepadMappings.access$1000(paramArrayOffloat2, paramArrayOffloat3);
    GamepadMappings.access$1100(paramArrayOffloat1, paramArrayOffloat3);
    GamepadMappings.access$1200(paramArrayOffloat1, paramArrayOffloat3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadMappings$PS4GamepadMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */