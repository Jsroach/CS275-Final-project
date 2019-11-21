package com.example.styledmap;

import java.util.Date;

public interface Crime  {

  int getId();
  String getCrimeType();
  Date getDate();
  String getWeapon();
  double getLatitude();
  double getLongitude();
}
