package org.chromium.device.geolocation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import java.util.Collections;
import java.util.List;
import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

public class LocationProviderGmsCore implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener, LocationProvider {
  private boolean mEnablehighAccuracy;
  
  private final GoogleApiClient mGoogleApiClient;
  
  private FusedLocationProviderApi mLocationProviderApi = LocationServices.FusedLocationApi;
  
  private LocationRequest mLocationRequest;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  LocationProviderGmsCore(Context paramContext) {
    Log.i("cr_LocationProvider", "Google Play Services", new Object[0]);
    GoogleApiClient.Builder builder = new GoogleApiClient.Builder(paramContext);
    Api api = LocationServices.API;
    zzbq.checkNotNull(api, "Api must not be null");
    builder.zzftc.put(api, null);
    List<?> list = Collections.emptyList();
    builder.zzfsx.addAll(list);
    builder.zzfsw.addAll(list);
    zzbq.checkNotNull(this, "Listener must not be null");
    builder.zzfti.add(this);
    zzbq.checkNotNull(this, "Listener must not be null");
    builder.zzftj.add(this);
    this.mGoogleApiClient = builder.build();
    assert false;
  }
  
  public static boolean isGooglePlayServicesAvailable(Context paramContext) {
    return (GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(paramContext) == 0);
  }
  
  public final void onConnected(Bundle paramBundle) {
    ThreadUtils.assertOnUiThread();
    this.mLocationRequest = LocationRequest.create();
    if (this.mEnablehighAccuracy) {
      this.mLocationRequest.setPriority(100).setInterval(500L);
    } else {
      this.mLocationRequest.setPriority(102).setInterval(1000L);
    } 
    Location location = this.mLocationProviderApi.getLastLocation(this.mGoogleApiClient);
    if (location != null)
      LocationProviderAdapter.onNewLocationAvailable(location); 
    try {
      this.mLocationProviderApi.requestLocationUpdates(this.mGoogleApiClient, this.mLocationRequest, this, ThreadUtils.getUiThreadLooper());
      return;
    } catch (IllegalStateException|SecurityException illegalStateException) {
      StringBuilder stringBuilder = new StringBuilder(" mLocationProviderApi.requestLocationUpdates() ");
      stringBuilder.append(illegalStateException);
      Log.e("cr_LocationProvider", stringBuilder.toString(), new Object[0]);
      stringBuilder = new StringBuilder("Failed to request location updates: ");
      stringBuilder.append(illegalStateException.toString());
      LocationProviderAdapter.newErrorAvailable(stringBuilder.toString());
      assert false;
      throw new AssertionError();
    } 
  }
  
  public final void onConnectionFailed(ConnectionResult paramConnectionResult) {
    StringBuilder stringBuilder = new StringBuilder("Failed to connect to Google Play Services: ");
    stringBuilder.append(paramConnectionResult.toString());
    LocationProviderAdapter.newErrorAvailable(stringBuilder.toString());
  }
  
  public final void onConnectionSuspended(int paramInt) {}
  
  public final void onLocationChanged(Location paramLocation) {
    LocationProviderAdapter.onNewLocationAvailable(paramLocation);
  }
  
  public final void start(boolean paramBoolean) {
    ThreadUtils.assertOnUiThread();
    if (this.mGoogleApiClient.isConnected())
      this.mGoogleApiClient.disconnect(); 
    this.mEnablehighAccuracy = paramBoolean;
    this.mGoogleApiClient.connect();
  }
  
  public final void stop() {
    ThreadUtils.assertOnUiThread();
    if (!this.mGoogleApiClient.isConnected())
      return; 
    this.mLocationProviderApi.removeLocationUpdates(this.mGoogleApiClient, this);
    this.mGoogleApiClient.disconnect();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\device\geolocation\LocationProviderGmsCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */