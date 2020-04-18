package uz.ita.assistance.web.screens.address;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.address.District;
import uz.ita.assistance.entity.address.Region;

import javax.inject.Inject;

@UiController("assistance_Region.edit")
@UiDescriptor("region-edit.xml")
@EditedEntityContainer("regionDc")
public class RegionEdit extends StandardEditor<Region> {
    @Inject private CollectionLoader<District> districtsDl;
    @Inject private InstanceContainer<Region> regionDc;
    @Inject private Table<District> districtsTable;
    @Inject private ScreenBuilders screenBuilders;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        districtsDl.setParameter("region", getEditedEntity());
        getScreenData().loadAll();
    }

    @Subscribe("districtsTable.create")
    private void onDistrictsTableCreate(Action.ActionPerformedEvent event) {
            screenBuilders.editor(districtsTable)
                    .newEntity()
                    .withInitializer(region -> region.setRegion(regionDc.getItem()))
                    .withScreenClass(DistrictEdit.class)
                    .withLaunchMode(OpenMode.DIALOG)
                    .build()
                    .show();
        }


}