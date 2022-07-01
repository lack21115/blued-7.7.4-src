package com.google.android.material.transition.platform;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.transition.Transition;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.BlendModeColorFilterCompat;
import androidx.core.graphics.BlendModeCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;

public class MaterialContainerTransformSharedElementCallback extends SharedElementCallback {
  private static WeakReference<View> a;
  
  private boolean b = true;
  
  private boolean c = true;
  
  private boolean d = false;
  
  private Rect e;
  
  private ShapeProvider f = new ShapeableViewShapeProvider();
  
  private void a(Activity paramActivity, Window paramWindow) {
    Transition transition = paramWindow.getSharedElementReturnTransition();
    if (transition instanceof MaterialContainerTransform) {
      transition = transition;
      transition.a(true);
      transition.addListener(new TransitionListenerAdapter(this, paramActivity) {
            public void onTransitionEnd(Transition param1Transition) {
              if (MaterialContainerTransformSharedElementCallback.a() != null) {
                View view = MaterialContainerTransformSharedElementCallback.a().get();
                if (view != null) {
                  view.setAlpha(1.0F);
                  MaterialContainerTransformSharedElementCallback.a((WeakReference)null);
                } 
              } 
              this.a.finish();
              this.a.overridePendingTransition(0, 0);
            }
          });
      if (this.c) {
        a(paramWindow, (MaterialContainerTransform)transition);
        transition.addListener(new TransitionListenerAdapter(this, paramWindow) {
              public void onTransitionStart(Transition param1Transition) {
                MaterialContainerTransformSharedElementCallback.a(this.a);
              }
            });
      } 
    } 
  }
  
  private static void a(Window paramWindow, MaterialContainerTransform paramMaterialContainerTransform) {
    paramWindow.setTransitionBackgroundFadeDuration(paramMaterialContainerTransform.getDuration());
  }
  
  private void c(Window paramWindow) {
    Transition transition = paramWindow.getSharedElementEnterTransition();
    if (transition instanceof MaterialContainerTransform) {
      transition = transition;
      if (!this.d)
        paramWindow.setSharedElementReenterTransition(null); 
      if (this.c) {
        a(paramWindow, (MaterialContainerTransform)transition);
        transition.addListener(new TransitionListenerAdapter(this, paramWindow) {
              public void onTransitionEnd(Transition param1Transition) {
                MaterialContainerTransformSharedElementCallback.b(this.a);
              }
              
              public void onTransitionStart(Transition param1Transition) {
                MaterialContainerTransformSharedElementCallback.a(this.a);
              }
            });
      } 
    } 
  }
  
  private static void d(Window paramWindow) {
    paramWindow.getDecorView().getBackground().mutate().setColorFilter(BlendModeColorFilterCompat.createBlendModeColorFilterCompat(0, BlendModeCompat.CLEAR));
  }
  
  private static void e(Window paramWindow) {
    paramWindow.getDecorView().getBackground().mutate().clearColorFilter();
  }
  
  public Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF) {
    a = new WeakReference<View>(paramView);
    return super.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
  }
  
  public View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable) {
    View view = super.onCreateSnapshotView(paramContext, paramParcelable);
    if (view != null) {
      WeakReference<View> weakReference = a;
      if (weakReference != null && this.f != null) {
        View view1 = weakReference.get();
        if (view1 != null) {
          ShapeAppearanceModel shapeAppearanceModel = this.f.a(view1);
          if (shapeAppearanceModel != null)
            view.setTag(R.id.mtrl_motion_snapshot_view, shapeAppearanceModel); 
        } 
      } 
    } 
    return view;
  }
  
  public void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {
    if (!paramList.isEmpty() && !paramMap.isEmpty()) {
      View view = paramMap.get(paramList.get(0));
      if (view != null) {
        Activity activity = ContextUtils.a(view.getContext());
        if (activity != null) {
          Window window = activity.getWindow();
          if (this.b) {
            c(window);
            return;
          } 
          a(activity, window);
        } 
      } 
    } 
  }
  
  public void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {
    if (!paramList1.isEmpty() && ((View)paramList1.get(0)).getTag(R.id.mtrl_motion_snapshot_view) instanceof View)
      ((View)paramList1.get(0)).setTag(R.id.mtrl_motion_snapshot_view, null); 
    if (!this.b && !paramList1.isEmpty())
      this.e = TransitionUtils.b(paramList1.get(0)); 
    this.b = false;
  }
  
  public void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2) {
    if (!paramList1.isEmpty() && !paramList2.isEmpty())
      ((View)paramList1.get(0)).setTag(R.id.mtrl_motion_snapshot_view, paramList2.get(0)); 
    if (!this.b && !paramList1.isEmpty() && this.e != null) {
      View view = paramList1.get(0);
      view.measure(View.MeasureSpec.makeMeasureSpec(this.e.width(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.e.height(), 1073741824));
      view.layout(this.e.left, this.e.top, this.e.right, this.e.bottom);
    } 
  }
  
  public static interface ShapeProvider {
    ShapeAppearanceModel a(View param1View);
  }
  
  public static class ShapeableViewShapeProvider implements ShapeProvider {
    public ShapeAppearanceModel a(View param1View) {
      return (param1View instanceof Shapeable) ? ((Shapeable)param1View).getShapeAppearanceModel() : null;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\google\android\material\transition\platform\MaterialContainerTransformSharedElementCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */