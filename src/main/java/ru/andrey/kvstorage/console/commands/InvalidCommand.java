package ru.andrey.kvstorage.console.commands;

import ru.andrey.kvstorage.console.DatabaseCommand;
import ru.andrey.kvstorage.console.DatabaseCommandResult;

public final class InvalidCommand implements DatabaseCommand {

    @Override
    public DatabaseCommandResult execute() {
        return DatabaseCommandResult.error("Wrong arguments count.");
    }

}
