package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

class TileList<T> {
  final int a;
  
  Tile<T> b;
  
  private final SparseArray<Tile<T>> c = new SparseArray(10);
  
  public TileList(int paramInt) {
    this.a = paramInt;
  }
  
  public Tile<T> addOrReplace(Tile<T> paramTile) {
    int i = this.c.indexOfKey(paramTile.mStartPosition);
    if (i < 0) {
      this.c.put(paramTile.mStartPosition, paramTile);
      return null;
    } 
    Tile<T> tile = (Tile)this.c.valueAt(i);
    this.c.setValueAt(i, paramTile);
    if (this.b == tile)
      this.b = paramTile; 
    return tile;
  }
  
  public void clear() {
    this.c.clear();
  }
  
  public Tile<T> getAtIndex(int paramInt) {
    return (Tile<T>)this.c.valueAt(paramInt);
  }
  
  public T getItemAt(int paramInt) {
    Tile<T> tile = this.b;
    if (tile == null || !tile.a(paramInt)) {
      int i = this.a;
      i = this.c.indexOfKey(paramInt - paramInt % i);
      if (i < 0)
        return null; 
      this.b = (Tile<T>)this.c.valueAt(i);
    } 
    return this.b.b(paramInt);
  }
  
  public Tile<T> removeAtPos(int paramInt) {
    Tile<T> tile = (Tile)this.c.get(paramInt);
    if (this.b == tile)
      this.b = null; 
    this.c.delete(paramInt);
    return tile;
  }
  
  public int size() {
    return this.c.size();
  }
  
  public static class Tile<T> {
    Tile<T> a;
    
    public int mItemCount;
    
    public final T[] mItems;
    
    public int mStartPosition;
    
    public Tile(Class<T> param1Class, int param1Int) {
      this.mItems = (T[])Array.newInstance(param1Class, param1Int);
    }
    
    boolean a(int param1Int) {
      int i = this.mStartPosition;
      return (i <= param1Int && param1Int < i + this.mItemCount);
    }
    
    T b(int param1Int) {
      return this.mItems[param1Int - this.mStartPosition];
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\recyclerview\widget\TileList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */