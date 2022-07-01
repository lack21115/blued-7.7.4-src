package com.tencent.tbs.courgette.jni;

public class CourgetteJNI {
  static {
    try {
      System.loadLibrary("tbs_courgette");
    } catch (Exception exception) {
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public static native int applyEnsemblePatch(String paramString1, String paramString2, String paramString3);
  
  public native String hello();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\courgette\jni\CourgetteJNI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */