package com.blued.android.module.player.media.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.blued.android.core.utils.Log;
import com.blued.android.module.player.media.model.VideoPlayConfig;

public class Utils {
  private static final String a = Utils.class.getSimpleName();
  
  public static Activity a(Context paramContext) {
    while (paramContext instanceof ContextWrapper) {
      if (paramContext instanceof Activity)
        return (Activity)paramContext; 
      paramContext = ((ContextWrapper)paramContext).getBaseContext();
    } 
    return null;
  }
  
  public static void a(VideoPlayConfig paramVideoPlayConfig) {
    paramVideoPlayConfig.e = AppInfo.l;
    paramVideoPlayConfig.f = AppInfo.m;
    if (paramVideoPlayConfig.a() != 0 && paramVideoPlayConfig.b() != 0 && paramVideoPlayConfig.e != 0) {
      float f = paramVideoPlayConfig.e / paramVideoPlayConfig.a();
      f = paramVideoPlayConfig.b() * f;
      if (paramVideoPlayConfig.f - f > 0.0F && (f / paramVideoPlayConfig.f) >= 0.8D) {
        paramVideoPlayConfig.e = AppInfo.l;
        paramVideoPlayConfig.f = AppInfo.m;
        b(paramVideoPlayConfig);
        return;
      } 
      paramVideoPlayConfig.f = (int)f;
    } 
  }
  
  public static int[] a(String paramString) {
    boolean bool1;
    boolean bool2;
    boolean bool3;
    int[] arrayOfInt = new int[3];
    MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
    try {
      if (!TextUtils.isEmpty(paramString) && !paramString.contains("http"))
        mediaMetadataRetriever.setDataSource(paramString); 
      String str1 = mediaMetadataRetriever.extractMetadata(18);
      String str2 = mediaMetadataRetriever.extractMetadata(19);
      paramString = mediaMetadataRetriever.extractMetadata(24);
      if (!TextUtils.isEmpty(str1) && !TextUtils.isEmpty(str2)) {
        bool2 = Integer.parseInt(str1);
        bool1 = Integer.parseInt(str2);
      } else {
        String str = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" widthStr");
        stringBuilder.append(str1);
        stringBuilder.append(",heightStr");
        stringBuilder.append(str2);
        Log.e(str, stringBuilder.toString());
        bool2 = false;
        bool1 = false;
      } 
      if (!TextUtils.isEmpty(paramString)) {
        bool3 = Integer.parseInt(paramString);
      } else {
        str1 = a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" rotation");
        stringBuilder.append(paramString);
        Log.e(str1, stringBuilder.toString());
        bool3 = false;
      } 
    } catch (Exception exception) {
      String str = a;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" MediaMetadataRetriever exception ");
      stringBuilder.append(exception);
      Log.e(str, stringBuilder.toString());
      exception.printStackTrace();
      mediaMetadataRetriever.release();
      return arrayOfInt;
    } finally {}
    if (bool3 == 90 || bool3 == 'Ď') {
      arrayOfInt[0] = bool1;
      arrayOfInt[1] = bool2;
    } else {
      arrayOfInt[0] = bool2;
      arrayOfInt[1] = bool1;
    } 
    arrayOfInt[2] = bool3;
    mediaMetadataRetriever.release();
    return arrayOfInt;
  }
  
  public static void b(VideoPlayConfig paramVideoPlayConfig) {
    if (paramVideoPlayConfig.a() != 0 && paramVideoPlayConfig.b() != 0 && paramVideoPlayConfig.e != 0 && paramVideoPlayConfig.f != 0) {
      float f = Math.min(paramVideoPlayConfig.a() / paramVideoPlayConfig.e, paramVideoPlayConfig.b() / paramVideoPlayConfig.f);
      paramVideoPlayConfig.e = (int)Math.ceil((paramVideoPlayConfig.a() / f));
      paramVideoPlayConfig.f = (int)Math.ceil((paramVideoPlayConfig.b() / f));
    } 
  }
  
  public static void b(String paramString) {
    // Byte code:
    //   0: ldc com/blued/android/module/player/media/utils/Utils
    //   2: monitorenter
    //   3: new java/io/File
    //   6: dup
    //   7: aload_0
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: astore_1
    //   12: new java/io/File
    //   15: dup
    //   16: aload_0
    //   17: ldc '.nomedia'
    //   19: invokespecial <init> : (Ljava/lang/String;Ljava/lang/String;)V
    //   22: astore_2
    //   23: aconst_null
    //   24: astore_0
    //   25: aload_1
    //   26: invokevirtual exists : ()Z
    //   29: ifne -> 37
    //   32: aload_1
    //   33: invokevirtual mkdirs : ()Z
    //   36: pop
    //   37: aload_2
    //   38: invokevirtual exists : ()Z
    //   41: ifne -> 124
    //   44: aload_2
    //   45: invokevirtual createNewFile : ()Z
    //   48: pop
    //   49: new java/io/FileOutputStream
    //   52: dup
    //   53: aload_2
    //   54: invokespecial <init> : (Ljava/io/File;)V
    //   57: astore_1
    //   58: aload_1
    //   59: astore_0
    //   60: aload_1
    //   61: invokevirtual flush : ()V
    //   64: aload_1
    //   65: astore_0
    //   66: getstatic com/blued/android/module/player/media/utils/Utils.a : Ljava/lang/String;
    //   69: astore_3
    //   70: aload_1
    //   71: astore_0
    //   72: new java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial <init> : ()V
    //   79: astore #4
    //   81: aload_1
    //   82: astore_0
    //   83: aload #4
    //   85: ldc 'create .nomedia file:'
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload_1
    //   92: astore_0
    //   93: aload #4
    //   95: aload_2
    //   96: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   99: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: astore_0
    //   105: aload_3
    //   106: aload #4
    //   108: invokevirtual toString : ()Ljava/lang/String;
    //   111: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   114: pop
    //   115: aload_1
    //   116: astore_0
    //   117: goto -> 124
    //   120: astore_2
    //   121: goto -> 153
    //   124: aload_0
    //   125: ifnull -> 140
    //   128: aload_0
    //   129: invokevirtual close : ()V
    //   132: goto -> 140
    //   135: astore_0
    //   136: aload_0
    //   137: invokevirtual printStackTrace : ()V
    //   140: ldc com/blued/android/module/player/media/utils/Utils
    //   142: monitorexit
    //   143: return
    //   144: astore_1
    //   145: aconst_null
    //   146: astore_0
    //   147: goto -> 225
    //   150: astore_2
    //   151: aconst_null
    //   152: astore_1
    //   153: aload_1
    //   154: astore_0
    //   155: getstatic com/blued/android/module/player/media/utils/Utils.a : Ljava/lang/String;
    //   158: astore_3
    //   159: aload_1
    //   160: astore_0
    //   161: new java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial <init> : ()V
    //   168: astore #4
    //   170: aload_1
    //   171: astore_0
    //   172: aload #4
    //   174: ldc 'exception in createNewFile() method:'
    //   176: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload_1
    //   181: astore_0
    //   182: aload #4
    //   184: aload_2
    //   185: invokevirtual getMessage : ()Ljava/lang/String;
    //   188: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload_1
    //   193: astore_0
    //   194: aload_3
    //   195: aload #4
    //   197: invokevirtual toString : ()Ljava/lang/String;
    //   200: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   203: pop
    //   204: aload_1
    //   205: ifnull -> 220
    //   208: aload_1
    //   209: invokevirtual close : ()V
    //   212: goto -> 220
    //   215: astore_0
    //   216: aload_0
    //   217: invokevirtual printStackTrace : ()V
    //   220: ldc com/blued/android/module/player/media/utils/Utils
    //   222: monitorexit
    //   223: return
    //   224: astore_1
    //   225: aload_0
    //   226: ifnull -> 241
    //   229: aload_0
    //   230: invokevirtual close : ()V
    //   233: goto -> 241
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual printStackTrace : ()V
    //   241: aload_1
    //   242: athrow
    //   243: astore_0
    //   244: ldc com/blued/android/module/player/media/utils/Utils
    //   246: monitorexit
    //   247: aload_0
    //   248: athrow
    // Exception table:
    //   from	to	target	type
    //   3	23	243	finally
    //   25	37	150	java/lang/Exception
    //   25	37	144	finally
    //   37	58	150	java/lang/Exception
    //   37	58	144	finally
    //   60	64	120	java/lang/Exception
    //   60	64	224	finally
    //   66	70	120	java/lang/Exception
    //   66	70	224	finally
    //   72	81	120	java/lang/Exception
    //   72	81	224	finally
    //   83	91	120	java/lang/Exception
    //   83	91	224	finally
    //   93	103	120	java/lang/Exception
    //   93	103	224	finally
    //   105	115	120	java/lang/Exception
    //   105	115	224	finally
    //   128	132	135	java/lang/Exception
    //   128	132	243	finally
    //   136	140	243	finally
    //   155	159	224	finally
    //   161	170	224	finally
    //   172	180	224	finally
    //   182	192	224	finally
    //   194	204	224	finally
    //   208	212	215	java/lang/Exception
    //   208	212	243	finally
    //   216	220	243	finally
    //   229	233	236	java/lang/Exception
    //   229	233	243	finally
    //   237	241	243	finally
    //   241	243	243	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\player\medi\\utils\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */