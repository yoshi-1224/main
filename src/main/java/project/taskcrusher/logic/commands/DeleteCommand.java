package project.taskcrusher.logic.commands;

import project.taskcrusher.commons.core.Messages;
import project.taskcrusher.commons.core.UnmodifiableObservableList;
import project.taskcrusher.logic.commands.exceptions.CommandException;
import project.taskcrusher.model.task.ReadOnlyTask;
import project.taskcrusher.model.task.UniqueTaskList.TaskNotFoundException;

/**
 * Deletes a person identified using it's last displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the task identified by the index number used in the last task listing.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_DELETE_TASK_SUCCESS = "Deleted Task: %1$s";

    public final int targetIndex;

    public DeleteCommand(int targetIndex) {
        this.targetIndex = targetIndex;
    }


    @Override
    public CommandResult execute() throws CommandException {

        UnmodifiableObservableList<ReadOnlyTask> lastShownList = model.getFilteredTaskList();

        if (lastShownList.size() < targetIndex) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        ReadOnlyTask taskToDelete = lastShownList.get(targetIndex - 1);

        try {
            model.deleteTask(taskToDelete);
        } catch (TaskNotFoundException pnfe) {
            assert false : "The target person cannot be missing";
        }

        return new CommandResult(String.format(MESSAGE_DELETE_TASK_SUCCESS, taskToDelete));
    }

}