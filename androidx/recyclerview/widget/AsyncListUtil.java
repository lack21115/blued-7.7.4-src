package androidx.recyclerview.widget;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;

public class AsyncListUtil<T> {
  final Class<T> a;
  
  final int b;
  
  final DataCallback<T> c;
  
  final ViewCallback d;
  
  final TileList<T> e;
  
  final ThreadUtil.MainThreadCallback<T> f;
  
  final ThreadUtil.BackgroundCallback<T> g;
  
  final int[] h = new int[2];
  
  final int[] i = new int[2];
  
  final int[] j = new int[2];
  
  boolean k;
  
  int l = 0;
  
  int m = 0;
  
  int n = this.m;
  
  final SparseIntArray o = new SparseIntArray();
  
  private int p = 0;
  
  private final ThreadUtil.MainThreadCallback<T> q = new ThreadUtil.MainThreadCallback<T>(this) {
      private void a() {
        for (int i = 0; i < this.a.e.size(); i++)
          this.a.g.recycleTile(this.a.e.getAtIndex(i)); 
        this.a.e.clear();
      }
      
      private boolean a(int param1Int) {
        return (param1Int == this.a.n);
      }
      
      public void addTile(int param1Int, TileList.Tile<T> param1Tile) {
        if (!a(param1Int)) {
          this.a.g.recycleTile(param1Tile);
          return;
        } 
        TileList.Tile<T> tile = this.a.e.addOrReplace(param1Tile);
        if (tile != null) {
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("duplicate tile @");
          stringBuilder.append(tile.mStartPosition);
          Log.e("AsyncListUtil", stringBuilder.toString());
          this.a.g.recycleTile(tile);
        } 
        int i = param1Tile.mStartPosition;
        int j = param1Tile.mItemCount;
        for (param1Int = 0; param1Int < this.a.o.size(); param1Int++) {
          int k = this.a.o.keyAt(param1Int);
          if (param1Tile.mStartPosition <= k && k < i + j) {
            this.a.o.removeAt(param1Int);
            this.a.d.onItemLoaded(k);
            continue;
          } 
        } 
      }
      
      public void removeTile(int param1Int1, int param1Int2) {
        StringBuilder stringBuilder;
        if (!a(param1Int1))
          return; 
        TileList.Tile tile = this.a.e.removeAtPos(param1Int2);
        if (tile == null) {
          stringBuilder = new StringBuilder();
          stringBuilder.append("tile not found @");
          stringBuilder.append(param1Int2);
          Log.e("AsyncListUtil", stringBuilder.toString());
          return;
        } 
        this.a.g.recycleTile((TileList.Tile)stringBuilder);
      }
      
      public void updateItemCount(int param1Int1, int param1Int2) {
        if (!a(param1Int1))
          return; 
        AsyncListUtil asyncListUtil = this.a;
        asyncListUtil.l = param1Int2;
        asyncListUtil.d.onDataRefresh();
        asyncListUtil = this.a;
        asyncListUtil.m = asyncListUtil.n;
        a();
        asyncListUtil = this.a;
        asyncListUtil.k = false;
        asyncListUtil.a();
      }
    };
  
  private final ThreadUtil.BackgroundCallback<T> r = new ThreadUtil.BackgroundCallback<T>(this) {
      final SparseBooleanArray a = new SparseBooleanArray();
      
      private TileList.Tile<T> c;
      
      private int d;
      
      private int e;
      
      private int f;
      
      private int g;
      
      private int a(int param1Int) {
        return param1Int - param1Int % this.b.b;
      }
      
      private TileList.Tile<T> a() {
        TileList.Tile<T> tile = this.c;
        if (tile != null) {
          this.c = tile.a;
          return tile;
        } 
        return new TileList.Tile<T>(this.b.a, this.b.b);
      }
      
      private void a(int param1Int1, int param1Int2, int param1Int3, boolean param1Boolean) {
        int i;
        for (i = param1Int1; i <= param1Int2; i += this.b.b) {
          int j;
          if (param1Boolean) {
            j = param1Int2 + param1Int1 - i;
          } else {
            j = i;
          } 
          this.b.g.loadTile(j, param1Int3);
        } 
      }
      
      private void a(TileList.Tile<T> param1Tile) {
        this.a.put(param1Tile.mStartPosition, true);
        this.b.f.addTile(this.d, param1Tile);
      }
      
      private boolean b(int param1Int) {
        return this.a.get(param1Int);
      }
      
      private void c(int param1Int) {
        this.a.delete(param1Int);
        this.b.f.removeTile(this.d, param1Int);
      }
      
      private void d(int param1Int) {
        int i = this.b.c.getMaxCachedTiles();
        while (this.a.size() >= i) {
          int j = this.a.keyAt(0);
          SparseBooleanArray sparseBooleanArray = this.a;
          int k = sparseBooleanArray.keyAt(sparseBooleanArray.size() - 1);
          int m = this.f - j;
          int n = k - this.g;
          if (m > 0 && (m >= n || param1Int == 2)) {
            c(j);
            continue;
          } 
          if (n > 0 && (m < n || param1Int == 1))
            c(k); 
        } 
      }
      
      public void loadTile(int param1Int1, int param1Int2) {
        if (b(param1Int1))
          return; 
        TileList.Tile<T> tile = a();
        tile.mStartPosition = param1Int1;
        tile.mItemCount = Math.min(this.b.b, this.e - tile.mStartPosition);
        this.b.c.fillData(tile.mItems, tile.mStartPosition, tile.mItemCount);
        d(param1Int2);
        a(tile);
      }
      
      public void recycleTile(TileList.Tile<T> param1Tile) {
        this.b.c.recycleData(param1Tile.mItems, param1Tile.mItemCount);
        param1Tile.a = this.c;
        this.c = param1Tile;
      }
      
      public void refresh(int param1Int) {
        this.d = param1Int;
        this.a.clear();
        this.e = this.b.c.refreshData();
        this.b.f.updateItemCount(this.d, this.e);
      }
      
      public void updateRange(int param1Int1, int param1Int2, int param1Int3, int param1Int4, int param1Int5) {
        if (param1Int1 > param1Int2)
          return; 
        param1Int1 = a(param1Int1);
        param1Int2 = a(param1Int2);
        this.f = a(param1Int3);
        this.g = a(param1Int4);
        if (param1Int5 == 1) {
          a(this.f, param1Int2, param1Int5, true);
          a(param1Int2 + this.b.b, this.g, param1Int5, false);
          return;
        } 
        a(param1Int1, this.g, param1Int5, false);
        a(this.f, param1Int1 - this.b.b, param1Int5, true);
      }
    };
  
  public AsyncListUtil(Class<T> paramClass, int paramInt, DataCallback<T> paramDataCallback, ViewCallback paramViewCallback) {
    this.a = paramClass;
    this.b = paramInt;
    this.c = paramDataCallback;
    this.d = paramViewCallback;
    this.e = new TileList<T>(this.b);
    MessageThreadUtil<T> messageThreadUtil = new MessageThreadUtil();
    this.f = messageThreadUtil.getMainThreadProxy(this.q);
    this.g = messageThreadUtil.getBackgroundProxy(this.r);
    refresh();
  }
  
  private boolean b() {
    return (this.n != this.m);
  }
  
  void a() {
    this.d.getItemRangeInto(this.h);
    int[] arrayOfInt = this.h;
    if (arrayOfInt[0] <= arrayOfInt[1]) {
      if (arrayOfInt[0] < 0)
        return; 
      if (arrayOfInt[1] >= this.l)
        return; 
      if (!this.k) {
        this.p = 0;
      } else {
        int k = arrayOfInt[0];
        int[] arrayOfInt2 = this.i;
        if (k > arrayOfInt2[1] || arrayOfInt2[0] > arrayOfInt[1]) {
          this.p = 0;
        } else if (arrayOfInt[0] < arrayOfInt2[0]) {
          this.p = 1;
        } else if (arrayOfInt[0] > arrayOfInt2[0]) {
          this.p = 2;
        } 
      } 
      arrayOfInt = this.i;
      int[] arrayOfInt1 = this.h;
      arrayOfInt[0] = arrayOfInt1[0];
      arrayOfInt[1] = arrayOfInt1[1];
      this.d.extendRangeInto(arrayOfInt1, this.j, this.p);
      arrayOfInt = this.j;
      arrayOfInt[0] = Math.min(this.h[0], Math.max(arrayOfInt[0], 0));
      arrayOfInt = this.j;
      arrayOfInt[1] = Math.max(this.h[1], Math.min(arrayOfInt[1], this.l - 1));
      ThreadUtil.BackgroundCallback<T> backgroundCallback = this.g;
      arrayOfInt1 = this.h;
      int i = arrayOfInt1[0];
      int j = arrayOfInt1[1];
      arrayOfInt1 = this.j;
      backgroundCallback.updateRange(i, j, arrayOfInt1[0], arrayOfInt1[1], this.p);
    } 
  }
  
  public T getItem(int paramInt) {
    if (paramInt >= 0 && paramInt < this.l) {
      T t = this.e.getItemAt(paramInt);
      if (t == null && !b())
        this.o.put(paramInt, 0); 
      return t;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append(" is not within 0 and ");
    stringBuilder.append(this.l);
    throw new IndexOutOfBoundsException(stringBuilder.toString());
  }
  
  public int getItemCount() {
    return this.l;
  }
  
  public void onRangeChanged() {
    if (b())
      return; 
    a();
    this.k = true;
  }
  
  public void refresh() {
    this.o.clear();
    ThreadUtil.BackgroundCallback<T> backgroundCallback = this.g;
    int i = this.n + 1;
    this.n = i;
    backgroundCallback.refresh(i);
  }
  
  public static abstract class DataCallback<T> {
    public abstract void fillData(T[] param1ArrayOfT, int param1Int1, int param1Int2);
    
    public int getMaxCachedTiles() {
      return 10;
    }
    
    public void recycleData(T[] param1ArrayOfT, int param1Int) {}
    
    public abstract int refreshData();
  }
  
  public static abstract class ViewCallback {
    public static final int HINT_SCROLL_ASC = 2;
    
    public static final int HINT_SCROLL_DESC = 1;
    
    public static final int HINT_SCROLL_NONE = 0;
    
    public void extendRangeInto(int[] param1ArrayOfint1, int[] param1ArrayOfint2, int param1Int) {
      int i = param1ArrayOfint1[1] - param1ArrayOfint1[0] + 1;
      int j = i / 2;
      int m = param1ArrayOfint1[0];
      if (param1Int == 1) {
        k = i;
      } else {
        k = j;
      } 
      param1ArrayOfint2[0] = m - k;
      int k = param1ArrayOfint1[1];
      if (param1Int != 2)
        i = j; 
      param1ArrayOfint2[1] = k + i;
    }
    
    public abstract void getItemRangeInto(int[] param1ArrayOfint);
    
    public abstract void onDataRefresh();
    
    public abstract void onItemLoaded(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\AsyncListUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */