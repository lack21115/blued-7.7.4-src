package org.chromium.device.gamepad;

final class GamepadMappings$UnknownGamepadMappings extends GamepadMappings {
  private int mLeftTriggerAxis = -1;
  
  private int mRightStickXAxis = -1;
  
  private int mRightStickYAxis = -1;
  
  private int mRightTriggerAxis = -1;
  
  private boolean mUseHatAxes;
  
  GamepadMappings$UnknownGamepadMappings(int[] paramArrayOfint) {
    int k = paramArrayOfint.length;
    int j = 0;
    int i = 0;
    while (j < k) {
      int m = paramArrayOfint[j];
      switch (m) {
        case 18:
        case 19:
        case 22:
          this.mRightTriggerAxis = m;
          break;
        case 17:
        case 23:
          this.mLeftTriggerAxis = m;
          break;
        case 16:
          i++;
          break;
        case 15:
          i++;
          break;
        case 13:
        case 14:
          this.mRightStickYAxis = m;
          break;
        case 11:
        case 12:
          this.mRightStickXAxis = m;
          break;
      } 
      j++;
    } 
    if (i == 2)
      this.mUseHatAxes = true; 
  }
  
  public final boolean isStandard() {
    return false;
  }
  
  public final void mapToStandardGamepad(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4) {
    GamepadMappings.access$500(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$600(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$700(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$800(paramArrayOffloat2, paramArrayOffloat4);
    GamepadMappings.access$1100(paramArrayOffloat1, paramArrayOffloat3);
    if (this.mLeftTriggerAxis != -1 && this.mRightTriggerAxis != -1) {
      float f1 = paramArrayOffloat3[this.mLeftTriggerAxis];
      float f2 = paramArrayOffloat3[this.mRightTriggerAxis];
      paramArrayOffloat2[6] = f1;
      paramArrayOffloat2[7] = f2;
    } else {
      float f1 = paramArrayOffloat4[104];
      float f2 = paramArrayOffloat4[105];
      paramArrayOffloat2[6] = f1;
      paramArrayOffloat2[7] = f2;
    } 
    if (this.mRightStickXAxis != -1 && this.mRightStickYAxis != -1) {
      float f1 = paramArrayOffloat3[this.mRightStickXAxis];
      float f2 = paramArrayOffloat3[this.mRightStickYAxis];
      paramArrayOffloat1[2] = f1;
      paramArrayOffloat1[3] = f2;
    } 
    if (this.mUseHatAxes) {
      GamepadMappings.access$1000(paramArrayOffloat2, paramArrayOffloat3);
      return;
    } 
    GamepadMappings.access$1500(paramArrayOffloat2, paramArrayOffloat4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadMappings$UnknownGamepadMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */