package fr.dataScale.api;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateToDoItemCommand {

	@TargetAggregateIdentifier
	private final String todoId;
	private final String description;


	public CreateToDoItemCommand(String todoId, String description) {
		super();
		this.todoId = todoId;
		this.description = description;
	}


	public String getToDoId() {
		return todoId;
	}


	public String getDescription() {
		return description;
	}





}
