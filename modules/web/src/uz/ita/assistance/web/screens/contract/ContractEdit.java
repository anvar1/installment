package uz.ita.assistance.web.screens.contract;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.PersistenceHelper;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.AppUI;
import uz.ita.assistance.entity.Contract;
import uz.ita.assistance.entity.InsuredEvent;
import uz.ita.assistance.entity.Product;
import uz.ita.assistance.entity.SubProduct;
import uz.ita.assistance.web.screens.address.DistrictEdit;
import uz.ita.assistance.web.screens.insuredevent.InsuredEventEdit;

import javax.inject.Inject;
import java.util.Objects;

@UiController("assistance_Contract.edit")
@UiDescriptor("contract-edit.xml")
@EditedEntityContainer("contractDc")
@LoadDataBeforeShow
public class ContractEdit extends StandardEditor<Contract> {
    @Inject private InstanceContainer<Contract> contractDc;
    @Inject private Metadata metadata;
    @Inject private Notifications notifications;
    @Inject private LookupPickerField<SubProduct> subProduct;

    @Subscribe("createAct")
    private void onCreateActClick(Button.ClickEvent event) {
        Contract contract = contractDc.getItemOrNull();
        if (contract!=null && contract.getInsuredEvent().size() == 0) {
            Screens screens = AppUI.getCurrent().getScreens();

            InsuredEventEdit insuredEventEdit = screens.create(InsuredEventEdit.class, OpenMode.NEW_TAB);
            InsuredEvent insuredEvent = metadata.create(InsuredEvent.class);
            insuredEvent.setContract(getEditedEntity());
            insuredEvent.setInsurant(getEditedEntity().getInsurant());
            insuredEvent.setPhone(getEditedEntity().getPhone());

            insuredEventEdit.setEntityToEdit(insuredEvent);
            insuredEventEdit.show();
        } else {
            notifications.create(Notifications.NotificationType.HUMANIZED)
                    .withCaption("Предупреждение!!")
                    .withDescription("Для полиса уже создан Акт")
                    .show();
        }
    }

}
