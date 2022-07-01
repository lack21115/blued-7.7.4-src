package com.airbnb.lottie;

import androidx.core.os.TraceCompat;

public class L {
  public static boolean a = false;
  
  private static boolean b = false;
  
  private static String[] c;
  
  private static long[] d;
  
  private static int e;
  
  private static int f;
  
  public static void a(String paramString) {
    if (!b)
      return; 
    int i = e;
    if (i == 20) {
      f++;
      return;
    } 
    c[i] = paramString;
    d[i] = System.nanoTime();
    TraceCompat.beginSection(paramString);
    e++;
  }
  
  public static float b(String paramString) {
    int i = f;
    if (i > 0) {
      f = i - 1;
      return 0.0F;
    } 
    if (!b)
      return 0.0F; 
    i = --e;
    if (i != -1) {
      if (paramString.equals(c[i])) {
        TraceCompat.endSection();
        return (float)(System.nanoTime() - d[e]) / 1000000.0F;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Unbalanced trace call ");
      stringBuilder.append(paramString);
      stringBuilder.append(". Expected ");
      stringBuilder.append(c[e]);
      stringBuilder.append(".");
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("Can't end trace section. There are none.");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\airbnb\lottie\L.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */