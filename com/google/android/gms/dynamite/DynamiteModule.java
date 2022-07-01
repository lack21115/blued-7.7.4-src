package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import java.lang.reflect.Field;

public final class DynamiteModule {
  private static Boolean zzhdc;
  
  private static zzk zzhdd;
  
  private static zzm zzhde;
  
  private static String zzhdf;
  
  private static final ThreadLocal zzhdg = new ThreadLocal();
  
  private static final zzi zzhdh = new zza();
  
  public static final DynamiteModule$zzd zzhdm = new zzf();
  
  private final Context zzhdo;
  
  static {
    new zzg();
    throw new VerifyError("bad dex opcode");
  }
  
  private DynamiteModule(Context paramContext) {
    this.zzhdo = (Context)zzbq.checkNotNull(paramContext);
  }
  
  private static Context zza(Context paramContext, String paramString, int paramInt, Cursor paramCursor, zzm paramzzm) {
    try {
      return (Context)zzn.zzy(paramzzm.zza(zzn.zzz(paramContext), paramString, paramInt, zzn.zzz(paramCursor)));
    } catch (Exception exception) {
      String str = String.valueOf(exception.toString());
      if (str.length() != 0) {
        str = "Failed to load DynamiteLoader: ".concat(str);
      } else {
        str = new String("Failed to load DynamiteLoader: ");
      } 
      Log.e("DynamiteModule", str);
      return null;
    } 
  }
  
  public static DynamiteModule zza(Context paramContext, DynamiteModule$zzd paramDynamiteModule$zzd, String paramString) {
    DynamiteModule$zza dynamiteModule$zza1 = zzhdg.get();
    DynamiteModule$zza dynamiteModule$zza2 = new DynamiteModule$zza((byte)0);
    zzhdg.set(dynamiteModule$zza2);
    try {
      StringBuilder stringBuilder1;
      zzj zzj = paramDynamiteModule$zzd.zza(paramContext, paramString, zzhdh);
      int i = zzj.zzhds;
      int j = zzj.zzhdt;
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
      if (zzj.zzhdu != 0 && (zzj.zzhdu != -1 || zzj.zzhds != 0) && (zzj.zzhdu != 1 || zzj.zzhdt != 0)) {
        DynamiteModule dynamiteModule;
        if (zzj.zzhdu == -1) {
          DynamiteModule dynamiteModule1 = zzz(paramContext, paramString);
          dynamiteModule = dynamiteModule1;
          if (dynamiteModule$zza2.zzhdp != null) {
            dynamiteModule = dynamiteModule1;
          } else {
            return dynamiteModule;
          } 
        } else {
          i = zzj.zzhdu;
          if (i == 1) {
            try {
              return zza((Context)dynamiteModule, paramString, zzj.zzhdt);
            } catch (DynamiteModule$zzc dynamiteModule$zzc) {}
          } else {
            i = zzj.zzhdu;
            stringBuilder1 = new StringBuilder(47);
            stringBuilder1.append("VersionPolicy returned invalid code:");
            stringBuilder1.append(i);
            throw new DynamiteModule$zzc(stringBuilder1.toString(), (byte)0);
          } 
        } 
      } else {
        i = zzj.zzhds;
        j = zzj.zzhdt;
        stringBuilder1 = new StringBuilder(91);
        stringBuilder1.append("No acceptable module found. Local version is ");
        stringBuilder1.append(i);
        stringBuilder1.append(" and remote version is ");
        stringBuilder1.append(j);
        stringBuilder1.append(".");
        throw new DynamiteModule$zzc(stringBuilder1.toString(), (byte)0);
      } 
      return (DynamiteModule)stringBuilder1;
    } finally {
      if (dynamiteModule$zza2.zzhdp != null)
        dynamiteModule$zza2.zzhdp.close(); 
      zzhdg.set(dynamiteModule$zza1);
    } 
  }
  
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdc : Ljava/lang/Boolean;
    //   6: astore_3
    //   7: ldc com/google/android/gms/dynamite/DynamiteModule
    //   9: monitorexit
    //   10: aload_3
    //   11: ifnull -> 35
    //   14: aload_3
    //   15: invokevirtual booleanValue : ()Z
    //   18: ifeq -> 28
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokestatic zzc : (Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   27: areturn
    //   28: aload_0
    //   29: aload_1
    //   30: iload_2
    //   31: invokestatic zzb : (Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   34: areturn
    //   35: new com/google/android/gms/dynamite/DynamiteModule$zzc
    //   38: dup
    //   39: ldc 'Failed to determine which loading route to use.'
    //   41: iconst_0
    //   42: invokespecial <init> : (Ljava/lang/String;B)V
    //   45: athrow
    //   46: astore_0
    //   47: ldc com/google/android/gms/dynamite/DynamiteModule
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Exception table:
    //   from	to	target	type
    //   3	10	46	finally
    //   47	50	46	finally
  }
  
  private static void zza(ClassLoader paramClassLoader) {
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
          zzm1 = new zzn((IBinder)zzm1);
        } 
      } 
      zzhde = zzm1;
      return;
    } catch (ClassNotFoundException|IllegalAccessException|InstantiationException|java.lang.reflect.InvocationTargetException|NoSuchMethodException classNotFoundException) {
      throw new DynamiteModule$zzc("Failed to instantiate dynamite loader", classNotFoundException, (byte)0);
    } 
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt) {
    StringBuilder stringBuilder = new StringBuilder(String.valueOf(paramString).length() + 51);
    stringBuilder.append("Selected remote version of ");
    stringBuilder.append(paramString);
    stringBuilder.append(", version >= ");
    stringBuilder.append(paramInt);
    Log.i("DynamiteModule", stringBuilder.toString());
    zzk zzk1 = zzdh(paramContext);
    if (zzk1 != null)
      try {
        IObjectWrapper iObjectWrapper = zzk1.zza(zzn.zzz(paramContext), paramString, paramInt);
        if (zzn.zzy(iObjectWrapper) != null)
          return new DynamiteModule((Context)zzn.zzy(iObjectWrapper)); 
        throw new DynamiteModule$zzc("Failed to load remote module.", (byte)0);
      } catch (RemoteException remoteException) {
        throw new DynamiteModule$zzc("Failed to load remote module.", remoteException, (byte)0);
      }  
    throw new DynamiteModule$zzc("Failed to create IDynamiteLoader.", (byte)0);
  }
  
  public static int zzc(Context paramContext, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdc : Ljava/lang/Boolean;
    //   6: astore #5
    //   8: aload #5
    //   10: astore #4
    //   12: aload #5
    //   14: ifnonnull -> 296
    //   17: aload_0
    //   18: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   21: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   24: ldc_w com/google/android/gms/dynamite/DynamiteModule$DynamiteLoaderClassLoader
    //   27: invokevirtual getName : ()Ljava/lang/String;
    //   30: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   33: astore #5
    //   35: aload #5
    //   37: ldc_w 'sClassLoader'
    //   40: invokevirtual getDeclaredField : (Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   43: astore #4
    //   45: aload #5
    //   47: monitorenter
    //   48: aload #4
    //   50: aconst_null
    //   51: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   54: checkcast java/lang/ClassLoader
    //   57: astore #6
    //   59: aload #6
    //   61: ifnull -> 98
    //   64: aload #6
    //   66: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   69: if_acmpne -> 80
    //   72: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   75: astore #4
    //   77: goto -> 215
    //   80: aload #6
    //   82: invokestatic zza : (Ljava/lang/ClassLoader;)V
    //   85: goto -> 90
    //   88: astore #4
    //   90: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   93: astore #4
    //   95: goto -> 215
    //   98: ldc_w 'com.google.android.gms'
    //   101: aload_0
    //   102: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   105: invokevirtual getPackageName : ()Ljava/lang/String;
    //   108: invokevirtual equals : (Ljava/lang/Object;)Z
    //   111: ifeq -> 126
    //   114: aload #4
    //   116: aconst_null
    //   117: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   120: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   123: goto -> 72
    //   126: aload_0
    //   127: aload_1
    //   128: iload_2
    //   129: invokestatic zze : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   132: istore_3
    //   133: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdf : Ljava/lang/String;
    //   136: ifnull -> 193
    //   139: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdf : Ljava/lang/String;
    //   142: invokevirtual isEmpty : ()Z
    //   145: ifeq -> 151
    //   148: goto -> 193
    //   151: new com/google/android/gms/dynamite/zzh
    //   154: dup
    //   155: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdf : Ljava/lang/String;
    //   158: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   161: invokespecial <init> : (Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   164: astore #6
    //   166: aload #6
    //   168: invokestatic zza : (Ljava/lang/ClassLoader;)V
    //   171: aload #4
    //   173: aconst_null
    //   174: aload #6
    //   176: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   179: getstatic java/lang/Boolean.TRUE : Ljava/lang/Boolean;
    //   182: putstatic com/google/android/gms/dynamite/DynamiteModule.zzhdc : Ljava/lang/Boolean;
    //   185: aload #5
    //   187: monitorexit
    //   188: ldc com/google/android/gms/dynamite/DynamiteModule
    //   190: monitorexit
    //   191: iload_3
    //   192: ireturn
    //   193: aload #5
    //   195: monitorexit
    //   196: ldc com/google/android/gms/dynamite/DynamiteModule
    //   198: monitorexit
    //   199: iload_3
    //   200: ireturn
    //   201: astore #6
    //   203: aload #4
    //   205: aconst_null
    //   206: invokestatic getSystemClassLoader : ()Ljava/lang/ClassLoader;
    //   209: invokevirtual set : (Ljava/lang/Object;Ljava/lang/Object;)V
    //   212: goto -> 72
    //   215: aload #5
    //   217: monitorexit
    //   218: goto -> 291
    //   221: astore #4
    //   223: aload #5
    //   225: monitorexit
    //   226: aload #4
    //   228: athrow
    //   229: astore #4
    //   231: aload #4
    //   233: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   236: astore #4
    //   238: new java/lang/StringBuilder
    //   241: dup
    //   242: aload #4
    //   244: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   247: invokevirtual length : ()I
    //   250: bipush #30
    //   252: iadd
    //   253: invokespecial <init> : (I)V
    //   256: astore #5
    //   258: aload #5
    //   260: ldc_w 'Failed to load module via V2: '
    //   263: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload #5
    //   269: aload #4
    //   271: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: ldc 'DynamiteModule'
    //   277: aload #5
    //   279: invokevirtual toString : ()Ljava/lang/String;
    //   282: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   285: pop
    //   286: getstatic java/lang/Boolean.FALSE : Ljava/lang/Boolean;
    //   289: astore #4
    //   291: aload #4
    //   293: putstatic com/google/android/gms/dynamite/DynamiteModule.zzhdc : Ljava/lang/Boolean;
    //   296: ldc com/google/android/gms/dynamite/DynamiteModule
    //   298: monitorexit
    //   299: aload #4
    //   301: invokevirtual booleanValue : ()Z
    //   304: ifeq -> 363
    //   307: aload_0
    //   308: aload_1
    //   309: iload_2
    //   310: invokestatic zze : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   313: istore_3
    //   314: iload_3
    //   315: ireturn
    //   316: astore_0
    //   317: aload_0
    //   318: invokevirtual getMessage : ()Ljava/lang/String;
    //   321: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   324: astore_0
    //   325: aload_0
    //   326: invokevirtual length : ()I
    //   329: ifeq -> 343
    //   332: ldc_w 'Failed to retrieve remote module version: '
    //   335: aload_0
    //   336: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   339: astore_0
    //   340: goto -> 354
    //   343: new java/lang/String
    //   346: dup
    //   347: ldc_w 'Failed to retrieve remote module version: '
    //   350: invokespecial <init> : (Ljava/lang/String;)V
    //   353: astore_0
    //   354: ldc 'DynamiteModule'
    //   356: aload_0
    //   357: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   360: pop
    //   361: iconst_0
    //   362: ireturn
    //   363: aload_0
    //   364: aload_1
    //   365: iload_2
    //   366: invokestatic zzd : (Landroid/content/Context;Ljava/lang/String;Z)I
    //   369: ireturn
    //   370: astore_0
    //   371: ldc com/google/android/gms/dynamite/DynamiteModule
    //   373: monitorexit
    //   374: aload_0
    //   375: athrow
    // Exception table:
    //   from	to	target	type
    //   3	8	370	finally
    //   17	48	229	java/lang/ClassNotFoundException
    //   17	48	229	java/lang/IllegalAccessException
    //   17	48	229	java/lang/NoSuchFieldException
    //   17	48	370	finally
    //   48	59	221	finally
    //   64	72	221	finally
    //   72	77	221	finally
    //   80	85	88	com/google/android/gms/dynamite/DynamiteModule$zzc
    //   80	85	221	finally
    //   90	95	221	finally
    //   98	123	221	finally
    //   126	148	201	com/google/android/gms/dynamite/DynamiteModule$zzc
    //   126	148	221	finally
    //   151	185	201	com/google/android/gms/dynamite/DynamiteModule$zzc
    //   151	185	221	finally
    //   185	188	221	finally
    //   188	191	370	finally
    //   193	196	221	finally
    //   196	199	370	finally
    //   203	212	221	finally
    //   215	218	221	finally
    //   223	226	221	finally
    //   226	229	229	java/lang/ClassNotFoundException
    //   226	229	229	java/lang/IllegalAccessException
    //   226	229	229	java/lang/NoSuchFieldException
    //   226	229	370	finally
    //   231	291	370	finally
    //   291	296	370	finally
    //   296	299	370	finally
    //   307	314	316	com/google/android/gms/dynamite/DynamiteModule$zzc
    //   371	374	370	finally
  }
  
  private static DynamiteModule zzc(Context paramContext, String paramString, int paramInt) {
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
    //   59: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhde : Lcom/google/android/gms/dynamite/zzm;
    //   62: astore_3
    //   63: ldc com/google/android/gms/dynamite/DynamiteModule
    //   65: monitorexit
    //   66: aload_3
    //   67: ifnull -> 147
    //   70: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdg : Ljava/lang/ThreadLocal;
    //   73: invokevirtual get : ()Ljava/lang/Object;
    //   76: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
    //   79: astore #4
    //   81: aload #4
    //   83: ifnull -> 135
    //   86: aload #4
    //   88: getfield zzhdp : Landroid/database/Cursor;
    //   91: ifnull -> 135
    //   94: aload_0
    //   95: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   98: aload_1
    //   99: iload_2
    //   100: aload #4
    //   102: getfield zzhdp : Landroid/database/Cursor;
    //   105: aload_3
    //   106: invokestatic zza : (Landroid/content/Context;Ljava/lang/String;ILandroid/database/Cursor;Lcom/google/android/gms/dynamite/zzm;)Landroid/content/Context;
    //   109: astore_0
    //   110: aload_0
    //   111: ifnull -> 123
    //   114: new com/google/android/gms/dynamite/DynamiteModule
    //   117: dup
    //   118: aload_0
    //   119: invokespecial <init> : (Landroid/content/Context;)V
    //   122: areturn
    //   123: new com/google/android/gms/dynamite/DynamiteModule$zzc
    //   126: dup
    //   127: ldc_w 'Failed to get module context'
    //   130: iconst_0
    //   131: invokespecial <init> : (Ljava/lang/String;B)V
    //   134: athrow
    //   135: new com/google/android/gms/dynamite/DynamiteModule$zzc
    //   138: dup
    //   139: ldc_w 'No result cursor'
    //   142: iconst_0
    //   143: invokespecial <init> : (Ljava/lang/String;B)V
    //   146: athrow
    //   147: new com/google/android/gms/dynamite/DynamiteModule$zzc
    //   150: dup
    //   151: ldc_w 'DynamiteLoaderV2 was not cached.'
    //   154: iconst_0
    //   155: invokespecial <init> : (Ljava/lang/String;B)V
    //   158: athrow
    //   159: astore_0
    //   160: ldc com/google/android/gms/dynamite/DynamiteModule
    //   162: monitorexit
    //   163: aload_0
    //   164: athrow
    // Exception table:
    //   from	to	target	type
    //   59	66	159	finally
    //   160	163	159	finally
  }
  
  private static int zzd(Context paramContext, String paramString, boolean paramBoolean) {
    zzk zzk1 = zzdh(paramContext);
    if (zzk1 == null)
      return 0; 
    try {
      return zzk1.zza(zzn.zzz(paramContext), paramString, paramBoolean);
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
  
  private static zzk zzdh(Context paramContext) {
    // Byte code:
    //   0: ldc com/google/android/gms/dynamite/DynamiteModule
    //   2: monitorenter
    //   3: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdd : Lcom/google/android/gms/dynamite/zzk;
    //   6: ifnull -> 18
    //   9: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdd : Lcom/google/android/gms/dynamite/zzk;
    //   12: astore_0
    //   13: ldc com/google/android/gms/dynamite/DynamiteModule
    //   15: monitorexit
    //   16: aload_0
    //   17: areturn
    //   18: invokestatic zzahf : ()Lcom/google/android/gms/common/zzf;
    //   21: aload_0
    //   22: invokevirtual isGooglePlayServicesAvailable : (Landroid/content/Context;)I
    //   25: ifeq -> 33
    //   28: ldc com/google/android/gms/dynamite/DynamiteModule
    //   30: monitorexit
    //   31: aconst_null
    //   32: areturn
    //   33: aload_0
    //   34: ldc_w 'com.google.android.gms'
    //   37: iconst_3
    //   38: invokevirtual createPackageContext : (Ljava/lang/String;I)Landroid/content/Context;
    //   41: invokevirtual getClassLoader : ()Ljava/lang/ClassLoader;
    //   44: ldc_w 'com.google.android.gms.chimera.container.DynamiteLoaderImpl'
    //   47: invokevirtual loadClass : (Ljava/lang/String;)Ljava/lang/Class;
    //   50: invokevirtual newInstance : ()Ljava/lang/Object;
    //   53: checkcast android/os/IBinder
    //   56: astore_0
    //   57: aload_0
    //   58: ifnonnull -> 66
    //   61: aconst_null
    //   62: astore_0
    //   63: goto -> 100
    //   66: aload_0
    //   67: ldc_w 'com.google.android.gms.dynamite.IDynamiteLoader'
    //   70: invokeinterface queryLocalInterface : (Ljava/lang/String;)Landroid/os/IInterface;
    //   75: astore_1
    //   76: aload_1
    //   77: instanceof com/google/android/gms/dynamite/zzk
    //   80: ifeq -> 91
    //   83: aload_1
    //   84: checkcast com/google/android/gms/dynamite/zzk
    //   87: astore_0
    //   88: goto -> 100
    //   91: new com/google/android/gms/dynamite/zzl
    //   94: dup
    //   95: aload_0
    //   96: invokespecial <init> : (Landroid/os/IBinder;)V
    //   99: astore_0
    //   100: aload_0
    //   101: ifnull -> 158
    //   104: aload_0
    //   105: putstatic com/google/android/gms/dynamite/DynamiteModule.zzhdd : Lcom/google/android/gms/dynamite/zzk;
    //   108: ldc com/google/android/gms/dynamite/DynamiteModule
    //   110: monitorexit
    //   111: aload_0
    //   112: areturn
    //   113: astore_0
    //   114: aload_0
    //   115: invokevirtual getMessage : ()Ljava/lang/String;
    //   118: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   121: astore_0
    //   122: aload_0
    //   123: invokevirtual length : ()I
    //   126: ifeq -> 140
    //   129: ldc_w 'Failed to load IDynamiteLoader from GmsCore: '
    //   132: aload_0
    //   133: invokevirtual concat : (Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_0
    //   137: goto -> 151
    //   140: new java/lang/String
    //   143: dup
    //   144: ldc_w 'Failed to load IDynamiteLoader from GmsCore: '
    //   147: invokespecial <init> : (Ljava/lang/String;)V
    //   150: astore_0
    //   151: ldc 'DynamiteModule'
    //   153: aload_0
    //   154: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: ldc com/google/android/gms/dynamite/DynamiteModule
    //   160: monitorexit
    //   161: aconst_null
    //   162: areturn
    //   163: astore_0
    //   164: ldc com/google/android/gms/dynamite/DynamiteModule
    //   166: monitorexit
    //   167: aload_0
    //   168: athrow
    // Exception table:
    //   from	to	target	type
    //   3	16	163	finally
    //   18	31	163	finally
    //   33	57	113	java/lang/Exception
    //   33	57	163	finally
    //   66	88	113	java/lang/Exception
    //   66	88	163	finally
    //   91	100	113	java/lang/Exception
    //   91	100	163	finally
    //   104	108	113	java/lang/Exception
    //   104	108	163	finally
    //   108	111	163	finally
    //   114	137	163	finally
    //   140	151	163	finally
    //   151	158	163	finally
    //   158	161	163	finally
    //   164	167	163	finally
  }
  
  private static int zze(Context paramContext, String paramString, boolean paramBoolean) {
    // Byte code:
    //   0: aconst_null
    //   1: astore #5
    //   3: aconst_null
    //   4: astore #6
    //   6: aload #6
    //   8: astore #4
    //   10: aload_0
    //   11: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   14: astore #7
    //   16: iload_2
    //   17: ifeq -> 313
    //   20: ldc_w 'api_force_staging'
    //   23: astore_0
    //   24: goto -> 27
    //   27: aload #6
    //   29: astore #4
    //   31: new java/lang/StringBuilder
    //   34: dup
    //   35: aload_0
    //   36: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   39: invokevirtual length : ()I
    //   42: bipush #42
    //   44: iadd
    //   45: aload_1
    //   46: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   49: invokevirtual length : ()I
    //   52: iadd
    //   53: invokespecial <init> : (I)V
    //   56: astore #8
    //   58: aload #6
    //   60: astore #4
    //   62: aload #8
    //   64: ldc_w 'content://com.google.android.gms.chimera/'
    //   67: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload #6
    //   73: astore #4
    //   75: aload #8
    //   77: aload_0
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload #6
    //   84: astore #4
    //   86: aload #8
    //   88: ldc_w '/'
    //   91: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload #6
    //   97: astore #4
    //   99: aload #8
    //   101: aload_1
    //   102: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload #6
    //   108: astore #4
    //   110: aload #7
    //   112: aload #8
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: invokestatic parse : (Ljava/lang/String;)Landroid/net/Uri;
    //   120: aconst_null
    //   121: aconst_null
    //   122: aconst_null
    //   123: aconst_null
    //   124: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   127: astore_0
    //   128: aload_0
    //   129: ifnull -> 239
    //   132: aload_0
    //   133: invokeinterface moveToFirst : ()Z
    //   138: ifeq -> 239
    //   141: aload_0
    //   142: iconst_0
    //   143: invokeinterface getInt : (I)I
    //   148: istore_3
    //   149: aload_0
    //   150: astore_1
    //   151: iload_3
    //   152: ifle -> 216
    //   155: ldc com/google/android/gms/dynamite/DynamiteModule
    //   157: monitorenter
    //   158: aload_0
    //   159: iconst_2
    //   160: invokeinterface getString : (I)Ljava/lang/String;
    //   165: putstatic com/google/android/gms/dynamite/DynamiteModule.zzhdf : Ljava/lang/String;
    //   168: ldc com/google/android/gms/dynamite/DynamiteModule
    //   170: monitorexit
    //   171: getstatic com/google/android/gms/dynamite/DynamiteModule.zzhdg : Ljava/lang/ThreadLocal;
    //   174: invokevirtual get : ()Ljava/lang/Object;
    //   177: checkcast com/google/android/gms/dynamite/DynamiteModule$zza
    //   180: astore #4
    //   182: aload_0
    //   183: astore_1
    //   184: aload #4
    //   186: ifnull -> 216
    //   189: aload_0
    //   190: astore_1
    //   191: aload #4
    //   193: getfield zzhdp : Landroid/database/Cursor;
    //   196: ifnonnull -> 216
    //   199: aload #4
    //   201: aload_0
    //   202: putfield zzhdp : Landroid/database/Cursor;
    //   205: aconst_null
    //   206: astore_1
    //   207: goto -> 216
    //   210: astore_1
    //   211: ldc com/google/android/gms/dynamite/DynamiteModule
    //   213: monitorexit
    //   214: aload_1
    //   215: athrow
    //   216: aload_1
    //   217: ifnull -> 226
    //   220: aload_1
    //   221: invokeinterface close : ()V
    //   226: iload_3
    //   227: ireturn
    //   228: astore_1
    //   229: aload_0
    //   230: astore #4
    //   232: goto -> 299
    //   235: astore_1
    //   236: goto -> 268
    //   239: ldc 'DynamiteModule'
    //   241: ldc_w 'Failed to retrieve remote module version.'
    //   244: invokestatic w : (Ljava/lang/String;Ljava/lang/String;)I
    //   247: pop
    //   248: new com/google/android/gms/dynamite/DynamiteModule$zzc
    //   251: dup
    //   252: ldc_w 'Failed to connect to dynamite module ContentResolver.'
    //   255: iconst_0
    //   256: invokespecial <init> : (Ljava/lang/String;B)V
    //   259: athrow
    //   260: astore_1
    //   261: goto -> 299
    //   264: astore_1
    //   265: aload #5
    //   267: astore_0
    //   268: aload_0
    //   269: astore #4
    //   271: aload_1
    //   272: instanceof com/google/android/gms/dynamite/DynamiteModule$zzc
    //   275: ifeq -> 283
    //   278: aload_0
    //   279: astore #4
    //   281: aload_1
    //   282: athrow
    //   283: aload_0
    //   284: astore #4
    //   286: new com/google/android/gms/dynamite/DynamiteModule$zzc
    //   289: dup
    //   290: ldc_w 'V2 version check failed'
    //   293: aload_1
    //   294: iconst_0
    //   295: invokespecial <init> : (Ljava/lang/String;Ljava/lang/Throwable;B)V
    //   298: athrow
    //   299: aload #4
    //   301: ifnull -> 311
    //   304: aload #4
    //   306: invokeinterface close : ()V
    //   311: aload_1
    //   312: athrow
    //   313: ldc_w 'api'
    //   316: astore_0
    //   317: goto -> 27
    // Exception table:
    //   from	to	target	type
    //   10	16	264	java/lang/Exception
    //   10	16	260	finally
    //   31	58	264	java/lang/Exception
    //   31	58	260	finally
    //   62	71	264	java/lang/Exception
    //   62	71	260	finally
    //   75	82	264	java/lang/Exception
    //   75	82	260	finally
    //   86	95	264	java/lang/Exception
    //   86	95	260	finally
    //   99	106	264	java/lang/Exception
    //   99	106	260	finally
    //   110	128	264	java/lang/Exception
    //   110	128	260	finally
    //   132	149	235	java/lang/Exception
    //   132	149	228	finally
    //   155	158	235	java/lang/Exception
    //   155	158	228	finally
    //   158	171	210	finally
    //   171	182	235	java/lang/Exception
    //   171	182	228	finally
    //   191	205	235	java/lang/Exception
    //   191	205	228	finally
    //   211	214	210	finally
    //   214	216	235	java/lang/Exception
    //   214	216	228	finally
    //   239	260	235	java/lang/Exception
    //   239	260	228	finally
    //   271	278	260	finally
    //   281	283	260	finally
    //   286	299	260	finally
  }
  
  public static int zzx(Context paramContext, String paramString) {
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
  
  private static DynamiteModule zzz(Context paramContext, String paramString) {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Selected local version of ".concat(paramString);
    } else {
      paramString = new String("Selected local version of ");
    } 
    Log.i("DynamiteModule", paramString);
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  public final IBinder zzhk(String paramString) {
    try {
      return (IBinder)this.zzhdo.getClassLoader().loadClass(paramString).newInstance();
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException classNotFoundException) {
      paramString = String.valueOf(paramString);
      if (paramString.length() != 0) {
        paramString = "Failed to instantiate module class: ".concat(paramString);
      } else {
        paramString = new String("Failed to instantiate module class: ");
      } 
      throw new DynamiteModule$zzc(paramString, classNotFoundException, (byte)0);
    } 
  }
  
  static {
    new zzb();
    new zzc();
    new zzd();
    new zze();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\android\gms\dynamite\DynamiteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */