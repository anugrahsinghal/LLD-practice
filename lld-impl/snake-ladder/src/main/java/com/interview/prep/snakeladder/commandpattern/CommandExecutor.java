package com.interview.prep.snakeladder.commandpattern;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

public abstract class CommandExecutor {

	public CommandExecutor() {
		// add dependencies
	}

	public String execute(Command command) {
		if (!isValid(command)) {
			return "INVALID";
		}
		return executeCommand(command);
	}

	protected abstract String executeCommand(Command command);

	protected abstract boolean isValid(Command command);

	protected abstract boolean isApplicable(Command command);

}

@AllArgsConstructor
class CommandRunner {
	List<CommandExecutor> commandExecutors;

	public String run(Command command) {
		for (CommandExecutor commandExecutor : commandExecutors) {
			if (commandExecutor.isApplicable(command)) {
				return commandExecutor.execute(command);
			}
		}
		return "INVALID";
	}
}

@Getter
@AllArgsConstructor
class Command {

	String name;
	List<String> params;
}
