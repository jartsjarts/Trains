package com.thought.works.exceptions;

@SuppressWarnings("serial")
public class DuplicatedEdgeException extends Exception {
	public DuplicatedEdgeException() {
	}

	public DuplicatedEdgeException(String edgeElem) {
		super("The edge " + edgeElem + " is duplicated.");
	}
}
