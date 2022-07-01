package androidx.transition;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class TransitionSet extends Transition {
  public static final int ORDERING_SEQUENTIAL = 1;
  
  public static final int ORDERING_TOGETHER = 0;
  
  int a;
  
  boolean i = false;
  
  private ArrayList<Transition> j = new ArrayList<Transition>();
  
  private boolean k = true;
  
  private int l = 0;
  
  public TransitionSet() {}
  
  public TransitionSet(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    TypedArray typedArray = paramContext.obtainStyledAttributes(paramAttributeSet, Styleable.i);
    setOrdering(TypedArrayUtils.getNamedInt(typedArray, (XmlPullParser)paramAttributeSet, "transitionOrdering", 0, 0));
    typedArray.recycle();
  }
  
  private void a(Transition paramTransition) {
    this.j.add(paramTransition);
    paramTransition.e = this;
  }
  
  private void e() {
    TransitionSetListener transitionSetListener = new TransitionSetListener(this);
    Iterator<Transition> iterator = this.j.iterator();
    while (iterator.hasNext())
      ((Transition)iterator.next()).addListener(transitionSetListener); 
    this.a = this.j.size();
  }
  
  String a(String paramString) {
    String str = super.a(paramString);
    for (int i = 0; i < this.j.size(); i++) {
      StringBuilder stringBuilder1 = new StringBuilder();
      stringBuilder1.append(str);
      stringBuilder1.append("\n");
      Transition transition = this.j.get(i);
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append(paramString);
      stringBuilder2.append("  ");
      stringBuilder1.append(transition.a(stringBuilder2.toString()));
      str = stringBuilder1.toString();
    } 
    return str;
  }
  
  protected void a() {
    if (this.j.isEmpty()) {
      b();
      c();
      return;
    } 
    e();
    if (!this.k) {
      for (int i = 1; i < this.j.size(); i++) {
        ((Transition)this.j.get(i - 1)).addListener(new TransitionListenerAdapter(this, this.j.get(i)) {
              public void onTransitionEnd(Transition param1Transition) {
                this.a.a();
                param1Transition.removeListener(this);
              }
            });
      } 
      Transition transition = this.j.get(0);
      if (transition != null) {
        transition.a();
        return;
      } 
    } else {
      Iterator<Transition> iterator = this.j.iterator();
      while (iterator.hasNext())
        ((Transition)iterator.next()).a(); 
    } 
  }
  
  protected void a(ViewGroup paramViewGroup, TransitionValuesMaps paramTransitionValuesMaps1, TransitionValuesMaps paramTransitionValuesMaps2, ArrayList<TransitionValues> paramArrayList1, ArrayList<TransitionValues> paramArrayList2) {
    long l = getStartDelay();
    int j = this.j.size();
    int i;
    for (i = 0; i < j; i++) {
      Transition transition = this.j.get(i);
      if (l > 0L && (this.k || i == 0)) {
        long l1 = transition.getStartDelay();
        if (l1 > 0L) {
          transition.setStartDelay(l1 + l);
        } else {
          transition.setStartDelay(l);
        } 
      } 
      transition.a(paramViewGroup, paramTransitionValuesMaps1, paramTransitionValuesMaps2, paramArrayList1, paramArrayList2);
    } 
  }
  
  void a(TransitionValues paramTransitionValues) {
    super.a(paramTransitionValues);
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).a(paramTransitionValues); 
  }
  
  public TransitionSet addListener(Transition.TransitionListener paramTransitionListener) {
    return (TransitionSet)super.addListener(paramTransitionListener);
  }
  
  public TransitionSet addTarget(int paramInt) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).addTarget(paramInt); 
    return (TransitionSet)super.addTarget(paramInt);
  }
  
  public TransitionSet addTarget(View paramView) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).addTarget(paramView); 
    return (TransitionSet)super.addTarget(paramView);
  }
  
  public TransitionSet addTarget(Class<?> paramClass) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).addTarget(paramClass); 
    return (TransitionSet)super.addTarget(paramClass);
  }
  
  public TransitionSet addTarget(String paramString) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).addTarget(paramString); 
    return (TransitionSet)super.addTarget(paramString);
  }
  
  public TransitionSet addTransition(Transition paramTransition) {
    a(paramTransition);
    if (this.b >= 0L)
      paramTransition.setDuration(this.b); 
    if ((this.l & 0x1) != 0)
      paramTransition.setInterpolator(getInterpolator()); 
    if ((this.l & 0x2) != 0)
      paramTransition.setPropagation(getPropagation()); 
    if ((this.l & 0x4) != 0)
      paramTransition.setPathMotion(getPathMotion()); 
    if ((this.l & 0x8) != 0)
      paramTransition.setEpicenterCallback(getEpicenterCallback()); 
    return this;
  }
  
  void b(ViewGroup paramViewGroup) {
    super.b(paramViewGroup);
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).b(paramViewGroup); 
  }
  
  void b(boolean paramBoolean) {
    super.b(paramBoolean);
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).b(paramBoolean); 
  }
  
  public void captureEndValues(TransitionValues paramTransitionValues) {
    if (b(paramTransitionValues.view))
      for (Transition transition : this.j) {
        if (transition.b(paramTransitionValues.view)) {
          transition.captureEndValues(paramTransitionValues);
          paramTransitionValues.a.add(transition);
        } 
      }  
  }
  
  public void captureStartValues(TransitionValues paramTransitionValues) {
    if (b(paramTransitionValues.view))
      for (Transition transition : this.j) {
        if (transition.b(paramTransitionValues.view)) {
          transition.captureStartValues(paramTransitionValues);
          paramTransitionValues.a.add(transition);
        } 
      }  
  }
  
  public Transition clone() {
    TransitionSet transitionSet = (TransitionSet)super.clone();
    transitionSet.j = new ArrayList<Transition>();
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      transitionSet.a(((Transition)this.j.get(i)).clone()); 
    return transitionSet;
  }
  
  TransitionSet d(ViewGroup paramViewGroup) {
    super.c(paramViewGroup);
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).c(paramViewGroup); 
    return this;
  }
  
  protected void d() {
    super.d();
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).d(); 
  }
  
  public Transition excludeTarget(int paramInt, boolean paramBoolean) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).excludeTarget(paramInt, paramBoolean); 
    return super.excludeTarget(paramInt, paramBoolean);
  }
  
  public Transition excludeTarget(View paramView, boolean paramBoolean) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).excludeTarget(paramView, paramBoolean); 
    return super.excludeTarget(paramView, paramBoolean);
  }
  
  public Transition excludeTarget(Class<?> paramClass, boolean paramBoolean) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).excludeTarget(paramClass, paramBoolean); 
    return super.excludeTarget(paramClass, paramBoolean);
  }
  
  public Transition excludeTarget(String paramString, boolean paramBoolean) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).excludeTarget(paramString, paramBoolean); 
    return super.excludeTarget(paramString, paramBoolean);
  }
  
  public int getOrdering() {
    return this.k ^ true;
  }
  
  public Transition getTransitionAt(int paramInt) {
    return (paramInt < 0 || paramInt >= this.j.size()) ? null : this.j.get(paramInt);
  }
  
  public int getTransitionCount() {
    return this.j.size();
  }
  
  public void pause(View paramView) {
    super.pause(paramView);
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).pause(paramView); 
  }
  
  public TransitionSet removeListener(Transition.TransitionListener paramTransitionListener) {
    return (TransitionSet)super.removeListener(paramTransitionListener);
  }
  
  public TransitionSet removeTarget(int paramInt) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).removeTarget(paramInt); 
    return (TransitionSet)super.removeTarget(paramInt);
  }
  
  public TransitionSet removeTarget(View paramView) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).removeTarget(paramView); 
    return (TransitionSet)super.removeTarget(paramView);
  }
  
  public TransitionSet removeTarget(Class<?> paramClass) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).removeTarget(paramClass); 
    return (TransitionSet)super.removeTarget(paramClass);
  }
  
  public TransitionSet removeTarget(String paramString) {
    for (int i = 0; i < this.j.size(); i++)
      ((Transition)this.j.get(i)).removeTarget(paramString); 
    return (TransitionSet)super.removeTarget(paramString);
  }
  
  public TransitionSet removeTransition(Transition paramTransition) {
    this.j.remove(paramTransition);
    paramTransition.e = null;
    return this;
  }
  
  public void resume(View paramView) {
    super.resume(paramView);
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).resume(paramView); 
  }
  
  public TransitionSet setDuration(long paramLong) {
    super.setDuration(paramLong);
    if (this.b >= 0L) {
      ArrayList<Transition> arrayList = this.j;
      if (arrayList != null) {
        int j = arrayList.size();
        for (int i = 0; i < j; i++)
          ((Transition)this.j.get(i)).setDuration(paramLong); 
      } 
    } 
    return this;
  }
  
  public void setEpicenterCallback(Transition.EpicenterCallback paramEpicenterCallback) {
    super.setEpicenterCallback(paramEpicenterCallback);
    this.l |= 0x8;
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).setEpicenterCallback(paramEpicenterCallback); 
  }
  
  public TransitionSet setInterpolator(TimeInterpolator paramTimeInterpolator) {
    this.l |= 0x1;
    ArrayList<Transition> arrayList = this.j;
    if (arrayList != null) {
      int j = arrayList.size();
      for (int i = 0; i < j; i++)
        ((Transition)this.j.get(i)).setInterpolator(paramTimeInterpolator); 
    } 
    return (TransitionSet)super.setInterpolator(paramTimeInterpolator);
  }
  
  public TransitionSet setOrdering(int paramInt) {
    if (paramInt != 0) {
      if (paramInt == 1) {
        this.k = false;
        return this;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Invalid parameter for TransitionSet ordering: ");
      stringBuilder.append(paramInt);
      throw new AndroidRuntimeException(stringBuilder.toString());
    } 
    this.k = true;
    return this;
  }
  
  public void setPathMotion(PathMotion paramPathMotion) {
    super.setPathMotion(paramPathMotion);
    this.l |= 0x4;
    if (this.j != null)
      for (int i = 0; i < this.j.size(); i++)
        ((Transition)this.j.get(i)).setPathMotion(paramPathMotion);  
  }
  
  public void setPropagation(TransitionPropagation paramTransitionPropagation) {
    super.setPropagation(paramTransitionPropagation);
    this.l |= 0x2;
    int j = this.j.size();
    for (int i = 0; i < j; i++)
      ((Transition)this.j.get(i)).setPropagation(paramTransitionPropagation); 
  }
  
  public TransitionSet setStartDelay(long paramLong) {
    return (TransitionSet)super.setStartDelay(paramLong);
  }
  
  static class TransitionSetListener extends TransitionListenerAdapter {
    TransitionSet a;
    
    TransitionSetListener(TransitionSet param1TransitionSet) {
      this.a = param1TransitionSet;
    }
    
    public void onTransitionEnd(Transition param1Transition) {
      TransitionSet transitionSet = this.a;
      transitionSet.a--;
      if (this.a.a == 0) {
        transitionSet = this.a;
        transitionSet.i = false;
        transitionSet.c();
      } 
      param1Transition.removeListener(this);
    }
    
    public void onTransitionStart(Transition param1Transition) {
      if (!this.a.i) {
        this.a.b();
        this.a.i = true;
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\TransitionSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */