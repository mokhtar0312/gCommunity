package tests;

import java.util.List;
import java.util.Random;

import delegate.EventServiceDelegate;
import delegate.VoteServicesDelegate;
import entities.Event;
import entities.SimpleMember;

public class testini {

	public static void main(String[] args) {
	//	VoteServicesDelegate.findAllVotes());
		List<Event> a=EventServiceDelegate.DoFindbyTyped("jamel");
		for(Event p : a){
			System.out.println(p.getFee());
		}
	}
}
