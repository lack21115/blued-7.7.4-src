package com.blued.android.module.external_sense_library.test.gles;

import java.nio.FloatBuffer;

public class Drawable2d {
  private static final float[] a = new float[] { 0.0F, 0.57735026F, -0.5F, -0.28867513F, 0.5F, -0.28867513F };
  
  private static final float[] b = new float[] { 0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  
  private static final FloatBuffer c = GlUtil.a(a);
  
  private static final FloatBuffer d = GlUtil.a(b);
  
  private static final float[] e = new float[] { -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.5F };
  
  private static final float[] f = new float[] { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  
  private static final FloatBuffer g = GlUtil.a(e);
  
  private static final FloatBuffer h = GlUtil.a(f);
  
  private static final float[] i = new float[] { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  
  private static final float[] j = new float[] { 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F };
  
  private static final FloatBuffer k = GlUtil.a(i);
  
  private static final FloatBuffer l = GlUtil.a(j);
  
  private Prefab m;
  
  public String toString() {
    if (this.m != null) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[Drawable2d: ");
      stringBuilder.append(this.m);
      stringBuilder.append("]");
      return stringBuilder.toString();
    } 
    return "[Drawable2d: ...]";
  }
  
  public enum Prefab {
    a, b, c;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\gles\Drawable2d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */