package org.chromium.device.gamepad;

abstract class GamepadMappings {
  private static float negativeAxisValueAsButton(float paramFloat) {
    return (paramFloat < -0.5F) ? 1.0F : 0.0F;
  }
  
  private static float positiveAxisValueAsButton(float paramFloat) {
    return (paramFloat > 0.5F) ? 1.0F : 0.0F;
  }
  
  public boolean isStandard() {
    return true;
  }
  
  public abstract void mapToStandardGamepad(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float[] paramArrayOffloat3, float[] paramArrayOffloat4);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\gamepad\GamepadMappings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */