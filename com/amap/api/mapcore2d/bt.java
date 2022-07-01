package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import com.amap.api.interfaces.ITileOverlay;
import com.amap.api.maps2d.model.TileOverlayOptions;

public class bt implements ak {
  private static int a;
  
  private bu b;
  
  private an c;
  
  private boolean d;
  
  private String e;
  
  private float f;
  
  public bt(TileOverlayOptions paramTileOverlayOptions, bu parambu, av paramav, az paramaz, Context paramContext) {
    this.b = parambu;
    this.c = new an(paramav);
    an an2 = this.c;
    an2.e = false;
    an2.g = false;
    an2.f = paramTileOverlayOptions.getDiskCacheEnabled();
    this.c.p = new bn<bs>();
    this.c.k = paramTileOverlayOptions.getTileProvider();
    this.c.n = new ba(paramaz.e.e, paramaz.e.f, false, 0L, this.c);
    String str = paramTileOverlayOptions.getDiskCacheDir();
    if (TextUtils.isEmpty(str))
      this.c.f = false; 
    an an3 = this.c;
    an3.m = str;
    an3.o = new u(parambu.getContext(), false, this.c);
    bv bv = new bv(paramaz, this.c);
    an an1 = this.c;
    an1.q = bv;
    an1.a(true);
    this.d = paramTileOverlayOptions.isVisible();
    this.e = getId();
    this.f = paramTileOverlayOptions.getZIndex();
  }
  
  private static String a(String paramString) {
    a++;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramString);
    stringBuilder.append(a);
    return stringBuilder.toString();
  }
  
  public void a() {
    this.c.q.c();
  }
  
  public void a(Canvas paramCanvas) {
    this.c.a(paramCanvas);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b() {
    this.c.q.d();
  }
  
  public void c() {
    this.c.q.b();
  }
  
  public void clearTileCache() {
    try {
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "TileOverlayDelegateImp", "remove");
    } 
  }
  
  public boolean equalsRemote(ITileOverlay paramITileOverlay) {
    return (equals(paramITileOverlay) || paramITileOverlay.getId().equals(getId()));
  }
  
  public String getId() {
    if (this.e == null)
      this.e = a("TileOverlay"); 
    return this.e;
  }
  
  public float getZIndex() {
    return this.f;
  }
  
  public int hashCodeRemote() {
    return hashCode();
  }
  
  public boolean isVisible() {
    return this.d;
  }
  
  public void remove() {
    try {
      this.b.b(this);
      return;
    } finally {
      Exception exception = null;
      cm.a(exception, "TileOverlayDelegateImp", "remove");
    } 
  }
  
  public void setVisible(boolean paramBoolean) {
    this.d = paramBoolean;
    this.c.a(paramBoolean);
  }
  
  public void setZIndex(float paramFloat) {
    this.f = paramFloat;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */