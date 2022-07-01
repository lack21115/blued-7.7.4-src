package com.soft.blued.ui.msg.pop;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.XPopup;
import com.blued.android.framework.ui.xpop.core.BasePopupView;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.user.model.PayBeanDetail;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.utils.StringUtils;
import com.soft.blued.utils.click.SingleClickProxy;

public class NormalPayTypeChoosePop extends BottomPopupView {
  private ImageView A;
  
  private TextView B;
  
  private Context C;
  
  private boolean D;
  
  private iChoosePayResultListener b;
  
  private TextView c;
  
  private LinearLayout d;
  
  private ShapeTextView e;
  
  private ImageView f;
  
  private LinearLayout g;
  
  private ImageView h;
  
  private LinearLayout i;
  
  private ImageView j;
  
  private ShapeTextView k;
  
  private View t;
  
  private int u;
  
  private IRequestHost v;
  
  private int w;
  
  private int x;
  
  private int y;
  
  private ShapeLinearLayout z;
  
  private NormalPayTypeChoosePop(Context paramContext, iChoosePayResultListener paramiChoosePayResultListener, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    super(paramContext);
    this.C = paramContext;
    this.b = paramiChoosePayResultListener;
    this.u = paramInt1;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("payPlatform:");
    stringBuilder.append(paramInt1);
    Log.v("drb", stringBuilder.toString());
    this.w = paramInt2;
    this.v = paramIRequestHost;
  }
  
  public static void a(Context paramContext, iChoosePayResultListener paramiChoosePayResultListener, int paramInt1, int paramInt2, IRequestHost paramIRequestHost) {
    NormalPayTypeChoosePop normalPayTypeChoosePop = new NormalPayTypeChoosePop(paramContext, paramiChoosePayResultListener, paramInt1, paramInt2, paramIRequestHost);
    (new XPopup.Builder(paramContext)).a((BasePopupView)normalPayTypeChoosePop).h();
  }
  
  private void c() {
    this.c = (TextView)findViewById(2131301409);
    this.d = (LinearLayout)findViewById(2131298698);
    this.e = (ShapeTextView)findViewById(2131300508);
    this.f = (ImageView)findViewById(2131297425);
    this.g = (LinearLayout)findViewById(2131299142);
    this.h = (ImageView)findViewById(2131297587);
    this.i = (LinearLayout)findViewById(2131298887);
    this.j = (ImageView)findViewById(2131297495);
    this.k = (ShapeTextView)findViewById(2131300656);
    this.t = findViewById(2131299451);
    this.z = (ShapeLinearLayout)findViewById(2131298717);
    this.A = (ImageView)findViewById(2131297442);
    this.B = (TextView)findViewById(2131299512);
  }
  
  public BluedUIHttpResponse a(IRequestHost paramIRequestHost) {
    return new BluedUIHttpResponse<BluedEntityA<PayPlatformDiscountModel>>(this, paramIRequestHost) {
        String a = "";
        
        protected void a(BluedEntityA<PayPlatformDiscountModel> param1BluedEntityA) {
          if (param1BluedEntityA.hasData() && param1BluedEntityA.getSingleData() != null) {
            if (((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel != null && ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel != null) {
              if (((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel.alipay != null) {
                this.a = ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel.alipay.desc;
                NormalPayTypeChoosePop.k(this.b).setVisibility(0);
                NormalPayTypeChoosePop.k(this.b).setText(this.a);
              } 
              PayPlatformDiscountModel._channel _channel = ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel;
              if (NormalPayTypeChoosePop.i(this.b) == 0 && _channel != null) {
                NormalPayTypeChoosePop normalPayTypeChoosePop;
                if (_channel.alipay != null && _channel.alipay.is_choose == 1) {
                  normalPayTypeChoosePop = this.b;
                  normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.a(normalPayTypeChoosePop));
                } else if (((PayPlatformDiscountModel._channel)normalPayTypeChoosePop).weixin != null && ((PayPlatformDiscountModel._channel)normalPayTypeChoosePop).weixin.is_choose == 1) {
                  normalPayTypeChoosePop = this.b;
                  normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.b(normalPayTypeChoosePop));
                } else if (((PayPlatformDiscountModel._channel)normalPayTypeChoosePop).huabei != null && ((PayPlatformDiscountModel._channel)normalPayTypeChoosePop).huabei.is_choose == 1) {
                  normalPayTypeChoosePop = this.b;
                  normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.c(normalPayTypeChoosePop));
                } 
              } 
            } 
            if (((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).vip != null) {
              NormalPayTypeChoosePop.a(this.b, ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).vip.is_upgrade);
              NormalPayTypeChoosePop.b(this.b, ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).vip.contract);
            } 
          } 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (param1Boolean && !StringUtils.e(this.a)) {
            NormalPayTypeChoosePop.k(this.b).setVisibility(0);
          } else {
            NormalPayTypeChoosePop.k(this.b).setVisibility(8);
          } 
          NormalPayTypeChoosePop.j(this.b).setVisibility(8);
        }
        
        public void onUIStart() {
          super.onUIStart();
          NormalPayTypeChoosePop.j(this.b).setVisibility(0);
        }
      };
  }
  
  public void b() {
    super.b();
    c();
    int i = this.u;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4)
            setChoose(this.j); 
        } else {
          setChoose(this.A);
        } 
      } else {
        setChoose(this.h);
      } 
    } else {
      setChoose(this.f);
    } 
    this.d.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              NormalPayTypeChoosePop normalPayTypeChoosePop = this.a;
              normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.a(normalPayTypeChoosePop));
            }
          }));
    this.g.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              NormalPayTypeChoosePop normalPayTypeChoosePop = this.a;
              normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.b(normalPayTypeChoosePop));
            }
          }));
    this.i.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              NormalPayTypeChoosePop normalPayTypeChoosePop = this.a;
              normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.c(normalPayTypeChoosePop));
            }
          }));
    this.z.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (NormalPayTypeChoosePop.d(this.a)) {
                NormalPayTypeChoosePop normalPayTypeChoosePop = this.a;
                normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.e(normalPayTypeChoosePop));
              } 
            }
          }));
    this.k.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              // Byte code:
              //   0: aload_0
              //   1: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   4: invokestatic f : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop$iChoosePayResultListener;
              //   7: ifnull -> 98
              //   10: aload_0
              //   11: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   14: invokestatic g : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)I
              //   17: istore_2
              //   18: iconst_1
              //   19: istore_3
              //   20: iload_2
              //   21: ifne -> 27
              //   24: goto -> 78
              //   27: aload_0
              //   28: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   31: invokestatic h : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)I
              //   34: iconst_1
              //   35: if_icmpne -> 76
              //   38: aload_0
              //   39: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   42: invokestatic i : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)I
              //   45: iconst_4
              //   46: if_icmpne -> 54
              //   49: iconst_1
              //   50: istore_2
              //   51: goto -> 62
              //   54: aload_0
              //   55: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   58: invokestatic i : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)I
              //   61: istore_2
              //   62: iload_2
              //   63: aload_0
              //   64: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   67: invokestatic g : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)I
              //   70: if_icmpeq -> 76
              //   73: goto -> 78
              //   76: iconst_0
              //   77: istore_3
              //   78: aload_0
              //   79: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   82: invokestatic f : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop$iChoosePayResultListener;
              //   85: aload_0
              //   86: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   89: invokestatic i : (Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;)I
              //   92: iload_3
              //   93: invokeinterface a : (IZ)V
              //   98: aload_0
              //   99: getfield a : Lcom/soft/blued/ui/msg/pop/NormalPayTypeChoosePop;
              //   102: invokevirtual p : ()V
              //   105: return
            }
          }));
  }
  
  public int getImplLayoutId() {
    return 2131493478;
  }
  
  public void getPayBeansGetDetail() {
    PayHttpUtils.c(new BluedUIHttpResponse<BluedEntityA<PayBeanDetail>>(this, this.v) {
          protected void a(BluedEntityA<PayBeanDetail> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.data != null && param1BluedEntityA.data.size() > 0) {
              PayBeanDetail payBeanDetail = param1BluedEntityA.data.get(0);
              if (payBeanDetail != null)
                if (payBeanDetail.is_support_beans == 1) {
                  NormalPayTypeChoosePop.l(this.a).setVisibility(0);
                  if (payBeanDetail.is_enough == 1) {
                    NormalPayTypeChoosePop.a(this.a, true);
                    NormalPayTypeChoosePop.m(this.a).setVisibility(0);
                    NormalPayTypeChoosePop.m(this.a).setText(String.format(NormalPayTypeChoosePop.n(this.a).getResources().getString(2131758242), new Object[] { StringUtils.a(String.valueOf(payBeanDetail.beans)) }));
                    return;
                  } 
                  NormalPayTypeChoosePop.a(this.a, false);
                  NormalPayTypeChoosePop.m(this.a).setVisibility(0);
                  NormalPayTypeChoosePop.m(this.a).setText(NormalPayTypeChoosePop.n(this.a).getResources().getString(2131758277));
                  NormalPayTypeChoosePop.l(this.a).setAlpha(0.5F);
                  if (NormalPayTypeChoosePop.i(this.a) == 3) {
                    NormalPayTypeChoosePop normalPayTypeChoosePop = this.a;
                    normalPayTypeChoosePop.setChoose(NormalPayTypeChoosePop.a(normalPayTypeChoosePop));
                    return;
                  } 
                } else {
                  NormalPayTypeChoosePop.l(this.a).setVisibility(8);
                }  
            } 
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            return super.onUIFailure(param1Int, param1String);
          }
        }this.w);
  }
  
  public void setChoose(ImageView paramImageView) {
    this.f.setImageResource(2131232665);
    this.h.setImageResource(2131232665);
    this.j.setImageResource(2131232665);
    this.A.setImageResource(2131232665);
    paramImageView.setImageResource(2131232456);
    switch (paramImageView.getId()) {
      case 2131297587:
        this.u = 2;
        break;
      case 2131297495:
        this.u = 4;
        break;
      case 2131297442:
        this.u = 3;
        break;
      case 2131297425:
        this.u = 1;
        break;
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("setChoose payPlatform:");
    stringBuilder.append(this.u);
    Log.v("drb", stringBuilder.toString());
  }
  
  public void t() {
    super.t();
    iChoosePayResultListener iChoosePayResultListener1 = this.b;
    if (iChoosePayResultListener1 != null)
      iChoosePayResultListener1.a(); 
  }
  
  public void v() {
    super.v();
    PayHttpUtils.a(a(this.v), this.w, this.v);
    getPayBeansGetDetail();
  }
  
  public static interface iChoosePayResultListener {
    void a();
    
    void a(int param1Int, boolean param1Boolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\NormalPayTypeChoosePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */