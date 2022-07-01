package com.amap.api.mapcore2d;

import android.graphics.Point;
import android.os.RemoteException;
import com.amap.api.interfaces.MapCameraMessage;
import com.amap.api.maps2d.model.CameraPosition;

class a {
  private b a;
  
  private int b;
  
  public a(b paramb) {
    this.a = paramb;
  }
  
  protected void a(MapCameraMessage paramMapCameraMessage) throws RemoteException {
    try {
      if (this.a != null) {
        if (this.a.i() == null)
          return; 
        float f = this.a.getZoomLevel();
        if (paramMapCameraMessage.nowType == MapCameraMessage.Type.h) {
          if (this.a.b != null)
            this.a.b.d((int)paramMapCameraMessage.xPixel, (int)paramMapCameraMessage.yPixel); 
          this.a.postInvalidate();
        } else if (paramMapCameraMessage.nowType == MapCameraMessage.Type.b) {
          this.a.i().a(true);
        } else if (paramMapCameraMessage.nowType == MapCameraMessage.Type.e) {
          this.a.i().a(false);
        } else if (paramMapCameraMessage.nowType == MapCameraMessage.Type.f) {
          float f1 = paramMapCameraMessage.zoom;
          this.a.i().c(f1);
        } else {
          Point point;
          if (paramMapCameraMessage.nowType == MapCameraMessage.Type.g) {
            float f1 = paramMapCameraMessage.amount;
            f1 = this.a.a(f1 + f);
            point = paramMapCameraMessage.focus;
            if (point != null) {
              this.a.a(f1 - f, point, false, 0L);
            } else {
              this.a.i().c(f1);
            } 
          } else {
            CameraPosition cameraPosition;
            if (((MapCameraMessage)point).nowType == MapCameraMessage.Type.i) {
              cameraPosition = ((MapCameraMessage)point).cameraPosition;
              if (cameraPosition != null) {
                int i = (int)(cameraPosition.target.latitude * 1000000.0D);
                int j = (int)(cameraPosition.target.longitude * 1000000.0D);
                this.a.i().a(new w(i, j), cameraPosition.zoom);
              } 
            } else if (((MapCameraMessage)cameraPosition).nowType == MapCameraMessage.Type.c) {
              cameraPosition = ((MapCameraMessage)cameraPosition).cameraPosition;
              int i = (int)(cameraPosition.target.latitude * 1000000.0D);
              int j = (int)(cameraPosition.target.longitude * 1000000.0D);
              this.a.i().a(new w(i, j));
            } else if (((MapCameraMessage)cameraPosition).nowType == MapCameraMessage.Type.j || ((MapCameraMessage)cameraPosition).nowType == MapCameraMessage.Type.k) {
              this.a.a((MapCameraMessage)cameraPosition, false, -1L);
            } else {
              ((MapCameraMessage)cameraPosition).isChangeFinished = true;
            } 
          } 
        } 
        if (f != this.b && this.a.c().isScaleControlsEnabled())
          this.a.s(); 
        l.a().b();
        return;
      } 
      return;
    } catch (Exception exception) {
      cm.a(exception, "AMapCallback", "runCameraUpdate");
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */