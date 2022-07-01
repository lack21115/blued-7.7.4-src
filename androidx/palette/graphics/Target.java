package androidx.palette.graphics;

public final class Target {
  public static final Target DARK_MUTED;
  
  public static final Target DARK_VIBRANT;
  
  public static final Target LIGHT_MUTED;
  
  public static final Target LIGHT_VIBRANT = new Target();
  
  public static final Target MUTED;
  
  public static final Target VIBRANT = new Target();
  
  final float[] a = new float[3];
  
  final float[] b = new float[3];
  
  final float[] c = new float[3];
  
  boolean d = true;
  
  static {
    b(VIBRANT);
    d(VIBRANT);
    DARK_VIBRANT = new Target();
    a(DARK_VIBRANT);
    d(DARK_VIBRANT);
    LIGHT_MUTED = new Target();
    c(LIGHT_MUTED);
    e(LIGHT_MUTED);
    MUTED = new Target();
    b(MUTED);
    e(MUTED);
    DARK_MUTED = new Target();
    a(DARK_MUTED);
    e(DARK_MUTED);
  }
  
  Target() {
    a(this.a);
    a(this.b);
    b();
  }
  
  Target(Target paramTarget) {
    float[] arrayOfFloat2 = paramTarget.a;
    float[] arrayOfFloat3 = this.a;
    System.arraycopy(arrayOfFloat2, 0, arrayOfFloat3, 0, arrayOfFloat3.length);
    arrayOfFloat2 = paramTarget.b;
    arrayOfFloat3 = this.b;
    System.arraycopy(arrayOfFloat2, 0, arrayOfFloat3, 0, arrayOfFloat3.length);
    float[] arrayOfFloat1 = paramTarget.c;
    arrayOfFloat2 = this.c;
    System.arraycopy(arrayOfFloat1, 0, arrayOfFloat2, 0, arrayOfFloat2.length);
  }
  
  private static void a(Target paramTarget) {
    float[] arrayOfFloat = paramTarget.b;
    arrayOfFloat[1] = 0.26F;
    arrayOfFloat[2] = 0.45F;
  }
  
  private static void a(float[] paramArrayOffloat) {
    paramArrayOffloat[0] = 0.0F;
    paramArrayOffloat[1] = 0.5F;
    paramArrayOffloat[2] = 1.0F;
  }
  
  private void b() {
    float[] arrayOfFloat = this.c;
    arrayOfFloat[0] = 0.24F;
    arrayOfFloat[1] = 0.52F;
    arrayOfFloat[2] = 0.24F;
  }
  
  private static void b(Target paramTarget) {
    float[] arrayOfFloat = paramTarget.b;
    arrayOfFloat[0] = 0.3F;
    arrayOfFloat[1] = 0.5F;
    arrayOfFloat[2] = 0.7F;
  }
  
  private static void c(Target paramTarget) {
    float[] arrayOfFloat = paramTarget.b;
    arrayOfFloat[0] = 0.55F;
    arrayOfFloat[1] = 0.74F;
  }
  
  private static void d(Target paramTarget) {
    float[] arrayOfFloat = paramTarget.a;
    arrayOfFloat[0] = 0.35F;
    arrayOfFloat[1] = 1.0F;
  }
  
  private static void e(Target paramTarget) {
    float[] arrayOfFloat = paramTarget.a;
    arrayOfFloat[1] = 0.3F;
    arrayOfFloat[2] = 0.4F;
  }
  
  void a() {
    int j = this.c.length;
    boolean bool = false;
    int i = 0;
    float f;
    for (f = 0.0F; i < j; f = f1) {
      float f2 = this.c[i];
      float f1 = f;
      if (f2 > 0.0F)
        f1 = f + f2; 
      i++;
    } 
    if (f != 0.0F) {
      j = this.c.length;
      for (i = bool; i < j; i++) {
        float[] arrayOfFloat = this.c;
        if (arrayOfFloat[i] > 0.0F)
          arrayOfFloat[i] = arrayOfFloat[i] / f; 
      } 
    } 
  }
  
  public float getLightnessWeight() {
    return this.c[1];
  }
  
  public float getMaximumLightness() {
    return this.b[2];
  }
  
  public float getMaximumSaturation() {
    return this.a[2];
  }
  
  public float getMinimumLightness() {
    return this.b[0];
  }
  
  public float getMinimumSaturation() {
    return this.a[0];
  }
  
  public float getPopulationWeight() {
    return this.c[2];
  }
  
  public float getSaturationWeight() {
    return this.c[0];
  }
  
  public float getTargetLightness() {
    return this.b[1];
  }
  
  public float getTargetSaturation() {
    return this.a[1];
  }
  
  public boolean isExclusive() {
    return this.d;
  }
  
  static {
    c(LIGHT_VIBRANT);
    d(LIGHT_VIBRANT);
  }
  
  public static final class Builder {
    private final Target a = new Target();
    
    public Builder() {}
    
    public Builder(Target param1Target) {}
    
    public Target build() {
      return this.a;
    }
    
    public Builder setExclusive(boolean param1Boolean) {
      this.a.d = param1Boolean;
      return this;
    }
    
    public Builder setLightnessWeight(float param1Float) {
      this.a.c[1] = param1Float;
      return this;
    }
    
    public Builder setMaximumLightness(float param1Float) {
      this.a.b[2] = param1Float;
      return this;
    }
    
    public Builder setMaximumSaturation(float param1Float) {
      this.a.a[2] = param1Float;
      return this;
    }
    
    public Builder setMinimumLightness(float param1Float) {
      this.a.b[0] = param1Float;
      return this;
    }
    
    public Builder setMinimumSaturation(float param1Float) {
      this.a.a[0] = param1Float;
      return this;
    }
    
    public Builder setPopulationWeight(float param1Float) {
      this.a.c[2] = param1Float;
      return this;
    }
    
    public Builder setSaturationWeight(float param1Float) {
      this.a.c[0] = param1Float;
      return this;
    }
    
    public Builder setTargetLightness(float param1Float) {
      this.a.b[1] = param1Float;
      return this;
    }
    
    public Builder setTargetSaturation(float param1Float) {
      this.a.a[1] = param1Float;
      return this;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\palette\graphics\Target.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */