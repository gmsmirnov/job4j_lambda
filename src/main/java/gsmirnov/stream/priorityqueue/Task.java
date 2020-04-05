package gsmirnov.stream.priorityqueue;

import java.util.Objects;

/**
 * Task model.
 *
 * @author Gregory Smirnov (gsmirnov <artress@ngs.ru>)
 * @version 0.1
 * @since 2020-04-05
 */
public class Task {
    /**
     * Task description.
     */
    private String desc;

    /**
     * Task priority.
     */
    private int priority;

    /**
     * The constructor, creates a new task with the specified parameters.
     *
     * @param desc the specified description.
     * @param priority the specified priority.
     */
    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Gets this task's description.
     *
     * @return this task's description.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Sets the specified description to this task.
     *
     * @param desc the specified description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Gets this task's priority.
     *
     * @return this task's priority.
     */
    public int getPriority() {
        return this.priority;
    }

    /**
     * Sets the specified priority to this task.
     *
     * @param priority the specified priority.
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * Checks this task for equivalence with another task. Both tasks are equals when their descriptions and priorities
     * are equals.
     *
     * @param o another task.
     * @return true when both tasks are equals, false either.
     */
    @Override
    public boolean equals(Object o) {
        boolean result;
        if (this == o) {
            result = true;
        } else if (o == null || getClass() != o.getClass()) {
            result = false;
        } else {
            Task task = (Task) o;
            result = this.priority == task.priority && Objects.equals(this.desc, task.desc);
        }
        return result;
    }

    /**
     * Calculates hash code for this task.
     *
     * @return calculated hash code to this task.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.desc, this.priority);
    }

    /**
     * Creates a string-presentation of this task.
     *
     * @return the string presentation of this task.
     */
    @Override
    public String toString() {
        return String.format("Task{desc='%s', priority=%d}", this.desc, this.priority);
    }
}