package com.soft.blued.ui.find.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.customview.CommonTopTitleNoTrans;
import com.soft.blued.ui.find.model.FilterInfo;
import com.soft.blued.utils.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class MultiSelectFragment extends BaseFragment {
  private Context d;
  
  private View e;
  
  private CommonTopTitleNoTrans f;
  
  private List<FilterInfo> g = new ArrayList<FilterInfo>();
  
  private List<FilterInfo> h = new ArrayList<FilterInfo>();
  
  private ListView i;
  
  private String[] j;
  
  private String k;
  
  private int[] l;
  
  private RaceAdapter m;
  
  private String n;
  
  private String o = "";
  
  private int p;
  
  private void a() {
    ArrayList<FilterInfo> arrayList = new ArrayList();
    String[] arrayOfString = this.j;
    if (arrayOfString == null || arrayOfString.length == 0)
      this.j = this.d.getResources().getStringArray(2130903098); 
    if (StringUtils.e(this.k))
      this.k = "-1"; 
    this.n = this.d.getResources().getString(2131759104);
    if ("-1".equals(this.k) || this.k.contains("-")) {
      for (int j = 0; j < this.j.length; j++) {
        FilterInfo filterInfo = new FilterInfo();
        filterInfo.mName = this.j[j];
        if (filterInfo.mName.equals(this.n))
          filterInfo.mSelected = true; 
        arrayList.add(filterInfo);
      } 
    } else {
      StringBuffer stringBuffer = new StringBuffer();
      String[] arrayOfString1 = this.k.split(",");
      int j;
      for (j = 0; j < arrayOfString1.length; j++) {
        int k = Integer.parseInt(arrayOfString1[j]);
        String[] arrayOfString2 = this.j;
        if (k < arrayOfString2.length && k >= 0)
          stringBuffer.append(arrayOfString2[k]); 
      } 
      for (j = 0; j < this.j.length; j++) {
        FilterInfo filterInfo = new FilterInfo();
        filterInfo.mName = this.j[j];
        if (stringBuffer.toString().contains(filterInfo.mName))
          filterInfo.mSelected = true; 
        arrayList.add(filterInfo);
      } 
    } 
    for (int i = 0; i < arrayList.size(); i++) {
      if (StringUtils.e(((FilterInfo)arrayList.get(i)).id)) {
        FilterInfo filterInfo = arrayList.get(i);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        stringBuilder.append("");
        filterInfo.id = stringBuilder.toString();
      } 
      int[] arrayOfInt = this.l;
      if (arrayOfInt != null && arrayOfInt.length > 0) {
        int j = 0;
        while (true) {
          arrayOfInt = this.l;
          if (j < arrayOfInt.length) {
            if (i == arrayOfInt[j])
              ((FilterInfo)arrayList.get(i)).visible = 8; 
            j++;
            continue;
          } 
          break;
        } 
      } 
      if (((FilterInfo)arrayList.get(i)).visible != 8)
        this.g.add(arrayList.get(i)); 
    } 
    this.m.notifyDataSetChanged();
  }
  
  public static void a(Fragment paramFragment, int paramInt, String paramString1, String[] paramArrayOfString, String paramString2, int[] paramArrayOfint) {
    Bundle bundle = new Bundle();
    bundle.putString("title", paramString1);
    bundle.putStringArray("list", paramArrayOfString);
    bundle.putString("selectedPostion", paramString2);
    bundle.putIntArray("gonePostions", paramArrayOfint);
    bundle.putInt("requestcode", paramInt);
    TerminalActivity.a(paramFragment, MultiSelectFragment.class, bundle, paramInt);
  }
  
  private void k() {
    this.m = new RaceAdapter(this, this.d);
    this.i = (ListView)this.e.findViewById(2131299559);
    this.i.setAdapter((ListAdapter)this.m);
  }
  
  private void l() {
    this.f = (CommonTopTitleNoTrans)this.e.findViewById(2131300300);
    this.f.setRightText(getString(2131755348));
    if (StringUtils.e(this.o)) {
      this.f.setCenterText(getString(2131756492));
    } else {
      this.f.setCenterText(this.o);
    } 
    this.f.setLeftClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            this.a.getActivity().finish();
          }
        });
    this.f.setRightClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            StringBuffer stringBuffer1 = new StringBuffer();
            StringBuffer stringBuffer2 = new StringBuffer();
            StringBuffer stringBuffer3 = new StringBuffer();
            for (int i = 0; i < MultiSelectFragment.a(this.a).size(); i++) {
              FilterInfo filterInfo = MultiSelectFragment.a(this.a).get(i);
              if (filterInfo.mSelected) {
                if (filterInfo.mName.equals(MultiSelectFragment.b(this.a))) {
                  stringBuffer1.append(-1);
                  stringBuffer2.append(-1);
                  stringBuffer3.append(-1);
                  break;
                } 
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(filterInfo.position);
                stringBuilder.append(",");
                stringBuffer1.append(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(filterInfo.mName);
                stringBuilder.append(",");
                stringBuffer2.append(stringBuilder.toString());
                stringBuilder = new StringBuilder();
                stringBuilder.append(filterInfo.id);
                stringBuilder.append(",");
                stringBuffer3.append(stringBuilder.toString());
              } 
            } 
            if (stringBuffer1.length() == 0) {
              stringBuffer1.append(-1);
              stringBuffer2.append(-1);
              stringBuffer3.append(-1);
            } 
            Intent intent = new Intent();
            intent.putExtra("SELETEDPOSITION", stringBuffer1.toString());
            intent.putExtra("SELECTEDTEXT", stringBuffer2.toString());
            intent.putExtra("SELECTEDID", stringBuffer3.toString());
            this.a.getActivity().setResult(-1, intent);
            this.a.getActivity().finish();
          }
        });
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    this.d = (Context)getActivity();
    View view = this.e;
    if (view == null) {
      this.e = paramLayoutInflater.inflate(2131493052, paramViewGroup, false);
      if (getArguments() != null) {
        this.j = getArguments().getStringArray("list");
        this.o = getArguments().getString("title");
        this.p = getArguments().getInt("requestcode");
        this.k = getArguments().getString("selectedPostion");
        this.l = getArguments().getIntArray("gonePostions");
      } 
      k();
      a();
      l();
    } else if (view.getParent() != null) {
      ((ViewGroup)this.e.getParent()).removeView(this.e);
    } 
    return this.e;
  }
  
  public class RaceAdapter extends BaseAdapter {
    private Context b;
    
    public RaceAdapter(MultiSelectFragment this$0, Context param1Context) {
      this.b = param1Context;
    }
    
    public int getCount() {
      return MultiSelectFragment.a(this.a).size();
    }
    
    public Object getItem(int param1Int) {
      return MultiSelectFragment.a(this.a).get(param1Int);
    }
    
    public long getItemId(int param1Int) {
      return param1Int;
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder;
      if (param1View == null) {
        param1View = LayoutInflater.from(this.b).inflate(2131494094, param1ViewGroup, false);
        viewHolder = new ViewHolder();
        param1View.setTag(viewHolder);
        viewHolder.a = (TextView)param1View.findViewById(2131300214);
        viewHolder.b = param1View.findViewById(2131300157);
        viewHolder.c = (RelativeLayout)param1View.findViewById(2131299712);
      } else {
        viewHolder = (ViewHolder)param1View.getTag();
      } 
      FilterInfo filterInfo = MultiSelectFragment.a(this.a).get(param1Int);
      filterInfo.position = param1Int;
      viewHolder.a.setText(filterInfo.mName);
      if (filterInfo.mSelected) {
        viewHolder.b.setVisibility(0);
      } else {
        viewHolder.b.setVisibility(8);
      } 
      param1View.setOnClickListener(new View.OnClickListener(this, filterInfo, viewHolder) {
            public void onClick(View param2View) {
              if (this.a.mSelected) {
                this.b.b.setVisibility(8);
                this.a.mSelected = false;
              } else {
                this.b.b.setVisibility(0);
                FilterInfo filterInfo = this.a;
                filterInfo.mSelected = true;
                if (filterInfo.mName.equals(MultiSelectFragment.b(this.c.a))) {
                  for (int i = 0; i < MultiSelectFragment.a(this.c.a).size(); i++) {
                    if (i != 0)
                      ((FilterInfo)MultiSelectFragment.a(this.c.a).get(i)).mSelected = false; 
                  } 
                } else if (((FilterInfo)MultiSelectFragment.a(this.c.a).get(0)).mSelected) {
                  ((FilterInfo)MultiSelectFragment.a(this.c.a).get(0)).mSelected = false;
                } 
              } 
              this.c.notifyDataSetChanged();
            }
          });
      return param1View;
    }
    
    final class ViewHolder {
      TextView a;
      
      View b;
      
      RelativeLayout c;
      
      private ViewHolder(MultiSelectFragment.RaceAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(MultiSelectFragment this$0, FilterInfo param1FilterInfo, MultiSelectFragment.RaceAdapter.ViewHolder param1ViewHolder) {}
    
    public void onClick(View param1View) {
      if (this.a.mSelected) {
        this.b.b.setVisibility(8);
        this.a.mSelected = false;
      } else {
        this.b.b.setVisibility(0);
        FilterInfo filterInfo = this.a;
        filterInfo.mSelected = true;
        if (filterInfo.mName.equals(MultiSelectFragment.b(this.c.a))) {
          for (int i = 0; i < MultiSelectFragment.a(this.c.a).size(); i++) {
            if (i != 0)
              ((FilterInfo)MultiSelectFragment.a(this.c.a).get(i)).mSelected = false; 
          } 
        } else if (((FilterInfo)MultiSelectFragment.a(this.c.a).get(0)).mSelected) {
          ((FilterInfo)MultiSelectFragment.a(this.c.a).get(0)).mSelected = false;
        } 
      } 
      this.c.notifyDataSetChanged();
    }
  }
  
  final class ViewHolder {
    TextView a;
    
    View b;
    
    RelativeLayout c;
    
    private ViewHolder(MultiSelectFragment this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\MultiSelectFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */