package com.wrapper.proxyapplication;

import android.app.Application;
import dalvik.system.PathClassLoader;
import java.io.File;

class AndroidNClassLoader extends PathClassLoader {
  private static final String TAG = "SecShell";
  
  private static String baseApkFullPath;
  
  private static Object oldDexPathListHolder;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private AndroidNClassLoader(String paramString, ClassLoader paramClassLoader, Application paramApplication) {
    super(paramString, paramClassLoader);
    try {
      throw new VerifyError("bad dex opcode");
    } finally {
      paramString = null;
    } 
  }
  
  private static ClassLoader createAndroidNClassLoader(String paramString, ClassLoader paramClassLoader, Application paramApplication) throws Exception {
    try {
      new AndroidNClassLoader(paramString, paramClassLoader, paramApplication);
      ShareReflectUtil.findField(paramClassLoader, "pathList");
      throw new VerifyError("bad dex opcode");
    } finally {
      paramString = null;
    } 
  }
  
  public static ClassLoader inject(ClassLoader paramClassLoader, Application paramApplication) throws Exception {
    try {
      paramClassLoader = createAndroidNClassLoader("", paramClassLoader, paramApplication);
      return paramClassLoader;
    } finally {
      paramClassLoader = null;
    } 
  }
  
  private static Object recreateDexPathList(Object paramObject, ClassLoader paramClassLoader, boolean paramBoolean) throws Exception {
    try {
      ShareReflectUtil.findConstructor(paramObject, new Class[] { ClassLoader.class, String.class, String.class, File.class });
      if (paramBoolean)
        throw new VerifyError("bad dex opcode"); 
      ShareReflectUtil.findField(paramObject, "dexElements");
      throw new VerifyError("bad dex opcode");
    } finally {
      paramObject = null;
    } 
  }
  
  private static void reflectPackageInfoClassloader(Application paramApplication, ClassLoader paramClassLoader) throws Exception {
    try {
      ShareReflectUtil.findField(paramApplication, "mBase");
      throw new VerifyError("bad dex opcode");
    } finally {
      paramApplication = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\wrapper\proxyapplication\AndroidNClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */