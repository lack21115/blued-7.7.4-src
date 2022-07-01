package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.soft.blued.R;
import java.util.ArrayList;
import java.util.List;

public class DiffuseView extends View {
  private static SparseArray<Bitmap> q = new SparseArray();
  
  private int a = getResources().getColor(2131100527);
  
  private int b = getResources().getColor(2131099814);
  
  private Bitmap c;
  
  private float d;
  
  private int e = 3;
  
  private float f = 50.0F;
  
  private float g = 1.0F;
  
  private boolean h = false;
  
  private int i;
  
  private int j;
  
  private List<Float> k = new ArrayList<Float>();
  
  private List<Float> l = new ArrayList<Float>();
  
  private Paint m;
  
  private Paint n;
  
  private long o;
  
  private boolean p;
  
  public DiffuseView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public DiffuseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.DiffuseView, paramInt, 0);
    this.a = typedArray.getColor(0, this.a);
    this.b = typedArray.getColor(1, this.b);
    this.d = typedArray.getFloat(3, this.d);
    this.e = typedArray.getInt(8, this.e);
    this.f = typedArray.getDimension(6, this.f);
    this.g = typedArray.getDimension(7, this.g);
    this.i = typedArray.getDimensionPixelSize(5, 50);
    this.j = typedArray.getDimensionPixelOffset(4, 50);
    paramInt = typedArray.getResourceId(2, -1);
    int i = this.i + this.a;
    this.c = (Bitmap)q.get(i);
    if (this.c == null && paramInt != -1) {
      this.c = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(getResources(), paramInt), this.i, this.j, true);
      q.put(i, this.c);
    } 
    typedArray.recycle();
    a();
  }
  
  private void a() {
    int i;
    this.m = new Paint();
    this.n = new Paint();
    this.p = true;
    Bitmap bitmap = this.c;
    if (bitmap == null) {
      i = 0;
    } else {
      i = bitmap.getHeight() / 2;
    } 
    this.d = i;
    this.m.setColor(this.a);
    this.m.setAntiAlias(true);
    this.n.setAntiAlias(true);
    this.k.add(Float.valueOf(204.0F));
    this.l.add(Float.valueOf(0.0F));
  }
  
  private void b() {
    this.h = false;
    this.l.clear();
    this.k.clear();
    this.k.add(Float.valueOf(204.0F));
    this.l.add(Float.valueOf(0.0F));
  }
  
  private boolean c() {
    return (System.currentTimeMillis() - this.o >= 3000L);
  }
  
  public void invalidate() {
    if (hasWindowFocus())
      super.invalidate(); 
  }
  
  public void onDraw(Canvas paramCanvas) {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial onDraw : (Landroid/graphics/Canvas;)V
    //   5: aload_0
    //   6: getfield h : Z
    //   9: ifne -> 70
    //   12: aload_0
    //   13: getfield c : Landroid/graphics/Bitmap;
    //   16: astore #7
    //   18: aload #7
    //   20: ifnull -> 418
    //   23: aload_1
    //   24: aload #7
    //   26: aload_0
    //   27: invokevirtual getWidth : ()I
    //   30: iconst_2
    //   31: idiv
    //   32: aload_0
    //   33: getfield c : Landroid/graphics/Bitmap;
    //   36: invokevirtual getWidth : ()I
    //   39: iconst_2
    //   40: idiv
    //   41: isub
    //   42: i2f
    //   43: aload_0
    //   44: invokevirtual getHeight : ()I
    //   47: iconst_2
    //   48: idiv
    //   49: aload_0
    //   50: getfield c : Landroid/graphics/Bitmap;
    //   53: invokevirtual getHeight : ()I
    //   56: iconst_2
    //   57: idiv
    //   58: isub
    //   59: i2f
    //   60: aload_0
    //   61: getfield n : Landroid/graphics/Paint;
    //   64: invokevirtual drawBitmap : (Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   67: goto -> 418
    //   70: iconst_0
    //   71: istore #6
    //   73: iload #6
    //   75: aload_0
    //   76: getfield k : Ljava/util/List;
    //   79: invokeinterface size : ()I
    //   84: if_icmpge -> 290
    //   87: aload_0
    //   88: getfield k : Ljava/util/List;
    //   91: iload #6
    //   93: invokeinterface get : (I)Ljava/lang/Object;
    //   98: checkcast java/lang/Float
    //   101: invokevirtual floatValue : ()F
    //   104: fstore_2
    //   105: aload_0
    //   106: getfield l : Ljava/util/List;
    //   109: iload #6
    //   111: invokeinterface get : (I)Ljava/lang/Object;
    //   116: checkcast java/lang/Float
    //   119: invokevirtual floatValue : ()F
    //   122: fstore #4
    //   124: aload_0
    //   125: getfield f : F
    //   128: fstore_3
    //   129: fload #4
    //   131: fload_3
    //   132: fcmpg
    //   133: ifge -> 225
    //   136: ldc 204.0
    //   138: fload_3
    //   139: aload_0
    //   140: getfield c : Landroid/graphics/Bitmap;
    //   143: invokevirtual getHeight : ()I
    //   146: iconst_2
    //   147: idiv
    //   148: i2f
    //   149: fsub
    //   150: fdiv
    //   151: fstore_3
    //   152: aload_0
    //   153: getfield g : F
    //   156: fstore #5
    //   158: aload_0
    //   159: getfield l : Ljava/util/List;
    //   162: iload #6
    //   164: fload #5
    //   166: fload #4
    //   168: fadd
    //   169: invokestatic valueOf : (F)Ljava/lang/Float;
    //   172: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   177: pop
    //   178: aload_0
    //   179: getfield k : Ljava/util/List;
    //   182: astore #7
    //   184: fload #4
    //   186: aload_0
    //   187: getfield f : F
    //   190: fcmpl
    //   191: ifge -> 209
    //   194: fload_2
    //   195: fload_3
    //   196: fload #5
    //   198: fmul
    //   199: fsub
    //   200: fstore_3
    //   201: fload_3
    //   202: fstore_2
    //   203: fload_3
    //   204: fconst_1
    //   205: fcmpg
    //   206: ifgt -> 211
    //   209: fconst_0
    //   210: fstore_2
    //   211: aload #7
    //   213: iload #6
    //   215: fload_2
    //   216: invokestatic valueOf : (F)Ljava/lang/Float;
    //   219: invokeinterface set : (ILjava/lang/Object;)Ljava/lang/Object;
    //   224: pop
    //   225: aload_0
    //   226: getfield m : Landroid/graphics/Paint;
    //   229: aload_0
    //   230: getfield k : Ljava/util/List;
    //   233: iload #6
    //   235: invokeinterface get : (I)Ljava/lang/Object;
    //   240: checkcast java/lang/Float
    //   243: invokevirtual floatValue : ()F
    //   246: invokestatic round : (F)I
    //   249: invokevirtual setAlpha : (I)V
    //   252: aload_1
    //   253: aload_0
    //   254: invokevirtual getWidth : ()I
    //   257: iconst_2
    //   258: idiv
    //   259: i2f
    //   260: aload_0
    //   261: invokevirtual getHeight : ()I
    //   264: iconst_2
    //   265: idiv
    //   266: i2f
    //   267: aload_0
    //   268: getfield d : F
    //   271: fload #4
    //   273: fadd
    //   274: aload_0
    //   275: getfield m : Landroid/graphics/Paint;
    //   278: invokevirtual drawCircle : (FFFLandroid/graphics/Paint;)V
    //   281: iload #6
    //   283: iconst_1
    //   284: iadd
    //   285: istore #6
    //   287: goto -> 73
    //   290: aload_0
    //   291: getfield l : Ljava/util/List;
    //   294: iconst_0
    //   295: invokeinterface get : (I)Ljava/lang/Object;
    //   300: checkcast java/lang/Float
    //   303: invokevirtual floatValue : ()F
    //   306: aload_0
    //   307: getfield f : F
    //   310: aload_0
    //   311: getfield d : F
    //   314: fsub
    //   315: fconst_2
    //   316: fdiv
    //   317: fcmpl
    //   318: iflt -> 363
    //   321: aload_0
    //   322: getfield l : Ljava/util/List;
    //   325: invokeinterface size : ()I
    //   330: iconst_2
    //   331: if_icmpge -> 363
    //   334: aload_0
    //   335: getfield k : Ljava/util/List;
    //   338: ldc 204.0
    //   340: invokestatic valueOf : (F)Ljava/lang/Float;
    //   343: invokeinterface add : (Ljava/lang/Object;)Z
    //   348: pop
    //   349: aload_0
    //   350: getfield l : Ljava/util/List;
    //   353: fconst_0
    //   354: invokestatic valueOf : (F)Ljava/lang/Float;
    //   357: invokeinterface add : (Ljava/lang/Object;)Z
    //   362: pop
    //   363: aload_0
    //   364: getfield c : Landroid/graphics/Bitmap;
    //   367: astore #7
    //   369: aload #7
    //   371: ifnull -> 418
    //   374: aload_1
    //   375: aload #7
    //   377: aload_0
    //   378: invokevirtual getWidth : ()I
    //   381: iconst_2
    //   382: idiv
    //   383: aload_0
    //   384: getfield c : Landroid/graphics/Bitmap;
    //   387: invokevirtual getWidth : ()I
    //   390: iconst_2
    //   391: idiv
    //   392: isub
    //   393: i2f
    //   394: aload_0
    //   395: invokevirtual getHeight : ()I
    //   398: iconst_2
    //   399: idiv
    //   400: aload_0
    //   401: getfield c : Landroid/graphics/Bitmap;
    //   404: invokevirtual getHeight : ()I
    //   407: iconst_2
    //   408: idiv
    //   409: isub
    //   410: i2f
    //   411: aload_0
    //   412: getfield n : Landroid/graphics/Paint;
    //   415: invokevirtual drawBitmap : (Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    //   418: aload_0
    //   419: getfield l : Ljava/util/List;
    //   422: invokeinterface size : ()I
    //   427: iconst_2
    //   428: if_icmpne -> 469
    //   431: aload_0
    //   432: getfield l : Ljava/util/List;
    //   435: iconst_1
    //   436: invokeinterface get : (I)Ljava/lang/Object;
    //   441: checkcast java/lang/Float
    //   444: invokevirtual floatValue : ()F
    //   447: aload_0
    //   448: getfield f : F
    //   451: fcmpl
    //   452: iflt -> 469
    //   455: aload_0
    //   456: invokespecial b : ()V
    //   459: aload_0
    //   460: invokestatic currentTimeMillis : ()J
    //   463: putfield o : J
    //   466: goto -> 481
    //   469: aload_0
    //   470: invokespecial c : ()Z
    //   473: ifeq -> 481
    //   476: aload_0
    //   477: iconst_1
    //   478: putfield h : Z
    //   481: aload_0
    //   482: invokevirtual invalidate : ()V
    //   485: return
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean)
      invalidate(); 
  }
  
  public void setColor(int paramInt) {
    this.a = paramInt;
  }
  
  public void setCoreColor(int paramInt) {
    this.b = paramInt;
  }
  
  public void setCoreImage(int paramInt) {
    this.c = BitmapFactory.decodeResource(getResources(), paramInt);
  }
  
  public void setCoreRadius(int paramInt) {
    this.d = paramInt;
  }
  
  public void setDiffuseSpeed(int paramInt) {
    this.g = paramInt;
  }
  
  public void setDiffuseWidth(int paramInt) {
    this.e = paramInt;
  }
  
  public void setIsTransparent(boolean paramBoolean) {
    this.p = paramBoolean;
  }
  
  public void setMaxWidth(int paramInt) {
    this.f = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\DiffuseView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */