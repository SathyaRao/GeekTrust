package com.waterManagement.model;

import java.util.HashMap;

public class Rooms {
	private static int members;
	private static HashMap<Integer,Integer> rooms = new HashMap<Integer,Integer>();
	private static int guests;
	
	public Rooms(){
		Rooms.rooms.put(2, 3);
		Rooms.rooms.put(3, 5);
	}
	public int getGuests() {
		return guests;
	}
	public void setGuests(int guests) {
		Rooms.guests = guests;
	}
	public int getRooms(int room) {
		return rooms.get(room);
	}
	public void setRooms() {
		Rooms.rooms.put(2, 3);
		Rooms.rooms.put(3, 5);
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		Rooms.members = members;
	}

}
