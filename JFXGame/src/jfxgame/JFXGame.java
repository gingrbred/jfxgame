package jfxgame;

import java.util.ArrayList;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.Cursor;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;
import javafx.scene.shape.Shape;
import javafx.event.Event;
import javafx.scene.Node;

public class JFXGame extends Application {
  static ArrayList<Rectangle> base = new ArrayList();
  static ArrayList<Polygon> hero = new ArrayList();
  static ArrayList<Polygon> invaders = new ArrayList();
  static Rectangle ship;
  static Rectangle Back;
  static Rectangle Invaders;
  static Rectangle Projectile;
  static Rectangle Shelter;
  @Override
  
  public void start (Stage primaryStage){
      Group root = new Group();
        Scene scene = new Scene(root);
        //Scene back = new Scene(root);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

        Canvas canvas = new Canvas(1680, 1050);

        //Notice gc is not being used yet 
        GraphicsContext gc = canvas.getGraphicsContext2D();
                //try disabling canvas --- notice the difference 
       
        //notice we are manually adding the shape objects to the "root" window
        primaryStage.show();
        Projectile = new Rectangle(840-10/2, 1050-20/2, 10, 20);
        Projectile.setFill(Color.LIGHTBLUE);
        ship = new Rectangle(840-100/2, 1050-50/2, 100, 50);
        ship.setFill(Color.CHARTREUSE);
        Back = new Rectangle(0,0,1688,1050);
        Back.setFill(Color.BLACK);
        Shelter one = new Shelter(840-200/2,525-200/2,100,200,200);
        Shelter.setFill(Color.CHARTREUSE);

        
//        Polly.set
        root.getChildren().add(canvas);
        root.getChildren().add(Back);
        root.getChildren().add(one);
        root.getChildren().add(ship);
        root.getChildren().add(Projectile);
  }
   
  public static void main(String[] args) {
        launch(args);
    }
  static class ship extends Rectangle{
      int shp = 100;
      int sx = 0;
      int sy = 0;
        public ship(int shp, int sx, int sy){
           this.shp = shp;
           
        }
  }
  static class Shelter extends Rectangle{
      int shX;
      int shY;
      int shHP;
      int shXsize;
      int shYsize;
      
      public Shelter(int shx, int shy, int shhp, int shxsize, int shysize){
          shHP = shhp;
          shX = shx;
          shY = shy;
          shXsize = shxsize;
          shYsize = shysize;
       
      }
      
      void setShelterX(int shx){
          this.shX = shx;
      }
      void setShelterY(int shy){
          this.shY = shy;
      }
      void setShelterHP(int shhp){
          this.shHP = shhp;
      }
      void setShelterXsize(int shxsize){
          this.shXsize = shxsize;
      }
      void setShelterYsize(int shysize){
          this.shYsize = shysize;
      }
      int getShelterX() {
          return this.shX;
      }
      int getShelterY() {
          return this.shY;
      }
      int getShelterHP() {
          return this.shHP;
      }
      int getShelterXsize() {
          return this.shXsize;
      }
      int getShelterYsize() {
          return this.shYsize;
      }
  }
  static class Invaders extends Rectangle{
        int iX;
        int iY;
        int iHP;

        public Invaders(int ix, int iy, int ihp) {
            iX = ix;
            iY = iy;
            iHP = ihp;
            //System.out.println("Done!");
        }

        void setInvadersX(int ix) {
            this.iX = ix;
        }

        void setInvadersY(int iy) {
            this.iY = iy;
        }
        int getInvadersX() {
            return this.iX;
        }

        int getInvadersY() {
            return this.iY;
        }

    }
          
      private void checkBounds(Polygon ship) {
        // checkBounds is called in two different locations --- it's really only necessary in the animation dohandle
        // experiment - check the differences

        boolean collisionDetected = false;

        // notice the difference in how an ArrayList iterates through items 
        for (Rectangle badblock : base) {
            if (ship.getBoundsInParent().intersects(badblock.getBoundsInParent())) {
                collisionDetected = true;
                badblock.setFill(Color.RED);
            } else {
                badblock.setFill(Color.BLUE);
            }
        }
        if (collisionDetected) {
            ship.setFill(Color.RED);
        } else {
            ship.setFill(Color.ORANGE);
        }
    }
}