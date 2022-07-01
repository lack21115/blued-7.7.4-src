package com.soft.blued.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.soft.blued.R;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LockPatternView extends View {
  private final Rect A;
  
  private int B;
  
  private int C;
  
  private int D;
  
  private final Matrix E;
  
  private final Matrix F;
  
  private boolean a;
  
  private Paint b;
  
  private Paint c;
  
  private OnPatternListener d;
  
  private ArrayList<Cell> e;
  
  private boolean[][] f;
  
  private float g;
  
  private float h;
  
  private long i;
  
  private DisplayMode j;
  
  private boolean k;
  
  private boolean l;
  
  private boolean m;
  
  private boolean n;
  
  private float o;
  
  private final int p;
  
  private float q;
  
  private float r;
  
  private float s;
  
  private Bitmap t;
  
  private Bitmap u;
  
  private Bitmap v;
  
  private Bitmap w;
  
  private Bitmap x;
  
  private final Path y;
  
  private final Rect z;
  
  public LockPatternView(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public LockPatternView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    int i = 0;
    this.a = false;
    this.b = new Paint();
    this.c = new Paint();
    this.e = new ArrayList<Cell>(9);
    this.f = (boolean[][])Array.newInstance(boolean.class, new int[] { 3, 3 });
    this.g = -1.0F;
    this.h = -1.0F;
    this.j = DisplayMode.a;
    this.k = true;
    this.l = false;
    this.m = true;
    this.n = false;
    this.o = 0.1F;
    this.p = 128;
    this.q = 0.6F;
    this.y = new Path();
    this.z = new Rect();
    this.A = new Rect();
    this.E = new Matrix();
    this.F = new Matrix();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LockPatternView);
    String str = typedArray.getString(0);
    if ("square".equals(str)) {
      this.D = 0;
    } else if ("lock_width".equals(str)) {
      this.D = 1;
    } else if ("lock_height".equals(str)) {
      this.D = 2;
    } else {
      this.D = 0;
    } 
    setClickable(true);
    this.c.setAntiAlias(true);
    this.c.setDither(true);
    this.c.setAlpha(128);
    this.c.setStyle(Paint.Style.STROKE);
    this.c.setStrokeJoin(Paint.Join.ROUND);
    this.c.setStrokeCap(Paint.Cap.ROUND);
    this.t = a(2131231279);
    this.u = a(2131231276);
    this.v = a(2131231277);
    this.w = a(2131234243);
    this.x = a(2131234244);
    Bitmap[] arrayOfBitmap = new Bitmap[3];
    arrayOfBitmap[0] = this.t;
    arrayOfBitmap[1] = this.u;
    arrayOfBitmap[2] = this.v;
    int j = arrayOfBitmap.length;
    while (i < j) {
      Bitmap bitmap = arrayOfBitmap[i];
      this.B = Math.max(this.B, bitmap.getWidth());
      this.C = Math.max(this.C, bitmap.getHeight());
      i++;
    } 
    typedArray.recycle();
  }
  
  private int a(float paramFloat) {
    float f1 = this.s;
    float f2 = this.q * f1;
    float f3 = getPaddingTop();
    float f4 = (f1 - f2) / 2.0F;
    int i;
    for (i = 0; i < 3; i++) {
      float f = i * f1 + f3 + f4;
      if (paramFloat >= f && paramFloat <= f + f2)
        return i; 
    } 
    return -1;
  }
  
  private int a(int paramInt1, int paramInt2) {
    int i = View.MeasureSpec.getSize(paramInt1);
    paramInt1 = View.MeasureSpec.getMode(paramInt1);
    if (paramInt1 != Integer.MIN_VALUE) {
      if (paramInt1 != 0)
        return i; 
    } else {
      paramInt2 = Math.max(i, paramInt2);
    } 
    return paramInt2;
  }
  
  private Bitmap a(int paramInt) {
    return BitmapFactory.decodeResource(getContext().getResources(), paramInt);
  }
  
  private Cell a(float paramFloat1, float paramFloat2) {
    Cell cell2 = b(paramFloat1, paramFloat2);
    Cell cell1 = null;
    if (cell2 != null) {
      ArrayList<Cell> arrayList = this.e;
      if (!arrayList.isEmpty()) {
        cell1 = arrayList.get(arrayList.size() - 1);
        int n = cell2.a - cell1.a;
        int m = cell2.b - cell1.b;
        int j = cell1.a;
        int k = cell1.b;
        int i1 = Math.abs(n);
        byte b = -1;
        int i = j;
        if (i1 == 2) {
          i = j;
          if (Math.abs(m) != 1) {
            j = cell1.a;
            if (n > 0) {
              i = 1;
            } else {
              i = -1;
            } 
            i = j + i;
          } 
        } 
        j = k;
        if (Math.abs(m) == 2) {
          j = k;
          if (Math.abs(n) != 1) {
            k = cell1.b;
            j = b;
            if (m > 0)
              j = 1; 
            j = k + j;
          } 
        } 
        cell1 = Cell.a(i, j);
      } 
      if (cell1 != null && !this.f[cell1.a][cell1.b])
        a(cell1); 
      a(cell2);
      if (this.m)
        performHapticFeedback(1, 3); 
      return cell2;
    } 
    return null;
  }
  
  public static String a(List<Cell> paramList) {
    if (paramList == null)
      return ""; 
    int j = paramList.size();
    byte[] arrayOfByte = new byte[j];
    for (int i = 0; i < j; i++) {
      Cell cell = paramList.get(i);
      arrayOfByte[i] = (byte)(cell.a() * 3 + cell.b());
    } 
    return Arrays.toString(arrayOfByte);
  }
  
  public static List<Cell> a(String paramString) {
    ArrayList<Cell> arrayList = new ArrayList();
    byte[] arrayOfByte = paramString.getBytes();
    for (int i = 0; i < arrayOfByte.length; i++) {
      byte b = arrayOfByte[i];
      arrayList.add(Cell.a(b / 3, b % 3));
    } 
    return arrayList;
  }
  
  private void a(Canvas paramCanvas, float paramFloat1, float paramFloat2, Cell paramCell1, Cell paramCell2) {
    Bitmap bitmap;
    if (this.j != DisplayMode.c) {
      i = 1;
    } else {
      i = 0;
    } 
    int j = paramCell2.a;
    int k = paramCell1.a;
    int m = paramCell2.b;
    int n = paramCell1.b;
    int i1 = ((int)this.r - this.B) / 2;
    int i2 = ((int)this.s - this.C) / 2;
    if (i) {
      bitmap = this.w;
    } else {
      bitmap = this.x;
    } 
    int i = this.B;
    int i3 = this.C;
    float f1 = (float)Math.toDegrees((float)Math.atan2((j - k), (m - n)));
    float f2 = Math.min(this.r / this.B, 1.0F);
    float f3 = Math.min(this.s / this.C, 1.0F);
    this.E.setTranslate(paramFloat1 + i1, paramFloat2 + i2);
    this.E.preTranslate((this.B / 2), (this.C / 2));
    this.E.preScale(f2 / 1.3F, f3 / 1.3F);
    this.E.preTranslate((-this.B / 2), (-this.C / 2));
    this.E.preRotate(f1 + 90.0F, i / 2.0F, i3 / 2.0F);
    this.E.preTranslate((i - bitmap.getWidth()) / 2.0F, 0.0F);
    paramCanvas.drawBitmap(bitmap, this.E, this.b);
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean) {
    StringBuilder stringBuilder;
    Bitmap bitmap;
    if (!paramBoolean || (this.l && this.j != DisplayMode.c)) {
      bitmap = this.t;
    } else if (this.n) {
      bitmap = this.u;
    } else if (this.j == DisplayMode.c) {
      bitmap = this.v;
    } else if (this.j == DisplayMode.a || this.j == DisplayMode.b) {
      bitmap = this.u;
    } else {
      stringBuilder = new StringBuilder();
      stringBuilder.append("unknown display mode ");
      stringBuilder.append(this.j);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    int i = this.B;
    int k = this.C;
    float f1 = this.r;
    float f2 = this.s;
    int j = (int)((f1 - i) / 2.0F);
    k = (int)((f2 - k) / 2.0F);
    f1 = Math.min(f1 / i, 1.0F);
    f2 = Math.min(this.s / this.C, 1.0F);
    this.F.setTranslate((paramInt1 + j), (paramInt2 + k));
    this.F.preTranslate((this.B / 2), (this.C / 2));
    this.F.preScale(f1, f2);
    this.F.preTranslate((-this.B / 2), (-this.C / 2));
    stringBuilder.drawBitmap(bitmap, this.F, this.b);
  }
  
  private void a(MotionEvent paramMotionEvent) {
    float f = this.r * this.o * 0.5F;
    int j = paramMotionEvent.getHistorySize();
    this.A.setEmpty();
    int i = 0;
    boolean bool = false;
    while (i < j + 1) {
      float f1;
      float f2;
      if (i < j) {
        f1 = paramMotionEvent.getHistoricalX(i);
      } else {
        f1 = paramMotionEvent.getX();
      } 
      if (i < j) {
        f2 = paramMotionEvent.getHistoricalY(i);
      } else {
        f2 = paramMotionEvent.getY();
      } 
      Cell cell = a(f1, f2);
      int k = this.e.size();
      if (cell != null && k == 1) {
        this.n = true;
        e();
      } 
      float f3 = Math.abs(f1 - this.g);
      float f4 = Math.abs(f2 - this.h);
      if (f3 > 0.0F || f4 > 0.0F)
        bool = true; 
      if (this.n && k > 0) {
        Cell cell1 = this.e.get(k - 1);
        f4 = b(cell1.b);
        f3 = c(cell1.a);
        float f5 = Math.min(f4, f1) - f;
        float f7 = Math.max(f4, f1) + f;
        float f6 = Math.min(f3, f2) - f;
        float f8 = Math.max(f3, f2) + f;
        f4 = f7;
        f3 = f8;
        f2 = f6;
        f1 = f5;
        if (cell != null) {
          f2 = this.r * 0.5F;
          f3 = this.s * 0.5F;
          f4 = b(cell.b);
          float f9 = c(cell.a);
          f1 = Math.min(f4 - f2, f5);
          f4 = Math.max(f4 + f2, f7);
          f2 = Math.min(f9 - f3, f6);
          f3 = Math.max(f9 + f3, f8);
        } 
        this.A.union(Math.round(f1), Math.round(f2), Math.round(f4), Math.round(f3));
      } 
      i++;
    } 
    this.g = paramMotionEvent.getX();
    this.h = paramMotionEvent.getY();
    if (bool) {
      this.z.union(this.A);
      invalidate(this.z);
      this.z.set(this.A);
    } 
  }
  
  private void a(Cell paramCell) {
    this.f[paramCell.a()][paramCell.b()] = true;
    this.e.add(paramCell);
    d();
  }
  
  private float b(int paramInt) {
    float f1 = getPaddingLeft();
    float f2 = paramInt;
    float f3 = this.r;
    return f1 + f2 * f3 + f3 / 2.0F;
  }
  
  private int b(float paramFloat) {
    float f1 = this.r;
    float f2 = this.q * f1;
    float f3 = getPaddingLeft();
    float f4 = (f1 - f2) / 2.0F;
    int i;
    for (i = 0; i < 3; i++) {
      float f = i * f1 + f3 + f4;
      if (paramFloat >= f && paramFloat <= f + f2)
        return i; 
    } 
    return -1;
  }
  
  private Cell b(float paramFloat1, float paramFloat2) {
    int i = a(paramFloat2);
    if (i < 0)
      return null; 
    int j = b(paramFloat1);
    return (j < 0) ? null : (this.f[i][j] ? null : Cell.a(i, j));
  }
  
  private void b(MotionEvent paramMotionEvent) {
    if (!this.e.isEmpty()) {
      this.n = false;
      f();
      invalidate();
    } 
  }
  
  private float c(int paramInt) {
    float f1 = getPaddingTop();
    float f2 = paramInt;
    float f3 = this.s;
    return f1 + f2 * f3 + f3 / 2.0F;
  }
  
  private void c(MotionEvent paramMotionEvent) {
    h();
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    Cell cell = a(f1, f2);
    if (cell != null) {
      this.n = true;
      this.j = DisplayMode.a;
      e();
    } else if (this.n) {
      this.n = false;
      g();
    } 
    if (cell != null) {
      float f3 = b(cell.b);
      float f4 = c(cell.a);
      float f5 = this.r / 2.0F;
      float f6 = this.s / 2.0F;
      invalidate((int)(f3 - f5), (int)(f4 - f6), (int)(f3 + f5), (int)(f4 + f6));
    } 
    this.g = f1;
    this.h = f2;
  }
  
  private void d() {
    OnPatternListener onPatternListener = this.d;
    if (onPatternListener != null)
      onPatternListener.a(this.e); 
  }
  
  private void e() {
    OnPatternListener onPatternListener = this.d;
    if (onPatternListener != null)
      onPatternListener.a(); 
  }
  
  private void f() {
    OnPatternListener onPatternListener = this.d;
    if (onPatternListener != null)
      onPatternListener.b(this.e); 
  }
  
  private void g() {
    OnPatternListener onPatternListener = this.d;
    if (onPatternListener != null)
      onPatternListener.b(); 
  }
  
  private void h() {
    this.e.clear();
    i();
    this.j = DisplayMode.a;
    invalidate();
  }
  
  private void i() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++)
        this.f[i][j] = false; 
    } 
  }
  
  public void a() {
    h();
  }
  
  public void a(DisplayMode paramDisplayMode, List<Cell> paramList) {
    this.e.clear();
    this.e.addAll(paramList);
    i();
    for (Cell cell : paramList)
      this.f[cell.a()][cell.b()] = true; 
    setDisplayMode(paramDisplayMode);
  }
  
  public void b() {
    this.k = false;
  }
  
  public void c() {
    this.k = true;
  }
  
  protected int getSuggestedMinimumHeight() {
    return this.B * 3;
  }
  
  protected int getSuggestedMinimumWidth() {
    return this.B * 3;
  }
  
  protected void onDraw(Canvas paramCanvas) {
    int i;
    boolean bool1;
    ArrayList<Cell> arrayList = this.e;
    int k = arrayList.size();
    boolean[][] arrayOfBoolean = this.f;
    if (this.j == DisplayMode.b) {
      int i1 = (int)(SystemClock.elapsedRealtime() - this.i) % (k + 1) * 700;
      int i2 = i1 / 700;
      i();
      for (i = 0; i < i2; i++) {
        Cell cell = arrayList.get(i);
        arrayOfBoolean[cell.a()][cell.b()] = true;
      } 
      if (i2 > 0 && i2 < k) {
        i = 1;
      } else {
        i = 0;
      } 
      if (i != 0) {
        float f3 = (i1 % 700) / 700.0F;
        Cell cell = arrayList.get(i2 - 1);
        float f4 = b(cell.b);
        float f5 = c(cell.a);
        cell = arrayList.get(i2);
        float f6 = b(cell.b);
        float f7 = c(cell.a);
        this.g = f4 + (f6 - f4) * f3;
        this.h = f5 + f3 * (f7 - f5);
      } 
      invalidate();
    } 
    float f1 = this.r;
    float f2 = this.s;
    this.c.setStrokeWidth(3.0F);
    Path path = this.y;
    path.rewind();
    int m = getPaddingTop();
    int n = getPaddingLeft();
    if (!this.l || this.j == DisplayMode.c) {
      i = 1;
    } else {
      i = 0;
    } 
    if ((this.b.getFlags() & 0x2) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    } 
    this.b.setFilterBitmap(true);
    if (i) {
      int i1 = 0;
      boolean bool;
      for (bool = false; i1 < k; bool = true) {
        Cell cell = arrayList.get(i1);
        if (!arrayOfBoolean[cell.a][cell.b])
          break; 
        float f3 = b(cell.b);
        float f4 = c(cell.a);
        if (i1 == 0) {
          path.moveTo(f3, f4);
        } else {
          path.lineTo(f3, f4);
        } 
        i1++;
      } 
      if ((this.n || this.j == DisplayMode.b) && bool)
        path.lineTo(this.g, this.h); 
      if (this.j != DisplayMode.c) {
        i1 = 1;
      } else {
        i1 = 0;
      } 
      if (i1 != 0) {
        this.c.setColor(Color.parseColor("#3494f4"));
      } else {
        this.c.setColor(Color.parseColor("#fc5255"));
      } 
      paramCanvas.drawPath(path, this.c);
    } 
    int j;
    for (j = 0; j < 3; j++) {
      float f3 = m;
      float f4 = j;
      int i1;
      for (i1 = 0; i1 < 3; i1++)
        a(paramCanvas, (int)(n + i1 * f1), (int)(f3 + f4 * f2), arrayOfBoolean[j][i1]); 
    } 
    boolean bool2 = bool1;
    if (i) {
      i = 0;
      while (true) {
        bool2 = bool1;
        if (i < k - 1) {
          Cell cell1 = arrayList.get(i);
          Cell cell2 = arrayList.get(++i);
          if (!arrayOfBoolean[cell2.a][cell2.b]) {
            bool2 = bool1;
            break;
          } 
          a(paramCanvas, n + cell1.b * f1, m + cell1.a * f2, cell1, cell2);
          continue;
        } 
        break;
      } 
    } 
    this.b.setFilterBitmap(bool2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2) {
    int j = getSuggestedMinimumWidth();
    int i = getSuggestedMinimumHeight();
    paramInt1 = a(paramInt1, j);
    paramInt2 = a(paramInt2, i);
    i = this.D;
    if (i != 0) {
      if (i != 1) {
        if (i == 2)
          paramInt1 = Math.min(paramInt1, paramInt2); 
      } else {
        paramInt2 = Math.min(paramInt1, paramInt2);
      } 
    } else {
      paramInt1 = Math.min(paramInt1, paramInt2);
      paramInt2 = paramInt1;
    } 
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable) {
    SavedState savedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(savedState.getSuperState());
    try {
      a(DisplayMode.a, a(savedState.a()));
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
    } 
    this.j = DisplayMode.values()[savedState.b()];
    this.k = savedState.c();
    this.l = savedState.d();
    this.m = savedState.e();
  }
  
  protected Parcelable onSaveInstanceState() {
    return (Parcelable)new SavedState(super.onSaveInstanceState(), a(this.e), this.j.ordinal(), this.k, this.l, this.m);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.r = (paramInt1 - getPaddingLeft() - getPaddingRight()) / 3.0F;
    this.s = (paramInt2 - getPaddingTop() - getPaddingBottom()) / 3.0F;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent) {
    if (this.k) {
      if (!isEnabled())
        return false; 
      int i = paramMotionEvent.getAction();
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3)
              return false; 
            if (this.n) {
              this.n = false;
              h();
              g();
            } 
            return true;
          } 
          a(paramMotionEvent);
          return true;
        } 
        b(paramMotionEvent);
        return true;
      } 
      c(paramMotionEvent);
      return true;
    } 
    return false;
  }
  
  public void setDisplayMode(DisplayMode paramDisplayMode) {
    this.j = paramDisplayMode;
    if (paramDisplayMode == DisplayMode.b)
      if (this.e.size() != 0) {
        this.i = SystemClock.elapsedRealtime();
        Cell cell = this.e.get(0);
        this.g = b(cell.b());
        this.h = c(cell.a());
        i();
      } else {
        throw new IllegalStateException("you must have a pattern to animate if you want to set the display mode to animate");
      }  
    invalidate();
  }
  
  public void setInStealthMode(boolean paramBoolean) {
    this.l = paramBoolean;
  }
  
  public void setOnPatternListener(OnPatternListener paramOnPatternListener) {
    this.d = paramOnPatternListener;
  }
  
  public void setTactileFeedbackEnabled(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public static class Cell {
    static Cell[][] c = (Cell[][])Array.newInstance(Cell.class, new int[] { 3, 3 });
    
    int a;
    
    int b;
    
    static {
      for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++)
          c[i][j] = new Cell(i, j); 
      } 
    }
    
    private Cell(int param1Int1, int param1Int2) {
      b(param1Int1, param1Int2);
      this.a = param1Int1;
      this.b = param1Int2;
    }
    
    public static Cell a(int param1Int1, int param1Int2) {
      // Byte code:
      //   0: ldc com/soft/blued/customview/LockPatternView$Cell
      //   2: monitorenter
      //   3: iload_0
      //   4: iload_1
      //   5: invokestatic b : (II)V
      //   8: getstatic com/soft/blued/customview/LockPatternView$Cell.c : [[Lcom/soft/blued/customview/LockPatternView$Cell;
      //   11: iload_0
      //   12: aaload
      //   13: iload_1
      //   14: aaload
      //   15: astore_2
      //   16: ldc com/soft/blued/customview/LockPatternView$Cell
      //   18: monitorexit
      //   19: aload_2
      //   20: areturn
      //   21: astore_2
      //   22: ldc com/soft/blued/customview/LockPatternView$Cell
      //   24: monitorexit
      //   25: aload_2
      //   26: athrow
      // Exception table:
      //   from	to	target	type
      //   3	16	21	finally
    }
    
    private static void b(int param1Int1, int param1Int2) {
      if (param1Int1 >= 0 && param1Int1 <= 2) {
        if (param1Int2 >= 0 && param1Int2 <= 2)
          return; 
        throw new IllegalArgumentException("column must be in range 0-2");
      } 
      throw new IllegalArgumentException("row must be in range 0-2");
    }
    
    public int a() {
      return this.a;
    }
    
    public int b() {
      return this.b;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("(row=");
      stringBuilder.append(this.a);
      stringBuilder.append(",clmn=");
      stringBuilder.append(this.b);
      stringBuilder.append(")");
      return stringBuilder.toString();
    }
  }
  
  public enum DisplayMode {
    a, b, c;
  }
  
  public static interface OnPatternListener {
    void a();
    
    void a(List<LockPatternView.Cell> param1List);
    
    void b();
    
    void b(List<LockPatternView.Cell> param1List);
  }
  
  static class SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
        public LockPatternView.SavedState a(Parcel param2Parcel) {
          return new LockPatternView.SavedState(param2Parcel);
        }
        
        public LockPatternView.SavedState[] a(int param2Int) {
          return new LockPatternView.SavedState[param2Int];
        }
      };
    
    private final String a;
    
    private final int b;
    
    private final boolean c;
    
    private final boolean d;
    
    private final boolean e;
    
    private SavedState(Parcel param1Parcel) {
      super(param1Parcel);
      this.a = param1Parcel.readString();
      this.b = param1Parcel.readInt();
      this.c = ((Boolean)param1Parcel.readValue(null)).booleanValue();
      this.d = ((Boolean)param1Parcel.readValue(null)).booleanValue();
      this.e = ((Boolean)param1Parcel.readValue(null)).booleanValue();
    }
    
    private SavedState(Parcelable param1Parcelable, String param1String, int param1Int, boolean param1Boolean1, boolean param1Boolean2, boolean param1Boolean3) {
      super(param1Parcelable);
      this.a = param1String;
      this.b = param1Int;
      this.c = param1Boolean1;
      this.d = param1Boolean2;
      this.e = param1Boolean3;
    }
    
    public String a() {
      return this.a;
    }
    
    public int b() {
      return this.b;
    }
    
    public boolean c() {
      return this.c;
    }
    
    public boolean d() {
      return this.d;
    }
    
    public boolean e() {
      return this.e;
    }
    
    public void writeToParcel(Parcel param1Parcel, int param1Int) {
      super.writeToParcel(param1Parcel, param1Int);
      param1Parcel.writeString(this.a);
      param1Parcel.writeInt(this.b);
      param1Parcel.writeValue(Boolean.valueOf(this.c));
      param1Parcel.writeValue(Boolean.valueOf(this.d));
      param1Parcel.writeValue(Boolean.valueOf(this.e));
    }
  }
  
  static final class null implements Parcelable.Creator<SavedState> {
    public LockPatternView.SavedState a(Parcel param1Parcel) {
      return new LockPatternView.SavedState(param1Parcel);
    }
    
    public LockPatternView.SavedState[] a(int param1Int) {
      return new LockPatternView.SavedState[param1Int];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\LockPatternView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */