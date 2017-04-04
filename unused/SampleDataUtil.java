package project.taskcrusher.model.util;

import project.taskcrusher.commons.exceptions.IllegalValueException;
import project.taskcrusher.model.ReadOnlyUserInbox;
import project.taskcrusher.model.UserInbox;
import project.taskcrusher.model.shared.Description;
import project.taskcrusher.model.shared.Name;
import project.taskcrusher.model.shared.Priority;
import project.taskcrusher.model.tag.UniqueTagList;
import project.taskcrusher.model.task.Deadline;
import project.taskcrusher.model.task.Task;
import project.taskcrusher.model.task.UniqueTaskList.DuplicateTaskException;
 //Sample data
public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        try {
            return new Task[] {
                new Task(new Name("CS2103 tutorial"), new Deadline("2017-11-11"), new Priority("3"),
                            new Description("presentation"), new UniqueTagList("school")),
                new Task(new Name("CS2106 assignment"), new Deadline("next Monday"), new Priority("2"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                new Task(new Name("CS2103 tutorial"), new Deadline("2017-11-11"), new Priority("3"),
                            new Description("presentation"), new UniqueTagList("school")),
                    new Task(new Name("CS2106 assignment"), new Deadline("2018-03-20"), new Priority("2"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("security assignment"), new Deadline("2017-12-11"), new Priority("3"),
//@@author A0163639W
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("Marketing project"), new Deadline("2017-11-19"), new Priority("3"),
                            new Description("brand audit"), new UniqueTagList("school")),
                    new Task(new Name("Meeting"), new Deadline("2019-11-11"), new Priority("2"),
                            new Description("nuclear deal"), new UniqueTagList("office")),
                    new Task(new Name("Invite for dinner"), new Deadline("2017-10-12"), new Priority("1"),
                            new Description("Mr XYZ"), new UniqueTagList("Home")),
                    new Task(new Name("Auditing"), new Deadline("2017-11-13"), new Priority("2"),
                            new Description("Accounts"), new UniqueTagList("office")),
                    new Task(new Name("Tennis match"), new Deadline("2017-09-11"), new Priority("1"),
                            new Description("With John"), new UniqueTagList("Home")),
                    new Task(new Name("Movie"), new Deadline("2017-11-09"), new Priority("1"),
                            new Description("iron man"), new UniqueTagList("home")),
                    new Task(new Name("Buy a phone"), new Deadline("2017-12-11"), new Priority("1"),
                            new Description("gift for friend"), new UniqueTagList("home")),
                    new Task(new Name("Cricket match"), new Deadline("2017-11-13"), new Priority("1"),
                            new Description("india wc final"), new UniqueTagList("home")),
                    new Task(new Name("maths project"), new Deadline("2017-04-11"), new Priority("1"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("Shopping"), new Deadline("2017-11-13"), new Priority("1"),
                            new Description("ikea"), new UniqueTagList("home")),
                    new Task(new Name("Repair watch"), new Deadline("2017-08-17"), new Priority("3"),
                            new Description("swatch"), new UniqueTagList("home")),
                    new Task(new Name("Physics hw"), new Deadline("2017-11-14"), new Priority("3"),
                            new Description("Kinematics"), new UniqueTagList("school")),
                    new Task(new Name("Chemistry lab"), new Deadline("2017-12-16"), new Priority("3"),
                            new Description("salt analysis"), new UniqueTagList("school")),
                    new Task(new Name("Club meeting"), new Deadline("2017-11-13"), new Priority("3"),
                            new Description("organising committee"), new UniqueTagList("school")),
                    new Task(new Name("Pick a friend"), new Deadline("2017-07-15"), new Priority("1"),
                            new Description("Mr Smith"), new UniqueTagList("home")),
                    new Task(new Name("Physics lab"), new Deadline("2017-06-11"), new Priority("3"),
                            new Description("Sonometer"), new UniqueTagList("school")),
                    new Task(new Name("Book tickets"), new Deadline("2017-11-12"), new Priority("3"),
                            new Description("delhisingapore"), new UniqueTagList("home")),
                    new Task(new Name("Fix a meeting"), new Deadline("2017-11-19"), new Priority("3"),
                            new Description("russian invasion"), new UniqueTagList("office")),
                    new Task(new Name("Computer lab"), new Deadline("2017-08-11"), new Priority("3"),
                            new Description("C OOP"), new UniqueTagList("school")),
                    new Task(new Name("C assignment"), new Deadline("2017-05-11"), new Priority("1"),
                            new Description("Directory with double pointers"), new UniqueTagList("school")),
                    new Task(new Name("Dinner"), new Deadline("2019-07-11"), new Priority("1"),
                            new Description("Hilton hotel"), new UniqueTagList("home")),
                    new Task(new Name("Marriage invite"), new Deadline("2017-09-11"), new Priority("3"),
                            new Description("Church"), new UniqueTagList("home")),
                    new Task(new Name("Lunch"), new Deadline("2017-09-10"), new Priority("3"), new Description("MCD"),
                            new UniqueTagList("school")),
                    new Task(new Name("Assignment"), new Deadline("2017-11-09"), new Priority("3"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("comp 2011"), new Deadline("2017-11-01"), new Priority("3"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("paper checking"), new Deadline("2017-10-09"), new Priority("3"),
                            new Description("comp2711"), new UniqueTagList("school")),
                    new Task(new Name("trip "), new Deadline("2017-08-09"), new Priority("2"), new Description("India"),
                            new UniqueTagList("home")),
                    new Task(new Name("Get a gun"), new Deadline("2017-11-08"), new Priority("3"),
                            new Description("shoot all enemies"), new UniqueTagList("school")),
                    new Task(new Name("comp3711 assignment"), new Deadline("2017-10-07"), new Priority("3"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("comp2012 assignment"), new Deadline("2017-09-10"), new Priority("3"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("OP assignment"), new Deadline("2017-07-08"), new Priority("3"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("cs3111"), new Deadline("2017-10-07"), new Priority("3"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("cs2001"), new Deadline("2017-11-12"), new Priority("3"),
                            new Description("submit assignment"), new UniqueTagList("school")),
                    new Task(new Name("Plan a trip"), new Deadline("2017-12-11"), new Priority("3"),
                            new Description("london"), new UniqueTagList("home")),
                    new Task(new Name("Vote"), new Deadline("2017-11-19"), new Priority("1"),
                            new Description("Elections"), new UniqueTagList("school")),
                    new Task(new Name("office trip"), new Deadline("2017-11-14"), new Priority("3"),
                            new Description("london"), new UniqueTagList("office")),
                    new Task(new Name("Mgmt project"), new Deadline("2017-11-19"), new Priority("3"),
                            new Description("OB"), new UniqueTagList("school")),
                    new Task(new Name("Book seats"), new Deadline("2017-04-11"), new Priority("3"),
                            new Description("london"), new UniqueTagList("home")),
                    new Task(new Name("teach friend"), new Deadline("2017-08-11"), new Priority("3"),
                            new Description("organic chemistry"), new UniqueTagList("school")),
                    new Task(new Name("Marriage"), new Deadline("2017-08-13"), new Priority("3"),
                            new Description("Delhi"), new UniqueTagList("home")),
                    new Task(new Name("TT match"), new Deadline("2017-09-19"), new Priority("3"),
                            new Description("MPSH"), new UniqueTagList("school"))
//@@author
            };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyUserInbox getSampleUserInbox() {
        try {
            UserInbox sampleuserInbox = new UserInbox();
            for (Task sampleTask : getSampleTasks()) {
                sampleuserInbox.addTask(sampleTask);
            }
            return sampleuserInbox;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate tasks", e);
        }
    }
}
