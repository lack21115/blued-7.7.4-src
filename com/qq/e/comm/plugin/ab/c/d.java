package com.qq.e.comm.plugin.ab.c;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.ab.h;
import com.qq.e.comm.plugin.util.ah;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import org.json.JSONArray;

public class d implements e {
  private Point a;
  
  private d() {}
  
  private int a(h paramh, int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokeinterface a : ()Landroid/view/View;
    //   7: invokespecial a : (Landroid/view/View;)Landroid/util/Pair;
    //   10: astore #6
    //   12: new java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial <init> : ()V
    //   19: astore #7
    //   21: aload #7
    //   23: ldc 'ExprValue:'
    //   25: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload #7
    //   31: iload_2
    //   32: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload #7
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokestatic d : (Ljava/lang/String;)V
    //   44: aload_1
    //   45: invokeinterface a : ()Landroid/view/View;
    //   50: invokevirtual getContext : ()Landroid/content/Context;
    //   53: ldc 'power'
    //   55: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   58: checkcast android/os/PowerManager
    //   61: invokevirtual isScreenOn : ()Z
    //   64: ifne -> 78
    //   67: ldc '曝光失败:\\t屏幕关闭'
    //   69: invokestatic i : (Ljava/lang/String;)V
    //   72: iconst_1
    //   73: istore #4
    //   75: goto -> 81
    //   78: iconst_0
    //   79: istore #4
    //   81: iload #4
    //   83: istore_3
    //   84: aload_1
    //   85: invokeinterface a : ()Landroid/view/View;
    //   90: invokevirtual getWindowVisibility : ()I
    //   93: ifeq -> 106
    //   96: ldc '曝光失败:\\t广告所属Window不可见，可能是由于Activity已经不是当前可见的Activity'
    //   98: invokestatic i : (Ljava/lang/String;)V
    //   101: iload #4
    //   103: iconst_2
    //   104: iadd
    //   105: istore_3
    //   106: iload_3
    //   107: istore #4
    //   109: aload_1
    //   110: invokeinterface a : ()Landroid/view/View;
    //   115: invokevirtual getVisibility : ()I
    //   118: ifeq -> 131
    //   121: ldc '曝光失败:\\t广告View的Visibility属性被设置为非VISIBLE'
    //   123: invokestatic i : (Ljava/lang/String;)V
    //   126: iload_3
    //   127: iconst_4
    //   128: iadd
    //   129: istore #4
    //   131: iload #4
    //   133: istore_3
    //   134: aload_1
    //   135: iconst_0
    //   136: invokeinterface f : (Z)I
    //   141: ifeq -> 155
    //   144: ldc '曝光失败:\\t广告View的某个父节点Visibility属性被设置为非VISIBLE'
    //   146: invokestatic i : (Ljava/lang/String;)V
    //   149: iload #4
    //   151: bipush #8
    //   153: iadd
    //   154: istore_3
    //   155: sipush #320
    //   158: istore #4
    //   160: bipush #50
    //   162: istore #5
    //   164: iload_2
    //   165: bipush #25
    //   167: if_icmpne -> 178
    //   170: bipush #100
    //   172: istore #4
    //   174: bipush #20
    //   176: istore #5
    //   178: aload_1
    //   179: invokeinterface f : ()I
    //   184: iload #4
    //   186: if_icmplt -> 203
    //   189: iload_3
    //   190: istore #4
    //   192: aload_1
    //   193: invokeinterface g : ()I
    //   198: iload #5
    //   200: if_icmpge -> 214
    //   203: ldc '曝光失败:\\t广告View的尺寸小于最低要求'
    //   205: invokestatic i : (Ljava/lang/String;)V
    //   208: iload_3
    //   209: bipush #16
    //   211: iadd
    //   212: istore #4
    //   214: new java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial <init> : ()V
    //   221: astore #7
    //   223: aload #7
    //   225: ldc 'rect:'
    //   227: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload #7
    //   233: aload #6
    //   235: getfield second : Ljava/lang/Object;
    //   238: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload #7
    //   244: invokevirtual toString : ()Ljava/lang/String;
    //   247: invokestatic d : (Ljava/lang/String;)V
    //   250: aload #6
    //   252: getfield first : Ljava/lang/Object;
    //   255: checkcast java/lang/Boolean
    //   258: invokevirtual booleanValue : ()Z
    //   261: ifne -> 275
    //   264: ldc '曝光失败:\\t广告所属位置不在屏幕范围内'
    //   266: invokestatic i : (Ljava/lang/String;)V
    //   269: iload #4
    //   271: bipush #32
    //   273: ior
    //   274: ireturn
    //   275: aload_1
    //   276: invokeinterface f : ()I
    //   281: iconst_2
    //   282: idiv
    //   283: istore_3
    //   284: aload_1
    //   285: invokeinterface g : ()I
    //   290: iconst_2
    //   291: idiv
    //   292: istore #5
    //   294: iload_2
    //   295: bipush #26
    //   297: if_icmpne -> 319
    //   300: aload_1
    //   301: invokeinterface f : ()I
    //   306: iconst_4
    //   307: idiv
    //   308: istore_3
    //   309: aload_1
    //   310: invokeinterface g : ()I
    //   315: iconst_4
    //   316: idiv
    //   317: istore #5
    //   319: aload #6
    //   321: getfield second : Ljava/lang/Object;
    //   324: checkcast android/graphics/Rect
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual width : ()I
    //   332: iload_3
    //   333: if_icmplt -> 264
    //   336: aload_1
    //   337: invokevirtual height : ()I
    //   340: iload #5
    //   342: if_icmpge -> 348
    //   345: goto -> 264
    //   348: iload #4
    //   350: ireturn
  }
  
  private Point a(Context paramContext) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/graphics/Point;
    //   6: ifnonnull -> 79
    //   9: aload_1
    //   10: ldc 'window'
    //   12: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   15: checkcast android/view/WindowManager
    //   18: astore_1
    //   19: aload_0
    //   20: new android/graphics/Point
    //   23: dup
    //   24: invokespecial <init> : ()V
    //   27: putfield a : Landroid/graphics/Point;
    //   30: getstatic android/os/Build$VERSION.SDK_INT : I
    //   33: bipush #17
    //   35: if_icmplt -> 54
    //   38: aload_1
    //   39: invokeinterface getDefaultDisplay : ()Landroid/view/Display;
    //   44: aload_0
    //   45: getfield a : Landroid/graphics/Point;
    //   48: invokevirtual getRealSize : (Landroid/graphics/Point;)V
    //   51: goto -> 79
    //   54: aload_0
    //   55: getfield a : Landroid/graphics/Point;
    //   58: aload_1
    //   59: invokeinterface getDefaultDisplay : ()Landroid/view/Display;
    //   64: invokevirtual getWidth : ()I
    //   67: aload_1
    //   68: invokeinterface getDefaultDisplay : ()Landroid/view/Display;
    //   73: invokevirtual getHeight : ()I
    //   76: invokevirtual set : (II)V
    //   79: aload_0
    //   80: getfield a : Landroid/graphics/Point;
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: areturn
    //   88: astore_1
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: athrow
    // Exception table:
    //   from	to	target	type
    //   2	51	88	finally
    //   54	79	88	finally
    //   79	84	88	finally
  }
  
  private Pair<Boolean, Rect> a(View paramView) {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = paramView.getWidth();
    int m = paramView.getHeight();
    Point point = a(paramView.getContext());
    Rect rect1 = new Rect(0, 0, point.x, point.y);
    Rect rect2 = new Rect(i, j, k + i, m + j);
    return new Pair(Boolean.valueOf(rect2.intersect(rect1)), rect2);
  }
  
  public static final d a() {
    return a.a;
  }
  
  public void a(h paramh, com.qq.e.comm.plugin.ab.b.d paramd) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual d : ()Lorg/json/JSONObject;
    //   4: astore #6
    //   6: aload #6
    //   8: ifnull -> 530
    //   11: aload #6
    //   13: ldc 'viewid'
    //   15: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   18: astore_2
    //   19: aload #6
    //   21: ldc 'customizedpingurls'
    //   23: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   26: astore #7
    //   28: aload #6
    //   30: ldc 'apurls'
    //   32: invokevirtual optJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   35: astore #5
    //   37: aload #5
    //   39: ifnull -> 124
    //   42: aload #5
    //   44: invokevirtual length : ()I
    //   47: iconst_1
    //   48: isub
    //   49: istore_3
    //   50: iload_3
    //   51: iflt -> 124
    //   54: aload #5
    //   56: iload_3
    //   57: invokevirtual optString : (I)Ljava/lang/String;
    //   60: astore #8
    //   62: aload #8
    //   64: ldc 'http://v.gdt.qq.com/gdt_stats.fcg'
    //   66: invokevirtual startsWith : (Ljava/lang/String;)Z
    //   69: ifne -> 531
    //   72: aload #8
    //   74: invokestatic c : ()Ljava/lang/String;
    //   77: invokestatic b : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   80: astore #8
    //   82: new java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #9
    //   91: aload #9
    //   93: ldc 'exposure handler append mu_p key url is (ccr) = '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #9
    //   101: aload #8
    //   103: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: aload #9
    //   109: invokevirtual toString : ()Ljava/lang/String;
    //   112: invokestatic d : (Ljava/lang/String;)V
    //   115: aload #8
    //   117: iconst_1
    //   118: invokestatic a : (Ljava/lang/String;Z)V
    //   121: goto -> 531
    //   124: new java/util/ArrayList
    //   127: dup
    //   128: invokespecial <init> : ()V
    //   131: astore #8
    //   133: aload #6
    //   135: ldc_w 'exprValue'
    //   138: iconst_0
    //   139: invokevirtual optInt : (Ljava/lang/String;I)I
    //   142: istore #4
    //   144: iconst_0
    //   145: istore_3
    //   146: iload_3
    //   147: aload_2
    //   148: invokevirtual length : ()I
    //   151: if_icmpge -> 174
    //   154: aload #8
    //   156: aload_2
    //   157: iload_3
    //   158: invokevirtual optString : (I)Ljava/lang/String;
    //   161: invokeinterface add : (Ljava/lang/Object;)Z
    //   166: pop
    //   167: iload_3
    //   168: iconst_1
    //   169: iadd
    //   170: istore_3
    //   171: goto -> 146
    //   174: aload_1
    //   175: invokeinterface e : ()Lcom/qq/e/comm/plugin/ab/c;
    //   180: invokeinterface a : ()Ljava/lang/String;
    //   185: astore #9
    //   187: aload_1
    //   188: invokeinterface e : ()Lcom/qq/e/comm/plugin/ab/c;
    //   193: invokeinterface c : ()Lcom/qq/e/comm/plugin/ad/e;
    //   198: astore #10
    //   200: aload #10
    //   202: getstatic com/qq/e/comm/plugin/ad/e.a : Lcom/qq/e/comm/plugin/ad/e;
    //   205: if_acmpne -> 538
    //   208: aload_0
    //   209: aload_1
    //   210: iload #4
    //   212: invokespecial a : (Lcom/qq/e/comm/plugin/ab/h;I)I
    //   215: istore_3
    //   216: goto -> 219
    //   219: new java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial <init> : ()V
    //   226: astore_2
    //   227: aload_2
    //   228: ldc_w 'AntiSpamValue of '
    //   231: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_2
    //   236: aload #10
    //   238: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: pop
    //   242: aload_2
    //   243: ldc_w ':::'
    //   246: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: iload_3
    //   252: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload_2
    //   257: invokevirtual toString : ()Ljava/lang/String;
    //   260: invokestatic d : (Ljava/lang/String;)V
    //   263: aload_1
    //   264: invokeinterface e : ()Lcom/qq/e/comm/plugin/ab/c;
    //   269: invokeinterface b : ()Ljava/lang/String;
    //   274: astore #11
    //   276: aconst_null
    //   277: astore_2
    //   278: iload_3
    //   279: ifeq -> 470
    //   282: new com/qq/e/comm/plugin/w/d$a
    //   285: dup
    //   286: invokespecial <init> : ()V
    //   289: astore #5
    //   291: aload #5
    //   293: iload_3
    //   294: invokevirtual a : (I)V
    //   297: aload #5
    //   299: astore_2
    //   300: iload_3
    //   301: bipush #48
    //   303: iand
    //   304: ifeq -> 470
    //   307: new java/util/HashMap
    //   310: dup
    //   311: invokespecial <init> : ()V
    //   314: astore_2
    //   315: iconst_2
    //   316: newarray int
    //   318: astore #12
    //   320: aload_1
    //   321: invokeinterface a : ()Landroid/view/View;
    //   326: aload #12
    //   328: invokevirtual getLocationOnScreen : ([I)V
    //   331: aload_2
    //   332: ldc_w 'x'
    //   335: aload #12
    //   337: iconst_0
    //   338: iaload
    //   339: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   342: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   347: pop
    //   348: aload_2
    //   349: ldc_w 'y'
    //   352: aload #12
    //   354: iconst_1
    //   355: iaload
    //   356: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   359: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   364: pop
    //   365: aload_2
    //   366: ldc_w 'w'
    //   369: aload_1
    //   370: invokeinterface f : ()I
    //   375: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   378: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   383: pop
    //   384: aload_2
    //   385: ldc_w 'h'
    //   388: aload_1
    //   389: invokeinterface g : ()I
    //   394: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   397: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   402: pop
    //   403: aload_2
    //   404: ldc_w 'sw'
    //   407: aload_0
    //   408: aload_1
    //   409: invokeinterface a : ()Landroid/view/View;
    //   414: invokevirtual getContext : ()Landroid/content/Context;
    //   417: invokespecial a : (Landroid/content/Context;)Landroid/graphics/Point;
    //   420: getfield x : I
    //   423: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   426: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   431: pop
    //   432: aload_2
    //   433: ldc_w 'sh'
    //   436: aload_0
    //   437: aload_1
    //   438: invokeinterface a : ()Landroid/view/View;
    //   443: invokevirtual getContext : ()Landroid/content/Context;
    //   446: invokespecial a : (Landroid/content/Context;)Landroid/graphics/Point;
    //   449: getfield y : I
    //   452: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   455: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   460: pop
    //   461: aload #5
    //   463: aload_2
    //   464: invokevirtual a : (Ljava/util/Map;)V
    //   467: aload #5
    //   469: astore_2
    //   470: aload_2
    //   471: aload #8
    //   473: new com/qq/e/comm/plugin/w/b
    //   476: dup
    //   477: aload #9
    //   479: aload #10
    //   481: aload #11
    //   483: invokespecial <init> : (Ljava/lang/String;Lcom/qq/e/comm/plugin/ad/e;Ljava/lang/String;)V
    //   486: new com/qq/e/comm/plugin/ab/c/d$1
    //   489: dup
    //   490: aload_0
    //   491: aload #7
    //   493: invokespecial <init> : (Lcom/qq/e/comm/plugin/ab/c/d;Lorg/json/JSONArray;)V
    //   496: invokestatic a : (Lcom/qq/e/comm/plugin/w/d$a;Ljava/util/List;Lcom/qq/e/comm/plugin/w/b;Lcom/qq/e/comm/plugin/w/d$b;)V
    //   499: iload_3
    //   500: ifne -> 530
    //   503: aload_1
    //   504: new com/qq/e/comm/plugin/ab/a/a
    //   507: dup
    //   508: getstatic com/qq/e/comm/plugin/ab/a/c.d : Lcom/qq/e/comm/plugin/ab/a/c;
    //   511: aload #6
    //   513: invokespecial <init> : (Lcom/qq/e/comm/plugin/ab/a/c;Lorg/json/JSONObject;)V
    //   516: invokeinterface a : (Lcom/qq/e/comm/plugin/ab/a/a;)V
    //   521: return
    //   522: astore_1
    //   523: ldc_w 'Exception occurred '
    //   526: aload_1
    //   527: invokestatic report : (Ljava/lang/String;Ljava/lang/Throwable;)V
    //   530: return
    //   531: iload_3
    //   532: iconst_1
    //   533: isub
    //   534: istore_3
    //   535: goto -> 50
    //   538: iconst_0
    //   539: istore_3
    //   540: goto -> 219
    // Exception table:
    //   from	to	target	type
    //   11	37	522	finally
    //   42	50	522	finally
    //   54	121	522	finally
    //   124	144	522	finally
    //   146	167	522	finally
    //   174	216	522	finally
    //   219	276	522	finally
    //   282	297	522	finally
    //   307	467	522	finally
    //   470	499	522	finally
    //   503	521	522	finally
  }
  
  public String b() {
    return "exposure";
  }
  
  static final class a {
    static final d a = new d();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\ab\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */