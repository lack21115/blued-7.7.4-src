package com.blued.android.module.media.selector.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;
import com.blued.android.core.image.ImageFileLoader;
import com.blued.android.core.image.ImageLoadResult;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.module.media.selector.R;
import com.blued.android.module.player.media.model.MediaInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Future;

public class ThumbLoader {
  public static String a;
  
  private static final String d = ThumbLoader.class.getSimpleName();
  
  private static ThumbLoader e;
  
  protected ConcurrentMap<Long, Future> b = new ConcurrentHashMap<Long, Future>();
  
  protected HashMap<ImageView, Long> c = new HashMap<ImageView, Long>();
  
  private ThreadPoolHelper.AlbumThread a(long paramLong, ImageView paramImageView, ThreadPoolHelper.AlbumThread paramAlbumThread) {
    this.b.put(Long.valueOf(paramLong), ThreadPoolHelper.a().b(paramAlbumThread));
    return paramAlbumThread;
  }
  
  public static ThumbLoader a() {
    if (e == null)
      e = new ThumbLoader(); 
    return e;
  }
  
  private void a(long paramLong) {
    ConcurrentMap<Long, Future> concurrentMap = this.b;
    if (concurrentMap != null) {
      Future future = concurrentMap.remove(Long.valueOf(paramLong));
      if (future != null)
        future.cancel(true); 
    } 
  }
  
  private void a(long paramLong, Bitmap paramBitmap) {
    Iterator<Map.Entry> iterator = this.c.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry entry = iterator.next();
      if (((Long)entry.getValue()).longValue() == paramLong) {
        ImageView imageView = (ImageView)entry.getKey();
        try {
          if (paramLong == ((Long)imageView.getTag()).longValue())
            imageView.setImageBitmap(paramBitmap); 
        } catch (Exception exception) {}
        a(imageView);
        break;
      } 
    } 
  }
  
  private void a(ImageView paramImageView) {
    this.c.remove(paramImageView);
  }
  
  private void a(ImageView paramImageView, long paramLong) {
    this.c.put(paramImageView, Long.valueOf(paramLong));
  }
  
  private void a(String paramString1, String paramString2) {
    if (!TextUtils.isEmpty(paramString2) && !TextUtils.isEmpty(paramString1) && (new File(paramString2)).exists())
      ImageFileLoader.a(null).a(paramString1, paramString2).a(); 
  }
  
  private boolean b(long paramLong) {
    return this.b.containsKey(Long.valueOf(paramLong));
  }
  
  private boolean b(ImageView paramImageView, long paramLong) {
    Long long_ = this.c.get(paramImageView);
    return (long_ != null && long_.longValue() == paramLong);
  }
  
  public void a(MediaInfo paramMediaInfo, ImageView paramImageView, LoadOptions paramLoadOptions) {
    if (TextUtils.isEmpty(paramMediaInfo.path)) {
      if (!TextUtils.isEmpty(paramMediaInfo.imgUri)) {
        ImageLoader.b(null, paramMediaInfo.imgUri).a(paramLoadOptions.b).a(paramImageView);
        a(paramImageView);
        return;
      } 
      if (!TextUtils.isEmpty(paramMediaInfo.imagePath)) {
        ImageLoader.d(null, paramMediaInfo.imagePath).a(paramLoadOptions.b).a(paramImageView);
        a(paramImageView);
        return;
      } 
      paramImageView.setImageResource(R.drawable.defaultpicture);
      return;
    } 
    ImageLoader.d(null, paramMediaInfo.path).a(R.drawable.defaultpicture).a(new ImageLoadResult(this, null, paramImageView, paramMediaInfo, paramLoadOptions) {
          public void a() {
            ThumbLoader.a(this.d, this.a);
          }
          
          public void a(int param1Int, Exception param1Exception) {
            ThumbLoader.a(this.d, this.a, this.b.id);
            if (!ThumbLoader.a(this.d, this.b.id)) {
              ThumbLoader thumbLoader = this.d;
              long l = this.b.id;
              ImageView imageView = this.a;
              ThumbLoader.a(thumbLoader, l, imageView, new ThumbLoader.CreateVideoThumsAsynctack(this.d, this.b, imageView, this.c));
            } 
          }
        }).a(paramImageView);
  }
  
  public void b() {
    ConcurrentMap<Long, Future> concurrentMap = this.b;
    if (concurrentMap != null) {
      Iterator<Future> iterator = concurrentMap.values().iterator();
      while (iterator.hasNext())
        ((Future)iterator.next()).cancel(true); 
    } 
  }
  
  class CreateVideoThumsAsynctack extends ThreadPoolHelper.AlbumThread {
    ImageView c;
    
    MediaInfo d;
    
    LoadOptions e;
    
    public CreateVideoThumsAsynctack(ThumbLoader this$0, MediaInfo param1MediaInfo, ImageView param1ImageView, LoadOptions param1LoadOptions) {
      this.d = param1MediaInfo;
      this.c = param1ImageView;
      this.e = param1LoadOptions;
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Z
      //   4: ifeq -> 829
      //   7: aload_0
      //   8: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   11: astore_3
      //   12: aload_3
      //   13: ifnull -> 829
      //   16: aload_3
      //   17: getfield path : Ljava/lang/String;
      //   20: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   23: ifne -> 829
      //   26: aload_0
      //   27: getfield e : Lcom/blued/android/core/imagecache/LoadOptions;
      //   30: ifnonnull -> 36
      //   33: goto -> 829
      //   36: aload_0
      //   37: iconst_0
      //   38: putfield b : Z
      //   41: getstatic android/os/Build$VERSION.SDK_INT : I
      //   44: istore_1
      //   45: aconst_null
      //   46: astore #4
      //   48: aconst_null
      //   49: astore #5
      //   51: aconst_null
      //   52: astore #7
      //   54: iload_1
      //   55: bipush #29
      //   57: if_icmplt -> 134
      //   60: invokestatic isExternalStorageLegacy : ()Z
      //   63: ifne -> 134
      //   66: getstatic android/provider/MediaStore$Video$Media.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
      //   69: aload_0
      //   70: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   73: getfield id : J
      //   76: invokestatic valueOf : (J)Ljava/lang/String;
      //   79: invokestatic withAppendedPath : (Landroid/net/Uri;Ljava/lang/String;)Landroid/net/Uri;
      //   82: astore_3
      //   83: invokestatic d : ()Landroid/content/Context;
      //   86: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
      //   89: astore #6
      //   91: aload_0
      //   92: getfield c : Landroid/widget/ImageView;
      //   95: invokevirtual getMeasuredWidth : ()I
      //   98: istore_2
      //   99: iload_2
      //   100: istore_1
      //   101: iload_2
      //   102: ifgt -> 109
      //   105: sipush #300
      //   108: istore_1
      //   109: aload #6
      //   111: aload_3
      //   112: new android/util/Size
      //   115: dup
      //   116: iload_1
      //   117: iload_1
      //   118: invokespecial <init> : (II)V
      //   121: aconst_null
      //   122: invokevirtual loadThumbnail : (Landroid/net/Uri;Landroid/util/Size;Landroid/os/CancellationSignal;)Landroid/graphics/Bitmap;
      //   125: astore_3
      //   126: goto -> 136
      //   129: astore_3
      //   130: aload_3
      //   131: invokevirtual printStackTrace : ()V
      //   134: aconst_null
      //   135: astore_3
      //   136: aload_3
      //   137: astore #6
      //   139: aload_3
      //   140: ifnonnull -> 254
      //   143: aload #7
      //   145: astore_3
      //   146: new android/media/MediaMetadataRetriever
      //   149: dup
      //   150: invokespecial <init> : ()V
      //   153: astore #4
      //   155: new java/lang/StringBuilder
      //   158: dup
      //   159: invokespecial <init> : ()V
      //   162: astore_3
      //   163: aload_3
      //   164: invokestatic c : ()Ljava/lang/String;
      //   167: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   170: pop
      //   171: aload_3
      //   172: ldc '获取视频帧,视频地址: '
      //   174: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   177: pop
      //   178: aload_3
      //   179: aload_0
      //   180: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   183: getfield path : Ljava/lang/String;
      //   186: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   189: pop
      //   190: iconst_1
      //   191: anewarray java/lang/Object
      //   194: dup
      //   195: iconst_0
      //   196: aload_3
      //   197: invokevirtual toString : ()Ljava/lang/String;
      //   200: aastore
      //   201: invokestatic a : ([Ljava/lang/Object;)V
      //   204: aload #4
      //   206: aload_0
      //   207: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   210: getfield path : Ljava/lang/String;
      //   213: invokevirtual setDataSource : (Ljava/lang/String;)V
      //   216: aload #4
      //   218: ldc2_w -1
      //   221: iconst_2
      //   222: invokevirtual getFrameAtTime : (JI)Landroid/graphics/Bitmap;
      //   225: astore #6
      //   227: goto -> 254
      //   230: astore #5
      //   232: aload #4
      //   234: astore_3
      //   235: aload #5
      //   237: astore #4
      //   239: goto -> 804
      //   242: aload #4
      //   244: astore #5
      //   246: goto -> 721
      //   249: astore #4
      //   251: goto -> 804
      //   254: aload #6
      //   256: ifnull -> 652
      //   259: aload #4
      //   261: astore_3
      //   262: aload #4
      //   264: astore #5
      //   266: aload_0
      //   267: getfield a : Z
      //   270: ifeq -> 652
      //   273: aload #4
      //   275: astore_3
      //   276: aload #4
      //   278: astore #5
      //   280: getstatic com/blued/android/module/media/selector/utils/ThumbLoader.a : Ljava/lang/String;
      //   283: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   286: ifeq -> 317
      //   289: aload #4
      //   291: astore_3
      //   292: aload #4
      //   294: astore #5
      //   296: ldc '/ShortVideo/img/'
      //   298: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
      //   301: putstatic com/blued/android/module/media/selector/utils/ThumbLoader.a : Ljava/lang/String;
      //   304: aload #4
      //   306: astore_3
      //   307: aload #4
      //   309: astore #5
      //   311: getstatic com/blued/android/module/media/selector/utils/ThumbLoader.a : Ljava/lang/String;
      //   314: invokestatic a : (Ljava/lang/String;)V
      //   317: aload #4
      //   319: astore_3
      //   320: aload #4
      //   322: astore #5
      //   324: new java/lang/StringBuilder
      //   327: dup
      //   328: invokespecial <init> : ()V
      //   331: astore #7
      //   333: aload #4
      //   335: astore_3
      //   336: aload #4
      //   338: astore #5
      //   340: aload #7
      //   342: getstatic com/blued/android/module/media/selector/utils/ThumbLoader.a : Ljava/lang/String;
      //   345: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   348: pop
      //   349: aload #4
      //   351: astore_3
      //   352: aload #4
      //   354: astore #5
      //   356: aload #7
      //   358: invokestatic currentTimeMillis : ()J
      //   361: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   364: pop
      //   365: aload #4
      //   367: astore_3
      //   368: aload #4
      //   370: astore #5
      //   372: aload #7
      //   374: ldc '.jpg'
      //   376: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   379: pop
      //   380: aload #4
      //   382: astore_3
      //   383: aload #4
      //   385: astore #5
      //   387: aload #7
      //   389: invokevirtual toString : ()Ljava/lang/String;
      //   392: astore #7
      //   394: aload #4
      //   396: astore_3
      //   397: aload #4
      //   399: astore #5
      //   401: getstatic com/blued/android/module/media/selector/utils/ThumbLoader.a : Ljava/lang/String;
      //   404: invokestatic b : (Ljava/lang/String;)V
      //   407: aload #4
      //   409: astore_3
      //   410: aload #4
      //   412: astore #5
      //   414: aload_0
      //   415: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   418: aload #7
      //   420: putfield imagePath : Ljava/lang/String;
      //   423: aload #4
      //   425: astore_3
      //   426: aload #4
      //   428: astore #5
      //   430: aload #6
      //   432: aload #7
      //   434: bipush #90
      //   436: invokestatic a : (Landroid/graphics/Bitmap;Ljava/lang/String;I)[B
      //   439: pop
      //   440: aload #4
      //   442: astore_3
      //   443: aload #4
      //   445: astore #5
      //   447: invokestatic n : ()Landroid/os/Handler;
      //   450: new com/blued/android/module/media/selector/utils/ThumbLoader$CreateVideoThumsAsynctack$1
      //   453: dup
      //   454: aload_0
      //   455: aload #6
      //   457: invokespecial <init> : (Lcom/blued/android/module/media/selector/utils/ThumbLoader$CreateVideoThumsAsynctack;Landroid/graphics/Bitmap;)V
      //   460: invokevirtual post : (Ljava/lang/Runnable;)Z
      //   463: pop
      //   464: aload #4
      //   466: astore_3
      //   467: aload #4
      //   469: astore #5
      //   471: new java/lang/StringBuilder
      //   474: dup
      //   475: invokespecial <init> : ()V
      //   478: astore #6
      //   480: aload #4
      //   482: astore_3
      //   483: aload #4
      //   485: astore #5
      //   487: aload #6
      //   489: invokestatic c : ()Ljava/lang/String;
      //   492: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   495: pop
      //   496: aload #4
      //   498: astore_3
      //   499: aload #4
      //   501: astore #5
      //   503: aload #6
      //   505: ldc ' 加入了缓存 id:'
      //   507: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   510: pop
      //   511: aload #4
      //   513: astore_3
      //   514: aload #4
      //   516: astore #5
      //   518: aload #6
      //   520: aload_0
      //   521: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   524: getfield id : J
      //   527: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   530: pop
      //   531: aload #4
      //   533: astore_3
      //   534: aload #4
      //   536: astore #5
      //   538: iconst_1
      //   539: anewarray java/lang/Object
      //   542: dup
      //   543: iconst_0
      //   544: aload #6
      //   546: invokevirtual toString : ()Ljava/lang/String;
      //   549: aastore
      //   550: invokestatic a : ([Ljava/lang/Object;)V
      //   553: aload #4
      //   555: astore_3
      //   556: aload #4
      //   558: astore #5
      //   560: aload_0
      //   561: getfield f : Lcom/blued/android/module/media/selector/utils/ThumbLoader;
      //   564: aload_0
      //   565: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   568: getfield path : Ljava/lang/String;
      //   571: aload #7
      //   573: invokestatic a : (Lcom/blued/android/module/media/selector/utils/ThumbLoader;Ljava/lang/String;Ljava/lang/String;)V
      //   576: aload #4
      //   578: astore_3
      //   579: aload #4
      //   581: astore #5
      //   583: new android/content/ContentValues
      //   586: dup
      //   587: invokespecial <init> : ()V
      //   590: astore #6
      //   592: aload #4
      //   594: astore_3
      //   595: aload #4
      //   597: astore #5
      //   599: aload #6
      //   601: ldc '_data'
      //   603: aload #7
      //   605: invokevirtual put : (Ljava/lang/String;Ljava/lang/String;)V
      //   608: aload #4
      //   610: astore_3
      //   611: aload #4
      //   613: astore #5
      //   615: invokestatic d : ()Landroid/content/Context;
      //   618: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
      //   621: getstatic android/provider/MediaStore$Video$Thumbnails.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
      //   624: aload #6
      //   626: ldc 'video_id=?'
      //   628: iconst_1
      //   629: anewarray java/lang/String
      //   632: dup
      //   633: iconst_0
      //   634: aload_0
      //   635: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   638: getfield id : J
      //   641: invokestatic valueOf : (J)Ljava/lang/String;
      //   644: aastore
      //   645: invokevirtual update : (Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
      //   648: pop
      //   649: goto -> 688
      //   652: aload #4
      //   654: astore_3
      //   655: aload #4
      //   657: astore #5
      //   659: aload_0
      //   660: getfield e : Lcom/blued/android/core/imagecache/LoadOptions;
      //   663: ifnull -> 688
      //   666: aload #4
      //   668: astore_3
      //   669: aload #4
      //   671: astore #5
      //   673: invokestatic n : ()Landroid/os/Handler;
      //   676: new com/blued/android/module/media/selector/utils/ThumbLoader$CreateVideoThumsAsynctack$2
      //   679: dup
      //   680: aload_0
      //   681: invokespecial <init> : (Lcom/blued/android/module/media/selector/utils/ThumbLoader$CreateVideoThumsAsynctack;)V
      //   684: invokevirtual post : (Ljava/lang/Runnable;)Z
      //   687: pop
      //   688: aload #4
      //   690: ifnull -> 698
      //   693: aload #4
      //   695: invokevirtual release : ()V
      //   698: aload_0
      //   699: getfield f : Lcom/blued/android/module/media/selector/utils/ThumbLoader;
      //   702: astore_3
      //   703: aload_0
      //   704: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   707: astore #4
      //   709: aload_3
      //   710: aload #4
      //   712: getfield id : J
      //   715: invokestatic b : (Lcom/blued/android/module/media/selector/utils/ThumbLoader;J)V
      //   718: goto -> 798
      //   721: aload #5
      //   723: astore_3
      //   724: new java/lang/StringBuilder
      //   727: dup
      //   728: invokespecial <init> : ()V
      //   731: astore #4
      //   733: aload #5
      //   735: astore_3
      //   736: aload #4
      //   738: invokestatic c : ()Ljava/lang/String;
      //   741: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   744: pop
      //   745: aload #5
      //   747: astore_3
      //   748: aload #4
      //   750: ldc ' 获取视频帧,异常！！！'
      //   752: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   755: pop
      //   756: aload #5
      //   758: astore_3
      //   759: iconst_1
      //   760: anewarray java/lang/Object
      //   763: dup
      //   764: iconst_0
      //   765: aload #4
      //   767: invokevirtual toString : ()Ljava/lang/String;
      //   770: aastore
      //   771: invokestatic a : ([Ljava/lang/Object;)V
      //   774: aload #5
      //   776: ifnull -> 784
      //   779: aload #5
      //   781: invokevirtual release : ()V
      //   784: aload_0
      //   785: getfield f : Lcom/blued/android/module/media/selector/utils/ThumbLoader;
      //   788: astore_3
      //   789: aload_0
      //   790: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   793: astore #4
      //   795: goto -> 709
      //   798: aload_0
      //   799: iconst_1
      //   800: putfield b : Z
      //   803: return
      //   804: aload_3
      //   805: ifnull -> 812
      //   808: aload_3
      //   809: invokevirtual release : ()V
      //   812: aload_0
      //   813: getfield f : Lcom/blued/android/module/media/selector/utils/ThumbLoader;
      //   816: aload_0
      //   817: getfield d : Lcom/blued/android/module/player/media/model/MediaInfo;
      //   820: getfield id : J
      //   823: invokestatic b : (Lcom/blued/android/module/media/selector/utils/ThumbLoader;J)V
      //   826: aload #4
      //   828: athrow
      //   829: aload_0
      //   830: iconst_1
      //   831: putfield b : Z
      //   834: return
      //   835: astore_3
      //   836: goto -> 721
      //   839: astore_3
      //   840: goto -> 242
      //   843: astore_3
      //   844: goto -> 798
      //   847: astore_3
      //   848: goto -> 826
      // Exception table:
      //   from	to	target	type
      //   91	99	129	java/io/IOException
      //   109	126	129	java/io/IOException
      //   146	155	835	java/lang/Exception
      //   146	155	249	finally
      //   155	227	839	java/lang/Exception
      //   155	227	230	finally
      //   266	273	835	java/lang/Exception
      //   266	273	249	finally
      //   280	289	835	java/lang/Exception
      //   280	289	249	finally
      //   296	304	835	java/lang/Exception
      //   296	304	249	finally
      //   311	317	835	java/lang/Exception
      //   311	317	249	finally
      //   324	333	835	java/lang/Exception
      //   324	333	249	finally
      //   340	349	835	java/lang/Exception
      //   340	349	249	finally
      //   356	365	835	java/lang/Exception
      //   356	365	249	finally
      //   372	380	835	java/lang/Exception
      //   372	380	249	finally
      //   387	394	835	java/lang/Exception
      //   387	394	249	finally
      //   401	407	835	java/lang/Exception
      //   401	407	249	finally
      //   414	423	835	java/lang/Exception
      //   414	423	249	finally
      //   430	440	835	java/lang/Exception
      //   430	440	249	finally
      //   447	464	835	java/lang/Exception
      //   447	464	249	finally
      //   471	480	835	java/lang/Exception
      //   471	480	249	finally
      //   487	496	835	java/lang/Exception
      //   487	496	249	finally
      //   503	511	835	java/lang/Exception
      //   503	511	249	finally
      //   518	531	835	java/lang/Exception
      //   518	531	249	finally
      //   538	553	835	java/lang/Exception
      //   538	553	249	finally
      //   560	576	835	java/lang/Exception
      //   560	576	249	finally
      //   583	592	835	java/lang/Exception
      //   583	592	249	finally
      //   599	608	835	java/lang/Exception
      //   599	608	249	finally
      //   615	649	835	java/lang/Exception
      //   615	649	249	finally
      //   659	666	835	java/lang/Exception
      //   659	666	249	finally
      //   673	688	835	java/lang/Exception
      //   673	688	249	finally
      //   693	698	843	java/lang/RuntimeException
      //   698	709	843	java/lang/RuntimeException
      //   709	718	843	java/lang/RuntimeException
      //   724	733	249	finally
      //   736	745	249	finally
      //   748	756	249	finally
      //   759	774	249	finally
      //   779	784	843	java/lang/RuntimeException
      //   784	795	843	java/lang/RuntimeException
      //   808	812	847	java/lang/RuntimeException
      //   812	826	847	java/lang/RuntimeException
    }
  }
  
  class null implements Runnable {
    null(ThumbLoader this$0, Bitmap param1Bitmap) {}
    
    public void run() {
      if (this.b.a) {
        if (ThumbLoader.b(this.b.f, this.b.c, this.b.d.id)) {
          try {
            if (this.b.d.id == ((Long)this.b.c.getTag()).longValue())
              this.b.c.setImageBitmap(this.a); 
          } catch (Exception exception) {}
          ThumbLoader.a(this.b.f, this.b.c);
          return;
        } 
        ThumbLoader.a(this.b.f, this.b.d.id, this.a);
      } 
    }
  }
  
  class null implements Runnable {
    null(ThumbLoader this$0) {}
    
    public void run() {
      if (ThumbLoader.b(this.a.f, this.a.c, this.a.d.id)) {
        this.a.c.setImageResource(this.a.e.b);
        ThumbLoader.a(this.a.f, this.a.c);
      } 
    }
  }
  
  public static class GetVideoThumsAsynctack extends ThreadPoolHelper.AlbumThread {
    ThumbLoader.OnGetVideoThumsListener c;
    
    HashMap<String, MediaInfo> d = new HashMap<String, MediaInfo>();
    
    List<MediaInfo> e;
    
    public GetVideoThumsAsynctack(ThumbLoader.OnGetVideoThumsListener param1OnGetVideoThumsListener, List<MediaInfo> param1List) {
      this.c = param1OnGetVideoThumsListener;
      this.e = param1List;
    }
    
    public void run() {
      // Byte code:
      //   0: aload_0
      //   1: getfield a : Z
      //   4: ifeq -> 501
      //   7: aload_0
      //   8: getfield e : Ljava/util/List;
      //   11: astore_2
      //   12: aload_2
      //   13: ifnull -> 501
      //   16: aload_2
      //   17: invokeinterface size : ()I
      //   22: iconst_1
      //   23: if_icmpge -> 29
      //   26: goto -> 501
      //   29: iconst_0
      //   30: istore_1
      //   31: iload_1
      //   32: aload_0
      //   33: getfield e : Ljava/util/List;
      //   36: invokeinterface size : ()I
      //   41: if_icmpge -> 85
      //   44: aload_0
      //   45: getfield e : Ljava/util/List;
      //   48: iload_1
      //   49: invokeinterface get : (I)Ljava/lang/Object;
      //   54: checkcast com/blued/android/module/player/media/model/MediaInfo
      //   57: astore_2
      //   58: aload_2
      //   59: ifnull -> 78
      //   62: aload_0
      //   63: getfield d : Ljava/util/HashMap;
      //   66: aload_2
      //   67: getfield id : J
      //   70: invokestatic valueOf : (J)Ljava/lang/String;
      //   73: aload_2
      //   74: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
      //   77: pop
      //   78: iload_1
      //   79: iconst_1
      //   80: iadd
      //   81: istore_1
      //   82: goto -> 31
      //   85: aload_0
      //   86: iconst_0
      //   87: putfield b : Z
      //   90: ldc 'video_id in ('
      //   92: astore_3
      //   93: iconst_0
      //   94: istore_1
      //   95: iload_1
      //   96: aload_0
      //   97: getfield e : Ljava/util/List;
      //   100: invokeinterface size : ()I
      //   105: if_icmpge -> 250
      //   108: aload_0
      //   109: getfield e : Ljava/util/List;
      //   112: iload_1
      //   113: invokeinterface get : (I)Ljava/lang/Object;
      //   118: checkcast com/blued/android/module/player/media/model/MediaInfo
      //   121: astore #4
      //   123: aload_3
      //   124: astore_2
      //   125: aload #4
      //   127: ifnull -> 177
      //   130: aload_3
      //   131: astore_2
      //   132: aload #4
      //   134: getfield media_type : I
      //   137: iconst_3
      //   138: if_icmpne -> 177
      //   141: new java/lang/StringBuilder
      //   144: dup
      //   145: invokespecial <init> : ()V
      //   148: astore_2
      //   149: aload_2
      //   150: aload_3
      //   151: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   154: pop
      //   155: aload_2
      //   156: aload #4
      //   158: getfield id : J
      //   161: invokevirtual append : (J)Ljava/lang/StringBuilder;
      //   164: pop
      //   165: aload_2
      //   166: ldc ','
      //   168: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   171: pop
      //   172: aload_2
      //   173: invokevirtual toString : ()Ljava/lang/String;
      //   176: astore_2
      //   177: aload_2
      //   178: astore_3
      //   179: iload_1
      //   180: aload_0
      //   181: getfield e : Ljava/util/List;
      //   184: invokeinterface size : ()I
      //   189: iconst_1
      //   190: isub
      //   191: if_icmpne -> 243
      //   194: aload_2
      //   195: astore_3
      //   196: aload_2
      //   197: ldc ','
      //   199: invokevirtual lastIndexOf : (Ljava/lang/String;)I
      //   202: ifle -> 217
      //   205: aload_2
      //   206: iconst_0
      //   207: aload_2
      //   208: ldc ','
      //   210: invokevirtual lastIndexOf : (Ljava/lang/String;)I
      //   213: invokevirtual substring : (II)Ljava/lang/String;
      //   216: astore_3
      //   217: new java/lang/StringBuilder
      //   220: dup
      //   221: invokespecial <init> : ()V
      //   224: astore_2
      //   225: aload_2
      //   226: aload_3
      //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   230: pop
      //   231: aload_2
      //   232: ldc ')'
      //   234: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: pop
      //   238: aload_2
      //   239: invokevirtual toString : ()Ljava/lang/String;
      //   242: astore_3
      //   243: iload_1
      //   244: iconst_1
      //   245: iadd
      //   246: istore_1
      //   247: goto -> 95
      //   250: invokestatic d : ()Landroid/content/Context;
      //   253: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
      //   256: getstatic android/provider/MediaStore$Video$Thumbnails.EXTERNAL_CONTENT_URI : Landroid/net/Uri;
      //   259: iconst_2
      //   260: anewarray java/lang/String
      //   263: dup
      //   264: iconst_0
      //   265: ldc '_data'
      //   267: aastore
      //   268: dup
      //   269: iconst_1
      //   270: ldc 'video_id'
      //   272: aastore
      //   273: aload_3
      //   274: aconst_null
      //   275: aconst_null
      //   276: invokevirtual query : (Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   279: astore_2
      //   280: invokestatic d : ()Landroid/content/Context;
      //   283: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
      //   286: aload_0
      //   287: getfield e : Ljava/util/List;
      //   290: iconst_0
      //   291: invokeinterface get : (I)Ljava/lang/Object;
      //   296: checkcast com/blued/android/module/player/media/model/MediaInfo
      //   299: getfield id : J
      //   302: iconst_2
      //   303: aconst_null
      //   304: invokestatic getThumbnail : (Landroid/content/ContentResolver;JILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
      //   307: pop
      //   308: aload_2
      //   309: ifnull -> 446
      //   312: aload_2
      //   313: invokeinterface moveToFirst : ()Z
      //   318: ifeq -> 446
      //   321: aload_2
      //   322: invokeinterface moveToNext : ()Z
      //   327: ifeq -> 446
      //   330: aload_0
      //   331: getfield a : Z
      //   334: ifeq -> 446
      //   337: aload_2
      //   338: iconst_0
      //   339: invokeinterface getString : (I)Ljava/lang/String;
      //   344: astore_3
      //   345: getstatic com/blued/android/module/media/selector/utils/ThumbLoader.a : Ljava/lang/String;
      //   348: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
      //   351: ifeq -> 395
      //   354: aload_3
      //   355: iconst_0
      //   356: aload_3
      //   357: ldc '/'
      //   359: invokevirtual lastIndexOf : (Ljava/lang/String;)I
      //   362: iconst_1
      //   363: iadd
      //   364: invokevirtual substring : (II)Ljava/lang/String;
      //   367: astore #4
      //   369: aload #4
      //   371: ldc '/ShortVideo/img/'
      //   373: invokestatic b : (Ljava/lang/String;)Ljava/lang/String;
      //   376: invokevirtual equals : (Ljava/lang/Object;)Z
      //   379: ifeq -> 390
      //   382: aload #4
      //   384: invokestatic a : (Ljava/lang/String;)V
      //   387: goto -> 395
      //   390: aload #4
      //   392: putstatic com/blued/android/module/media/selector/utils/ThumbLoader.a : Ljava/lang/String;
      //   395: aload_2
      //   396: iconst_1
      //   397: invokeinterface getString : (I)Ljava/lang/String;
      //   402: astore #4
      //   404: aload_0
      //   405: getfield d : Ljava/util/HashMap;
      //   408: aload #4
      //   410: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
      //   413: checkcast com/blued/android/module/player/media/model/MediaInfo
      //   416: astore #4
      //   418: aload #4
      //   420: ifnull -> 321
      //   423: new java/io/File
      //   426: dup
      //   427: aload_3
      //   428: invokespecial <init> : (Ljava/lang/String;)V
      //   431: invokevirtual exists : ()Z
      //   434: ifeq -> 321
      //   437: aload #4
      //   439: aload_3
      //   440: putfield imagePath : Ljava/lang/String;
      //   443: goto -> 321
      //   446: aload_2
      //   447: ifnull -> 476
      //   450: goto -> 470
      //   453: astore_3
      //   454: aload_2
      //   455: ifnull -> 464
      //   458: aload_2
      //   459: invokeinterface close : ()V
      //   464: aload_3
      //   465: athrow
      //   466: aload_2
      //   467: ifnull -> 476
      //   470: aload_2
      //   471: invokeinterface close : ()V
      //   476: aload_0
      //   477: getfield c : Lcom/blued/android/module/media/selector/utils/ThumbLoader$OnGetVideoThumsListener;
      //   480: astore_2
      //   481: aload_2
      //   482: ifnull -> 495
      //   485: aload_2
      //   486: aload_0
      //   487: getfield e : Ljava/util/List;
      //   490: invokeinterface a : (Ljava/util/List;)V
      //   495: aload_0
      //   496: iconst_1
      //   497: putfield b : Z
      //   500: return
      //   501: aload_0
      //   502: getfield c : Lcom/blued/android/module/media/selector/utils/ThumbLoader$OnGetVideoThumsListener;
      //   505: astore_2
      //   506: aload_2
      //   507: ifnull -> 520
      //   510: aload_2
      //   511: aload_0
      //   512: getfield e : Ljava/util/List;
      //   515: invokeinterface a : (Ljava/util/List;)V
      //   520: aload_0
      //   521: iconst_1
      //   522: putfield b : Z
      //   525: return
      //   526: astore_3
      //   527: goto -> 466
      // Exception table:
      //   from	to	target	type
      //   280	308	526	java/lang/Exception
      //   280	308	453	finally
      //   312	321	526	java/lang/Exception
      //   312	321	453	finally
      //   321	387	526	java/lang/Exception
      //   321	387	453	finally
      //   390	395	526	java/lang/Exception
      //   390	395	453	finally
      //   395	418	526	java/lang/Exception
      //   395	418	453	finally
      //   423	443	526	java/lang/Exception
      //   423	443	453	finally
    }
  }
  
  public static interface OnGetVideoThumsListener<T> {
    void a(List<T> param1List);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\selecto\\utils\ThumbLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */