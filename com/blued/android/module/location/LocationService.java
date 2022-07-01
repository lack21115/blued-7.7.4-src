package com.blued.android.module.location;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.blued.android.module.location.gaode.GaoDeLocationService;
import com.blued.android.module.location.gaode.GaoDePoiService;
import com.blued.android.module.location.google.GoogleLocationService;
import com.blued.android.module.location.lifecycle.LiveEvent;
import com.blued.android.module.location.listener.OnLocationListener;
import com.blued.android.module.location.listener.OnLocationRequestListener;
import com.blued.android.module.location.listener.OnPoiListener;
import com.blued.android.module.location.listener.OnPoiRequestListener;
import com.blued.android.module.location.model.LocationModel;
import com.blued.android.module.location.model.LocationPOIModel;
import com.blued.android.module.location.model.POIModel;
import com.blued.android.module.location.utils.AppUtils;
import com.blued.android.module.location.utils.BluedPoiUtils;
import com.blued.android.module.location.utils.LocationCacheUtils;
import com.blued.android.module.location.utils.LocationLiveDataUtils;
import com.blued.android.module.location.utils.POILiveDataUtils;
import com.blued.android.module.location.utils.ThreadUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LocationService {
  private static LocationType a = LocationType.a;
  
  private static LocationStatus b = LocationStatus.a;
  
  private static long c = 0L;
  
  private static ConcurrentLinkedQueue<OnLocationRequestListener> d;
  
  private static String e;
  
  private static String f;
  
  private static OnLocationRequestListener g;
  
  private static boolean h;
  
  public static String a() {
    return LocationCacheUtils.c();
  }
  
  public static void a(Application paramApplication) {
    LocationType locationType;
    if (AppUtils.b()) {
      locationType = LocationType.a;
    } else {
      locationType = LocationType.d;
    } 
    a(paramApplication, locationType);
  }
  
  public static void a(Application paramApplication, LocationType paramLocationType) {
    AppUtils.a(paramApplication);
    a = paramLocationType;
    if (h && d != null)
      return; 
    n();
    h = true;
    e = a();
    f = b();
    d = new ConcurrentLinkedQueue<OnLocationRequestListener>();
    ProcessLifecycleOwner.get().getLifecycle().addObserver(new LifecycleObserver() {
          @OnLifecycleEvent(Lifecycle.Event.ON_START)
          public void onAppStart() {
            LocationService.g();
          }
          
          @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
          public void onAppStop() {
            LocationService.h();
          }
        });
    o();
  }
  
  public static void a(LifecycleOwner paramLifecycleOwner, int paramInt, OnPoiRequestListener paramOnPoiRequestListener) {
    a(paramLifecycleOwner, new OnLocationRequestListener(paramInt, POILiveDataUtils.a(paramLifecycleOwner, new Observer<POIModel>(paramOnPoiRequestListener) {
              public void a(POIModel param1POIModel) {
                if (param1POIModel != null)
                  this.a.onComplete(param1POIModel.a, param1POIModel.b, param1POIModel.c); 
              }
            }), paramLifecycleOwner) {
          public void onComplete(int param1Int, String param1String1, String param1String2) {
            if (param1Int == 0) {
              param1Int = LocationService.null.a[LocationService.k().ordinal()];
              if (param1Int != 1) {
                if (param1Int != 2) {
                  if (param1Int != 3) {
                    if (param1Int != 4)
                      return; 
                    BluedPoiUtils.a(this.a, new OnPoiListener(this) {
                          public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                            if (param2Int == 0) {
                              POILiveDataUtils.a(this.a.b, this.a.c, new POIModel(param2Int, param2List, param2Boolean));
                              return;
                            } 
                            GaoDePoiService.a().a(this.a.a, new OnPoiListener(this) {
                                  public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                    POILiveDataUtils.a(this.a.a.b, this.a.a.c, new POIModel(param3Int, param3List, param3Boolean));
                                  }
                                });
                          }
                        });
                    return;
                  } 
                  GaoDePoiService.a().a(this.a, new OnPoiListener(this) {
                        public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                          if (param2Int == 0) {
                            POILiveDataUtils.a(this.a.b, this.a.c, new POIModel(param2Int, param2List, param2Boolean));
                            return;
                          } 
                          BluedPoiUtils.a(this.a.a, new OnPoiListener(this) {
                                public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                  POILiveDataUtils.a(this.a.a.b, this.a.a.c, new POIModel(param3Int, param3List, param3Boolean));
                                }
                              });
                        }
                      });
                  return;
                } 
                BluedPoiUtils.a(this.a, new OnPoiListener(this) {
                      public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                        POILiveDataUtils.a(this.a.b, this.a.c, new POIModel(param2Int, param2List, param2Boolean));
                      }
                    });
                return;
              } 
              GaoDePoiService.a().a(this.a, new OnPoiListener(this) {
                    public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                      POILiveDataUtils.a(this.a.b, this.a.c, new POIModel(param2Int, param2List, param2Boolean));
                    }
                  });
              return;
            } 
            POILiveDataUtils.a(this.b, this.c, new POIModel(param1Int, null, false));
          }
        });
  }
  
  public static void a(LifecycleOwner paramLifecycleOwner, int paramInt, String paramString, OnPoiRequestListener paramOnPoiRequestListener) {
    a(new OnLocationRequestListener(paramInt, paramString, POILiveDataUtils.a(paramLifecycleOwner, new Observer<POIModel>(paramOnPoiRequestListener) {
              public void a(POIModel param1POIModel) {
                if (param1POIModel != null)
                  this.a.onComplete(param1POIModel.a, param1POIModel.b, param1POIModel.c); 
              }
            }), paramLifecycleOwner) {
          public void onComplete(int param1Int, String param1String1, String param1String2) {
            if (param1Int == 0) {
              param1Int = LocationService.null.a[LocationService.k().ordinal()];
              if (param1Int != 1) {
                if (param1Int != 2) {
                  if (param1Int != 3) {
                    if (param1Int != 4)
                      return; 
                    BluedPoiUtils.b(this.a, this.b, new OnPoiListener(this) {
                          public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                            if (param2Int == 0) {
                              POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                              return;
                            } 
                            GaoDePoiService.a().b(this.a.a, this.a.b, new OnPoiListener(this) {
                                  public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                    POILiveDataUtils.a(this.a.a.c, this.a.a.d, new POIModel(param3Int, param3List, param3Boolean));
                                  }
                                });
                          }
                        });
                    return;
                  } 
                  GaoDePoiService.a().b(this.a, this.b, new OnPoiListener(this) {
                        public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                          if (param2Int == 0) {
                            POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                            return;
                          } 
                          BluedPoiUtils.b(this.a.a, this.a.b, new OnPoiListener(this) {
                                public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                  POILiveDataUtils.a(this.a.a.c, this.a.a.d, new POIModel(param3Int, param3List, param3Boolean));
                                }
                              });
                        }
                      });
                  return;
                } 
                BluedPoiUtils.b(this.a, this.b, new OnPoiListener(this) {
                      public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                        POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                      }
                    });
                return;
              } 
              GaoDePoiService.a().b(this.a, this.b, new OnPoiListener(this) {
                    public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                      POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                    }
                  });
              return;
            } 
            POILiveDataUtils.a(this.c, this.d, new POIModel(param1Int, null, false));
          }
        });
  }
  
  public static void a(LifecycleOwner paramLifecycleOwner, int paramInt, String paramString1, String paramString2, OnPoiRequestListener paramOnPoiRequestListener) {
    a(new OnLocationRequestListener(paramInt, paramString1, paramString2, POILiveDataUtils.a(paramLifecycleOwner, new Observer<POIModel>(paramOnPoiRequestListener) {
              public void a(POIModel param1POIModel) {
                if (param1POIModel != null)
                  this.a.onComplete(param1POIModel.a, param1POIModel.b, param1POIModel.c); 
              }
            }), paramLifecycleOwner) {
          public void onComplete(int param1Int, String param1String1, String param1String2) {
            if (param1Int == 0) {
              param1Int = LocationService.null.a[LocationService.k().ordinal()];
              if (param1Int != 1) {
                if (param1Int != 2) {
                  if (param1Int != 3) {
                    if (param1Int != 4)
                      return; 
                    BluedPoiUtils.a(this.a, this.b, this.c, new OnPoiListener(this) {
                          public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                            if (param2Int == 0) {
                              POILiveDataUtils.a(this.a.d, this.a.e, new POIModel(param2Int, param2List, param2Boolean));
                              return;
                            } 
                            GaoDePoiService.a().a(this.a.a, this.a.b, this.a.c, new OnPoiListener(this) {
                                  public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                    POILiveDataUtils.a(this.a.a.d, this.a.a.e, new POIModel(param3Int, param3List, param3Boolean));
                                  }
                                });
                          }
                        });
                    return;
                  } 
                  GaoDePoiService.a().a(this.a, this.b, this.c, new OnPoiListener(this) {
                        public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                          if (param2Int == 0) {
                            POILiveDataUtils.a(this.a.d, this.a.e, new POIModel(param2Int, param2List, param2Boolean));
                            return;
                          } 
                          BluedPoiUtils.a(this.a.a, this.a.b, this.a.c, new OnPoiListener(this) {
                                public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                  POILiveDataUtils.a(this.a.a.d, this.a.a.e, new POIModel(param3Int, param3List, param3Boolean));
                                }
                              });
                        }
                      });
                  return;
                } 
                BluedPoiUtils.a(this.a, this.b, this.c, new OnPoiListener(this) {
                      public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                        POILiveDataUtils.a(this.a.d, this.a.e, new POIModel(param2Int, param2List, param2Boolean));
                      }
                    });
                return;
              } 
              GaoDePoiService.a().a(this.a, this.b, this.c, new OnPoiListener(this) {
                    public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                      POILiveDataUtils.a(this.a.d, this.a.e, new POIModel(param2Int, param2List, param2Boolean));
                    }
                  });
              return;
            } 
            POILiveDataUtils.a(this.d, this.e, new POIModel(param1Int, null, false));
          }
        });
  }
  
  public static void a(LifecycleOwner paramLifecycleOwner, OnLocationRequestListener paramOnLocationRequestListener) {
    if (!h)
      a(AppUtils.a()); 
    LocationLiveDataUtils.a(paramLifecycleOwner, new Observer<LocationModel>(paramOnLocationRequestListener) {
          public void a(LocationModel param1LocationModel) {
            if (param1LocationModel != null)
              this.a.onComplete(param1LocationModel.a, param1LocationModel.b, param1LocationModel.c); 
          }
        });
    if (TextUtils.isEmpty(f) || TextUtils.isEmpty(e) || System.currentTimeMillis() - c > 60000L) {
      o();
      return;
    } 
    if (System.currentTimeMillis() - c > 20000L) {
      LocationLiveDataUtils.a(paramLifecycleOwner, new LocationModel(0, e, f));
      o();
      return;
    } 
    LocationLiveDataUtils.a(paramLifecycleOwner, new LocationModel(0, e, f));
  }
  
  private static void a(OnLocationListener paramOnLocationListener) {
    int i = null.a[a.ordinal()];
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i != 4)
            return; 
          GoogleLocationService.a().a(new OnLocationListener(paramOnLocationListener) {
                public void a() {
                  OnLocationListener onLocationListener = this.a;
                  if (onLocationListener != null)
                    onLocationListener.a(); 
                }
                
                public void a(int param1Int) {
                  GaoDeLocationService.a().a(true, 10, this.a);
                }
              });
          return;
        } 
        GaoDeLocationService.a().a(true, 10, new OnLocationListener(paramOnLocationListener) {
              public void a() {
                OnLocationListener onLocationListener = this.a;
                if (onLocationListener != null)
                  onLocationListener.a(); 
              }
              
              public void a(int param1Int) {
                GoogleLocationService.a().a(this.a);
              }
            });
        return;
      } 
      GoogleLocationService.a().a(paramOnLocationListener);
      return;
    } 
    GaoDeLocationService.a().a(true, 10, paramOnLocationListener);
  }
  
  public static void a(OnLocationRequestListener paramOnLocationRequestListener) {
    if (!h)
      a(AppUtils.a()); 
    if (TextUtils.isEmpty(f) || TextUtils.isEmpty(e) || System.currentTimeMillis() - c > 60000L) {
      d.offer(paramOnLocationRequestListener);
      o();
      return;
    } 
    if (System.currentTimeMillis() - c > 20000L) {
      ThreadUtils.a(new Runnable(paramOnLocationRequestListener) {
            public void run() {
              this.a.onComplete(0, LocationService.i(), LocationService.j());
            }
          });
      o();
      return;
    } 
    ThreadUtils.a(new Runnable(paramOnLocationRequestListener) {
          public void run() {
            this.a.onComplete(0, LocationService.i(), LocationService.j());
          }
        });
  }
  
  public static void a(OnLocationRequestListener paramOnLocationRequestListener, boolean paramBoolean) {
    if (!h)
      a(AppUtils.a()); 
    if (paramBoolean) {
      d.offer(paramOnLocationRequestListener);
      o();
      return;
    } 
    a(paramOnLocationRequestListener);
  }
  
  public static void a(String paramString) {
    BluedPoiUtils.a(paramString);
  }
  
  public static String b() {
    return LocationCacheUtils.d();
  }
  
  public static void b(LifecycleOwner paramLifecycleOwner, int paramInt, String paramString, OnPoiRequestListener paramOnPoiRequestListener) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(LocationCacheUtils.a());
    stringBuilder.append(paramString);
    a(paramLifecycleOwner, paramInt, stringBuilder.toString(), paramOnPoiRequestListener);
  }
  
  public static LocationType c() {
    return a;
  }
  
  public static void c(LifecycleOwner paramLifecycleOwner, int paramInt, String paramString, OnPoiRequestListener paramOnPoiRequestListener) {
    a(new OnLocationRequestListener(paramInt, paramString, POILiveDataUtils.a(paramLifecycleOwner, new Observer<POIModel>(paramOnPoiRequestListener) {
              public void a(POIModel param1POIModel) {
                if (param1POIModel != null)
                  this.a.onComplete(param1POIModel.a, param1POIModel.b, param1POIModel.c); 
              }
            }), paramLifecycleOwner) {
          public void onComplete(int param1Int, String param1String1, String param1String2) {
            if (param1Int == 0) {
              param1Int = LocationService.null.a[LocationService.k().ordinal()];
              if (param1Int != 1) {
                if (param1Int != 2) {
                  if (param1Int != 3) {
                    if (param1Int != 4)
                      return; 
                    BluedPoiUtils.a(this.a, this.b, new OnPoiListener(this) {
                          public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                            if (param2Int == 0) {
                              POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                              return;
                            } 
                            GaoDePoiService.a().a(this.a.a, this.a.b, new OnPoiListener(this) {
                                  public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                    POILiveDataUtils.a(this.a.a.c, this.a.a.d, new POIModel(param3Int, param3List, param3Boolean));
                                  }
                                });
                          }
                        });
                    return;
                  } 
                  GaoDePoiService.a().a(this.a, this.b, new OnPoiListener(this) {
                        public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                          if (param2Int == 0) {
                            POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                            return;
                          } 
                          BluedPoiUtils.a(this.a.a, this.a.b, new OnPoiListener(this) {
                                public void a(int param3Int, List<LocationPOIModel> param3List, boolean param3Boolean) {
                                  POILiveDataUtils.a(this.a.a.c, this.a.a.d, new POIModel(param3Int, param3List, param3Boolean));
                                }
                              });
                        }
                      });
                  return;
                } 
                BluedPoiUtils.a(this.a, this.b, new OnPoiListener(this) {
                      public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                        POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                      }
                    });
                return;
              } 
              GaoDePoiService.a().a(this.a, this.b, new OnPoiListener(this) {
                    public void a(int param2Int, List<LocationPOIModel> param2List, boolean param2Boolean) {
                      POILiveDataUtils.a(this.a.c, this.a.d, new POIModel(param2Int, param2List, param2Boolean));
                    }
                  });
              return;
            } 
            POILiveDataUtils.a(this.c, this.d, new POIModel(param1Int, null, false));
          }
        });
  }
  
  public static String d() {
    return LocationCacheUtils.e();
  }
  
  public static String e() {
    return LocationCacheUtils.f();
  }
  
  public static boolean f() {
    return LocationCacheUtils.i();
  }
  
  private static void n() {
    ThreadUtils.b(new Runnable() {
          public void run() {
            try {
              boolean bool;
              if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable((Context)AppUtils.a()) == 0) {
                bool = true;
              } else {
                bool = false;
              } 
              LocationCacheUtils.b(bool);
              return;
            } catch (Exception exception) {
              exception.printStackTrace();
              return;
            } 
          }
        });
  }
  
  private static void o() {
    if (AppUtils.c() >= 23 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_FINE_LOCATION") != 0 && ActivityCompat.checkSelfPermission((Context)AppUtils.a(), "android.permission.ACCESS_COARSE_LOCATION") != 0) {
      while (d.size() > 0) {
        ThreadUtils.a(new Runnable() {
              public void run() {
                OnLocationRequestListener onLocationRequestListener = LocationService.l().poll();
                if (onLocationRequestListener != null)
                  onLocationRequestListener.onComplete(-2, LocationService.i(), LocationService.j()); 
              }
            });
      } 
      LocationLiveDataUtils.a(new LocationModel(-2, e, f));
      return;
    } 
    if (b == LocationStatus.a) {
      b = LocationStatus.b;
      a(new OnLocationListener() {
            public void a() {
              LocationService.a(LocationStatus.c);
              LocationService.a(System.currentTimeMillis());
              LocationService.b(LocationService.a());
              LocationService.c(LocationService.b());
              while (LocationService.l().size() > 0) {
                LocationService.a(LocationStatus.d);
                ThreadUtils.a(new Runnable(this) {
                      public void run() {
                        OnLocationRequestListener onLocationRequestListener = LocationService.l().poll();
                        if (onLocationRequestListener != null) {
                          if (TextUtils.isEmpty(LocationService.j()) || TextUtils.isEmpty(LocationService.i())) {
                            onLocationRequestListener.onComplete(-1, LocationService.i(), LocationService.j());
                            return;
                          } 
                          onLocationRequestListener.onComplete(0, LocationService.i(), LocationService.j());
                          return;
                        } 
                      }
                    });
              } 
              if (LocationService.m() != null)
                LocationService.m().onComplete(0, LocationService.i(), LocationService.j()); 
              LocationLiveDataUtils.a(new LocationModel(0, LocationService.i(), LocationService.j()));
              LocationService.a(LocationStatus.a);
            }
            
            public void a(int param1Int) {
              while (LocationService.l().size() > 0) {
                LocationService.a(LocationStatus.d);
                ThreadUtils.a(new Runnable(this, param1Int) {
                      public void run() {
                        OnLocationRequestListener onLocationRequestListener = LocationService.l().poll();
                        if (onLocationRequestListener != null)
                          onLocationRequestListener.onComplete(this.a, LocationService.i(), LocationService.j()); 
                      }
                    });
              } 
              LocationLiveDataUtils.a(new LocationModel(param1Int, LocationService.i(), LocationService.j()));
              LocationService.a(LocationStatus.a);
            }
          });
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\location\LocationService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */