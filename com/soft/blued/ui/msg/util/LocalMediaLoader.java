package com.soft.blued.ui.msg.util;

import android.content.Context;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.blued.android.framework.utils.AppUtils;
import com.soft.blued.ui.feed.model.ChildImageInfo;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

public final class LocalMediaLoader {
  private static final String a = LocalMediaLoader.class.getSimpleName();
  
  private static final Uri b = MediaStore.Files.getContentUri("external");
  
  private static final String[] f = new String[] { "_id", "_data", "mime_type", "width", "height", "duration", "_size", "bucket_display_name", "_display_name", "bucket_id" };
  
  private static final String[] g = new String[] { String.valueOf(1), String.valueOf(3) };
  
  private Context c;
  
  private boolean d;
  
  private int e;
  
  public LocalMediaLoader(Context paramContext, int paramInt) {
    this.c = paramContext.getApplicationContext();
    this.d = AppUtils.b();
    this.e = paramInt;
  }
  
  private String a(long paramLong) {
    return b.buildUpon().appendPath(a(Long.valueOf(paramLong))).build().toString();
  }
  
  private String a(long paramLong1, long paramLong2) {
    String str;
    long l = 300000L;
    if (paramLong1 != 0L)
      l = Math.min(300000L, paramLong1); 
    Locale locale = Locale.CHINA;
    paramLong1 = Math.max(paramLong2, 3000L);
    if (Math.max(paramLong2, 3000L) == 0L) {
      str = "";
    } else {
      str = "=";
    } 
    return String.format(locale, "%d <%s duration and duration <= %d", new Object[] { Long.valueOf(paramLong1), str, Long.valueOf(l) });
  }
  
  public static String a(Object paramObject) {
    try {
      return paramObject.toString();
    } catch (Exception exception) {
      return "";
    } 
  }
  
  private static String a(String paramString, boolean paramBoolean) {
    String str;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("(media_type=?");
    if (paramBoolean) {
      str = "";
    } else {
      str = " AND mime_type!='image/gif'";
    } 
    stringBuilder.append(str);
    stringBuilder.append(" OR ");
    stringBuilder.append("media_type=? AND ");
    stringBuilder.append(paramString);
    stringBuilder.append(") AND ");
    stringBuilder.append("_size");
    stringBuilder.append(">0");
    return stringBuilder.toString();
  }
  
  public static boolean a(String paramString) {
    return TextUtils.isEmpty(paramString) ? false : paramString.startsWith("content://");
  }
  
  private static String[] a(int paramInt) {
    return new String[] { String.valueOf(paramInt) };
  }
  
  private static String b() {
    return "media_type=? AND _size>0";
  }
  
  private String c() {
    int i = this.e;
    return (i != 0) ? ((i != 1) ? ((i != 2) ? null : b()) : "media_type=? AND _size>0") : a(a(0L, 0L), true);
  }
  
  private String[] d() {
    int i = this.e;
    return (i != 0) ? ((i != 1) ? ((i != 2) ? null : a(3)) : a(1)) : g;
  }
  
  public LinkedHashMap<String, List<ChildImageInfo>> a() {
    // Byte code:
    //   0: aload_0
    //   1: getfield c : Landroid/content/Context;
    //   4: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   7: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.b : Landroid/net/Uri;
    //   10: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   13: aload_0
    //   14: invokespecial c : ()Ljava/lang/String;
    //   17: aload_0
    //   18: invokespecial d : ()[Ljava/lang/String;
    //   21: ldc '_id DESC'
    //   23: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   26: astore #21
    //   28: aload #21
    //   30: ifnull -> 861
    //   33: new java/util/LinkedHashMap
    //   36: dup
    //   37: invokespecial <init> : ()V
    //   40: astore #22
    //   42: aload #22
    //   44: aload_0
    //   45: getfield c : Landroid/content/Context;
    //   48: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   51: ldc 2131757947
    //   53: invokevirtual getString : (I)Ljava/lang/String;
    //   56: new java/util/ArrayList
    //   59: dup
    //   60: invokespecial <init> : ()V
    //   63: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   66: pop
    //   67: aload #21
    //   69: invokeinterface getCount : ()I
    //   74: ifle -> 730
    //   77: aload #21
    //   79: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   82: iconst_0
    //   83: aaload
    //   84: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   89: istore #9
    //   91: aload #21
    //   93: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   96: iconst_1
    //   97: aaload
    //   98: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   103: istore #7
    //   105: aload #21
    //   107: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   110: iconst_2
    //   111: aaload
    //   112: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   117: istore #8
    //   119: aload #21
    //   121: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   124: iconst_3
    //   125: aaload
    //   126: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   131: istore #6
    //   133: aload #21
    //   135: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   138: iconst_4
    //   139: aaload
    //   140: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   145: istore #5
    //   147: aload #21
    //   149: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   152: iconst_5
    //   153: aaload
    //   154: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   159: istore #4
    //   161: aload #21
    //   163: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   166: bipush #6
    //   168: aaload
    //   169: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   174: istore_3
    //   175: aload #21
    //   177: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   180: bipush #7
    //   182: aaload
    //   183: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   188: istore_2
    //   189: aload #21
    //   191: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.f : [Ljava/lang/String;
    //   194: bipush #8
    //   196: aaload
    //   197: invokeinterface getColumnIndexOrThrow : (Ljava/lang/String;)I
    //   202: istore_1
    //   203: aload #21
    //   205: invokeinterface moveToFirst : ()Z
    //   210: pop
    //   211: aload #21
    //   213: iload #9
    //   215: invokeinterface getLong : (I)J
    //   220: lstore #12
    //   222: aload #21
    //   224: iload #7
    //   226: invokeinterface getString : (I)Ljava/lang/String;
    //   231: astore #20
    //   233: aload_0
    //   234: getfield d : Z
    //   237: ifeq -> 885
    //   240: aload_0
    //   241: lload #12
    //   243: invokespecial a : (J)Ljava/lang/String;
    //   246: astore #19
    //   248: goto -> 251
    //   251: aload #21
    //   253: iload #8
    //   255: invokeinterface getString : (I)Ljava/lang/String;
    //   260: astore #17
    //   262: aload #17
    //   264: astore #18
    //   266: aload #17
    //   268: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   271: ifeq -> 279
    //   274: invokestatic a : ()Ljava/lang/String;
    //   277: astore #18
    //   279: aload #18
    //   281: astore #17
    //   283: aload #18
    //   285: ldc_w 'image/*'
    //   288: invokevirtual endsWith : (Ljava/lang/String;)Z
    //   291: ifeq -> 319
    //   294: aload #19
    //   296: invokestatic c : (Ljava/lang/String;)Z
    //   299: ifeq -> 312
    //   302: aload #20
    //   304: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   307: astore #17
    //   309: goto -> 319
    //   312: aload #19
    //   314: invokestatic d : (Ljava/lang/String;)Ljava/lang/String;
    //   317: astore #17
    //   319: aload #21
    //   321: iload #6
    //   323: invokeinterface getInt : (I)I
    //   328: istore #10
    //   330: aload #21
    //   332: iload #5
    //   334: invokeinterface getInt : (I)I
    //   339: istore #11
    //   341: aload #21
    //   343: iload #4
    //   345: invokeinterface getLong : (I)J
    //   350: lstore #12
    //   352: aload #21
    //   354: iload_3
    //   355: invokeinterface getLong : (I)J
    //   360: lstore #14
    //   362: aload #21
    //   364: iload_2
    //   365: invokeinterface getString : (I)Ljava/lang/String;
    //   370: astore #23
    //   372: aload #21
    //   374: iload_1
    //   375: invokeinterface getString : (I)Ljava/lang/String;
    //   380: astore #18
    //   382: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.a : Ljava/lang/String;
    //   385: astore #24
    //   387: new java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial <init> : ()V
    //   394: astore #25
    //   396: aload #25
    //   398: ldc_w 'fileName : '
    //   401: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload #25
    //   407: aload #18
    //   409: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload #25
    //   415: ldc_w '    type :'
    //   418: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload #25
    //   424: aload #17
    //   426: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload #25
    //   432: ldc_w '  path :'
    //   435: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: pop
    //   439: aload #25
    //   441: aload #19
    //   443: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: aload #25
    //   449: ldc_w 'isAndroidQ : '
    //   452: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: aload #25
    //   458: aload_0
    //   459: getfield d : Z
    //   462: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload #24
    //   468: iconst_1
    //   469: anewarray java/lang/Object
    //   472: dup
    //   473: iconst_0
    //   474: aload #25
    //   476: invokevirtual toString : ()Ljava/lang/String;
    //   479: aastore
    //   480: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   483: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.a : Ljava/lang/String;
    //   486: astore #18
    //   488: new java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial <init> : ()V
    //   495: astore #24
    //   497: aload #24
    //   499: ldc_w 'absolutePath : '
    //   502: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload #24
    //   508: aload #20
    //   510: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload #24
    //   516: ldc_w ' || '
    //   519: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload #24
    //   525: aload #20
    //   527: invokestatic b : (Ljava/lang/String;)Z
    //   530: invokevirtual append : (Z)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload #18
    //   536: iconst_1
    //   537: anewarray java/lang/Object
    //   540: dup
    //   541: iconst_0
    //   542: aload #24
    //   544: invokevirtual toString : ()Ljava/lang/String;
    //   547: aastore
    //   548: invokestatic c : (Ljava/lang/String;[Ljava/lang/Object;)V
    //   551: aload #17
    //   553: invokestatic a : (Ljava/lang/String;)Z
    //   556: ifeq -> 571
    //   559: lload #12
    //   561: ldc2_w 3000
    //   564: lcmp
    //   565: ifge -> 895
    //   568: goto -> 892
    //   571: new com/soft/blued/ui/feed/model/ChildImageInfo
    //   574: dup
    //   575: invokespecial <init> : ()V
    //   578: astore #24
    //   580: aload #24
    //   582: iload #11
    //   584: putfield height : I
    //   587: aload #24
    //   589: iload #10
    //   591: putfield width : I
    //   594: aload #24
    //   596: aload #17
    //   598: putfield mediaType : Ljava/lang/String;
    //   601: aload #24
    //   603: lload #12
    //   605: putfield duration : J
    //   608: aload #24
    //   610: aload #19
    //   612: putfield imgUri : Ljava/lang/String;
    //   615: aload #24
    //   617: aload #20
    //   619: putfield mImagePath : Ljava/lang/String;
    //   622: aload #22
    //   624: aload #23
    //   626: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   629: checkcast java/util/List
    //   632: astore #18
    //   634: aload #18
    //   636: astore #17
    //   638: aload #18
    //   640: ifnonnull -> 652
    //   643: new java/util/ArrayList
    //   646: dup
    //   647: invokespecial <init> : ()V
    //   650: astore #17
    //   652: aload #17
    //   654: aload #24
    //   656: invokeinterface add : (Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload #22
    //   664: aload #23
    //   666: invokevirtual containsValue : (Ljava/lang/Object;)Z
    //   669: ifne -> 682
    //   672: aload #22
    //   674: aload #23
    //   676: aload #17
    //   678: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   681: pop
    //   682: aload #22
    //   684: aload_0
    //   685: getfield c : Landroid/content/Context;
    //   688: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   691: ldc 2131757947
    //   693: invokevirtual getString : (I)Ljava/lang/String;
    //   696: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   699: checkcast java/util/List
    //   702: aload #24
    //   704: invokeinterface add : (Ljava/lang/Object;)Z
    //   709: pop
    //   710: aload #21
    //   712: invokeinterface moveToNext : ()Z
    //   717: istore #16
    //   719: iload #16
    //   721: ifne -> 727
    //   724: goto -> 730
    //   727: goto -> 211
    //   730: aload #21
    //   732: ifnull -> 752
    //   735: aload #21
    //   737: invokeinterface isClosed : ()Z
    //   742: ifne -> 752
    //   745: aload #21
    //   747: invokeinterface close : ()V
    //   752: aload #22
    //   754: areturn
    //   755: astore #17
    //   757: goto -> 836
    //   760: astore #17
    //   762: aload #17
    //   764: invokevirtual printStackTrace : ()V
    //   767: getstatic com/soft/blued/ui/msg/util/LocalMediaLoader.a : Ljava/lang/String;
    //   770: astore #18
    //   772: new java/lang/StringBuilder
    //   775: dup
    //   776: invokespecial <init> : ()V
    //   779: astore #19
    //   781: aload #19
    //   783: ldc_w 'loadAllMedia Data Error: '
    //   786: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: pop
    //   790: aload #19
    //   792: aload #17
    //   794: invokevirtual getMessage : ()Ljava/lang/String;
    //   797: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   800: pop
    //   801: aload #18
    //   803: aload #19
    //   805: invokevirtual toString : ()Ljava/lang/String;
    //   808: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
    //   811: pop
    //   812: aload #21
    //   814: ifnull -> 834
    //   817: aload #21
    //   819: invokeinterface isClosed : ()Z
    //   824: ifne -> 834
    //   827: aload #21
    //   829: invokeinterface close : ()V
    //   834: aconst_null
    //   835: areturn
    //   836: aload #21
    //   838: ifnull -> 858
    //   841: aload #21
    //   843: invokeinterface isClosed : ()Z
    //   848: ifne -> 858
    //   851: aload #21
    //   853: invokeinterface close : ()V
    //   858: aload #17
    //   860: athrow
    //   861: aload #21
    //   863: ifnull -> 883
    //   866: aload #21
    //   868: invokeinterface isClosed : ()Z
    //   873: ifne -> 883
    //   876: aload #21
    //   878: invokeinterface close : ()V
    //   883: aconst_null
    //   884: areturn
    //   885: aload #20
    //   887: astore #19
    //   889: goto -> 251
    //   892: goto -> 710
    //   895: lload #12
    //   897: ldc2_w 300000
    //   900: lcmp
    //   901: ifle -> 907
    //   904: goto -> 892
    //   907: lload #12
    //   909: lconst_0
    //   910: lcmp
    //   911: ifne -> 917
    //   914: goto -> 892
    //   917: lload #14
    //   919: lconst_0
    //   920: lcmp
    //   921: ifgt -> 571
    //   924: goto -> 892
    // Exception table:
    //   from	to	target	type
    //   33	211	760	java/lang/Exception
    //   33	211	755	finally
    //   211	248	760	java/lang/Exception
    //   211	248	755	finally
    //   251	262	760	java/lang/Exception
    //   251	262	755	finally
    //   266	279	760	java/lang/Exception
    //   266	279	755	finally
    //   283	309	760	java/lang/Exception
    //   283	309	755	finally
    //   312	319	760	java/lang/Exception
    //   312	319	755	finally
    //   319	559	760	java/lang/Exception
    //   319	559	755	finally
    //   571	634	760	java/lang/Exception
    //   571	634	755	finally
    //   643	652	760	java/lang/Exception
    //   643	652	755	finally
    //   652	682	760	java/lang/Exception
    //   652	682	755	finally
    //   682	710	760	java/lang/Exception
    //   682	710	755	finally
    //   710	719	760	java/lang/Exception
    //   710	719	755	finally
    //   762	812	755	finally
  }
  
  public static class MediaType {
    public static String a() {
      return "image/jpeg";
    }
    
    public static boolean a(String param1String) {
      return (param1String != null && param1String.startsWith("video"));
    }
    
    public static boolean b(String param1String) {
      return (param1String != null && param1String.startsWith("image"));
    }
    
    public static boolean c(String param1String) {
      return TextUtils.isEmpty(param1String) ? false : param1String.startsWith("content://");
    }
    
    public static String d(String param1String) {
      try {
        if (!TextUtils.isEmpty(param1String)) {
          param1String = (new File(param1String)).getName();
          int i = param1String.lastIndexOf(".");
          if (i == -1) {
            param1String = "jpeg";
          } else {
            param1String = param1String.substring(i + 1);
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("image/");
          stringBuilder.append(param1String);
          return stringBuilder.toString();
        } 
        return "image/jpeg";
      } catch (Exception exception) {
        exception.printStackTrace();
        return "image/jpeg";
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\ms\\util\LocalMediaLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */