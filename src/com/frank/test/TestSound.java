package com.frank.test;

import java.util.Arrays;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;

/**
 * 测试MidiSystem里头方法
 * 
 * @author kst
 * @date 2018-12-17 17:51:17
 */
public class TestSound {

	public static void main(String[] args) {
		MidiDevice.Info[] midis = MidiSystem.getMidiDeviceInfo();
		System.out.println(Arrays.toString(midis));
	}
}
