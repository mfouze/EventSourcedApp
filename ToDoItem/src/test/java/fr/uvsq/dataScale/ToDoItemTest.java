package fr.uvsq.dataScale;


import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

import fr.uvsq.dataScale.api.CreateToDoItemCommand;
import fr.uvsq.dataScale.api.MarkCompletedCommand;
import fr.uvsq.dataScale.api.ToDoItemCompletedEvent;
import fr.uvsq.dataScale.api.ToDoItemCreatedEvent;
import fr.uvsq.dataScale.commandhandler.ToDoItem;

public class ToDoItemTest {
	private FixtureConfiguration fixture;

	@Before
	public void setUp() throws Exception {
		fixture = Fixtures.newGivenWhenThenFixture(ToDoItem.class);
	}

	@Test
	public void testCreateToDoItem() throws Exception {
		fixture.given()
		.when(new CreateToDoItemCommand("todo1", "need to implement the aggregate"))
		.expectEvents(new ToDoItemCreatedEvent("todo1", "need to implement the aggregate"));
	}
	@Test
	public void testMarkToDoItemAsCompleted() throws Exception {
		fixture.given(new ToDoItemCreatedEvent("todo1", "need to implement the aggregate"))
		.when(new MarkCompletedCommand("todo1"))
		.expectEvents(new ToDoItemCompletedEvent("todo1"));
	}
}


