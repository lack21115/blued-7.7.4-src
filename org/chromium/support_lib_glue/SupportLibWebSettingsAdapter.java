package org.chromium.support_lib_glue;

import org.chromium.android_webview.AwSettings;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;

final class SupportLibWebSettingsAdapter implements WebSettingsBoundaryInterface {
  private final AwSettings mAwSettings;
  
  public SupportLibWebSettingsAdapter(AwSettings paramAwSettings) {
    this.mAwSettings = paramAwSettings;
  }
  
  public final int getDisabledActionModeMenuItems() {
    return this.mAwSettings.getDisabledActionModeMenuItems();
  }
  
  public final boolean getOffscreenPreRaster() {
    return this.mAwSettings.getOffscreenPreRaster();
  }
  
  public final boolean getSafeBrowsingEnabled() {
    return this.mAwSettings.getSafeBrowsingEnabled();
  }
  
  public final void setDisabledActionModeMenuItems(int paramInt) {
    this.mAwSettings.setDisabledActionModeMenuItems(paramInt);
  }
  
  public final void setOffscreenPreRaster(boolean paramBoolean) {
    this.mAwSettings.setOffscreenPreRaster(paramBoolean);
  }
  
  public final void setSafeBrowsingEnabled(boolean paramBoolean) {
    this.mAwSettings.setSafeBrowsingEnabled(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_glue\SupportLibWebSettingsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */