package gsmirnov.stream.priorityqueue;

import java.util.LinkedList;

/**
 * Priority queue. Based on linked list queue where elements are located by priority in ascending order.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-05
 */
public class PriorityQueue {
    /**
     * The queue.
     */
    private final LinkedList<Task> tasks = new LinkedList<Task>();

    /**
     * Puts the specified task to its place in the priority queue.
     *
     * @param task the specified task.
     */
    public void put(Task task) {
        if (this.tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            for (var index = 0; index < this.tasks.size(); index++) {
                if (this.tasks.get(index).getPriority() > task.getPriority()) {
                    this.tasks.add(index, task);
                    break;
                }
            }
        }
    }

    /**
     * Gets the firs task by priority and deletes it from the queue.
     *
     * @return first by priority task or null if the queue is empty.
     */
    public Task take() {
        return this.tasks.poll();
    }
}