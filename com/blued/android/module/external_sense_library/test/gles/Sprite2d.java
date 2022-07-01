package com.blued.android.module.external_sense_library.test.gles;

public class Sprite2d {
  private Drawable2d a;
  
  private float[] b;
  
  private float c;
  
  private float d;
  
  private float e;
  
  private float f;
  
  private float g;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("[Sprite2d pos=");
    stringBuilder.append(this.f);
    stringBuilder.append(",");
    stringBuilder.append(this.g);
    stringBuilder.append(" scale=");
    stringBuilder.append(this.d);
    stringBuilder.append(",");
    stringBuilder.append(this.e);
    stringBuilder.append(" angle=");
    stringBuilder.append(this.c);
    stringBuilder.append(" color={");
    stringBuilder.append(this.b[0]);
    stringBuilder.append(",");
    stringBuilder.append(this.b[1]);
    stringBuilder.append(",");
    stringBuilder.append(this.b[2]);
    stringBuilder.append("} drawable=");
    stringBuilder.append(this.a);
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\external_sense_library\test\gles\Sprite2d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */