package com.blued.android.module.common.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public abstract class CommonRecycleAdapter<T> extends RecyclerView.Adapter<CommonRecycleAdapter.CommonAdapterHolder> {
  protected Context b;
  
  protected LayoutInflater c;
  
  protected final List<T> d = new ArrayList<T>();
  
  public CommonRecycleAdapter(Context paramContext) {
    this.b = paramContext;
    this.c = LayoutInflater.from(this.b);
  }
  
  protected abstract int a(int paramInt);
  
  public CommonAdapterHolder a(ViewGroup paramViewGroup, int paramInt) {
    return new CommonAdapterHolder(this.c.inflate(a(paramInt), paramViewGroup, false));
  }
  
  public List<T> a() {
    return this.d;
  }
  
  public void a(int paramInt, T paramT) {
    if (paramInt >= 0 && paramInt < this.d.size()) {
      this.d.set(paramInt, paramT);
      notifyItemChanged(paramInt);
    } 
  }
  
  public void a(CommonAdapterHolder paramCommonAdapterHolder, int paramInt) {
    if (this.d.size() < paramInt)
      return; 
    a(this.d.get(paramInt), paramInt, paramCommonAdapterHolder);
  }
  
  protected abstract void a(T paramT, int paramInt, CommonAdapterHolder paramCommonAdapterHolder);
  
  public void a(List<T> paramList) {
    if (paramList != null) {
      this.d.clear();
      this.d.addAll(paramList);
    } 
    notifyDataSetChanged();
  }
  
  public int getItemCount() {
    return this.d.size();
  }
  
  public int getItemViewType(int paramInt) {
    return super.getItemViewType(paramInt);
  }
  
  public static class CommonAdapterHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> p;
    
    private View q;
    
    public CommonAdapterHolder(View param1View) {
      super(param1View);
      this.q = param1View;
      this.p = new SparseArray();
    }
    
    public CommonAdapterHolder a(int param1Int, String param1String) {
      TextView textView = c(param1Int);
      if (textView != null)
        textView.setText(param1String); 
      return this;
    }
    
    public CommonAdapterHolder b(int param1Int1, int param1Int2) {
      View view = (View)c(param1Int1);
      if (view != null)
        view.setVisibility(param1Int2); 
      return this;
    }
    
    public <T extends View> T c(int param1Int) {
      View view2 = (View)this.p.get(param1Int);
      View view1 = view2;
      if (view2 == null) {
        view1 = this.q.findViewById(param1Int);
        this.p.put(param1Int, view1);
      } 
      return (T)view1;
    }
    
    public CommonAdapterHolder c(int param1Int1, int param1Int2) {
      View view = (View)c(param1Int1);
      if (view != null)
        view.setBackgroundResource(param1Int2); 
      return this;
    }
    
    public CommonAdapterHolder d(int param1Int1, int param1Int2) {
      ImageView imageView = c(param1Int1);
      if (imageView != null)
        imageView.setImageResource(param1Int2); 
      return this;
    }
    
    public View w() {
      return this.q;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\adapter\CommonRecycleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */