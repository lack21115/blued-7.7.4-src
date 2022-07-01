package a.f.a;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

public abstract class a extends BaseAdapter implements b.a, Filterable {
  public boolean b;
  
  public boolean c;
  
  public Cursor d;
  
  public Context e;
  
  public int f;
  
  public a g;
  
  public DataSetObserver h;
  
  public b i;
  
  public a(Context paramContext, Cursor paramCursor, boolean paramBoolean) {
    byte b1;
    if (paramBoolean) {
      b1 = 1;
    } else {
      b1 = 2;
    } 
    if ((b1 & 0x1) == 1)
      throw new VerifyError("bad dex opcode"); 
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract View a(Context paramContext, Cursor paramCursor, ViewGroup paramViewGroup);
  
  public void a(Cursor paramCursor) {
    throw new VerifyError("bad dex opcode");
  }
  
  public abstract void a(View paramView, Context paramContext, Cursor paramCursor);
  
  public abstract CharSequence b(Cursor paramCursor);
  
  public int getCount() {
    throw new VerifyError("bad dex opcode");
  }
  
  public View getDropDownView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    throw new VerifyError("bad dex opcode");
  }
  
  public Filter getFilter() {
    throw new VerifyError("bad dex opcode");
  }
  
  public Object getItem(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public long getItemId(int paramInt) {
    throw new VerifyError("bad dex opcode");
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    throw new VerifyError("bad dex opcode");
  }
  
  public class a extends ContentObserver {
    public a(a this$0) {}
    
    public boolean deliverSelfNotifications() {
      return true;
    }
    
    public void onChange(boolean param1Boolean) {
      throw new VerifyError("bad dex opcode");
    }
  }
  
  public class b extends DataSetObserver {
    public b(a this$0) {}
    
    public void onChanged() {
      throw new VerifyError("bad dex opcode");
    }
    
    public void onInvalidated() {
      throw new VerifyError("bad dex opcode");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\a\f\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */