package fr.dataScale.api;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

public class CreateToDoItemCommand {

	@TargetAggregateIdentifier
	private final String toDoId;
	private final String description;


	public CreateToDoItemCommand(String toDoId, String description) {
		super();
		this.toDoId = toDoId;
		this.description = description;
	}


	public String getToDoId() {
		return toDoId;
	}


	public String getDescription() {
		return description;
	}





}
