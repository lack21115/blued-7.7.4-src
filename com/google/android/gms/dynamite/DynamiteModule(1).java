package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION;
  
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
  
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION;
  
  public static final VersionPolicy PREFER_LOCAL;
  
  public static final VersionPolicy PREFER_REMOTE;
  
  public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING;
  
  private static Boolean zza;
  
  private static zzk zzb;
  
  private static zzm zzc;
  
  private static String zzd;
  
  private static int zze = -1;
  
  private static final ThreadLocal<zza> zzf = new ThreadLocal<zza>();
  
  private static final VersionPolicy.zzb zzg = new zzb();
  
  private static final VersionPolicy zzh;
  
  private final Context zzi;
  
  static {
    PREFER_REMOTE = new zza();
    PREFER_LOCAL = new zzd();
    PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzc();
    PREFER_HIGHEST_OR_LOCAL_VERSION = new zzf();
    PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
    PREFER_HIGHEST_OR_REMOTE_VERSION = new zzh();
    zzh = new zzg();
  }
  
  private DynamiteModule(Context paramContext) {
    this.zzi = (Context)Preconditions.checkNotNull(paramContext);
  }
  
  public static int getLocalVersion(Context paramContext, String paramString) {
    try {
      StringBuilder stringBuilder1;
      ClassLoader classLoader = paramContext.getApplicationContext().getClassLoader();
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(paramString).length() + 61);
      stringBuilder2.append("com.google.android.gms.dynamite.descriptors.");
      stringBuilder2.append(paramString);
      stringBuilder2.append(".ModuleDescriptor");
      Class<?> clazz = classLoader.loadClass(stringBuilder2.toString());
      Field field1 = clazz.getDeclaredField("MODULE_ID");
      Field field2 = clazz.getDeclaredField("MODULE_VERSION");
      if (!field1.get(null).equals(paramString)) {
        String str = String.valueOf(field1.get(null));
        stringBuilder1 = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(paramString).length());
        stringBuilder1.append("Module descriptor id '");
        stringBuilder1.append(str);
        stringBuilder1.append("' didn't match expected id '");
        stringBuilder1.append(paramString);
        stringBuilder1.append("'");
        Log.e("DynamiteModule", stringBuilder1.toString());
        return 0;
      } 
      return stringBuilder1.getInt(null);
    } catch (ClassNotFoundException classNotFoundException) {
      StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 45);
      stringBuilder.append("Local module descriptor class for ");
      stringBuilder.append(paramString);
      stringBuilder.append(" not found.");
      Log.w("DynamiteModule", stringBuilder.toString());
      return 0;
    } catch (Exception exception) {
      String str = String.valueOf(exception.getMessage());
      if (str.length() != 0) {
        str = "Failed to load module descriptor class: ".concat(str);
      } else {
        str = new String("Failed to load module descriptor class: ");
      } 
      Log.e("DynamiteModule", str);
      return 0;
    } 
  }
  
  public static int getRemoteVersion(Context paramContext, String paramString) {
    return zza(paramContext, paramString, false);
  }
  
  public static DynamiteModule load(Context paramContext, VersionPolicy paramVersionPolicy, String paramString) throws LoadingException {
    zza zza1 = zzf.get();
    zza zza2 = new zza(null);
    zzf.set(zza2);
    try {
      VersionPolicy.zza zza = paramVersionPolicy.zza(paramContext, paramString, zzg);
      int i = zza.zza;
      int j = zza.zzb;
      StringBuilder stringBuilder2 = new StringBuilder(String.valueOf(paramString).length() + 68 + String.valueOf(paramString).length());
      stringBuilder2.append("Considering local module ");
      stringBuilder2.append(paramString);
      stringBuilder2.append(":");
      stringBuilder2.append(i);
      stringBuilder2.append(" and remote module ");
      stringBuilder2.append(paramString);
      stringBuilder2.append(":");
      stringBuilder2.append(j);
      Log.i("DynamiteModule", stringBuilder2.toString());
      if (zza.zzc != 0 && (zza.zzc != -1 || zza.zza != 0) && (zza.zzc != 1 || zza.zzb != 0)) {
        DynamiteModule dynamiteModule;
        if (zza.zzc == -1) {
          dynamiteModule = zza(paramContext, paramString);
          return dynamiteModule;
        } 
        i = zza.zzc;
        if (i == 1)
          try {
            return zza((Context)dynamiteModule, paramString, zza.zzb);
          } catch (LoadingException loadingException) {
            String str = String.valueOf(loadingException.getMessage());
            if (str.length() != 0) {
              str = "Failed to load remote module: ".concat(str);
            } else {
              str = new String("Failed to load remote module: ");
            } 
            Log.w("DynamiteModule", str);
            if (zza.zza != 0 && (paramVersionPolicy.zza((Context)dynamiteModule, paramString, new zzb(zza.zza, 0))).zzc == -1) {
              dynamiteModule = zza((Context)dynamiteModule, paramString);
              return dynamiteModule;
            } 
            throw new LoadingException("Remote load failed. No local fallback found.", loadingException, null);
          }  
        i = zza.zzc;
        StringBuilder stringBuilder = new StringBuilder(47);
        stringBuilder.append("VersionPolicy returned invalid code:");
        stringBuilder.append(i);
        throw new LoadingException(stringBuilder.toString(), null);
      } 
      i = zza.zza;
      j = zza.zzb;
      StringBuilder stringBuilder1 = new StringBuilder(91);
      stringBuilder1.append("No acceptable module found. Local version is ");
      stringBuilder1.append(i);
      stringBuilder1.append(" and remote version is ");
      stringBuilder1.append(j);
      stringBuilder1.append(".");
      throw new LoadingException(stringBuilder1.toString(), null);
    } finally {
      if (zza2.zza != null)
        zza2.zza.close(); 
      zzf.set(zza1);
    } 
  }
  
  public static int zza(Context paramContext, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zza : Ljava/lang/Boolean;
    //   6: astore #6
    //   8: aload #6
    //   10: astore #5
    //   12: aload #6
    //   14: ifnonnull -> 334
    //   17: aload_0
    //   18: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   21: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   24: ldc com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader
    //   26: invokevirtual getName : ()Ljava/lang/String;
    //   29: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   32: ldc_w 'sClassLoader'
    //   35: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   38: astore #7
    //   40: aload #7
    //   42: invokevirtual getDeclaringClass : ()Ljava/lang/Class;
    //   45: astore #6
    //   47: aload #6
    //   49: monitorenter
    //   50: aload #7
    //   52: aconst_null
    //   53: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   56: checkcast java/lang/ClassLoader
    //   59: astore #5
    //   61: aload #5
    //   63: ifnull -> 95
    //   66: aload #5
    //   68: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   71: if_acmpne -> 82
    //   74: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   77: astore #5
    //   79: goto -> 243
    //   82: aload #5
    //   84: invokestatic zza : (Ljava/lang/ClassLoader;)V
    //   87: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   90: astore #5
    //   92: goto -> 243
    //   95: ldc_w 'com.google.android.gms'
    //   98: aload_0
    //   99: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   102: invokevirtual getPackageName : ()Ljava/lang/String;
    //   105: invokevirtual equals : (Ljava/lang/Object;)Z
    //   108: ifeq -> 128
    //   111: aload #7
    //   113: aconst_null
    //   114: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   117: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   120: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   123: astore #5
    //   125: goto -> 243
    //   128: aload_0
    //   129: aload_1
    //   130: iload_2
    //   131: invokestatic zzc : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   134: istore_3
    //   135: getstatic com/google/android/gms/dynamite/DynamiteModule.zzd : Ljava/lang/String;
    //   138: ifnull -> 221
    //   141: getstatic com/google/android/gms/dynamite/DynamiteModule.zzd : Ljava/lang/String;
    //   144: invokevirtual isEmpty : ()Z
    //   147: ifeq -> 153
    //   150: goto -> 221
    //   153: getstatic android/os/Build$VERSION.SDK_INT : I
    //   156: bipush #29
    //   158: if_icmplt -> 179
    //   161: new dalvik/system/DelegateLastClassLoader
    //   164: dup
    //   165: getstatic com/google/android/gms/dynamite/DynamiteModule.zzd : Ljava/lang/String;
    //   168: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   171: invokespecial <init> : (Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   174: astore #5
    //   176: goto -> 194
    //   179: new com/google/android/gms/dynamite/zzi
    //   182: dup
    //   183: getstatic com/google/android/gms/dynamite/DynamiteModule.zzd : Ljava/lang/String;
    //   186: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   189: invokespecial <init> : (Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   192: astore #5
    //   194: aload #5
    //   196: invokestatic zza : (Ljava/lang/ClassLoader;)V
    //   199: aload #7
    //   201: aconst_null
    //   202: aload #5
    //   204: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   207: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   210: putstatic com/google/android/gms/dynamite/DynamiteModule.zza : Ljava/lang/Boolean;
    //   213: aload #6
    //   215: monitorexit
    //   216: ldc com/google/android/gms/dynamite/DynamiteModule
    //   218: monitorexit
    //   219: iload_3
    //   220: ireturn
    //   221: aload #6
    //   223: monitorexit
    //   224: ldc com/google/android/gms/dynamite/DynamiteModule
    //   226: monitorexit
    //   227: iload_3
    //   228: ireturn
    //   229: aload #7
    //   231: aconst_null
    //   232: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   235: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   238: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   241: astore #5
    //   243: aload #6
    //   245: monitorexit
    //   246: goto -> 329
    //   249: astore #5
    //   251: aload #6
    //   253: monitorexit
    //   254: aload #5
    //   256: athrow
    //   257: astore #5
    //   259: goto -> 269
    //   262: astore #5
    //   264: goto -> 269
    //   267: astore #5
    //   269: aload #5
    //   271: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   274: astore #5
    //   276: new java/lang/StringBuilder
    //   279: dup
    //   280: aload #5
    //   282: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   285: invokevirtual length : ()I
    //   288: bipush #30
    //   290: iadd
    //   291: invokespecial <init> : (I)V
    //   294: astore #6
    //   296: aload #6
    //   298: ldc_w 'Failed to load module via V2: '
    //   301: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #6
    //   307: aload #5
    //   309: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: ldc 'DynamiteModule'
    //   315: aload #6
    //   317: invokevirtual toString : ()Ljava/lang/String;
    //   320: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   323: pop
    //   324: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   327: astore #5
    //   329: aload #5
    //   331: putstatic com/google/android/gms/dynamite/DynamiteModule.zza : Ljava/lang/Boolean;
    //   334: ldc com/google/android/gms/dynamite/DynamiteModule
    //   336: monitorexit
    //   337: aload #5
    //   339: invokevirtual booleanValue : ()Z
    //   342: istore #4
    //   344: iload #4
    //   346: ifeq -> 405
    //   349: aload_0
    //   350: aload_1
    //   351: iload_2
    //   352: invokestatic zzc : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   355: istore_3
    //   356: iload_3
    //   357: ireturn
    //   358: astore_1
    //   359: aload_1
    //   360: invokevirtual getMessage : ()Ljava/lang/String;
    //   363: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   366: astore_1
    //   367: aload_1
    //   368: invokevirtual length : ()I
    //   371: ifeq -> 385
    //   374: ldc_w 'Failed to retrieve remote module version: '
    //   377: aload_1
    //   378: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   381: astore_1
    //   382: goto -> 396
    //   385: new java/lang/String
    //   388: dup
    //   389: ldc_w 'Failed to retrieve remote module version: '
    //   392: invokespecial <init> : (Ljava/lang/String;)V
    //   395: astore_1
    //   396: ldc 'DynamiteModule'
    //   398: aload_1
    //   399: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   402: pop
    //   403: iconst_0
    //   404: ireturn
    //   405: aload_0
    //   406: aload_1
    //   407: iload_2
    //   408: invokestatic zzb : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   411: istore_3
    //   412: iload_3
    //   413: ireturn
    //   414: astore_1
    //   415: ldc com/google/android/gms/dynamite/DynamiteModule
    //   417: monitorexit
    //   418: aload_1
    //   419: athrow
    //   420: astore_1
    //   421: aload_0
    //   422: aload_1
    //   423: invokestatic addDynamiteErrorToDropBox : (Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   426: pop
    //   427: aload_1
    //   428: athrow
    //   429: astore #5
    //   431: goto -> 87
    //   434: astore #5
    //   436: goto -> 229
    // Exception table:
    //   from	to	target	type
    //   0	3	420	finally
    //   3	8	414	finally
    //   17	50	267	java/lang/ClassNotFoundException
    //   17	50	262	java/lang/IllegalAccessException
    //   17	50	257	java/lang/NoSuchFieldException
    //   17	50	414	finally
    //   50	61	249	finally
    //   66	79	249	finally
    //   82	87	429	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   82	87	249	finally
    //   87	92	249	finally
    //   95	125	249	finally
    //   128	150	434	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   128	150	249	finally
    //   153	176	434	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   153	176	249	finally
    //   179	194	434	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   179	194	249	finally
    //   194	213	434	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   194	213	249	finally
    //   213	216	249	finally
    //   216	219	414	finally
    //   221	224	249	finally
    //   224	227	414	finally
    //   229	243	249	finally
    //   243	246	249	finally
    //   251	254	249	finally
    //   254	257	267	java/lang/ClassNotFoundException
    //   254	257	262	java/lang/IllegalAccessException
    //   254	257	257	java/lang/NoSuchFieldException
    //   254	257	414	finally
    //   269	329	414	finally
    //   329	334	414	finally
    //   334	337	414	finally
    //   337	344	420	finally
    //   349	356	358	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   349	356	420	finally
    //   359	382	420	finally
    //   385	396	420	finally
    //   396	403	420	finally
    //   405	412	420	finally
    //   415	418	414	finally
    //   418	420	420	finally
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString) {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Selected local version of ".concat(paramString);
    } else {
      paramString = new String("Selected local version of ");
    } 
    Log.i("DynamiteModule", paramString);
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt) throws LoadingException {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zza : Ljava/lang/Boolean;
    //   6: astore_3
    //   7: ldc com/google/android/gms/dynamite/DynamiteModule
    //   9: monitorexit
    //   10: aload_3
    //   11: ifnull -> 187
    //   14: aload_3
    //   15: invokevirtual booleanValue : ()Z
    //   18: ifeq -> 28
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokestatic zzb : (Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   27: areturn
    //   28: new java/lang/StringBuilder
    //   31: dup
    //   32: aload_1
    //   33: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual length : ()I
    //   39: bipush #51
    //   41: iadd
    //   42: invokespecial <init> : (I)V
    //   45: astore_3
    //   46: aload_3
    //   47: ldc_w 'Selected remote version of '
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: aload_1
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_3
    //   61: ldc_w ', version >= '
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_3
    //   69: iload_2
    //   70: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: ldc 'DynamiteModule'
    //   76: aload_3
    //   77: invokevirtual toString : ()Ljava/lang/String;
    //   80: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   83: pop
    //   84: aload_0
    //   85: invokestatic zza : (Landroid/content/Context;)Lcom/google/android/gms/dynamite/zzk;
    //   88: astore_3
    //   89: aload_3
    //   90: ifnull -> 175
    //   93: aload_3
    //   94: invokeinterface zzb : ()I
    //   99: iconst_2
    //   100: if_icmplt -> 119
    //   103: aload_3
    //   104: aload_0
    //   105: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   108: aload_1
    //   109: iload_2
    //   110: invokeinterface zzb : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;I)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   115: astore_1
    //   116: goto -> 141
    //   119: ldc 'DynamiteModule'
    //   121: ldc_w 'Dynamite loader version < 2, falling back to createModuleContext'
    //   124: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   127: pop
    //   128: aload_3
    //   129: aload_0
    //   130: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   133: aload_1
    //   134: iload_2
    //   135: invokeinterface zza : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;I)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   140: astore_1
    //   141: aload_1
    //   142: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   145: ifnull -> 163
    //   148: new com/google/android/gms/dynamite/DynamiteModule
    //   151: dup
    //   152: aload_1
    //   153: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   156: checkcast android/content/Context
    //   159: invokespecial <init> : (Landroid/content/Context;)V
    //   162: areturn
    //   163: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   166: dup
    //   167: ldc_w 'Failed to load remote module.'
    //   170: aconst_null
    //   171: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzb;)V
    //   174: athrow
    //   175: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   178: dup
    //   179: ldc_w 'Failed to create IDynamiteLoader.'
    //   182: aconst_null
    //   183: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzb;)V
    //   186: athrow
    //   187: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   190: dup
    //   191: ldc_w 'Failed to determine which loading route to use.'
    //   194: aconst_null
    //   195: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzb;)V
    //   198: athrow
    //   199: astore_1
    //   200: ldc com/google/android/gms/dynamite/DynamiteModule
    //   202: monitorexit
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: aload_1
    //   208: invokestatic addDynamiteErrorToDropBox : (Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   211: pop
    //   212: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   215: dup
    //   216: ldc_w 'Failed to load remote module.'
    //   219: aload_1
    //   220: aconst_null
    //   221: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzb;)V
    //   224: athrow
    //   225: astore_0
    //   226: aload_0
    //   227: athrow
    //   228: astore_0
    //   229: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   232: dup
    //   233: ldc_w 'Failed to load remote module.'
    //   236: aload_0
    //   237: aconst_null
    //   238: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzb;)V
    //   241: athrow
    // Exception table:
    //   from	to	target	type
    //   0	3	228	android/os/RemoteException
    //   0	3	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   0	3	205	finally
    //   3	10	199	finally
    //   14	28	228	android/os/RemoteException
    //   14	28	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   14	28	205	finally
    //   28	89	228	android/os/RemoteException
    //   28	89	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   28	89	205	finally
    //   93	116	228	android/os/RemoteException
    //   93	116	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   93	116	205	finally
    //   119	141	228	android/os/RemoteException
    //   119	141	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   119	141	205	finally
    //   141	163	228	android/os/RemoteException
    //   141	163	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   141	163	205	finally
    //   163	175	228	android/os/RemoteException
    //   163	175	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   163	175	205	finally
    //   175	187	228	android/os/RemoteException
    //   175	187	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   175	187	205	finally
    //   187	199	228	android/os/RemoteException
    //   187	199	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   187	199	205	finally
    //   200	203	199	finally
    //   203	205	228	android/os/RemoteException
    //   203	205	225	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   203	205	205	finally
  }
  
  private static zzk zza(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzb : Lcom/google/android/gms/dynamite/zzk;
    //   6: ifnull -> 18
    //   9: getstatic com/google/android/gms/dynamite/DynamiteModule.zzb : Lcom/google/android/gms/dynamite/zzk;
    //   12: astore_0
    //   13: ldc com/google/android/gms/dynamite/DynamiteModule
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: aload_0
    //   19: ldc_w 'com.google.android.gms'
    //   22: iconst_3
    //   23: invokevirtual createPackageContext : (Ljava/lang/String;I)Landroid/content/Context;
    //   26: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   29: ldc_w 'com.google.android.gms.chimera.container.DynamiteLoaderImpl'
    //   32: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   35: invokevirtual newInstance : ()Ljava/lang/Object;
    //   38: checkcast android/os/IBinder
    //   41: astore_0
    //   42: aload_0
    //   43: ifnonnull -> 51
    //   46: aconst_null
    //   47: astore_0
    //   48: goto -> 85
    //   51: aload_0
    //   52: ldc_w 'com.google.android.gms.dynamite.IDynamiteLoader'
    //   55: invokeinterface queryLocalInterface : (Ljava/lang/String;)Landroid/os/IInterface;
    //   60: astore_1
    //   61: aload_1
    //   62: instanceof com/google/android/gms/dynamite/zzk
    //   65: ifeq -> 76
    //   68: aload_1
    //   69: checkcast com/google/android/gms/dynamite/zzk
    //   72: astore_0
    //   73: goto -> 85
    //   76: new com/google/android/gms/dynamite/zzj
    //   79: dup
    //   80: aload_0
    //   81: invokespecial <init> : (Landroid/os/IBinder;)V
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull -> 143
    //   89: aload_0
    //   90: putstatic com/google/android/gms/dynamite/DynamiteModule.zzb : Lcom/google/android/gms/dynamite/zzk;
    //   93: ldc com/google/android/gms/dynamite/DynamiteModule
    //   95: monitorexit
    //   96: aload_0
    //   97: areturn
    //   98: astore_0
    //   99: aload_0
    //   100: invokevirtual getMessage : ()Ljava/lang/String;
    //   103: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   106: astore_0
    //   107: aload_0
    //   108: invokevirtual length : ()I
    //   111: ifeq -> 125
    //   114: ldc_w 'Failed to load IDynamiteLoader from GmsCore: '
    //   117: aload_0
    //   118: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   121: astore_0
    //   122: goto -> 136
    //   125: new java/lang/String
    //   128: dup
    //   129: ldc_w 'Failed to load IDynamiteLoader from GmsCore: '
    //   132: invokespecial <init> : (Ljava/lang/String;)V
    //   135: astore_0
    //   136: ldc 'DynamiteModule'
    //   138: aload_0
    //   139: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   142: pop
    //   143: ldc com/google/android/gms/dynamite/DynamiteModule
    //   145: monitorexit
    //   146: aconst_null
    //   147: areturn
    //   148: astore_0
    //   149: ldc com/google/android/gms/dynamite/DynamiteModule
    //   151: monitorexit
    //   152: aload_0
    //   153: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	148	finally
    //   18	42	98	java/lang/Exception
    //   18	42	148	finally
    //   51	73	98	java/lang/Exception
    //   51	73	148	finally
    //   76	85	98	java/lang/Exception
    //   76	85	148	finally
    //   89	93	98	java/lang/Exception
    //   89	93	148	finally
    //   93	96	148	finally
    //   99	122	148	finally
    //   125	136	148	finally
    //   136	143	148	finally
    //   143	146	148	finally
    //   149	152	148	finally
  }
  
  private static Boolean zza() {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zze : I
    //   6: iconst_2
    //   7: if_icmplt -> 29
    //   10: iconst_1
    //   11: istore_0
    //   12: goto -> 15
    //   15: ldc com/google/android/gms/dynamite/DynamiteModule
    //   17: monitorexit
    //   18: iload_0
    //   19: invokestatic valueOf : (Z)Ljava/lang/Boolean;
    //   22: areturn
    //   23: astore_1
    //   24: ldc com/google/android/gms/dynamite/DynamiteModule
    //   26: monitorexit
    //   27: aload_1
    //   28: athrow
    //   29: iconst_0
    //   30: istore_0
    //   31: goto -> 15
    // Exception table:
    //   from	to	target	type
    //   3	10	23	finally
    //   15	23	23	finally
    //   24	27	23	finally
  }
  
  private static void zza(ClassLoader paramClassLoader) throws LoadingException {
    try {
      zzm zzm1;
      IBinder iBinder = paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
      if (iBinder == null) {
        iBinder = null;
      } else {
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        if (iInterface instanceof zzm) {
          zzm1 = (zzm)iInterface;
        } else {
          zzm1 = new zzl((IBinder)zzm1);
        } 
      } 
      zzc = zzm1;
      return;
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (IllegalAccessException illegalAccessException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (InvocationTargetException invocationTargetException) {
    
    } catch (NoSuchMethodException noSuchMethodException) {}
    throw new LoadingException("Failed to instantiate dynamite loader", noSuchMethodException, null);
  }
  
  private static int zzb(Context paramContext, String paramString, boolean paramBoolean) {
    zzk zzk1 = zza(paramContext);
    if (zzk1 == null)
      return 0; 
    try {
      if (zzk1.zzb() >= 2)
        return zzk1.zzb(ObjectWrapper.wrap(paramContext), paramString, paramBoolean); 
      Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
      return zzk1.zza(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
    } catch (RemoteException remoteException) {
      String str = String.valueOf(remoteException.getMessage());
      if (str.length() != 0) {
        str = "Failed to retrieve remote module version: ".concat(str);
      } else {
        str = new String("Failed to retrieve remote module version: ");
      } 
      Log.w("DynamiteModule", str);
      return 0;
    } 
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt) throws LoadingException, RemoteException {
    // Byte code:
    //   0: new java/lang/StringBuilder
    //   3: dup
    //   4: aload_1
    //   5: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   8: invokevirtual length : ()I
    //   11: bipush #51
    //   13: iadd
    //   14: invokespecial <init> : (I)V
    //   17: astore_3
    //   18: aload_3
    //   19: ldc_w 'Selected remote version of '
    //   22: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_3
    //   27: aload_1
    //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_3
    //   33: ldc_w ', version >= '
    //   36: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload_3
    //   41: iload_2
    //   42: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc 'DynamiteModule'
    //   48: aload_3
    //   49: invokevirtual toString : ()Ljava/lang/String;
    //   52: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   55: pop
    //   56: ldc com/google/android/gms/dynamite/DynamiteModule
    //   58: monitorenter
    //   59: getstatic com/google/android/gms/dynamite/DynamiteModule.zzc : Lcom/google/android/gms/dynamite/zzm;
    //   62: astore_3
    //   63: ldc com/google/android/gms/dynamite/DynamiteModule
    //   65: monitorexit
    //   66: aload_3
    //   67: ifnull -> 222
    //   70: getstatic com/google/android/gms/dynamite/DynamiteModule.zzf : Ljava/lang/ThreadLocal;
    //   73: invokevirtual get : ()Ljava/lang/Object;
    //   76: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
    //   79: astore #4
    //   81: aload #4
    //   83: ifnull -> 210
    //   86: aload #4
    //   88: getfield zza : Landroid/database/Cursor;
    //   91: ifnull -> 210
    //   94: aload_0
    //   95: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   98: astore_0
    //   99: aload #4
    //   101: getfield zza : Landroid/database/Cursor;
    //   104: astore #4
    //   106: aconst_null
    //   107: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   110: pop
    //   111: invokestatic zza : ()Ljava/lang/Boolean;
    //   114: invokevirtual booleanValue : ()Z
    //   117: ifeq -> 150
    //   120: ldc 'DynamiteModule'
    //   122: ldc_w 'Dynamite loader version >= 2, using loadModule2NoCrashUtils'
    //   125: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   128: pop
    //   129: aload_3
    //   130: aload_0
    //   131: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   134: aload_1
    //   135: iload_2
    //   136: aload #4
    //   138: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   141: invokeinterface zzb : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ILcom/google/android/gms/dynamic/IObjectWrapper;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   146: astore_0
    //   147: goto -> 177
    //   150: ldc 'DynamiteModule'
    //   152: ldc_w 'Dynamite loader version < 2, falling back to loadModule2'
    //   155: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   158: pop
    //   159: aload_3
    //   160: aload_0
    //   161: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   164: aload_1
    //   165: iload_2
    //   166: aload #4
    //   168: invokestatic wrap : (Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   171: invokeinterface zza : (Lcom/google/android/gms/dynamic/IObjectWrapper;Ljava/lang/String;ILcom/google/android/gms/dynamic/IObjectWrapper;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   176: astore_0
    //   177: aload_0
    //   178: invokestatic unwrap : (Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   181: checkcast android/content/Context
    //   184: astore_0
    //   185: aload_0
    //   186: ifnull -> 198
    //   189: new com/google/android/gms/dynamite/DynamiteModule
    //   192: dup
    //   193: aload_0
    //   194: invokespecial <init> : (Landroid/content/Context;)V
    //   197: areturn
    //   198: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   201: dup
    //   202: ldc_w 'Failed to get module context'
    //   205: aconst_null
    //   206: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzb;)V
    //   209: athrow
    //   210: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   213: dup
    //   214: ldc_w 'No result cursor'
    //   217: aconst_null
    //   218: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzb;)V
    //   221: athrow
    //   222: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   225: dup
    //   226: ldc_w 'DynamiteLoaderV2 was not cached.'
    //   229: aconst_null
    //   230: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzb;)V
    //   233: athrow
    //   234: astore_0
    //   235: ldc com/google/android/gms/dynamite/DynamiteModule
    //   237: monitorexit
    //   238: aload_0
    //   239: athrow
    // Exception table:
    //   from	to	target	type
    //   59	66	234	finally
    //   235	238	234	finally
  }
  
  private static int zzc(Context paramContext, String paramString, boolean paramBoolean) throws LoadingException {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aload_0
    //   4: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   7: astore #6
    //   9: iload_2
    //   10: ifeq -> 295
    //   13: ldc_w 'api_force_staging'
    //   16: astore_0
    //   17: goto -> 20
    //   20: new java/lang/StringBuilder
    //   23: dup
    //   24: aload_0
    //   25: invokevirtual length : ()I
    //   28: bipush #42
    //   30: iadd
    //   31: aload_1
    //   32: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   35: invokevirtual length : ()I
    //   38: iadd
    //   39: invokespecial <init> : (I)V
    //   42: astore #7
    //   44: aload #7
    //   46: ldc_w 'content://com.google.android.gms.chimera/'
    //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload #7
    //   55: aload_0
    //   56: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload #7
    //   62: ldc_w '/'
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #7
    //   71: aload_1
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload #6
    //   78: aload #7
    //   80: invokevirtual toString : ()Ljava/lang/String;
    //   83: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: aconst_null
    //   90: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore_0
    //   94: aload_0
    //   95: ifnull -> 221
    //   98: aload_0
    //   99: invokeinterface moveToFirst : ()Z
    //   104: ifeq -> 221
    //   107: aload_0
    //   108: iconst_0
    //   109: invokeinterface getInt : (I)I
    //   114: istore_3
    //   115: aload_0
    //   116: astore_1
    //   117: iload_3
    //   118: ifle -> 209
    //   121: ldc com/google/android/gms/dynamite/DynamiteModule
    //   123: monitorenter
    //   124: aload_0
    //   125: iconst_2
    //   126: invokeinterface getString : (I)Ljava/lang/String;
    //   131: putstatic com/google/android/gms/dynamite/DynamiteModule.zzd : Ljava/lang/String;
    //   134: aload_0
    //   135: ldc_w 'loaderVersion'
    //   138: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   143: istore #4
    //   145: iload #4
    //   147: iflt -> 161
    //   150: aload_0
    //   151: iload #4
    //   153: invokeinterface getInt : (I)I
    //   158: putstatic com/google/android/gms/dynamite/DynamiteModule.zze : I
    //   161: ldc com/google/android/gms/dynamite/DynamiteModule
    //   163: monitorexit
    //   164: getstatic com/google/android/gms/dynamite/DynamiteModule.zzf : Ljava/lang/ThreadLocal;
    //   167: invokevirtual get : ()Ljava/lang/Object;
    //   170: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
    //   173: astore #5
    //   175: aload_0
    //   176: astore_1
    //   177: aload #5
    //   179: ifnull -> 209
    //   182: aload_0
    //   183: astore_1
    //   184: aload #5
    //   186: getfield zza : Landroid/database/Cursor;
    //   189: ifnonnull -> 209
    //   192: aload #5
    //   194: aload_0
    //   195: putfield zza : Landroid/database/Cursor;
    //   198: aconst_null
    //   199: astore_1
    //   200: goto -> 209
    //   203: astore_1
    //   204: ldc com/google/android/gms/dynamite/DynamiteModule
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    //   209: aload_1
    //   210: ifnull -> 219
    //   213: aload_1
    //   214: invokeinterface close : ()V
    //   219: iload_3
    //   220: ireturn
    //   221: ldc 'DynamiteModule'
    //   223: ldc_w 'Failed to retrieve remote module version.'
    //   226: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   229: pop
    //   230: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   233: dup
    //   234: ldc_w 'Failed to connect to dynamite module ContentResolver.'
    //   237: aconst_null
    //   238: invokespecial <init> : (Ljava/lang/String;Lcom/google/android/gms/dynamite/zzb;)V
    //   241: athrow
    //   242: astore_1
    //   243: goto -> 283
    //   246: astore_1
    //   247: goto -> 260
    //   250: astore_1
    //   251: aload #5
    //   253: astore_0
    //   254: goto -> 283
    //   257: astore_1
    //   258: aconst_null
    //   259: astore_0
    //   260: aload_1
    //   261: instanceof com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   264: ifeq -> 269
    //   267: aload_1
    //   268: athrow
    //   269: new com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   272: dup
    //   273: ldc_w 'V2 version check failed'
    //   276: aload_1
    //   277: aconst_null
    //   278: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zzb;)V
    //   281: athrow
    //   282: astore_1
    //   283: aload_0
    //   284: ifnull -> 293
    //   287: aload_0
    //   288: invokeinterface close : ()V
    //   293: aload_1
    //   294: athrow
    //   295: ldc_w 'api'
    //   298: astore_0
    //   299: goto -> 20
    // Exception table:
    //   from	to	target	type
    //   3	9	257	java/lang/Exception
    //   3	9	250	finally
    //   20	94	257	java/lang/Exception
    //   20	94	250	finally
    //   98	115	246	java/lang/Exception
    //   98	115	242	finally
    //   121	124	246	java/lang/Exception
    //   121	124	242	finally
    //   124	145	203	finally
    //   150	161	203	finally
    //   161	164	203	finally
    //   164	175	246	java/lang/Exception
    //   164	175	242	finally
    //   184	198	246	java/lang/Exception
    //   184	198	242	finally
    //   204	207	203	finally
    //   207	209	246	java/lang/Exception
    //   207	209	242	finally
    //   221	242	246	java/lang/Exception
    //   221	242	242	finally
    //   260	269	282	finally
    //   269	282	282	finally
  }
  
  public final Context getModuleContext() {
    return this.zzi;
  }
  
  public final IBinder instantiate(String paramString) throws LoadingException {
    try {
      return (IBinder)this.zzi.getClassLoader().loadClass(paramString).newInstance();
    } catch (ClassNotFoundException classNotFoundException) {
    
    } catch (InstantiationException instantiationException) {
    
    } catch (IllegalAccessException illegalAccessException) {}
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Failed to instantiate module class: ".concat(paramString);
    } else {
      paramString = new String("Failed to instantiate module class: ");
    } 
    throw new LoadingException(paramString, illegalAccessException, null);
  }
  
  public static class DynamiteLoaderClassLoader {
    public static ClassLoader sClassLoader;
  }
  
  public static class LoadingException extends Exception {
    private LoadingException(String param1String) {
      super(param1String);
    }
    
    private LoadingException(String param1String, Throwable param1Throwable) {
      super(param1String, param1Throwable);
    }
  }
  
  public static interface VersionPolicy {
    zza zza(Context param1Context, String param1String, zzb param1zzb) throws DynamiteModule.LoadingException;
    
    public static final class zza {
      public int zza = 0;
      
      public int zzb = 0;
      
      public int zzc = 0;
    }
    
    public static interface zzb {
      int zza(Context param2Context, String param2String);
      
      int zza(Context param2Context, String param2String, boolean param2Boolean) throws DynamiteModule.LoadingException;
    }
  }
  
  public static final class zza {
    public int zza = 0;
    
    public int zzb = 0;
    
    public int zzc = 0;
  }
  
  public static interface zzb {
    int zza(Context param1Context, String param1String);
    
    int zza(Context param1Context, String param1String, boolean param1Boolean) throws DynamiteModule.LoadingException;
  }
  
  static final class zza {
    public Cursor zza;
    
    private zza() {}
  }
  
  static final class zzb implements VersionPolicy.zzb {
    private final int zza;
    
    private final int zzb;
    
    public zzb(int param1Int1, int param1Int2) {
      this.zza = param1Int1;
      this.zzb = 0;
    }
    
    public final int zza(Context param1Context, String param1String) {
      return this.zza;
    }
    
    public final int zza(Context param1Context, String param1String, boolean param1Boolean) {
      return 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\google\android\gms\dynamite\DynamiteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */