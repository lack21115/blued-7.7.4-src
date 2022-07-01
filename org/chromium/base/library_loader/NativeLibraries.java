package org.chromium.base.library_loader;

public final class NativeLibraries {
  public static final String[] LIBRARIES;
  
  public static int sCpuFamily;
  
  public static boolean sEnableLinkerTests;
  
  public static boolean sUseLibraryInZipFile;
  
  public static boolean sUseLinker = false;
  
  static String sVersionNumber;
  
  static {
    sUseLibraryInZipFile = false;
    sEnableLinkerTests = false;
    LIBRARIES = new String[] { "webviewchromium" };
    sVersionNumber = "69.0.3497.109";
    sCpuFamily = 1;
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\base\library_loader\NativeLibraries.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */