package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.OnChildAttachStateChangeListener {
  public static final int ACTION_STATE_DRAG = 2;
  
  public static final int ACTION_STATE_IDLE = 0;
  
  public static final int ACTION_STATE_SWIPE = 1;
  
  public static final int ANIMATION_TYPE_DRAG = 8;
  
  public static final int ANIMATION_TYPE_SWIPE_CANCEL = 4;
  
  public static final int ANIMATION_TYPE_SWIPE_SUCCESS = 2;
  
  public static final int DOWN = 2;
  
  public static final int END = 32;
  
  public static final int LEFT = 4;
  
  public static final int RIGHT = 8;
  
  public static final int START = 16;
  
  public static final int UP = 1;
  
  private ItemTouchHelperGestureListener A;
  
  private final RecyclerView.OnItemTouchListener B = new RecyclerView.OnItemTouchListener(this) {
      public boolean onInterceptTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {
        this.a.p.onTouchEvent(param1MotionEvent);
        int i = param1MotionEvent.getActionMasked();
        if (i == 0) {
          this.a.g = param1MotionEvent.getPointerId(0);
          this.a.c = param1MotionEvent.getX();
          this.a.d = param1MotionEvent.getY();
          this.a.c();
          if (this.a.b == null) {
            ItemTouchHelper.RecoverAnimation recoverAnimation = this.a.b(param1MotionEvent);
            if (recoverAnimation != null) {
              ItemTouchHelper itemTouchHelper2 = this.a;
              itemTouchHelper2.c -= recoverAnimation.l;
              itemTouchHelper2 = this.a;
              itemTouchHelper2.d -= recoverAnimation.m;
              this.a.a(recoverAnimation.h, true);
              if (this.a.a.remove(recoverAnimation.h.itemView))
                this.a.h.clearView(this.a.k, recoverAnimation.h); 
              this.a.a(recoverAnimation.h, recoverAnimation.i);
              ItemTouchHelper itemTouchHelper1 = this.a;
              itemTouchHelper1.a(param1MotionEvent, itemTouchHelper1.i, 0);
            } 
          } 
        } else if (i == 3 || i == 1) {
          ItemTouchHelper itemTouchHelper = this.a;
          itemTouchHelper.g = -1;
          itemTouchHelper.a((RecyclerView.ViewHolder)null, 0);
        } else if (this.a.g != -1) {
          int j = param1MotionEvent.findPointerIndex(this.a.g);
          if (j >= 0)
            this.a.a(i, param1MotionEvent, j); 
        } 
        if (this.a.m != null)
          this.a.m.addMovement(param1MotionEvent); 
        return (this.a.b != null);
      }
      
      public void onRequestDisallowInterceptTouchEvent(boolean param1Boolean) {
        if (!param1Boolean)
          return; 
        this.a.a((RecyclerView.ViewHolder)null, 0);
      }
      
      public void onTouchEvent(RecyclerView param1RecyclerView, MotionEvent param1MotionEvent) {
        this.a.p.onTouchEvent(param1MotionEvent);
        if (this.a.m != null)
          this.a.m.addMovement(param1MotionEvent); 
        if (this.a.g == -1)
          return; 
        int i = param1MotionEvent.getActionMasked();
        int j = param1MotionEvent.findPointerIndex(this.a.g);
        if (j >= 0)
          this.a.a(i, param1MotionEvent, j); 
        RecyclerView.ViewHolder viewHolder = this.a.b;
        if (viewHolder == null)
          return; 
        boolean bool = false;
        if (i != 1) {
          ItemTouchHelper itemTouchHelper;
          if (i != 2) {
            if (i != 3) {
              if (i != 6)
                return; 
              i = param1MotionEvent.getActionIndex();
              if (param1MotionEvent.getPointerId(i) == this.a.g) {
                if (i == 0)
                  bool = true; 
                this.a.g = param1MotionEvent.getPointerId(bool);
                itemTouchHelper = this.a;
                itemTouchHelper.a(param1MotionEvent, itemTouchHelper.i, i);
                return;
              } 
            } else {
              if (this.a.m != null)
                this.a.m.clear(); 
              this.a.a((RecyclerView.ViewHolder)null, 0);
              this.a.g = -1;
            } 
          } else if (j >= 0) {
            ItemTouchHelper itemTouchHelper1 = this.a;
            itemTouchHelper1.a(param1MotionEvent, itemTouchHelper1.i, j);
            this.a.a((RecyclerView.ViewHolder)itemTouchHelper);
            this.a.k.removeCallbacks(this.a.l);
            this.a.l.run();
            this.a.k.invalidate();
            return;
          } 
          return;
        } 
        this.a.a((RecyclerView.ViewHolder)null, 0);
        this.a.g = -1;
      }
    };
  
  private Rect C;
  
  private long D;
  
  final List<View> a = new ArrayList<View>();
  
  RecyclerView.ViewHolder b = null;
  
  float c;
  
  float d;
  
  float e;
  
  float f;
  
  int g = -1;
  
  Callback h;
  
  int i;
  
  List<RecoverAnimation> j = new ArrayList<RecoverAnimation>();
  
  RecyclerView k;
  
  final Runnable l = new Runnable(this) {
      public void run() {
        if (this.a.b != null && this.a.b()) {
          if (this.a.b != null) {
            ItemTouchHelper itemTouchHelper = this.a;
            itemTouchHelper.a(itemTouchHelper.b);
          } 
          this.a.k.removeCallbacks(this.a.l);
          ViewCompat.postOnAnimation((View)this.a.k, this);
        } 
      }
    };
  
  VelocityTracker m;
  
  View n = null;
  
  int o = -1;
  
  GestureDetectorCompat p;
  
  private final float[] q = new float[2];
  
  private float r;
  
  private float s;
  
  private float t;
  
  private float u;
  
  private int v = 0;
  
  private int w;
  
  private List<RecyclerView.ViewHolder> x;
  
  private List<Integer> y;
  
  private RecyclerView.ChildDrawingOrderCallback z = null;
  
  public ItemTouchHelper(Callback paramCallback) {
    this.h = paramCallback;
  }
  
  private void a(float[] paramArrayOffloat) {
    if ((this.i & 0xC) != 0) {
      paramArrayOffloat[0] = this.t + this.e - this.b.itemView.getLeft();
    } else {
      paramArrayOffloat[0] = this.b.itemView.getTranslationX();
    } 
    if ((this.i & 0x3) != 0) {
      paramArrayOffloat[1] = this.u + this.f - this.b.itemView.getTop();
      return;
    } 
    paramArrayOffloat[1] = this.b.itemView.getTranslationY();
  }
  
  private static boolean a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4) {
    return (paramFloat1 >= paramFloat3 && paramFloat1 <= paramFloat3 + paramView.getWidth() && paramFloat2 >= paramFloat4 && paramFloat2 <= paramFloat4 + paramView.getHeight());
  }
  
  private int b(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    if ((paramInt & 0xC) != 0) {
      byte b1;
      float f1 = this.e;
      byte b2 = 8;
      if (f1 > 0.0F) {
        b1 = 8;
      } else {
        b1 = 4;
      } 
      VelocityTracker velocityTracker = this.m;
      if (velocityTracker != null && this.g > -1) {
        velocityTracker.computeCurrentVelocity(1000, this.h.getSwipeVelocityThreshold(this.s));
        float f = this.m.getXVelocity(this.g);
        f1 = this.m.getYVelocity(this.g);
        if (f <= 0.0F)
          b2 = 4; 
        f = Math.abs(f);
        if ((b2 & paramInt) != 0 && b1 == b2 && f >= this.h.getSwipeEscapeVelocity(this.r) && f > Math.abs(f1))
          return b2; 
      } 
      f1 = this.k.getWidth();
      float f2 = this.h.getSwipeThreshold(paramViewHolder);
      if ((paramInt & b1) != 0 && Math.abs(this.e) > f1 * f2)
        return b1; 
    } 
    return 0;
  }
  
  private List<RecyclerView.ViewHolder> b(RecyclerView.ViewHolder paramViewHolder) {
    RecyclerView.ViewHolder viewHolder = paramViewHolder;
    List<RecyclerView.ViewHolder> list = this.x;
    if (list == null) {
      this.x = new ArrayList<RecyclerView.ViewHolder>();
      this.y = new ArrayList<Integer>();
    } else {
      list.clear();
      this.y.clear();
    } 
    int j = this.h.getBoundingBoxMargin();
    int k = Math.round(this.t + this.e) - j;
    int m = Math.round(this.u + this.f) - j;
    int i = viewHolder.itemView.getWidth();
    j *= 2;
    int n = i + k + j;
    int i1 = viewHolder.itemView.getHeight() + m + j;
    int i2 = (k + n) / 2;
    int i3 = (m + i1) / 2;
    RecyclerView.LayoutManager layoutManager = this.k.getLayoutManager();
    int i4 = layoutManager.getChildCount();
    for (i = 0; i < i4; i++) {
      View view = layoutManager.getChildAt(i);
      if (view != paramViewHolder.itemView && view.getBottom() >= m && view.getTop() <= i1 && view.getRight() >= k && view.getLeft() <= n) {
        RecyclerView.ViewHolder viewHolder1 = this.k.getChildViewHolder(view);
        if (this.h.canDropOver(this.k, this.b, viewHolder1)) {
          j = Math.abs(i2 - (view.getLeft() + view.getRight()) / 2);
          int i5 = Math.abs(i3 - (view.getTop() + view.getBottom()) / 2);
          int i6 = j * j + i5 * i5;
          int i7 = this.x.size();
          j = 0;
          i5 = 0;
          while (j < i7 && i6 > ((Integer)this.y.get(j)).intValue()) {
            i5++;
            j++;
          } 
          this.x.add(i5, viewHolder1);
          this.y.add(i5, Integer.valueOf(i6));
        } 
      } 
    } 
    return this.x;
  }
  
  private int c(RecyclerView.ViewHolder paramViewHolder) {
    if (this.v == 2)
      return 0; 
    int j = this.h.getMovementFlags(this.k, paramViewHolder);
    int i = (this.h.convertToAbsoluteDirection(j, ViewCompat.getLayoutDirection((View)this.k)) & 0xFF00) >> 8;
    if (i == 0)
      return 0; 
    int k = (j & 0xFF00) >> 8;
    if (Math.abs(this.e) > Math.abs(this.f)) {
      j = b(paramViewHolder, i);
      if (j > 0)
        return ((k & j) == 0) ? Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection((View)this.k)) : j; 
      i = c(paramViewHolder, i);
      if (i > 0)
        return i; 
    } else {
      j = c(paramViewHolder, i);
      if (j > 0)
        return j; 
      j = b(paramViewHolder, i);
      if (j > 0) {
        i = j;
        if ((k & j) == 0)
          i = Callback.convertToRelativeDirection(j, ViewCompat.getLayoutDirection((View)this.k)); 
        return i;
      } 
    } 
    return 0;
  }
  
  private int c(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    if ((paramInt & 0x3) != 0) {
      byte b1;
      float f1 = this.f;
      byte b2 = 2;
      if (f1 > 0.0F) {
        b1 = 2;
      } else {
        b1 = 1;
      } 
      VelocityTracker velocityTracker = this.m;
      if (velocityTracker != null && this.g > -1) {
        velocityTracker.computeCurrentVelocity(1000, this.h.getSwipeVelocityThreshold(this.s));
        f1 = this.m.getXVelocity(this.g);
        float f = this.m.getYVelocity(this.g);
        if (f <= 0.0F)
          b2 = 1; 
        f = Math.abs(f);
        if ((b2 & paramInt) != 0 && b2 == b1 && f >= this.h.getSwipeEscapeVelocity(this.r) && f > Math.abs(f1))
          return b2; 
      } 
      f1 = this.k.getHeight();
      float f2 = this.h.getSwipeThreshold(paramViewHolder);
      if ((paramInt & b1) != 0 && Math.abs(this.f) > f1 * f2)
        return b1; 
    } 
    return 0;
  }
  
  private RecyclerView.ViewHolder c(MotionEvent paramMotionEvent) {
    RecyclerView.LayoutManager layoutManager = this.k.getLayoutManager();
    int i = this.g;
    if (i == -1)
      return null; 
    i = paramMotionEvent.findPointerIndex(i);
    float f3 = paramMotionEvent.getX(i);
    float f4 = this.c;
    float f1 = paramMotionEvent.getY(i);
    float f2 = this.d;
    f3 = Math.abs(f3 - f4);
    f1 = Math.abs(f1 - f2);
    i = this.w;
    if (f3 < i && f1 < i)
      return null; 
    if (f3 > f1 && layoutManager.canScrollHorizontally())
      return null; 
    if (f1 > f3 && layoutManager.canScrollVertically())
      return null; 
    View view = a(paramMotionEvent);
    return (view == null) ? null : this.k.getChildViewHolder(view);
  }
  
  private void d() {
    this.w = ViewConfiguration.get(this.k.getContext()).getScaledTouchSlop();
    this.k.addItemDecoration(this);
    this.k.addOnItemTouchListener(this.B);
    this.k.addOnChildAttachStateChangeListener(this);
    f();
  }
  
  private void e() {
    this.k.removeItemDecoration(this);
    this.k.removeOnItemTouchListener(this.B);
    this.k.removeOnChildAttachStateChangeListener(this);
    for (int i = this.j.size() - 1; i >= 0; i--) {
      RecoverAnimation recoverAnimation = this.j.get(0);
      this.h.clearView(this.k, recoverAnimation.h);
    } 
    this.j.clear();
    this.n = null;
    this.o = -1;
    h();
    g();
  }
  
  private void f() {
    this.A = new ItemTouchHelperGestureListener(this);
    this.p = new GestureDetectorCompat(this.k.getContext(), (GestureDetector.OnGestureListener)this.A);
  }
  
  private void g() {
    ItemTouchHelperGestureListener itemTouchHelperGestureListener = this.A;
    if (itemTouchHelperGestureListener != null) {
      itemTouchHelperGestureListener.a();
      this.A = null;
    } 
    if (this.p != null)
      this.p = null; 
  }
  
  private void h() {
    VelocityTracker velocityTracker = this.m;
    if (velocityTracker != null) {
      velocityTracker.recycle();
      this.m = null;
    } 
  }
  
  private void i() {
    if (Build.VERSION.SDK_INT >= 21)
      return; 
    if (this.z == null)
      this.z = new RecyclerView.ChildDrawingOrderCallback(this) {
          public int onGetChildDrawingOrder(int param1Int1, int param1Int2) {
            if (this.a.n == null)
              return param1Int2; 
            int j = this.a.o;
            int i = j;
            if (j == -1) {
              i = this.a.k.indexOfChild(this.a.n);
              this.a.o = i;
            } 
            return (param1Int2 == param1Int1 - 1) ? i : ((param1Int2 < i) ? param1Int2 : (param1Int2 + 1));
          }
        }; 
    this.k.setChildDrawingOrderCallback(this.z);
  }
  
  View a(MotionEvent paramMotionEvent) {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    RecyclerView.ViewHolder viewHolder = this.b;
    if (viewHolder != null) {
      View view = viewHolder.itemView;
      if (a(view, f1, f2, this.t + this.e, this.u + this.f))
        return view; 
    } 
    int i;
    for (i = this.j.size() - 1; i >= 0; i--) {
      RecoverAnimation recoverAnimation = this.j.get(i);
      View view = recoverAnimation.h.itemView;
      if (a(view, f1, f2, recoverAnimation.l, recoverAnimation.m))
        return view; 
    } 
    return this.k.findChildViewUnder(f1, f2);
  }
  
  void a(int paramInt1, MotionEvent paramMotionEvent, int paramInt2) {
    if (this.b == null && paramInt1 == 2 && this.v != 2) {
      if (!this.h.isItemViewSwipeEnabled())
        return; 
      if (this.k.getScrollState() == 1)
        return; 
      RecyclerView.ViewHolder viewHolder = c(paramMotionEvent);
      if (viewHolder == null)
        return; 
      paramInt1 = (this.h.a(this.k, viewHolder) & 0xFF00) >> 8;
      if (paramInt1 == 0)
        return; 
      float f1 = paramMotionEvent.getX(paramInt2);
      float f2 = paramMotionEvent.getY(paramInt2);
      f1 -= this.c;
      f2 -= this.d;
      float f3 = Math.abs(f1);
      float f4 = Math.abs(f2);
      paramInt2 = this.w;
      if (f3 < paramInt2 && f4 < paramInt2)
        return; 
      if (f3 > f4) {
        if (f1 < 0.0F && (paramInt1 & 0x4) == 0)
          return; 
        if (f1 > 0.0F && (paramInt1 & 0x8) == 0)
          return; 
      } else {
        if (f2 < 0.0F && (paramInt1 & 0x1) == 0)
          return; 
        if (f2 > 0.0F && (paramInt1 & 0x2) == 0)
          return; 
      } 
      this.f = 0.0F;
      this.e = 0.0F;
      this.g = paramMotionEvent.getPointerId(0);
      a(viewHolder, 1);
    } 
  }
  
  void a(MotionEvent paramMotionEvent, int paramInt1, int paramInt2) {
    float f1 = paramMotionEvent.getX(paramInt2);
    float f2 = paramMotionEvent.getY(paramInt2);
    this.e = f1 - this.c;
    this.f = f2 - this.d;
    if ((paramInt1 & 0x4) == 0)
      this.e = Math.max(0.0F, this.e); 
    if ((paramInt1 & 0x8) == 0)
      this.e = Math.min(0.0F, this.e); 
    if ((paramInt1 & 0x1) == 0)
      this.f = Math.max(0.0F, this.f); 
    if ((paramInt1 & 0x2) == 0)
      this.f = Math.min(0.0F, this.f); 
  }
  
  void a(View paramView) {
    if (paramView == this.n) {
      this.n = null;
      if (this.z != null)
        this.k.setChildDrawingOrderCallback((RecyclerView.ChildDrawingOrderCallback)null); 
    } 
  }
  
  void a(RecoverAnimation paramRecoverAnimation, int paramInt) {
    this.k.post(new Runnable(this, paramRecoverAnimation, paramInt) {
          public void run() {
            if (this.c.k != null && this.c.k.isAttachedToWindow() && !this.a.n && this.a.h.getAdapterPosition() != -1) {
              RecyclerView.ItemAnimator itemAnimator = this.c.k.getItemAnimator();
              if ((itemAnimator == null || !itemAnimator.isRunning(null)) && !this.c.a()) {
                this.c.h.onSwiped(this.a.h, this.b);
                return;
              } 
              this.c.k.post(this);
            } 
          }
        });
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder) {
    if (this.k.isLayoutRequested())
      return; 
    if (this.v != 2)
      return; 
    float f = this.h.getMoveThreshold(paramViewHolder);
    int i = (int)(this.t + this.e);
    int j = (int)(this.u + this.f);
    if (Math.abs(j - paramViewHolder.itemView.getTop()) < paramViewHolder.itemView.getHeight() * f && Math.abs(i - paramViewHolder.itemView.getLeft()) < paramViewHolder.itemView.getWidth() * f)
      return; 
    List<RecyclerView.ViewHolder> list = b(paramViewHolder);
    if (list.size() == 0)
      return; 
    RecyclerView.ViewHolder viewHolder = this.h.chooseDropTarget(paramViewHolder, list, i, j);
    if (viewHolder == null) {
      this.x.clear();
      this.y.clear();
      return;
    } 
    int k = viewHolder.getAdapterPosition();
    int m = paramViewHolder.getAdapterPosition();
    if (this.h.onMove(this.k, paramViewHolder, viewHolder))
      this.h.onMoved(this.k, paramViewHolder, m, viewHolder, k, i, j); 
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, int paramInt) {
    boolean bool1;
    if (paramViewHolder == this.b && paramInt == this.v)
      return; 
    this.D = Long.MIN_VALUE;
    int i = this.v;
    a(paramViewHolder, true);
    this.v = paramInt;
    if (paramInt == 2)
      if (paramViewHolder != null) {
        this.n = paramViewHolder.itemView;
        i();
      } else {
        throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
      }  
    RecyclerView.ViewHolder viewHolder = this.b;
    if (viewHolder != null) {
      RecoverAnimation recoverAnimation;
      if (viewHolder.itemView.getParent() != null) {
        float f1;
        float f2;
        int j;
        if (i == 2) {
          j = 0;
        } else {
          j = c(viewHolder);
        } 
        h();
        if (j != 1 && j != 2) {
          if (j != 4 && j != 8 && j != 16 && j != 32) {
            f1 = 0.0F;
          } else {
            f1 = Math.signum(this.e) * this.k.getWidth();
          } 
          f2 = 0.0F;
        } else {
          f2 = Math.signum(this.f) * this.k.getHeight();
          f1 = 0.0F;
        } 
        if (i == 2) {
          bool1 = true;
        } else if (j > 0) {
          bool1 = true;
        } else {
          bool1 = true;
        } 
        a(this.q);
        float[] arrayOfFloat = this.q;
        float f3 = arrayOfFloat[0];
        float f4 = arrayOfFloat[1];
        recoverAnimation = new RecoverAnimation(this, viewHolder, bool1, i, f3, f4, f1, f2, j, viewHolder) {
            public void onAnimationEnd(Animator param1Animator) {
              super.onAnimationEnd(param1Animator);
              if (this.n)
                return; 
              if (this.a <= 0) {
                this.c.h.clearView(this.c.k, this.b);
              } else {
                this.c.a.add(this.b.itemView);
                this.k = true;
                int i = this.a;
                if (i > 0)
                  this.c.a(this, i); 
              } 
              if (this.c.n == this.b.itemView)
                this.c.a(this.b.itemView); 
            }
          };
        recoverAnimation.setDuration(this.h.getAnimationDuration(this.k, bool1, f1 - f3, f2 - f4));
        this.j.add(recoverAnimation);
        recoverAnimation.start();
        bool1 = true;
      } else {
        a(((RecyclerView.ViewHolder)recoverAnimation).itemView);
        this.h.clearView(this.k, (RecyclerView.ViewHolder)recoverAnimation);
        bool1 = false;
      } 
      this.b = null;
    } else {
      bool1 = false;
    } 
    if (paramViewHolder != null) {
      this.i = (this.h.a(this.k, paramViewHolder) & (1 << paramInt * 8 + 8) - 1) >> this.v * 8;
      this.t = paramViewHolder.itemView.getLeft();
      this.u = paramViewHolder.itemView.getTop();
      this.b = paramViewHolder;
      if (paramInt == 2)
        this.b.itemView.performHapticFeedback(0); 
    } 
    boolean bool2 = false;
    ViewParent viewParent = this.k.getParent();
    if (viewParent != null) {
      if (this.b != null)
        bool2 = true; 
      viewParent.requestDisallowInterceptTouchEvent(bool2);
    } 
    if (!bool1)
      this.k.getLayoutManager().requestSimpleAnimationsInNextLayout(); 
    this.h.onSelectedChanged(this.b, this.v);
    this.k.invalidate();
  }
  
  void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean) {
    for (int i = this.j.size() - 1; i >= 0; i--) {
      RecoverAnimation recoverAnimation = this.j.get(i);
      if (recoverAnimation.h == paramViewHolder) {
        recoverAnimation.n |= paramBoolean;
        if (!recoverAnimation.o)
          recoverAnimation.cancel(); 
        this.j.remove(i);
        return;
      } 
    } 
  }
  
  boolean a() {
    int j = this.j.size();
    for (int i = 0; i < j; i++) {
      if (!((RecoverAnimation)this.j.get(i)).o)
        return true; 
    } 
    return false;
  }
  
  public void attachToRecyclerView(RecyclerView paramRecyclerView) {
    RecyclerView recyclerView = this.k;
    if (recyclerView == paramRecyclerView)
      return; 
    if (recyclerView != null)
      e(); 
    this.k = paramRecyclerView;
    if (paramRecyclerView != null) {
      Resources resources = paramRecyclerView.getResources();
      this.r = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
      this.s = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
      d();
    } 
  }
  
  RecoverAnimation b(MotionEvent paramMotionEvent) {
    if (this.j.isEmpty())
      return null; 
    View view = a(paramMotionEvent);
    for (int i = this.j.size() - 1; i >= 0; i--) {
      RecoverAnimation recoverAnimation = this.j.get(i);
      if (recoverAnimation.h.itemView == view)
        return recoverAnimation; 
    } 
    return null;
  }
  
  boolean b() {
    // Byte code:
    //   0: aload_0
    //   1: getfield b : Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    //   4: ifnonnull -> 16
    //   7: aload_0
    //   8: ldc2_w -9223372036854775808
    //   11: putfield D : J
    //   14: iconst_0
    //   15: ireturn
    //   16: invokestatic currentTimeMillis : ()J
    //   19: lstore #6
    //   21: aload_0
    //   22: getfield D : J
    //   25: lstore #4
    //   27: lload #4
    //   29: ldc2_w -9223372036854775808
    //   32: lcmp
    //   33: ifne -> 42
    //   36: lconst_0
    //   37: lstore #4
    //   39: goto -> 49
    //   42: lload #6
    //   44: lload #4
    //   46: lsub
    //   47: lstore #4
    //   49: aload_0
    //   50: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   53: invokevirtual getLayoutManager : ()Landroidx/recyclerview/widget/RecyclerView$LayoutManager;
    //   56: astore #8
    //   58: aload_0
    //   59: getfield C : Landroid/graphics/Rect;
    //   62: ifnonnull -> 76
    //   65: aload_0
    //   66: new android/graphics/Rect
    //   69: dup
    //   70: invokespecial <init> : ()V
    //   73: putfield C : Landroid/graphics/Rect;
    //   76: aload #8
    //   78: aload_0
    //   79: getfield b : Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    //   82: getfield itemView : Landroid/view/View;
    //   85: aload_0
    //   86: getfield C : Landroid/graphics/Rect;
    //   89: invokevirtual calculateItemDecorationsForChild : (Landroid/view/View;Landroid/graphics/Rect;)V
    //   92: aload #8
    //   94: invokevirtual canScrollHorizontally : ()Z
    //   97: ifeq -> 198
    //   100: aload_0
    //   101: getfield t : F
    //   104: aload_0
    //   105: getfield e : F
    //   108: fadd
    //   109: f2i
    //   110: istore_2
    //   111: iload_2
    //   112: aload_0
    //   113: getfield C : Landroid/graphics/Rect;
    //   116: getfield left : I
    //   119: isub
    //   120: aload_0
    //   121: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   124: invokevirtual getPaddingLeft : ()I
    //   127: isub
    //   128: istore_1
    //   129: aload_0
    //   130: getfield e : F
    //   133: fconst_0
    //   134: fcmpg
    //   135: ifge -> 145
    //   138: iload_1
    //   139: ifge -> 145
    //   142: goto -> 200
    //   145: aload_0
    //   146: getfield e : F
    //   149: fconst_0
    //   150: fcmpl
    //   151: ifle -> 198
    //   154: iload_2
    //   155: aload_0
    //   156: getfield b : Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    //   159: getfield itemView : Landroid/view/View;
    //   162: invokevirtual getWidth : ()I
    //   165: iadd
    //   166: aload_0
    //   167: getfield C : Landroid/graphics/Rect;
    //   170: getfield right : I
    //   173: iadd
    //   174: aload_0
    //   175: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   178: invokevirtual getWidth : ()I
    //   181: aload_0
    //   182: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   185: invokevirtual getPaddingRight : ()I
    //   188: isub
    //   189: isub
    //   190: istore_1
    //   191: iload_1
    //   192: ifle -> 198
    //   195: goto -> 200
    //   198: iconst_0
    //   199: istore_1
    //   200: aload #8
    //   202: invokevirtual canScrollVertically : ()Z
    //   205: ifeq -> 306
    //   208: aload_0
    //   209: getfield u : F
    //   212: aload_0
    //   213: getfield f : F
    //   216: fadd
    //   217: f2i
    //   218: istore_3
    //   219: iload_3
    //   220: aload_0
    //   221: getfield C : Landroid/graphics/Rect;
    //   224: getfield top : I
    //   227: isub
    //   228: aload_0
    //   229: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   232: invokevirtual getPaddingTop : ()I
    //   235: isub
    //   236: istore_2
    //   237: aload_0
    //   238: getfield f : F
    //   241: fconst_0
    //   242: fcmpg
    //   243: ifge -> 253
    //   246: iload_2
    //   247: ifge -> 253
    //   250: goto -> 308
    //   253: aload_0
    //   254: getfield f : F
    //   257: fconst_0
    //   258: fcmpl
    //   259: ifle -> 306
    //   262: iload_3
    //   263: aload_0
    //   264: getfield b : Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    //   267: getfield itemView : Landroid/view/View;
    //   270: invokevirtual getHeight : ()I
    //   273: iadd
    //   274: aload_0
    //   275: getfield C : Landroid/graphics/Rect;
    //   278: getfield bottom : I
    //   281: iadd
    //   282: aload_0
    //   283: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   286: invokevirtual getHeight : ()I
    //   289: aload_0
    //   290: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   293: invokevirtual getPaddingBottom : ()I
    //   296: isub
    //   297: isub
    //   298: istore_2
    //   299: iload_2
    //   300: ifle -> 306
    //   303: goto -> 308
    //   306: iconst_0
    //   307: istore_2
    //   308: iload_1
    //   309: istore_3
    //   310: iload_1
    //   311: ifeq -> 346
    //   314: aload_0
    //   315: getfield h : Landroidx/recyclerview/widget/ItemTouchHelper$Callback;
    //   318: aload_0
    //   319: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   322: aload_0
    //   323: getfield b : Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    //   326: getfield itemView : Landroid/view/View;
    //   329: invokevirtual getWidth : ()I
    //   332: iload_1
    //   333: aload_0
    //   334: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   337: invokevirtual getWidth : ()I
    //   340: lload #4
    //   342: invokevirtual interpolateOutOfBoundsScroll : (Landroidx/recyclerview/widget/RecyclerView;IIIJ)I
    //   345: istore_3
    //   346: iload_2
    //   347: ifeq -> 385
    //   350: aload_0
    //   351: getfield h : Landroidx/recyclerview/widget/ItemTouchHelper$Callback;
    //   354: aload_0
    //   355: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   358: aload_0
    //   359: getfield b : Landroidx/recyclerview/widget/RecyclerView$ViewHolder;
    //   362: getfield itemView : Landroid/view/View;
    //   365: invokevirtual getHeight : ()I
    //   368: iload_2
    //   369: aload_0
    //   370: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   373: invokevirtual getHeight : ()I
    //   376: lload #4
    //   378: invokevirtual interpolateOutOfBoundsScroll : (Landroidx/recyclerview/widget/RecyclerView;IIIJ)I
    //   381: istore_2
    //   382: goto -> 385
    //   385: iload_3
    //   386: ifne -> 405
    //   389: iload_2
    //   390: ifeq -> 396
    //   393: goto -> 405
    //   396: aload_0
    //   397: ldc2_w -9223372036854775808
    //   400: putfield D : J
    //   403: iconst_0
    //   404: ireturn
    //   405: aload_0
    //   406: getfield D : J
    //   409: ldc2_w -9223372036854775808
    //   412: lcmp
    //   413: ifne -> 422
    //   416: aload_0
    //   417: lload #6
    //   419: putfield D : J
    //   422: aload_0
    //   423: getfield k : Landroidx/recyclerview/widget/RecyclerView;
    //   426: iload_3
    //   427: iload_2
    //   428: invokevirtual scrollBy : (II)V
    //   431: iconst_1
    //   432: ireturn
  }
  
  void c() {
    VelocityTracker velocityTracker = this.m;
    if (velocityTracker != null)
      velocityTracker.recycle(); 
    this.m = VelocityTracker.obtain();
  }
  
  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    paramRect.setEmpty();
  }
  
  public void onChildViewAttachedToWindow(View paramView) {}
  
  public void onChildViewDetachedFromWindow(View paramView) {
    a(paramView);
    RecyclerView.ViewHolder viewHolder1 = this.k.getChildViewHolder(paramView);
    if (viewHolder1 == null)
      return; 
    RecyclerView.ViewHolder viewHolder2 = this.b;
    if (viewHolder2 != null && viewHolder1 == viewHolder2) {
      a((RecyclerView.ViewHolder)null, 0);
      return;
    } 
    a(viewHolder1, false);
    if (this.a.remove(viewHolder1.itemView))
      this.h.clearView(this.k, viewHolder1); 
  }
  
  public void onDraw(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    float f1;
    float f2;
    this.o = -1;
    if (this.b != null) {
      a(this.q);
      float[] arrayOfFloat = this.q;
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
    } else {
      f1 = 0.0F;
      f2 = 0.0F;
    } 
    this.h.a(paramCanvas, paramRecyclerView, this.b, this.j, this.v, f1, f2);
  }
  
  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState) {
    float f1;
    float f2;
    if (this.b != null) {
      a(this.q);
      float[] arrayOfFloat = this.q;
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
    } else {
      f1 = 0.0F;
      f2 = 0.0F;
    } 
    this.h.b(paramCanvas, paramRecyclerView, this.b, this.j, this.v, f1, f2);
  }
  
  public void startDrag(RecyclerView.ViewHolder paramViewHolder) {
    if (!this.h.b(this.k, paramViewHolder)) {
      Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
      return;
    } 
    if (paramViewHolder.itemView.getParent() != this.k) {
      Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
      return;
    } 
    c();
    this.f = 0.0F;
    this.e = 0.0F;
    a(paramViewHolder, 2);
  }
  
  public void startSwipe(RecyclerView.ViewHolder paramViewHolder) {
    if (!this.h.c(this.k, paramViewHolder)) {
      Log.e("ItemTouchHelper", "Start swipe has been called but swiping is not enabled");
      return;
    } 
    if (paramViewHolder.itemView.getParent() != this.k) {
      Log.e("ItemTouchHelper", "Start swipe has been called with a view holder which is not a child of the RecyclerView controlled by this ItemTouchHelper.");
      return;
    } 
    c();
    this.f = 0.0F;
    this.e = 0.0F;
    a(paramViewHolder, 1);
  }
  
  public static abstract class Callback {
    public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
    
    public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
    
    private static final Interpolator a = new Interpolator() {
        public float getInterpolation(float param2Float) {
          return param2Float * param2Float * param2Float * param2Float * param2Float;
        }
      };
    
    private static final Interpolator b = new Interpolator() {
        public float getInterpolation(float param2Float) {
          param2Float--;
          return param2Float * param2Float * param2Float * param2Float * param2Float + 1.0F;
        }
      };
    
    private int c = -1;
    
    private int a(RecyclerView param1RecyclerView) {
      if (this.c == -1)
        this.c = param1RecyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame); 
      return this.c;
    }
    
    public static int convertToRelativeDirection(int param1Int1, int param1Int2) {
      int i = param1Int1 & 0xC0C0C;
      if (i == 0)
        return param1Int1; 
      param1Int1 &= i;
      if (param1Int2 == 0) {
        param1Int2 = i << 2;
        return param1Int1 | param1Int2;
      } 
      param1Int2 = i << 1;
      param1Int1 |= 0xFFF3F3F3 & param1Int2;
      param1Int2 = (param1Int2 & 0xC0C0C) << 2;
      return param1Int1 | param1Int2;
    }
    
    public static ItemTouchUIUtil getDefaultUIUtil() {
      return ItemTouchUIUtilImpl.a;
    }
    
    public static int makeFlag(int param1Int1, int param1Int2) {
      return param1Int2 << param1Int1 * 8;
    }
    
    public static int makeMovementFlags(int param1Int1, int param1Int2) {
      int i = makeFlag(0, param1Int2 | param1Int1);
      param1Int2 = makeFlag(1, param1Int2);
      return makeFlag(2, param1Int1) | param1Int2 | i;
    }
    
    final int a(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder) {
      return convertToAbsoluteDirection(getMovementFlags(param1RecyclerView, param1ViewHolder), ViewCompat.getLayoutDirection((View)param1RecyclerView));
    }
    
    void a(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder, List<ItemTouchHelper.RecoverAnimation> param1List, int param1Int, float param1Float1, float param1Float2) {
      int j = param1List.size();
      int i;
      for (i = 0; i < j; i++) {
        ItemTouchHelper.RecoverAnimation recoverAnimation = param1List.get(i);
        recoverAnimation.update();
        int k = param1Canvas.save();
        onChildDraw(param1Canvas, param1RecyclerView, recoverAnimation.h, recoverAnimation.l, recoverAnimation.m, recoverAnimation.i, false);
        param1Canvas.restoreToCount(k);
      } 
      if (param1ViewHolder != null) {
        i = param1Canvas.save();
        onChildDraw(param1Canvas, param1RecyclerView, param1ViewHolder, param1Float1, param1Float2, param1Int, true);
        param1Canvas.restoreToCount(i);
      } 
    }
    
    void b(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder, List<ItemTouchHelper.RecoverAnimation> param1List, int param1Int, float param1Float1, float param1Float2) {
      int j = param1List.size();
      boolean bool = false;
      int i;
      for (i = 0; i < j; i++) {
        ItemTouchHelper.RecoverAnimation recoverAnimation = param1List.get(i);
        int k = param1Canvas.save();
        onChildDrawOver(param1Canvas, param1RecyclerView, recoverAnimation.h, recoverAnimation.l, recoverAnimation.m, recoverAnimation.i, false);
        param1Canvas.restoreToCount(k);
      } 
      if (param1ViewHolder != null) {
        i = param1Canvas.save();
        onChildDrawOver(param1Canvas, param1RecyclerView, param1ViewHolder, param1Float1, param1Float2, param1Int, true);
        param1Canvas.restoreToCount(i);
      } 
      param1Int = j - 1;
      i = bool;
      while (param1Int >= 0) {
        ItemTouchHelper.RecoverAnimation recoverAnimation = param1List.get(param1Int);
        if (recoverAnimation.o && !recoverAnimation.k) {
          param1List.remove(param1Int);
        } else if (!recoverAnimation.o) {
          i = 1;
        } 
        param1Int--;
      } 
      if (i != 0)
        param1RecyclerView.invalidate(); 
    }
    
    boolean b(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder) {
      return ((a(param1RecyclerView, param1ViewHolder) & 0xFF0000) != 0);
    }
    
    boolean c(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder) {
      return ((a(param1RecyclerView, param1ViewHolder) & 0xFF00) != 0);
    }
    
    public boolean canDropOver(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder1, RecyclerView.ViewHolder param1ViewHolder2) {
      return true;
    }
    
    public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder param1ViewHolder, List<RecyclerView.ViewHolder> param1List, int param1Int1, int param1Int2) {
      // Byte code:
      //   0: aload_1
      //   1: getfield itemView : Landroid/view/View;
      //   4: invokevirtual getWidth : ()I
      //   7: istore #9
      //   9: aload_1
      //   10: getfield itemView : Landroid/view/View;
      //   13: invokevirtual getHeight : ()I
      //   16: istore #10
      //   18: iload_3
      //   19: aload_1
      //   20: getfield itemView : Landroid/view/View;
      //   23: invokevirtual getLeft : ()I
      //   26: isub
      //   27: istore #11
      //   29: iload #4
      //   31: aload_1
      //   32: getfield itemView : Landroid/view/View;
      //   35: invokevirtual getTop : ()I
      //   38: isub
      //   39: istore #12
      //   41: aload_2
      //   42: invokeinterface size : ()I
      //   47: istore #13
      //   49: aconst_null
      //   50: astore #16
      //   52: iconst_m1
      //   53: istore #5
      //   55: iconst_0
      //   56: istore #7
      //   58: iload #7
      //   60: iload #13
      //   62: if_icmpge -> 413
      //   65: aload_2
      //   66: iload #7
      //   68: invokeinterface get : (I)Ljava/lang/Object;
      //   73: checkcast androidx/recyclerview/widget/RecyclerView$ViewHolder
      //   76: astore #14
      //   78: iload #11
      //   80: ifle -> 142
      //   83: aload #14
      //   85: getfield itemView : Landroid/view/View;
      //   88: invokevirtual getRight : ()I
      //   91: iload_3
      //   92: iload #9
      //   94: iadd
      //   95: isub
      //   96: istore #6
      //   98: iload #6
      //   100: ifge -> 142
      //   103: aload #14
      //   105: getfield itemView : Landroid/view/View;
      //   108: invokevirtual getRight : ()I
      //   111: aload_1
      //   112: getfield itemView : Landroid/view/View;
      //   115: invokevirtual getRight : ()I
      //   118: if_icmple -> 142
      //   121: iload #6
      //   123: invokestatic abs : (I)I
      //   126: istore #6
      //   128: iload #6
      //   130: iload #5
      //   132: if_icmple -> 142
      //   135: aload #14
      //   137: astore #16
      //   139: goto -> 146
      //   142: iload #5
      //   144: istore #6
      //   146: aload #16
      //   148: astore #15
      //   150: iload #6
      //   152: istore #5
      //   154: iload #11
      //   156: ifge -> 240
      //   159: aload #14
      //   161: getfield itemView : Landroid/view/View;
      //   164: invokevirtual getLeft : ()I
      //   167: iload_3
      //   168: isub
      //   169: istore #8
      //   171: aload #16
      //   173: astore #15
      //   175: iload #6
      //   177: istore #5
      //   179: iload #8
      //   181: ifle -> 240
      //   184: aload #16
      //   186: astore #15
      //   188: iload #6
      //   190: istore #5
      //   192: aload #14
      //   194: getfield itemView : Landroid/view/View;
      //   197: invokevirtual getLeft : ()I
      //   200: aload_1
      //   201: getfield itemView : Landroid/view/View;
      //   204: invokevirtual getLeft : ()I
      //   207: if_icmpge -> 240
      //   210: iload #8
      //   212: invokestatic abs : (I)I
      //   215: istore #8
      //   217: aload #16
      //   219: astore #15
      //   221: iload #6
      //   223: istore #5
      //   225: iload #8
      //   227: iload #6
      //   229: if_icmple -> 240
      //   232: iload #8
      //   234: istore #5
      //   236: aload #14
      //   238: astore #15
      //   240: aload #15
      //   242: astore #16
      //   244: iload #5
      //   246: istore #6
      //   248: iload #12
      //   250: ifge -> 335
      //   253: aload #14
      //   255: getfield itemView : Landroid/view/View;
      //   258: invokevirtual getTop : ()I
      //   261: iload #4
      //   263: isub
      //   264: istore #8
      //   266: aload #15
      //   268: astore #16
      //   270: iload #5
      //   272: istore #6
      //   274: iload #8
      //   276: ifle -> 335
      //   279: aload #15
      //   281: astore #16
      //   283: iload #5
      //   285: istore #6
      //   287: aload #14
      //   289: getfield itemView : Landroid/view/View;
      //   292: invokevirtual getTop : ()I
      //   295: aload_1
      //   296: getfield itemView : Landroid/view/View;
      //   299: invokevirtual getTop : ()I
      //   302: if_icmpge -> 335
      //   305: iload #8
      //   307: invokestatic abs : (I)I
      //   310: istore #8
      //   312: aload #15
      //   314: astore #16
      //   316: iload #5
      //   318: istore #6
      //   320: iload #8
      //   322: iload #5
      //   324: if_icmple -> 335
      //   327: iload #8
      //   329: istore #6
      //   331: aload #14
      //   333: astore #16
      //   335: iload #12
      //   337: ifle -> 400
      //   340: aload #14
      //   342: getfield itemView : Landroid/view/View;
      //   345: invokevirtual getBottom : ()I
      //   348: iload #4
      //   350: iload #10
      //   352: iadd
      //   353: isub
      //   354: istore #5
      //   356: iload #5
      //   358: ifge -> 400
      //   361: aload #14
      //   363: getfield itemView : Landroid/view/View;
      //   366: invokevirtual getBottom : ()I
      //   369: aload_1
      //   370: getfield itemView : Landroid/view/View;
      //   373: invokevirtual getBottom : ()I
      //   376: if_icmple -> 400
      //   379: iload #5
      //   381: invokestatic abs : (I)I
      //   384: istore #5
      //   386: iload #5
      //   388: iload #6
      //   390: if_icmple -> 400
      //   393: aload #14
      //   395: astore #16
      //   397: goto -> 404
      //   400: iload #6
      //   402: istore #5
      //   404: iload #7
      //   406: iconst_1
      //   407: iadd
      //   408: istore #7
      //   410: goto -> 58
      //   413: aload #16
      //   415: areturn
    }
    
    public void clearView(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder) {
      ItemTouchUIUtilImpl.a.clearView(param1ViewHolder.itemView);
    }
    
    public int convertToAbsoluteDirection(int param1Int1, int param1Int2) {
      int i = param1Int1 & 0x303030;
      if (i == 0)
        return param1Int1; 
      param1Int1 &= i;
      if (param1Int2 == 0) {
        param1Int2 = i >> 2;
        return param1Int1 | param1Int2;
      } 
      param1Int2 = i >> 1;
      param1Int1 |= 0xFFCFCFCF & param1Int2;
      param1Int2 = (param1Int2 & 0x303030) >> 2;
      return param1Int1 | param1Int2;
    }
    
    public long getAnimationDuration(RecyclerView param1RecyclerView, int param1Int, float param1Float1, float param1Float2) {
      RecyclerView.ItemAnimator itemAnimator = param1RecyclerView.getItemAnimator();
      return (itemAnimator == null) ? ((param1Int == 8) ? 200L : 250L) : ((param1Int == 8) ? itemAnimator.getMoveDuration() : itemAnimator.getRemoveDuration());
    }
    
    public int getBoundingBoxMargin() {
      return 0;
    }
    
    public float getMoveThreshold(RecyclerView.ViewHolder param1ViewHolder) {
      return 0.5F;
    }
    
    public abstract int getMovementFlags(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder);
    
    public float getSwipeEscapeVelocity(float param1Float) {
      return param1Float;
    }
    
    public float getSwipeThreshold(RecyclerView.ViewHolder param1ViewHolder) {
      return 0.5F;
    }
    
    public float getSwipeVelocityThreshold(float param1Float) {
      return param1Float;
    }
    
    public int interpolateOutOfBoundsScroll(RecyclerView param1RecyclerView, int param1Int1, int param1Int2, int param1Int3, long param1Long) {
      param1Int3 = a(param1RecyclerView);
      int i = Math.abs(param1Int2);
      int j = (int)Math.signum(param1Int2);
      float f2 = i;
      float f1 = 1.0F;
      f2 = Math.min(1.0F, f2 * 1.0F / param1Int1);
      param1Int1 = (int)((j * param1Int3) * b.getInterpolation(f2));
      if (param1Long <= 2000L)
        f1 = (float)param1Long / 2000.0F; 
      param1Int3 = (int)(param1Int1 * a.getInterpolation(f1));
      param1Int1 = param1Int3;
      if (param1Int3 == 0) {
        if (param1Int2 > 0)
          return 1; 
        param1Int1 = -1;
      } 
      return param1Int1;
    }
    
    public boolean isItemViewSwipeEnabled() {
      return true;
    }
    
    public boolean isLongPressDragEnabled() {
      return true;
    }
    
    public void onChildDraw(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder, float param1Float1, float param1Float2, int param1Int, boolean param1Boolean) {
      ItemTouchUIUtilImpl.a.onDraw(param1Canvas, param1RecyclerView, param1ViewHolder.itemView, param1Float1, param1Float2, param1Int, param1Boolean);
    }
    
    public void onChildDrawOver(Canvas param1Canvas, RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder, float param1Float1, float param1Float2, int param1Int, boolean param1Boolean) {
      ItemTouchUIUtilImpl.a.onDrawOver(param1Canvas, param1RecyclerView, param1ViewHolder.itemView, param1Float1, param1Float2, param1Int, param1Boolean);
    }
    
    public abstract boolean onMove(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder1, RecyclerView.ViewHolder param1ViewHolder2);
    
    public void onMoved(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder1, int param1Int1, RecyclerView.ViewHolder param1ViewHolder2, int param1Int2, int param1Int3, int param1Int4) {
      RecyclerView.LayoutManager layoutManager = param1RecyclerView.getLayoutManager();
      if (layoutManager instanceof ItemTouchHelper.ViewDropHandler) {
        ((ItemTouchHelper.ViewDropHandler)layoutManager).prepareForDrop(param1ViewHolder1.itemView, param1ViewHolder2.itemView, param1Int3, param1Int4);
        return;
      } 
      if (layoutManager.canScrollHorizontally()) {
        if (layoutManager.getDecoratedLeft(param1ViewHolder2.itemView) <= param1RecyclerView.getPaddingLeft())
          param1RecyclerView.scrollToPosition(param1Int2); 
        if (layoutManager.getDecoratedRight(param1ViewHolder2.itemView) >= param1RecyclerView.getWidth() - param1RecyclerView.getPaddingRight())
          param1RecyclerView.scrollToPosition(param1Int2); 
      } 
      if (layoutManager.canScrollVertically()) {
        if (layoutManager.getDecoratedTop(param1ViewHolder2.itemView) <= param1RecyclerView.getPaddingTop())
          param1RecyclerView.scrollToPosition(param1Int2); 
        if (layoutManager.getDecoratedBottom(param1ViewHolder2.itemView) >= param1RecyclerView.getHeight() - param1RecyclerView.getPaddingBottom())
          param1RecyclerView.scrollToPosition(param1Int2); 
      } 
    }
    
    public void onSelectedChanged(RecyclerView.ViewHolder param1ViewHolder, int param1Int) {
      if (param1ViewHolder != null)
        ItemTouchUIUtilImpl.a.onSelected(param1ViewHolder.itemView); 
    }
    
    public abstract void onSwiped(RecyclerView.ViewHolder param1ViewHolder, int param1Int);
  }
  
  static final class null implements Interpolator {
    public float getInterpolation(float param1Float) {
      return param1Float * param1Float * param1Float * param1Float * param1Float;
    }
  }
  
  static final class null implements Interpolator {
    public float getInterpolation(float param1Float) {
      param1Float--;
      return param1Float * param1Float * param1Float * param1Float * param1Float + 1.0F;
    }
  }
  
  class ItemTouchHelperGestureListener extends GestureDetector.SimpleOnGestureListener {
    private boolean b = true;
    
    ItemTouchHelperGestureListener(ItemTouchHelper this$0) {}
    
    void a() {
      this.b = false;
    }
    
    public boolean onDown(MotionEvent param1MotionEvent) {
      return true;
    }
    
    public void onLongPress(MotionEvent param1MotionEvent) {
      if (!this.b)
        return; 
      View view = this.a.a(param1MotionEvent);
      if (view != null) {
        RecyclerView.ViewHolder viewHolder = this.a.k.getChildViewHolder(view);
        if (viewHolder != null) {
          if (!this.a.h.b(this.a.k, viewHolder))
            return; 
          if (param1MotionEvent.getPointerId(0) == this.a.g) {
            int i = param1MotionEvent.findPointerIndex(this.a.g);
            float f1 = param1MotionEvent.getX(i);
            float f2 = param1MotionEvent.getY(i);
            ItemTouchHelper itemTouchHelper = this.a;
            itemTouchHelper.c = f1;
            itemTouchHelper.d = f2;
            itemTouchHelper.f = 0.0F;
            itemTouchHelper.e = 0.0F;
            if (itemTouchHelper.h.isLongPressDragEnabled())
              this.a.a(viewHolder, 2); 
          } 
        } 
      } 
    }
  }
  
  static class RecoverAnimation implements Animator.AnimatorListener {
    private final ValueAnimator a;
    
    private float b;
    
    final float d;
    
    final float e;
    
    final float f;
    
    final float g;
    
    final RecyclerView.ViewHolder h;
    
    final int i;
    
    final int j;
    
    boolean k;
    
    float l;
    
    float m;
    
    boolean n = false;
    
    boolean o = false;
    
    RecoverAnimation(RecyclerView.ViewHolder param1ViewHolder, int param1Int1, int param1Int2, float param1Float1, float param1Float2, float param1Float3, float param1Float4) {
      this.i = param1Int2;
      this.j = param1Int1;
      this.h = param1ViewHolder;
      this.d = param1Float1;
      this.e = param1Float2;
      this.f = param1Float3;
      this.g = param1Float4;
      this.a = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.a.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) {
            public void onAnimationUpdate(ValueAnimator param2ValueAnimator) {
              this.a.setFraction(param2ValueAnimator.getAnimatedFraction());
            }
          });
      this.a.setTarget(param1ViewHolder.itemView);
      this.a.addListener(this);
      setFraction(0.0F);
    }
    
    public void cancel() {
      this.a.cancel();
    }
    
    public void onAnimationCancel(Animator param1Animator) {
      setFraction(1.0F);
    }
    
    public void onAnimationEnd(Animator param1Animator) {
      if (!this.o)
        this.h.setIsRecyclable(true); 
      this.o = true;
    }
    
    public void onAnimationRepeat(Animator param1Animator) {}
    
    public void onAnimationStart(Animator param1Animator) {}
    
    public void setDuration(long param1Long) {
      this.a.setDuration(param1Long);
    }
    
    public void setFraction(float param1Float) {
      this.b = param1Float;
    }
    
    public void start() {
      this.h.setIsRecyclable(false);
      this.a.start();
    }
    
    public void update() {
      float f1 = this.d;
      float f2 = this.f;
      if (f1 == f2) {
        this.l = this.h.itemView.getTranslationX();
      } else {
        this.l = f1 + this.b * (f2 - f1);
      } 
      f1 = this.e;
      f2 = this.g;
      if (f1 == f2) {
        this.m = this.h.itemView.getTranslationY();
        return;
      } 
      this.m = f1 + this.b * (f2 - f1);
    }
  }
  
  class null implements ValueAnimator.AnimatorUpdateListener {
    null(ItemTouchHelper this$0) {}
    
    public void onAnimationUpdate(ValueAnimator param1ValueAnimator) {
      this.a.setFraction(param1ValueAnimator.getAnimatedFraction());
    }
  }
  
  public static abstract class SimpleCallback extends Callback {
    private int a;
    
    private int b;
    
    public SimpleCallback(int param1Int1, int param1Int2) {
      this.a = param1Int2;
      this.b = param1Int1;
    }
    
    public int getDragDirs(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder) {
      return this.b;
    }
    
    public int getMovementFlags(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder) {
      return makeMovementFlags(getDragDirs(param1RecyclerView, param1ViewHolder), getSwipeDirs(param1RecyclerView, param1ViewHolder));
    }
    
    public int getSwipeDirs(RecyclerView param1RecyclerView, RecyclerView.ViewHolder param1ViewHolder) {
      return this.a;
    }
    
    public void setDefaultDragDirs(int param1Int) {
      this.b = param1Int;
    }
    
    public void setDefaultSwipeDirs(int param1Int) {
      this.a = param1Int;
    }
  }
  
  public static interface ViewDropHandler {
    void prepareForDrop(View param1View1, View param1View2, int param1Int1, int param1Int2);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\ItemTouchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */