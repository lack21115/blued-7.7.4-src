package com.amap.api.mapcore2d;

import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;

class ca implements al {
  private y a;
  
  private boolean b = true;
  
  private boolean c = false;
  
  private boolean d = true;
  
  private boolean e = true;
  
  private boolean f = true;
  
  private boolean g = false;
  
  private int h = 0;
  
  private int i = 0;
  
  private final Handler j = new Handler(this) {
      public void handleMessage(Message param1Message) {
        if (param1Message != null) {
          if (ca.a(this.a) == null)
            return; 
          try {
            int i = param1Message.what;
            if (i != 0) {
              if (i != 1) {
                if (i != 2) {
                  if (i != 3)
                    return; 
                  return;
                } 
                return;
              } 
              return;
            } 
            return;
          } finally {
            param1Message = null;
          } 
        } 
      }
    };
  
  private boolean k;
  
  ca(y paramy) {
    this.a = paramy;
  }
  
  public int getLogoPosition() throws RemoteException {
    return this.h;
  }
  
  public int getZoomPosition() throws RemoteException {
    return this.i;
  }
  
  public boolean isCompassEnabled() throws RemoteException {
    return this.f;
  }
  
  public boolean isMyLocationButtonEnabled() throws RemoteException {
    return this.c;
  }
  
  public boolean isScaleControlsEnabled() throws RemoteException {
    return this.g;
  }
  
  public boolean isScrollGesturesEnabled() throws RemoteException {
    return this.b;
  }
  
  public boolean isZoomControlsEnabled() throws RemoteException {
    return this.e;
  }
  
  public boolean isZoomGesturesEnabled() throws RemoteException {
    return this.d;
  }
  
  public boolean isZoomInByScreenCenter() {
    return this.k;
  }
  
  public void setAllGesturesEnabled(boolean paramBoolean) throws RemoteException {
    setZoomGesturesEnabled(paramBoolean);
    setScrollGesturesEnabled(paramBoolean);
  }
  
  public void setCompassEnabled(boolean paramBoolean) throws RemoteException {
    this.f = paramBoolean;
    this.j.obtainMessage(2).sendToTarget();
  }
  
  public void setLogoCenter(int paramInt1, int paramInt2) {
    y y1 = this.a;
    if (y1 != null)
      y1.a(paramInt1, paramInt2); 
  }
  
  public void setLogoPosition(int paramInt) throws RemoteException {
    this.h = paramInt;
    this.a.setLogoPosition(paramInt);
  }
  
  public void setMyLocationButtonEnabled(boolean paramBoolean) throws RemoteException {
    this.c = paramBoolean;
    this.j.obtainMessage(3).sendToTarget();
  }
  
  public void setScaleControlsEnabled(boolean paramBoolean) throws RemoteException {
    this.g = paramBoolean;
    this.j.obtainMessage(1).sendToTarget();
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean) throws RemoteException {
    this.b = paramBoolean;
  }
  
  public void setZoomControlsEnabled(boolean paramBoolean) throws RemoteException {
    this.e = paramBoolean;
    this.j.obtainMessage(0).sendToTarget();
  }
  
  public void setZoomGesturesEnabled(boolean paramBoolean) throws RemoteException {
    this.d = paramBoolean;
  }
  
  public void setZoomInByScreenCenter(boolean paramBoolean) {
    this.k = paramBoolean;
  }
  
  public void setZoomPosition(int paramInt) throws RemoteException {
    this.i = paramInt;
    this.a.setZoomPosition(paramInt);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */