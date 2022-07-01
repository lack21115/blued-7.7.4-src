package android.support.v4.provider;

import android.content.Context;
import android.content.pm.Signature;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.TypefaceCompatUtil;
import android.support.v4.util.LruCache;
import android.support.v4.util.SimpleArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class FontsContractCompat {
  private static final SelfDestructiveThread sBackgroundThread;
  
  private static final Comparator sByteArrayComparator;
  
  private static final Object sLock;
  
  private static final SimpleArrayMap sPendingReplies;
  
  private static final LruCache sTypefaceCache = new LruCache(16);
  
  static {
    sBackgroundThread = new SelfDestructiveThread("fonts", 10, 10000);
    sLock = new Object();
    sPendingReplies = new SimpleArrayMap();
    sByteArrayComparator = new FontsContractCompat$5();
    throw new VerifyError("bad dex opcode");
  }
  
  private static List convertToByteArrayList(Signature[] paramArrayOfSignature) {
    ArrayList<byte[]> arrayList = new ArrayList();
    for (int i = 0; i < paramArrayOfSignature.length; i++)
      arrayList.add(paramArrayOfSignature[i].toByteArray()); 
    return arrayList;
  }
  
  private static boolean equalsByteArrayList(List<byte[]> paramList1, List<byte[]> paramList2) {
    if (paramList1.size() != paramList2.size())
      return false; 
    for (int i = 0; i < paramList1.size(); i++) {
      if (!Arrays.equals(paramList1.get(i), paramList2.get(i)))
        return false; 
    } 
    return true;
  }
  
  private static FontsContractCompat$FontInfo[] getFontFromProvider(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal) {
    // Byte code:
    //   0: new java/util/ArrayList
    //   3: dup
    //   4: invokespecial <init> : ()V
    //   7: astore #14
    //   9: new android/net/Uri$Builder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: ldc 'content'
    //   18: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   21: aload_2
    //   22: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   25: invokevirtual build : ()Landroid/net/Uri;
    //   28: astore #16
    //   30: new android/net/Uri$Builder
    //   33: dup
    //   34: invokespecial <init> : ()V
    //   37: ldc 'content'
    //   39: invokevirtual scheme : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   42: aload_2
    //   43: invokevirtual authority : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   46: ldc 'file'
    //   48: invokevirtual appendPath : (Ljava/lang/String;)Landroid/net/Uri$Builder;
    //   51: invokevirtual build : ()Landroid/net/Uri;
    //   54: astore #17
    //   56: aconst_null
    //   57: astore #15
    //   59: aload #15
    //   61: astore_2
    //   62: getstatic android/os/Build$VERSION.SDK_INT : I
    //   65: bipush #16
    //   67: if_icmple -> 152
    //   70: aload #15
    //   72: astore_2
    //   73: aload_0
    //   74: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   77: astore_0
    //   78: aload #15
    //   80: astore_2
    //   81: aload_1
    //   82: getfield mQuery : Ljava/lang/String;
    //   85: astore_1
    //   86: aload #15
    //   88: astore_2
    //   89: aload_0
    //   90: aload #16
    //   92: bipush #7
    //   94: anewarray java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: ldc '_id'
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: ldc 'file_id'
    //   106: aastore
    //   107: dup
    //   108: iconst_2
    //   109: ldc 'font_ttc_index'
    //   111: aastore
    //   112: dup
    //   113: iconst_3
    //   114: ldc 'font_variation_settings'
    //   116: aastore
    //   117: dup
    //   118: iconst_4
    //   119: ldc 'font_weight'
    //   121: aastore
    //   122: dup
    //   123: iconst_5
    //   124: ldc 'font_italic'
    //   126: aastore
    //   127: dup
    //   128: bipush #6
    //   130: ldc 'result_code'
    //   132: aastore
    //   133: ldc 'query = ?'
    //   135: iconst_1
    //   136: anewarray java/lang/String
    //   139: dup
    //   140: iconst_0
    //   141: aload_1
    //   142: aastore
    //   143: aconst_null
    //   144: aload_3
    //   145: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;
    //   148: astore_0
    //   149: goto -> 543
    //   152: aload #15
    //   154: astore_2
    //   155: aload_0
    //   156: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   159: astore_0
    //   160: aload #15
    //   162: astore_2
    //   163: aload_1
    //   164: getfield mQuery : Ljava/lang/String;
    //   167: astore_1
    //   168: aload #15
    //   170: astore_2
    //   171: aload_0
    //   172: aload #16
    //   174: bipush #7
    //   176: anewarray java/lang/String
    //   179: dup
    //   180: iconst_0
    //   181: ldc '_id'
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: ldc 'file_id'
    //   188: aastore
    //   189: dup
    //   190: iconst_2
    //   191: ldc 'font_ttc_index'
    //   193: aastore
    //   194: dup
    //   195: iconst_3
    //   196: ldc 'font_variation_settings'
    //   198: aastore
    //   199: dup
    //   200: iconst_4
    //   201: ldc 'font_weight'
    //   203: aastore
    //   204: dup
    //   205: iconst_5
    //   206: ldc 'font_italic'
    //   208: aastore
    //   209: dup
    //   210: bipush #6
    //   212: ldc 'result_code'
    //   214: aastore
    //   215: ldc 'query = ?'
    //   217: iconst_1
    //   218: anewarray java/lang/String
    //   221: dup
    //   222: iconst_0
    //   223: aload_1
    //   224: aastore
    //   225: aconst_null
    //   226: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   229: astore_0
    //   230: goto -> 543
    //   233: aload #14
    //   235: astore_1
    //   236: aload_0
    //   237: ifnull -> 508
    //   240: aload #14
    //   242: astore_1
    //   243: aload_0
    //   244: astore_2
    //   245: aload_0
    //   246: invokeinterface getCount : ()I
    //   251: ifle -> 508
    //   254: aload_0
    //   255: astore_2
    //   256: aload_0
    //   257: ldc 'result_code'
    //   259: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   264: istore #7
    //   266: aload_0
    //   267: astore_2
    //   268: new java/util/ArrayList
    //   271: dup
    //   272: invokespecial <init> : ()V
    //   275: astore_3
    //   276: aload_0
    //   277: astore_2
    //   278: aload_0
    //   279: ldc '_id'
    //   281: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   286: istore #8
    //   288: aload_0
    //   289: astore_2
    //   290: aload_0
    //   291: ldc 'file_id'
    //   293: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   298: istore #9
    //   300: aload_0
    //   301: astore_2
    //   302: aload_0
    //   303: ldc 'font_ttc_index'
    //   305: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   310: istore #10
    //   312: aload_0
    //   313: astore_2
    //   314: aload_0
    //   315: ldc 'font_weight'
    //   317: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   322: istore #11
    //   324: aload_0
    //   325: astore_2
    //   326: aload_0
    //   327: ldc 'font_italic'
    //   329: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   334: istore #12
    //   336: aload_3
    //   337: astore_1
    //   338: aload_0
    //   339: astore_2
    //   340: aload_0
    //   341: invokeinterface moveToNext : ()Z
    //   346: ifeq -> 508
    //   349: iload #7
    //   351: iconst_m1
    //   352: if_icmpeq -> 546
    //   355: aload_0
    //   356: astore_2
    //   357: aload_0
    //   358: iload #7
    //   360: invokeinterface getInt : (I)I
    //   365: istore #4
    //   367: goto -> 370
    //   370: iload #10
    //   372: iconst_m1
    //   373: if_icmpeq -> 552
    //   376: aload_0
    //   377: astore_2
    //   378: aload_0
    //   379: iload #10
    //   381: invokeinterface getInt : (I)I
    //   386: istore #5
    //   388: goto -> 391
    //   391: iload #9
    //   393: iconst_m1
    //   394: if_icmpne -> 416
    //   397: aload_0
    //   398: astore_2
    //   399: aload #16
    //   401: aload_0
    //   402: iload #8
    //   404: invokeinterface getLong : (I)J
    //   409: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   412: astore_1
    //   413: goto -> 558
    //   416: aload_0
    //   417: astore_2
    //   418: aload #17
    //   420: aload_0
    //   421: iload #9
    //   423: invokeinterface getLong : (I)J
    //   428: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   431: astore_1
    //   432: goto -> 558
    //   435: iload #11
    //   437: iconst_m1
    //   438: if_icmpeq -> 561
    //   441: aload_0
    //   442: astore_2
    //   443: aload_0
    //   444: iload #11
    //   446: invokeinterface getInt : (I)I
    //   451: istore #6
    //   453: goto -> 456
    //   456: iload #12
    //   458: iconst_m1
    //   459: if_icmpeq -> 569
    //   462: aload_0
    //   463: astore_2
    //   464: aload_0
    //   465: iload #12
    //   467: invokeinterface getInt : (I)I
    //   472: iconst_1
    //   473: if_icmpne -> 569
    //   476: iconst_1
    //   477: istore #13
    //   479: goto -> 482
    //   482: aload_0
    //   483: astore_2
    //   484: aload_3
    //   485: new android/support/v4/provider/FontsContractCompat$FontInfo
    //   488: dup
    //   489: aload_1
    //   490: iload #5
    //   492: iload #6
    //   494: iload #13
    //   496: iload #4
    //   498: invokespecial <init> : (Landroid/net/Uri;IIZI)V
    //   501: invokevirtual add : (Ljava/lang/Object;)Z
    //   504: pop
    //   505: goto -> 336
    //   508: aload_0
    //   509: ifnull -> 518
    //   512: aload_0
    //   513: invokeinterface close : ()V
    //   518: aload_1
    //   519: iconst_0
    //   520: anewarray android/support/v4/provider/FontsContractCompat$FontInfo
    //   523: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   526: checkcast [Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   529: areturn
    //   530: astore_0
    //   531: aload_2
    //   532: ifnull -> 541
    //   535: aload_2
    //   536: invokeinterface close : ()V
    //   541: aload_0
    //   542: athrow
    //   543: goto -> 233
    //   546: iconst_0
    //   547: istore #4
    //   549: goto -> 370
    //   552: iconst_0
    //   553: istore #5
    //   555: goto -> 391
    //   558: goto -> 435
    //   561: sipush #400
    //   564: istore #6
    //   566: goto -> 456
    //   569: iconst_0
    //   570: istore #13
    //   572: goto -> 482
    // Exception table:
    //   from	to	target	type
    //   62	70	530	finally
    //   73	78	530	finally
    //   81	86	530	finally
    //   89	149	530	finally
    //   155	160	530	finally
    //   163	168	530	finally
    //   171	230	530	finally
    //   245	254	530	finally
    //   256	266	530	finally
    //   268	276	530	finally
    //   278	288	530	finally
    //   290	300	530	finally
    //   302	312	530	finally
    //   314	324	530	finally
    //   326	336	530	finally
    //   340	349	530	finally
    //   357	367	530	finally
    //   378	388	530	finally
    //   399	413	530	finally
    //   418	432	530	finally
    //   443	453	530	finally
    //   464	476	530	finally
    //   484	505	530	finally
  }
  
  private static FontsContractCompat$TypefaceResult getFontInternal(Context paramContext, FontRequest paramFontRequest, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual getPackageManager : ()Landroid/content/pm/PackageManager;
    //   4: astore #7
    //   6: aload_0
    //   7: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   10: astore #8
    //   12: aload_1
    //   13: getfield mProviderAuthority : Ljava/lang/String;
    //   16: astore #5
    //   18: aload #7
    //   20: aload #5
    //   22: iconst_0
    //   23: invokevirtual resolveContentProvider : (Ljava/lang/String;I)Landroid/content/pm/ProviderInfo;
    //   26: astore #6
    //   28: aload #6
    //   30: ifnull -> 309
    //   33: aload #6
    //   35: getfield packageName : Ljava/lang/String;
    //   38: aload_1
    //   39: getfield mProviderPackage : Ljava/lang/String;
    //   42: invokevirtual equals : (Ljava/lang/Object;)Z
    //   45: ifeq -> 262
    //   48: aload #7
    //   50: aload #6
    //   52: getfield packageName : Ljava/lang/String;
    //   55: bipush #64
    //   57: invokevirtual getPackageInfo : (Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   60: getfield signatures : [Landroid/content/pm/Signature;
    //   63: invokestatic convertToByteArrayList : ([Landroid/content/pm/Signature;)Ljava/util/List;
    //   66: astore #7
    //   68: aload #7
    //   70: getstatic android/support/v4/provider/FontsContractCompat.sByteArrayComparator : Ljava/util/Comparator;
    //   73: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   76: aload_1
    //   77: getfield mCertificates : Ljava/util/List;
    //   80: ifnull -> 92
    //   83: aload_1
    //   84: getfield mCertificates : Ljava/util/List;
    //   87: astore #5
    //   89: goto -> 350
    //   92: aload #8
    //   94: aload_1
    //   95: getfield mCertificatesArray : I
    //   98: invokestatic readCerts : (Landroid/content/res/Resources;I)Ljava/util/List;
    //   101: astore #5
    //   103: goto -> 350
    //   106: iload_3
    //   107: aload #5
    //   109: invokeinterface size : ()I
    //   114: if_icmpge -> 362
    //   117: new java/util/ArrayList
    //   120: dup
    //   121: aload #5
    //   123: iload_3
    //   124: invokeinterface get : (I)Ljava/lang/Object;
    //   129: checkcast java/util/Collection
    //   132: invokespecial <init> : (Ljava/util/Collection;)V
    //   135: astore #8
    //   137: aload #8
    //   139: getstatic android/support/v4/provider/FontsContractCompat.sByteArrayComparator : Ljava/util/Comparator;
    //   142: invokestatic sort : (Ljava/util/List;Ljava/util/Comparator;)V
    //   145: aload #7
    //   147: aload #8
    //   149: invokestatic equalsByteArrayList : (Ljava/util/List;Ljava/util/List;)Z
    //   152: ifeq -> 355
    //   155: aload #6
    //   157: astore #5
    //   159: goto -> 162
    //   162: aload #5
    //   164: ifnonnull -> 180
    //   167: new android/support/v4/provider/FontsContractCompat$FontFamilyResult
    //   170: dup
    //   171: iconst_1
    //   172: aconst_null
    //   173: invokespecial <init> : (I[Landroid/support/v4/provider/FontsContractCompat$FontInfo;)V
    //   176: astore_1
    //   177: goto -> 200
    //   180: new android/support/v4/provider/FontsContractCompat$FontFamilyResult
    //   183: dup
    //   184: iconst_0
    //   185: aload_0
    //   186: aload_1
    //   187: aload #5
    //   189: getfield authority : Ljava/lang/String;
    //   192: aconst_null
    //   193: invokestatic getFontFromProvider : (Landroid/content/Context;Landroid/support/v4/provider/FontRequest;Ljava/lang/String;Landroid/os/CancellationSignal;)[Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   196: invokespecial <init> : (I[Landroid/support/v4/provider/FontsContractCompat$FontInfo;)V
    //   199: astore_1
    //   200: aload_1
    //   201: getfield mStatusCode : I
    //   204: istore #4
    //   206: bipush #-3
    //   208: istore_3
    //   209: iload #4
    //   211: ifne -> 241
    //   214: aload_0
    //   215: aconst_null
    //   216: aload_1
    //   217: getfield mFonts : [Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   220: iload_2
    //   221: invokestatic createFromFontInfo : (Landroid/content/Context;Landroid/os/CancellationSignal;[Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/graphics/Typeface;
    //   224: astore_0
    //   225: aload_0
    //   226: ifnull -> 231
    //   229: iconst_0
    //   230: istore_3
    //   231: new android/support/v4/provider/FontsContractCompat$TypefaceResult
    //   234: dup
    //   235: aload_0
    //   236: iload_3
    //   237: invokespecial <init> : (Landroid/graphics/Typeface;I)V
    //   240: areturn
    //   241: aload_1
    //   242: getfield mStatusCode : I
    //   245: iconst_1
    //   246: if_icmpne -> 252
    //   249: bipush #-2
    //   251: istore_3
    //   252: new android/support/v4/provider/FontsContractCompat$TypefaceResult
    //   255: dup
    //   256: aconst_null
    //   257: iload_3
    //   258: invokespecial <init> : (Landroid/graphics/Typeface;I)V
    //   261: areturn
    //   262: new java/lang/StringBuilder
    //   265: dup
    //   266: ldc_w 'Found content provider '
    //   269: invokespecial <init> : (Ljava/lang/String;)V
    //   272: astore_0
    //   273: aload_0
    //   274: aload #5
    //   276: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload_0
    //   281: ldc_w ', but package was not '
    //   284: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload_0
    //   289: aload_1
    //   290: getfield mProviderPackage : Ljava/lang/String;
    //   293: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: new android/content/pm/PackageManager$NameNotFoundException
    //   300: dup
    //   301: aload_0
    //   302: invokevirtual toString : ()Ljava/lang/String;
    //   305: invokespecial <init> : (Ljava/lang/String;)V
    //   308: athrow
    //   309: new java/lang/StringBuilder
    //   312: dup
    //   313: ldc_w 'No package found for authority: '
    //   316: invokespecial <init> : (Ljava/lang/String;)V
    //   319: astore_0
    //   320: aload_0
    //   321: aload #5
    //   323: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: new android/content/pm/PackageManager$NameNotFoundException
    //   330: dup
    //   331: aload_0
    //   332: invokevirtual toString : ()Ljava/lang/String;
    //   335: invokespecial <init> : (Ljava/lang/String;)V
    //   338: athrow
    //   339: astore_0
    //   340: new android/support/v4/provider/FontsContractCompat$TypefaceResult
    //   343: dup
    //   344: aconst_null
    //   345: iconst_m1
    //   346: invokespecial <init> : (Landroid/graphics/Typeface;I)V
    //   349: areturn
    //   350: iconst_0
    //   351: istore_3
    //   352: goto -> 106
    //   355: iload_3
    //   356: iconst_1
    //   357: iadd
    //   358: istore_3
    //   359: goto -> 106
    //   362: aconst_null
    //   363: astore #5
    //   365: goto -> 162
    // Exception table:
    //   from	to	target	type
    //   0	28	339	android/content/pm/PackageManager$NameNotFoundException
    //   33	89	339	android/content/pm/PackageManager$NameNotFoundException
    //   92	103	339	android/content/pm/PackageManager$NameNotFoundException
    //   106	155	339	android/content/pm/PackageManager$NameNotFoundException
    //   167	177	339	android/content/pm/PackageManager$NameNotFoundException
    //   180	200	339	android/content/pm/PackageManager$NameNotFoundException
    //   262	309	339	android/content/pm/PackageManager$NameNotFoundException
    //   309	339	339	android/content/pm/PackageManager$NameNotFoundException
  }
  
  public static Typeface getFontSync(Context paramContext, FontRequest paramFontRequest, ResourcesCompat.FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2) {
    FontsContractCompat$TypefaceResult fontsContractCompat$TypefaceResult;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFontRequest.mIdentifier);
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    String str = stringBuilder.toString();
    Typeface typeface = (Typeface)sTypefaceCache.get(str);
    if (typeface != null) {
      if (paramFontCallback != null)
        paramFontCallback.onFontRetrieved(typeface); 
      return typeface;
    } 
    if (paramBoolean && paramInt1 == -1) {
      fontsContractCompat$TypefaceResult = getFontInternal(paramContext, paramFontRequest, paramInt2);
      if (paramFontCallback != null)
        if (fontsContractCompat$TypefaceResult.mResult == 0) {
          paramFontCallback.callbackSuccessAsync(fontsContractCompat$TypefaceResult.mTypeface, paramHandler);
        } else {
          paramFontCallback.callbackFailAsync(fontsContractCompat$TypefaceResult.mResult, paramHandler);
        }  
      return fontsContractCompat$TypefaceResult.mTypeface;
    } 
    FontsContractCompat$1 fontsContractCompat$1 = new FontsContractCompat$1((Context)fontsContractCompat$TypefaceResult, paramFontRequest, paramInt2, str);
    if (paramBoolean)
      try {
        return ((FontsContractCompat$TypefaceResult)sBackgroundThread.postAndWait(fontsContractCompat$1, paramInt1)).mTypeface;
      } catch (InterruptedException interruptedException) {
        return null;
      }  
    if (paramFontCallback == null) {
      fontsContractCompat$TypefaceResult = null;
    } else {
      null = new FontsContractCompat$2(paramFontCallback, paramHandler);
    } 
    synchronized (sLock) {
      if (sPendingReplies.containsKey(str)) {
        if (null != null)
          ((ArrayList<FontsContractCompat$2>)sPendingReplies.get(str)).add(null); 
        return null;
      } 
      if (null != null) {
        ArrayList<FontsContractCompat$2> arrayList = new ArrayList();
        arrayList.add(null);
        sPendingReplies.put(str, arrayList);
      } 
      SelfDestructiveThread selfDestructiveThread = sBackgroundThread;
      null = new FontsContractCompat$3(str);
      selfDestructiveThread.post(new SelfDestructiveThread$2(fontsContractCompat$1, new Handler(), (SelfDestructiveThread$ReplyCallback)null));
      return null;
    } 
  }
  
  public static Map prepareFontData(Context paramContext, FontsContractCompat$FontInfo[] paramArrayOfFontsContractCompat$FontInfo, CancellationSignal paramCancellationSignal) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = paramArrayOfFontsContractCompat$FontInfo.length;
    for (int i = 0; i < j; i++) {
      FontsContractCompat$FontInfo fontsContractCompat$FontInfo = paramArrayOfFontsContractCompat$FontInfo[i];
      if (fontsContractCompat$FontInfo.mResultCode == 0) {
        Uri uri = fontsContractCompat$FontInfo.mUri;
        if (!hashMap.containsKey(uri))
          hashMap.put(uri, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, uri)); 
      } 
    } 
    return Collections.unmodifiableMap(hashMap);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\provider\FontsContractCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */