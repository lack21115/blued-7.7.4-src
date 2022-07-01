package org.chromium.net;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;

final class HttpNegotiateAuthenticator$GetTokenCallback implements AccountManagerCallback {
  private final HttpNegotiateAuthenticator$RequestData mRequestData;
  
  public HttpNegotiateAuthenticator$GetTokenCallback(HttpNegotiateAuthenticator$RequestData paramHttpNegotiateAuthenticator$RequestData) {
    this.mRequestData = paramHttpNegotiateAuthenticator$RequestData;
  }
  
  public final void run(AccountManagerFuture paramAccountManagerFuture) {
    try {
      Context context;
      Bundle bundle = (Bundle)paramAccountManagerFuture.getResult();
      if (bundle.containsKey("intent")) {
        context = ContextUtils.sApplicationContext;
        context.registerReceiver(new HttpNegotiateAuthenticator$GetTokenCallback$1(this, context), new IntentFilter("android.accounts.LOGIN_ACCOUNTS_CHANGED"));
        return;
      } 
      HttpNegotiateAuthenticator.access$100(HttpNegotiateAuthenticator.this, (Bundle)context, this.mRequestData);
      return;
    } catch (OperationCanceledException|android.accounts.AuthenticatorException|java.io.IOException operationCanceledException) {
      Log.w("net_auth", "ERR_UNEXPECTED: Error while attempting to obtain a token.", new Object[] { operationCanceledException });
      HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\HttpNegotiateAuthenticator$GetTokenCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */