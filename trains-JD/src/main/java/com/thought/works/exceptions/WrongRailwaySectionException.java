package com.thought.works.exceptions;

@SuppressWarnings("serial")
public class WrongRailwaySectionException extends Exception{
	public WrongRailwaySectionException(){}
	public WrongRailwaySectionException(String edgeElem){
		super("The input railway section "+edgeElem+" has not the right format.");
	}
	
	 
}
