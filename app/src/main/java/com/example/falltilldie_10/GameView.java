package com.example.falltilldie_10;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;

import com.example.falltilldie_10.Map.MapView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONException;
import org.json.JSONObject;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    public static Canvas canvas;
    public static Paint paint;
    public static boolean isPlaying;
    public static int screenX;
    public static int screenY;
    private static int widthScreen;
    private static int heightScreen;
    public static float screenRatioX_1, screenRatioY_1;
    public static float screenRatioX_2, screenRatioY_2;

    public static Resources res;

    public static boolean left = false;
    public static boolean right = false;

    public boolean online;
    public boolean waiting;

    FirebaseDatabase database;
    DatabaseReference roomRef;
    DatabaseReference playerRef;
    DatabaseReference otherRef;
    DatabaseReference myRef;
    DatabaseReference EnemyRef;
    DatabaseReference readyRef;
    private String message;
    private int id;
    private boolean host;
    public boolean checkOver;


    private MapView mapView;
    private JSONObject jsonObjectRead;
    private String DataIn;

    public Context gameActivity;
    public Intent soundBoom;

    public GameView(Context context, int screenX, int screenY, int heightScreen, int widthScreen){
        super(context);
        this.gameActivity = context;
        soundBoom = new Intent(context, MusicService.class);
        screenRatioX_1 =(float) (widthScreen * 1.00 / (9 * 66));
        screenRatioX_2 =  9 * 66;
        screenRatioY_1 = (float) (heightScreen * 1.00 / (18 * 66));
        screenRatioY_2 = 19 * 66;
        Log.i("tagggx", widthScreen + " " + heightScreen + "  " + screenRatioX_1 + " " + screenRatioY_1);
        this.screenX = screenX;
        this.screenY = screenY;
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        canvas = new Canvas();
        paint = new Paint();
        res = getResources();
//        database = FirebaseDatabase.getInstance();
//        Log.i("gameView", " " );
//        roomRef = database.getReference("Rooms");
//        roomRef.setValue(message);
//        readyRef = database.getReference("ready");
//        readyRef.setValue("0");
        mapView = new MapView(screenX, screenY, context);
        online = false;
        checkOver = false;
    }

    public GameView(Context context, int screenX, int screenY, int heightScreen, int widthScreen, boolean online){
        super(context);
        id = 123;
        message = "player" + id;
        screenRatioX_1 =(float) (widthScreen * 1.00 / (9 * 66));
        screenRatioX_2 =  9 * 66;
        screenRatioY_1 = (float) (heightScreen * 1.00 / (18 * 66));
        screenRatioY_2 = 19 * 66;
        this.screenX = screenX;
        this.screenY = screenY;
        this.widthScreen = widthScreen;
        this.heightScreen = heightScreen;
        canvas = new Canvas();
        paint = new Paint();
        res = getResources();
        mapView = new MapView(screenX, screenY, context);
        database = FirebaseDatabase.getInstance();
        host = false;
        checkOver = false;

        roomRef = database.getReference("Rooms");
        //need change.
//        myRef.setValue(message);
        this.online = online;
        waiting = true;
        readyRef = database.getReference("ready");
        readyRef.setValue("0");
        playerRef = database.getReference("Player");
        otherRef = database.getReference("OtherPlayer");
    }


    @Override
    public void run() {
        while (isPlaying) {
            if (online) {
                if (waiting) {
                    draw_waiting();
                    addEventListenerOnline();
                    if (host) {
                        myRef = playerRef;
                        EnemyRef = otherRef;
                        myRef.setValue(mapView.makeJSonObject().toString());
                        addEventListenOther(myRef);
                    } else {
                        myRef = otherRef;
                        EnemyRef = playerRef;
                        myRef.setValue(mapView.makeJSonObjectPlayer().toString());
                        addEventListenOther(myRef);
                    }
                } else {
                    if (host) {
                        myRef.setValue(mapView.makeJSonObject().toString());
                    } else {
                        myRef.setValue(mapView.makeJSonObjectPlayer().toString());
                    }
                    addEventListenOther(EnemyRef);
                    if (DataIn != null) {
                        Log.i("jsonObject", " " + DataIn);
                    }
                    try {
                        JSONObject jsonObject = new JSONObject(DataIn);
                        jsonObjectRead = jsonObject.getJSONObject("Player");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    updateOnline(jsonObjectRead);
                    drawOnline();
                    sleep();
                }
            } else {
                update();
                draw();
                sleep();
            }
            }
        }

    private void update() {
        mapView.update();
    }

    private void updateOnline(JSONObject jsonObjectRead) {
        if (host) {
            mapView.updateOnline(jsonObjectRead);
        } else  {
            mapView.updateOnline2(jsonObjectRead);
        }
    }

    private void drawOnline() {
        if (!mapView.isOVer()) {
            if (getHolder().getSurface().isValid()) {
                canvas = getHolder().lockCanvas();
                mapView.drawOnline();
                getHolder().unlockCanvasAndPost(canvas);
            }
        } else {
            if (checkOver == false) {
                Intent intent = new Intent(gameActivity, GameOverActivity.class);
                gameActivity.startActivity(intent);
                checkOver = true;
            }
        }
    }

    private void draw() {
        //draw
        if (!mapView.isOVer()) {
            if (getHolder().getSurface().isValid()) {

                canvas = getHolder().lockCanvas();
                mapView.draw();
                getHolder().unlockCanvasAndPost(canvas);
            }
        } else {
            if (checkOver == false) {
                checkOver = true;
                Intent intent = new Intent(gameActivity, GameOverActivity.class);
                gameActivity.startActivity(intent);
            }
        }
    }

    public void draw_waiting() {
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();
            mapView.draw_waiting();
            getHolder().unlockCanvasAndPost(canvas);

        }
    }
    public void draw_not_connect() {
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();
            mapView.draw_not_connect();
            getHolder().unlockCanvasAndPost(canvas);

        }
    }


    public void drawOver() {
        if (getHolder().getSurface().isValid()) {
            canvas = getHolder().lockCanvas();
            mapView.drawOver();
            getHolder().unlockCanvasAndPost(canvas);

        }
    }



    public void drawPause() {

    }

    private void sleep() {
        try {
            thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause() {
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public static int getWidthScreen() {
        return widthScreen;
    }

    public static int getHeightScreen() {
        return heightScreen;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2) {
                    left = true;
                    right = false;
                }
                if (event.getX() > screenX / 2) {
                    right = true;
                    left = false;
                }

                break;
            case MotionEvent.ACTION_UP:
                left = false;
                right = false;
                break;
        }
        return true;
    }

    public void addEventListenerOnline() {
        roomRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                if (value.equals("") || value.equals(message)) {
                    roomRef.setValue(message);
                    host = true;
                    waiting = true;
                } else {

                    host = false;
                    readyRef.setValue("1");
                    waiting = false;
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        readyRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                if (value.equals("0")) {
                    waiting = true;
                } else {
                    waiting = false;
                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void addEventListenOther(DatabaseReference reference) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);
                DataIn = value;
                         }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

    public void addEventListenerOnlineEvent() {
        playerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

}
