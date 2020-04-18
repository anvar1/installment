package uz.ita.assistance.web.screens.service;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Service;

import javax.inject.Inject;

@UiController("assistance_Service.browse")
@UiDescriptor("service-browse.xml")
@LookupComponent("servicesTable")
@LoadDataBeforeShow
public class ServiceBrowse extends StandardLookup<Service> {
    @Inject
    private TreeTable<Service> servicesTable;
    @Inject private ScreenBuilders screenBuilders;

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        servicesTable.expandAll();
    }


    @Subscribe("servicesTable.create")
    public void onCreate(Action.ActionPerformedEvent event) {
//        if (servicesTable.getSingleSelected() != null) {
        screenBuilders.editor(servicesTable)
                .newEntity()
                .withInitializer(branch -> branch.setParent(servicesTable.getSingleSelected()))
                .withScreenClass(ServiceEdit.class)
                .withLaunchMode(OpenMode.DIALOG)
                .build()
                .show();
        servicesTable.expandAll();
//        }
    }
}