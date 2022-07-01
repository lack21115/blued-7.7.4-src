package com.brandongogetap.stickyheaders;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StickyLayoutManager extends LinearLayoutManager {
  private StickyHeaderPositioner a;
  
  private StickyHeaderHandler b;
  
  private List<Integer> c = new ArrayList<Integer>();
  
  private ViewRetriever.RecyclerViewRetriever d;
  
  private int e = -1;
  
  private StickyHeaderListener f;
  
  public StickyLayoutManager(Context paramContext, int paramInt, boolean paramBoolean, StickyHeaderHandler paramStickyHeaderHandler) {
    super(paramContext, paramInt, paramBoolean);
    a(paramStickyHeaderHandler);
  }
  
  public StickyLayoutManager(Context paramContext, StickyHeaderHandler paramStickyHeaderHandler) {
    this(paramContext, 1, false, paramStickyHeaderHandler);
    a(paramStickyHeaderHandler);
  }
  
  private void a(StickyHeaderHandler paramStickyHeaderHandler) {
    Preconditions.a(paramStickyHeaderHandler, "StickyHeaderHandler == null");
    this.b = paramStickyHeaderHandler;
  }
  
  private void h() {
    boolean bool;
    this.a.b(getOrientation());
    StickyHeaderPositioner stickyHeaderPositioner = this.a;
    int i = findFirstVisibleItemPosition();
    Map<Integer, View> map = i();
    ViewRetriever.RecyclerViewRetriever recyclerViewRetriever = this.d;
    if (findFirstCompletelyVisibleItemPosition() == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    stickyHeaderPositioner.a(i, map, recyclerViewRetriever, bool);
  }
  
  private Map<Integer, View> i() {
    LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
    for (int i = 0; i < getChildCount(); i++) {
      View view = getChildAt(i);
      int j = getPosition(view);
      if (this.c.contains(Integer.valueOf(j)))
        linkedHashMap.put(Integer.valueOf(j), view); 
    } 
    return (Map)linkedHashMap;
  }
  
  private void j() {
    this.c.clear();
    List list = this.b.a();
    if (list == null) {
      stickyHeaderPositioner = this.a;
      if (stickyHeaderPositioner != null)
        stickyHeaderPositioner.a(this.c); 
      return;
    } 
    for (int i = 0; i < stickyHeaderPositioner.size(); i++) {
      if (stickyHeaderPositioner.get(i) instanceof com.brandongogetap.stickyheaders.exposed.StickyHeader)
        this.c.add(Integer.valueOf(i)); 
    } 
    StickyHeaderPositioner stickyHeaderPositioner = this.a;
    if (stickyHeaderPositioner != null)
      stickyHeaderPositioner.a(this.c); 
  }
  
  public void onAttachedToWindow(RecyclerView paramRecyclerView) {
    Preconditions.a((View)paramRecyclerView);
    this.d = new ViewRetriever.RecyclerViewRetriever(paramRecyclerView);
    this.a = new StickyHeaderPositioner(paramRecyclerView);
    this.a.a(this.e);
    this.a.a(this.f);
    if (this.c.size() > 0) {
      this.a.a(this.c);
      h();
    } 
    super.onAttachedToWindow(paramRecyclerView);
  }
  
  public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    super.onLayoutChildren(paramRecycler, paramState);
    j();
    if (this.a != null)
      h(); 
  }
  
  public void removeAndRecycleAllViews(RecyclerView.Recycler paramRecycler) {
    super.removeAndRecycleAllViews(paramRecycler);
    StickyHeaderPositioner stickyHeaderPositioner = this.a;
    if (stickyHeaderPositioner != null)
      stickyHeaderPositioner.a(); 
  }
  
  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    paramInt = super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
    if (Math.abs(paramInt) > 0) {
      StickyHeaderPositioner stickyHeaderPositioner = this.a;
      if (stickyHeaderPositioner != null) {
        boolean bool;
        int i = findFirstVisibleItemPosition();
        Map<Integer, View> map = i();
        ViewRetriever.RecyclerViewRetriever recyclerViewRetriever = this.d;
        if (findFirstCompletelyVisibleItemPosition() == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        stickyHeaderPositioner.a(i, map, recyclerViewRetriever, bool);
      } 
    } 
    return paramInt;
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState) {
    paramInt = super.scrollVerticallyBy(paramInt, paramRecycler, paramState);
    if (Math.abs(paramInt) > 0) {
      StickyHeaderPositioner stickyHeaderPositioner = this.a;
      if (stickyHeaderPositioner != null) {
        boolean bool;
        int i = findFirstVisibleItemPosition();
        Map<Integer, View> map = i();
        ViewRetriever.RecyclerViewRetriever recyclerViewRetriever = this.d;
        if (findFirstCompletelyVisibleItemPosition() == 0) {
          bool = true;
        } else {
          bool = false;
        } 
        stickyHeaderPositioner.a(i, map, recyclerViewRetriever, bool);
      } 
    } 
    return paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\brandongogetap\stickyheaders\StickyLayoutManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */