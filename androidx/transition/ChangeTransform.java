package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform extends Transition {
  static {
    if (Build.VERSION.SDK_INT >= 21) {
      bool = true;
    } else {
      bool = false;
    } 
    l = bool;
  }
  
  public ChangeTransform() {}
  
  public ChangeTransform(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.g);
    XmlPullParser xmlPullParser = (XmlPullParser)paramAttributeSet;
    this.a = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "reparentWithOverlay", 1, true);
    this.m = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "reparent", 0, true);
    typedArray.recycle();
  }
  
  private ObjectAnimator a(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2, boolean paramBoolean) {
    Matrix matrix1 = (Matrix)paramTransitionValues1.values.get("android:changeTransform:matrix");
    Matrix matrix3 = (Matrix)paramTransitionValues2.values.get("android:changeTransform:matrix");
    Matrix matrix2 = matrix1;
    if (matrix1 == null)
      matrix2 = MatrixUtils.a; 
    matrix1 = matrix3;
    if (matrix3 == null)
      matrix1 = MatrixUtils.a; 
    if (matrix2.equals(matrix1))
      return null; 
    Transforms transforms = (Transforms)paramTransitionValues2.values.get("android:changeTransform:transforms");
    View view = paramTransitionValues2.view;
    a(view);
    float[] arrayOfFloat1 = new float[9];
    matrix2.getValues(arrayOfFloat1);
    float[] arrayOfFloat2 = new float[9];
    matrix1.getValues(arrayOfFloat2);
    PathAnimatorMatrix pathAnimatorMatrix = new PathAnimatorMatrix(view, arrayOfFloat1);
    PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofObject(j, new FloatArrayEvaluator(new float[9]), (Object[])new float[][] { arrayOfFloat1, arrayOfFloat2 });
    Path path = getPathMotion().getPath(arrayOfFloat1[2], arrayOfFloat1[5], arrayOfFloat2[2], arrayOfFloat2[5]);
    ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(pathAnimatorMatrix, new PropertyValuesHolder[] { propertyValuesHolder, PropertyValuesHolderUtils.a(k, path) });
    AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter(this, paramBoolean, matrix1, view, transforms, pathAnimatorMatrix) {
        private boolean g;
        
        private Matrix h = new Matrix();
        
        private void a(Matrix param1Matrix) {
          this.h.set(param1Matrix);
          this.c.setTag(R.id.transition_transform, this.h);
          this.d.restore(this.c);
        }
        
        public void onAnimationCancel(Animator param1Animator) {
          this.g = true;
        }
        
        public void onAnimationEnd(Animator param1Animator) {
          if (!this.g)
            if (this.a && this.f.a) {
              a(this.b);
            } else {
              this.c.setTag(R.id.transition_transform, null);
              this.c.setTag(R.id.parent_matrix, null);
            }  
          ViewUtils.c(this.c, null);
          this.d.restore(this.c);
        }
        
        public void onAnimationPause(Animator param1Animator) {
          a(this.e.a());
        }
        
        public void onAnimationResume(Animator param1Animator) {
          ChangeTransform.a(this.c);
        }
      };
    objectAnimator.addListener((Animator.AnimatorListener)animatorListenerAdapter);
    AnimatorUtils.a((Animator)objectAnimator, animatorListenerAdapter);
    return objectAnimator;
  }
  
  static void a(View paramView) {
    a(paramView, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
  }
  
  static void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, float paramFloat8) {
    paramView.setTranslationX(paramFloat1);
    paramView.setTranslationY(paramFloat2);
    ViewCompat.setTranslationZ(paramView, paramFloat3);
    paramView.setScaleX(paramFloat4);
    paramView.setScaleY(paramFloat5);
    paramView.setRotationX(paramFloat6);
    paramView.setRotationY(paramFloat7);
    paramView.setRotation(paramFloat8);
  }
  
  private void a(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    TransitionSet transitionSet;
    View view = paramTransitionValues2.view;
    Matrix matrix = new Matrix((Matrix)paramTransitionValues2.values.get("android:changeTransform:parentMatrix"));
    ViewUtils.b((View)paramViewGroup, matrix);
    GhostView ghostView = GhostViewUtils.a(view, paramViewGroup, matrix);
    if (ghostView == null)
      return; 
    ghostView.reserveEndViewTransition((ViewGroup)paramTransitionValues1.values.get("android:changeTransform:parent"), paramTransitionValues1.view);
    ChangeTransform changeTransform = this;
    while (changeTransform.e != null)
      transitionSet = changeTransform.e; 
    transitionSet.addListener(new GhostListener(view, ghostView));
    if (l) {
      if (paramTransitionValues1.view != paramTransitionValues2.view)
        ViewUtils.a(paramTransitionValues1.view, 0.0F); 
      ViewUtils.a(view, 1.0F);
    } 
  }
  
  private void a(TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    Matrix matrix2 = (Matrix)paramTransitionValues2.values.get("android:changeTransform:parentMatrix");
    paramTransitionValues2.view.setTag(R.id.parent_matrix, matrix2);
    Matrix matrix3 = this.n;
    matrix3.reset();
    matrix2.invert(matrix3);
    matrix2 = (Matrix)paramTransitionValues1.values.get("android:changeTransform:matrix");
    Matrix matrix1 = matrix2;
    if (matrix2 == null) {
      matrix1 = new Matrix();
      paramTransitionValues1.values.put("android:changeTransform:matrix", matrix1);
    } 
    matrix1.postConcat((Matrix)paramTransitionValues1.values.get("android:changeTransform:parentMatrix"));
    matrix1.postConcat(matrix3);
  }
  
  private boolean a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2) {
    if (!b((View)paramViewGroup1) || !b((View)paramViewGroup2))
      return (paramViewGroup1 == paramViewGroup2); 
    TransitionValues transitionValues = a((View)paramViewGroup1, true);
    return (transitionValues != null && paramViewGroup2 == transitionValues.view);
  }
  
  private void b(TransitionValues paramTransitionValues) {
    View view = paramTransitionValues.view;
    if (view.getVisibility() == 8)
      return; 
    paramTransitionValues.values.put("android:changeTransform:parent", view.getParent());
    Transforms transforms = new Transforms(view);
    paramTransitionValues.values.put("android:changeTransform:transforms", transforms);
    Matrix matrix = view.getMatrix();
    if (matrix == null || matrix.isIdentity()) {
      matrix = null;
    } else {
      matrix = new Matrix(matrix);
    } 
    paramTransitionValues.values.put("android:changeTransform:matrix", matrix);
    if (this.m) {
      matrix = new Matrix();
      ViewGroup viewGroup = (ViewGroup)view.getParent();
      ViewUtils.a((View)viewGroup, matrix);
      matrix.preTranslate(-viewGroup.getScrollX(), -viewGroup.getScrollY());
      paramTransitionValues.values.put("android:changeTransform:parentMatrix", matrix);
      paramTransitionValues.values.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
      paramTransitionValues.values.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
    } 
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    b(paramTransitionValues);
    if (!l)
      ((ViewGroup)paramTransitionValues.view.getParent()).startViewTransition(paramTransitionValues.view); 
  }
  
  public Animator createAnimator(ViewGroup paramViewGroup, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2) {
    boolean bool;
    if (paramTransitionValues1 == null || paramTransitionValues2 == null || !paramTransitionValues1.values.containsKey("android:changeTransform:parent") || !paramTransitionValues2.values.containsKey("android:changeTransform:parent"))
      return null; 
    ViewGroup viewGroup1 = (ViewGroup)paramTransitionValues1.values.get("android:changeTransform:parent");
    ViewGroup viewGroup2 = (ViewGroup)paramTransitionValues2.values.get("android:changeTransform:parent");
    if (this.m && !a(viewGroup1, viewGroup2)) {
      bool = true;
    } else {
      bool = false;
    } 
    Matrix matrix = (Matrix)paramTransitionValues1.values.get("android:changeTransform:intermediateMatrix");
    if (matrix != null)
      paramTransitionValues1.values.put("android:changeTransform:matrix", matrix); 
    matrix = (Matrix)paramTransitionValues1.values.get("android:changeTransform:intermediateParentMatrix");
    if (matrix != null)
      paramTransitionValues1.values.put("android:changeTransform:parentMatrix", matrix); 
    if (bool)
      a(paramTransitionValues1, paramTransitionValues2); 
    ObjectAnimator objectAnimator = a(paramTransitionValues1, paramTransitionValues2, bool);
    if (bool && objectAnimator != null && this.a) {
      a(paramViewGroup, paramTransitionValues1, paramTransitionValues2);
      return (Animator)objectAnimator;
    } 
    if (!l)
      viewGroup1.endViewTransition(paramTransitionValues1.view); 
    return (Animator)objectAnimator;
  }
  
  public boolean getReparent() {
    return this.m;
  }
  
  public boolean getReparentWithOverlay() {
    return this.a;
  }
  
  public String[] getTransitionProperties() {
    return i;
  }
  
  public void setReparent(boolean paramBoolean) {
    this.m = paramBoolean;
  }
  
  public void setReparentWithOverlay(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  static {
    boolean bool;
  }
  
  private static final String[] i = new String[] { "android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix" };
  
  private static final Property<PathAnimatorMatrix, float[]> j = new Property<PathAnimatorMatrix, float[]>(float[].class, "nonTranslations") {
      public float[] get(ChangeTransform.PathAnimatorMatrix param1PathAnimatorMatrix) {
        return null;
      }
      
      public void set(ChangeTransform.PathAnimatorMatrix param1PathAnimatorMatrix, float[] param1ArrayOffloat) {
        param1PathAnimatorMatrix.a(param1ArrayOffloat);
      }
    };
  
  private static final Property<PathAnimatorMatrix, PointF> k = new Property<PathAnimatorMatrix, PointF>(PointF.class, "translations") {
      public PointF get(ChangeTransform.PathAnimatorMatrix param1PathAnimatorMatrix) {
        return null;
      }
      
      public void set(ChangeTransform.PathAnimatorMatrix param1PathAnimatorMatrix, PointF param1PointF) {
        param1PathAnimatorMatrix.a(param1PointF);
      }
    };
  
  private static final boolean l;
  
  boolean a = true;
  
  private boolean m = true;
  
  private Matrix n = new Matrix();
  
  static class GhostListener extends TransitionListenerAdapter {
    private View a;
    
    private GhostView b;
    
    GhostListener(View param1View, GhostView param1GhostView) {
      this.a = param1View;
      this.b = param1GhostView;
    }
    
    public void onTransitionEnd(Transition param1Transition) {
      param1Transition.removeListener(this);
      GhostViewUtils.a(this.a);
      this.a.setTag(R.id.transition_transform, null);
      this.a.setTag(R.id.parent_matrix, null);
    }
    
    public void onTransitionPause(Transition param1Transition) {
      this.b.setVisibility(4);
    }
    
    public void onTransitionResume(Transition param1Transition) {
      this.b.setVisibility(0);
    }
  }
  
  static class PathAnimatorMatrix {
    private final Matrix a = new Matrix();
    
    private final View b;
    
    private final float[] c;
    
    private float d;
    
    private float e;
    
    PathAnimatorMatrix(View param1View, float[] param1ArrayOffloat) {
      this.b = param1View;
      this.c = (float[])param1ArrayOffloat.clone();
      float[] arrayOfFloat = this.c;
      this.d = arrayOfFloat[2];
      this.e = arrayOfFloat[5];
      b();
    }
    
    private void b() {
      float[] arrayOfFloat = this.c;
      arrayOfFloat[2] = this.d;
      arrayOfFloat[5] = this.e;
      this.a.setValues(arrayOfFloat);
      ViewUtils.c(this.b, this.a);
    }
    
    Matrix a() {
      return this.a;
    }
    
    void a(PointF param1PointF) {
      this.d = param1PointF.x;
      this.e = param1PointF.y;
      b();
    }
    
    void a(float[] param1ArrayOffloat) {
      System.arraycopy(param1ArrayOffloat, 0, this.c, 0, param1ArrayOffloat.length);
      b();
    }
  }
  
  static class Transforms {
    final float a;
    
    final float b;
    
    final float c;
    
    final float d;
    
    final float e;
    
    final float f;
    
    final float g;
    
    final float h;
    
    Transforms(View param1View) {
      this.a = param1View.getTranslationX();
      this.b = param1View.getTranslationY();
      this.c = ViewCompat.getTranslationZ(param1View);
      this.d = param1View.getScaleX();
      this.e = param1View.getScaleY();
      this.f = param1View.getRotationX();
      this.g = param1View.getRotationY();
      this.h = param1View.getRotation();
    }
    
    public boolean equals(Object param1Object) {
      boolean bool = param1Object instanceof Transforms;
      boolean bool1 = false;
      if (!bool)
        return false; 
      param1Object = param1Object;
      bool = bool1;
      if (((Transforms)param1Object).a == this.a) {
        bool = bool1;
        if (((Transforms)param1Object).b == this.b) {
          bool = bool1;
          if (((Transforms)param1Object).c == this.c) {
            bool = bool1;
            if (((Transforms)param1Object).d == this.d) {
              bool = bool1;
              if (((Transforms)param1Object).e == this.e) {
                bool = bool1;
                if (((Transforms)param1Object).f == this.f) {
                  bool = bool1;
                  if (((Transforms)param1Object).g == this.g) {
                    bool = bool1;
                    if (((Transforms)param1Object).h == this.h)
                      bool = true; 
                  } 
                } 
              } 
            } 
          } 
        } 
      } 
      return bool;
    }
    
    public int hashCode() {
      byte b1;
      byte b2;
      byte b3;
      byte b4;
      byte b5;
      byte b6;
      byte b7;
      float f = this.a;
      int i = 0;
      if (f != 0.0F) {
        b1 = Float.floatToIntBits(f);
      } else {
        b1 = 0;
      } 
      f = this.b;
      if (f != 0.0F) {
        b2 = Float.floatToIntBits(f);
      } else {
        b2 = 0;
      } 
      f = this.c;
      if (f != 0.0F) {
        b3 = Float.floatToIntBits(f);
      } else {
        b3 = 0;
      } 
      f = this.d;
      if (f != 0.0F) {
        b4 = Float.floatToIntBits(f);
      } else {
        b4 = 0;
      } 
      f = this.e;
      if (f != 0.0F) {
        b5 = Float.floatToIntBits(f);
      } else {
        b5 = 0;
      } 
      f = this.f;
      if (f != 0.0F) {
        b6 = Float.floatToIntBits(f);
      } else {
        b6 = 0;
      } 
      f = this.g;
      if (f != 0.0F) {
        b7 = Float.floatToIntBits(f);
      } else {
        b7 = 0;
      } 
      f = this.h;
      if (f != 0.0F)
        i = Float.floatToIntBits(f); 
      return ((((((b1 * 31 + b2) * 31 + b3) * 31 + b4) * 31 + b5) * 31 + b6) * 31 + b7) * 31 + i;
    }
    
    public void restore(View param1View) {
      ChangeTransform.a(param1View, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\ChangeTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */