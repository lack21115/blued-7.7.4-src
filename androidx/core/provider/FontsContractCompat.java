package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.provider.BaseColumns;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class FontsContractCompat {
  public static final String PARCEL_FONT_RESULTS = "font_results";
  
  static final LruCache<String, Typeface> a = new LruCache(16);
  
  static final Object b;
  
  static final SimpleArrayMap<String, ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>> c;
  
  private static final SelfDestructiveThread d = new SelfDestructiveThread("fonts", 10, 10000);
  
  private static final Comparator<byte[]> e;
  
  static {
    b = new Object();
    c = new SimpleArrayMap();
    e = new Comparator<byte[]>() {
        public int compare(byte[] param1ArrayOfbyte1, byte[] param1ArrayOfbyte2) {
          if (param1ArrayOfbyte1.length != param1ArrayOfbyte2.length) {
            int j = param1ArrayOfbyte1.length;
            int k = param1ArrayOfbyte2.length;
            return j - k;
          } 
          for (int i = 0; i < param1ArrayOfbyte1.length; i++) {
            if (param1ArrayOfbyte1[i] != param1ArrayOfbyte2[i]) {
              byte b1 = param1ArrayOfbyte1[i];
              byte b2 = param1ArrayOfbyte2[i];
              i = b1;
              b1 = b2;
              return i - b1;
            } 
          } 
          return 0;
        }
      };
  }
  
  static TypefaceResult a(Context paramContext, FontRequest paramFontRequest, int paramInt) {
    try {
      FontFamilyResult fontFamilyResult = fetchFonts(paramContext, null, paramFontRequest);
      int i = fontFamilyResult.getStatusCode();
      byte b = -3;
      if (i == 0) {
        Typeface typeface = TypefaceCompat.createFromFontInfo(paramContext, null, fontFamilyResult.getFonts(), paramInt);
        if (typeface != null)
          b = 0; 
        return new TypefaceResult(typeface, b);
      } 
      if (fontFamilyResult.getStatusCode() == 1)
        b = -2; 
      return new TypefaceResult(null, b);
    } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
      return new TypefaceResult(null, -1);
    } 
  }
  
  private static List<List<byte[]>> a(FontRequest paramFontRequest, Resources paramResources) {
    return (paramFontRequest.getCertificates() != null) ? paramFontRequest.getCertificates() : FontResourcesParserCompat.readCerts(paramResources, paramFontRequest.getCertificatesArrayResId());
  }
  
  private static List<byte[]> a(Signature[] paramArrayOfSignature) {
    ArrayList<byte[]> arrayList = new ArrayList();
    for (int i = 0; i < paramArrayOfSignature.length; i++)
      arrayList.add(paramArrayOfSignature[i].toByteArray()); 
    return (List<byte[]>)arrayList;
  }
  
  private static void a(Context paramContext, FontRequest paramFontRequest, FontRequestCallback paramFontRequestCallback, Handler paramHandler) {
    paramHandler.post(new Runnable(paramContext, paramFontRequest, new Handler(), paramFontRequestCallback) {
          public void run() {
            try {
              FontsContractCompat.FontFamilyResult fontFamilyResult = FontsContractCompat.fetchFonts(this.a, null, this.b);
              if (fontFamilyResult.getStatusCode() != 0) {
                int k = fontFamilyResult.getStatusCode();
                if (k != 1) {
                  if (k != 2) {
                    this.c.post(new Runnable(this) {
                          public void run() {
                            this.a.d.onTypefaceRequestFailed(-3);
                          }
                        });
                    return;
                  } 
                  this.c.post(new Runnable(this) {
                        public void run() {
                          this.a.d.onTypefaceRequestFailed(-3);
                        }
                      });
                  return;
                } 
                this.c.post(new Runnable(this) {
                      public void run() {
                        this.a.d.onTypefaceRequestFailed(-2);
                      }
                    });
                return;
              } 
              FontsContractCompat.FontInfo[] arrayOfFontInfo = fontFamilyResult.getFonts();
              if (arrayOfFontInfo == null || arrayOfFontInfo.length == 0) {
                this.c.post(new Runnable(this) {
                      public void run() {
                        this.a.d.onTypefaceRequestFailed(1);
                      }
                    });
                return;
              } 
              int j = arrayOfFontInfo.length;
              for (int i = 0; i < j; i++) {
                FontsContractCompat.FontInfo fontInfo = arrayOfFontInfo[i];
                if (fontInfo.getResultCode() != 0) {
                  i = fontInfo.getResultCode();
                  if (i < 0) {
                    this.c.post(new Runnable(this) {
                          public void run() {
                            this.a.d.onTypefaceRequestFailed(-3);
                          }
                        });
                    return;
                  } 
                  this.c.post(new Runnable(this, i) {
                        public void run() {
                          this.b.d.onTypefaceRequestFailed(this.a);
                        }
                      });
                  return;
                } 
              } 
              Typeface typeface = FontsContractCompat.buildTypeface(this.a, null, arrayOfFontInfo);
              if (typeface == null) {
                this.c.post(new Runnable(this) {
                      public void run() {
                        this.a.d.onTypefaceRequestFailed(-3);
                      }
                    });
                return;
              } 
              this.c.post(new Runnable(this, typeface) {
                    public void run() {
                      this.b.d.onTypefaceRetrieved(this.a);
                    }
                  });
              return;
            } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
              this.c.post(new Runnable(this) {
                    public void run() {
                      this.a.d.onTypefaceRequestFailed(-1);
                    }
                  });
              return;
            } 
          }
        });
  }
  
  private static boolean a(List<byte[]> paramList1, List<byte[]> paramList2) {
    if (paramList1.size() != paramList2.size())
      return false; 
    for (int i = 0; i < paramList1.size(); i++) {
      if (!Arrays.equals(paramList1.get(i), paramList2.get(i)))
        return false; 
    } 
    return true;
  }
  
  static FontInfo[] a(Context paramContext, FontRequest paramFontRequest, String paramString, CancellationSignal paramCancellationSignal) {
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
    //   82: invokevirtual getQuery : ()Ljava/lang/String;
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
    //   149: goto -> 230
    //   152: aload #15
    //   154: astore_2
    //   155: aload_0
    //   156: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   159: astore_0
    //   160: aload #15
    //   162: astore_2
    //   163: aload_1
    //   164: invokevirtual getQuery : ()Ljava/lang/String;
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
    //   230: aload #14
    //   232: astore_1
    //   233: aload_0
    //   234: ifnull -> 502
    //   237: aload #14
    //   239: astore_1
    //   240: aload_0
    //   241: astore_2
    //   242: aload_0
    //   243: invokeinterface getCount : ()I
    //   248: ifle -> 502
    //   251: aload_0
    //   252: astore_2
    //   253: aload_0
    //   254: ldc 'result_code'
    //   256: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   261: istore #7
    //   263: aload_0
    //   264: astore_2
    //   265: new java/util/ArrayList
    //   268: dup
    //   269: invokespecial <init> : ()V
    //   272: astore_3
    //   273: aload_0
    //   274: astore_2
    //   275: aload_0
    //   276: ldc '_id'
    //   278: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   283: istore #8
    //   285: aload_0
    //   286: astore_2
    //   287: aload_0
    //   288: ldc 'file_id'
    //   290: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   295: istore #9
    //   297: aload_0
    //   298: astore_2
    //   299: aload_0
    //   300: ldc 'font_ttc_index'
    //   302: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   307: istore #10
    //   309: aload_0
    //   310: astore_2
    //   311: aload_0
    //   312: ldc 'font_weight'
    //   314: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   319: istore #11
    //   321: aload_0
    //   322: astore_2
    //   323: aload_0
    //   324: ldc 'font_italic'
    //   326: invokeinterface getColumnIndex : (Ljava/lang/String;)I
    //   331: istore #12
    //   333: aload_0
    //   334: astore_2
    //   335: aload_0
    //   336: invokeinterface moveToNext : ()Z
    //   341: ifeq -> 500
    //   344: iload #7
    //   346: iconst_m1
    //   347: if_icmpeq -> 537
    //   350: aload_0
    //   351: astore_2
    //   352: aload_0
    //   353: iload #7
    //   355: invokeinterface getInt : (I)I
    //   360: istore #4
    //   362: goto -> 365
    //   365: iload #10
    //   367: iconst_m1
    //   368: if_icmpeq -> 543
    //   371: aload_0
    //   372: astore_2
    //   373: aload_0
    //   374: iload #10
    //   376: invokeinterface getInt : (I)I
    //   381: istore #5
    //   383: goto -> 386
    //   386: iload #9
    //   388: iconst_m1
    //   389: if_icmpne -> 411
    //   392: aload_0
    //   393: astore_2
    //   394: aload #16
    //   396: aload_0
    //   397: iload #8
    //   399: invokeinterface getLong : (I)J
    //   404: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   407: astore_1
    //   408: goto -> 427
    //   411: aload_0
    //   412: astore_2
    //   413: aload #17
    //   415: aload_0
    //   416: iload #9
    //   418: invokeinterface getLong : (I)J
    //   423: invokestatic withAppendedId : (Landroid/net/Uri;J)Landroid/net/Uri;
    //   426: astore_1
    //   427: iload #11
    //   429: iconst_m1
    //   430: if_icmpeq -> 549
    //   433: aload_0
    //   434: astore_2
    //   435: aload_0
    //   436: iload #11
    //   438: invokeinterface getInt : (I)I
    //   443: istore #6
    //   445: goto -> 448
    //   448: iload #12
    //   450: iconst_m1
    //   451: if_icmpeq -> 557
    //   454: aload_0
    //   455: astore_2
    //   456: aload_0
    //   457: iload #12
    //   459: invokeinterface getInt : (I)I
    //   464: iconst_1
    //   465: if_icmpne -> 557
    //   468: iconst_1
    //   469: istore #13
    //   471: goto -> 474
    //   474: aload_0
    //   475: astore_2
    //   476: aload_3
    //   477: new androidx/core/provider/FontsContractCompat$FontInfo
    //   480: dup
    //   481: aload_1
    //   482: iload #5
    //   484: iload #6
    //   486: iload #13
    //   488: iload #4
    //   490: invokespecial <init> : (Landroid/net/Uri;IIZI)V
    //   493: invokevirtual add : (Ljava/lang/Object;)Z
    //   496: pop
    //   497: goto -> 333
    //   500: aload_3
    //   501: astore_1
    //   502: aload_0
    //   503: ifnull -> 512
    //   506: aload_0
    //   507: invokeinterface close : ()V
    //   512: aload_1
    //   513: iconst_0
    //   514: anewarray androidx/core/provider/FontsContractCompat$FontInfo
    //   517: invokevirtual toArray : ([Ljava/lang/Object;)[Ljava/lang/Object;
    //   520: checkcast [Landroidx/core/provider/FontsContractCompat$FontInfo;
    //   523: areturn
    //   524: astore_0
    //   525: aload_2
    //   526: ifnull -> 535
    //   529: aload_2
    //   530: invokeinterface close : ()V
    //   535: aload_0
    //   536: athrow
    //   537: iconst_0
    //   538: istore #4
    //   540: goto -> 365
    //   543: iconst_0
    //   544: istore #5
    //   546: goto -> 386
    //   549: sipush #400
    //   552: istore #6
    //   554: goto -> 448
    //   557: iconst_0
    //   558: istore #13
    //   560: goto -> 474
    // Exception table:
    //   from	to	target	type
    //   62	70	524	finally
    //   73	78	524	finally
    //   81	86	524	finally
    //   89	149	524	finally
    //   155	160	524	finally
    //   163	168	524	finally
    //   171	230	524	finally
    //   242	251	524	finally
    //   253	263	524	finally
    //   265	273	524	finally
    //   275	285	524	finally
    //   287	297	524	finally
    //   299	309	524	finally
    //   311	321	524	finally
    //   323	333	524	finally
    //   335	344	524	finally
    //   352	362	524	finally
    //   373	383	524	finally
    //   394	408	524	finally
    //   413	427	524	finally
    //   435	445	524	finally
    //   456	468	524	finally
    //   476	497	524	finally
  }
  
  public static Typeface buildTypeface(Context paramContext, CancellationSignal paramCancellationSignal, FontInfo[] paramArrayOfFontInfo) {
    return TypefaceCompat.createFromFontInfo(paramContext, paramCancellationSignal, paramArrayOfFontInfo, 0);
  }
  
  public static FontFamilyResult fetchFonts(Context paramContext, CancellationSignal paramCancellationSignal, FontRequest paramFontRequest) throws PackageManager.NameNotFoundException {
    ProviderInfo providerInfo = getProvider(paramContext.getPackageManager(), paramFontRequest, paramContext.getResources());
    return (providerInfo == null) ? new FontFamilyResult(1, null) : new FontFamilyResult(0, a(paramContext, paramFontRequest, providerInfo.authority, paramCancellationSignal));
  }
  
  public static Typeface getFontSync(Context paramContext, FontRequest paramFontRequest, ResourcesCompat.FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean, int paramInt1, int paramInt2) {
    TypefaceResult typefaceResult;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramFontRequest.getIdentifier());
    stringBuilder.append("-");
    stringBuilder.append(paramInt2);
    String str = stringBuilder.toString();
    Typeface typeface = (Typeface)a.get(str);
    if (typeface != null) {
      if (paramFontCallback != null)
        paramFontCallback.onFontRetrieved(typeface); 
      return typeface;
    } 
    if (paramBoolean && paramInt1 == -1) {
      typefaceResult = a(paramContext, paramFontRequest, paramInt2);
      if (paramFontCallback != null)
        if (typefaceResult.b == 0) {
          paramFontCallback.callbackSuccessAsync(typefaceResult.a, paramHandler);
        } else {
          paramFontCallback.callbackFailAsync(typefaceResult.b, paramHandler);
        }  
      return typefaceResult.a;
    } 
    Callable<TypefaceResult> callable = new Callable<TypefaceResult>((Context)typefaceResult, paramFontRequest, paramInt2, str) {
        public FontsContractCompat.TypefaceResult call() throws Exception {
          FontsContractCompat.TypefaceResult typefaceResult = FontsContractCompat.a(this.a, this.b, this.c);
          if (typefaceResult.a != null)
            FontsContractCompat.a.put(this.d, typefaceResult.a); 
          return typefaceResult;
        }
      };
    if (paramBoolean)
      try {
        return ((TypefaceResult)d.postAndWait((Callable)callable, paramInt1)).a;
      } catch (InterruptedException interruptedException) {
        return null;
      }  
    if (paramFontCallback == null) {
      typefaceResult = null;
    } else {
      null = new SelfDestructiveThread.ReplyCallback<TypefaceResult>(paramFontCallback, paramHandler) {
          public void onReply(FontsContractCompat.TypefaceResult param1TypefaceResult) {
            if (param1TypefaceResult == null) {
              this.a.callbackFailAsync(1, this.b);
              return;
            } 
            if (param1TypefaceResult.b == 0) {
              this.a.callbackSuccessAsync(param1TypefaceResult.a, this.b);
              return;
            } 
            this.a.callbackFailAsync(param1TypefaceResult.b, this.b);
          }
        };
    } 
    synchronized (b) {
      ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>> arrayList = (ArrayList)c.get(str);
      if (arrayList != null) {
        if (null != null)
          arrayList.add(null); 
        return null;
      } 
      if (null != null) {
        arrayList = new ArrayList<SelfDestructiveThread.ReplyCallback<TypefaceResult>>();
        arrayList.add(null);
        c.put(str, arrayList);
      } 
      d.postAndReply(callable, new SelfDestructiveThread.ReplyCallback<TypefaceResult>(str) {
            public void onReply(FontsContractCompat.TypefaceResult param1TypefaceResult) {
              synchronized (FontsContractCompat.b) {
                ArrayList<SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>> arrayList = (ArrayList)FontsContractCompat.c.get(this.a);
                if (arrayList == null)
                  return; 
                FontsContractCompat.c.remove(this.a);
                for (int i = 0; i < arrayList.size(); i++)
                  ((SelfDestructiveThread.ReplyCallback<FontsContractCompat.TypefaceResult>)arrayList.get(i)).onReply(param1TypefaceResult); 
                return;
              } 
            }
          });
      return null;
    } 
  }
  
  public static ProviderInfo getProvider(PackageManager paramPackageManager, FontRequest paramFontRequest, Resources paramResources) throws PackageManager.NameNotFoundException {
    String str = paramFontRequest.getProviderAuthority();
    int i = 0;
    ProviderInfo providerInfo = paramPackageManager.resolveContentProvider(str, 0);
    if (providerInfo != null) {
      List<List<byte[]>> list;
      if (providerInfo.packageName.equals(paramFontRequest.getProviderPackage())) {
        List<byte[]> list1 = a((paramPackageManager.getPackageInfo(providerInfo.packageName, 64)).signatures);
        Collections.sort((List)list1, (Comparator)e);
        list = a(paramFontRequest, paramResources);
        while (i < list.size()) {
          ArrayList<byte> arrayList = new ArrayList(list.get(i));
          Collections.sort(arrayList, (Comparator)e);
          if (a(list1, (List)arrayList))
            return providerInfo; 
          i++;
        } 
        return null;
      } 
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("Found content provider ");
      stringBuilder1.append(str);
      stringBuilder1.append(", but package was not ");
      stringBuilder1.append(list.getProviderPackage());
      throw new PackageManager.NameNotFoundException(stringBuilder1.toString());
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("No package found for authority: ");
    stringBuilder.append(str);
    throw new PackageManager.NameNotFoundException(stringBuilder.toString());
  }
  
  public static Map<Uri, ByteBuffer> prepareFontData(Context paramContext, FontInfo[] paramArrayOfFontInfo, CancellationSignal paramCancellationSignal) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    int j = paramArrayOfFontInfo.length;
    for (int i = 0; i < j; i++) {
      FontInfo fontInfo = paramArrayOfFontInfo[i];
      if (fontInfo.getResultCode() == 0) {
        Uri uri = fontInfo.getUri();
        if (!hashMap.containsKey(uri))
          hashMap.put(uri, TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, uri)); 
      } 
    } 
    return (Map)Collections.unmodifiableMap(hashMap);
  }
  
  public static void requestFont(Context paramContext, FontRequest paramFontRequest, FontRequestCallback paramFontRequestCallback, Handler paramHandler) {
    a(paramContext.getApplicationContext(), paramFontRequest, paramFontRequestCallback, paramHandler);
  }
  
  public static void resetCache() {
    a.evictAll();
  }
  
  public static final class Columns implements BaseColumns {
    public static final String FILE_ID = "file_id";
    
    public static final String ITALIC = "font_italic";
    
    public static final String RESULT_CODE = "result_code";
    
    public static final int RESULT_CODE_FONT_NOT_FOUND = 1;
    
    public static final int RESULT_CODE_FONT_UNAVAILABLE = 2;
    
    public static final int RESULT_CODE_MALFORMED_QUERY = 3;
    
    public static final int RESULT_CODE_OK = 0;
    
    public static final String TTC_INDEX = "font_ttc_index";
    
    public static final String VARIATION_SETTINGS = "font_variation_settings";
    
    public static final String WEIGHT = "font_weight";
  }
  
  public static class FontFamilyResult {
    public static final int STATUS_OK = 0;
    
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    
    private final int a;
    
    private final FontsContractCompat.FontInfo[] b;
    
    public FontFamilyResult(int param1Int, FontsContractCompat.FontInfo[] param1ArrayOfFontInfo) {
      this.a = param1Int;
      this.b = param1ArrayOfFontInfo;
    }
    
    public FontsContractCompat.FontInfo[] getFonts() {
      return this.b;
    }
    
    public int getStatusCode() {
      return this.a;
    }
  }
  
  public static class FontInfo {
    private final Uri a;
    
    private final int b;
    
    private final int c;
    
    private final boolean d;
    
    private final int e;
    
    public FontInfo(Uri param1Uri, int param1Int1, int param1Int2, boolean param1Boolean, int param1Int3) {
      this.a = (Uri)Preconditions.checkNotNull(param1Uri);
      this.b = param1Int1;
      this.c = param1Int2;
      this.d = param1Boolean;
      this.e = param1Int3;
    }
    
    public int getResultCode() {
      return this.e;
    }
    
    public int getTtcIndex() {
      return this.b;
    }
    
    public Uri getUri() {
      return this.a;
    }
    
    public int getWeight() {
      return this.c;
    }
    
    public boolean isItalic() {
      return this.d;
    }
  }
  
  public static class FontRequestCallback {
    public static final int FAIL_REASON_FONT_LOAD_ERROR = -3;
    
    public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
    
    public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
    
    public static final int FAIL_REASON_MALFORMED_QUERY = 3;
    
    public static final int FAIL_REASON_PROVIDER_NOT_FOUND = -1;
    
    public static final int FAIL_REASON_SECURITY_VIOLATION = -4;
    
    public static final int FAIL_REASON_WRONG_CERTIFICATES = -2;
    
    public static final int RESULT_OK = 0;
    
    public void onTypefaceRequestFailed(int param1Int) {}
    
    public void onTypefaceRetrieved(Typeface param1Typeface) {}
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface FontRequestFailReason {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FontRequestFailReason {}
  
  static final class TypefaceResult {
    final Typeface a;
    
    final int b;
    
    TypefaceResult(Typeface param1Typeface, int param1Int) {
      this.a = param1Typeface;
      this.b = param1Int;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\provider\FontsContractCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */