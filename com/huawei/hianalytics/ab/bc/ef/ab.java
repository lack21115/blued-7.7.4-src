package com.huawei.hianalytics.ab.bc.ef;

public class ab {
  private static bc ab = new bc();
  
  public static void ab(int paramInt) {
    ab.ab(paramInt);
  }
  
  public static void ab(String paramString1, String paramString2) {
    if (ab() && paramString1 != null && paramString2 != null)
      ab.bc(3, paramString1, paramString2); 
  }
  
  public static void ab(String paramString1, String paramString2, Object... paramVarArgs) {
    if (cd() && paramString1 != null && paramString2 != null) {
      paramString2 = String.format(paramString2, paramVarArgs);
      ab.bc(4, paramString1, paramString2);
    } 
  }
  
  private static boolean ab() {
    return ab.bc(3);
  }
  
  public static void bc(String paramString1, String paramString2) {
    if (bc() && paramString1 != null && paramString2 != null)
      ab.bc(6, paramString1, paramString2); 
  }
  
  public static void bc(String paramString1, String paramString2, Object... paramVarArgs) {
    de(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  private static boolean bc() {
    return ab.bc(6);
  }
  
  public static void cd(String paramString1, String paramString2) {
    if (cd() && paramString1 != null && paramString2 != null)
      ab.bc(4, paramString1, paramString2); 
  }
  
  private static boolean cd() {
    return ab.bc(4);
  }
  
  public static void de(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null)
      ab.bc(4, paramString1, paramString2); 
  }
  
  private static boolean de() {
    return ab.bc(5);
  }
  
  public static void ef(String paramString1, String paramString2) {
    if (paramString1 != null && paramString2 != null)
      ab.bc(5, paramString1, paramString2); 
  }
  
  public static void fg(String paramString1, String paramString2) {
    if (de() && paramString1 != null && paramString2 != null)
      ab.bc(5, paramString1, paramString2); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hianalytics\ab\bc\ef\ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */