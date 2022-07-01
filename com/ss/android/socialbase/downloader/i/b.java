package com.ss.android.socialbase.downloader.i;

class b {
  private final double a;
  
  private final int b;
  
  private double c;
  
  private int d;
  
  public b(double paramDouble) {
    int i;
    this.c = -1.0D;
    this.a = paramDouble;
    if (paramDouble == 0.0D) {
      i = Integer.MAX_VALUE;
    } else {
      i = (int)Math.ceil(1.0D / paramDouble);
    } 
    this.b = i;
  }
  
  public double a() {
    return this.c;
  }
  
  public void a(double paramDouble) {
    double d = 1.0D - this.a;
    int i = this.d;
    if (i > this.b) {
      this.c = Math.exp(d * Math.log(this.c) + this.a * Math.log(paramDouble));
    } else if (i > 0) {
      d = d * i / (i + 1.0D);
      this.c = Math.exp(d * Math.log(this.c) + (1.0D - d) * Math.log(paramDouble));
    } else {
      this.c = paramDouble;
    } 
    this.d++;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\ss\android\socialbase\downloader\i\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */