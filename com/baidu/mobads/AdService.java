package com.baidu.mobads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.utils.XAdSDKFoundationFacade;

public class AdService {
  protected static String channelId = "";
  
  protected static int instanceCount = -1;
  
  private AdView a;
  
  public AdService(Context paramContext, ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, AdViewListener paramAdViewListener) {
    this(paramContext, paramViewGroup, paramLayoutParams, paramAdViewListener, AdSize.Banner, "");
  }
  
  public AdService(Context paramContext, ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams, AdViewListener paramAdViewListener, AdSize paramAdSize, String paramString) {
    if (paramContext != null && paramViewGroup != null && paramLayoutParams != null && paramAdViewListener != null && paramAdSize != null) {
      this.a = new AdView(paramContext, false, paramAdSize, paramString);
      this.a.setListener(paramAdViewListener);
      a(paramViewGroup, paramLayoutParams);
      instanceCount++;
      return;
    } 
    throw new IllegalArgumentException("One of arguments is null");
  }
  
  private void a(ViewGroup paramViewGroup, ViewGroup.LayoutParams paramLayoutParams) {
    try {
      if (this.a.getParent() != paramViewGroup) {
        if (this.a.getParent() != null)
          ((ViewGroup)this.a.getParent()).removeView((View)this.a); 
        paramViewGroup.addView((View)this.a, paramLayoutParams);
        return;
      } 
    } catch (Exception exception) {
      XAdSDKFoundationFacade.getInstance().getAdLogger().d(exception);
    } 
  }
  
  public static void setChannelId(String paramString) {
    channelId = paramString;
    XAdSDKFoundationFacade.getInstance().getCommonUtils().setChannelId(paramString);
  }
  
  public void destroy() {
    AdView adView = this.a;
    if (adView != null) {
      adView.destroy();
      this.a = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\AdService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */