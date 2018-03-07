package fr.dataScale.commandhandler;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

import fr.dataScale.api.CreateToDoItemCommand;
import fr.dataScale.api.MarkCompletedCommand;
import fr.dataScale.api.ToDoItemCompletedEvent;
import fr.dataScale.api.ToDoItemCreatedEvent;

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