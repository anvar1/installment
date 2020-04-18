package uz.ita.assistance.web.screens.branch;

import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.components.data.TreeTableItems;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Branch;

import javax.inject.Inject;
import java.util.Collection;

@UiController("assistance_Branch.lookup")
@UiDescriptor("branch-lookup.xml")
@LookupComponent("branchesTable")
@LoadDataBeforeShow
public class BranchLookup extends StandardLookup<Branch> {

    @Inject protected TreeTable<Branch> branchesTable;
    @Inject private CollectionContainer<Branch> branchesDc;
    private Branch exclude;

    @Subscribe
    private void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        if (options instanceof MapScreenOptions) {
            exclude = (Branch) ((MapScreenOptions) options).getParams().get("exclude");
            excludeItem(exclude);
        }
    }

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        excludeItem(exclude);
        branchesTable.expandAll();
    }

    private void excludeItem(Branch branch) {
        TreeTableItems<Branch> treeTableItems = (TreeTableItems<Branch>) branchesTable.getItems();
        Collection<Branch> children = (Collection<Branch>) treeTableItems.getChildren(branch);
        for (Branch childId : children) {
            excludeItem(branchesDc.getItem(childId.getId()));
        }
        branchesDc.getMutableItems().remove(branch);
    }

}