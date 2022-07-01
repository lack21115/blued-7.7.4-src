package com.sina.weibo.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class WeiboAppManager {
  private static final String SDK_INT_FILE_NAME = "weibo_for_sdk.json";
  
  private static final String TAG = WeiboAppManager.class.getName();
  
  private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";
  
  private static final Uri WEIBO_NAME_URI = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");
  
  private static WeiboAppManager sInstance;
  
  private Context mContext;
  
  private WeiboAppManager(Context paramContext) {
    this.mContext = paramContext.getApplicationContext();
  }
  
  public static WeiboAppManager getInstance(Context paramContext) {
    // Byte code:
    //   0: ldc com/sina/weibo/sdk/WeiboAppManager
    //   2: monitorenter
    //   3: getstatic com/sina/weibo/sdk/WeiboAppManager.sInstance : Lcom/sina/weibo/sdk/WeiboAppManager;
    //   6: ifnonnull -> 20
    //   9: new com/sina/weibo/sdk/WeiboAppManager
    //   12: dup
    //   13: aload_0
    //   14: invokespecial <init> : (Landroid/content/Context;)V
    //   17: putstatic com/sina/weibo/sdk/WeiboAppManager.sInstance : Lcom/sina/weibo/sdk/WeiboAppManager;
    //   20: getstatic com/sina/weibo/sdk/WeiboAppManager.sInstance : Lcom/sina/weibo/sdk/WeiboAppManager;
    //   23: astore_0
    //   24: ldc com/sina/weibo/sdk/WeiboAppManager
    //   26: monitorexit
    //   27: aload_0
    //   28: areturn
    //   29: astore_0
    //   30: ldc com/sina/weibo/sdk/WeiboAppManager
    //   32: monitorexit
    //   33: aload_0
    //   34: athrow
    // Exception table:
    //   from	to	target	type
    //   3	20	29	finally
    //   20	24	29	finally
  }
  
  private WeiboInfo queryWeiboInfoByAsset(Context paramContext) {
    Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
    intent.addCategory("android.intent.category.DEFAULT");
    List list = paramContext.getPackageManager().queryIntentServices(intent, 0);
    paramContext = null;
    if (list != null) {
      if (list.isEmpty())
        return null; 
      Iterator<ResolveInfo> iterator = list.iterator();
      while (true) {
        if (!iterator.hasNext())
          return (WeiboInfo)paramContext; 
        ResolveInfo resolveInfo = iterator.next();
        if (resolveInfo.serviceInfo == null || resolveInfo.serviceInfo.applicationInfo == null || TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName))
          continue; 
        WeiboInfo weiboInfo = parseWeiboInfoByAsset(resolveInfo.serviceInfo.applicationInfo.packageName);
        if (weiboInfo != null && (paramContext == null || paramContext.getSupportApi() < weiboInfo.getSupportApi()))
          WeiboInfo weiboInfo1 = weiboInfo; 
      } 
    } 
    return null;
  }
  
  private WeiboInfo queryWeiboInfoByProvider(Context paramContext) {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   4: astore #5
    //   6: aload #5
    //   8: getstatic com/sina/weibo/sdk/WeiboAppManager.WEIBO_NAME_URI : Landroid/net/Uri;
    //   11: aconst_null
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   18: astore #6
    //   20: aload #6
    //   22: ifnonnull -> 39
    //   25: aload #6
    //   27: ifnull -> 37
    //   30: aload #6
    //   32: invokeinterface close : ()V
    //   37: aconst_null
    //   38: areturn
    //   39: aload #6
    //   41: astore #5
    //   43: aload #6
    //   45: ldc 'support_api'
    //   47: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   52: istore_3
    //   53: aload #6
    //   55: astore #5
    //   57: aload #6
    //   59: ldc 'package'
    //   61: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   66: istore #4
    //   68: aload #6
    //   70: astore #5
    //   72: aload #6
    //   74: invokeinterface moveToFirst : ()Z
    //   79: ifeq -> 209
    //   82: iconst_m1
    //   83: istore_2
    //   84: aload #6
    //   86: astore #5
    //   88: aload #6
    //   90: iload_3
    //   91: invokeinterface getString : (I)Ljava/lang/String;
    //   96: astore #7
    //   98: aload #6
    //   100: astore #5
    //   102: aload #7
    //   104: invokestatic parseInt : (Ljava/lang/String;)I
    //   107: istore_3
    //   108: iload_3
    //   109: istore_2
    //   110: goto -> 124
    //   113: astore #7
    //   115: aload #6
    //   117: astore #5
    //   119: aload #7
    //   121: invokevirtual printStackTrace : ()V
    //   124: aload #6
    //   126: astore #5
    //   128: aload #6
    //   130: iload #4
    //   132: invokeinterface getString : (I)Ljava/lang/String;
    //   137: astore #7
    //   139: aload #6
    //   141: astore #5
    //   143: aload #7
    //   145: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   148: ifne -> 209
    //   151: aload #6
    //   153: astore #5
    //   155: aload_1
    //   156: aload #7
    //   158: invokestatic validateWeiboSign : (Landroid/content/Context;Ljava/lang/String;)Z
    //   161: ifeq -> 209
    //   164: aload #6
    //   166: astore #5
    //   168: new com/sina/weibo/sdk/WeiboAppManager$WeiboInfo
    //   171: dup
    //   172: invokespecial <init> : ()V
    //   175: astore_1
    //   176: aload #6
    //   178: astore #5
    //   180: aload_1
    //   181: aload #7
    //   183: invokestatic access$0 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;Ljava/lang/String;)V
    //   186: aload #6
    //   188: astore #5
    //   190: aload_1
    //   191: iload_2
    //   192: invokestatic access$1 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;I)V
    //   195: aload #6
    //   197: ifnull -> 207
    //   200: aload #6
    //   202: invokeinterface close : ()V
    //   207: aload_1
    //   208: areturn
    //   209: aload #6
    //   211: ifnull -> 267
    //   214: aload #6
    //   216: astore_1
    //   217: goto -> 261
    //   220: astore #5
    //   222: aload #6
    //   224: astore_1
    //   225: aload #5
    //   227: astore #6
    //   229: goto -> 243
    //   232: astore_1
    //   233: aconst_null
    //   234: astore #5
    //   236: goto -> 270
    //   239: astore #6
    //   241: aconst_null
    //   242: astore_1
    //   243: aload_1
    //   244: astore #5
    //   246: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   249: aload #6
    //   251: invokevirtual getMessage : ()Ljava/lang/String;
    //   254: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_1
    //   258: ifnull -> 267
    //   261: aload_1
    //   262: invokeinterface close : ()V
    //   267: aconst_null
    //   268: areturn
    //   269: astore_1
    //   270: aload #5
    //   272: ifnull -> 282
    //   275: aload #5
    //   277: invokeinterface close : ()V
    //   282: aload_1
    //   283: athrow
    // Exception table:
    //   from	to	target	type
    //   6	20	239	java/lang/Exception
    //   6	20	232	finally
    //   43	53	220	java/lang/Exception
    //   43	53	269	finally
    //   57	68	220	java/lang/Exception
    //   57	68	269	finally
    //   72	82	220	java/lang/Exception
    //   72	82	269	finally
    //   88	98	220	java/lang/Exception
    //   88	98	269	finally
    //   102	108	113	java/lang/NumberFormatException
    //   102	108	220	java/lang/Exception
    //   102	108	269	finally
    //   119	124	220	java/lang/Exception
    //   119	124	269	finally
    //   128	139	220	java/lang/Exception
    //   128	139	269	finally
    //   143	151	220	java/lang/Exception
    //   143	151	269	finally
    //   155	164	220	java/lang/Exception
    //   155	164	269	finally
    //   168	176	220	java/lang/Exception
    //   168	176	269	finally
    //   180	186	220	java/lang/Exception
    //   180	186	269	finally
    //   190	195	220	java/lang/Exception
    //   190	195	269	finally
    //   246	257	269	finally
  }
  
  private WeiboInfo queryWeiboInfoInternal(Context paramContext) {
    boolean bool1;
    WeiboInfo weiboInfo2 = queryWeiboInfoByProvider(paramContext);
    WeiboInfo weiboInfo1 = queryWeiboInfoByAsset(paramContext);
    boolean bool2 = true;
    if (weiboInfo2 != null) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    if (weiboInfo1 == null)
      bool2 = false; 
    return (bool1 && bool2) ? ((weiboInfo2.getSupportApi() >= weiboInfo1.getSupportApi()) ? weiboInfo2 : weiboInfo1) : (bool1 ? weiboInfo2 : (bool2 ? weiboInfo1 : null));
  }
  
  public WeiboInfo getWeiboInfo() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield mContext : Landroid/content/Context;
    //   7: invokespecial queryWeiboInfoInternal : (Landroid/content/Context;)Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;
    //   10: astore_1
    //   11: aload_0
    //   12: monitorexit
    //   13: aload_1
    //   14: areturn
    //   15: astore_1
    //   16: aload_0
    //   17: monitorexit
    //   18: aload_1
    //   19: athrow
    // Exception table:
    //   from	to	target	type
    //   2	11	15	finally
  }
  
  public WeiboInfo parseWeiboInfoByAsset(String paramString) {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   4: ifeq -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: getfield mContext : Landroid/content/Context;
    //   13: aload_1
    //   14: iconst_2
    //   15: invokevirtual createPackageContext : (Ljava/lang/String;I)Landroid/content/Context;
    //   18: astore_3
    //   19: sipush #4096
    //   22: newarray byte
    //   24: astore #5
    //   26: aload_3
    //   27: invokevirtual getAssets : ()Landroid/content/res/AssetManager;
    //   30: ldc 'weibo_for_sdk.json'
    //   32: invokevirtual open : (Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore #4
    //   37: aload #4
    //   39: astore_3
    //   40: new java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial <init> : ()V
    //   47: astore #6
    //   49: aload #4
    //   51: astore_3
    //   52: aload #4
    //   54: aload #5
    //   56: iconst_0
    //   57: sipush #4096
    //   60: invokevirtual read : ([BII)I
    //   63: istore_2
    //   64: iload_2
    //   65: iconst_m1
    //   66: if_icmpne -> 204
    //   69: aload #4
    //   71: astore_3
    //   72: aload #6
    //   74: invokevirtual toString : ()Ljava/lang/String;
    //   77: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   80: ifne -> 179
    //   83: aload #4
    //   85: astore_3
    //   86: aload_0
    //   87: getfield mContext : Landroid/content/Context;
    //   90: aload_1
    //   91: invokestatic validateWeiboSign : (Landroid/content/Context;Ljava/lang/String;)Z
    //   94: ifne -> 100
    //   97: goto -> 179
    //   100: aload #4
    //   102: astore_3
    //   103: new org/json/JSONObject
    //   106: dup
    //   107: aload #6
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokespecial <init> : (Ljava/lang/String;)V
    //   115: ldc 'support_api'
    //   117: iconst_m1
    //   118: invokevirtual optInt : (Ljava/lang/String;I)I
    //   121: istore_2
    //   122: aload #4
    //   124: astore_3
    //   125: new com/sina/weibo/sdk/WeiboAppManager$WeiboInfo
    //   128: dup
    //   129: invokespecial <init> : ()V
    //   132: astore #5
    //   134: aload #4
    //   136: astore_3
    //   137: aload #5
    //   139: aload_1
    //   140: invokestatic access$0 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;Ljava/lang/String;)V
    //   143: aload #4
    //   145: astore_3
    //   146: aload #5
    //   148: iload_2
    //   149: invokestatic access$1 : (Lcom/sina/weibo/sdk/WeiboAppManager$WeiboInfo;I)V
    //   152: aload #4
    //   154: ifnull -> 176
    //   157: aload #4
    //   159: invokevirtual close : ()V
    //   162: aload #5
    //   164: areturn
    //   165: astore_1
    //   166: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   169: aload_1
    //   170: invokevirtual getMessage : ()Ljava/lang/String;
    //   173: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload #5
    //   178: areturn
    //   179: aload #4
    //   181: ifnull -> 202
    //   184: aload #4
    //   186: invokevirtual close : ()V
    //   189: aconst_null
    //   190: areturn
    //   191: astore_1
    //   192: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   195: aload_1
    //   196: invokevirtual getMessage : ()Ljava/lang/String;
    //   199: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   202: aconst_null
    //   203: areturn
    //   204: aload #4
    //   206: astore_3
    //   207: aload #6
    //   209: new java/lang/String
    //   212: dup
    //   213: aload #5
    //   215: iconst_0
    //   216: iload_2
    //   217: invokespecial <init> : ([BII)V
    //   220: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: goto -> 49
    //   227: astore_1
    //   228: goto -> 253
    //   231: astore_1
    //   232: goto -> 282
    //   235: astore_1
    //   236: goto -> 311
    //   239: astore_1
    //   240: goto -> 340
    //   243: astore_1
    //   244: aconst_null
    //   245: astore_3
    //   246: goto -> 379
    //   249: astore_1
    //   250: aconst_null
    //   251: astore #4
    //   253: aload #4
    //   255: astore_3
    //   256: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   259: aload_1
    //   260: invokevirtual getMessage : ()Ljava/lang/String;
    //   263: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   266: aload #4
    //   268: ifnull -> 376
    //   271: aload #4
    //   273: invokevirtual close : ()V
    //   276: aconst_null
    //   277: areturn
    //   278: astore_1
    //   279: aconst_null
    //   280: astore #4
    //   282: aload #4
    //   284: astore_3
    //   285: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   288: aload_1
    //   289: invokevirtual getMessage : ()Ljava/lang/String;
    //   292: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   295: aload #4
    //   297: ifnull -> 376
    //   300: aload #4
    //   302: invokevirtual close : ()V
    //   305: aconst_null
    //   306: areturn
    //   307: astore_1
    //   308: aconst_null
    //   309: astore #4
    //   311: aload #4
    //   313: astore_3
    //   314: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   317: aload_1
    //   318: invokevirtual getMessage : ()Ljava/lang/String;
    //   321: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload #4
    //   326: ifnull -> 376
    //   329: aload #4
    //   331: invokevirtual close : ()V
    //   334: aconst_null
    //   335: areturn
    //   336: astore_1
    //   337: aconst_null
    //   338: astore #4
    //   340: aload #4
    //   342: astore_3
    //   343: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   346: aload_1
    //   347: invokevirtual getMessage : ()Ljava/lang/String;
    //   350: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   353: aload #4
    //   355: ifnull -> 376
    //   358: aload #4
    //   360: invokevirtual close : ()V
    //   363: aconst_null
    //   364: areturn
    //   365: astore_1
    //   366: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   369: aload_1
    //   370: invokevirtual getMessage : ()Ljava/lang/String;
    //   373: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   376: aconst_null
    //   377: areturn
    //   378: astore_1
    //   379: aload_3
    //   380: ifnull -> 401
    //   383: aload_3
    //   384: invokevirtual close : ()V
    //   387: goto -> 401
    //   390: astore_3
    //   391: getstatic com/sina/weibo/sdk/WeiboAppManager.TAG : Ljava/lang/String;
    //   394: aload_3
    //   395: invokevirtual getMessage : ()Ljava/lang/String;
    //   398: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)V
    //   401: aload_1
    //   402: athrow
    // Exception table:
    //   from	to	target	type
    //   9	37	336	android/content/pm/PackageManager$NameNotFoundException
    //   9	37	307	java/io/IOException
    //   9	37	278	org/json/JSONException
    //   9	37	249	java/lang/Exception
    //   9	37	243	finally
    //   40	49	239	android/content/pm/PackageManager$NameNotFoundException
    //   40	49	235	java/io/IOException
    //   40	49	231	org/json/JSONException
    //   40	49	227	java/lang/Exception
    //   40	49	378	finally
    //   52	64	239	android/content/pm/PackageManager$NameNotFoundException
    //   52	64	235	java/io/IOException
    //   52	64	231	org/json/JSONException
    //   52	64	227	java/lang/Exception
    //   52	64	378	finally
    //   72	83	239	android/content/pm/PackageManager$NameNotFoundException
    //   72	83	235	java/io/IOException
    //   72	83	231	org/json/JSONException
    //   72	83	227	java/lang/Exception
    //   72	83	378	finally
    //   86	97	239	android/content/pm/PackageManager$NameNotFoundException
    //   86	97	235	java/io/IOException
    //   86	97	231	org/json/JSONException
    //   86	97	227	java/lang/Exception
    //   86	97	378	finally
    //   103	122	239	android/content/pm/PackageManager$NameNotFoundException
    //   103	122	235	java/io/IOException
    //   103	122	231	org/json/JSONException
    //   103	122	227	java/lang/Exception
    //   103	122	378	finally
    //   125	134	239	android/content/pm/PackageManager$NameNotFoundException
    //   125	134	235	java/io/IOException
    //   125	134	231	org/json/JSONException
    //   125	134	227	java/lang/Exception
    //   125	134	378	finally
    //   137	143	239	android/content/pm/PackageManager$NameNotFoundException
    //   137	143	235	java/io/IOException
    //   137	143	231	org/json/JSONException
    //   137	143	227	java/lang/Exception
    //   137	143	378	finally
    //   146	152	239	android/content/pm/PackageManager$NameNotFoundException
    //   146	152	235	java/io/IOException
    //   146	152	231	org/json/JSONException
    //   146	152	227	java/lang/Exception
    //   146	152	378	finally
    //   157	162	165	java/io/IOException
    //   184	189	191	java/io/IOException
    //   207	224	239	android/content/pm/PackageManager$NameNotFoundException
    //   207	224	235	java/io/IOException
    //   207	224	231	org/json/JSONException
    //   207	224	227	java/lang/Exception
    //   207	224	378	finally
    //   256	266	378	finally
    //   271	276	365	java/io/IOException
    //   285	295	378	finally
    //   300	305	365	java/io/IOException
    //   314	324	378	finally
    //   329	334	365	java/io/IOException
    //   343	353	378	finally
    //   358	363	365	java/io/IOException
    //   383	387	390	java/io/IOException
  }
  
  public static class WeiboInfo {
    private String mPackageName;
    
    private int mSupportApi;
    
    private void setPackageName(String param1String) {
      this.mPackageName = param1String;
    }
    
    private void setSupportApi(int param1Int) {
      this.mSupportApi = param1Int;
    }
    
    public String getPackageName() {
      return this.mPackageName;
    }
    
    public int getSupportApi() {
      return this.mSupportApi;
    }
    
    public boolean isLegal() {
      return (!TextUtils.isEmpty(this.mPackageName) && this.mSupportApi > 0);
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder("WeiboInfo: PackageName = ");
      stringBuilder.append(this.mPackageName);
      stringBuilder.append(", supportApi = ");
      stringBuilder.append(this.mSupportApi);
      return stringBuilder.toString();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\sina\weibo\sdk\WeiboAppManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */