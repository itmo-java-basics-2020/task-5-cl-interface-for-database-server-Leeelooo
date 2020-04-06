package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.ExecutionEnvironment;

public final class DatabaseCommands {

    public static DatabaseCommand getCommand(
            ExecutionEnvironment environment,
            String commandText
    ) {
        if (commandText == null) {
            return new InvalidCommand();
        }
        var options = commandText.split(" ");
        if (options.length == 0) {
            return new InvalidCommand();
        }

        switch (options[0]) {
            case CreateDatabaseCommand.LINE:
                if (options.length != 2) {
                    return new InvalidCommand();
                }
                return new CreateDatabaseCommand(environment, options[1]);
            case  CreateTableCommand.LINE:
                if (options.length != 3) {
                    return new InvalidCommand();
                }
                return new CreateTableCommand(environment, options[1], options[2]);
            case ReadKeyCommand.LINE:
                if (options.length != 4) {
                    return new InvalidCommand();
                }
                return new ReadKeyCommand(environment, options[1], options[2], options[3]);
            case UpdateKeyCommand.LINE:
                if (options.length != 5) {
                    return new InvalidCommand();
                }
                return new UpdateKeyCommand(environment, options[1], options[2], options[3], options[4]);
            default:
                return new InvalidCommand();
        }
    }

}
