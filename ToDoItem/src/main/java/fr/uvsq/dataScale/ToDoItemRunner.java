package fr.uvsq.dataScale;

import java.io.File;
import java.util.UUID;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.SimpleEventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.uvsq.dataScale.api.CreateToDoItemCommand;
import fr.uvsq.dataScale.api.MarkCompletedCommand;
import fr.uvsq.dataScale.commandhandler.ToDoItem;

public class ToDoItemRunner {

	private CommandGateway commandGateway;
	 
    public ToDoItemRunner(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

 
    private void run() {
        final String itemId = UUID.randomUUID().toString();
        commandGateway.send(new CreateToDoItemCommand(itemId, "Need to do this"));
        commandGateway.send(new MarkCompletedCommand(itemId));
    }
    
	public static void main(String[] args) {

//		System.out.println("jsuis laaaaaa");
//		// Le bus de commandes --->des requetes 
//		CommandBus commandBus = new SimpleCommandBus();
//		//CommandBus commandBus =  new SimpleCommandBus();
//		System.out.println("puis iciiiiii");
//
//		//permet de dispatcher chaque commande
//		CommandGateway commandGateway = new DefaultCommandGateway(commandBus);
//
//		//Notre eventStore
//		EventStore eventStore = new FileSystemEventStore(new SimpleEventFileResolver(new File("./eventsore")));
//
//		//Notre event bus 
//		EventBus eventBus = new SimpleEventBus();
//
//		//Repository
//		EventSourcingRepository repository = new EventSourcingRepository(ToDoItem.class, eventStore);
//
//		//Seting event bus of our rep
//		repository.setEventBus(eventBus);
//
//		//On declare juste a axon que notre classe peut gerer les commands handling dont peut automatiquement gerer la recuperation de la commande 
//		AggregateAnnotationCommandHandler.subscribe(ToDoItem.class, repository, commandBus);
//
//		//On envoie des commandes sur le bus de commandes
//		//On attribue de maniere auto un identifiant a notre commande
//		final String itemId = UUID.randomUUID().toString();
//		commandGateway.send(new CreateToDoItemCommand(itemId, "Need to do this"));
//		commandGateway.send(new MarkCompletedCommand(itemId));
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        ToDoItemRunner runner = new ToDoItemRunner(applicationContext.getBean(CommandGateway.class));
        runner.run();
		

	}

}


