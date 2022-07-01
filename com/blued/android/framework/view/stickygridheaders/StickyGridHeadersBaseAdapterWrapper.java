package com.blued.android.framework.view.stickygridheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;

public class StickyGridHeadersBaseAdapterWrapper extends BaseAdapter {
  private final Context a;
  
  private int b;
  
  private boolean c = false;
  
  private DataSetObserver d = new DataSetObserver(this) {
      public void onChanged() {
        this.a.a();
      }
      
      public void onInvalidated() {
        StickyGridHeadersBaseAdapterWrapper.a(this.a, false);
      }
    };
  
  private final StickyGridHeadersBaseAdapter e;
  
  private StickyGridHeadersGridView f;
  
  private View g;
  
  private View h;
  
  private int i = 1;
  
  public StickyGridHeadersBaseAdapterWrapper(Context paramContext, StickyGridHeadersGridView paramStickyGridHeadersGridView, StickyGridHeadersBaseAdapter paramStickyGridHeadersBaseAdapter) {
    this.a = paramContext;
    this.e = paramStickyGridHeadersBaseAdapter;
    this.f = paramStickyGridHeadersGridView;
    paramStickyGridHeadersBaseAdapter.registerDataSetObserver(this.d);
  }
  
  private FillerView a(View paramView1, ViewGroup paramViewGroup, View paramView2) {
    FillerView fillerView = (FillerView)paramView1;
    paramView1 = fillerView;
    if (fillerView == null)
      paramView1 = new FillerView(this, this.a); 
    paramView1.setMeasureTarget(paramView2);
    return (FillerView)paramView1;
  }
  
  private HeaderFillerView b(int paramInt, View paramView, ViewGroup paramViewGroup) {
    HeaderFillerView headerFillerView2 = (HeaderFillerView)paramView;
    HeaderFillerView headerFillerView1 = headerFillerView2;
    if (headerFillerView2 == null)
      headerFillerView1 = new HeaderFillerView(this, this.a); 
    return headerFillerView1;
  }
  
  private int d(int paramInt) {
    if (this.i == 0)
      return 0; 
    int i = this.e.a(paramInt);
    paramInt = this.i;
    i %= paramInt;
    return (i == 0) ? 0 : (paramInt - i);
  }
  
  protected View a(int paramInt, View paramView, ViewGroup paramViewGroup) {
    return (this.e.a() == 0) ? null : this.e.a((c(paramInt)).a, paramView, paramViewGroup);
  }
  
  protected void a() {
    int i = 0;
    this.b = 0;
    int j = this.e.a();
    if (j == 0) {
      this.b = this.e.getCount();
      this.c = true;
      return;
    } 
    while (i < j) {
      this.b += this.e.a(i) + this.i;
      i++;
    } 
    this.c = true;
  }
  
  public void a(int paramInt) {
    this.i = paramInt;
    this.c = false;
  }
  
  public boolean areAllItemsEnabled() {
    return false;
  }
  
  protected long b(int paramInt) {
    return (c(paramInt)).a;
  }
  
  protected Position c(int paramInt) {
    int m = this.e.a();
    int k = 0;
    if (m == 0)
      return (paramInt >= this.e.getCount()) ? new Position(this, -1, 0) : new Position(this, paramInt, 0); 
    int i = paramInt;
    int j = paramInt;
    for (paramInt = k; paramInt < m; paramInt++) {
      k = this.e.a(paramInt);
      if (j == 0)
        return new Position(this, -2, paramInt); 
      int n = this.i;
      j -= n;
      if (j < 0)
        return new Position(this, -3, paramInt); 
      i -= n;
      if (j < k)
        return new Position(this, i, paramInt); 
      n = d(paramInt);
      i -= n;
      j -= k + n;
      if (j < 0)
        return new Position(this, -1, paramInt); 
    } 
    return new Position(this, -1, paramInt);
  }
  
  public int getCount() {
    if (this.c)
      return this.b; 
    int i = 0;
    this.b = 0;
    int j = this.e.a();
    if (j == 0) {
      this.b = this.e.getCount();
      this.c = true;
      return this.b;
    } 
    while (i < j) {
      this.b += this.e.a(i) + d(i) + this.i;
      i++;
    } 
    this.c = true;
    return this.b;
  }
  
  public Object getItem(int paramInt) throws ArrayIndexOutOfBoundsException {
    Position position = c(paramInt);
    return (position.b == -1 || position.b == -2) ? null : this.e.getItem(position.b);
  }
  
  public long getItemId(int paramInt) {
    Position position = c(paramInt);
    return (position.b == -2) ? -1L : ((position.b == -1) ? -2L : ((position.b == -3) ? -3L : this.e.getItemId(position.b)));
  }
  
  public int getItemViewType(int paramInt) {
    Position position = c(paramInt);
    if (position.b == -2)
      return 1; 
    if (position.b == -1)
      return 0; 
    if (position.b == -3)
      return 2; 
    paramInt = this.e.getItemViewType(position.b);
    return (paramInt == -1) ? paramInt : (paramInt + 3);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    HeaderFillerView headerFillerView;
    FillerView fillerView;
    View view2;
    Position position = c(paramInt);
    if (position.b == -2) {
      headerFillerView = b(position.a, paramView, paramViewGroup);
      view2 = this.e.a(position.a, (View)headerFillerView.getTag(), paramViewGroup);
      this.f.b((View)headerFillerView.getTag());
      headerFillerView.setTag(view2);
      this.f.a(view2);
      this.g = (View)headerFillerView;
      headerFillerView.forceLayout();
      return (View)headerFillerView;
    } 
    if (position.b == -3) {
      fillerView = a((View)headerFillerView, (ViewGroup)view2, this.g);
      fillerView.forceLayout();
      return fillerView;
    } 
    if (position.b == -1)
      return a(fillerView, (ViewGroup)view2, this.h); 
    View view1 = this.e.getView(position.b, fillerView, (ViewGroup)view2);
    this.h = view1;
    return view1;
  }
  
  public int getViewTypeCount() {
    return this.e.getViewTypeCount() + 3;
  }
  
  public boolean hasStableIds() {
    return this.e.hasStableIds();
  }
  
  public boolean isEmpty() {
    return this.e.isEmpty();
  }
  
  public boolean isEnabled(int paramInt) {
    Position position = c(paramInt);
    return (position.b == -1 || position.b == -2) ? false : this.e.isEnabled(position.b);
  }
  
  public void registerDataSetObserver(DataSetObserver paramDataSetObserver) {
    super.registerDataSetObserver(paramDataSetObserver);
    this.e.registerDataSetObserver(paramDataSetObserver);
  }
  
  public void unregisterDataSetObserver(DataSetObserver paramDataSetObserver) {
    super.unregisterDataSetObserver(paramDataSetObserver);
    this.e.unregisterDataSetObserver(paramDataSetObserver);
  }
  
  public class FillerView extends View {
    private View b;
    
    public FillerView(StickyGridHeadersBaseAdapterWrapper this$0, Context param1Context) {
      super(param1Context);
    }
    
    protected void onMeasure(int param1Int1, int param1Int2) {
      super.onMeasure(param1Int1, View.MeasureSpec.makeMeasureSpec(this.b.getMeasuredHeight(), 1073741824));
    }
    
    public void setMeasureTarget(View param1View) {
      this.b = param1View;
    }
  }
  
  public class HeaderFillerView extends FrameLayout {
    private int b;
    
    public HeaderFillerView(StickyGridHeadersBaseAdapterWrapper this$0, Context param1Context) {
      super(param1Context);
    }
    
    protected FrameLayout.LayoutParams generateDefaultLayoutParams() {
      return new FrameLayout.LayoutParams(-1, -1);
    }
    
    public int getHeaderId() {
      return this.b;
    }
    
    protected void onMeasure(int param1Int1, int param1Int2) {
      FrameLayout.LayoutParams layoutParams;
      View view = (View)getTag();
      ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
      ViewGroup.LayoutParams layoutParams1 = layoutParams2;
      if (layoutParams2 == null) {
        layoutParams = generateDefaultLayoutParams();
        view.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
      } 
      if (view.getVisibility() != 8) {
        param1Int2 = getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(0, 0), 0, ((ViewGroup.LayoutParams)layoutParams).height);
        view.measure(getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(StickyGridHeadersBaseAdapterWrapper.a(this.a).getWidth(), 1073741824), 0, ((ViewGroup.LayoutParams)layoutParams).width), param1Int2);
      } 
      setMeasuredDimension(View.MeasureSpec.getSize(param1Int1), view.getMeasuredHeight());
    }
    
    public void setHeaderId(int param1Int) {
      this.b = param1Int;
    }
  }
  
  public class HeaderHolder {}
  
  public class Position {
    protected int a;
    
    protected int b;
    
    protected Position(StickyGridHeadersBaseAdapterWrapper this$0, int param1Int1, int param1Int2) {
      this.b = param1Int1;
      this.a = param1Int2;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\framework\view\stickygridheaders\StickyGridHeadersBaseAdapterWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */