package com.soft.blued.tinker.reporter;

import android.app.ActivityManager;
import android.content.Context;
import com.tencent.tinker.lib.listener.DefaultPatchListener;
import com.tencent.tinker.lib.util.TinkerLog;

public class BluedPatchListener extends DefaultPatchListener {
  private final int a;
  
  public BluedPatchListener(Context paramContext) {
    super(paramContext);
    this.a = ((ActivityManager)paramContext.getSystemService("activity")).getMemoryClass();
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("application maxMemory:");
    stringBuilder.append(this.a);
    TinkerLog.i("Tinker.BluedPatchListener", stringBuilder.toString(), new Object[0]);
  }
  
  public int patchCheck(String paramString1, String paramString2) {
    // Byte code:
    //   0: new java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial <init> : (Ljava/lang/String;)V
    //   8: astore #7
    //   10: iconst_0
    //   11: istore #6
    //   13: ldc 'Tinker.BluedPatchListener'
    //   15: ldc 'receive a patch file: %s, file size:%d'
    //   17: iconst_2
    //   18: anewarray java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: aload_1
    //   24: aastore
    //   25: dup
    //   26: iconst_1
    //   27: aload #7
    //   29: invokestatic getFileOrDirectorySize : (Ljava/io/File;)J
    //   32: invokestatic valueOf : (J)Ljava/lang/Long;
    //   35: aastore
    //   36: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   39: aload_0
    //   40: aload_1
    //   41: aload_2
    //   42: invokespecial patchCheck : (Ljava/lang/String;Ljava/lang/String;)I
    //   45: istore_3
    //   46: iload_3
    //   47: istore #4
    //   49: iload_3
    //   50: ifne -> 65
    //   53: ldc2_w 62914560
    //   56: aload_0
    //   57: getfield a : I
    //   60: invokestatic a : (JI)I
    //   63: istore #4
    //   65: iload #4
    //   67: istore_3
    //   68: iload #4
    //   70: ifne -> 100
    //   73: iload #4
    //   75: istore_3
    //   76: aload_0
    //   77: getfield context : Landroid/content/Context;
    //   80: ldc 'tinker_share_config'
    //   82: iconst_4
    //   83: invokevirtual getSharedPreferences : (Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   86: aload_2
    //   87: iconst_0
    //   88: invokeinterface getInt : (Ljava/lang/String;I)I
    //   93: iconst_3
    //   94: if_icmplt -> 100
    //   97: bipush #-23
    //   99: istore_3
    //   100: bipush #-24
    //   102: istore #5
    //   104: iload_3
    //   105: ifne -> 191
    //   108: aload #7
    //   110: invokestatic fastGetPatchPackageMeta : (Ljava/io/File;)Ljava/util/Properties;
    //   113: astore_1
    //   114: aload_1
    //   115: ifnonnull -> 125
    //   118: iload #5
    //   120: istore #4
    //   122: goto -> 194
    //   125: aload_1
    //   126: ldc 'platform'
    //   128: invokevirtual getProperty : (Ljava/lang/String;)Ljava/lang/String;
    //   131: astore_1
    //   132: new java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial <init> : ()V
    //   139: astore_2
    //   140: aload_2
    //   141: ldc 'get platform:'
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload_2
    //   148: aload_1
    //   149: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 'Tinker.BluedPatchListener'
    //   155: aload_2
    //   156: invokevirtual toString : ()Ljava/lang/String;
    //   159: iconst_0
    //   160: anewarray java/lang/Object
    //   163: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   166: iload #5
    //   168: istore #4
    //   170: aload_1
    //   171: ifnull -> 194
    //   174: aload_1
    //   175: getstatic com/soft/blued/tinker/app/BuildInfo.f : Ljava/lang/String;
    //   178: invokevirtual equals : (Ljava/lang/Object;)Z
    //   181: ifne -> 191
    //   184: iload #5
    //   186: istore #4
    //   188: goto -> 194
    //   191: iload_3
    //   192: istore #4
    //   194: iload #4
    //   196: ifne -> 202
    //   199: iconst_1
    //   200: istore #6
    //   202: iload #6
    //   204: invokestatic a : (Z)V
    //   207: iload #4
    //   209: ireturn
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\tinker\reporter\BluedPatchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */