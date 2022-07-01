package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class HttpNegotiateAuthenticator$GetTokenCallback$1 extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    appContext.unregisterReceiver(this);
    (HttpNegotiateAuthenticator$GetTokenCallback.access$000(HttpNegotiateAuthenticator$GetTokenCallback.this)).accountManager.getAuthToken((HttpNegotiateAuthenticator$GetTokenCallback.access$000(HttpNegotiateAuthenticator$GetTokenCallback.this)).account, (HttpNegotiateAuthenticator$GetTokenCallback.access$000(HttpNegotiateAuthenticator$GetTokenCallback.this)).authTokenType, (HttpNegotiateAuthenticator$GetTokenCallback.access$000(HttpNegotiateAuthenticator$GetTokenCallback.this)).options, true, new HttpNegotiateAuthenticator$GetTokenCallback(this.this$1.this$0, HttpNegotiateAuthenticator$GetTokenCallback.access$000(HttpNegotiateAuthenticator$GetTokenCallback.this)), null);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\net\HttpNegotiateAuthenticator$GetTokenCallback$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */