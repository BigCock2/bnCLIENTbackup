package net.AzureWare.events;

import com.darkmagician6.eventapi.events.Event;

public class EventMove implements Event {
   public double x;
   public double y;
   public double z;
   private boolean onground;
   private boolean alwaysSend;
   
   
   public EventMove(double a, double b, double c) {
      this.x = a;
      this.y = b;
      this.z = c;
   }

   public double getX() {
      return this.x;
   }

   public void setX(double x) {
      this.x = x;
   }

   public double getY() {
      return this.y;
   }

   public void setY(double y) {
      this.y = y;
   }

   public double getZ() {
      return this.z;
   }

   public void setZ(double z) {
      this.z = z;
   }

   public void setGround(boolean ground) {
       this.onground = ground;
   }

   public void setAlwaysSend(boolean alwaysSend) {
       this.alwaysSend = alwaysSend;
   }

   public void setOnGround(boolean onground) {
       this.onground = onground;
   }
}
