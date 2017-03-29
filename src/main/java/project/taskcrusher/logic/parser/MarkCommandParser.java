package project.taskcrusher.logic.parser;

import static project.taskcrusher.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Optional;

import project.taskcrusher.logic.commands.Command;
import project.taskcrusher.logic.commands.IncorrectCommand;
import project.taskcrusher.logic.commands.MarkCommand;
import project.taskcrusher.model.event.Event;
import project.taskcrusher.model.task.Task;

public class MarkCommandParser {
    public Command parse(String args) {
        String[] preamble = args.trim().split("\\s+");

        if (preamble.length != 3) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE));
        } else if (!preamble[0].matches("[" + Task.TASK_FLAG + Event.EVENT_FLAG + "]")) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE));
        } else if (!preamble[1].matches("\\d+")) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE));
        } else if (!preamble[2].matches("c|ic")) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE));
        }

        Optional<Integer> index = ParserUtil.parseIndex(preamble[1]);
        if (!index.isPresent()) {
            return new IncorrectCommand(String.format(MESSAGE_INVALID_COMMAND_FORMAT, MarkCommand.MESSAGE_USAGE));
        }
        System.out.println("preamble[2] = " + preamble[2]);
        int markFlag = preamble[2] == "ic" ? MarkCommand.MARK_INCOMPLETE : MarkCommand.MARK_INCOMPLETE;

        return new MarkCommand(preamble[0], index.get(), markFlag);
    }
}