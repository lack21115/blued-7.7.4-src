package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.amap.api.services.core.PoiItem;
import com.blued.android.core.AppMethods;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.android.module.location.LocationService;
import com.blued.android.module.location.model.LocationPOIModel;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SendPositionSearchFragment extends BaseFragment implements View.OnClickListener {
  private Context d;
  
  private View e;
  
  private RenrenPullToRefreshListView f;
  
  private ListView g;
  
  private List<PoiItem> h;
  
  private POISearchAdapter i;
  
  private int j;
  
  private boolean k = true;
  
  private TextView l;
  
  private EditText m;
  
  private ImageView n;
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.j = 0; 
    if (this.j == 0)
      this.k = true; 
    if (!this.k) {
      int i = this.j;
      if (i != 0) {
        this.j = i - 1;
        AppMethods.a(this.d.getResources().getString(2131756083));
        this.f.q();
        return;
      } 
    } 
    a(this.j);
  }
  
  public void a() {
    this.l = (TextView)this.e.findViewById(2131296867);
    this.l.setOnClickListener(this);
    this.n = (ImageView)this.e.findViewById(2131297456);
    this.n.setOnClickListener(this);
    this.m = (EditText)this.e.findViewById(2131296857);
    this.m.setImeOptions(3);
    this.m.setOnClickListener(this);
    this.m.setCursorVisible(true);
    this.m.requestFocus();
    this.m.addTextChangedListener(new TextWatcher(this) {
          public void afterTextChanged(Editable param1Editable) {
            if (param1Editable.length() > 0) {
              SendPositionSearchFragment.a(this.a).setText(2131755443);
              SendPositionSearchFragment.b(this.a).setVisibility(0);
              return;
            } 
            SendPositionSearchFragment.a(this.a).setText(2131755726);
            SendPositionSearchFragment.b(this.a).setVisibility(8);
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        });
    this.m.setOnKeyListener(new -$$Lambda$SendPositionSearchFragment$Iyj0C9fV2GXwoJwUzF6XneJW0Ww(this));
    a(new -$$Lambda$SendPositionSearchFragment$Fiqcc3tQ5LXZXIRN7D0mTs7sgHk(this), 300L);
  }
  
  public void a(int paramInt) {
    String str = this.m.getText().toString();
    -$$Lambda$SendPositionSearchFragment$ZxjQoynD9H1zxX_SApNbsdIX1pc -$$Lambda$SendPositionSearchFragment$ZxjQoynD9H1zxX_SApNbsdIX1pc = new -$$Lambda$SendPositionSearchFragment$ZxjQoynD9H1zxX_SApNbsdIX1pc(this);
    LocationService.c(getViewLifecycleOwner(), paramInt, str, -$$Lambda$SendPositionSearchFragment$ZxjQoynD9H1zxX_SApNbsdIX1pc);
  }
  
  public void k() {
    this.h = new ArrayList<PoiItem>();
    this.h.clear();
    this.f = (RenrenPullToRefreshListView)this.e.findViewById(2131298144);
    this.f.setRefreshEnabled(false);
    this.g = (ListView)this.f.getRefreshableView();
    this.g.setClipToPadding(false);
    this.g.setScrollBarStyle(33554432);
    this.g.setHeaderDividersEnabled(false);
    this.g.setDividerHeight(1);
    this.g.setDivider(getResources().getDrawable(2131232935));
    this.i = new POISearchAdapter(this, (Context)getActivity());
    this.g.setAdapter((ListAdapter)this.i);
    this.f.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            SendPositionSearchFragment.a(this.a, 0);
            SendPositionSearchFragment.a(this.a, false);
          }
          
          public void b() {
            SendPositionSearchFragment.c(this.a);
            PrintStream printStream = System.out;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("position load more:");
            stringBuilder.append(SendPositionSearchFragment.d(this.a));
            printStream.println(stringBuilder.toString());
            SendPositionSearchFragment.a(this.a, false);
          }
        });
  }
  
  public void onClick(View paramView) {
    int i = paramView.getId();
    if (i != 2131296857) {
      if (i != 2131296867) {
        if (i != 2131297456)
          return; 
        this.m.setText("");
        return;
      } 
      if (!StringUtils.e(this.m.getText().toString())) {
        KeyboardUtils.a((Activity)getActivity());
        this.j = 0;
        a(this.j);
        return;
      } 
      getActivity().finish();
      return;
    } 
    this.m.setHint("");
    this.m.setCursorVisible(true);
    this.m.setGravity(48);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493310, paramViewGroup, false);
      k();
      a();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public class POISearchAdapter extends BaseAdapter {
    private Context b;
    
    private LayoutInflater c;
    
    private List<LocationPOIModel> d = new ArrayList<LocationPOIModel>();
    
    public POISearchAdapter(SendPositionSearchFragment this$0, Context param1Context) {
      this.b = param1Context;
      this.c = LayoutInflater.from(param1Context);
    }
    
    public void a(List<LocationPOIModel> param1List) {
      this.d.clear();
      if (param1List != null && param1List.size() > 0)
        this.d.addAll(param1List); 
      notifyDataSetChanged();
    }
    
    public void b(List<LocationPOIModel> param1List) {
      if (param1List != null && param1List.size() > 0) {
        this.d.addAll(param1List);
        notifyDataSetChanged();
      } 
    }
    
    public int getCount() {
      return this.d.size();
    }
    
    public Object getItem(int param1Int) {
      return Integer.valueOf(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder1;
      ViewHolder viewHolder2;
      if (param1View == null) {
        viewHolder1 = new ViewHolder();
        View view = this.c.inflate(2131493646, param1ViewGroup, false);
        viewHolder1.a = (LinearLayout)view.findViewById(2131298900);
        viewHolder1.b = (TextView)view.findViewById(2131301177);
        viewHolder1.c = (TextView)view.findViewById(2131301176);
        viewHolder1.d = (ImageView)view.findViewById(2131297455);
        view.setTag(viewHolder1);
      } else {
        ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
        viewHolder2 = viewHolder1;
        viewHolder1 = viewHolder;
      } 
      LocationPOIModel locationPOIModel = this.d.get(param1Int);
      viewHolder1.b.setText(locationPOIModel.name);
      viewHolder1.c.setText(locationPOIModel.address);
      viewHolder1.d.setVisibility(8);
      viewHolder1.a.setOnClickListener(new -$$Lambda$SendPositionSearchFragment$POISearchAdapter$zpjUzCPENR5vWRUT3ZYbMZGeRkw(this, locationPOIModel));
      return (View)viewHolder2;
    }
    
    class ViewHolder {
      public LinearLayout a;
      
      public TextView b;
      
      public TextView c;
      
      public ImageView d;
      
      private ViewHolder(SendPositionSearchFragment.POISearchAdapter this$0) {}
    }
  }
  
  class ViewHolder {
    public LinearLayout a;
    
    public TextView b;
    
    public TextView c;
    
    public ImageView d;
    
    private ViewHolder(SendPositionSearchFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\SendPositionSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */