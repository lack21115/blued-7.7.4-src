package androidx.recyclerview.widget;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {
  public static final int INVALID_POSITION = -1;
  
  T[] a;
  
  private T[] b;
  
  private int c;
  
  private int d;
  
  private int e;
  
  private Callback f;
  
  private BatchedCallback g;
  
  private int h;
  
  private final Class<T> i;
  
  public SortedList(Class<T> paramClass, Callback<T> paramCallback) {
    this(paramClass, paramCallback, 10);
  }
  
  public SortedList(Class<T> paramClass, Callback<T> paramCallback, int paramInt) {
    this.i = paramClass;
    this.a = (T[])Array.newInstance(paramClass, paramInt);
    this.f = paramCallback;
    this.h = 0;
  }
  
  private int a(T paramT, int paramInt1, int paramInt2, int paramInt3) {
    int i;
    int j = paramInt1 - 1;
    while (true) {
      i = paramInt1;
      if (j >= paramInt2) {
        T t = this.a[j];
        if (this.f.compare(t, paramT) != 0) {
          i = paramInt1;
          break;
        } 
        if (this.f.areItemsTheSame(t, paramT))
          return j; 
        j--;
        continue;
      } 
      break;
    } 
    while (true) {
      paramInt1 = i + 1;
      if (paramInt1 < paramInt3) {
        T t = this.a[paramInt1];
        if (this.f.compare(t, paramT) != 0)
          break; 
        i = paramInt1;
        if (this.f.areItemsTheSame(t, paramT))
          return paramInt1; 
        continue;
      } 
      break;
    } 
    return -1;
  }
  
  private int a(T paramT, boolean paramBoolean) {
    int i;
    int j = a(paramT, this.a, 0, this.h, 1);
    if (j == -1) {
      i = 0;
    } else {
      i = j;
      if (j < this.h) {
        T t = this.a[j];
        i = j;
        if (this.f.areItemsTheSame(t, paramT)) {
          if (this.f.areContentsTheSame(t, paramT)) {
            this.a[j] = paramT;
            return j;
          } 
          this.a[j] = paramT;
          Callback<T> callback = this.f;
          callback.onChanged(j, 1, callback.getChangePayload(t, paramT));
          return j;
        } 
      } 
    } 
    a(i, paramT);
    if (paramBoolean)
      this.f.onInserted(i, 1); 
    return i;
  }
  
  private int a(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2) {
    while (paramInt1 < paramInt2) {
      if (this.f.areItemsTheSame(paramArrayOfT[paramInt1], paramT))
        return paramInt1; 
      paramInt1++;
    } 
    return -1;
  }
  
  private int a(T paramT, T[] paramArrayOfT, int paramInt1, int paramInt2, int paramInt3) {
    int i = paramInt1;
    while (i < paramInt2) {
      paramInt1 = (i + paramInt2) / 2;
      T t = paramArrayOfT[paramInt1];
      int j = this.f.compare(t, paramT);
      if (j < 0) {
        i = paramInt1 + 1;
        continue;
      } 
      if (j == 0) {
        if (this.f.areItemsTheSame(t, paramT))
          return paramInt1; 
        i = a(paramT, paramInt1, i, paramInt2);
        paramInt2 = i;
        if (paramInt3 == 1) {
          paramInt2 = i;
          if (i == -1)
            paramInt2 = paramInt1; 
        } 
        return paramInt2;
      } 
      paramInt2 = paramInt1;
    } 
    return (paramInt3 == 1) ? i : -1;
  }
  
  private void a() {
    this.h--;
    this.c++;
    this.f.onRemoved(this.e, 1);
  }
  
  private void a(int paramInt, T paramT) {
    int i = this.h;
    if (paramInt <= i) {
      T[] arrayOfT = this.a;
      if (i == arrayOfT.length) {
        arrayOfT = (T[])Array.newInstance(this.i, arrayOfT.length + 10);
        System.arraycopy(this.a, 0, arrayOfT, 0, paramInt);
        arrayOfT[paramInt] = paramT;
        System.arraycopy(this.a, paramInt, arrayOfT, paramInt + 1, this.h - paramInt);
        this.a = arrayOfT;
      } else {
        System.arraycopy(arrayOfT, paramInt, arrayOfT, paramInt + 1, i - paramInt);
        this.a[paramInt] = paramT;
      } 
      this.h++;
      return;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("cannot add item to ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" because size is ");
    stringBuilder.append(this.h);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  private void a(int paramInt, boolean paramBoolean) {
    T[] arrayOfT = this.a;
    System.arraycopy(arrayOfT, paramInt + 1, arrayOfT, paramInt, this.h - paramInt - 1);
    this.h--;
    this.a[this.h] = null;
    if (paramBoolean)
      this.f.onRemoved(paramInt, 1); 
  }
  
  private void a(T paramT) {
    T[] arrayOfT = this.a;
    int i = this.e;
    arrayOfT[i] = paramT;
    this.e = i + 1;
    this.h++;
    this.f.onInserted(this.e - 1, 1);
  }
  
  private void a(T[] paramArrayOfT) {
    if (paramArrayOfT.length < 1)
      return; 
    int i = c(paramArrayOfT);
    if (this.h == 0) {
      this.a = paramArrayOfT;
      this.h = i;
      this.f.onInserted(0, i);
      return;
    } 
    a(paramArrayOfT, i);
  }
  
  private void a(T[] paramArrayOfT, int paramInt) {
    int k = this.f instanceof BatchedCallback ^ true;
    if (k != 0)
      beginBatchedUpdates(); 
    this.b = this.a;
    int i = 0;
    this.c = 0;
    int j = this.h;
    this.d = j;
    this.a = (T[])Array.newInstance(this.i, j + paramInt + 10);
    this.e = 0;
    while (true) {
      if (this.c < this.d || i < paramInt) {
        j = this.c;
        int m = this.d;
        if (j == m) {
          paramInt -= i;
          System.arraycopy(paramArrayOfT, i, this.a, this.e, paramInt);
          this.e += paramInt;
          this.h += paramInt;
          this.f.onInserted(this.e - paramInt, paramInt);
        } else if (i == paramInt) {
          paramInt = m - j;
          System.arraycopy(this.b, j, this.a, this.e, paramInt);
          this.e += paramInt;
        } else {
          T[] arrayOfT1;
          T t1 = this.b[j];
          T t2 = paramArrayOfT[i];
          j = this.f.compare(t1, t2);
          if (j > 0) {
            arrayOfT1 = this.a;
            j = this.e;
            this.e = j + 1;
            arrayOfT1[j] = t2;
            this.h++;
            i++;
            this.f.onInserted(this.e - 1, 1);
            continue;
          } 
          if (j == 0 && this.f.areItemsTheSame(arrayOfT1, (T[])t2)) {
            T[] arrayOfT = this.a;
            j = this.e;
            this.e = j + 1;
            arrayOfT[j] = t2;
            j = i + 1;
            this.c++;
            i = j;
            if (!this.f.areContentsTheSame(arrayOfT1, (T[])t2)) {
              Callback<T[]> callback = this.f;
              callback.onChanged(this.e - 1, 1, callback.getChangePayload(arrayOfT1, (T[])t2));
              i = j;
            } 
            continue;
          } 
          T[] arrayOfT2 = this.a;
          j = this.e;
          this.e = j + 1;
          arrayOfT2[j] = (T)arrayOfT1;
          this.c++;
          continue;
        } 
      } 
      this.b = null;
      if (k != 0)
        endBatchedUpdates(); 
      return;
    } 
  }
  
  private void b() {
    if (this.b == null)
      return; 
    throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
  }
  
  private void b(T[] paramArrayOfT) {
    int i = this.f instanceof BatchedCallback ^ true;
    if (i != 0)
      beginBatchedUpdates(); 
    this.c = 0;
    this.d = this.h;
    this.b = this.a;
    this.e = 0;
    int j = c(paramArrayOfT);
    this.a = (T[])Array.newInstance(this.i, j);
    while (true) {
      if (this.e < j || this.c < this.d) {
        int k = this.c;
        int m = this.d;
        if (k >= m) {
          int n = this.e;
          j -= n;
          System.arraycopy(paramArrayOfT, n, this.a, n, j);
          this.e += j;
          this.h += j;
          this.f.onInserted(n, j);
        } else {
          int n = this.e;
          if (n >= j) {
            j = m - k;
            this.h -= j;
            this.f.onRemoved(n, j);
          } else {
            T t1 = this.b[k];
            T t2 = paramArrayOfT[n];
            n = this.f.compare(t1, t2);
            if (n < 0) {
              a();
              continue;
            } 
            if (n > 0) {
              a(t2);
              continue;
            } 
            if (!this.f.areItemsTheSame(t1, t2)) {
              a();
              a(t2);
              continue;
            } 
            T[] arrayOfT = this.a;
            n = this.e;
            arrayOfT[n] = t2;
            this.c++;
            this.e = n + 1;
            if (!this.f.areContentsTheSame(t1, t2)) {
              Callback<T> callback = this.f;
              callback.onChanged(this.e - 1, 1, callback.getChangePayload(t1, t2));
            } 
            continue;
          } 
        } 
      } 
      this.b = null;
      if (i != 0)
        endBatchedUpdates(); 
      return;
    } 
  }
  
  private boolean b(T paramT, boolean paramBoolean) {
    int i = a(paramT, this.a, 0, this.h, 2);
    if (i == -1)
      return false; 
    a(i, paramBoolean);
    return true;
  }
  
  private int c(T[] paramArrayOfT) {
    if (paramArrayOfT.length == 0)
      return 0; 
    Arrays.sort(paramArrayOfT, this.f);
    int j = 1;
    int i = 1;
    int k = 0;
    while (j < paramArrayOfT.length) {
      T t = paramArrayOfT[j];
      if (this.f.compare(paramArrayOfT[k], t) == 0) {
        int m = a(t, paramArrayOfT, k, i);
        if (m != -1) {
          paramArrayOfT[m] = t;
        } else {
          if (i != j)
            paramArrayOfT[i] = t; 
          i++;
        } 
      } else {
        if (i != j)
          paramArrayOfT[i] = t; 
        k = i;
        i++;
      } 
      j++;
    } 
    return i;
  }
  
  private T[] d(T[] paramArrayOfT) {
    Object[] arrayOfObject = (Object[])Array.newInstance(this.i, paramArrayOfT.length);
    System.arraycopy(paramArrayOfT, 0, arrayOfObject, 0, paramArrayOfT.length);
    return (T[])arrayOfObject;
  }
  
  public int add(T paramT) {
    b();
    return a(paramT, true);
  }
  
  public void addAll(Collection<T> paramCollection) {
    addAll(paramCollection.toArray((T[])Array.newInstance(this.i, paramCollection.size())), true);
  }
  
  public void addAll(T... paramVarArgs) {
    addAll(paramVarArgs, false);
  }
  
  public void addAll(T[] paramArrayOfT, boolean paramBoolean) {
    b();
    if (paramArrayOfT.length == 0)
      return; 
    if (paramBoolean) {
      a(paramArrayOfT);
      return;
    } 
    a(d(paramArrayOfT));
  }
  
  public void beginBatchedUpdates() {
    b();
    Callback<?> callback = this.f;
    if (callback instanceof BatchedCallback)
      return; 
    if (this.g == null)
      this.g = new BatchedCallback(callback); 
    this.f = this.g;
  }
  
  public void clear() {
    b();
    int i = this.h;
    if (i == 0)
      return; 
    Arrays.fill((Object[])this.a, 0, i, (Object)null);
    this.h = 0;
    this.f.onRemoved(0, i);
  }
  
  public void endBatchedUpdates() {
    b();
    Callback callback = this.f;
    if (callback instanceof BatchedCallback)
      ((BatchedCallback)callback).dispatchLastEvent(); 
    callback = this.f;
    BatchedCallback batchedCallback = this.g;
    if (callback == batchedCallback)
      this.f = batchedCallback.a; 
  }
  
  public T get(int paramInt) throws IndexOutOfBoundsException {
    if (paramInt < this.h && paramInt >= 0) {
      T[] arrayOfT = this.b;
      if (arrayOfT != null) {
        int i = this.e;
        if (paramInt >= i)
          return arrayOfT[paramInt - i + this.c]; 
      } 
      return this.a[paramInt];
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Asked to get item at ");
    stringBuilder.append(paramInt);
    stringBuilder.append(" but size is ");
    stringBuilder.append(this.h);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  public int indexOf(T paramT) {
    if (this.b != null) {
      int i = a(paramT, this.a, 0, this.e, 4);
      if (i != -1)
        return i; 
      i = a(paramT, this.b, this.c, this.d, 4);
      return (i != -1) ? (i - this.c + this.e) : -1;
    } 
    return a(paramT, this.a, 0, this.h, 4);
  }
  
  public void recalculatePositionOfItemAt(int paramInt) {
    b();
    T t = get(paramInt);
    a(paramInt, false);
    int i = a(t, false);
    if (paramInt != i)
      this.f.onMoved(paramInt, i); 
  }
  
  public boolean remove(T paramT) {
    b();
    return b(paramT, true);
  }
  
  public T removeItemAt(int paramInt) {
    b();
    T t = get(paramInt);
    a(paramInt, true);
    return t;
  }
  
  public void replaceAll(Collection<T> paramCollection) {
    replaceAll(paramCollection.toArray((T[])Array.newInstance(this.i, paramCollection.size())), true);
  }
  
  public void replaceAll(T... paramVarArgs) {
    replaceAll(paramVarArgs, false);
  }
  
  public void replaceAll(T[] paramArrayOfT, boolean paramBoolean) {
    b();
    if (paramBoolean) {
      b(paramArrayOfT);
      return;
    } 
    b(d(paramArrayOfT));
  }
  
  public int size() {
    return this.h;
  }
  
  public void updateItemAt(int paramInt, T paramT) {
    b();
    T t = get(paramInt);
    if (t == paramT || !this.f.areContentsTheSame(t, paramT)) {
      i = 1;
    } else {
      i = 0;
    } 
    if (t != paramT && this.f.compare(t, paramT) == 0) {
      this.a[paramInt] = paramT;
      if (i) {
        Callback<T> callback = this.f;
        callback.onChanged(paramInt, 1, callback.getChangePayload(t, paramT));
      } 
      return;
    } 
    if (i) {
      Callback<T> callback = this.f;
      callback.onChanged(paramInt, 1, callback.getChangePayload(t, paramT));
    } 
    a(paramInt, false);
    int i = a(paramT, false);
    if (paramInt != i)
      this.f.onMoved(paramInt, i); 
  }
  
  public static class BatchedCallback<T2> extends Callback<T2> {
    final SortedList.Callback<T2> a;
    
    private final BatchingListUpdateCallback b;
    
    public BatchedCallback(SortedList.Callback<T2> param1Callback) {
      this.a = param1Callback;
      this.b = new BatchingListUpdateCallback(this.a);
    }
    
    public boolean areContentsTheSame(T2 param1T21, T2 param1T22) {
      return this.a.areContentsTheSame(param1T21, param1T22);
    }
    
    public boolean areItemsTheSame(T2 param1T21, T2 param1T22) {
      return this.a.areItemsTheSame(param1T21, param1T22);
    }
    
    public int compare(T2 param1T21, T2 param1T22) {
      return this.a.compare(param1T21, param1T22);
    }
    
    public void dispatchLastEvent() {
      this.b.dispatchLastEvent();
    }
    
    public Object getChangePayload(T2 param1T21, T2 param1T22) {
      return this.a.getChangePayload(param1T21, param1T22);
    }
    
    public void onChanged(int param1Int1, int param1Int2) {
      this.b.onChanged(param1Int1, param1Int2, null);
    }
    
    public void onChanged(int param1Int1, int param1Int2, Object param1Object) {
      this.b.onChanged(param1Int1, param1Int2, param1Object);
    }
    
    public void onInserted(int param1Int1, int param1Int2) {
      this.b.onInserted(param1Int1, param1Int2);
    }
    
    public void onMoved(int param1Int1, int param1Int2) {
      this.b.onMoved(param1Int1, param1Int2);
    }
    
    public void onRemoved(int param1Int1, int param1Int2) {
      this.b.onRemoved(param1Int1, param1Int2);
    }
  }
  
  public static abstract class Callback<T2> implements ListUpdateCallback, Comparator<T2> {
    public abstract boolean areContentsTheSame(T2 param1T21, T2 param1T22);
    
    public abstract boolean areItemsTheSame(T2 param1T21, T2 param1T22);
    
    public abstract int compare(T2 param1T21, T2 param1T22);
    
    public Object getChangePayload(T2 param1T21, T2 param1T22) {
      return null;
    }
    
    public abstract void onChanged(int param1Int1, int param1Int2);
    
    public void onChanged(int param1Int1, int param1Int2, Object param1Object) {
      onChanged(param1Int1, param1Int2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\SortedList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */