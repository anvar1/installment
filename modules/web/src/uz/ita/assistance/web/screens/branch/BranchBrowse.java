package uz.ita.assistance.web.screens.branch;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Branch;

import javax.inject.Inject;

@UiController("assistance_Branch.browse")
@UiDescriptor("branch-browse.xml")
@LookupComponent("branchesTable")
@LoadDataBeforeShow
public class BranchBrowse extends StandardLookup<Branch> {
    @Inject private TreeTable<Branch> branchesTable;
    @Inject private ScreenBuilders screenBuilders;

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        branchesTable.expandAll();
    }


    @Subscribe("branchesTable.create")
    public void onCreate(Action.ActionPerformedEvent event) {
        if (branchesTable.getSingleSelected() != null) {
            screenBuilders.editor(branchesTable)
                    .newEntity()
                    .withInitializer(branch -> branch.setParent(branchesTable.getSingleSelected()))
                    .withScreenClass(BranchEdit.class)
                    .withLaunchMode(OpenMode.DIALOG)
                    .build()
                    .show();
            branchesTable.expandAll();
        }
    }

}
