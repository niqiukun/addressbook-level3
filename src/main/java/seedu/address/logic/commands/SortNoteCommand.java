package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import static seedu.address.logic.parser.CliSyntax.PREFIX_SORTBY;

import java.util.function.Predicate;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.note.Note;
import seedu.address.model.note.SortByCond;




/**
 * Edits the details of an existing person in the address book.
 */
public class SortNoteCommand extends Command {

    public static final String COMMAND_WORD = "sort";
    public static final String DATEMODIFIED = "DateModified";
    public static final String DATEADDED = "DateAdded";
    public static final String NUMOFACCESS = "NumOfAccess";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the notes "
            + "by the condition given by the user. \n "
            + "Parameters: "
        + "[" + PREFIX_SORTBY + DATEMODIFIED + " or " + DATEADDED + " or " + NUMOFACCESS + " ] "
            + "Example: " + COMMAND_WORD + " " + PREFIX_SORTBY + "DateModified";

    public static final String MESSAGE_SORT_NOTE_SUCCESS = "Sorted Note by: %1$s";
    public static final String MESSAGE_NOT_SORTED = "Must provide at one and only one field to sort by.";
    public static final String MESSAGE_DUPLICATE_NOTE = "This notebook is already sorted.";
    private SortByCond sortByCond;

    /**
     * @param sortByCond condition to sort NoteBook by.
     */
    public SortNoteCommand(SortByCond sortByCond) {
        requireNonNull(sortByCond);
        this.sortByCond = sortByCond;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.commitNote();
        Predicate<Note> notePredicate = model.getFilteredNoteListPred();
        model.editNoteSortByCond(sortByCond);
        model.sortNoteBook();
        model.updateFilteredNoteList(notePredicate);
        return new CommandResult(String.format(MESSAGE_SORT_NOTE_SUCCESS, sortByCond.sortByCond));
    }



    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof SortNoteCommand)) {
            return false;
        }

        // state check
        SortNoteCommand e = (SortNoteCommand) other;
        return sortByCond.equals(e.sortByCond);
    }

}
