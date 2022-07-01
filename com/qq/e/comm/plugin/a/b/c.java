package com.qq.e.comm.plugin.a.b;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import com.qq.e.comm.plugin.d.d;

abstract class c {
  public static c a(Context paramContext) {
    Context context = null;
    try {
      a a = new a(paramContext);
    } finally {
      paramContext = null;
    } 
    return (c)paramContext;
  }
  
  public abstract Notification a();
  
  public abstract c a(int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract c a(PendingIntent paramPendingIntent);
  
  public abstract c a(Bitmap paramBitmap);
  
  public abstract c a(String paramString);
  
  public abstract c a(boolean paramBoolean);
  
  public abstract c b(String paramString);
  
  static class a extends c {
    private Notification.Builder a;
    
    private a(Context param1Context) {
      this.a = new Notification.Builder(param1Context);
      d.a(param1Context, this.a);
      this.a.setSmallIcon(17301634);
    }
    
    public Notification a() {
      try {
        return this.a.build();
      } finally {
        Exception exception = null;
      } 
    }
    
    public c a(int param1Int1, int param1Int2, boolean param1Boolean) {
      this.a.setProgress(param1Int1, param1Int2, param1Boolean);
      return this;
    }
    
    public c a(PendingIntent param1PendingIntent) {
      this.a.setContentIntent(param1PendingIntent);
      return this;
    }
    
    public c a(Bitmap param1Bitmap) {
      this.a.setLargeIcon(param1Bitmap);
      return this;
    }
    
    public c a(String param1String) {
      this.a.setContentTitle(param1String);
      return this;
    }
    
    public c a(boolean param1Boolean) {
      this.a.setAutoCancel(param1Boolean);
      return this;
    }
    
    public c b(String param1String) {
      this.a.setContentText(param1String);
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\a\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */