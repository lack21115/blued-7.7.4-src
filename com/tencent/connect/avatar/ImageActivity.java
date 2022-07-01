package com.tencent.connect.avatar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.open.b.d;
import com.tencent.open.utils.Global;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.Util;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.json.JSONException;

public class ImageActivity extends Activity {
  RelativeLayout a;
  
  private QQToken b;
  
  private String c;
  
  private Handler d;
  
  private c e;
  
  private Button f;
  
  private Button g;
  
  private b h;
  
  private TextView i;
  
  private ProgressBar j;
  
  private int k = 0;
  
  private boolean l = false;
  
  private long m = 0L;
  
  private int n = 0;
  
  private final int o = 640;
  
  private final int p = 640;
  
  private Rect q = new Rect();
  
  private String r;
  
  private Bitmap s;
  
  private final View.OnClickListener t = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        ImageActivity.d(this.a).setVisibility(0);
        ImageActivity.e(this.a).setEnabled(false);
        ImageActivity.e(this.a).setTextColor(Color.rgb(21, 21, 21));
        ImageActivity.f(this.a).setEnabled(false);
        ImageActivity.f(this.a).setTextColor(Color.rgb(36, 94, 134));
        (new Thread(new Runnable(this) {
              public void run() {
                ImageActivity.g(this.a.a);
              }
            })).start();
        if (ImageActivity.h(this.a)) {
          this.a.a("10657", 0L);
          return;
        } 
        long l1 = System.currentTimeMillis();
        long l2 = ImageActivity.i(this.a);
        this.a.a("10655", l1 - l2);
        if ((ImageActivity.c(this.a)).b)
          this.a.a("10654", 0L); 
      }
    };
  
  private final View.OnClickListener u = new View.OnClickListener(this) {
      public void onClick(View param1View) {
        long l1 = System.currentTimeMillis();
        long l2 = ImageActivity.i(this.a);
        this.a.a("10656", l1 - l2);
        this.a.setResult(0);
        ImageActivity.j(this.a);
      }
    };
  
  private final IUiListener v = new IUiListener(this) {
      public void onCancel() {}
      
      public void onComplete(Object param1Object) {
        ImageActivity.e(this.a).setEnabled(true);
        Button button = ImageActivity.e(this.a);
        int i = -1;
        button.setTextColor(-1);
        ImageActivity.f(this.a).setEnabled(true);
        ImageActivity.f(this.a).setTextColor(-1);
        ImageActivity.d(this.a).setVisibility(8);
        param1Object = param1Object;
        try {
          int j = param1Object.getInt("ret");
          i = j;
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        if (i == 0) {
          ImageActivity.b(this.a, "设置成功", 0);
          this.a.a("10658", 0L);
          d.a().a(ImageActivity.k(this.a).getOpenId(), ImageActivity.k(this.a).getAppId(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "3", "0");
          ImageActivity imageActivity = this.a;
          if (ImageActivity.l(imageActivity) != null && !"".equals(ImageActivity.l(this.a))) {
            Intent intent = new Intent();
            intent.setClassName((Context)imageActivity, ImageActivity.l(this.a));
            if (imageActivity.getPackageManager().resolveActivity(intent, 0) != null)
              imageActivity.startActivity(intent); 
          } 
          ImageActivity.a(this.a, 0, param1Object.toString(), (String)null, (String)null);
          ImageActivity.j(this.a);
          return;
        } 
        ImageActivity.b(this.a, "设置出错了，请重新登录再尝试下呢：）", 1);
        d.a().a(ImageActivity.k(this.a).getOpenId(), ImageActivity.k(this.a).getAppId(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "1");
      }
      
      public void onError(UiError param1UiError) {
        ImageActivity.e(this.a).setEnabled(true);
        ImageActivity.e(this.a).setTextColor(-1);
        ImageActivity.f(this.a).setEnabled(true);
        ImageActivity.f(this.a).setTextColor(-1);
        ImageActivity.f(this.a).setText("重试");
        ImageActivity.d(this.a).setVisibility(8);
        ImageActivity.a(this.a, true);
        ImageActivity.b(this.a, param1UiError.errorMessage, 1);
        this.a.a("10660", 0L);
      }
    };
  
  private final IUiListener w = new IUiListener(this) {
      private void a(int param1Int) {
        if (ImageActivity.n(this.a) < 2)
          ImageActivity.o(this.a); 
      }
      
      public void onCancel() {}
      
      public void onComplete(Object param1Object) {
        param1Object = param1Object;
        int i = -1;
        try {
          int j = param1Object.getInt("ret");
          if (j == 0) {
            i = j;
            param1Object = param1Object.getString("nickname");
            i = j;
            ImageActivity.m(this.a).post(new Runnable(this, (String)param1Object) {
                  public void run() {
                    ImageActivity.b(this.b.a, this.a);
                  }
                });
            i = j;
            this.a.a("10659", 0L);
            i = j;
          } else {
            i = j;
            this.a.a("10661", 0L);
            i = j;
          } 
        } catch (JSONException jSONException) {
          jSONException.printStackTrace();
        } 
        if (i != 0)
          a(i); 
      }
      
      public void onError(UiError param1UiError) {
        a(0);
      }
    };
  
  private Bitmap a(String paramString) throws IOException {
    BitmapFactory.Options options = new BitmapFactory.Options();
    int j = 1;
    options.inJustDecodeBounds = true;
    Uri uri = Uri.parse(paramString);
    InputStream inputStream = getContentResolver().openInputStream(uri);
    if (inputStream == null)
      return null; 
    try {
      BitmapFactory.decodeStream(inputStream, null, options);
    } catch (OutOfMemoryError outOfMemoryError) {
      outOfMemoryError.printStackTrace();
    } 
    inputStream.close();
    int k = options.outWidth;
    int i = options.outHeight;
    while (true) {
      if (k * i <= 4194304) {
        options.inJustDecodeBounds = false;
        options.inSampleSize = j;
        InputStream inputStream1 = getContentResolver().openInputStream(uri);
        try {
          return BitmapFactory.decodeStream(inputStream1, null, options);
        } catch (OutOfMemoryError outOfMemoryError) {
          outOfMemoryError.printStackTrace();
          return null;
        } 
      } 
      k /= 2;
      i /= 2;
      j *= 2;
    } 
  }
  
  private View a() {
    ViewGroup.LayoutParams layoutParams7 = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, -1);
    ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
    this.a = new RelativeLayout((Context)this);
    this.a.setLayoutParams(layoutParams7);
    this.a.setBackgroundColor(-16777216);
    RelativeLayout relativeLayout2 = new RelativeLayout((Context)this);
    relativeLayout2.setLayoutParams(layoutParams2);
    this.a.addView((View)relativeLayout2);
    this.e = new c((Context)this);
    this.e.setLayoutParams(layoutParams4);
    this.e.setScaleType(ImageView.ScaleType.MATRIX);
    relativeLayout2.addView((View)this.e);
    this.h = new b((Context)this);
    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(layoutParams4);
    layoutParams3.addRule(14, -1);
    layoutParams3.addRule(15, -1);
    this.h.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
    relativeLayout2.addView(this.h);
    LinearLayout linearLayout = new LinearLayout((Context)this);
    RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, a.a((Context)this, 80.0F));
    layoutParams6.addRule(14, -1);
    linearLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
    linearLayout.setOrientation(0);
    linearLayout.setGravity(17);
    this.a.addView((View)linearLayout);
    ImageView imageView = new ImageView((Context)this);
    imageView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(a.a((Context)this, 24.0F), a.a((Context)this, 24.0F)));
    imageView.setImageDrawable(b("com.tencent.plus.logo.png"));
    linearLayout.addView((View)imageView);
    this.i = new TextView((Context)this);
    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(layoutParams2);
    layoutParams.leftMargin = a.a((Context)this, 7.0F);
    this.i.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
    this.i.setEllipsize(TextUtils.TruncateAt.END);
    this.i.setSingleLine();
    this.i.setTextColor(-1);
    this.i.setTextSize(24.0F);
    this.i.setVisibility(8);
    linearLayout.addView((View)this.i);
    RelativeLayout relativeLayout1 = new RelativeLayout((Context)this);
    RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, a.a((Context)this, 60.0F));
    layoutParams5.addRule(12, -1);
    layoutParams5.addRule(9, -1);
    relativeLayout1.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
    relativeLayout1.setBackgroundDrawable(b("com.tencent.plus.bar.png"));
    int i = a.a((Context)this, 10.0F);
    relativeLayout1.setPadding(i, i, i, 0);
    this.a.addView((View)relativeLayout1);
    a a = new a(this, (Context)this);
    i = a.a((Context)this, 14.0F);
    int j = a.a((Context)this, 7.0F);
    this.g = new Button((Context)this);
    RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(a.a((Context)this, 78.0F), a.a((Context)this, 45.0F));
    this.g.setLayoutParams((ViewGroup.LayoutParams)layoutParams8);
    this.g.setText("取消");
    this.g.setTextColor(-1);
    this.g.setTextSize(18.0F);
    this.g.setPadding(i, j, i, j);
    a.b(this.g);
    relativeLayout1.addView((View)this.g);
    this.f = new Button((Context)this);
    layoutParams8 = new RelativeLayout.LayoutParams(a.a((Context)this, 78.0F), a.a((Context)this, 45.0F));
    layoutParams8.addRule(11, -1);
    this.f.setLayoutParams((ViewGroup.LayoutParams)layoutParams8);
    this.f.setTextColor(-1);
    this.f.setTextSize(18.0F);
    this.f.setPadding(i, j, i, j);
    this.f.setText("选取");
    a.a(this.f);
    relativeLayout1.addView((View)this.f);
    TextView textView = new TextView((Context)this);
    layoutParams8 = new RelativeLayout.LayoutParams(layoutParams2);
    layoutParams8.addRule(13, -1);
    textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams8);
    textView.setText("移动和缩放");
    textView.setPadding(0, a.a((Context)this, 3.0F), 0, 0);
    textView.setTextSize(18.0F);
    textView.setTextColor(-1);
    relativeLayout1.addView((View)textView);
    this.j = new ProgressBar((Context)this);
    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(layoutParams2);
    layoutParams1.addRule(14, -1);
    layoutParams1.addRule(15, -1);
    this.j.setLayoutParams((ViewGroup.LayoutParams)layoutParams1);
    this.j.setVisibility(8);
    this.a.addView((View)this.j);
    return (View)this.a;
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3) {
    Intent intent = new Intent();
    intent.putExtra("key_error_code", paramInt);
    intent.putExtra("key_error_msg", paramString2);
    intent.putExtra("key_error_detail", paramString3);
    intent.putExtra("key_response", paramString1);
    setResult(-1, intent);
  }
  
  private void a(Bitmap paramBitmap) {
    (new QQAvatarImp(this, this.b)).setAvator(paramBitmap, this.v);
  }
  
  private void a(String paramString, int paramInt) {
    this.d.post(new Runnable(this, paramString, paramInt) {
          public void run() {
            ImageActivity.a(this.c, this.a, this.b);
          }
        });
  }
  
  private Drawable b(String paramString) {
    AssetManager assetManager = getAssets();
    Drawable drawable2 = null;
    Drawable drawable1 = drawable2;
    try {
      InputStream inputStream = assetManager.open(paramString);
      drawable1 = drawable2;
      Drawable drawable = Drawable.createFromStream(inputStream, paramString);
      drawable1 = drawable;
      inputStream.close();
      return drawable;
    } catch (IOException iOException) {
      iOException.printStackTrace();
      return drawable1;
    } 
  }
  
  private void b() {
    try {
      this.s = a(this.r);
      if (this.s != null) {
        this.e.setImageBitmap(this.s);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cannot read picture: '");
        stringBuilder.append(this.r);
        stringBuilder.append("'!");
        throw new IOException(stringBuilder.toString());
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
      a("图片读取失败，请检查该图片是否有效", 1);
      a(-5, (String)null, "图片读取失败，请检查该图片是否有效", iOException.getMessage());
      d();
    } 
    this.f.setOnClickListener(this.t);
    this.g.setOnClickListener(this.u);
    this.a.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ImageActivity imageActivity = this.a;
            ImageActivity.a(imageActivity, ImageActivity.a(imageActivity).a());
            ImageActivity.c(this.a).a(ImageActivity.b(this.a));
          }
        });
  }
  
  private void b(String paramString, int paramInt) {
    Toast toast = Toast.makeText((Context)this, paramString, 1);
    LinearLayout linearLayout = (LinearLayout)toast.getView();
    ((TextView)linearLayout.getChildAt(0)).setPadding(8, 0, 0, 0);
    ImageView imageView = new ImageView((Context)this);
    imageView.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(a.a((Context)this, 16.0F), a.a((Context)this, 16.0F)));
    if (paramInt == 0) {
      imageView.setImageDrawable(b("com.tencent.plus.ic_success.png"));
    } else {
      imageView.setImageDrawable(b("com.tencent.plus.ic_error.png"));
    } 
    linearLayout.addView((View)imageView, 0);
    linearLayout.setOrientation(0);
    linearLayout.setGravity(17);
    toast.setView((View)linearLayout);
    toast.setGravity(17, 0, 0);
    toast.show();
  }
  
  private void c() {
    float f4 = this.q.width();
    Matrix matrix1 = this.e.getImageMatrix();
    float[] arrayOfFloat = new float[9];
    matrix1.getValues(arrayOfFloat);
    float f1 = arrayOfFloat[2];
    float f2 = arrayOfFloat[5];
    float f3 = arrayOfFloat[0];
    f4 = 640.0F / f4;
    int i = (int)((this.q.left - f1) / f3);
    if (i < 0)
      i = 0; 
    int j = (int)((this.q.top - f2) / f3);
    if (j < 0)
      j = 0; 
    Matrix matrix2 = new Matrix();
    matrix2.set(matrix1);
    matrix2.postScale(f4, f4);
    int m = (int)(650.0F / f3);
    int k = Math.min(this.s.getWidth() - i, m);
    m = Math.min(this.s.getHeight() - j, m);
    try {
      Bitmap bitmap1 = Bitmap.createBitmap(this.s, i, j, k, m, matrix2, true);
      Bitmap bitmap2 = Bitmap.createBitmap(bitmap1, 0, 0, 640, 640);
      bitmap1.recycle();
      a(bitmap2);
      return;
    } catch (IllegalArgumentException illegalArgumentException) {
      illegalArgumentException.printStackTrace();
      a("图片读取失败，请检查该图片是否有效", 1);
      a(-5, (String)null, "图片读取失败，请检查该图片是否有效", illegalArgumentException.getMessage());
      d();
      return;
    } 
  }
  
  private void c(String paramString) {
    paramString = d(paramString);
    if (!"".equals(paramString)) {
      this.i.setText(paramString);
      this.i.setVisibility(0);
    } 
  }
  
  private String d(String paramString) {
    return paramString.replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&quot;", "\"").replaceAll("&#39;", "'").replaceAll("&amp;", "&");
  }
  
  private void d() {
    finish();
    int i = this.n;
    if (i != 0)
      overridePendingTransition(0, i); 
  }
  
  private void e() {
    this.k++;
    (new UserInfo((Context)this, this.b)).getUserInfo(this.w);
  }
  
  public void a(String paramString, long paramLong) {
    Util.reportBernoulli((Context)this, paramString, paramLong, this.b.getAppId());
  }
  
  public void onBackPressed() {
    setResult(0);
    d();
  }
  
  public void onCreate(Bundle paramBundle) {
    requestWindowFeature(1);
    super.onCreate(paramBundle);
    setRequestedOrientation(1);
    setContentView(a());
    this.d = new Handler();
    Bundle bundle = getIntent().getBundleExtra("key_params");
    this.r = bundle.getString("picture");
    this.c = bundle.getString("return_activity");
    String str3 = bundle.getString("appid");
    String str1 = bundle.getString("access_token");
    long l = bundle.getLong("expires_in");
    String str2 = bundle.getString("openid");
    this.n = bundle.getInt("exitAnim");
    this.b = new QQToken(str3);
    QQToken qQToken = this.b;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append((l - System.currentTimeMillis()) / 1000L);
    stringBuilder.append("");
    qQToken.setAccessToken(str1, stringBuilder.toString());
    this.b.setOpenId(str2);
    b();
    e();
    this.m = System.currentTimeMillis();
    a("10653", 0L);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    this.e.setImageBitmap((Bitmap)null);
    Bitmap bitmap = this.s;
    if (bitmap != null && !bitmap.isRecycled())
      this.s.recycle(); 
  }
  
  class QQAvatarImp extends BaseApi {
    public QQAvatarImp(ImageActivity this$0, QQToken param1QQToken) {
      super(param1QQToken);
    }
    
    public void setAvator(Bitmap param1Bitmap, IUiListener param1IUiListener) {
      Bundle bundle = composeCGIParams();
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      param1Bitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
      byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
      param1Bitmap.recycle();
      BaseApi.TempRequestListener tempRequestListener = new BaseApi.TempRequestListener(this, param1IUiListener);
      bundle.putByteArray("picture", arrayOfByte);
      HttpUtils.requestAsync(this.mToken, Global.getContext(), "user/set_user_face", bundle, "POST", (IRequestListener)tempRequestListener);
      d.a().a(this.mToken.getOpenId(), this.mToken.getAppId(), "ANDROIDSDK.SETAVATAR.SUCCEED", "12", "19", "0");
    }
  }
  
  class a extends View {
    public a(ImageActivity this$0, Context param1Context) {
      super(param1Context);
    }
    
    public void a(Button param1Button) {
      StateListDrawable stateListDrawable = new StateListDrawable();
      Drawable drawable1 = ImageActivity.a(this.a, "com.tencent.plus.blue_normal.png");
      Drawable drawable2 = ImageActivity.a(this.a, "com.tencent.plus.blue_down.png");
      Drawable drawable3 = ImageActivity.a(this.a, "com.tencent.plus.blue_disable.png");
      stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawable2);
      stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawable1);
      stateListDrawable.addState(View.ENABLED_STATE_SET, drawable1);
      stateListDrawable.addState(View.FOCUSED_STATE_SET, drawable1);
      stateListDrawable.addState(View.EMPTY_STATE_SET, drawable3);
      param1Button.setBackgroundDrawable((Drawable)stateListDrawable);
    }
    
    public void b(Button param1Button) {
      StateListDrawable stateListDrawable = new StateListDrawable();
      Drawable drawable1 = ImageActivity.a(this.a, "com.tencent.plus.gray_normal.png");
      Drawable drawable2 = ImageActivity.a(this.a, "com.tencent.plus.gray_down.png");
      Drawable drawable3 = ImageActivity.a(this.a, "com.tencent.plus.gray_disable.png");
      stateListDrawable.addState(View.PRESSED_ENABLED_STATE_SET, drawable2);
      stateListDrawable.addState(View.ENABLED_FOCUSED_STATE_SET, drawable1);
      stateListDrawable.addState(View.ENABLED_STATE_SET, drawable1);
      stateListDrawable.addState(View.FOCUSED_STATE_SET, drawable1);
      stateListDrawable.addState(View.EMPTY_STATE_SET, drawable3);
      param1Button.setBackgroundDrawable((Drawable)stateListDrawable);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\connect\avatar\ImageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */