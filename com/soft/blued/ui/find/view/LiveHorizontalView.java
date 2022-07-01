package com.soft.blued.ui.find.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.framework.http.parser.BluedEntity;
import com.soft.blued.ui.find.adapter.LiveRecyclerAdapter;
import com.soft.blued.ui.find.model.NearbyLiveExtra;
import com.soft.blued.ui.find.model.UserFindResult;
import com.soft.blued.ui.web.WebViewShowInfoFragment;

public class LiveHorizontalView extends LinearLayout {
  public Context a;
  
  public View b;
  
  private TextView c;
  
  private TextView d;
  
  private ImageView e;
  
  private RecyclerView f;
  
  private View g;
  
  private LiveRecyclerAdapter h;
  
  private BluedEntity<UserFindResult, NearbyLiveExtra> i;
  
  public LiveHorizontalView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public LiveHorizontalView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public void a(Context paramContext) {
    this.a = paramContext;
    this.b = LayoutInflater.from(this.a).inflate(2131493776, (ViewGroup)this);
    this.g = this.b.findViewById(2131299102);
    this.c = (TextView)this.b.findViewById(2131300995);
    this.d = (TextView)this.b.findViewById(2131300974);
    this.e = (ImageView)this.b.findViewById(2131297863);
    this.f = (RecyclerView)this.b.findViewById(2131299778);
    CustomLinearLayoutManager customLinearLayoutManager = new CustomLinearLayoutManager(this, this.a);
    customLinearLayoutManager.setStackFromEnd(true);
    customLinearLayoutManager.setOrientation(0);
    customLinearLayoutManager.scrollToPosition(0);
    this.f.setLayoutManager((RecyclerView.LayoutManager)customLinearLayoutManager);
    this.h = new LiveRecyclerAdapter(this.a);
    setVisibility(8);
  }
  
  public RecyclerView getListView() {
    return this.f;
  }
  
  public BluedEntity<UserFindResult, NearbyLiveExtra> getParseData() {
    return this.i;
  }
  
  public class CustomLinearLayoutManager extends LinearLayoutManager {
    public CustomLinearLayoutManager(LiveHorizontalView this$0, Context param1Context) {
      super(param1Context);
    }
    
    public boolean canScrollVertically() {
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\view\LiveHorizontalView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */