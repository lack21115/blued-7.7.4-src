package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import java.util.Locale;

public class GrsManager implements BasePlugin {
  private static final int GRS_KEY_INDEX = 1;
  
  private static final int GRS_PATH_INDEX = 2;
  
  private static final String GRS_SCHEMA = "grs://";
  
  private static final int GRS_SERVICE_INDEX = 0;
  
  private static final int MAX_GRS_SPLIT = 3;
  
  private static final String SEPARATOR = "/";
  
  private static final String TAG = "GrsManager";
  
  private static volatile GrsManager instance;
  
  private GrsConfig grsConfig;
  
  private f grsInterceptor;
  
  public static GrsManager getInstance() {
    // Byte code:
    //   0: getstatic com/huawei/hms/framework/network/grs/GrsManager.instance : Lcom/huawei/hms/framework/network/grs/GrsManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/huawei/hms/framework/network/grs/GrsManager
    //   8: monitorenter
    //   9: getstatic com/huawei/hms/framework/network/grs/GrsManager.instance : Lcom/huawei/hms/framework/network/grs/GrsManager;
    //   12: ifnonnull -> 25
    //   15: new com/huawei/hms/framework/network/grs/GrsManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/huawei/hms/framework/network/grs/GrsManager.instance : Lcom/huawei/hms/framework/network/grs/GrsManager;
    //   25: ldc com/huawei/hms/framework/network/grs/GrsManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/huawei/hms/framework/network/grs/GrsManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/huawei/hms/framework/network/grs/GrsManager.instance : Lcom/huawei/hms/framework/network/grs/GrsManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  private String getServiceNameUrl(String paramString1, String paramString2) {
    return GrsApi.synGetGrsUrl(paramString1, paramString2);
  }
  
  public static boolean isGRSSchema(String paramString) {
    return (paramString != null && paramString.startsWith("grs://"));
  }
  
  private String[] parseGRSSchema(String paramString) {
    return StringUtils.substring(paramString, paramString.toLowerCase(Locale.ENGLISH).indexOf("grs://") + 6).split("/", 3);
  }
  
  public PluginInterceptor getInterceptor() {
    if (this.grsInterceptor == null)
      this.grsInterceptor = new f(); 
    return this.grsInterceptor;
  }
  
  public boolean initGrs(Context paramContext, GrsConfig paramGrsConfig) {
    GrsConfig grsConfig = this.grsConfig;
    if (grsConfig == null || !grsConfig.equal(paramGrsConfig)) {
      GrsBaseInfo grsBaseInfo;
      this.grsConfig = paramGrsConfig;
      paramGrsConfig = null;
      if (paramContext != null) {
        paramContext = paramContext.getApplicationContext();
      } else {
        paramContext = null;
      } 
      grsConfig = this.grsConfig;
      if (grsConfig != null)
        grsBaseInfo = grsConfig.getGrsBaseInfo(paramContext); 
      GrsApi.grsSdkInit(paramContext, grsBaseInfo);
    } 
    return true;
  }
  
  protected String parseGrs(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: astore_2
    //   2: aload_1
    //   3: ldc '/'
    //   5: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   8: ifeq -> 28
    //   11: aload_1
    //   12: aload_1
    //   13: ldc 'grs://'
    //   15: invokevirtual indexOf : (Ljava/lang/String;)I
    //   18: aload_1
    //   19: invokevirtual length : ()I
    //   22: iconst_1
    //   23: isub
    //   24: invokestatic substring : (Ljava/lang/String;II)Ljava/lang/String;
    //   27: astore_2
    //   28: aload_0
    //   29: aload_2
    //   30: invokespecial parseGRSSchema : (Ljava/lang/String;)[Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: arraylength
    //   36: iconst_1
    //   37: if_icmpne -> 57
    //   40: aload_3
    //   41: iconst_0
    //   42: aaload
    //   43: astore_1
    //   44: ldc 'ROOT'
    //   46: astore_2
    //   47: aload_0
    //   48: aload_1
    //   49: aload_2
    //   50: invokespecial getServiceNameUrl : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   53: astore_1
    //   54: goto -> 84
    //   57: aload_3
    //   58: arraylength
    //   59: iconst_2
    //   60: if_icmplt -> 74
    //   63: aload_3
    //   64: iconst_0
    //   65: aaload
    //   66: astore_1
    //   67: aload_3
    //   68: iconst_1
    //   69: aaload
    //   70: astore_2
    //   71: goto -> 47
    //   74: ldc 'GrsManager'
    //   76: ldc 'parseGrs params.length<1.'
    //   78: invokestatic i : (Ljava/lang/String;Ljava/lang/Object;)V
    //   81: ldc ''
    //   83: astore_1
    //   84: aload_1
    //   85: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   88: ifne -> 171
    //   91: aload_1
    //   92: astore_2
    //   93: aload_3
    //   94: arraylength
    //   95: iconst_2
    //   96: if_icmple -> 169
    //   99: aload_1
    //   100: ldc '/'
    //   102: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   105: ifeq -> 135
    //   108: new java/lang/StringBuilder
    //   111: dup
    //   112: invokespecial <init> : ()V
    //   115: astore_2
    //   116: aload_2
    //   117: aload_1
    //   118: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: pop
    //   122: aload_2
    //   123: aload_3
    //   124: iconst_2
    //   125: aaload
    //   126: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload_2
    //   131: invokevirtual toString : ()Ljava/lang/String;
    //   134: areturn
    //   135: new java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial <init> : ()V
    //   142: astore_2
    //   143: aload_2
    //   144: aload_1
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc '/'
    //   152: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: aload_3
    //   158: iconst_2
    //   159: aaload
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_2
    //   165: invokevirtual toString : ()Ljava/lang/String;
    //   168: astore_2
    //   169: aload_2
    //   170: areturn
    //   171: new java/io/IOException
    //   174: dup
    //   175: ldc 'can not get url, do grsUrl(serviceName or key) error?'
    //   177: invokespecial <init> : (Ljava/lang/String;)V
    //   180: athrow
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\huawei\hms\framework\network\grs\GrsManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */