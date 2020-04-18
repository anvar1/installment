package uz.ita.assistance.web.screens.agent;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Agent;

import javax.inject.Inject;

@UiController("assistance_Agent.browse")
@UiDescriptor("agent-browse.xml")
@LookupComponent("agentsTable")
@LoadDataBeforeShow
public class AgentBrowse extends StandardLookup<Agent> {
    @Inject private TreeTable<Agent> agentsTable;
    @Inject private ScreenBuilders screenBuilders;

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        agentsTable.expandAll();
    }


    @Subscribe("agentsTable.create")
    public void onCreate(Action.ActionPerformedEvent event) {
//        if (agentsTable.getSingleSelected() != null) {
            screenBuilders.editor(agentsTable)
                    .newEntity()
                    .withInitializer(branch -> branch.setParent(agentsTable.getSingleSelected()))
                    .withScreenClass(AgentEdit.class)
                    .withLaunchMode(OpenMode.DIALOG)
                    .build()
                    .show();
            agentsTable.expandAll();
//        }
    }
}