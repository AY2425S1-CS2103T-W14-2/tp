package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.ExportCommand.SUCCESS_MESSAGE;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

public class ExportCommandTest {
    private final Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    private final Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_export_success() {
        CommandResult expectedCommandResult = new CommandResult(SUCCESS_MESSAGE);
        assertCommandSuccess(new ExportCommand("csv"), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void equals() {
        final ExportCommand standardCommand = new ExportCommand("csv");
        final String differentFormat = "pdf";

        // same values -> returns true
        ExportCommand commandWithSameValues = new ExportCommand("csv");
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different export format -> returns false
        assertFalse(standardCommand.equals(new ExportCommand(differentFormat)));
    }
}
