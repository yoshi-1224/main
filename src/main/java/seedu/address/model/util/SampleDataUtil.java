package seedu.address.model.util;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.UserInbox;
import seedu.address.model.ReadOnlyUserInbox;
import seedu.address.model.person.Description;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Task;
import seedu.address.model.person.Priority;
import seedu.address.model.person.UniqueTaskList.DuplicateTaskException;
import seedu.address.model.tag.UniqueTagList;

public class SampleDataUtil {
    public static Task[] getSamplePersons() {
        try {
            return new Task[] {
                new Task(new Name("Alex Yeoh"), new Priority("87438807"), new Email("alexyeoh@gmail.com"),
                    new Description("Blk 30 Geylang Street 29, #06-40"),
                    new UniqueTagList("friends")),
                new Task(new Name("Bernice Yu"), new Priority("99272758"), new Email("berniceyu@gmail.com"),
                    new Description("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                    new UniqueTagList("colleagues", "friends")),
                new Task(new Name("Charlotte Oliveiro"), new Priority("93210283"), new Email("charlotte@yahoo.com"),
                    new Description("Blk 11 Ang Mo Kio Street 74, #11-04"),
                    new UniqueTagList("neighbours")),
                new Task(new Name("David Li"), new Priority("91031282"), new Email("lidavid@google.com"),
                    new Description("Blk 436 Serangoon Gardens Street 26, #16-43"),
                    new UniqueTagList("family")),
                new Task(new Name("Irfan Ibrahim"), new Priority("92492021"), new Email("irfan@outlook.com"),
                    new Description("Blk 47 Tampines Street 20, #17-35"),
                    new UniqueTagList("classmates")),
                new Task(new Name("Roy Balakrishnan"), new Priority("92624417"), new Email("royb@gmail.com"),
                    new Description("Blk 45 Aljunied Street 85, #11-31"),
                    new UniqueTagList("colleagues"))
            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyUserInbox getSampleAddressBook() {
        try {
            UserInbox sampleAB = new UserInbox();
            for (Task samplePerson : getSamplePersons()) {
                sampleAB.addTask(samplePerson);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate persons", e);
        }
    }
}
