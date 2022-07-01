package com.google.android.gms.common.internal;

import java.util.concurrent.ConcurrentHashMap;

public class LibraryVersion {
  private static final GmsLogger zza = new GmsLogger("LibraryVersion", "");
  
  private static LibraryVersion zzb = new LibraryVersion();
  
  private ConcurrentHashMap<String, String> zzc = new ConcurrentHashMap<String, String>();
  
  public static LibraryVersion getInstance() {
    return zzb;
  }
  
  public String getVersion(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: ldc 'Please provide a valid libraryName'
    //   3: invokestatic checkNotEmpty : (Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   6: pop
    //   7: aload_0
    //   8: getfield zzc : Ljava/util/concurrent/ConcurrentHashMap;
    //   11: aload_1
    //   12: invokevirtual containsKey : (Ljava/lang/Object;)Z
    //   15: ifeq -> 30
    //   18: aload_0
    //   19: getfield zzc : Ljava/util/concurrent/ConcurrentHashMap;
    //   22: aload_1
    //   23: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   26: checkcast java/lang/String
    //   29: areturn
    //   30: new java/util/Properties
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: astore #7
    //   39: aconst_null
    //   40: astore #6
    //   42: aconst_null
    //   43: astore_2
    //   44: aconst_null
    //   45: astore_3
    //   46: aconst_null
    //   47: astore #5
    //   49: ldc com/google/android/gms/common/internal/LibraryVersion
    //   51: ldc '/%s.properties'
    //   53: iconst_1
    //   54: anewarray java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   64: invokevirtual getResourceAsStream : (Ljava/lang/String;)Ljava/io/InputStream;
    //   67: astore #4
    //   69: aload #4
    //   71: ifnull -> 177
    //   74: aload #6
    //   76: astore_2
    //   77: aload #7
    //   79: aload #4
    //   81: invokevirtual load : (Ljava/io/InputStream;)V
    //   84: aload #6
    //   86: astore_2
    //   87: aload #7
    //   89: ldc 'version'
    //   91: aconst_null
    //   92: invokevirtual getProperty : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   95: astore_3
    //   96: aload_3
    //   97: astore_2
    //   98: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   101: astore #5
    //   103: aload_3
    //   104: astore_2
    //   105: new java/lang/StringBuilder
    //   108: dup
    //   109: aload_1
    //   110: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   113: invokevirtual length : ()I
    //   116: bipush #12
    //   118: iadd
    //   119: aload_3
    //   120: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   123: invokevirtual length : ()I
    //   126: iadd
    //   127: invokespecial <init> : (I)V
    //   130: astore #6
    //   132: aload_3
    //   133: astore_2
    //   134: aload #6
    //   136: aload_1
    //   137: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload_3
    //   142: astore_2
    //   143: aload #6
    //   145: ldc ' version is '
    //   147: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload_3
    //   152: astore_2
    //   153: aload #6
    //   155: aload_3
    //   156: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: aload_3
    //   161: astore_2
    //   162: aload #5
    //   164: ldc 'LibraryVersion'
    //   166: aload #6
    //   168: invokevirtual toString : ()Ljava/lang/String;
    //   171: invokevirtual v : (Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -> 243
    //   177: aload #6
    //   179: astore_2
    //   180: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   183: astore #7
    //   185: aload #6
    //   187: astore_2
    //   188: aload_1
    //   189: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   192: astore_3
    //   193: aload #6
    //   195: astore_2
    //   196: aload_3
    //   197: invokevirtual length : ()I
    //   200: ifeq -> 216
    //   203: aload #6
    //   205: astore_2
    //   206: ldc 'Failed to get app version for libraryName: '
    //   208: aload_3
    //   209: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   212: astore_3
    //   213: goto -> 229
    //   216: aload #6
    //   218: astore_2
    //   219: new java/lang/String
    //   222: dup
    //   223: ldc 'Failed to get app version for libraryName: '
    //   225: invokespecial <init> : (Ljava/lang/String;)V
    //   228: astore_3
    //   229: aload #6
    //   231: astore_2
    //   232: aload #7
    //   234: ldc 'LibraryVersion'
    //   236: aload_3
    //   237: invokevirtual w : (Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload #5
    //   242: astore_3
    //   243: aload_3
    //   244: astore_2
    //   245: aload #4
    //   247: ifnull -> 363
    //   250: aload #4
    //   252: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   255: aload_3
    //   256: astore_2
    //   257: goto -> 363
    //   260: astore_1
    //   261: goto -> 394
    //   264: astore #5
    //   266: aload #4
    //   268: astore_3
    //   269: aload_2
    //   270: astore #4
    //   272: goto -> 287
    //   275: astore_1
    //   276: aload_2
    //   277: astore #4
    //   279: goto -> 394
    //   282: astore #5
    //   284: aconst_null
    //   285: astore #4
    //   287: aload_3
    //   288: astore_2
    //   289: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   292: astore #7
    //   294: aload_3
    //   295: astore_2
    //   296: aload_1
    //   297: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   300: astore #6
    //   302: aload_3
    //   303: astore_2
    //   304: aload #6
    //   306: invokevirtual length : ()I
    //   309: ifeq -> 326
    //   312: aload_3
    //   313: astore_2
    //   314: ldc 'Failed to get app version for libraryName: '
    //   316: aload #6
    //   318: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   321: astore #6
    //   323: goto -> 339
    //   326: aload_3
    //   327: astore_2
    //   328: new java/lang/String
    //   331: dup
    //   332: ldc 'Failed to get app version for libraryName: '
    //   334: invokespecial <init> : (Ljava/lang/String;)V
    //   337: astore #6
    //   339: aload_3
    //   340: astore_2
    //   341: aload #7
    //   343: ldc 'LibraryVersion'
    //   345: aload #6
    //   347: aload #5
    //   349: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   352: aload_3
    //   353: ifnull -> 360
    //   356: aload_3
    //   357: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   360: aload #4
    //   362: astore_2
    //   363: aload_2
    //   364: astore_3
    //   365: aload_2
    //   366: ifnonnull -> 382
    //   369: getstatic com/google/android/gms/common/internal/LibraryVersion.zza : Lcom/google/android/gms/common/internal/GmsLogger;
    //   372: ldc 'LibraryVersion'
    //   374: ldc '.properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used'
    //   376: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   379: ldc 'UNKNOWN'
    //   381: astore_3
    //   382: aload_0
    //   383: getfield zzc : Ljava/util/concurrent/ConcurrentHashMap;
    //   386: aload_1
    //   387: aload_3
    //   388: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   391: pop
    //   392: aload_3
    //   393: areturn
    //   394: aload #4
    //   396: ifnull -> 404
    //   399: aload #4
    //   401: invokestatic closeQuietly : (Ljava/io/Closeable;)V
    //   404: aload_1
    //   405: athrow
    // Exception table:
    //   from	to	target	type
    //   49	69	282	java/io/IOException
    //   49	69	275	finally
    //   77	84	264	java/io/IOException
    //   77	84	260	finally
    //   87	96	264	java/io/IOException
    //   87	96	260	finally
    //   98	103	264	java/io/IOException
    //   98	103	260	finally
    //   105	132	264	java/io/IOException
    //   105	132	260	finally
    //   134	141	264	java/io/IOException
    //   134	141	260	finally
    //   143	151	264	java/io/IOException
    //   143	151	260	finally
    //   153	160	264	java/io/IOException
    //   153	160	260	finally
    //   162	174	264	java/io/IOException
    //   162	174	260	finally
    //   180	185	264	java/io/IOException
    //   180	185	260	finally
    //   188	193	264	java/io/IOException
    //   188	193	260	finally
    //   196	203	264	java/io/IOException
    //   196	203	260	finally
    //   206	213	264	java/io/IOException
    //   206	213	260	finally
    //   219	229	264	java/io/IOException
    //   219	229	260	finally
    //   232	240	264	java/io/IOException
    //   232	240	260	finally
    //   289	294	275	finally
    //   296	302	275	finally
    //   304	312	275	finally
    //   314	323	275	finally
    //   328	339	275	finally
    //   341	352	275	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\common\internal\LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */