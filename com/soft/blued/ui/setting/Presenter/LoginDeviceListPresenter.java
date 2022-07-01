package com.soft.blued.ui.setting.Presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.soft.blued.http.LoginRegisterHttpUtils;
import com.soft.blued.ui.setting.Contract.LoginDeviceListContract;
import com.soft.blued.ui.setting.model.DeviceModel;
import com.soft.blued.ui.setting.model.LoginProtectionModel;
import java.util.ArrayList;
import java.util.List;

public class LoginDeviceListPresenter implements LoginDeviceListContract.IPresenter {
  private LoginDeviceListContract.IView a;
  
  private IRequestHost b;
  
  private List<DeviceModel> c;
  
  public LoginDeviceListPresenter(LoginDeviceListContract.IView paramIView, IRequestHost paramIRequestHost) {
    this.a = paramIView;
    this.b = paramIRequestHost;
    this.c = new ArrayList<DeviceModel>();
  }
  
  public void a(String paramString1, String paramString2) {
    LoginRegisterHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<LoginProtectionModel>>(this, this.b, paramString1) {
          protected void a(BluedEntityA<LoginProtectionModel> param1BluedEntityA) {
            // Byte code:
            //   0: aload_0
            //   1: getfield a : Ljava/lang/String;
            //   4: astore_3
            //   5: aload_3
            //   6: invokevirtual hashCode : ()I
            //   9: istore_2
            //   10: iload_2
            //   11: ldc -1335458389
            //   13: if_icmpeq -> 59
            //   16: iload_2
            //   17: ldc 102230
            //   19: if_icmpeq -> 45
            //   22: iload_2
            //   23: ldc 113762
            //   25: if_icmpeq -> 31
            //   28: goto -> 73
            //   31: aload_3
            //   32: ldc 'set'
            //   34: invokevirtual equals : (Ljava/lang/Object;)Z
            //   37: ifeq -> 73
            //   40: iconst_0
            //   41: istore_2
            //   42: goto -> 75
            //   45: aload_3
            //   46: ldc 'get'
            //   48: invokevirtual equals : (Ljava/lang/Object;)Z
            //   51: ifeq -> 73
            //   54: iconst_1
            //   55: istore_2
            //   56: goto -> 75
            //   59: aload_3
            //   60: ldc 'delete'
            //   62: invokevirtual equals : (Ljava/lang/Object;)Z
            //   65: ifeq -> 73
            //   68: iconst_2
            //   69: istore_2
            //   70: goto -> 75
            //   73: iconst_m1
            //   74: istore_2
            //   75: iload_2
            //   76: ifeq -> 128
            //   79: aload_1
            //   80: ifnull -> 169
            //   83: aload_1
            //   84: invokevirtual hasData : ()Z
            //   87: ifeq -> 169
            //   90: aload_0
            //   91: getfield b : Lcom/soft/blued/ui/setting/Presenter/LoginDeviceListPresenter;
            //   94: aload_1
            //   95: invokevirtual getSingleData : ()Ljava/lang/Object;
            //   98: checkcast com/soft/blued/ui/setting/model/LoginProtectionModel
            //   101: getfield devices : Ljava/util/List;
            //   104: invokestatic a : (Lcom/soft/blued/ui/setting/Presenter/LoginDeviceListPresenter;Ljava/util/List;)Ljava/util/List;
            //   107: pop
            //   108: aload_0
            //   109: getfield b : Lcom/soft/blued/ui/setting/Presenter/LoginDeviceListPresenter;
            //   112: invokestatic a : (Lcom/soft/blued/ui/setting/Presenter/LoginDeviceListPresenter;)Lcom/soft/blued/ui/setting/Contract/LoginDeviceListContract$IView;
            //   115: aload_1
            //   116: invokevirtual getSingleData : ()Ljava/lang/Object;
            //   119: checkcast com/soft/blued/ui/setting/model/LoginProtectionModel
            //   122: invokeinterface a : (Lcom/soft/blued/ui/setting/model/LoginProtectionModel;)V
            //   127: return
            //   128: aload_1
            //   129: ifnull -> 153
            //   132: aload_1
            //   133: invokevirtual hasData : ()Z
            //   136: ifeq -> 153
            //   139: aload_1
            //   140: invokevirtual getSingleData : ()Ljava/lang/Object;
            //   143: checkcast com/soft/blued/ui/setting/model/LoginProtectionModel
            //   146: getfield mobile : Ljava/lang/String;
            //   149: astore_1
            //   150: goto -> 156
            //   153: ldc ''
            //   155: astore_1
            //   156: aload_0
            //   157: getfield b : Lcom/soft/blued/ui/setting/Presenter/LoginDeviceListPresenter;
            //   160: invokestatic a : (Lcom/soft/blued/ui/setting/Presenter/LoginDeviceListPresenter;)Lcom/soft/blued/ui/setting/Contract/LoginDeviceListContract$IView;
            //   163: aload_1
            //   164: invokeinterface a : (Ljava/lang/String;)V
            //   169: return
          }
          
          public boolean onUIFailure(int param1Int, String param1String) {
            if (param1Int != 4035008) {
              if ("set".equals(this.a)) {
                LoginDeviceListPresenter.a(this.b).a(false);
              } else if ("close".equals(this.a)) {
                LoginDeviceListPresenter.a(this.b).a(true);
              } 
              return super.onUIFailure(param1Int, param1String);
            } 
            LoginDeviceListPresenter.a(this.b).c();
            return true;
          }
          
          public void onUIFinish() {
            super.onUIFinish();
            LoginDeviceListPresenter.a(this.b).b();
          }
          
          public void onUIStart() {
            super.onUIStart();
            LoginDeviceListPresenter.a(this.b).a();
          }
        }paramString1, "", paramString2, this.b);
  }
  
  public List<DeviceModel> b() {
    return this.c;
  }
  
  public void bb_() {
    a("get", "");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\setting\Presenter\LoginDeviceListPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */