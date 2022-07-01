package androidx.cursoradapter.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

public abstract class CursorAdapter extends BaseAdapter implements Filterable, CursorFilter.CursorFilterClient {
  @Deprecated
  public static final int FLAG_AUTO_REQUERY = 1;
  
  public static final int FLAG_REGISTER_CONTENT_OBSERVER = 2;
  
  protected boolean a;
  
  protected boolean b;
  
  protected Cursor c;
  
  protected Context d;
  
  protected int e;
  
  protected ChangeObserver f;
  
  protected DataSetObserver g;
  
  protected CursorFilter h;
  
  protected FilterQueryProvider i;
  
  @Deprecated
  public CursorAdapter(Context paramContext, Cursor paramCursor) {
    a(paramContext, paramCursor, 1);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, int paramInt) {
    a(paramContext, paramCursor, paramInt);
  }
  
  public CursorAdapter(Context paramContext, Cursor paramCursor, boolean paramBoolean) {
    byte b;
    if (paramBoolean) {
      b = 1;
    } else {
      b = 2;
    } 
    a(paramContext, paramCursor, b);
  }
  
  protected void a() {
    if (this.b) {
      Cursor cursor = this.c;
      if (cursor != null && !cursor.isClosed())
        this.a = this.c.requery(); 
    } 
  }
  
  void a(Context paramContext, Cursor paramCursor, int paramInt) {
    byte b;
    boolean bool = false;
    if ((paramInt & 0x1) == 1) {
      paramInt |= 0x2;
      this.b = true;
    } else {
      this.b = false;
    } 
    if (paramCursor != null)
      bool = true; 
    this.c = paramCursor;
    this.a = bool;
    this.d = paramContext;
    if (bool) {
      b = paramCursor.getColumnIndexOrThrow("_id");
    } else {
      b = -1;
    } 
    this.e = b;
    if ((paramInt & 0x2) == 2) {
      this.f = new ChangeObserver(this);
      this.g = new MyDataSetObserver(this);
    } else {
      this.f = null;
      this.g = null;
    } 
    if (bool) {
      ChangeObserver changeObserver = this.f;
      if (changeObserver != null)
        paramCursor.registerContentObserver(changeObserver); 
      DataSetObserver dataSetObserver = this.g;
      if (dataSetObserver != null)
        paramCursor.registerDataSetObserver(dataSetObserver); 
    } 
  }
  
  public abstract void bindView(View paramView, Context paramContext, Cursor paramCursor);
  
  public void changeCursor(Cursor paramCursor) {
    paramCursor = swapCursor(paramCursor);
    if (paramCursor != null)
      paramCursor.close(); 
  }
  
  public CharSequence convertToString(Cursor paramCursor) {
    return (paramCursor == null) ? "" : paramCursor.toString();
  }
  
  public int getCount() {
    if (this.a) {
      Cursor cursor = this.c;
      if (cursor != null)
        return cursor.getCount(); 
    } 
    return 0;
  }
  
  public Cursor getCursor() {
    return this.c;
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (this.a) {
      this.c.moveToPosition(paramInt);
      View view = paramView;
      if (paramView == null)
        view = newDropDownView(this.d, this.c, paramViewGroup); 
      bindView(view, this.d, this.c);
      return view;
    } 
    return null;
  }
  
  public Filter getFilter() {
    if (this.h == null)
      this.h = new CursorFilter(this); 
    return this.h;
  }
  
  public FilterQueryProvider getFilterQueryProvider() {
    return this.i;
  }
  
  public Object getItem(int paramInt) {
    if (this.a) {
      Cursor cursor = this.c;
      if (cursor != null) {
        cursor.moveToPosition(paramInt);
        return this.c;
      } 
    } 
    return null;
  }
  
  public long getItemId(int paramInt) {
    if (this.a) {
      Cursor cursor = this.c;
      if (cursor != null && cursor.moveToPosition(paramInt))
        return this.c.getLong(this.e); 
    } 
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    if (this.a) {
      if (this.c.moveToPosition(paramInt)) {
        View view = paramView;
        if (paramView == null)
          view = newView(this.d, this.c, paramViewGroup); 
        bindView(view, this.d, this.c);
        return view;
      } 
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("couldn't move cursor to position ");
      stringBuilder.append(paramInt);
      throw new IllegalStateException(stringBuilder.toString());
    } 
    throw new IllegalStateException("this should only be called when the cursor is valid");
  }
  
  public boolean hasStableIds() {
    return true;
  }
  
  public View newDropDownView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup) {
    return newView(paramContext, paramCursor, paramViewGroup);
  }
  
  public abstract View newView(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence) {
    FilterQueryProvider filterQueryProvider = this.i;
    return (filterQueryProvider != null) ? filterQueryProvider.runQuery(paramCharSequence) : this.c;
  }
  
  public void setFilterQueryProvider(FilterQueryProvider paramFilterQueryProvider) {
    this.i = paramFilterQueryProvider;
  }
  
  public Cursor swapCursor(Cursor paramCursor) {
    Cursor cursor = this.c;
    if (paramCursor == cursor)
      return null; 
    if (cursor != null) {
      ChangeObserver changeObserver = this.f;
      if (changeObserver != null)
        cursor.unregisterContentObserver(changeObserver); 
      DataSetObserver dataSetObserver = this.g;
      if (dataSetObserver != null)
        cursor.unregisterDataSetObserver(dataSetObserver); 
    } 
    this.c = paramCursor;
    if (paramCursor != null) {
      ChangeObserver changeObserver = this.f;
      if (changeObserver != null)
        paramCursor.registerContentObserver(changeObserver); 
      DataSetObserver dataSetObserver = this.g;
      if (dataSetObserver != null)
        paramCursor.registerDataSetObserver(dataSetObserver); 
      this.e = paramCursor.getColumnIndexOrThrow("_id");
      this.a = true;
      notifyDataSetChanged();
      return cursor;
    } 
    this.e = -1;
    this.a = false;
    notifyDataSetInvalidated();
    return cursor;
  }
  
  class ChangeObserver extends ContentObserver {
    ChangeObserver(CursorAdapter this$0) {
      super(new Handler());
    }
    
    public boolean deliverSelfNotifications() {
      return true;
    }
    
    public void onChange(boolean param1Boolean) {
      this.a.a();
    }
  }
  
  class MyDataSetObserver extends DataSetObserver {
    MyDataSetObserver(CursorAdapter this$0) {}
    
    public void onChanged() {
      CursorAdapter cursorAdapter = this.a;
      cursorAdapter.a = true;
      cursorAdapter.notifyDataSetChanged();
    }
    
    public void onInvalidated() {
      CursorAdapter cursorAdapter = this.a;
      cursorAdapter.a = false;
      cursorAdapter.notifyDataSetInvalidated();
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\cursoradapter\widget\CursorAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */