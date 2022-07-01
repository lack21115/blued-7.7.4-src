package com.amap.api.interfaces;

import android.os.RemoteException;

public interface IOverlay {
  void destroy();
  
  boolean equalsRemote(IOverlay paramIOverlay) throws RemoteException;
  
  String getId() throws RemoteException;
  
  float getZIndex() throws RemoteException;
  
  int hashCodeRemote() throws RemoteException;
  
  boolean isVisible() throws RemoteException;
  
  void remove() throws RemoteException;
  
  void setVisible(boolean paramBoolean) throws RemoteException;
  
  void setZIndex(float paramFloat) throws RemoteException;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\interfaces\IOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */