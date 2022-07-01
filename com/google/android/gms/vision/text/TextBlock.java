package com.google.android.gms.vision.text;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.zzdlf;
import com.google.android.gms.internal.zzdll;

public final class TextBlock implements Text {
  private Point[] cornerPoints;
  
  private zzdll[] zzlhz;
  
  private Rect zzlic;
  
  TextBlock(SparseArray paramSparseArray) {
    this.zzlhz = new zzdll[paramSparseArray.size()];
    for (int i = 0; i < this.zzlhz.length; i++)
      this.zzlhz[i] = (zzdll)paramSparseArray.valueAt(i); 
  }
  
  private static Point[] zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, zzdlf paramzzdlf) {
    int i = paramzzdlf.left;
    int j = paramzzdlf.top;
    double d1 = Math.sin(Math.toRadians(paramzzdlf.zzlif));
    double d2 = Math.cos(Math.toRadians(paramzzdlf.zzlif));
    Point[] arrayOfPoint = new Point[4];
    Point point = new Point(paramInt1, paramInt2);
    boolean bool = false;
    arrayOfPoint[0] = point;
    arrayOfPoint[1] = new Point(paramInt3, paramInt2);
    arrayOfPoint[2] = new Point(paramInt3, paramInt4);
    arrayOfPoint[3] = new Point(paramInt1, paramInt4);
    for (paramInt1 = bool; paramInt1 < 4; paramInt1++) {
      paramInt2 = (int)((arrayOfPoint[paramInt1]).x * d2 - (arrayOfPoint[paramInt1]).y * d1);
      paramInt3 = (int)((arrayOfPoint[paramInt1]).x * d1 + (arrayOfPoint[paramInt1]).y * d2);
      (arrayOfPoint[paramInt1]).x = paramInt2;
      (arrayOfPoint[paramInt1]).y = paramInt3;
      arrayOfPoint[paramInt1].offset(i, j);
    } 
    return arrayOfPoint;
  }
  
  public final Rect getBoundingBox() {
    if (this.zzlic == null) {
      Point[] arrayOfPoint = super.getCornerPoints();
      int i1 = arrayOfPoint.length;
      int k = 0;
      int m = Integer.MIN_VALUE;
      int n = Integer.MAX_VALUE;
      int j = Integer.MAX_VALUE;
      int i = Integer.MIN_VALUE;
      while (k < i1) {
        Point point = arrayOfPoint[k];
        n = Math.min(n, point.x);
        m = Math.max(m, point.x);
        j = Math.min(j, point.y);
        i = Math.max(i, point.y);
        k++;
      } 
      this.zzlic = new Rect(n, j, m, i);
    } 
    return this.zzlic;
  }
  
  public final Point[] getCornerPoints() {
    if (this.cornerPoints == null) {
      Point[] arrayOfPoint;
      if (this.zzlhz.length == 0) {
        arrayOfPoint = new Point[0];
      } else {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = Integer.MAX_VALUE;
        int m = Integer.MIN_VALUE;
        int n = Integer.MIN_VALUE;
        while (j < this.zzlhz.length) {
          zzdlf zzdlf1 = (this.zzlhz[j]).zzlih;
          zzdlf zzdlf2 = (this.zzlhz[0]).zzlih;
          int i1 = -zzdlf2.left;
          int i2 = -zzdlf2.top;
          double d1 = Math.sin(Math.toRadians(zzdlf2.zzlif));
          double d2 = Math.cos(Math.toRadians(zzdlf2.zzlif));
          Point[] arrayOfPoint1 = new Point[4];
          arrayOfPoint1[0] = new Point(zzdlf1.left, zzdlf1.top);
          arrayOfPoint1[0].offset(i1, i2);
          i1 = (int)((arrayOfPoint1[0]).x * d2 + (arrayOfPoint1[0]).y * d1);
          i2 = (int)(-(arrayOfPoint1[0]).x * d1 + (arrayOfPoint1[0]).y * d2);
          (arrayOfPoint1[0]).x = i1;
          (arrayOfPoint1[0]).y = i2;
          arrayOfPoint1[1] = new Point(zzdlf1.width + i1, i2);
          arrayOfPoint1[2] = new Point(zzdlf1.width + i1, zzdlf1.height + i2);
          arrayOfPoint1[3] = new Point(i1, i2 + zzdlf1.height);
          for (i1 = 0; i1 < 4; i1++) {
            Point point = arrayOfPoint1[i1];
            i = Math.min(i, point.x);
            m = Math.max(m, point.x);
            k = Math.min(k, point.y);
            n = Math.max(n, point.y);
          } 
          j++;
        } 
        arrayOfPoint = zza(i, k, m, n, (this.zzlhz[0]).zzlih);
      } 
      this.cornerPoints = arrayOfPoint;
    } 
    return this.cornerPoints;
  }
  
  public final String getValue() {
    if (this.zzlhz.length == 0)
      return ""; 
    StringBuilder stringBuilder = new StringBuilder((this.zzlhz[0]).zzlik);
    for (int i = 1; i < this.zzlhz.length; i++) {
      stringBuilder.append("\n");
      stringBuilder.append((this.zzlhz[i]).zzlik);
    } 
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\vision\text\TextBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */