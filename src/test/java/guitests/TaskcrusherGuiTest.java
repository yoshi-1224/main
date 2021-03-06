package guitests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeoutException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.testfx.api.FxToolkit;

import guitests.guihandles.CommandBoxHandle;
import guitests.guihandles.EventCardHandle;
import guitests.guihandles.MainGuiHandle;
import guitests.guihandles.MainMenuHandle;
import guitests.guihandles.ResultDisplayHandle;
import guitests.guihandles.TaskCardHandle;
import guitests.guihandles.UserInboxPanelHandle;
import javafx.application.Platform;
import javafx.stage.Stage;
import project.taskcrusher.TestApp;
import project.taskcrusher.commons.core.EventsCenter;
import project.taskcrusher.commons.events.BaseEvent;
import project.taskcrusher.model.UserInbox;
import project.taskcrusher.model.event.ReadOnlyEvent;
import project.taskcrusher.model.task.ReadOnlyTask;
import project.taskcrusher.testutil.TestUtil;
import project.taskcrusher.testutil.TypicalTestUserInbox;

/// **
// * A GUI Test class for Taskcrusher.
// */
public abstract class TaskcrusherGuiTest {

    /*
     * The TestName Rule makes the current test name available inside test
     * methods
     */
    @Rule
    public TestName name = new TestName();

    TestApp testApp;

    protected TypicalTestUserInbox td = new TypicalTestUserInbox();

    /*
     * Handles to GUI elements present at the start up are created in advance
     * for easy access from child classes.
     */
    protected MainGuiHandle mainGui;
    protected MainMenuHandle mainMenu;
    protected UserInboxPanelHandle userInboxPanel;
    protected ResultDisplayHandle resultDisplay;
    protected CommandBoxHandle commandBox;
    private Stage stage;

    @BeforeClass
    public static void setupSpec() {
        try {
            FxToolkit.registerPrimaryStage();
            FxToolkit.hideStage();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setup() throws Exception {
        FxToolkit.setupStage((stage) -> {
            mainGui = new MainGuiHandle(new GuiRobot(), stage);
            mainMenu = mainGui.getMainMenu();
            userInboxPanel = mainGui.getUserInboxPanel();
            resultDisplay = mainGui.getResultDisplay();
            commandBox = mainGui.getCommandBox();
            this.stage = stage;
        });
        EventsCenter.clearSubscribers();
        testApp = (TestApp) FxToolkit.setupApplication(() -> new TestApp(this::getInitialData, getDataFileLocation()));
        FxToolkit.showStage();
        while (!stage.isShowing())
            ;
        mainGui.focusOnMainApp();
    }

    /**
     * Override this in child classes to set the initial local data. Return null
     * to use the data in the file specified in {@link #getDataFileLocation()}
     */
    protected UserInbox getInitialData() {
        UserInbox ab = new UserInbox();
        TypicalTestUserInbox.loadUserInboxWithSampleTasks(ab);
        TypicalTestUserInbox.loadUserInboxWithSampleEvents(ab);
        return ab;
    }

    /**
     * Override this in child classes to set the data file location.
     */
    protected String getDataFileLocation() {
        return TestApp.SAVE_LOCATION_FOR_TESTING;
    }

    @After
    public void cleanup() throws TimeoutException {
        FxToolkit.cleanupStages();
    }

    /**
     * Asserts the task shown in the card is same as the given task
     */
    public void assertMatching(ReadOnlyTask task, TaskCardHandle card) {
        assertTrue(TestUtil.compareTaskCardAndTask(card, task));
    }

    /**
     * Asserts the event shown in the card is same as the given task
     */
    public void assertMatching(ReadOnlyEvent event, EventCardHandle card) {
        assertTrue(TestUtil.compareEventCardAndEvent(card, event));
    }

    /**
     * Asserts the size of the task list is equal to the given number.
     */
    protected void assertTaskListSize(int size) {
        int numberOfTasks = userInboxPanel.getNumberOfTasks();
        assertEquals(size, numberOfTasks);
    }

    /**
     * Asserts the size of the event list is equal to the given number.
     */
    protected void assertEventListSize(int size) {
        int numberOfEvents = userInboxPanel.getNumberOfEvents();
        assertEquals(size, numberOfEvents);
    }

    /**
     * Asserts the message shown in the Result Display area is same as the given
     * string.
     */
    protected void assertResultMessage(String expected) {
        assertEquals(expected, resultDisplay.getText());
    }

    public void raise(BaseEvent e) {
        // JUnit doesn't run its test cases on the UI thread. Platform.runLater
        // is used to post event on the UI thread.
        Platform.runLater(() -> EventsCenter.getInstance().post(e));
    }
}
