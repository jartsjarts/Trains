package com.thought.works.exceptions;

@SuppressWarnings("serial")
public class NotExistingNodeException extends Exception{
	public NotExistingNodeException() {
	}

	public NotExistingNodeException(String townElem) {
		super("The town " + townElem + " does not exist.");
	}
}