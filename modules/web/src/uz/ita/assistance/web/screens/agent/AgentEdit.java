package uz.ita.assistance.web.screens.agent;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.components.LookupField;
import com.haulmont.cuba.gui.components.PickerField;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.Agent;
import uz.ita.assistance.entity.address.Country;
import uz.ita.assistance.entity.address.District;
import uz.ita.assistance.entity.address.Region;

import javax.inject.Inject;
import java.util.Objects;

@UiController("assistance_Agent.edit")
@UiDescriptor("agent-edit.xml")
@EditedEntityContainer("agentDc")
@PrimaryEditorScreen(Agent.class)
public class AgentEdit extends StandardEditor<Agent> {
    @Inject
    private CollectionLoader<District> districtLd;
    @Inject private CollectionContainer<Country> countryDc;
    @Inject private CollectionContainer<Region> regionDc;

    @Inject private PickerField<Agent> parentField;
    @Inject private LookupField<Country> country;
    @Inject private LookupField<Region> region;
    @Inject private LookupField<Region> district;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        districtLd.setParameter("region", getEditedEntity().getAddress().getRegion());
        getScreenData().loadAll();
        if (!PersistenceHelper.isNew(getEditedEntity())) {
            parentField.setEditable(true);
            PickerField.LookupAction lookupAction = new PickerField.LookupAction(parentField);
            lookupAction.setLookupScreenParams(ParamsMap.of("exclude", getEditedEntity()));
            parentField.addAction(lookupAction);
        } else {
            country.setValue(countryDc.getItems().stream()
                    .filter(country -> Objects.equals(country.getId(), 860))
                    .findFirst().get());
            region.setValue(regionDc.getItems().stream()
                    .filter(region -> Objects.equals(region.getId(), 1726))
                    .findFirst().get());

        }
    }

    @Subscribe(id = "regionDc", target = Target.DATA_CONTAINER)
    private void onRegionDcItemChange(InstanceContainer.ItemChangeEvent<Region> event) {
        districtLd.setParameter("region", event.getItem());
        district.setValue(null);
        districtLd.load();

    }
}