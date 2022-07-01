package org.chromium.net;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OperationCanceledException;
import android.os.Handler;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

final class HttpNegotiateAuthenticator$GetAccountsCallback implements AccountManagerCallback {
  private final HttpNegotiateAuthenticator$RequestData mRequestData;
  
  public HttpNegotiateAuthenticator$GetAccountsCallback(HttpNegotiateAuthenticator$RequestData paramHttpNegotiateAuthenticator$RequestData) {
    this.mRequestData = paramHttpNegotiateAuthenticator$RequestData;
  }
  
  public final void run(AccountManagerFuture paramAccountManagerFuture) {
    try {
      Account[] arrayOfAccount = (Account[])paramAccountManagerFuture.getResult();
      if (arrayOfAccount.length == 0) {
        Log.w("net_auth", "ERR_MISSING_AUTH_CREDENTIALS: No account provided for the kerberos authentication. Please verify the configuration policies and that the CONTACTS runtime permission is granted. ", new Object[0]);
        HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -341, null);
        return;
      } 
      if (arrayOfAccount.length > 1) {
        Log.w("net_auth", "ERR_MISSING_AUTH_CREDENTIALS: Found %d accounts eligible for the kerberos authentication. Please fix the configuration by providing a single account.", new Object[] { Integer.valueOf(arrayOfAccount.length) });
        HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -341, null);
        return;
      } 
      if (HttpNegotiateAuthenticator.lacksPermission(ContextUtils.sApplicationContext, "android.permission.USE_CREDENTIALS", true)) {
        Log.e("net_auth", "ERR_MISCONFIGURED_AUTH_ENVIRONMENT: USE_CREDENTIALS permission not granted. Aborting authentication.", new Object[0]);
        HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -343, null);
        return;
      } 
      this.mRequestData.account = arrayOfAccount[0];
      this.mRequestData.accountManager.getAuthToken(this.mRequestData.account, this.mRequestData.authTokenType, this.mRequestData.options, true, new HttpNegotiateAuthenticator$GetTokenCallback(HttpNegotiateAuthenticator.this, this.mRequestData), new Handler(ThreadUtils.getUiThreadLooper()));
      return;
    } catch (OperationCanceledException|android.accounts.AuthenticatorException|java.io.IOException operationCanceledException) {
      Log.w("net_auth", "ERR_UNEXPECTED: Error while attempting to retrieve accounts.", new Object[] { operationCanceledException });
      HttpNegotiateAuthenticator.this.nativeSetResult(this.mRequestData.nativeResultObject, -9, null);
      return;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\HttpNegotiateAuthenticator$GetAccountsCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */