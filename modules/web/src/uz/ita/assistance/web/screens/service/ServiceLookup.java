package uz.ita.assistance.web.screens.service;

import com.haulmont.cuba.gui.components.TreeTable;
import com.haulmont.cuba.gui.components.data.TreeTableItems;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Service;

import javax.inject.Inject;
import java.util.Collection;

@UiController("assistance_Service.lookup")
@UiDescriptor("service-lookup.xml")
@LookupComponent("servicesTable")
@LoadDataBeforeShow
public class ServiceLookup extends StandardLookup<Service> {

    @Inject
    protected TreeTable<Service> servicesTable;
    @Inject private CollectionContainer<Service> servicesDc;
    private Service exclude;

    @Subscribe
    private void onInit(InitEvent event) {
        ScreenOptions options = event.getOptions();
        if (options instanceof MapScreenOptions) {
            exclude = (Service) ((MapScreenOptions) options).getParams().get("exclude");
            excludeItem(exclude);
        }
    }

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        excludeItem(exclude);
        servicesTable.expandAll();
    }

    private void excludeItem(Service branch) {
        TreeTableItems<Service> treeTableItems = (TreeTableItems<Service>) servicesTable.getItems();
        Collection<Service> children = (Collection<Service>) treeTableItems.getChildren(branch);
        for (Service childId : children) {
            excludeItem(servicesDc.getItem(childId.getId()));
        }
        servicesDc.getMutableItems().remove(branch);
    }
}