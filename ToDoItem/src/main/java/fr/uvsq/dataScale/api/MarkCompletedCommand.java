package fr.uvsq.dataScale.api;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class MarkCompletedCommand {

	@TargetAggregateIdentifier
	private final String todoId;

	public String getTodoId() {
		return todoId;
	}

	public MarkCompletedCommand(String todoId) {
		super();
		this.todoId = todoId;
	}
	
	
}
