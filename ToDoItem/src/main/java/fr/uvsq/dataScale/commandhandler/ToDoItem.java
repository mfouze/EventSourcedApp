package fr.uvsq.dataScale.commandhandler;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import fr.uvsq.dataScale.api.CreateToDoItemCommand;
import fr.uvsq.dataScale.api.MarkCompletedCommand;
import fr.uvsq.dataScale.api.ToDoItemCompletedEvent;
import fr.uvsq.dataScale.api.ToDoItemCreatedEvent;

public class ToDoItem extends AbstractAnnotatedAggregateRoot {

	@AggregateIdentifier
	private String id;

	public ToDoItem() {
	}

	@CommandHandler
	public ToDoItem(CreateToDoItemCommand command) {
		apply(new ToDoItemCreatedEvent(command.getTodoId(), command.getDescription()));
	}
	@CommandHandler
	public void markCompleted(MarkCompletedCommand command) {
		apply(new ToDoItemCompletedEvent(id));
	}
	@EventHandler
	public void on(ToDoItemCreatedEvent event) {
		this.id = event.getTodoId();
	}

}
