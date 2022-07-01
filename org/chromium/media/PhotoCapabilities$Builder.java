package org.chromium.media;

public final class PhotoCapabilities$Builder {
  public int currentColorTemperature;
  
  public double currentExposureCompensation;
  
  public int currentHeight;
  
  public int currentIso;
  
  public int currentWidth;
  
  public double currentZoom;
  
  public int exposureMode;
  
  private int[] exposureModes;
  
  private int[] fillLightModes;
  
  public int focusMode;
  
  private int[] focusModes;
  
  public int maxColorTemperature;
  
  public double maxExposureCompensation;
  
  public int maxHeight;
  
  public int maxIso;
  
  public int maxWidth;
  
  public double maxZoom;
  
  public int minColorTemperature;
  
  public double minExposureCompensation;
  
  public int minHeight;
  
  public int minIso;
  
  public int minWidth;
  
  public double minZoom;
  
  public boolean redEyeReduction;
  
  public int stepColorTemperature;
  
  public double stepExposureCompensation;
  
  public int stepHeight;
  
  public int stepIso;
  
  public int stepWidth;
  
  public double stepZoom;
  
  public boolean supportsTorch;
  
  public boolean torch;
  
  public int whiteBalanceMode;
  
  private int[] whiteBalanceModes;
  
  public final PhotoCapabilities build() {
    return new PhotoCapabilities(this.maxIso, this.minIso, this.currentIso, this.stepIso, this.maxHeight, this.minHeight, this.currentHeight, this.stepHeight, this.maxWidth, this.minWidth, this.currentWidth, this.stepWidth, this.maxZoom, this.minZoom, this.currentZoom, this.stepZoom, this.focusMode, this.focusModes, this.exposureMode, this.exposureModes, this.maxExposureCompensation, this.minExposureCompensation, this.currentExposureCompensation, this.stepExposureCompensation, this.whiteBalanceMode, this.whiteBalanceModes, this.fillLightModes, this.supportsTorch, this.torch, this.redEyeReduction, this.maxColorTemperature, this.minColorTemperature, this.currentColorTemperature, this.stepColorTemperature);
  }
  
  public final PhotoCapabilities$Builder setExposureModes(int[] paramArrayOfint) {
    this.exposureModes = (int[])paramArrayOfint.clone();
    return this;
  }
  
  public final PhotoCapabilities$Builder setFillLightModes(int[] paramArrayOfint) {
    this.fillLightModes = (int[])paramArrayOfint.clone();
    return this;
  }
  
  public final PhotoCapabilities$Builder setFocusModes(int[] paramArrayOfint) {
    this.focusModes = (int[])paramArrayOfint.clone();
    return this;
  }
  
  public final PhotoCapabilities$Builder setWhiteBalanceModes(int[] paramArrayOfint) {
    this.whiteBalanceModes = (int[])paramArrayOfint.clone();
    return this;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\PhotoCapabilities$Builder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */