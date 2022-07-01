package androidx.appcompat.view;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;
import java.util.Iterator;

public class ViewPropertyAnimatorCompatSet {
  final ArrayList<ViewPropertyAnimatorCompat> a = new ArrayList<ViewPropertyAnimatorCompat>();
  
  ViewPropertyAnimatorListener b;
  
  private long c = -1L;
  
  private Interpolator d;
  
  private boolean e;
  
  private final ViewPropertyAnimatorListenerAdapter f = new ViewPropertyAnimatorListenerAdapter(this) {
      private boolean b = false;
      
      private int c = 0;
      
      void a() {
        this.c = 0;
        this.b = false;
        this.a.a();
      }
      
      public void onAnimationEnd(View param1View) {
        int i = this.c + 1;
        this.c = i;
        if (i == this.a.a.size()) {
          if (this.a.b != null)
            this.a.b.onAnimationEnd(null); 
          a();
        } 
      }
      
      public void onAnimationStart(View param1View) {
        if (this.b)
          return; 
        this.b = true;
        if (this.a.b != null)
          this.a.b.onAnimationStart(null); 
      }
    };
  
  void a() {
    this.e = false;
  }
  
  public void cancel() {
    if (!this.e)
      return; 
    Iterator<ViewPropertyAnimatorCompat> iterator = this.a.iterator();
    while (iterator.hasNext())
      ((ViewPropertyAnimatorCompat)iterator.next()).cancel(); 
    this.e = false;
  }
  
  public ViewPropertyAnimatorCompatSet play(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat) {
    if (!this.e)
      this.a.add(paramViewPropertyAnimatorCompat); 
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet playSequentially(ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat1, ViewPropertyAnimatorCompat paramViewPropertyAnimatorCompat2) {
    this.a.add(paramViewPropertyAnimatorCompat1);
    paramViewPropertyAnimatorCompat2.setStartDelay(paramViewPropertyAnimatorCompat1.getDuration());
    this.a.add(paramViewPropertyAnimatorCompat2);
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setDuration(long paramLong) {
    if (!this.e)
      this.c = paramLong; 
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setInterpolator(Interpolator paramInterpolator) {
    if (!this.e)
      this.d = paramInterpolator; 
    return this;
  }
  
  public ViewPropertyAnimatorCompatSet setListener(ViewPropertyAnimatorListener paramViewPropertyAnimatorListener) {
    if (!this.e)
      this.b = paramViewPropertyAnimatorListener; 
    return this;
  }
  
  public void start() {
    if (this.e)
      return; 
    for (ViewPropertyAnimatorCompat viewPropertyAnimatorCompat : this.a) {
      long l = this.c;
      if (l >= 0L)
        viewPropertyAnimatorCompat.setDuration(l); 
      Interpolator interpolator = this.d;
      if (interpolator != null)
        viewPropertyAnimatorCompat.setInterpolator(interpolator); 
      if (this.b != null)
        viewPropertyAnimatorCompat.setListener((ViewPropertyAnimatorListener)this.f); 
      viewPropertyAnimatorCompat.start();
    } 
    this.e = true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\view\ViewPropertyAnimatorCompatSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */