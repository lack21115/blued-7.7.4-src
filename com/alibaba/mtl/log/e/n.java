package com.alibaba.mtl.log.e;

public class n {
  private static a a(String paramString) {
    if (paramString != null) {
      a a = new a();
      int m = 0;
      int i;
      for (i = 0; i < 256; i++)
        a.d[i] = i; 
      a.x = 0;
      a.y = 0;
      int j = 0;
      int k = 0;
      i = m;
      while (true) {
        if (i < 256) {
          try {
            k = (paramString.charAt(j) + a.d[i] + k) % 256;
            m = a.d[i];
            a.d[i] = a.d[k];
            a.d[k] = m;
            j = (j + 1) % paramString.length();
            i++;
          } catch (Exception exception) {
            return null;
          } 
          continue;
        } 
        return a;
      } 
    } 
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfbyte, a parama) {
    if (paramArrayOfbyte != null && parama != null) {
      int k = parama.x;
      int j = parama.y;
      for (int i = 0; i < paramArrayOfbyte.length; i++) {
        k = (k + 1) % 256;
        j = (parama.d[k] + j) % 256;
        int m = parama.d[k];
        parama.d[k] = parama.d[j];
        parama.d[j] = m;
        m = parama.d[k];
        int i1 = parama.d[j];
        byte b = paramArrayOfbyte[i];
        paramArrayOfbyte[i] = (byte)(parama.d[(m + i1) % 256] ^ b);
      } 
      parama.x = k;
      parama.y = j;
      return paramArrayOfbyte;
    } 
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, String paramString) {
    if (paramArrayOfbyte != null && paramString != null) {
      a a = a(paramString);
      if (a != null)
        return a(paramArrayOfbyte, a); 
    } 
    return null;
  }
  
  static class a {
    public int[] d = new int[256];
    
    public int x;
    
    public int y;
    
    private a() {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */