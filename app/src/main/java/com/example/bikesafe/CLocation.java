package com.example.bikesafe;

import android.location.Location;

public class CLocation extends Location {

    private boolean bUseMetricUnits=false;

    public CLocation(Location location) {
        this(location, true);
    }
    public CLocation(Location location, boolean bUseMetricUnits) {
        super(location);
        this.bUseMetricUnits = bUseMetricUnits;
    }
    public boolean getUserMetricUnits() {
        return this.bUseMetricUnits;
    }
    public void setbUseMetricUnits(boolean bUseMetricUnits) {
        this.bUseMetricUnits = bUseMetricUnits;
    }

    @Override
    public float distanceTo(Location dest) {
        float nDistance = super.distanceTo(dest);

        if(!this.getUserMetricUnits()) {
            nDistance = nDistance*3.28083989501312f;
        }
        return nDistance;
    }

    @Override
    public double getAltitude() {
        double nAltitude = super.getAltitude();

        if(!this.getUserMetricUnits()) {
            nAltitude = nAltitude*3.28083989501312d;
        }
        return nAltitude;
     }

    @Override
    public float getSpeed() {
        float nSpeed = super.getSpeed()*3.6f;

        if(!this.getUserMetricUnits()) {
            nSpeed = super.getSpeed() * 2.23693629f;
        }
        return nSpeed ;
    }

    @Override
    public float getAccuracy() {
        float nAccuracy = super.getAccuracy();

        if(!this.getUserMetricUnits()) {
            nAccuracy = nAccuracy*3.28083989501312f;
        }
        return nAccuracy;
    }
}


