package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DefaultItemAnimator extends SimpleItemAnimator {
  private static TimeInterpolator i;
  
  ArrayList<ArrayList<RecyclerView.ViewHolder>> a = new ArrayList<ArrayList<RecyclerView.ViewHolder>>();
  
  ArrayList<ArrayList<MoveInfo>> b = new ArrayList<ArrayList<MoveInfo>>();
  
  ArrayList<ArrayList<ChangeInfo>> c = new ArrayList<ArrayList<ChangeInfo>>();
  
  ArrayList<RecyclerView.ViewHolder> d = new ArrayList<RecyclerView.ViewHolder>();
  
  ArrayList<RecyclerView.ViewHolder> e = new ArrayList<RecyclerView.ViewHolder>();
  
  ArrayList<RecyclerView.ViewHolder> f = new ArrayList<RecyclerView.ViewHolder>();
  
  ArrayList<RecyclerView.ViewHolder> g = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<RecyclerView.ViewHolder> j = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<RecyclerView.ViewHolder> k = new ArrayList<RecyclerView.ViewHolder>();
  
  private ArrayList<MoveInfo> l = new ArrayList<MoveInfo>();
  
  private ArrayList<ChangeInfo> m = new ArrayList<ChangeInfo>();
  
  private void a(List<ChangeInfo> paramList, RecyclerView.ViewHolder paramViewHolder) {
    for (int i = paramList.size() - 1; i >= 0; i--) {
      ChangeInfo changeInfo = paramList.get(i);
      if (a(changeInfo, paramViewHolder) && changeInfo.oldHolder == null && changeInfo.newHolder == null)
        paramList.remove(changeInfo); 
    } 
  }
  
  private boolean a(ChangeInfo paramChangeInfo, RecyclerView.ViewHolder paramViewHolder) {
    RecyclerView.ViewHolder viewHolder = paramChangeInfo.newHolder;
    boolean bool = false;
    if (viewHolder == paramViewHolder) {
      paramChangeInfo.newHolder = null;
    } else {
      if (paramChangeInfo.oldHolder == paramViewHolder) {
        paramChangeInfo.oldHolder = null;
        bool = true;
        paramViewHolder.itemView.setAlpha(1.0F);
        paramViewHolder.itemView.setTranslationX(0.0F);
        paramViewHolder.itemView.setTranslationY(0.0F);
        dispatchChangeFinished(paramViewHolder, bool);
        return true;
      } 
      return false;
    } 
    paramViewHolder.itemView.setAlpha(1.0F);
    paramViewHolder.itemView.setTranslationX(0.0F);
    paramViewHolder.itemView.setTranslationY(0.0F);
    dispatchChangeFinished(paramViewHolder, bool);
    return true;
  }
  
  private void b(ChangeInfo paramChangeInfo) {
    if (paramChangeInfo.oldHolder != null)
      a(paramChangeInfo, paramChangeInfo.oldHolder); 
    if (paramChangeInfo.newHolder != null)
      a(paramChangeInfo, paramChangeInfo.newHolder); 
  }
  
  private void c(RecyclerView.ViewHolder paramViewHolder) {
    View view = paramViewHolder.itemView;
    ViewPropertyAnimator viewPropertyAnimator = view.animate();
    this.f.add(paramViewHolder);
    viewPropertyAnimator.setDuration(getRemoveDuration()).alpha(0.0F).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramViewHolder, viewPropertyAnimator, view) {
          public void onAnimationEnd(Animator param1Animator) {
            this.b.setListener(null);
            this.c.setAlpha(1.0F);
            this.d.dispatchRemoveFinished(this.a);
            this.d.f.remove(this.a);
            this.d.a();
          }
          
          public void onAnimationStart(Animator param1Animator) {
            this.d.dispatchRemoveStarting(this.a);
          }
        }).start();
  }
  
  private void d(RecyclerView.ViewHolder paramViewHolder) {
    if (i == null)
      i = (new ValueAnimator()).getInterpolator(); 
    paramViewHolder.itemView.animate().setInterpolator(i);
    endAnimation(paramViewHolder);
  }
  
  void a() {
    if (!isRunning())
      dispatchAnimationsFinished(); 
  }
  
  void a(ChangeInfo paramChangeInfo) {
    View view1;
    RecyclerView.ViewHolder viewHolder1 = paramChangeInfo.oldHolder;
    View view2 = null;
    if (viewHolder1 == null) {
      viewHolder1 = null;
    } else {
      view1 = viewHolder1.itemView;
    } 
    RecyclerView.ViewHolder viewHolder2 = paramChangeInfo.newHolder;
    if (viewHolder2 != null)
      view2 = viewHolder2.itemView; 
    if (view1 != null) {
      ViewPropertyAnimator viewPropertyAnimator = view1.animate().setDuration(getChangeDuration());
      this.g.add(paramChangeInfo.oldHolder);
      viewPropertyAnimator.translationX((paramChangeInfo.toX - paramChangeInfo.fromX));
      viewPropertyAnimator.translationY((paramChangeInfo.toY - paramChangeInfo.fromY));
      viewPropertyAnimator.alpha(0.0F).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramChangeInfo, viewPropertyAnimator, view1) {
            public void onAnimationEnd(Animator param1Animator) {
              this.b.setListener(null);
              this.c.setAlpha(1.0F);
              this.c.setTranslationX(0.0F);
              this.c.setTranslationY(0.0F);
              this.d.dispatchChangeFinished(this.a.oldHolder, true);
              this.d.g.remove(this.a.oldHolder);
              this.d.a();
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.d.dispatchChangeStarting(this.a.oldHolder, true);
            }
          }).start();
    } 
    if (view2 != null) {
      ViewPropertyAnimator viewPropertyAnimator = view2.animate();
      this.g.add(paramChangeInfo.newHolder);
      viewPropertyAnimator.translationX(0.0F).translationY(0.0F).setDuration(getChangeDuration()).alpha(1.0F).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramChangeInfo, viewPropertyAnimator, view2) {
            public void onAnimationEnd(Animator param1Animator) {
              this.b.setListener(null);
              this.c.setAlpha(1.0F);
              this.c.setTranslationX(0.0F);
              this.c.setTranslationY(0.0F);
              this.d.dispatchChangeFinished(this.a.newHolder, false);
              this.d.g.remove(this.a.newHolder);
              this.d.a();
            }
            
            public void onAnimationStart(Animator param1Animator) {
              this.d.dispatchChangeStarting(this.a.newHolder, false);
            }
          }).start();
    } 
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder) {
    View view = paramViewHolder.itemView;
    ViewPropertyAnimator viewPropertyAnimator = view.animate();
    this.d.add(paramViewHolder);
    viewPropertyAnimator.alpha(1.0F).setDuration(getAddDuration()).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramViewHolder, view, viewPropertyAnimator) {
          public void onAnimationCancel(Animator param1Animator) {
            this.b.setAlpha(1.0F);
          }
          
          public void onAnimationEnd(Animator param1Animator) {
            this.c.setListener(null);
            this.d.dispatchAddFinished(this.a);
            this.d.d.remove(this.a);
            this.d.a();
          }
          
          public void onAnimationStart(Animator param1Animator) {
            this.d.dispatchAddStarting(this.a);
          }
        }).start();
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    View view = paramViewHolder.itemView;
    paramInt1 = paramInt3 - paramInt1;
    paramInt2 = paramInt4 - paramInt2;
    if (paramInt1 != 0)
      view.animate().translationX(0.0F); 
    if (paramInt2 != 0)
      view.animate().translationY(0.0F); 
    ViewPropertyAnimator viewPropertyAnimator = view.animate();
    this.e.add(paramViewHolder);
    viewPropertyAnimator.setDuration(getMoveDuration()).setListener((Animator.AnimatorListener)new AnimatorListenerAdapter(this, paramViewHolder, paramInt1, view, paramInt2, viewPropertyAnimator) {
          public void onAnimationCancel(Animator param1Animator) {
            if (this.b != 0)
              this.c.setTranslationX(0.0F); 
            if (this.d != 0)
              this.c.setTranslationY(0.0F); 
          }
          
          public void onAnimationEnd(Animator param1Animator) {
            this.e.setListener(null);
            this.f.dispatchMoveFinished(this.a);
            this.f.e.remove(this.a);
            this.f.a();
          }
          
          public void onAnimationStart(Animator param1Animator) {
            this.f.dispatchMoveStarting(this.a);
          }
        }).start();
  }
  
  void a(List<RecyclerView.ViewHolder> paramList) {
    for (int i = paramList.size() - 1; i >= 0; i--)
      ((RecyclerView.ViewHolder)paramList.get(i)).itemView.animate().cancel(); 
  }
  
  public boolean animateAdd(RecyclerView.ViewHolder paramViewHolder) {
    d(paramViewHolder);
    paramViewHolder.itemView.setAlpha(0.0F);
    this.k.add(paramViewHolder);
    return true;
  }
  
  public boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    if (paramViewHolder1 == paramViewHolder2)
      return animateMove(paramViewHolder1, paramInt1, paramInt2, paramInt3, paramInt4); 
    float f1 = paramViewHolder1.itemView.getTranslationX();
    float f2 = paramViewHolder1.itemView.getTranslationY();
    float f3 = paramViewHolder1.itemView.getAlpha();
    d(paramViewHolder1);
    int i = (int)((paramInt3 - paramInt1) - f1);
    int j = (int)((paramInt4 - paramInt2) - f2);
    paramViewHolder1.itemView.setTranslationX(f1);
    paramViewHolder1.itemView.setTranslationY(f2);
    paramViewHolder1.itemView.setAlpha(f3);
    if (paramViewHolder2 != null) {
      d(paramViewHolder2);
      paramViewHolder2.itemView.setTranslationX(-i);
      paramViewHolder2.itemView.setTranslationY(-j);
      paramViewHolder2.itemView.setAlpha(0.0F);
    } 
    this.m.add(new ChangeInfo(paramViewHolder1, paramViewHolder2, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean animateMove(RecyclerView.ViewHolder paramViewHolder, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    View view = paramViewHolder.itemView;
    paramInt1 += (int)paramViewHolder.itemView.getTranslationX();
    paramInt2 += (int)paramViewHolder.itemView.getTranslationY();
    d(paramViewHolder);
    int i = paramInt3 - paramInt1;
    int j = paramInt4 - paramInt2;
    if (i == 0 && j == 0) {
      dispatchMoveFinished(paramViewHolder);
      return false;
    } 
    if (i != 0)
      view.setTranslationX(-i); 
    if (j != 0)
      view.setTranslationY(-j); 
    this.l.add(new MoveInfo(paramViewHolder, paramInt1, paramInt2, paramInt3, paramInt4));
    return true;
  }
  
  public boolean animateRemove(RecyclerView.ViewHolder paramViewHolder) {
    d(paramViewHolder);
    this.j.add(paramViewHolder);
    return true;
  }
  
  public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder, List<Object> paramList) {
    return (!paramList.isEmpty() || super.canReuseUpdatedViewHolder(paramViewHolder, paramList));
  }
  
  public void endAnimation(RecyclerView.ViewHolder paramViewHolder) {
    View view = paramViewHolder.itemView;
    view.animate().cancel();
    int i;
    for (i = this.l.size() - 1; i >= 0; i--) {
      if (((MoveInfo)this.l.get(i)).holder == paramViewHolder) {
        view.setTranslationY(0.0F);
        view.setTranslationX(0.0F);
        dispatchMoveFinished(paramViewHolder);
        this.l.remove(i);
      } 
    } 
    a(this.m, paramViewHolder);
    if (this.j.remove(paramViewHolder)) {
      view.setAlpha(1.0F);
      dispatchRemoveFinished(paramViewHolder);
    } 
    if (this.k.remove(paramViewHolder)) {
      view.setAlpha(1.0F);
      dispatchAddFinished(paramViewHolder);
    } 
    for (i = this.c.size() - 1; i >= 0; i--) {
      ArrayList<ChangeInfo> arrayList = this.c.get(i);
      a(arrayList, paramViewHolder);
      if (arrayList.isEmpty())
        this.c.remove(i); 
    } 
    for (i = this.b.size() - 1; i >= 0; i--) {
      ArrayList arrayList = this.b.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        if (((MoveInfo)arrayList.get(j)).holder == paramViewHolder) {
          view.setTranslationY(0.0F);
          view.setTranslationX(0.0F);
          dispatchMoveFinished(paramViewHolder);
          arrayList.remove(j);
          if (arrayList.isEmpty())
            this.b.remove(i); 
          break;
        } 
      } 
    } 
    for (i = this.a.size() - 1; i >= 0; i--) {
      ArrayList arrayList = this.a.get(i);
      if (arrayList.remove(paramViewHolder)) {
        view.setAlpha(1.0F);
        dispatchAddFinished(paramViewHolder);
        if (arrayList.isEmpty())
          this.a.remove(i); 
      } 
    } 
    this.f.remove(paramViewHolder);
    this.d.remove(paramViewHolder);
    this.g.remove(paramViewHolder);
    this.e.remove(paramViewHolder);
    a();
  }
  
  public void endAnimations() {
    int i;
    for (i = this.l.size() - 1; i >= 0; i--) {
      MoveInfo moveInfo = this.l.get(i);
      View view = moveInfo.holder.itemView;
      view.setTranslationY(0.0F);
      view.setTranslationX(0.0F);
      dispatchMoveFinished(moveInfo.holder);
      this.l.remove(i);
    } 
    for (i = this.j.size() - 1; i >= 0; i--) {
      dispatchRemoveFinished(this.j.get(i));
      this.j.remove(i);
    } 
    for (i = this.k.size() - 1; i >= 0; i--) {
      RecyclerView.ViewHolder viewHolder = this.k.get(i);
      viewHolder.itemView.setAlpha(1.0F);
      dispatchAddFinished(viewHolder);
      this.k.remove(i);
    } 
    for (i = this.m.size() - 1; i >= 0; i--)
      b(this.m.get(i)); 
    this.m.clear();
    if (!isRunning())
      return; 
    for (i = this.b.size() - 1; i >= 0; i--) {
      ArrayList<MoveInfo> arrayList = this.b.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        MoveInfo moveInfo = arrayList.get(j);
        View view = moveInfo.holder.itemView;
        view.setTranslationY(0.0F);
        view.setTranslationX(0.0F);
        dispatchMoveFinished(moveInfo.holder);
        arrayList.remove(j);
        if (arrayList.isEmpty())
          this.b.remove(arrayList); 
      } 
    } 
    for (i = this.a.size() - 1; i >= 0; i--) {
      ArrayList<RecyclerView.ViewHolder> arrayList = this.a.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        RecyclerView.ViewHolder viewHolder = arrayList.get(j);
        viewHolder.itemView.setAlpha(1.0F);
        dispatchAddFinished(viewHolder);
        arrayList.remove(j);
        if (arrayList.isEmpty())
          this.a.remove(arrayList); 
      } 
    } 
    for (i = this.c.size() - 1; i >= 0; i--) {
      ArrayList<ChangeInfo> arrayList = this.c.get(i);
      for (int j = arrayList.size() - 1; j >= 0; j--) {
        b(arrayList.get(j));
        if (arrayList.isEmpty())
          this.c.remove(arrayList); 
      } 
    } 
    a(this.f);
    a(this.e);
    a(this.d);
    a(this.g);
    dispatchAnimationsFinished();
  }
  
  public boolean isRunning() {
    return (!this.k.isEmpty() || !this.m.isEmpty() || !this.l.isEmpty() || !this.j.isEmpty() || !this.e.isEmpty() || !this.f.isEmpty() || !this.d.isEmpty() || !this.g.isEmpty() || !this.b.isEmpty() || !this.a.isEmpty() || !this.c.isEmpty());
  }
  
  public void runPendingAnimations() {
    int i = this.j.isEmpty() ^ true;
    int j = this.l.isEmpty() ^ true;
    int k = this.m.isEmpty() ^ true;
    int m = this.k.isEmpty() ^ true;
    if (i == 0 && j == 0 && m == 0 && k == 0)
      return; 
    Iterator<RecyclerView.ViewHolder> iterator = this.j.iterator();
    while (iterator.hasNext())
      c(iterator.next()); 
    this.j.clear();
    if (j != 0) {
      ArrayList<MoveInfo> arrayList = new ArrayList();
      arrayList.addAll(this.l);
      this.b.add(arrayList);
      this.l.clear();
      Runnable runnable = new Runnable(this, arrayList) {
          public void run() {
            for (DefaultItemAnimator.MoveInfo moveInfo : this.a)
              this.b.a(moveInfo.holder, moveInfo.fromX, moveInfo.fromY, moveInfo.toX, moveInfo.toY); 
            this.a.clear();
            this.b.b.remove(this.a);
          }
        };
      if (i != 0) {
        ViewCompat.postOnAnimationDelayed(((MoveInfo)arrayList.get(0)).holder.itemView, runnable, getRemoveDuration());
      } else {
        runnable.run();
      } 
    } 
    if (k != 0) {
      ArrayList<ChangeInfo> arrayList = new ArrayList();
      arrayList.addAll(this.m);
      this.c.add(arrayList);
      this.m.clear();
      Runnable runnable = new Runnable(this, arrayList) {
          public void run() {
            for (DefaultItemAnimator.ChangeInfo changeInfo : this.a)
              this.b.a(changeInfo); 
            this.a.clear();
            this.b.c.remove(this.a);
          }
        };
      if (i != 0) {
        ViewCompat.postOnAnimationDelayed(((ChangeInfo)arrayList.get(0)).oldHolder.itemView, runnable, getRemoveDuration());
      } else {
        runnable.run();
      } 
    } 
    if (m != 0) {
      ArrayList<RecyclerView.ViewHolder> arrayList = new ArrayList();
      arrayList.addAll(this.k);
      this.a.add(arrayList);
      this.k.clear();
      Runnable runnable = new Runnable(this, arrayList) {
          public void run() {
            for (RecyclerView.ViewHolder viewHolder : this.a)
              this.b.a(viewHolder); 
            this.a.clear();
            this.b.a.remove(this.a);
          }
        };
      if (i != 0 || j != 0 || k != 0) {
        long l1;
        long l3 = 0L;
        if (i != 0) {
          l1 = getRemoveDuration();
        } else {
          l1 = 0L;
        } 
        if (j != 0) {
          l2 = getMoveDuration();
        } else {
          l2 = 0L;
        } 
        if (k != 0)
          l3 = getChangeDuration(); 
        long l2 = Math.max(l2, l3);
        ViewCompat.postOnAnimationDelayed(((RecyclerView.ViewHolder)arrayList.get(0)).itemView, runnable, l1 + l2);
        return;
      } 
      runnable.run();
      return;
    } 
  }
  
  static class ChangeInfo {
    public int fromX;
    
    public int fromY;
    
    public RecyclerView.ViewHolder newHolder;
    
    public RecyclerView.ViewHolder oldHolder;
    
    public int toX;
    
    public int toY;
    
    private ChangeInfo(RecyclerView.ViewHolder param1ViewHolder1, RecyclerView.ViewHolder param1ViewHolder2) {
      this.oldHolder = param1ViewHolder1;
      this.newHolder = param1ViewHolder2;
    }
    
    ChangeInfo(RecyclerView.ViewHolder param1ViewHolder1, RecyclerView.ViewHolder param1ViewHolder2, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this(param1ViewHolder1, param1ViewHolder2);
      this.fromX = param1Int1;
      this.fromY = param1Int2;
      this.toX = param1Int3;
      this.toY = param1Int4;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("ChangeInfo{oldHolder=");
      stringBuilder.append(this.oldHolder);
      stringBuilder.append(", newHolder=");
      stringBuilder.append(this.newHolder);
      stringBuilder.append(", fromX=");
      stringBuilder.append(this.fromX);
      stringBuilder.append(", fromY=");
      stringBuilder.append(this.fromY);
      stringBuilder.append(", toX=");
      stringBuilder.append(this.toX);
      stringBuilder.append(", toY=");
      stringBuilder.append(this.toY);
      stringBuilder.append('}');
      return stringBuilder.toString();
    }
  }
  
  static class MoveInfo {
    public int fromX;
    
    public int fromY;
    
    public RecyclerView.ViewHolder holder;
    
    public int toX;
    
    public int toY;
    
    MoveInfo(RecyclerView.ViewHolder param1ViewHolder, int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.holder = param1ViewHolder;
      this.fromX = param1Int1;
      this.fromY = param1Int2;
      this.toX = param1Int3;
      this.toY = param1Int4;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\DefaultItemAnimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */