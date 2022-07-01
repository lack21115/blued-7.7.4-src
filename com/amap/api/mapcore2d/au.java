package com.amap.api.mapcore2d;

import android.content.Context;
import android.graphics.Point;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps2d.model.LatLng;

class au extends ViewGroup {
  private y a;
  
  public au(Context paramContext, y paramy) {
    super(paramContext);
    this.a = paramy;
    setWillNotDraw(false);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
    int j = paramInt5 & 0x7;
    int i = paramInt5 & 0x70;
    if (j == 5) {
      paramInt5 = paramInt3 - paramInt1;
    } else {
      paramInt5 = paramInt3;
      if (j == 1)
        paramInt5 = paramInt3 - paramInt1 / 2; 
    } 
    if (i == 80) {
      paramInt3 = paramInt4 - paramInt2;
    } else {
      paramInt3 = paramInt4;
      if (i == 16)
        paramInt3 = paramInt4 - paramInt2 / 2; 
    } 
    paramView.layout(paramInt5, paramInt3, paramInt1 + paramInt5, paramInt2 + paramInt3);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfint) {
    if (paramView instanceof android.widget.ListView) {
      View view = (View)paramView.getParent();
      if (view != null) {
        paramArrayOfint[0] = view.getWidth();
        paramArrayOfint[1] = view.getHeight();
      } 
    } 
    if (paramInt1 <= 0 || paramInt2 <= 0)
      paramView.measure(0, 0); 
    if (paramInt1 == -2) {
      paramArrayOfint[0] = paramView.getMeasuredWidth();
    } else if (paramInt1 == -1) {
      paramArrayOfint[0] = getMeasuredWidth();
    } else {
      paramArrayOfint[0] = paramInt1;
    } 
    if (paramInt2 == -2) {
      paramArrayOfint[1] = paramView.getMeasuredHeight();
      return;
    } 
    if (paramInt2 == -1) {
      paramArrayOfint[1] = getMeasuredHeight();
      return;
    } 
    paramArrayOfint[1] = paramInt2;
  }
  
  private void a(View paramView, a parama) {
    int[] arrayOfInt = new int[2];
    a(paramView, parama.width, parama.height, arrayOfInt);
    a(paramView, arrayOfInt[0], arrayOfInt[1], parama.c, parama.d, parama.e);
  }
  
  private void a(ce paramce, int[] paramArrayOfint, int paramInt) {
    int i = paramce.b();
    if (i == 1) {
      a((View)paramce, paramArrayOfint[0], paramArrayOfint[1], getWidth() - paramArrayOfint[0], (getHeight() + paramArrayOfint[1]) / 2, paramInt);
      return;
    } 
    if (i == 0)
      a((View)paramce, paramArrayOfint[0], paramArrayOfint[1], getWidth() - paramArrayOfint[0], getHeight(), paramInt); 
  }
  
  private void b(View paramView, a parama) {
    int[] arrayOfInt = new int[2];
    a(paramView, parama.width, parama.height, arrayOfInt);
    if (paramView instanceof ce) {
      a((ce)paramView, arrayOfInt, parama.e);
      return;
    } 
    if (paramView instanceof ap) {
      a(paramView, arrayOfInt[0], arrayOfInt[1], getWidth() - arrayOfInt[0], arrayOfInt[1], parama.e);
      return;
    } 
    if (paramView instanceof p) {
      a(paramView, arrayOfInt[0], arrayOfInt[1], 0, 0, parama.e);
      return;
    } 
    if (parama.b != null) {
      w w = new w((int)(parama.b.latitude * 1000000.0D), (int)(parama.b.longitude * 1000000.0D));
      Point point = null;
      try {
        Point point1 = this.a.d().a(w, (Point)null);
        point = point1;
      } catch (RemoteException remoteException) {
        cm.a((Throwable)remoteException, "MapOverlayViewGroup", "layoutMap");
      } 
      if (point == null)
        return; 
      point.x += parama.c;
      point.y += parama.d;
      a(paramView, arrayOfInt[0], arrayOfInt[1], point.x, point.y, parama.e);
    } 
  }
  
  public void a() {
    onLayout(false, 0, 0, 0, 0);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      paramInt2 = getChildCount();
    } finally {
      Exception exception = null;
    } 
  }
  
  public static class a extends ViewGroup.LayoutParams {
    public int a = 1;
    
    public LatLng b = null;
    
    public int c = 0;
    
    public int d = 0;
    
    public int e = 51;
    
    public a(int param1Int1, int param1Int2, LatLng param1LatLng, int param1Int3, int param1Int4, int param1Int5) {
      super(param1Int1, param1Int2);
      this.a = 0;
      this.b = param1LatLng;
      this.c = param1Int3;
      this.d = param1Int4;
      this.e = param1Int5;
    }
    
    public a(ViewGroup.LayoutParams param1LayoutParams) {
      super(param1LayoutParams);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\amap\api\mapcore2d\au.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */