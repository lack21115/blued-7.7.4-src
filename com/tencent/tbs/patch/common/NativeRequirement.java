package com.tencent.tbs.patch.common;

public class NativeRequirement {
  private static final Object a = new Object();
  
  private static boolean b = false;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void loadNativeSo(String paramString) {
    Object object = a;
    /* monitor enter ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
    try {
      System.load(paramString);
      b = true;
    } catch (Throwable throwable) {
      b = false;
      throwable.printStackTrace();
    } finally {}
    /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=null} */
  }
  
  public void loadLibraryIfNecessary() {
    synchronized (a) {
      boolean bool = b;
      if (!bool)
        try {
          System.loadLibrary("x5patch");
          b = true;
        } catch (Throwable throwable) {
          b = false;
          throwable.printStackTrace();
        }  
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\NativeRequirement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */