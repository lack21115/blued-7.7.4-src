package a.d.b;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class c {
  public static final int[] b = new int[] { 0, 4, 8 };
  
  public static SparseIntArray c = new SparseIntArray();
  
  public HashMap<Integer, a> a = new HashMap<Integer, a>();
  
  static {
    c.append(h.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
    c.append(h.ConstraintSet_layout_constraintLeft_toRightOf, 26);
    c.append(h.ConstraintSet_layout_constraintRight_toLeftOf, 29);
    c.append(h.ConstraintSet_layout_constraintRight_toRightOf, 30);
    c.append(h.ConstraintSet_layout_constraintTop_toTopOf, 36);
    c.append(h.ConstraintSet_layout_constraintTop_toBottomOf, 35);
    c.append(h.ConstraintSet_layout_constraintBottom_toTopOf, 4);
    c.append(h.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
    c.append(h.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
    c.append(h.ConstraintSet_layout_editor_absoluteX, 6);
    c.append(h.ConstraintSet_layout_editor_absoluteY, 7);
    c.append(h.ConstraintSet_layout_constraintGuide_begin, 17);
    c.append(h.ConstraintSet_layout_constraintGuide_end, 18);
    c.append(h.ConstraintSet_layout_constraintGuide_percent, 19);
    c.append(h.ConstraintSet_android_orientation, 27);
    c.append(h.ConstraintSet_layout_constraintStart_toEndOf, 32);
    c.append(h.ConstraintSet_layout_constraintStart_toStartOf, 33);
    c.append(h.ConstraintSet_layout_constraintEnd_toStartOf, 10);
    c.append(h.ConstraintSet_layout_constraintEnd_toEndOf, 9);
    c.append(h.ConstraintSet_layout_goneMarginLeft, 13);
    c.append(h.ConstraintSet_layout_goneMarginTop, 16);
    c.append(h.ConstraintSet_layout_goneMarginRight, 14);
    c.append(h.ConstraintSet_layout_goneMarginBottom, 11);
    c.append(h.ConstraintSet_layout_goneMarginStart, 15);
    c.append(h.ConstraintSet_layout_goneMarginEnd, 12);
    c.append(h.ConstraintSet_layout_constraintVertical_weight, 40);
    c.append(h.ConstraintSet_layout_constraintHorizontal_weight, 39);
    c.append(h.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
    c.append(h.ConstraintSet_layout_constraintVertical_chainStyle, 42);
    c.append(h.ConstraintSet_layout_constraintHorizontal_bias, 20);
    c.append(h.ConstraintSet_layout_constraintVertical_bias, 37);
    c.append(h.ConstraintSet_layout_constraintDimensionRatio, 5);
    c.append(h.ConstraintSet_layout_constraintLeft_creator, 75);
    c.append(h.ConstraintSet_layout_constraintTop_creator, 75);
    c.append(h.ConstraintSet_layout_constraintRight_creator, 75);
    c.append(h.ConstraintSet_layout_constraintBottom_creator, 75);
    c.append(h.ConstraintSet_layout_constraintBaseline_creator, 75);
    c.append(h.ConstraintSet_android_layout_marginLeft, 24);
    c.append(h.ConstraintSet_android_layout_marginRight, 28);
    c.append(h.ConstraintSet_android_layout_marginStart, 31);
    c.append(h.ConstraintSet_android_layout_marginEnd, 8);
    c.append(h.ConstraintSet_android_layout_marginTop, 34);
    c.append(h.ConstraintSet_android_layout_marginBottom, 2);
    c.append(h.ConstraintSet_android_layout_width, 23);
    c.append(h.ConstraintSet_android_layout_height, 21);
    c.append(h.ConstraintSet_android_visibility, 22);
    c.append(h.ConstraintSet_android_alpha, 43);
    c.append(h.ConstraintSet_android_elevation, 44);
    c.append(h.ConstraintSet_android_rotationX, 45);
    c.append(h.ConstraintSet_android_rotationY, 46);
    c.append(h.ConstraintSet_android_rotation, 60);
    c.append(h.ConstraintSet_android_scaleX, 47);
    c.append(h.ConstraintSet_android_scaleY, 48);
    c.append(h.ConstraintSet_android_transformPivotX, 49);
    c.append(h.ConstraintSet_android_transformPivotY, 50);
    c.append(h.ConstraintSet_android_translationX, 51);
    c.append(h.ConstraintSet_android_translationY, 52);
    c.append(h.ConstraintSet_android_translationZ, 53);
    c.append(h.ConstraintSet_layout_constraintWidth_default, 54);
    c.append(h.ConstraintSet_layout_constraintHeight_default, 55);
    c.append(h.ConstraintSet_layout_constraintWidth_max, 56);
    c.append(h.ConstraintSet_layout_constraintHeight_max, 57);
    c.append(h.ConstraintSet_layout_constraintWidth_min, 58);
    c.append(h.ConstraintSet_layout_constraintHeight_min, 59);
    c.append(h.ConstraintSet_layout_constraintCircle, 61);
    c.append(h.ConstraintSet_layout_constraintCircleRadius, 62);
    c.append(h.ConstraintSet_layout_constraintCircleAngle, 63);
    c.append(h.ConstraintSet_android_id, 38);
    c.append(h.ConstraintSet_layout_constraintWidth_percent, 69);
    c.append(h.ConstraintSet_layout_constraintHeight_percent, 70);
    c.append(h.ConstraintSet_chainUseRtl, 71);
    c.append(h.ConstraintSet_barrierDirection, 72);
    c.append(h.ConstraintSet_constraint_referenced_ids, 73);
    c.append(h.ConstraintSet_barrierAllowsGoneWidgets, 74);
    throw new VerifyError("bad dex opcode");
  }
  
  public c() {
    throw new VerifyError("bad dex opcode");
  }
  
  public final a a(Context paramContext, AttributeSet paramAttributeSet) {
    a a = new a();
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, h.ConstraintSet);
    int j = typedArray.getIndexCount();
    for (int i = 0;; i++) {
      if (i < j) {
        StringBuilder stringBuilder;
        int m;
        int n = typedArray.getIndex(i);
        int k = c.get(n);
        switch (k) {
          default:
            switch (k) {
              default:
                switch (k) {
                  default:
                    stringBuilder = b.a.a.a.a.a("Unknown attribute 0x");
                    stringBuilder.append(Integer.toHexString(n));
                    stringBuilder.append("   ");
                    stringBuilder.append(c.get(n));
                    Log.w("ConstraintSet", stringBuilder.toString());
                    break;
                  case 75:
                    stringBuilder = b.a.a.a.a.a("unused attribute 0x");
                    stringBuilder.append(Integer.toHexString(n));
                    stringBuilder.append("   ");
                    stringBuilder.append(c.get(n));
                    Log.w("ConstraintSet", stringBuilder.toString());
                    break;
                  case 74:
                    a.r0 = typedArray.getBoolean(n, a.r0);
                    break;
                  case 73:
                    a.v0 = typedArray.getString(n);
                    break;
                  case 72:
                    a.s0 = typedArray.getInt(n, a.s0);
                    break;
                  case 71:
                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                    break;
                  case 70:
                    a.q0 = typedArray.getFloat(n, 1.0F);
                    break;
                  case 69:
                    a.p0 = typedArray.getFloat(n, 1.0F);
                    break;
                } 
                i++;
                continue;
              case 63:
                a.z = typedArray.getFloat(n, a.z);
                break;
              case 62:
                a.y = typedArray.getDimensionPixelSize(n, a.y);
                break;
              case 61:
                m = typedArray.getResourceId(n, a.x);
                k = m;
                if (m == -1)
                  k = typedArray.getInt(n, -1); 
                a.x = k;
                break;
              case 60:
                a.X = typedArray.getFloat(n, a.X);
                break;
            } 
            i++;
            continue;
          case 53:
            a.g0 = typedArray.getDimension(n, a.g0);
            break;
          case 52:
            a.f0 = typedArray.getDimension(n, a.f0);
            break;
          case 51:
            a.e0 = typedArray.getDimension(n, a.e0);
            break;
          case 50:
            a.d0 = typedArray.getFloat(n, a.d0);
            break;
          case 49:
            a.c0 = typedArray.getFloat(n, a.c0);
            break;
          case 48:
            a.b0 = typedArray.getFloat(n, a.b0);
            break;
          case 47:
            a.a0 = typedArray.getFloat(n, a.a0);
            break;
          case 46:
            a.Z = typedArray.getFloat(n, a.Z);
            break;
          case 45:
            a.Y = typedArray.getFloat(n, a.Y);
            break;
          case 44:
            a.V = true;
            a.W = typedArray.getDimension(n, a.W);
            break;
          case 43:
            a.U = typedArray.getFloat(n, a.U);
            break;
          case 42:
            a.T = typedArray.getInt(n, a.T);
            break;
          case 41:
            a.S = typedArray.getInt(n, a.S);
            break;
          case 40:
            a.Q = typedArray.getFloat(n, a.Q);
            break;
          case 39:
            a.R = typedArray.getFloat(n, a.R);
            break;
          case 38:
            a.d = typedArray.getResourceId(n, a.d);
            break;
          case 37:
            a.v = typedArray.getFloat(n, a.v);
            break;
          case 36:
            m = typedArray.getResourceId(n, a.l);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.l = k;
            break;
          case 35:
            m = typedArray.getResourceId(n, a.m);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.m = k;
            break;
          case 34:
            a.F = typedArray.getDimensionPixelSize(n, a.F);
            break;
          case 33:
            m = typedArray.getResourceId(n, a.r);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.r = k;
            break;
          case 32:
            m = typedArray.getResourceId(n, a.q);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.q = k;
            break;
          case 31:
            a.I = typedArray.getDimensionPixelSize(n, a.I);
            break;
          case 30:
            m = typedArray.getResourceId(n, a.k);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.k = k;
            break;
          case 29:
            m = typedArray.getResourceId(n, a.j);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.j = k;
            break;
          case 28:
            a.E = typedArray.getDimensionPixelSize(n, a.E);
            break;
          case 27:
            a.C = typedArray.getInt(n, a.C);
            break;
          case 26:
            m = typedArray.getResourceId(n, a.i);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.i = k;
            break;
          case 25:
            m = typedArray.getResourceId(n, a.h);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.h = k;
            break;
          case 24:
            a.D = typedArray.getDimensionPixelSize(n, a.D);
            break;
          case 23:
            a.b = typedArray.getLayoutDimension(n, a.b);
            break;
          case 22:
            a.J = typedArray.getInt(n, a.J);
            a.J = b[a.J];
            break;
          case 21:
            a.c = typedArray.getLayoutDimension(n, a.c);
            break;
          case 20:
            a.u = typedArray.getFloat(n, a.u);
            break;
          case 19:
            a.g = typedArray.getFloat(n, a.g);
            break;
          case 18:
            a.f = typedArray.getDimensionPixelOffset(n, a.f);
            break;
          case 17:
            a.e = typedArray.getDimensionPixelOffset(n, a.e);
            break;
          case 16:
            a.L = typedArray.getDimensionPixelSize(n, a.L);
            break;
          case 15:
            a.P = typedArray.getDimensionPixelSize(n, a.P);
            break;
          case 14:
            a.M = typedArray.getDimensionPixelSize(n, a.M);
            break;
          case 13:
            a.K = typedArray.getDimensionPixelSize(n, a.K);
            break;
          case 12:
            a.O = typedArray.getDimensionPixelSize(n, a.O);
            break;
          case 11:
            a.N = typedArray.getDimensionPixelSize(n, a.N);
            break;
          case 10:
            m = typedArray.getResourceId(n, a.s);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.s = k;
            break;
          case 9:
            m = typedArray.getResourceId(n, a.t);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.t = k;
            break;
          case 8:
            a.H = typedArray.getDimensionPixelSize(n, a.H);
            break;
          case 7:
            a.B = typedArray.getDimensionPixelOffset(n, a.B);
            break;
          case 6:
            a.A = typedArray.getDimensionPixelOffset(n, a.A);
            break;
          case 5:
            a.w = typedArray.getString(n);
            break;
          case 4:
            m = typedArray.getResourceId(n, a.n);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.n = k;
            break;
          case 3:
            m = typedArray.getResourceId(n, a.o);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.o = k;
            break;
          case 2:
            a.G = typedArray.getDimensionPixelSize(n, a.G);
            break;
          case 1:
            m = typedArray.getResourceId(n, a.p);
            k = m;
            if (m == -1)
              k = typedArray.getInt(n, -1); 
            a.p = k;
            break;
        } 
      } else {
        break;
      } 
    } 
    typedArray.recycle();
    return a;
  }
  
  public void a(d paramd) {
    int j = paramd.getChildCount();
    this.a.clear();
    int i = 0;
    while (i < j) {
      View view = paramd.getChildAt(i);
      d.a a = (d.a)view.getLayoutParams();
      int k = view.getId();
      if (k != -1) {
        if (!this.a.containsKey(Integer.valueOf(k)))
          this.a.put(Integer.valueOf(k), new a()); 
        a a1 = this.a.get(Integer.valueOf(k));
        if (view instanceof b) {
          view = view;
          a1.a(k, a);
          if (view instanceof a) {
            a1.t0 = 1;
            view = view;
            a1.s0 = view.getType();
            a1.u0 = view.getReferencedIds();
          } 
        } 
        a1.a(k, a);
        i++;
        continue;
      } 
      throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public void a(Context paramContext, int paramInt) {
    XmlResourceParser xmlResourceParser = paramContext.getResources().getXml(paramInt);
    try {
      paramInt = xmlResourceParser.getEventType();
    } catch (XmlPullParserException xmlPullParserException) {
      xmlPullParserException.printStackTrace();
      throw new VerifyError("bad dex opcode");
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    while (true) {
      if (paramInt != 1) {
        if (paramInt != 0) {
          if (paramInt == 2) {
            String str = xmlResourceParser.getName();
            a a = a((Context)iOException, Xml.asAttributeSet((XmlPullParser)xmlResourceParser));
            if (str.equalsIgnoreCase("Guideline"))
              a.a = true; 
            this.a.put(Integer.valueOf(a.d), a);
          } 
        } else {
          xmlResourceParser.getName();
        } 
        paramInt = xmlResourceParser.next();
        continue;
      } 
      throw new VerifyError("bad dex opcode");
    } 
  }
  
  public void a(ConstraintLayout paramConstraintLayout) {
    int j = paramConstraintLayout.getChildCount();
    HashSet hashSet = new HashSet(this.a.keySet());
    int i = 0;
    while (i < j) {
      View view = paramConstraintLayout.getChildAt(i);
      int k = view.getId();
      if (k != -1) {
        if (this.a.containsKey(Integer.valueOf(k))) {
          hashSet.remove(Integer.valueOf(k));
          a a = this.a.get(Integer.valueOf(k));
          if (view instanceof a)
            a.t0 = 1; 
          int m = a.t0;
          if (m != -1 && m == 1) {
            a a2 = (a)view;
            a2.setId(k);
            a2.setType(a.s0);
            a2.setAllowsGoneWidget(a.r0);
            int[] arrayOfInt = a.u0;
            if (arrayOfInt != null) {
              a2.setReferencedIds(arrayOfInt);
            } else {
              String str = a.v0;
              if (str != null) {
                a.u0 = a(a2, str);
                a2.setReferencedIds(a.u0);
              } 
            } 
          } 
          ConstraintLayout.a a1 = (ConstraintLayout.a)view.getLayoutParams();
          a.a(a1);
          view.setLayoutParams((ViewGroup.LayoutParams)a1);
          view.setVisibility(a.J);
          if (Build.VERSION.SDK_INT >= 17) {
            view.setAlpha(a.U);
            view.setRotation(a.X);
            view.setRotationX(a.Y);
            view.setRotationY(a.Z);
            view.setScaleX(a.a0);
            view.setScaleY(a.b0);
            if (!Float.isNaN(a.c0))
              view.setPivotX(a.c0); 
            if (!Float.isNaN(a.d0))
              view.setPivotY(a.d0); 
            view.setTranslationX(a.e0);
            view.setTranslationY(a.f0);
            if (Build.VERSION.SDK_INT >= 21) {
              view.setTranslationZ(a.g0);
              if (a.V)
                view.setElevation(a.W); 
            } 
          } 
        } 
        i++;
        continue;
      } 
      throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
    } 
    for (Integer integer : hashSet) {
      a a = this.a.get(integer);
      i = a.t0;
      if (i != -1 && i == 1) {
        a a1 = new a(paramConstraintLayout.getContext());
        a1.setId(integer.intValue());
        int[] arrayOfInt = a.u0;
        if (arrayOfInt != null) {
          a1.setReferencedIds(arrayOfInt);
        } else {
          String str = a.v0;
          if (str != null) {
            a.u0 = a(a1, str);
            a1.setReferencedIds(a.u0);
          } 
        } 
        a1.setType(a.s0);
        ConstraintLayout.a a2 = paramConstraintLayout.generateDefaultLayoutParams();
        a1.c();
        a.a(a2);
        paramConstraintLayout.addView(a1, (ViewGroup.LayoutParams)a2);
      } 
      if (a.a) {
        e e = new e(paramConstraintLayout.getContext());
        e.setId(integer.intValue());
        ConstraintLayout.a a1 = paramConstraintLayout.generateDefaultLayoutParams();
        a.a(a1);
        paramConstraintLayout.addView(e, (ViewGroup.LayoutParams)a1);
      } 
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public final int[] a(View paramView, String paramString) {
    String[] arrayOfString = paramString.split(",");
    Context context = paramView.getContext();
    int[] arrayOfInt = new int[arrayOfString.length];
    int j = 0;
    int i = 0;
    while (true) {
      if (j < arrayOfString.length) {
        String str = arrayOfString[j].trim();
        try {
          m = g.class.getField(str).getInt(null);
        } catch (Exception exception) {
          m = 0;
        } 
        int k = m;
        if (!m)
          k = context.getResources().getIdentifier(str, "id", context.getPackageName()); 
        int m = k;
        if (k == 0) {
          m = k;
          if (paramView.isInEditMode()) {
            m = k;
            if (paramView.getParent() instanceof ConstraintLayout) {
              Object object = ((ConstraintLayout)paramView.getParent()).a(0, str);
              m = k;
              if (object != null) {
                m = k;
                if (object instanceof Integer)
                  m = ((Integer)object).intValue(); 
              } 
            } 
          } 
        } 
        arrayOfInt[i] = m;
        j++;
        i++;
        continue;
      } 
      int[] arrayOfInt1 = arrayOfInt;
      if (i != arrayOfString.length)
        arrayOfInt1 = Arrays.copyOf(arrayOfInt, i); 
      return arrayOfInt1;
    } 
  }
  
  public static class a {
    public int A = -1;
    
    public int B = -1;
    
    public int C = -1;
    
    public int D = -1;
    
    public int E = -1;
    
    public int F = -1;
    
    public int G = -1;
    
    public int H = -1;
    
    public int I = -1;
    
    public int J = 0;
    
    public int K = -1;
    
    public int L = -1;
    
    public int M = -1;
    
    public int N = -1;
    
    public int O = -1;
    
    public int P = -1;
    
    public float Q = 0.0F;
    
    public float R = 0.0F;
    
    public int S = 0;
    
    public int T = 0;
    
    public float U = 1.0F;
    
    public boolean V = false;
    
    public float W = 0.0F;
    
    public float X = 0.0F;
    
    public float Y = 0.0F;
    
    public float Z = 0.0F;
    
    public boolean a = false;
    
    public float a0 = 1.0F;
    
    public int b;
    
    public float b0 = 1.0F;
    
    public int c;
    
    public float c0 = Float.NaN;
    
    public int d;
    
    public float d0 = Float.NaN;
    
    public int e = -1;
    
    public float e0 = 0.0F;
    
    public int f = -1;
    
    public float f0 = 0.0F;
    
    public float g = -1.0F;
    
    public float g0 = 0.0F;
    
    public int h = -1;
    
    public boolean h0 = false;
    
    public int i = -1;
    
    public boolean i0 = false;
    
    public int j = -1;
    
    public int j0 = 0;
    
    public int k = -1;
    
    public int k0 = 0;
    
    public int l = -1;
    
    public int l0 = -1;
    
    public int m = -1;
    
    public int m0 = -1;
    
    public int n = -1;
    
    public int n0 = -1;
    
    public int o = -1;
    
    public int o0 = -1;
    
    public int p = -1;
    
    public float p0 = 1.0F;
    
    public int q = -1;
    
    public float q0 = 1.0F;
    
    public int r = -1;
    
    public boolean r0 = false;
    
    public int s = -1;
    
    public int s0 = -1;
    
    public int t = -1;
    
    public int t0 = -1;
    
    public float u = 0.5F;
    
    public int[] u0;
    
    public float v = 0.5F;
    
    public String v0;
    
    public String w = null;
    
    public int x = -1;
    
    public int y = 0;
    
    public float z = 0.0F;
    
    public a() {
      throw new VerifyError("bad dex opcode");
    }
    
    public final void a(int param1Int, d.a param1a) {
      this.d = param1Int;
      this.h = param1a.d;
      this.i = param1a.e;
      this.j = param1a.f;
      this.k = param1a.g;
      this.l = param1a.h;
      this.m = param1a.i;
      this.n = param1a.j;
      this.o = param1a.k;
      this.p = param1a.l;
      this.q = param1a.p;
      this.r = param1a.q;
      this.s = param1a.r;
      this.t = param1a.s;
      this.u = param1a.z;
      this.v = param1a.A;
      this.w = param1a.B;
      this.x = param1a.m;
      this.y = param1a.n;
      this.z = param1a.o;
      this.A = param1a.P;
      this.B = param1a.Q;
      this.C = param1a.R;
      this.g = param1a.c;
      this.e = param1a.a;
      this.f = param1a.b;
      this.b = ((ViewGroup.MarginLayoutParams)param1a).width;
      this.c = ((ViewGroup.MarginLayoutParams)param1a).height;
      this.D = ((ViewGroup.MarginLayoutParams)param1a).leftMargin;
      this.E = ((ViewGroup.MarginLayoutParams)param1a).rightMargin;
      this.F = ((ViewGroup.MarginLayoutParams)param1a).topMargin;
      this.G = ((ViewGroup.MarginLayoutParams)param1a).bottomMargin;
      this.Q = param1a.E;
      this.R = param1a.D;
      this.T = param1a.G;
      this.S = param1a.F;
      boolean bool = param1a.S;
      this.h0 = bool;
      this.i0 = param1a.T;
      this.j0 = param1a.H;
      this.k0 = param1a.I;
      this.h0 = bool;
      this.l0 = param1a.L;
      this.m0 = param1a.M;
      this.n0 = param1a.J;
      this.o0 = param1a.K;
      this.p0 = param1a.N;
      this.q0 = param1a.O;
      if (Build.VERSION.SDK_INT >= 17) {
        this.H = param1a.getMarginEnd();
        this.I = param1a.getMarginStart();
      } 
      this.U = param1a.m0;
      this.X = param1a.p0;
      this.Y = param1a.q0;
      this.Z = param1a.r0;
      this.a0 = param1a.s0;
      this.b0 = param1a.t0;
      this.c0 = param1a.u0;
      this.d0 = param1a.v0;
      this.e0 = param1a.w0;
      this.f0 = param1a.x0;
      this.g0 = param1a.y0;
      this.W = param1a.o0;
      this.V = param1a.n0;
      throw new VerifyError("bad dex opcode");
    }
    
    public void a(ConstraintLayout.a param1a) {
      param1a.d = this.h;
      param1a.e = this.i;
      param1a.f = this.j;
      param1a.g = this.k;
      param1a.h = this.l;
      param1a.i = this.m;
      param1a.j = this.n;
      param1a.k = this.o;
      param1a.l = this.p;
      param1a.p = this.q;
      param1a.q = this.r;
      param1a.r = this.s;
      param1a.s = this.t;
      ((ViewGroup.MarginLayoutParams)param1a).leftMargin = this.D;
      ((ViewGroup.MarginLayoutParams)param1a).rightMargin = this.E;
      ((ViewGroup.MarginLayoutParams)param1a).topMargin = this.F;
      ((ViewGroup.MarginLayoutParams)param1a).bottomMargin = this.G;
      param1a.x = this.P;
      param1a.y = this.O;
      param1a.z = this.u;
      param1a.A = this.v;
      param1a.m = this.x;
      param1a.n = this.y;
      param1a.o = this.z;
      param1a.B = this.w;
      param1a.P = this.A;
      param1a.Q = this.B;
      param1a.E = this.Q;
      param1a.D = this.R;
      param1a.G = this.T;
      param1a.F = this.S;
      param1a.S = this.h0;
      param1a.T = this.i0;
      param1a.H = this.j0;
      param1a.I = this.k0;
      param1a.L = this.l0;
      param1a.M = this.m0;
      param1a.J = this.n0;
      param1a.K = this.o0;
      param1a.N = this.p0;
      param1a.O = this.q0;
      param1a.R = this.C;
      param1a.c = this.g;
      param1a.a = this.e;
      param1a.b = this.f;
      ((ViewGroup.MarginLayoutParams)param1a).width = this.b;
      ((ViewGroup.MarginLayoutParams)param1a).height = this.c;
      if (Build.VERSION.SDK_INT >= 17) {
        param1a.setMarginStart(this.I);
        param1a.setMarginEnd(this.H);
      } 
      param1a.a();
      throw new VerifyError("bad dex opcode");
    }
    
    public Object clone() {
      a a1 = new a();
      a1.a = this.a;
      a1.b = this.b;
      a1.c = this.c;
      a1.e = this.e;
      a1.f = this.f;
      a1.g = this.g;
      a1.h = this.h;
      a1.i = this.i;
      a1.j = this.j;
      a1.k = this.k;
      a1.l = this.l;
      a1.m = this.m;
      a1.n = this.n;
      a1.o = this.o;
      a1.p = this.p;
      a1.q = this.q;
      a1.r = this.r;
      a1.s = this.s;
      a1.t = this.t;
      a1.u = this.u;
      a1.v = this.v;
      a1.w = this.w;
      a1.A = this.A;
      a1.B = this.B;
      a1.u = this.u;
      a1.u = this.u;
      a1.u = this.u;
      a1.u = this.u;
      a1.u = this.u;
      a1.C = this.C;
      a1.D = this.D;
      a1.E = this.E;
      a1.F = this.F;
      a1.G = this.G;
      a1.H = this.H;
      a1.I = this.I;
      a1.J = this.J;
      a1.K = this.K;
      a1.L = this.L;
      a1.M = this.M;
      a1.N = this.N;
      a1.O = this.O;
      a1.P = this.P;
      a1.Q = this.Q;
      a1.R = this.R;
      a1.S = this.S;
      a1.T = this.T;
      a1.U = this.U;
      a1.V = this.V;
      a1.W = this.W;
      a1.X = this.X;
      a1.Y = this.Y;
      a1.Z = this.Z;
      a1.a0 = this.a0;
      a1.b0 = this.b0;
      a1.c0 = this.c0;
      a1.d0 = this.d0;
      a1.e0 = this.e0;
      a1.f0 = this.f0;
      a1.g0 = this.g0;
      a1.h0 = this.h0;
      a1.i0 = this.i0;
      a1.j0 = this.j0;
      a1.k0 = this.k0;
      a1.l0 = this.l0;
      a1.m0 = this.m0;
      a1.n0 = this.n0;
      a1.o0 = this.o0;
      a1.p0 = this.p0;
      a1.q0 = this.q0;
      a1.s0 = this.s0;
      a1.t0 = this.t0;
      int[] arrayOfInt = this.u0;
      if (arrayOfInt != null)
        a1.u0 = Arrays.copyOf(arrayOfInt, arrayOfInt.length); 
      a1.x = this.x;
      a1.y = this.y;
      a1.z = this.z;
      a1.r0 = this.r0;
      return a1;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\d\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */