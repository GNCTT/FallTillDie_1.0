package com.example.falltilldie_10.OnlineGame;

import android.util.Log;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class Client implements Runnable {
    private static final int CREATE_MAP_PKT = 1;
    private static final int SET_PLANE_PKT = 2;
    private static final int BYE_PKT_TYPE = 3;
    private static final int TURN_PKT_TYPE = 4;

    private static String msv;
    private static int clientID;

    private static int WIDTH_MAP_SIZE;
    private static int HEIGHT_MAP_SIZE;
    private static int num_trap;
    private static int arr_trap[][];
    private static byte[] buffer;
    private static byte[] type_byte;
    private static byte[] len_byte;

    private static byte ID_byte[];

    private static byte width_map_byte[];
    private static byte height_map_byte[];

    private static byte num_trap_byte[];

    private static byte x_trap_byte[];
    private static byte y_trap_byte[];

    private static byte dir_byte[];

    private static int dir_plane;

    private static byte x_location_byte[];
    private static byte y_location_byte[];
    private static int x_location;
    private static int y_location;

    private static int data_length;
    private static byte[] data_byte;
    private static byte[] data_byte1;
    private static byte[] data_byte2;
    private static byte[] pkt_sent;
    private static byte[] datax = new byte[4];
    private static byte[] dataN = new byte[4];
    private static byte[] dataM = new byte[4];
    private static byte[] dataArrElement;

    private Socket client_socket = null;
    private DataInputStream in;
    private DataOutputStream out;
    private String ip;
    private int port;
    public boolean checkSend;
    private int timeReceive;
    private final static int MaxTimeReceive = 0;
    public boolean waitingOther;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        checkSend = false;
        timeReceive = 0;
        waitingOther = true;

    }


    static int bytetoINT(byte[] bytes) {
        return ByteBuffer.wrap(bytes).order(ByteOrder.LITTLE_ENDIAN).getInt();
    }

    static String byteToString(byte[] bytes) {
        return new String(bytes, StandardCharsets.UTF_8);
    }

    static byte[] Stringtobyte(String s) {
        byte b[] = s.getBytes();
        return b;
    }

    public static byte[] getBytebyIndex(byte[] bytes, int index1, int index2) {
        byte[] outarr = new byte[index2 - index1];
        for (int i = 0; i < index2 - index1; i++) {
            outarr[i] = bytes[i + index1];
        }
        return outarr;
    }

    public static int checkPara(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return 0;
            }
        }
        return 1;
    }


    static byte[] intobyte(int i) {
        ByteBuffer b = ByteBuffer.allocate(4);
        b.order(ByteOrder.LITTLE_ENDIAN);
        b.putInt(i);
        return b.array();
    }

    static byte[] make_pkt_hello(int i, String d) {
        byte type[] = intobyte(i);
        byte data[] = Stringtobyte(d);
        int datalen = data.length;
        byte len[] = intobyte(datalen);
        ByteBuffer final_array = ByteBuffer.allocate(datalen + 8);
        final_array.put(type);
        final_array.put(len);
        final_array.put(data);
        return final_array.array();
    }

    static byte[] make_pkt_data(byte[] data1, byte[] data2) {
        ByteBuffer pkt_sent = ByteBuffer.allocate(8);
        pkt_sent.put(data1);
        pkt_sent.put(data2);
        return pkt_sent.array();
    }

    static byte[] make_pkt_send(byte[] type, byte[] len, byte[] data) {
        int size = bytetoINT(len) + 8;
        ByteBuffer pkt_sent = ByteBuffer.allocate(size);
        pkt_sent.put(type);
        pkt_sent.put(len);
        pkt_sent.put(data);
        return pkt_sent.array();
    }

    @Override
    public void run() {
        initConnect();
    }

    public void initConnect() {
        Log.i("before_Conenct", "hi " + ip + " " + port);

        try {
            if (!checkSend) {
                client_socket = new Socket(ip, port);
                Log.i("after_Conenct", "hi");
                out = new DataOutputStream(client_socket.getOutputStream());
                in = new DataInputStream(client_socket.getInputStream());
                checkSend = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void write_data() {

    }

    public void read_data() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (!checkSend) {
                        client_socket = new Socket(ip, port);
                        Log.i("after_Conenct", "hi");
                        out = new DataOutputStream(client_socket.getOutputStream());
                        in = new DataInputStream(client_socket.getInputStream());
                        checkSend = true;
                    }
                    byte[] buffer = new byte[5000];
                    in.read(buffer);
                    if (buffer != null) {
                        type_byte = getBytebyIndex(buffer, 0, 4);
                        int type = bytetoINT(type_byte);
                        Log.i("getDatafromServer", "" + type);
                        timeReceive = 0;
                        if (type != 0) {
                            waitingOther = false;
                        }
                        ByteBuffer before_send = ByteBuffer.allocate(12);
                        type_byte = intobyte(0);
                        len_byte = intobyte(1);
                        data_byte = Stringtobyte("190");
                        before_send.put(type_byte);
                        before_send.put(len_byte);
                        before_send.put(data_byte);
                        out.write(before_send.array());
                    }
                    Log.i("client_ok", "ok");
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.i("client_not_ok", "ok");
                }
            }
        });


    }
}
