package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class ResourceCursorAdapter extends CursorAdapter {
  private int j;
  
  private int k;
  
  private LayoutInflater l;
  
  @Deprecated
  public ResourceCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor) {
    super(paramContext, paramCursor);
    this.k = paramInt;
    this.j = paramInt;
    this.l = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public ResourceCursorAdapter(Context paramContext, int paramInt1, Cursor paramCursor, int paramInt2) {
    super(paramContext, paramCursor, paramInt2);
    this.k = paramInt1;
    this.j = paramInt1;
    this.l = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  @Deprecated
  public ResourceCursorAdapter(Context paramContext, int paramInt, Cursor paramCursor, boolean paramBoolean) {
    super(paramContext, paramCursor, paramBoolean);
    this.k = paramInt;
    this.j = paramInt;
    this.l = (LayoutInflater)paramContext.getSystemService("layout_inflater");
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) {
    return this.l.inflate(this.k, paramViewGroup, false);
  }
  
  public View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) {
    return this.l.inflate(this.j, paramViewGroup, false);
  }
  
  public void setDropDownViewResource(int paramInt) {
    this.k = paramInt;
  }
  
  public void setViewResource(int paramInt) {
    this.j = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cursoradapter\widget\ResourceCursorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */