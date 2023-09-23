/*
 * Author: Aidan Evans
 * Date: 3/23/2019
 */


package commands;



public class MediaKeys {
	public static final int VOL_UP = -1;
	public static final int VOL_DOWN = -2;
	public static final int PLAY = -3;
	public static final int NEXT = -4;
	public static final int PREV = -5;
	public static final int MUTE = -6;
	public static final int STOP = -7;
	public static final int MEDIAKEY = -10;


	public static Runnable sortMediaKeys(Integer mediaKey) {
		switch (mediaKey) {
			case VOL_UP : return () -> volumeUp();
			case VOL_DOWN:  return () -> volumeDown();
			case PLAY:  return () -> songPlayPause();
			case NEXT:  return () -> songNext();
			case PREV: return () -> songPrevious();
			case MUTE:  return () -> volumeMute();
			case STOP : return () -> mediaStop();
			default:
				throw new RuntimeException("Invalid media key error");
        }
	}

	//loads library from "MediaKeys.dll"
	static {
		System.loadLibrary("MediaKeys");
	}

	public static native void volumeMute();
	
	public static native void volumeDown();
	
	public static native void volumeUp();
	
	
	public static native void songPrevious();
	
	public static native void songNext();
	
	public static native void songPlayPause();


	public static native void mediaStop();
	


}
