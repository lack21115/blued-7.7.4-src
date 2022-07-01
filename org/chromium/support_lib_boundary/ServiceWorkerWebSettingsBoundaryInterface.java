package org.chromium.support_lib_boundary;

public interface ServiceWorkerWebSettingsBoundaryInterface {
  boolean getAllowContentAccess();
  
  boolean getAllowFileAccess();
  
  boolean getBlockNetworkLoads();
  
  int getCacheMode();
  
  void setAllowContentAccess(boolean paramBoolean);
  
  void setAllowFileAccess(boolean paramBoolean);
  
  void setBlockNetworkLoads(boolean paramBoolean);
  
  void setCacheMode(int paramInt);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\support_lib_boundary\ServiceWorkerWebSettingsBoundaryInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */