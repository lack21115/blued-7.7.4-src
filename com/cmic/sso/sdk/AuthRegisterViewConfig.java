package com.cmic.sso.sdk;

import android.view.View;
import com.cmic.sso.sdk.utils.rglistener.CustomInterface;

public class AuthRegisterViewConfig {
  private CustomInterface customInterface;
  
  private int rootViewId;
  
  private View view;
  
  private AuthRegisterViewConfig(Builder paramBuilder) {
    this.customInterface = paramBuilder.customInterface;
    this.view = paramBuilder.view;
    this.rootViewId = paramBuilder.rootViewId;
  }
  
  public CustomInterface getCustomInterface() {
    return this.customInterface;
  }
  
  public int getRootViewId() {
    return this.rootViewId;
  }
  
  public View getView() {
    return this.view;
  }
  
  public static class Builder {
    private CustomInterface customInterface;
    
    private int rootViewId;
    
    private View view;
    
    public AuthRegisterViewConfig build() {
      return new AuthRegisterViewConfig(this);
    }
    
    public Builder setCustomInterface(CustomInterface param1CustomInterface) {
      this.customInterface = param1CustomInterface;
      return this;
    }
    
    public Builder setRootViewId(int param1Int) {
      this.rootViewId = param1Int;
      return this;
    }
    
    public Builder setView(View param1View) {
      this.view = param1View;
      return this;
    }
  }
  
  public static class RootViewId {
    public static final int ROOT_VIEW_ID_BODY = 0;
    
    public static final int ROOT_VIEW_ID_TITLE_BAR = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\cmic\sso\sdk\AuthRegisterViewConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */