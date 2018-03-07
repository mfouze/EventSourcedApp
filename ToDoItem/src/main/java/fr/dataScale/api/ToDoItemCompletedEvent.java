package fr.dataScale.api;

public class ToDoItemCompletedEvent {

	private final String todoId;

	public ToDoItemCompletedEvent(String todoId) {
		this.todoId = todoId;
	}

	public String getTodoId() {
		return todoId;
	}
}
