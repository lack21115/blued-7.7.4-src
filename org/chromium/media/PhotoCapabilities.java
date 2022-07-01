package org.chromium.media;

import org.chromium.base.annotations.CalledByNative;

class PhotoCapabilities {
  private int currentColorTemperature;
  
  private double currentExposureCompensation;
  
  private int currentHeight;
  
  private int currentIso;
  
  private int currentWidth;
  
  private double currentZoom;
  
  private int exposureMode;
  
  private int[] exposureModes;
  
  private int[] fillLightModes;
  
  private int focusMode;
  
  private int[] focusModes;
  
  private int maxColorTemperature;
  
  private double maxExposureCompensation;
  
  private int maxHeight;
  
  private int maxIso;
  
  private int maxWidth;
  
  private double maxZoom;
  
  private int minColorTemperature;
  
  private double minExposureCompensation;
  
  private int minHeight;
  
  private int minIso;
  
  private int minWidth;
  
  private double minZoom;
  
  private boolean redEyeReduction;
  
  private int stepColorTemperature;
  
  private double stepExposureCompensation;
  
  private int stepHeight;
  
  private int stepIso;
  
  private int stepWidth;
  
  private double stepZoom;
  
  private boolean supportsTorch;
  
  private boolean torch;
  
  private int whiteBalanceMode;
  
  private int[] whiteBalanceModes;
  
  PhotoCapabilities(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, int paramInt13, int[] paramArrayOfint1, int paramInt14, int[] paramArrayOfint2, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8, int paramInt15, int[] paramArrayOfint3, int[] paramArrayOfint4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt16, int paramInt17, int paramInt18, int paramInt19) {
    this.maxIso = paramInt1;
    this.minIso = paramInt2;
    this.currentIso = paramInt3;
    this.stepIso = paramInt4;
    this.maxHeight = paramInt5;
    this.minHeight = paramInt6;
    this.currentHeight = paramInt7;
    this.stepHeight = paramInt8;
    this.maxWidth = paramInt9;
    this.minWidth = paramInt10;
    this.currentWidth = paramInt11;
    this.stepWidth = paramInt12;
    this.maxZoom = paramDouble1;
    this.minZoom = paramDouble2;
    this.currentZoom = paramDouble3;
    this.stepZoom = paramDouble4;
    this.focusMode = paramInt13;
    this.focusModes = paramArrayOfint1;
    this.exposureMode = paramInt14;
    this.exposureModes = paramArrayOfint2;
    this.maxExposureCompensation = paramDouble5;
    this.minExposureCompensation = paramDouble6;
    this.currentExposureCompensation = paramDouble7;
    this.stepExposureCompensation = paramDouble8;
    this.whiteBalanceMode = paramInt15;
    this.whiteBalanceModes = paramArrayOfint3;
    this.fillLightModes = paramArrayOfint4;
    this.supportsTorch = paramBoolean1;
    this.torch = paramBoolean2;
    this.redEyeReduction = paramBoolean3;
    this.maxColorTemperature = paramInt16;
    this.minColorTemperature = paramInt17;
    this.currentColorTemperature = paramInt18;
    this.stepColorTemperature = paramInt19;
  }
  
  @CalledByNative
  public int getCurrentColorTemperature() {
    return this.currentColorTemperature;
  }
  
  @CalledByNative
  public double getCurrentExposureCompensation() {
    return this.currentExposureCompensation;
  }
  
  @CalledByNative
  public int getCurrentHeight() {
    return this.currentHeight;
  }
  
  @CalledByNative
  public int getCurrentIso() {
    return this.currentIso;
  }
  
  @CalledByNative
  public int getCurrentWidth() {
    return this.currentWidth;
  }
  
  @CalledByNative
  public double getCurrentZoom() {
    return this.currentZoom;
  }
  
  @CalledByNative
  public int getExposureMode() {
    return this.exposureMode;
  }
  
  @CalledByNative
  public int[] getExposureModes() {
    return (this.exposureModes != null) ? (int[])this.exposureModes.clone() : new int[0];
  }
  
  @CalledByNative
  public int[] getFillLightModes() {
    return (this.fillLightModes != null) ? (int[])this.fillLightModes.clone() : new int[0];
  }
  
  @CalledByNative
  public int getFocusMode() {
    return this.focusMode;
  }
  
  @CalledByNative
  public int[] getFocusModes() {
    return (this.focusModes != null) ? (int[])this.focusModes.clone() : new int[0];
  }
  
  @CalledByNative
  public int getMaxColorTemperature() {
    return this.maxColorTemperature;
  }
  
  @CalledByNative
  public double getMaxExposureCompensation() {
    return this.maxExposureCompensation;
  }
  
  @CalledByNative
  public int getMaxHeight() {
    return this.maxHeight;
  }
  
  @CalledByNative
  public int getMaxIso() {
    return this.maxIso;
  }
  
  @CalledByNative
  public int getMaxWidth() {
    return this.maxWidth;
  }
  
  @CalledByNative
  public double getMaxZoom() {
    return this.maxZoom;
  }
  
  @CalledByNative
  public int getMinColorTemperature() {
    return this.minColorTemperature;
  }
  
  @CalledByNative
  public double getMinExposureCompensation() {
    return this.minExposureCompensation;
  }
  
  @CalledByNative
  public int getMinHeight() {
    return this.minHeight;
  }
  
  @CalledByNative
  public int getMinIso() {
    return this.minIso;
  }
  
  @CalledByNative
  public int getMinWidth() {
    return this.minWidth;
  }
  
  @CalledByNative
  public double getMinZoom() {
    return this.minZoom;
  }
  
  @CalledByNative
  public boolean getRedEyeReduction() {
    return this.redEyeReduction;
  }
  
  @CalledByNative
  public int getStepColorTemperature() {
    return this.stepColorTemperature;
  }
  
  @CalledByNative
  public double getStepExposureCompensation() {
    return this.stepExposureCompensation;
  }
  
  @CalledByNative
  public int getStepHeight() {
    return this.stepHeight;
  }
  
  @CalledByNative
  public int getStepIso() {
    return this.stepIso;
  }
  
  @CalledByNative
  public int getStepWidth() {
    return this.stepWidth;
  }
  
  @CalledByNative
  public double getStepZoom() {
    return this.stepZoom;
  }
  
  @CalledByNative
  public boolean getSupportsTorch() {
    return this.supportsTorch;
  }
  
  @CalledByNative
  public boolean getTorch() {
    return this.torch;
  }
  
  @CalledByNative
  public int getWhiteBalanceMode() {
    return this.whiteBalanceMode;
  }
  
  @CalledByNative
  public int[] getWhiteBalanceModes() {
    return (this.whiteBalanceModes != null) ? (int[])this.whiteBalanceModes.clone() : new int[0];
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\PhotoCapabilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */