package uz.ita.assistance.web.screens.agent;

import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.components.data.TreeTableItems;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Agent;

import javax.inject.Inject;
import java.util.Collection;

@UiController("assistance_Agent.lookup")
@UiDescriptor("agent-lookup.xml")
@LookupComponent("agentsTable")
@LoadDataBeforeShow
public class AgentLookup extends StandardLookup<Agent> {

    @Inject protected TreeTable<Agent> agentsTable;
    @Inject private CollectionContainer<Agent> agentsDc;
    private Agent exclude;

    @Subscribe
    private void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        if (options instanceof MapScreenOptions) {
            exclude = (Agent) ((MapScreenOptions) options).getParams().get("exclude");
        }
    }

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        excludeItem(exclude);
        agentsTable.expandAll();
    }

    private void excludeItem(Agent agent) {
        TreeTableItems<Agent> treeTableItems = (TreeTableItems<Agent>) agentsTable.getItems();
        Collection<Agent> children = (Collection<Agent>) treeTableItems.getChildren(agent);
        for (Agent childId : children) {
            excludeItem(agentsDc.getItem(childId.getId()));
        }
        agentsDc.getMutableItems().remove(agent);
    }
}