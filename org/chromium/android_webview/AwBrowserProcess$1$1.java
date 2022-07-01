package org.chromium.android_webview;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.io.File;

final class AwBrowserProcess$1$1 implements ServiceConnection {
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder) {
    // Byte code:
    //   0: aload_0
    //   1: getfield val$minidumpFiles : [Ljava/io/File;
    //   4: arraylength
    //   5: anewarray android/os/ParcelFileDescriptor
    //   8: astore_1
    //   9: iconst_0
    //   10: istore #5
    //   12: iconst_0
    //   13: istore #4
    //   15: iconst_0
    //   16: istore_3
    //   17: aload_0
    //   18: getfield val$minidumpFiles : [Ljava/io/File;
    //   21: arraylength
    //   22: istore #6
    //   24: iload_3
    //   25: iload #6
    //   27: if_icmpge -> 112
    //   30: aload_1
    //   31: iload_3
    //   32: aload_0
    //   33: getfield val$minidumpFiles : [Ljava/io/File;
    //   36: iload_3
    //   37: aaload
    //   38: ldc 268435456
    //   40: invokestatic open : (Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
    //   43: aastore
    //   44: goto -> 53
    //   47: astore #7
    //   49: aload_1
    //   50: iload_3
    //   51: aconst_null
    //   52: aastore
    //   53: aload_0
    //   54: getfield val$minidumpFiles : [Ljava/io/File;
    //   57: iload_3
    //   58: aaload
    //   59: invokevirtual delete : ()Z
    //   62: ifne -> 105
    //   65: new java/lang/StringBuilder
    //   68: dup
    //   69: ldc 'Couldn't delete file '
    //   71: invokespecial <init> : (Ljava/lang/String;)V
    //   74: astore #7
    //   76: aload #7
    //   78: aload_0
    //   79: getfield val$minidumpFiles : [Ljava/io/File;
    //   82: iload_3
    //   83: aaload
    //   84: invokevirtual getAbsolutePath : ()Ljava/lang/String;
    //   87: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: ldc 'AwBrowserProcess'
    //   93: aload #7
    //   95: invokevirtual toString : ()Ljava/lang/String;
    //   98: iconst_0
    //   99: anewarray java/lang/Object
    //   102: invokestatic w : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: iload_3
    //   106: iconst_1
    //   107: iadd
    //   108: istore_3
    //   109: goto -> 17
    //   112: aload_2
    //   113: invokestatic asInterface : (Landroid/os/IBinder;)Lorg/chromium/android_webview/services/ICrashReceiverService;
    //   116: aload_1
    //   117: invokeinterface transmitCrashes : ([Landroid/os/ParcelFileDescriptor;)V
    //   122: iload #4
    //   124: istore_3
    //   125: goto -> 132
    //   128: astore_2
    //   129: iload #4
    //   131: istore_3
    //   132: iload_3
    //   133: aload_1
    //   134: arraylength
    //   135: if_icmpge -> 161
    //   138: aload_1
    //   139: iload_3
    //   140: aaload
    //   141: ifnull -> 150
    //   144: aload_1
    //   145: iload_3
    //   146: aaload
    //   147: invokevirtual close : ()V
    //   150: goto -> 154
    //   153: astore_2
    //   154: iload_3
    //   155: iconst_1
    //   156: iadd
    //   157: istore_3
    //   158: goto -> 132
    //   161: aload_0
    //   162: getfield val$appContext : Landroid/content/Context;
    //   165: aload_0
    //   166: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   169: return
    //   170: astore_2
    //   171: iload #5
    //   173: istore_3
    //   174: iload_3
    //   175: aload_1
    //   176: arraylength
    //   177: if_icmpge -> 204
    //   180: aload_1
    //   181: iload_3
    //   182: aaload
    //   183: ifnull -> 192
    //   186: aload_1
    //   187: iload_3
    //   188: aaload
    //   189: invokevirtual close : ()V
    //   192: goto -> 197
    //   195: astore #7
    //   197: iload_3
    //   198: iconst_1
    //   199: iadd
    //   200: istore_3
    //   201: goto -> 174
    //   204: aload_0
    //   205: getfield val$appContext : Landroid/content/Context;
    //   208: aload_0
    //   209: invokevirtual unbindService : (Landroid/content/ServiceConnection;)V
    //   212: aload_2
    //   213: athrow
    // Exception table:
    //   from	to	target	type
    //   17	24	170	finally
    //   30	44	47	java/io/FileNotFoundException
    //   30	44	170	finally
    //   53	105	170	finally
    //   112	122	128	android/os/RemoteException
    //   112	122	170	finally
    //   144	150	153	java/io/IOException
    //   186	192	195	java/io/IOException
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\android_webview\AwBrowserProcess$1$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */