package com.soft.blued.ui.msg.customview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blued.android.core.BlueAppLocal;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.soft.blued.ui.msg.model.UserGiftPackageModel;
import com.soft.blued.ui.user.model.GiftGivingOptionForJsonParse;
import java.text.DecimalFormat;

public class GiftGivingOptionViewNew extends LinearLayout {
  public int a = 2;
  
  public Context b;
  
  public View c;
  
  private ShapeLinearLayout d;
  
  private TextView e;
  
  private TextView f;
  
  private ImageView g;
  
  private TextView h;
  
  private TextView i;
  
  private TextView j;
  
  private TextView k;
  
  public GiftGivingOptionViewNew(Context paramContext) {
    super(paramContext);
    this.b = paramContext;
    a();
  }
  
  public GiftGivingOptionViewNew(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    a();
  }
  
  public GiftGivingOptionViewNew(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    a();
  }
  
  private String a(long paramLong) {
    StringBuilder stringBuilder1;
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(0);
    stringBuilder2.append(getContext().getString(2131758023));
    String str = stringBuilder2.toString();
    if (paramLong > 60L) {
      long l = paramLong / 60L;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(l);
      stringBuilder.append(getContext().getString(2131758023));
      String str1 = stringBuilder.toString();
      if (l > 60L) {
        paramLong = l % 60L;
        l /= 60L;
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(l);
        stringBuilder3.append(getContext().getString(2131758002));
        stringBuilder3.append(paramLong);
        stringBuilder3.append(getContext().getString(2131758023));
        String str2 = stringBuilder3.toString();
        if (l > 24L) {
          long l1 = l / 24L;
          stringBuilder1 = new StringBuilder();
          stringBuilder1.append(l1);
          stringBuilder1.append(getContext().getString(2131757967));
          stringBuilder1.append(l % 24L);
          stringBuilder1.append(getContext().getString(2131758002));
          stringBuilder1.append(paramLong);
          stringBuilder1.append(getContext().getString(2131758023));
          return stringBuilder1.toString();
        } 
      } 
    } 
    return (String)stringBuilder1;
  }
  
  public void a() {
    this.c = LayoutInflater.from(this.b).inflate(2131493532, (ViewGroup)this);
    this.d = (ShapeLinearLayout)this.c.findViewById(2131298900);
    this.g = (ImageView)this.c.findViewById(2131297496);
    this.h = (TextView)this.c.findViewById(2131301088);
    this.e = (TextView)this.c.findViewById(2131301167);
    this.f = (TextView)this.c.findViewById(2131300754);
    this.i = (TextView)this.c.findViewById(2131301362);
    this.j = (TextView)this.c.findViewById(2131301433);
    this.k = (TextView)this.c.findViewById(2131301159);
  }
  
  public void a(IRequestHost paramIRequestHost, UserGiftPackageModel paramUserGiftPackageModel) {
    if (paramUserGiftPackageModel.gift_detail == null)
      return; 
    TextView textView = this.k;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramUserGiftPackageModel.num);
    stringBuilder.append("");
    textView.setText(stringBuilder.toString());
    this.k.setVisibility(0);
    a(paramIRequestHost, paramUserGiftPackageModel.gift_detail, paramUserGiftPackageModel.chosen);
    if (paramUserGiftPackageModel.end_time == 0L) {
      this.e.setVisibility(4);
      return;
    } 
    long l1 = paramUserGiftPackageModel.end_time;
    long l2 = System.currentTimeMillis();
    this.e.setVisibility(0);
    this.e.setText(a((l1 * 1000L - l2) / 1000L));
  }
  
  public void a(IRequestHost paramIRequestHost, GiftGivingOptionForJsonParse paramGiftGivingOptionForJsonParse, boolean paramBoolean) {
    if (paramBoolean) {
      this.k.setTextColor(ContextCompat.getColor(getContext(), 2131100980));
      this.k.setBackgroundResource(2131233829);
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100958);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100832);
      if (paramGiftGivingOptionForJsonParse.is_free == 2) {
        this.f.setVisibility(0);
        this.f.setText(paramGiftGivingOptionForJsonParse.description);
      } else {
        this.f.setVisibility(4);
      } 
      this.f.setBackground(this.b.getResources().getDrawable(2131233738));
      if (paramGiftGivingOptionForJsonParse.is_stock == 1) {
        this.i.setText("1");
        this.i.setTextColor(this.b.getResources().getColor(2131100793));
        this.i.setBackground(this.b.getResources().getDrawable(2131233830));
        this.i.setVisibility(0);
      } else {
        this.i.setVisibility(4);
      } 
    } else {
      this.k.setTextColor(ContextCompat.getColor(getContext(), 2131100844));
      this.k.setBackgroundResource(2131233832);
      ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100792);
      ShapeHelper.d((ShapeHelper.ShapeView)this.d, 2131100792);
      this.f.setVisibility(4);
      if (paramGiftGivingOptionForJsonParse.is_stock == 1) {
        this.i.setText("1");
        this.i.setTextColor(this.b.getResources().getColor(2131100808));
        this.i.setBackground(this.b.getResources().getDrawable(2131233831));
        this.i.setVisibility(0);
      } else {
        this.i.setVisibility(4);
      } 
    } 
    if (paramGiftGivingOptionForJsonParse.is_free == 2) {
      this.e.getPaint().setFlags(17);
    } else {
      this.e.getPaint().setFlags(1);
    } 
    if (paramGiftGivingOptionForJsonParse.type == -1 && !TextUtils.isEmpty(paramGiftGivingOptionForJsonParse.label))
      if (paramGiftGivingOptionForJsonParse.chosen) {
        this.f.setVisibility(0);
        this.f.setText(paramGiftGivingOptionForJsonParse.label);
      } else {
        this.f.setVisibility(4);
      }  
    ImageLoader.a(paramIRequestHost, paramGiftGivingOptionForJsonParse.icon).a(16.0F).a(this.g);
    if (BlueAppLocal.d()) {
      if ("CN".equals(BlueAppLocal.c().getCountry().toUpperCase())) {
        this.h.setText(paramGiftGivingOptionForJsonParse.gift_name_cn);
      } else {
        this.h.setText(paramGiftGivingOptionForJsonParse.gift_name_tw);
      } 
    } else {
      this.h.setText(paramGiftGivingOptionForJsonParse.gift_name_en);
    } 
    if (this.a != 3) {
      DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
      TextView textView = this.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("¥");
      stringBuilder.append(decimalFormat.format(paramGiftGivingOptionForJsonParse.money));
      textView.setText(stringBuilder.toString());
    } else {
      TextView textView = this.e;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramGiftGivingOptionForJsonParse.beans);
      stringBuilder.append(getContext().getString(2131757405));
      textView.setText(stringBuilder.toString());
    } 
    if (paramGiftGivingOptionForJsonParse.type == 2) {
      this.j.setVisibility(0);
      return;
    } 
    if (paramGiftGivingOptionForJsonParse.type == 3) {
      this.j.setVisibility(0);
      this.j.setText(getContext().getString(2131757986));
      return;
    } 
    this.j.setVisibility(8);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\customview\GiftGivingOptionViewNew.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */