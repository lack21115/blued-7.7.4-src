package androidx.customview.widget;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy {
  private static int a(int paramInt1, int paramInt2) {
    return paramInt1 * 13 * paramInt1 + paramInt2 * paramInt2;
  }
  
  private static <T> T a(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean) {
    int i;
    int j = paramArrayList.size();
    if (paramT == null) {
      i = -1;
    } else {
      i = paramArrayList.lastIndexOf(paramT);
    } 
    return (++i < j) ? paramArrayList.get(i) : ((paramBoolean && j > 0) ? paramArrayList.get(0) : null);
  }
  
  private static boolean a(int paramInt, Rect paramRect1, Rect paramRect2) {
    // Byte code:
    //   0: iload_0
    //   1: bipush #17
    //   3: if_icmpeq -> 64
    //   6: iload_0
    //   7: bipush #33
    //   9: if_icmpeq -> 38
    //   12: iload_0
    //   13: bipush #66
    //   15: if_icmpeq -> 64
    //   18: iload_0
    //   19: sipush #130
    //   22: if_icmpne -> 28
    //   25: goto -> 38
    //   28: new java/lang/IllegalArgumentException
    //   31: dup
    //   32: ldc 'direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.'
    //   34: invokespecial <init> : (Ljava/lang/String;)V
    //   37: athrow
    //   38: aload_2
    //   39: getfield right : I
    //   42: aload_1
    //   43: getfield left : I
    //   46: if_icmplt -> 62
    //   49: aload_2
    //   50: getfield left : I
    //   53: aload_1
    //   54: getfield right : I
    //   57: if_icmpgt -> 62
    //   60: iconst_1
    //   61: ireturn
    //   62: iconst_0
    //   63: ireturn
    //   64: aload_2
    //   65: getfield bottom : I
    //   68: aload_1
    //   69: getfield top : I
    //   72: if_icmplt -> 88
    //   75: aload_2
    //   76: getfield top : I
    //   79: aload_1
    //   80: getfield bottom : I
    //   83: if_icmpgt -> 88
    //   86: iconst_1
    //   87: ireturn
    //   88: iconst_0
    //   89: ireturn
  }
  
  private static boolean a(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3) {
    boolean bool1 = a(paramRect1, paramRect2, paramInt);
    boolean bool = false;
    if (!bool1)
      return false; 
    if (!a(paramRect1, paramRect3, paramInt))
      return true; 
    if (b(paramInt, paramRect1, paramRect2, paramRect3))
      return true; 
    if (b(paramInt, paramRect1, paramRect3, paramRect2))
      return false; 
    if (a(c(paramInt, paramRect1, paramRect2), g(paramInt, paramRect1, paramRect2)) < a(c(paramInt, paramRect1, paramRect3), g(paramInt, paramRect1, paramRect3)))
      bool = true; 
    return bool;
  }
  
  private static boolean a(Rect paramRect1, Rect paramRect2, int paramInt) {
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130)
            return ((paramRect1.top < paramRect2.top || paramRect1.bottom <= paramRect2.top) && paramRect1.bottom < paramRect2.bottom); 
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } 
        return ((paramRect1.left < paramRect2.left || paramRect1.right <= paramRect2.left) && paramRect1.right < paramRect2.right);
      } 
      return ((paramRect1.bottom > paramRect2.bottom || paramRect1.top >= paramRect2.bottom) && paramRect1.top > paramRect2.top);
    } 
    return ((paramRect1.right > paramRect2.right || paramRect1.left >= paramRect2.right) && paramRect1.left > paramRect2.left);
  }
  
  private static <T> T b(T paramT, ArrayList<T> paramArrayList, boolean paramBoolean) {
    int i;
    int j = paramArrayList.size();
    if (paramT == null) {
      i = j;
    } else {
      i = paramArrayList.indexOf(paramT);
    } 
    return (--i >= 0) ? paramArrayList.get(i) : ((paramBoolean && j > 0) ? paramArrayList.get(j - 1) : null);
  }
  
  private static boolean b(int paramInt, Rect paramRect1, Rect paramRect2) {
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130)
            return (paramRect1.bottom <= paramRect2.top); 
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } 
        return (paramRect1.right <= paramRect2.left);
      } 
      return (paramRect1.top >= paramRect2.bottom);
    } 
    return (paramRect1.left >= paramRect2.right);
  }
  
  private static boolean b(int paramInt, Rect paramRect1, Rect paramRect2, Rect paramRect3) {
    boolean bool = a(paramInt, paramRect1, paramRect2);
    if (!a(paramInt, paramRect1, paramRect3)) {
      if (!bool)
        return false; 
      boolean bool1 = b(paramInt, paramRect1, paramRect3);
      bool = true;
      if (!bool1)
        return true; 
      if (paramInt != 17) {
        if (paramInt == 66)
          return true; 
        if (c(paramInt, paramRect1, paramRect2) < e(paramInt, paramRect1, paramRect3))
          return true; 
        bool = false;
      } 
      return bool;
    } 
    return false;
  }
  
  private static int c(int paramInt, Rect paramRect1, Rect paramRect2) {
    return Math.max(0, d(paramInt, paramRect1, paramRect2));
  }
  
  private static int d(int paramInt, Rect paramRect1, Rect paramRect2) {
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130) {
            paramInt = paramRect2.top;
            int m = paramRect1.bottom;
            return paramInt - m;
          } 
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } 
        paramInt = paramRect2.left;
        int k = paramRect1.right;
        return paramInt - k;
      } 
      paramInt = paramRect1.top;
      int j = paramRect2.bottom;
      return paramInt - j;
    } 
    paramInt = paramRect1.left;
    int i = paramRect2.right;
    return paramInt - i;
  }
  
  private static int e(int paramInt, Rect paramRect1, Rect paramRect2) {
    return Math.max(1, f(paramInt, paramRect1, paramRect2));
  }
  
  private static int f(int paramInt, Rect paramRect1, Rect paramRect2) {
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130) {
            paramInt = paramRect2.bottom;
            int m = paramRect1.bottom;
            return paramInt - m;
          } 
          throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        } 
        paramInt = paramRect2.right;
        int k = paramRect1.right;
        return paramInt - k;
      } 
      paramInt = paramRect1.top;
      int j = paramRect2.top;
      return paramInt - j;
    } 
    paramInt = paramRect1.left;
    int i = paramRect2.left;
    return paramInt - i;
  }
  
  public static <L, T> T findNextFocusInAbsoluteDirection(L paramL, CollectionAdapter<L, T> paramCollectionAdapter, BoundsAdapter<T> paramBoundsAdapter, T paramT, Rect paramRect, int paramInt) {
    T t;
    Rect rect1 = new Rect(paramRect);
    int i = 0;
    if (paramInt != 17) {
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt == 130) {
            rect1.offset(0, -(paramRect.height() + 1));
          } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
          } 
        } else {
          rect1.offset(-(paramRect.width() + 1), 0);
        } 
      } else {
        rect1.offset(0, paramRect.height() + 1);
      } 
    } else {
      rect1.offset(paramRect.width() + 1, 0);
    } 
    Object object = null;
    int j = paramCollectionAdapter.size(paramL);
    Rect rect2 = new Rect();
    while (i < j) {
      T t1 = paramCollectionAdapter.get(paramL, i);
      if (t1 != paramT) {
        paramBoundsAdapter.obtainBounds(t1, rect2);
        if (a(paramInt, paramRect, rect2, rect1)) {
          rect1.set(rect2);
          t = t1;
        } 
      } 
      i++;
    } 
    return t;
  }
  
  public static <L, T> T findNextFocusInRelativeDirection(L paramL, CollectionAdapter<L, T> paramCollectionAdapter, BoundsAdapter<T> paramBoundsAdapter, T paramT, int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
    int j = paramCollectionAdapter.size(paramL);
    ArrayList<?> arrayList = new ArrayList(j);
    int i;
    for (i = 0; i < j; i++)
      arrayList.add(paramCollectionAdapter.get(paramL, i)); 
    Collections.sort(arrayList, new SequentialComparator(paramBoolean1, paramBoundsAdapter));
    if (paramInt != 1) {
      if (paramInt == 2)
        return a(paramT, (ArrayList)arrayList, paramBoolean2); 
      throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    } 
    return b(paramT, (ArrayList)arrayList, paramBoolean2);
  }
  
  private static int g(int paramInt, Rect paramRect1, Rect paramRect2) {
    if (paramInt != 17)
      if (paramInt != 33) {
        if (paramInt != 66) {
          if (paramInt != 130)
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."); 
          return Math.abs(paramRect1.left + paramRect1.width() / 2 - paramRect2.left + paramRect2.width() / 2);
        } 
      } else {
        return Math.abs(paramRect1.left + paramRect1.width() / 2 - paramRect2.left + paramRect2.width() / 2);
      }  
    return Math.abs(paramRect1.top + paramRect1.height() / 2 - paramRect2.top + paramRect2.height() / 2);
  }
  
  public static interface BoundsAdapter<T> {
    void obtainBounds(T param1T, Rect param1Rect);
  }
  
  public static interface CollectionAdapter<T, V> {
    V get(T param1T, int param1Int);
    
    int size(T param1T);
  }
  
  static class SequentialComparator<T> implements Comparator<T> {
    private final Rect a = new Rect();
    
    private final Rect b = new Rect();
    
    private final boolean c;
    
    private final FocusStrategy.BoundsAdapter<T> d;
    
    SequentialComparator(boolean param1Boolean, FocusStrategy.BoundsAdapter<T> param1BoundsAdapter) {
      this.c = param1Boolean;
      this.d = param1BoundsAdapter;
    }
    
    public int compare(T param1T1, T param1T2) {
      Rect rect1 = this.a;
      Rect rect2 = this.b;
      this.d.obtainBounds(param1T1, rect1);
      this.d.obtainBounds(param1T2, rect2);
      int i = rect1.top;
      int j = rect2.top;
      byte b = -1;
      if (i < j)
        return -1; 
      if (rect1.top > rect2.top)
        return 1; 
      if (rect1.left < rect2.left) {
        if (this.c)
          b = 1; 
        return b;
      } 
      if (rect1.left > rect2.left)
        return this.c ? -1 : 1; 
      if (rect1.bottom < rect2.bottom)
        return -1; 
      if (rect1.bottom > rect2.bottom)
        return 1; 
      if (rect1.right < rect2.right) {
        if (this.c)
          b = 1; 
        return b;
      } 
      return (rect1.right > rect2.right) ? (this.c ? -1 : 1) : 0;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\customview\widget\FocusStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */