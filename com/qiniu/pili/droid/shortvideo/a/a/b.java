package com.qiniu.pili.droid.shortvideo.a.a;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import com.qiniu.pili.droid.shortvideo.PLCameraParamSelectListener;
import com.qiniu.pili.droid.shortvideo.PLCameraPreviewListener;
import com.qiniu.pili.droid.shortvideo.PLCameraSetting;
import com.qiniu.pili.droid.shortvideo.PLFocusListener;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class b implements SurfaceTexture.OnFrameAvailableListener, Camera.PreviewCallback {
  private Context a;
  
  private PLCameraPreviewListener b;
  
  private PLCameraParamSelectListener c;
  
  private PLCameraSetting d;
  
  private int e = -1;
  
  private int f = 1;
  
  private int g;
  
  private int h;
  
  private int i;
  
  private int j;
  
  private e k;
  
  private a l;
  
  private PLFocusListener m;
  
  private List<Float> n;
  
  public b(Context paramContext, PLCameraSetting paramPLCameraSetting) {
    this.a = paramContext;
    this.d = paramPLCameraSetting;
    this.f = this.d.getCameraId().ordinal();
    e.f.c("CameraManager", "CameraManager created !");
  }
  
  private static List<Camera.Size> a(List<Camera.Size> paramList) {
    if (paramList == null)
      return null; 
    Collections.sort(paramList, new Comparator<Camera.Size>() {
          public int a(Camera.Size param1Size1, Camera.Size param1Size2) {
            return param1Size1.width * param1Size1.height - param1Size2.width * param1Size2.height;
          }
        });
    return paramList;
  }
  
  private List<Camera.Size> a(List<Camera.Size> paramList, PLCameraSetting.CAMERA_PREVIEW_SIZE_RATIO paramCAMERA_PREVIEW_SIZE_RATIO, PLCameraSetting.CAMERA_PREVIEW_SIZE_LEVEL paramCAMERA_PREVIEW_SIZE_LEVEL) {
    String str;
    if (paramList == null)
      return null; 
    ArrayList<Camera.Size> arrayList2 = new ArrayList();
    double d = PLCameraSetting.calcCameraPreviewSizeRatio(paramCAMERA_PREVIEW_SIZE_RATIO);
    e e1 = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("filterCameraPreviewSize targetRatio : ");
    stringBuilder.append(d);
    e1.c("CameraManager", stringBuilder.toString());
    Iterator<Camera.Size> iterator = paramList.iterator();
    while (iterator.hasNext()) {
      Camera.Size size = iterator.next();
      e e3 = e.f;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append("size.width:");
      stringBuilder1.append(size.width);
      stringBuilder1.append(",size.height:");
      stringBuilder1.append(size.height);
      e3.c("CameraManager", stringBuilder1.toString());
      if (Math.abs(size.width / size.height - d) > 0.05D) {
        arrayList2.add(size);
        iterator.remove();
      } 
    } 
    ArrayList<Camera.Size> arrayList1 = new ArrayList();
    int i = PLCameraSetting.calcCameraPreviewSizeLevel(paramCAMERA_PREVIEW_SIZE_LEVEL);
    e e2 = e.f;
    stringBuilder = new StringBuilder();
    stringBuilder.append("filterCameraPreviewSize targetLevel : ");
    stringBuilder.append(i);
    e2.c("CameraManager", stringBuilder.toString());
    null = paramList.iterator();
    while (null.hasNext()) {
      Camera.Size size = null.next();
      if (size.height != i) {
        arrayList1.add(size);
        null.remove();
      } 
    } 
    if (paramList.isEmpty()) {
      if (arrayList1.isEmpty()) {
        paramList = arrayList2;
      } else {
        paramList = arrayList1;
      } 
      if (arrayList1.isEmpty()) {
        str = "after no filter";
      } else {
        str = "after ratio filter";
      } 
    } else {
      str = "after ratio and level filter";
    } 
    for (Camera.Size size : paramList) {
      e e3 = e.f;
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append(" size.w:");
      stringBuilder1.append(size.width);
      stringBuilder1.append(", size.h:");
      stringBuilder1.append(size.height);
      e3.c("CameraManager", stringBuilder1.toString());
    } 
    return paramList;
  }
  
  private boolean i() {
    // Byte code:
    //   0: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   3: ldc 'CameraManager'
    //   5: ldc 'setupCamera +'
    //   7: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: getfield a : Landroid/content/Context;
    //   14: invokestatic a : (Landroid/content/Context;)Z
    //   17: istore #4
    //   19: iconst_0
    //   20: istore_2
    //   21: iload #4
    //   23: ifne -> 38
    //   26: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   29: ldc 'CameraManager'
    //   31: ldc 'failed, No camera hardware !'
    //   33: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   36: iconst_0
    //   37: ireturn
    //   38: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   41: aload_0
    //   42: getfield f : I
    //   45: invokevirtual a : (I)Z
    //   48: ifne -> 53
    //   51: iconst_0
    //   52: ireturn
    //   53: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   56: invokevirtual k : ()Landroid/hardware/Camera$Parameters;
    //   59: astore #8
    //   61: aload #8
    //   63: ifnonnull -> 78
    //   66: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   69: ldc 'CameraManager'
    //   71: ldc 'failed to get camera params'
    //   73: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   76: iconst_0
    //   77: ireturn
    //   78: aload #8
    //   80: invokevirtual getSupportedPreviewFormats : ()Ljava/util/List;
    //   83: astore #5
    //   85: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   88: astore #6
    //   90: new java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial <init> : ()V
    //   97: astore #7
    //   99: aload #7
    //   101: ldc 'supported camera preview formats: '
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload #7
    //   109: aload #5
    //   111: invokeinterface size : ()I
    //   116: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload #6
    //   122: ldc 'CameraManager'
    //   124: aload #7
    //   126: invokevirtual toString : ()Ljava/lang/String;
    //   129: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   132: aload #5
    //   134: invokeinterface iterator : ()Ljava/util/Iterator;
    //   139: astore #5
    //   141: aload #5
    //   143: invokeinterface hasNext : ()Z
    //   148: ifeq -> 193
    //   151: aload #5
    //   153: invokeinterface next : ()Ljava/lang/Object;
    //   158: checkcast java/lang/Integer
    //   161: invokevirtual intValue : ()I
    //   164: bipush #17
    //   166: if_icmpne -> 141
    //   169: aload #8
    //   171: bipush #17
    //   173: invokevirtual setPreviewFormat : (I)V
    //   176: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   179: ldc 'CameraManager'
    //   181: ldc 'set camera preview format NV21'
    //   183: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: getstatic com/qiniu/pili/droid/shortvideo/PLFourCC.FOURCC_NV21 : I
    //   190: putfield e : I
    //   193: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   196: invokevirtual l : ()Ljava/util/List;
    //   199: astore #5
    //   201: aconst_null
    //   202: astore #6
    //   204: aload #5
    //   206: ifnull -> 234
    //   209: aload_0
    //   210: getfield c : Lcom/qiniu/pili/droid/shortvideo/PLCameraParamSelectListener;
    //   213: astore #7
    //   215: aload #7
    //   217: ifnull -> 234
    //   220: aload #7
    //   222: aload #5
    //   224: invokeinterface onPreviewFpsSelected : (Ljava/util/List;)[I
    //   229: astore #5
    //   231: goto -> 237
    //   234: aconst_null
    //   235: astore #5
    //   237: aload #5
    //   239: ifnull -> 324
    //   242: aload #5
    //   244: arraylength
    //   245: iconst_2
    //   246: if_icmpne -> 324
    //   249: aload #8
    //   251: aload #5
    //   253: iconst_0
    //   254: iaload
    //   255: aload #5
    //   257: iconst_1
    //   258: iaload
    //   259: invokevirtual setPreviewFpsRange : (II)V
    //   262: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   265: astore #7
    //   267: new java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial <init> : ()V
    //   274: astore #9
    //   276: aload #9
    //   278: ldc 'set camera preview fps: '
    //   280: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload #9
    //   286: aload #5
    //   288: iconst_0
    //   289: iaload
    //   290: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: aload #9
    //   296: ldc '~'
    //   298: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: pop
    //   302: aload #9
    //   304: aload #5
    //   306: iconst_1
    //   307: iaload
    //   308: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload #7
    //   314: ldc 'CameraManager'
    //   316: aload #9
    //   318: invokevirtual toString : ()Ljava/lang/String;
    //   321: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload #8
    //   326: invokevirtual getSupportedPreviewSizes : ()Ljava/util/List;
    //   329: astore #5
    //   331: aload #5
    //   333: ifnull -> 998
    //   336: aload #5
    //   338: invokeinterface isEmpty : ()Z
    //   343: ifeq -> 349
    //   346: goto -> 998
    //   349: aload_0
    //   350: aload #5
    //   352: aload_0
    //   353: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLCameraSetting;
    //   356: invokevirtual getCameraPreviewSizeRatio : ()Lcom/qiniu/pili/droid/shortvideo/PLCameraSetting$CAMERA_PREVIEW_SIZE_RATIO;
    //   359: aload_0
    //   360: getfield d : Lcom/qiniu/pili/droid/shortvideo/PLCameraSetting;
    //   363: invokevirtual getCameraPreviewSizeLevel : ()Lcom/qiniu/pili/droid/shortvideo/PLCameraSetting$CAMERA_PREVIEW_SIZE_LEVEL;
    //   366: invokespecial a : (Ljava/util/List;Lcom/qiniu/pili/droid/shortvideo/PLCameraSetting$CAMERA_PREVIEW_SIZE_RATIO;Lcom/qiniu/pili/droid/shortvideo/PLCameraSetting$CAMERA_PREVIEW_SIZE_LEVEL;)Ljava/util/List;
    //   369: invokestatic a : (Ljava/util/List;)Ljava/util/List;
    //   372: astore #9
    //   374: aload #9
    //   376: ifnull -> 985
    //   379: aload #9
    //   381: invokeinterface isEmpty : ()Z
    //   386: ifne -> 985
    //   389: aload_0
    //   390: getfield c : Lcom/qiniu/pili/droid/shortvideo/PLCameraParamSelectListener;
    //   393: astore #5
    //   395: aload #5
    //   397: ifnull -> 414
    //   400: aload #5
    //   402: aload #9
    //   404: invokeinterface onPreviewSizeSelected : (Ljava/util/List;)Landroid/hardware/Camera$Size;
    //   409: astore #5
    //   411: goto -> 417
    //   414: aconst_null
    //   415: astore #5
    //   417: aload #5
    //   419: astore #7
    //   421: aload #5
    //   423: ifnonnull -> 447
    //   426: aload #9
    //   428: aload #9
    //   430: invokeinterface size : ()I
    //   435: iconst_2
    //   436: idiv
    //   437: invokeinterface get : (I)Ljava/lang/Object;
    //   442: checkcast android/hardware/Camera$Size
    //   445: astore #7
    //   447: aload #8
    //   449: aload #7
    //   451: getfield width : I
    //   454: aload #7
    //   456: getfield height : I
    //   459: invokevirtual setPreviewSize : (II)V
    //   462: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   465: astore #5
    //   467: new java/lang/StringBuilder
    //   470: dup
    //   471: invokespecial <init> : ()V
    //   474: astore #9
    //   476: aload #9
    //   478: ldc_w 'set camera preview size: '
    //   481: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: aload #9
    //   487: aload #7
    //   489: getfield width : I
    //   492: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: aload #9
    //   498: ldc_w 'x'
    //   501: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload #9
    //   507: aload #7
    //   509: getfield height : I
    //   512: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload #5
    //   518: ldc 'CameraManager'
    //   520: aload #9
    //   522: invokevirtual toString : ()Ljava/lang/String;
    //   525: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: aload #7
    //   531: getfield width : I
    //   534: putfield g : I
    //   537: aload_0
    //   538: aload #7
    //   540: getfield height : I
    //   543: putfield h : I
    //   546: aload #8
    //   548: invokevirtual getSupportedFocusModes : ()Ljava/util/List;
    //   551: astore #9
    //   553: aload #9
    //   555: ifnull -> 717
    //   558: aload #9
    //   560: invokeinterface isEmpty : ()Z
    //   565: ifne -> 717
    //   568: aload_0
    //   569: getfield c : Lcom/qiniu/pili/droid/shortvideo/PLCameraParamSelectListener;
    //   572: astore #10
    //   574: aload #6
    //   576: astore #5
    //   578: aload #10
    //   580: ifnull -> 624
    //   583: aload #10
    //   585: aload #9
    //   587: invokeinterface onFocusModeSelected : (Ljava/util/List;)Ljava/lang/String;
    //   592: astore #5
    //   594: aload #9
    //   596: aload #5
    //   598: invokeinterface contains : (Ljava/lang/Object;)Z
    //   603: ifne -> 624
    //   606: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   609: ldc 'CameraManager'
    //   611: ldc_w 'no such focus mode exists in this camera'
    //   614: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   617: aload #6
    //   619: astore #5
    //   621: goto -> 624
    //   624: aload #5
    //   626: astore #6
    //   628: aload #5
    //   630: ifnonnull -> 667
    //   633: aload #9
    //   635: ldc_w 'continuous-video'
    //   638: invokeinterface contains : (Ljava/lang/Object;)Z
    //   643: ifeq -> 654
    //   646: ldc_w 'continuous-video'
    //   649: astore #6
    //   651: goto -> 667
    //   654: aload #9
    //   656: iconst_0
    //   657: invokeinterface get : (I)Ljava/lang/Object;
    //   662: checkcast java/lang/String
    //   665: astore #6
    //   667: aload #8
    //   669: aload #6
    //   671: invokevirtual setFocusMode : (Ljava/lang/String;)V
    //   674: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   677: astore #5
    //   679: new java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial <init> : ()V
    //   686: astore #9
    //   688: aload #9
    //   690: ldc_w 'set focus mode: '
    //   693: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: pop
    //   697: aload #9
    //   699: aload #6
    //   701: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload #5
    //   707: ldc 'CameraManager'
    //   709: aload #9
    //   711: invokevirtual toString : ()Ljava/lang/String;
    //   714: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   717: aload_0
    //   718: getfield a : Landroid/content/Context;
    //   721: invokestatic c : (Landroid/content/Context;)I
    //   724: istore_1
    //   725: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   728: invokevirtual c : ()Landroid/hardware/Camera$CameraInfo;
    //   731: astore #5
    //   733: aload_0
    //   734: getfield f : I
    //   737: iconst_1
    //   738: if_icmpne -> 764
    //   741: sipush #360
    //   744: aload #5
    //   746: getfield orientation : I
    //   749: iload_1
    //   750: iadd
    //   751: sipush #360
    //   754: irem
    //   755: isub
    //   756: sipush #360
    //   759: irem
    //   760: istore_1
    //   761: goto -> 780
    //   764: aload #5
    //   766: getfield orientation : I
    //   769: iload_1
    //   770: isub
    //   771: sipush #360
    //   774: iadd
    //   775: sipush #360
    //   778: irem
    //   779: istore_1
    //   780: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   783: iload_1
    //   784: invokevirtual b : (I)V
    //   787: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   790: astore #5
    //   792: new java/lang/StringBuilder
    //   795: dup
    //   796: invokespecial <init> : ()V
    //   799: astore #6
    //   801: aload #6
    //   803: ldc_w 'set camera display orientation: '
    //   806: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: aload #6
    //   812: iload_1
    //   813: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   816: pop
    //   817: aload #5
    //   819: ldc 'CameraManager'
    //   821: aload #6
    //   823: invokevirtual toString : ()Ljava/lang/String;
    //   826: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   829: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   832: aload #8
    //   834: invokevirtual a : (Landroid/hardware/Camera$Parameters;)V
    //   837: aload_0
    //   838: getfield b : Lcom/qiniu/pili/droid/shortvideo/PLCameraPreviewListener;
    //   841: ifnull -> 917
    //   844: aload #8
    //   846: invokevirtual getPreviewFormat : ()I
    //   849: invokestatic getBitsPerPixel : (I)I
    //   852: istore_3
    //   853: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   856: invokevirtual g : ()I
    //   859: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   862: invokevirtual h : ()I
    //   865: imul
    //   866: iload_3
    //   867: imul
    //   868: bipush #8
    //   870: idiv
    //   871: istore_3
    //   872: iload_3
    //   873: ifne -> 889
    //   876: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   879: ldc 'CameraManager'
    //   881: ldc_w 'previewBufferSize can not be 0!'
    //   884: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   887: iconst_0
    //   888: ireturn
    //   889: iload_2
    //   890: iconst_2
    //   891: if_icmpge -> 910
    //   894: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   897: iload_3
    //   898: newarray byte
    //   900: invokevirtual a : ([B)V
    //   903: iload_2
    //   904: iconst_1
    //   905: iadd
    //   906: istore_2
    //   907: goto -> 889
    //   910: invokestatic a : ()Lcom/qiniu/pili/droid/shortvideo/a/a/a;
    //   913: aload_0
    //   914: invokevirtual a : (Landroid/hardware/Camera$PreviewCallback;)V
    //   917: iload_1
    //   918: bipush #90
    //   920: if_icmpeq -> 954
    //   923: iload_1
    //   924: sipush #270
    //   927: if_icmpne -> 933
    //   930: goto -> 954
    //   933: aload_0
    //   934: aload #7
    //   936: getfield width : I
    //   939: putfield i : I
    //   942: aload_0
    //   943: aload #7
    //   945: getfield height : I
    //   948: putfield j : I
    //   951: goto -> 972
    //   954: aload_0
    //   955: aload #7
    //   957: getfield height : I
    //   960: putfield i : I
    //   963: aload_0
    //   964: aload #7
    //   966: getfield width : I
    //   969: putfield j : I
    //   972: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   975: ldc 'CameraManager'
    //   977: ldc_w 'setupCamera -'
    //   980: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   983: iconst_1
    //   984: ireturn
    //   985: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   988: ldc 'CameraManager'
    //   990: ldc_w 'No camera device preview sizes available, setup camera failed!'
    //   993: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   996: iconst_0
    //   997: ireturn
    //   998: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   1001: ldc 'CameraManager'
    //   1003: ldc_w 'Could not get camera device preview sizes, setup camera failed!'
    //   1006: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   1009: iconst_0
    //   1010: ireturn
  }
  
  public void a() {
    e.f.c("CameraManager", "pause +");
    a.a().q();
    a.a().f();
    e.f.c("CameraManager", "pause -");
  }
  
  public void a(float paramFloat) {
    List<Float> list = this.n;
    if (list != null) {
      int i = list.indexOf(Float.valueOf(paramFloat));
      if (i >= 0) {
        a.a().d(i);
        return;
      } 
      e.f.d("CameraManager", "setZoom failed, invalid value.");
      return;
    } 
    e.f.d("CameraManager", "setZoom failed, must call getZooms first.");
  }
  
  public void a(int paramInt) {
    a.a().c(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2) {
    Camera.Parameters parameters = a.a().k();
    if (parameters != null) {
      this.k = new e(this.a, parameters.getFocusMode(), paramInt1, paramInt2);
      this.k.a(this.m);
    } 
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    e e1 = this.k;
    if (e1 != null)
      e1.a(paramInt1, paramInt2, paramInt3, paramInt4); 
  }
  
  public final void a(PLCameraParamSelectListener paramPLCameraParamSelectListener) {
    this.c = paramPLCameraParamSelectListener;
  }
  
  public final void a(PLCameraPreviewListener paramPLCameraPreviewListener) {
    this.b = paramPLCameraPreviewListener;
  }
  
  public void a(PLCameraSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    e.f.c("CameraManager", "switchCameraId +");
    if (a.b() < 2) {
      e.f.e("CameraManager", "failed to switch camera, the phone only has one camera !");
      return;
    } 
    if (paramCAMERA_FACING_ID == null) {
      e.f.c("CameraManager", "switch to next camera");
      if (this.f == 0) {
        this.f = 1;
        paramCAMERA_FACING_ID = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT;
      } else {
        this.f = 0;
        paramCAMERA_FACING_ID = PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK;
      } 
    } else {
      e e1 = e.f;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("switch to specify camera with facing: ");
      stringBuilder.append(paramCAMERA_FACING_ID);
      e1.c("CameraManager", stringBuilder.toString());
      if (paramCAMERA_FACING_ID == PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_BACK) {
        this.f = 0;
      } else if (paramCAMERA_FACING_ID == PLCameraSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT) {
        this.f = 1;
      } else {
        this.f = 2;
      } 
    } 
    this.d.setCameraId(paramCAMERA_FACING_ID);
    this.n = null;
    e.f.c("CameraManager", "switchCameraId -");
  }
  
  public void a(PLFocusListener paramPLFocusListener) {
    this.m = paramPLFocusListener;
    e e1 = this.k;
    if (e1 != null)
      e1.a(paramPLFocusListener); 
  }
  
  public void a(a parama) {
    this.l = parama;
  }
  
  public boolean a(SurfaceTexture paramSurfaceTexture) {
    e.f.c("CameraManager", "resume +");
    if (!i())
      return false; 
    paramSurfaceTexture.setOnFrameAvailableListener(this);
    a.a().a(paramSurfaceTexture);
    a.a().p();
    e.f.c("CameraManager", "resume -");
    return true;
  }
  
  public void b() {
    e.f.c("CameraManager", "destroy");
  }
  
  public boolean c() {
    e.f.c("CameraManager", "turnLightOn");
    if (!a.a().d()) {
      e.f.d("CameraManager", "turnLightOn: camera not open !");
      return false;
    } 
    if (!com.qiniu.pili.droid.shortvideo.f.a.a().c()) {
      e.f.d("CameraManager", "turnLightOn: torch not supported !");
      return false;
    } 
    Camera.Parameters parameters = a.a().k();
    if (parameters == null)
      return false; 
    List list = parameters.getSupportedFlashModes();
    if (list == null) {
      e.f.e("CameraManager", "getSupportedFlashModes is null");
      return false;
    } 
    if (!"torch".equals(parameters.getFlashMode()))
      if (list.contains("torch")) {
        if (com.qiniu.pili.droid.shortvideo.f.a.a().b())
          parameters.setFocusMode("macro"); 
        parameters.setFlashMode("torch");
        a.a().a(parameters);
      } else {
        e.f.e("CameraManager", "FLASH_MODE_TORCH not supported");
        return false;
      }  
    return true;
  }
  
  public boolean d() {
    e.f.c("CameraManager", "turnLightOff");
    if (!a.a().d()) {
      e.f.d("CameraManager", "turnLightOff: camera not open !");
      return false;
    } 
    if (!com.qiniu.pili.droid.shortvideo.f.a.a().c()) {
      e.f.d("CameraManager", "turnLightOff: torch not supported !");
      return false;
    } 
    Camera.Parameters parameters = a.a().k();
    if (parameters == null)
      return false; 
    List list = parameters.getSupportedFlashModes();
    String str = parameters.getFlashMode();
    if (list == null) {
      e.f.e("CameraManager", "getSupportedFlashModes is null");
      return false;
    } 
    if (!"off".equals(str))
      if (list.contains("off")) {
        if (com.qiniu.pili.droid.shortvideo.f.a.a().b())
          parameters.setFocusMode("continuous-video"); 
        parameters.setFlashMode("off");
        a.a().a(parameters);
      } else {
        e.f.e("CameraManager", "FLASH_MODE_OFF not supported");
        return false;
      }  
    return true;
  }
  
  public boolean e() {
    boolean bool = com.qiniu.pili.droid.shortvideo.f.a.a().c();
    boolean bool1 = false;
    if (!bool)
      return false; 
    Camera.Parameters parameters = a.a().k();
    bool = bool1;
    if (parameters != null) {
      bool = bool1;
      if (parameters.getSupportedFlashModes() != null) {
        bool = bool1;
        if (parameters.getSupportedFlashModes().contains("torch"))
          bool = true; 
      } 
    } 
    return bool;
  }
  
  public int f() {
    return a.a().m();
  }
  
  public int g() {
    return a.a().n();
  }
  
  public List<Float> h() {
    List<Integer> list = a.a().o();
    if (list != null) {
      this.n = new ArrayList<Float>(list.size());
      for (Integer integer : list)
        this.n.add(Float.valueOf(integer.intValue() / 100.0F)); 
    } else {
      this.n = null;
    } 
    e e1 = e.f;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("get zoom values: ");
    stringBuilder.append(this.n);
    e1.c("CameraManager", stringBuilder.toString());
    return this.n;
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture) {
    e.f.a("CameraManager", "onFrameAvailable");
    a a1 = this.l;
    if (a1 != null)
      a1.a(this.g, this.h, this.i, this.j); 
  }
  
  public void onPreviewFrame(byte[] paramArrayOfbyte, Camera paramCamera) {
    if (paramCamera != null) {
      if (paramArrayOfbyte == null)
        return; 
      int i = a.a().g();
      int j = a.a().h();
      if (this.b != null && i != 0 && j != 0) {
        int k;
        if (a.a().j()) {
          k = (360 - a.a().i()) % 360;
        } else {
          k = a.a().i();
        } 
        this.b.onPreviewFrame(paramArrayOfbyte, i, j, k, this.e, System.nanoTime());
      } 
      paramCamera.addCallbackBuffer(paramArrayOfbyte);
    } 
  }
  
  public static interface a {
    void a(int param1Int1, int param1Int2, int param1Int3, int param1Int4);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\a\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */