package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;

public final class MaterialArcMotion extends PathMotion {
  private static PointF a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return (paramFloat2 > paramFloat4) ? new PointF(paramFloat3, paramFloat2) : new PointF(paramFloat1, paramFloat4);
  }
  
  public Path getPath(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    Path path = new Path();
    path.moveTo(paramFloat1, paramFloat2);
    PointF pointF = a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    path.quadTo(pointF.x, pointF.y, paramFloat3, paramFloat4);
    return path;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\MaterialArcMotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */