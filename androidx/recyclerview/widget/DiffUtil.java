package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DiffUtil {
  private static final Comparator<Snake> a = new Comparator<Snake>() {
      public int compare(DiffUtil.Snake param1Snake1, DiffUtil.Snake param1Snake2) {
        int j = param1Snake1.a - param1Snake2.a;
        int i = j;
        if (j == 0)
          i = param1Snake1.b - param1Snake2.b; 
        return i;
      }
    };
  
  private static Snake a(Callback paramCallback, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint1, int[] paramArrayOfint2, int paramInt5) {
    paramInt2 -= paramInt1;
    int k = paramInt4 - paramInt3;
    if (paramInt2 < 1 || k < 1)
      return null; 
    int m = paramInt2 - k;
    int n = (paramInt2 + k + 1) / 2;
    paramInt4 = paramInt5 - n - 1;
    int i = paramInt5 + n + 1;
    Arrays.fill(paramArrayOfint1, paramInt4, i, 0);
    Arrays.fill(paramArrayOfint2, paramInt4 + m, i + m, paramInt2);
    if (m % 2 != 0) {
      i = 1;
    } else {
      i = 0;
    } 
    int j;
    for (j = 0; j <= n; j++) {
      int i1 = -j;
      int i2 = i1;
      while (true)
        i2 += 2; 
      i2 = i1;
      while (true)
        i2 += 2; 
      continue;
    } 
    throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
  }
  
  public static DiffResult calculateDiff(Callback paramCallback) {
    return calculateDiff(paramCallback, true);
  }
  
  public static DiffResult calculateDiff(Callback paramCallback, boolean paramBoolean) {
    int i = paramCallback.getOldListSize();
    int j = paramCallback.getNewListSize();
    ArrayList<Snake> arrayList = new ArrayList();
    ArrayList<Range> arrayList1 = new ArrayList();
    arrayList1.add(new Range(0, i, 0, j));
    i = Math.abs(i - j) + i + j;
    j = i * 2;
    int[] arrayOfInt1 = new int[j];
    int[] arrayOfInt2 = new int[j];
    ArrayList<Range> arrayList2 = new ArrayList();
    while (!arrayList1.isEmpty()) {
      Range range = arrayList1.remove(arrayList1.size() - 1);
      Snake snake = a(paramCallback, range.a, range.b, range.c, range.d, arrayOfInt1, arrayOfInt2, i);
      if (snake != null) {
        Range range1;
        if (snake.c > 0)
          arrayList.add(snake); 
        snake.a += range.a;
        snake.b += range.c;
        if (arrayList2.isEmpty()) {
          range1 = new Range();
        } else {
          range1 = arrayList2.remove(arrayList2.size() - 1);
        } 
        range1.a = range.a;
        range1.c = range.c;
        if (snake.e) {
          range1.b = snake.a;
          range1.d = snake.b;
        } else if (snake.d) {
          range1.b = snake.a - 1;
          range1.d = snake.b;
        } else {
          range1.b = snake.a;
          range1.d = snake.b - 1;
        } 
        arrayList1.add(range1);
        if (snake.e) {
          if (snake.d) {
            range.a = snake.a + snake.c + 1;
            range.c = snake.b + snake.c;
          } else {
            range.a = snake.a + snake.c;
            range.c = snake.b + snake.c + 1;
          } 
        } else {
          range.a = snake.a + snake.c;
          range.c = snake.b + snake.c;
        } 
        arrayList1.add(range);
        continue;
      } 
      arrayList2.add(range);
    } 
    Collections.sort(arrayList, a);
    return new DiffResult(paramCallback, arrayList, arrayOfInt1, arrayOfInt2, paramBoolean);
  }
  
  public static abstract class Callback {
    public abstract boolean areContentsTheSame(int param1Int1, int param1Int2);
    
    public abstract boolean areItemsTheSame(int param1Int1, int param1Int2);
    
    public Object getChangePayload(int param1Int1, int param1Int2) {
      return null;
    }
    
    public abstract int getNewListSize();
    
    public abstract int getOldListSize();
  }
  
  public static class DiffResult {
    public static final int NO_POSITION = -1;
    
    private final List<DiffUtil.Snake> a;
    
    private final int[] b;
    
    private final int[] c;
    
    private final DiffUtil.Callback d;
    
    private final int e;
    
    private final int f;
    
    private final boolean g;
    
    DiffResult(DiffUtil.Callback param1Callback, List<DiffUtil.Snake> param1List, int[] param1ArrayOfint1, int[] param1ArrayOfint2, boolean param1Boolean) {
      this.a = param1List;
      this.b = param1ArrayOfint1;
      this.c = param1ArrayOfint2;
      Arrays.fill(this.b, 0);
      Arrays.fill(this.c, 0);
      this.d = param1Callback;
      this.e = param1Callback.getOldListSize();
      this.f = param1Callback.getNewListSize();
      this.g = param1Boolean;
      a();
      b();
    }
    
    private static DiffUtil.PostponedUpdate a(List<DiffUtil.PostponedUpdate> param1List, int param1Int, boolean param1Boolean) {
      for (int i = param1List.size() - 1; i >= 0; i--) {
        DiffUtil.PostponedUpdate postponedUpdate = param1List.get(i);
        if (postponedUpdate.a == param1Int && postponedUpdate.c == param1Boolean) {
          param1List.remove(i);
          while (i < param1List.size()) {
            DiffUtil.PostponedUpdate postponedUpdate1 = param1List.get(i);
            int j = postponedUpdate1.b;
            if (param1Boolean) {
              param1Int = 1;
            } else {
              param1Int = -1;
            } 
            postponedUpdate1.b = j + param1Int;
            i++;
          } 
          return postponedUpdate;
        } 
      } 
      return null;
    }
    
    private void a() {
      DiffUtil.Snake snake;
      if (this.a.isEmpty()) {
        snake = null;
      } else {
        snake = this.a.get(0);
      } 
      if (snake == null || snake.a != 0 || snake.b != 0) {
        snake = new DiffUtil.Snake();
        snake.a = 0;
        snake.b = 0;
        snake.d = false;
        snake.c = 0;
        snake.e = false;
        this.a.add(0, snake);
      } 
    }
    
    private void a(int param1Int1, int param1Int2, int param1Int3) {
      if (this.b[param1Int1 - 1] != 0)
        return; 
      a(param1Int1, param1Int2, param1Int3, false);
    }
    
    private void a(List<DiffUtil.PostponedUpdate> param1List, ListUpdateCallback param1ListUpdateCallback, int param1Int1, int param1Int2, int param1Int3) {
      if (!this.g) {
        param1ListUpdateCallback.onInserted(param1Int1, param1Int2);
        return;
      } 
      while (--param1Int2 >= 0) {
        StringBuilder stringBuilder;
        int[] arrayOfInt = this.c;
        int i = param1Int3 + param1Int2;
        int j = arrayOfInt[i] & 0x1F;
        if (j != 0) {
          if (j != 4 && j != 8) {
            if (j == 16) {
              param1List.add(new DiffUtil.PostponedUpdate(i, param1Int1, false));
            } else {
              stringBuilder = new StringBuilder();
              stringBuilder.append("unknown flag for pos ");
              stringBuilder.append(i);
              stringBuilder.append(" ");
              stringBuilder.append(Long.toBinaryString(j));
              throw new IllegalStateException(stringBuilder.toString());
            } 
          } else {
            int k = this.c[i] >> 5;
            param1ListUpdateCallback.onMoved((a((List<DiffUtil.PostponedUpdate>)stringBuilder, k, true)).b, param1Int1);
            if (j == 4)
              param1ListUpdateCallback.onChanged(param1Int1, 1, this.d.getChangePayload(k, i)); 
          } 
        } else {
          param1ListUpdateCallback.onInserted(param1Int1, 1);
          for (DiffUtil.PostponedUpdate postponedUpdate : stringBuilder)
            postponedUpdate.b++; 
        } 
        param1Int2--;
      } 
    }
    
    private boolean a(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
      int i;
      int j;
      if (param1Boolean) {
        i = param1Int2 - 1;
        param1Int2 = param1Int1;
        j = i;
      } else {
        int k = param1Int1 - 1;
        j = k;
        i = param1Int2;
        param1Int2 = k;
      } 
      while (param1Int3 >= 0) {
        int[] arrayOfInt;
        DiffUtil.Snake snake = this.a.get(param1Int3);
        int k = snake.a;
        int m = snake.c;
        int n = snake.b;
        int i1 = snake.c;
        byte b = 8;
        if (param1Boolean) {
          while (--param1Int2 >= k + m) {
            if (this.d.areItemsTheSame(param1Int2, j)) {
              if (!this.d.areContentsTheSame(param1Int2, j))
                b = 4; 
              this.c[j] = param1Int2 << 5 | 0x10;
              this.b[param1Int2] = j << 5 | b;
              return true;
            } 
            param1Int2--;
          } 
        } else {
          for (param1Int2 = i - 1; param1Int2 >= n + i1; param1Int2--) {
            if (this.d.areItemsTheSame(j, param1Int2)) {
              if (!this.d.areContentsTheSame(j, param1Int2))
                b = 4; 
              arrayOfInt = this.b;
              arrayOfInt[--param1Int1] = param1Int2 << 5 | 0x10;
              this.c[param1Int2] = param1Int1 << 5 | b;
              return true;
            } 
          } 
        } 
        param1Int2 = ((DiffUtil.Snake)arrayOfInt).a;
        i = ((DiffUtil.Snake)arrayOfInt).b;
        param1Int3--;
      } 
      return false;
    }
    
    private void b() {
      int j = this.e;
      int i = this.f;
      for (int k = this.a.size() - 1; k >= 0; k--) {
        DiffUtil.Snake snake = this.a.get(k);
        int i1 = snake.a;
        int i2 = snake.c;
        int m = snake.b;
        int n = snake.c;
        if (this.g) {
          int i3;
          while (true) {
            i3 = i;
            if (j > i1 + i2) {
              a(j, i, k);
              j--;
              continue;
            } 
            break;
          } 
          while (i3 > m + n) {
            b(j, i3, k);
            i3--;
          } 
        } 
        for (i = 0; i < snake.c; i++) {
          int i3 = snake.a + i;
          m = snake.b + i;
          if (this.d.areContentsTheSame(i3, m)) {
            j = 1;
          } else {
            j = 2;
          } 
          this.b[i3] = m << 5 | j;
          this.c[m] = i3 << 5 | j;
        } 
        j = snake.a;
        i = snake.b;
      } 
    }
    
    private void b(int param1Int1, int param1Int2, int param1Int3) {
      if (this.c[param1Int2 - 1] != 0)
        return; 
      a(param1Int1, param1Int2, param1Int3, true);
    }
    
    private void b(List<DiffUtil.PostponedUpdate> param1List, ListUpdateCallback param1ListUpdateCallback, int param1Int1, int param1Int2, int param1Int3) {
      if (!this.g) {
        param1ListUpdateCallback.onRemoved(param1Int1, param1Int2);
        return;
      } 
      while (--param1Int2 >= 0) {
        StringBuilder stringBuilder;
        int[] arrayOfInt = this.b;
        int i = param1Int3 + param1Int2;
        int j = arrayOfInt[i] & 0x1F;
        if (j != 0) {
          if (j != 4 && j != 8) {
            if (j == 16) {
              param1List.add(new DiffUtil.PostponedUpdate(i, param1Int1 + param1Int2, true));
            } else {
              stringBuilder = new StringBuilder();
              stringBuilder.append("unknown flag for pos ");
              stringBuilder.append(i);
              stringBuilder.append(" ");
              stringBuilder.append(Long.toBinaryString(j));
              throw new IllegalStateException(stringBuilder.toString());
            } 
          } else {
            int k = this.b[i] >> 5;
            DiffUtil.PostponedUpdate postponedUpdate = a((List<DiffUtil.PostponedUpdate>)stringBuilder, k, false);
            param1ListUpdateCallback.onMoved(param1Int1 + param1Int2, postponedUpdate.b - 1);
            if (j == 4)
              param1ListUpdateCallback.onChanged(postponedUpdate.b - 1, 1, this.d.getChangePayload(i, k)); 
          } 
        } else {
          param1ListUpdateCallback.onRemoved(param1Int1 + param1Int2, 1);
          for (DiffUtil.PostponedUpdate postponedUpdate : stringBuilder)
            postponedUpdate.b--; 
        } 
        param1Int2--;
      } 
    }
    
    public int convertNewPositionToOld(int param1Int) {
      if (param1Int >= 0 && param1Int < this.f) {
        param1Int = this.c[param1Int];
        return ((param1Int & 0x1F) == 0) ? -1 : (param1Int >> 5);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Index out of bounds - passed position = ");
      stringBuilder.append(param1Int);
      stringBuilder.append(", new list size = ");
      stringBuilder.append(this.f);
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    public int convertOldPositionToNew(int param1Int) {
      if (param1Int >= 0 && param1Int < this.e) {
        param1Int = this.b[param1Int];
        return ((param1Int & 0x1F) == 0) ? -1 : (param1Int >> 5);
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Index out of bounds - passed position = ");
      stringBuilder.append(param1Int);
      stringBuilder.append(", old list size = ");
      stringBuilder.append(this.e);
      throw new IndexOutOfBoundsException(stringBuilder.toString());
    }
    
    public void dispatchUpdatesTo(ListUpdateCallback param1ListUpdateCallback) {
      if (param1ListUpdateCallback instanceof BatchingListUpdateCallback) {
        param1ListUpdateCallback = param1ListUpdateCallback;
      } else {
        param1ListUpdateCallback = new BatchingListUpdateCallback(param1ListUpdateCallback);
      } 
      ArrayList<DiffUtil.PostponedUpdate> arrayList = new ArrayList();
      int j = this.e;
      int k = this.f;
      for (int i = this.a.size(); --i >= 0; i--) {
        DiffUtil.Snake snake = this.a.get(i);
        int m = snake.c;
        int n = snake.a + m;
        int i1 = snake.b + m;
        if (n < j)
          b(arrayList, param1ListUpdateCallback, n, j - n, n); 
        if (i1 < k)
          a(arrayList, param1ListUpdateCallback, n, k - i1, i1); 
        for (j = m - 1; j >= 0; j--) {
          if ((this.b[snake.a + j] & 0x1F) == 2)
            param1ListUpdateCallback.onChanged(snake.a + j, 1, this.d.getChangePayload(snake.a + j, snake.b + j)); 
        } 
        j = snake.a;
        k = snake.b;
      } 
      param1ListUpdateCallback.dispatchLastEvent();
    }
    
    public void dispatchUpdatesTo(RecyclerView.Adapter param1Adapter) {
      dispatchUpdatesTo(new AdapterListUpdateCallback(param1Adapter));
    }
  }
  
  public static abstract class ItemCallback<T> {
    public abstract boolean areContentsTheSame(T param1T1, T param1T2);
    
    public abstract boolean areItemsTheSame(T param1T1, T param1T2);
    
    public Object getChangePayload(T param1T1, T param1T2) {
      return null;
    }
  }
  
  static class PostponedUpdate {
    int a;
    
    int b;
    
    boolean c;
    
    public PostponedUpdate(int param1Int1, int param1Int2, boolean param1Boolean) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Boolean;
    }
  }
  
  static class Range {
    int a;
    
    int b;
    
    int c;
    
    int d;
    
    public Range() {}
    
    public Range(int param1Int1, int param1Int2, int param1Int3, int param1Int4) {
      this.a = param1Int1;
      this.b = param1Int2;
      this.c = param1Int3;
      this.d = param1Int4;
    }
  }
  
  static class Snake {
    int a;
    
    int b;
    
    int c;
    
    boolean d;
    
    boolean e;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\DiffUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */