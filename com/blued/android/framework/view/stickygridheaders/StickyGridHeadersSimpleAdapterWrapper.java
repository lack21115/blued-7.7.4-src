package com.blued.android.framework.view.stickygridheaders;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class StickyGridHeadersSimpleAdapterWrapper extends BaseAdapter implements StickyGridHeadersBaseAdapter {
  private StickyGridHeadersSimpleAdapter a;
  
  private HeaderData[] b;
  
  public StickyGridHeadersSimpleAdapterWrapper(StickyGridHeadersSimpleAdapter paramStickyGridHeadersSimpleAdapter) {
    this.a = paramStickyGridHeadersSimpleAdapter;
    paramStickyGridHeadersSimpleAdapter.registerDataSetObserver(new DataSetObserverExtension());
    this.b = a(paramStickyGridHeadersSimpleAdapter);
  }
  
  public int a() {
    return this.b.length;
  }
  
  public int a(int paramInt) {
    return this.b[paramInt].a();
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return this.a.a(this.b[paramInt].b(), paramView, paramViewGroup);
  }
  
  protected HeaderData[] a(StickyGridHeadersSimpleAdapter paramStickyGridHeadersSimpleAdapter) {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    ArrayList<HeaderData> arrayList = new ArrayList();
    for (int i = 0; i < paramStickyGridHeadersSimpleAdapter.getCount(); i++) {
      long l = paramStickyGridHeadersSimpleAdapter.a(i);
      HeaderData headerData2 = (HeaderData)hashMap.get(Long.valueOf(l));
      HeaderData headerData1 = headerData2;
      if (headerData2 == null) {
        headerData1 = new HeaderData(this, i);
        arrayList.add(headerData1);
      } 
      headerData1.c();
      hashMap.put(Long.valueOf(l), headerData1);
    } 
    return arrayList.<HeaderData>toArray(new HeaderData[arrayList.size()]);
  }
  
  public int getCount() {
    return this.a.getCount();
  }
  
  public Object getItem(int paramInt) {
    return this.a.getItem(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return this.a.getItemId(paramInt);
  }
  
  public int getItemViewType(int paramInt) {
    return this.a.getItemViewType(paramInt);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return this.a.getView(paramInt, paramView, paramViewGroup);
  }
  
  public int getViewTypeCount() {
    return this.a.getViewTypeCount();
  }
  
  public boolean hasStableIds() {
    return this.a.hasStableIds();
  }
  
  final class DataSetObserverExtension extends DataSetObserver {
    private DataSetObserverExtension(StickyGridHeadersSimpleAdapterWrapper this$0) {}
    
    public void onChanged() {
      StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = this.a;
      StickyGridHeadersSimpleAdapterWrapper.a(stickyGridHeadersSimpleAdapterWrapper, stickyGridHeadersSimpleAdapterWrapper.a(StickyGridHeadersSimpleAdapterWrapper.a(stickyGridHeadersSimpleAdapterWrapper)));
      this.a.notifyDataSetChanged();
    }
    
    public void onInvalidated() {
      StickyGridHeadersSimpleAdapterWrapper stickyGridHeadersSimpleAdapterWrapper = this.a;
      StickyGridHeadersSimpleAdapterWrapper.a(stickyGridHeadersSimpleAdapterWrapper, stickyGridHeadersSimpleAdapterWrapper.a(StickyGridHeadersSimpleAdapterWrapper.a(stickyGridHeadersSimpleAdapterWrapper)));
      this.a.notifyDataSetInvalidated();
    }
  }
  
  class HeaderData {
    private int b;
    
    private int c;
    
    public HeaderData(StickyGridHeadersSimpleAdapterWrapper this$0, int param1Int) {
      this.c = param1Int;
      this.b = 0;
    }
    
    public int a() {
      return this.b;
    }
    
    public int b() {
      return this.c;
    }
    
    public void c() {
      this.b++;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickygridheaders\StickyGridHeadersSimpleAdapterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */