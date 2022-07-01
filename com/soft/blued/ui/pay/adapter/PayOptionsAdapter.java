package com.soft.blued.ui.pay.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.blued.android.core.AppInfo;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.AesCrypto;
import com.blued.android.module.common.model.DecryptJson;
import com.blued.android.module.common.utils.DialogUtils;
import com.blued.android.module.live.base.model.PayOption;
import com.blued.android.module.live_china.model.PayRemaining;
import com.blued.android.similarity_operation_provider.BluedURIRouterAdapter;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.utils.BluedPreferences;
import com.soft.blued.utils.DeviceUtils;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.view.tip.CommonAlertDialog;
import com.soft.blued.view.tip.model.DialogWith6PW;
import java.util.List;

public class PayOptionsAdapter extends BaseAdapter {
  private LayoutInflater a;
  
  private List<PayOption._pay_list> b;
  
  private Context c;
  
  private String d;
  
  private String e;
  
  private boolean f = false;
  
  private IRequestHost g;
  
  private Dialog h;
  
  public PayOptionsAdapter(Context paramContext, List<PayOption._pay_list> paramList, String paramString1, String paramString2, boolean paramBoolean, IRequestHost paramIRequestHost) {
    this.a = LayoutInflater.from(paramContext);
    this.b = paramList;
    this.c = paramContext;
    this.d = paramString1;
    this.e = paramString2;
    this.f = paramBoolean;
    this.g = paramIRequestHost;
    this.h = DialogUtils.a(paramContext);
  }
  
  public PayOption._pay_list a(int paramInt) {
    return this.b.get(paramInt);
  }
  
  public void a(String paramString, boolean paramBoolean) {
    PayHttpUtils.a(paramString, Boolean.valueOf(paramBoolean), 1, new BluedUIHttpResponse<BluedEntityA<PayRemaining>>(this) {
          protected void a(BluedEntityA<PayRemaining> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              PayRemaining payRemaining = param1BluedEntityA.data.get(0);
              PayOptionsAdapter.a(this.a, true);
              try {
                String str = AesCrypto.c(payRemaining._);
                BluedPreferences.V(((DecryptJson)AppInfo.f().fromJson(str, DecryptJson.class)).token);
                return;
              } catch (Exception exception) {
                return;
              } 
            } 
            AppMethods.d(2131756082);
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            DialogUtils.b(PayOptionsAdapter.e(this.a));
          }
          
          public void onUIStart() {
            super.onUIStart();
            DialogUtils.a(PayOptionsAdapter.e(this.a));
          }
        }this.g);
  }
  
  public boolean a() {
    if (this.f)
      return true; 
    String str1 = this.c.getResources().getString(2131755025);
    String str2 = this.c.getResources().getString(2131755021);
    CommonAlertDialog.a(this.c, str1, str2, true, new CommonAlertDialog.PWDListener(this) {
          public void a(String param1String, boolean param1Boolean, DialogWith6PW param1DialogWith6PW) {
            this.a.a(param1String, param1Boolean);
          }
        }null);
    return false;
  }
  
  public int getCount() {
    return this.b.size();
  }
  
  public long getItemId(int paramInt) {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup) {
    ViewHolder viewHolder1;
    ViewHolder viewHolder2;
    if (paramView == null) {
      viewHolder1 = new ViewHolder();
      View view = this.a.inflate(2131493621, paramViewGroup, false);
      viewHolder1.a = (TextView)view.findViewById(2131301284);
      viewHolder1.b = (TextView)view.findViewById(2131301518);
      viewHolder1.c = (TextView)view.findViewById(2131300742);
      view.setTag(viewHolder1);
    } else {
      ViewHolder viewHolder = (ViewHolder)viewHolder1.getTag();
      viewHolder2 = viewHolder1;
      viewHolder1 = viewHolder;
    } 
    PayOption._pay_list _pay_list = this.b.get(paramInt);
    if (_pay_list != null) {
      if (DeviceUtils.f()) {
        TextView textView1 = viewHolder1.a;
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(_pay_list.pretax);
        stringBuilder4.append("");
        stringBuilder3.append(StringUtils.a(stringBuilder4.toString()));
        stringBuilder3.append(this.c.getResources().getString(2131755014));
        textView1.setText(stringBuilder3.toString());
      } else {
        TextView textView1 = viewHolder1.a;
        StringBuilder stringBuilder3 = new StringBuilder();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append((int)_pay_list.money);
        stringBuilder4.append("");
        stringBuilder3.append(StringUtils.a(stringBuilder4.toString()));
        stringBuilder3.append(this.c.getResources().getString(2131755014));
        textView1.setText(stringBuilder3.toString());
      } 
      TextView textView = viewHolder1.b;
      StringBuilder stringBuilder1 = new StringBuilder();
      StringBuilder stringBuilder2 = new StringBuilder();
      stringBuilder2.append((int)(_pay_list.money * _pay_list.ratio));
      stringBuilder2.append("");
      stringBuilder1.append(StringUtils.a(stringBuilder2.toString()));
      stringBuilder1.append(this.c.getResources().getString(2131755033));
      textView.setText(stringBuilder1.toString());
      if (_pay_list.bonus > 0.0F) {
        viewHolder1.c.setVisibility(0);
        textView = viewHolder1.c;
        String str = this.c.getResources().getString(2131758421);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append((int)_pay_list.bonus);
        stringBuilder2.append("");
        textView.setText(String.format(str, new Object[] { StringUtils.a(stringBuilder2.toString()) }));
      } else {
        viewHolder1.c.setVisibility(8);
      } 
      if (_pay_list.choosed) {
        viewHolder1.a.setBackground(this.c.getResources().getDrawable(2131233768));
        viewHolder1.a.setTextColor(this.c.getResources().getColor(2131100980));
      } else {
        viewHolder1.a.setBackground(BluedSkinUtils.b(this.c, 2131233945));
        viewHolder1.a.setTextColor(this.c.getResources().getColor(2131100716));
      } 
      viewHolder2.setOnClickListener(new View.OnClickListener(this, _pay_list, paramInt) {
            public void onClick(View param1View) {
              this.a.choosed = true;
              for (int i = 0; i < PayOptionsAdapter.a(this.c).size(); i++) {
                if (i != this.b)
                  ((PayOption._pay_list)PayOptionsAdapter.a(this.c).get(i)).choosed = false; 
              } 
              this.c.notifyDataSetChanged();
              if (this.c.a()) {
                Context context = PayOptionsAdapter.b(this.c);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.a.id);
                stringBuilder.append("");
                BluedURIRouterAdapter.startVIPPay(context, stringBuilder.toString(), "", "", "", PayOptionsAdapter.c(this.c), PayOptionsAdapter.d(this.c));
              } 
            }
          });
    } 
    return (View)viewHolder2;
  }
  
  class ViewHolder {
    public TextView a;
    
    public TextView b;
    
    public TextView c;
    
    private ViewHolder(PayOptionsAdapter this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\pay\adapter\PayOptionsAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */