package com.soft.blued.ui.msg.pop;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.xpop.core.BottomPopupView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeLinearLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.soft.blued.http.PayHttpUtils;
import com.soft.blued.ui.user.model.PayPlatformDiscountModel;
import com.soft.blued.utils.click.SingleClickProxy;

public class UserGiftPayTypeChoosePop extends BottomPopupView {
  private iChoosePayResultListener b;
  
  private TextView c;
  
  private ShapeLinearLayout d;
  
  private ImageView e;
  
  private ShapeLinearLayout f;
  
  private LinearLayout g;
  
  private ShapeTextView h;
  
  private ImageView i;
  
  private LinearLayout j;
  
  private ImageView k;
  
  private LinearLayout t;
  
  private ImageView u;
  
  private ShapeTextView v;
  
  private int w;
  
  private View x;
  
  private IRequestHost y;
  
  private void c() {
    this.c = (TextView)findViewById(2131301409);
    this.d = (ShapeLinearLayout)findViewById(2131298717);
    ShapeHelper.b((ShapeHelper.ShapeView)this.d, 2131100728);
    this.e = (ImageView)findViewById(2131297442);
    this.f = (ShapeLinearLayout)findViewById(2131299003);
    ShapeHelper.b((ShapeHelper.ShapeView)this.f, 2131100728);
    this.g = (LinearLayout)findViewById(2131298698);
    this.h = (ShapeTextView)findViewById(2131300508);
    this.i = (ImageView)findViewById(2131297425);
    this.j = (LinearLayout)findViewById(2131299142);
    this.k = (ImageView)findViewById(2131297587);
    this.t = (LinearLayout)findViewById(2131298887);
    this.u = (ImageView)findViewById(2131297495);
    this.v = (ShapeTextView)findViewById(2131300656);
    this.x = findViewById(2131299451);
  }
  
  public BluedUIHttpResponse a(IRequestHost paramIRequestHost) {
    return new BluedUIHttpResponse<BluedEntityA<PayPlatformDiscountModel>>(this, paramIRequestHost) {
        protected void a(BluedEntityA<PayPlatformDiscountModel> param1BluedEntityA) {
          if (param1BluedEntityA.hasData() && param1BluedEntityA.getSingleData() != null && ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel != null && ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel != null && ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel.alipay != null) {
            String str = ((PayPlatformDiscountModel)param1BluedEntityA.getSingleData()).channel.alipay.desc;
            UserGiftPayTypeChoosePop.h(this.a).setText(str);
          } 
        }
        
        public void onUIFinish(boolean param1Boolean) {
          // Byte code:
          //   0: aload_0
          //   1: iload_1
          //   2: invokespecial onUIFinish : (Z)V
          //   5: iload_1
          //   6: ifeq -> 63
          //   9: new java/lang/StringBuilder
          //   12: dup
          //   13: invokespecial <init> : ()V
          //   16: astore_2
          //   17: aload_2
          //   18: aload_0
          //   19: getfield a : Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;
          //   22: invokestatic h : (Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;)Lcom/blued/android/framework/view/shape/ShapeTextView;
          //   25: invokevirtual getText : ()Ljava/lang/CharSequence;
          //   28: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   31: pop
          //   32: aload_2
          //   33: ldc ''
          //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   38: pop
          //   39: aload_2
          //   40: invokevirtual toString : ()Ljava/lang/String;
          //   43: invokestatic e : (Ljava/lang/String;)Z
          //   46: ifne -> 63
          //   49: aload_0
          //   50: getfield a : Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;
          //   53: invokestatic h : (Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;)Lcom/blued/android/framework/view/shape/ShapeTextView;
          //   56: iconst_0
          //   57: invokevirtual setVisibility : (I)V
          //   60: goto -> 75
          //   63: aload_0
          //   64: getfield a : Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;
          //   67: invokestatic h : (Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;)Lcom/blued/android/framework/view/shape/ShapeTextView;
          //   70: bipush #8
          //   72: invokevirtual setVisibility : (I)V
          //   75: aload_0
          //   76: getfield a : Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;
          //   79: invokestatic g : (Lcom/soft/blued/ui/msg/pop/UserGiftPayTypeChoosePop;)Landroid/view/View;
          //   82: bipush #8
          //   84: invokevirtual setVisibility : (I)V
          //   87: return
        }
        
        public void onUIStart() {
          super.onUIStart();
          UserGiftPayTypeChoosePop.g(this.a).setVisibility(0);
        }
      };
  }
  
  public void b() {
    super.b();
    c();
    int i = this.w;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4)
            setChoose(this.u); 
        } else {
          setChoose(this.e);
        } 
      } else {
        setChoose(this.k);
      } 
    } else {
      setChoose(this.i);
    } 
    this.g.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = this.a;
              userGiftPayTypeChoosePop.setChoose(UserGiftPayTypeChoosePop.a(userGiftPayTypeChoosePop));
            }
          }));
    this.j.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = this.a;
              userGiftPayTypeChoosePop.setChoose(UserGiftPayTypeChoosePop.b(userGiftPayTypeChoosePop));
            }
          }));
    this.t.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = this.a;
              userGiftPayTypeChoosePop.setChoose(UserGiftPayTypeChoosePop.c(userGiftPayTypeChoosePop));
            }
          }));
    this.d.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              UserGiftPayTypeChoosePop userGiftPayTypeChoosePop = this.a;
              userGiftPayTypeChoosePop.setChoose(UserGiftPayTypeChoosePop.d(userGiftPayTypeChoosePop));
            }
          }));
    this.v.setOnClickListener((View.OnClickListener)new SingleClickProxy(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (UserGiftPayTypeChoosePop.e(this.a) != null)
                UserGiftPayTypeChoosePop.e(this.a).a(UserGiftPayTypeChoosePop.f(this.a)); 
              this.a.p();
            }
          }));
  }
  
  public int getImplLayoutId() {
    return 2131493478;
  }
  
  public void setChoose(ImageView paramImageView) {
    this.i.setImageResource(2131232665);
    this.k.setImageResource(2131232665);
    this.u.setImageResource(2131232665);
    this.e.setImageResource(2131232665);
    paramImageView.setImageResource(2131232456);
    switch (paramImageView.getId()) {
      default:
        return;
      case 2131297587:
        this.w = 2;
        return;
      case 2131297495:
        this.w = 4;
        return;
      case 2131297442:
        this.w = 3;
        return;
      case 2131297425:
        break;
    } 
    this.w = 1;
  }
  
  public void v() {
    super.v();
    PayHttpUtils.a(a(this.y), 0, this.y);
  }
  
  public static interface iChoosePayResultListener {
    void a(int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\pop\UserGiftPayTypeChoosePop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */