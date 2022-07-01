package com.soft.blued.ui.setting.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.soft.blued.ui.setting.Contract.LoginDeviceListContract;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.utils.TimeAndDateUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LoginDeviceListAdapter extends BaseAdapter {
  private Context a;
  
  private LoginDeviceListContract.IPresenter b;
  
  private List<DeviceModel> c;
  
  public LoginDeviceListAdapter(Context paramContext, LoginDeviceListContract.IPresenter paramIPresenter, List<DeviceModel> paramList) {
    this.a = paramContext;
    this.b = paramIPresenter;
    this.c = paramList;
  }
  
  private String a(int paramInt) {
    long l = paramInt * 1000L;
    if (TimeAndDateUtils.f(l)) {
      if (TimeAndDateUtils.e(l))
        return ((SimpleDateFormat)TimeAndDateUtils.f.get()).format(new Date(l)); 
      if (TimeAndDateUtils.g(l)) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.getResources().getString(2131755486));
        stringBuilder.append(" ");
        stringBuilder.append(((SimpleDateFormat)TimeAndDateUtils.f.get()).format(new Date(l)));
        return stringBuilder.toString();
      } 
      return ((SimpleDateFormat)TimeAndDateUtils.h.get()).format(new Date(l));
    } 
    return ((SimpleDateFormat)TimeAndDateUtils.e.get()).format(new Date(l));
  }
  
  public int getCount() {
    List<DeviceModel> list = this.c;
    return (list != null) ? list.size() : 0;
  }
  
  public Object getItem(int paramInt) {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt) {
    return Long.parseLong(((DeviceModel)this.c.get(paramInt)).id);
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder;
    if (paramView == null) {
      paramView = LayoutInflater.from(this.a).inflate(2131493591, paramViewGroup, false);
      viewHolder = new ViewHolder(this, paramView);
      paramView.setTag(viewHolder);
    } else {
      viewHolder = (ViewHolder)paramView.getTag();
    } 
    DeviceModel deviceModel = this.c.get(paramInt);
    if (deviceModel != null) {
      if (paramInt == getCount() - 1) {
        ViewHolder.a(viewHolder).setVisibility(8);
      } else {
        ViewHolder.a(viewHolder).setVisibility(0);
      } 
      String str = deviceModel.id;
      if (deviceModel.is_self == 1) {
        TextView textView1 = ViewHolder.b(viewHolder);
        StringBuilder stringBuilder1 = new StringBuilder();
        stringBuilder1.append(deviceModel.dev_name);
        stringBuilder1.append(this.a.getResources().getString(2131757791));
        textView1.setText(stringBuilder1.toString());
      } else {
        ViewHolder.b(viewHolder).setText(deviceModel.dev_name);
      } 
      TextView textView = ViewHolder.c(viewHolder);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.a.getResources().getString(2131757107));
      stringBuilder.append(a(deviceModel.last_login));
      textView.setText(stringBuilder.toString());
      ViewHolder.d(viewHolder).setOnClickListener(new View.OnClickListener(this, deviceModel, str) {
            public void onClick(View param1View) {
              CommonAlertDialog.a(LoginDeviceListAdapter.a(this.c), null, String.format(LoginDeviceListAdapter.a(this.c).getResources().getString(2131758520), new Object[] { this.a.dev_name }), LoginDeviceListAdapter.a(this.c).getResources().getString(2131758518), new DialogInterface.OnClickListener(this) {
                    public void onClick(DialogInterface param2DialogInterface, int param2Int) {
                      LoginDeviceListAdapter.b(this.a.c).a("delete", this.a.b);
                      if (this.a.a.is_self == 1)
                        UserRelationshipUtils.a("", new int[0]); 
                    }
                  }null, null, null);
            }
          });
    } 
    return paramView;
  }
  
  class ViewHolder {
    private TextView b;
    
    private TextView c;
    
    private TextView d;
    
    private TextView e;
    
    public ViewHolder(LoginDeviceListAdapter this$0, View param1View) {
      if (param1View != null) {
        this.b = (TextView)param1View.findViewById(2131300739);
        this.c = (TextView)param1View.findViewById(2131300933);
        this.d = (TextView)param1View.findViewById(2131300709);
        this.e = (TextView)param1View.findViewById(2131300945);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\adapter\LoginDeviceListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */