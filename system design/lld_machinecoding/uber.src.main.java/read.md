The queue should be in-memory and should not require access to the file system.
There can be multiple topics in the queue.
A (string) message can be published on a topic by a producer/publisher and consumers/subscribers can subscribe to the topic to receive the messages.
There can be multiple producers and consumers.
A producer can publish to multiple topics.
A consumer can listen to multiple topics.
The consumer should print "<consumer_id> received <message>" on receiving the message.
The queue system should be multi-threaded, i.e., messages can be produced or consumed in parallel by different producers/consumers.



messagebroker
1-1 communciation
1-many commnication


pusblish(Queue, message)
publish ( topic , message)

register/subscribe ( Queue , Topic )

deregister(subscriber)
delete ( Queue)


QueueService
List<Queues>
List<Topics>


abstract class channel()
List<subscriber/consumers>;
publish ( message)
register(Consumer/subscriber)

Queue implemnts channel()

//implmentation
@LoadBalanced
publish(message)


Topic 
publish(message)


