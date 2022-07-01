package org.chromium.device.gamepad;

final class GamepadMappings$XboxOneS2016FirmwareMappings extends GamepadMappings {
  private boolean mLeftTriggerActivated = false;
  
  private boolean mRightTriggerActivated = false;
  
  private GamepadMappings$XboxOneS2016FirmwareMappings() {}
  
  public final void mapToStandardGamepad(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4) {
    paramArrayOffloat2[0] = paramArrayOffloat4[96];
    paramArrayOffloat2[1] = paramArrayOffloat4[97];
    paramArrayOffloat2[2] = paramArrayOffloat4[98];
    paramArrayOffloat2[3] = paramArrayOffloat4[99];
    paramArrayOffloat2[4] = paramArrayOffloat4[100];
    paramArrayOffloat2[5] = paramArrayOffloat4[101];
    paramArrayOffloat2[8] = paramArrayOffloat4[102];
    paramArrayOffloat2[9] = paramArrayOffloat4[103];
    paramArrayOffloat2[10] = paramArrayOffloat4[104];
    paramArrayOffloat2[11] = paramArrayOffloat4[105];
    if (paramArrayOffloat3[11] != 0.0F)
      this.mLeftTriggerActivated = true; 
    if (paramArrayOffloat3[14] != 0.0F)
      this.mRightTriggerActivated = true; 
    if (this.mLeftTriggerActivated) {
      paramArrayOffloat2[6] = (paramArrayOffloat3[11] + 1.0F) / 2.0F;
    } else {
      paramArrayOffloat2[6] = 0.0F;
    } 
    if (this.mRightTriggerActivated) {
      paramArrayOffloat2[7] = (paramArrayOffloat3[14] + 1.0F) / 2.0F;
    } else {
      paramArrayOffloat2[7] = 0.0F;
    } 
    GamepadMappings.access$1000(paramArrayOffloat2, paramArrayOffloat3);
    GamepadMappings.access$1100(paramArrayOffloat1, paramArrayOffloat3);
    GamepadMappings.access$1400(paramArrayOffloat1, paramArrayOffloat3);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadMappings$XboxOneS2016FirmwareMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */