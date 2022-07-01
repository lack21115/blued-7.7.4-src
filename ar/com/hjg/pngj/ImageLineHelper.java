package ar.com.hjg.pngj;

public class ImageLineHelper {
  static int[] a;
  
  static int[] b;
  
  static int[] c;
  
  static int[][] d;
  
  static {
    a();
  }
  
  private static void a() {
    a = new int[2];
    int i;
    for (i = 0; i < 2; i++)
      a[i] = i * 255; 
    b = new int[4];
    for (i = 0; i < 4; i++)
      b[i] = i * 255 / 3; 
    c = new int[16];
    for (i = 0; i < 16; i++)
      c[i] = i * 255 / 15; 
    d = new int[][] { null, a, b, null, c };
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ImageLineHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */