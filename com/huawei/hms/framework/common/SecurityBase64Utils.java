package com.huawei.hms.framework.common;

import android.util.Base64;
import com.huawei.secure.android.common.util.SafeBase64;

public class SecurityBase64Utils {
  private static boolean IS_AEGIS_BASE64_LIBRARY_LOADED = false;
  
  private static final String SAFE_BASE64_PATH = "com.huawei.secure.android.common.util.SafeBase64";
  
  private static boolean checkCompatible(String paramString) {
    // Byte code:
    //   0: ldc com/huawei/hms/framework/common/SecurityBase64Utils
    //   2: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnonnull -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   17: pop
    //   18: ldc com/huawei/hms/framework/common/StringUtils
    //   20: monitorenter
    //   21: iconst_1
    //   22: putstatic com/huawei/hms/framework/common/SecurityBase64Utils.IS_AEGIS_BASE64_LIBRARY_LOADED : Z
    //   25: ldc com/huawei/hms/framework/common/StringUtils
    //   27: monitorexit
    //   28: iconst_1
    //   29: ireturn
    //   30: astore_0
    //   31: ldc com/huawei/hms/framework/common/StringUtils
    //   33: monitorexit
    //   34: aload_0
    //   35: athrow
    //   36: astore_0
    //   37: iconst_0
    //   38: ireturn
    // Exception table:
    //   from	to	target	type
    //   12	21	36	java/lang/ClassNotFoundException
    //   21	28	30	finally
    //   31	34	30	finally
    //   34	36	36	java/lang/ClassNotFoundException
  }
  
  public static byte[] decode(String paramString, int paramInt) {
    if (IS_AEGIS_BASE64_LIBRARY_LOADED || checkCompatible("com.huawei.secure.android.common.util.SafeBase64"))
      return SafeBase64.a(paramString, paramInt); 
    try {
      return Base64.decode(paramString, paramInt);
    } catch (Exception exception) {
      return new byte[0];
    } 
  }
  
  public static String encodeToString(byte[] paramArrayOfbyte, int paramInt) {
    if (IS_AEGIS_BASE64_LIBRARY_LOADED || checkCompatible("com.huawei.secure.android.common.util.SafeBase64"))
      return SafeBase64.a(paramArrayOfbyte, paramInt); 
    try {
      return Base64.encodeToString(paramArrayOfbyte, paramInt);
    } catch (Exception exception) {
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\common\SecurityBase64Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */