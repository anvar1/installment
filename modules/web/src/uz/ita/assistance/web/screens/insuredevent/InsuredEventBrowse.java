package uz.ita.assistance.web.screens.insuredevent;

import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.reports.gui.actions.TablePrintFormAction;
import uz.ita.assistance.entity.InsuredEvent;
import uz.ita.assistance.entity.InsuredEventStatus;
import uz.ita.assistance.service.InsuredEventService;

import javax.inject.Inject;
import java.util.Objects;

@UiController("assistance_InsuredEvent.browse")
@UiDescriptor("insured-event-browse.xml")
@LookupComponent("insuredEventsTable")
@LoadDataBeforeShow
public class InsuredEventBrowse extends StandardLookup<InsuredEvent> {
    @Inject private GroupTable<InsuredEvent> insuredEventsTable;
    @Inject private Button printDetails;
    @Inject private InsuredEventService insuredEventService;
    @Inject
    private CollectionContainer<InsuredEvent> insuredEventsDc;
    @Inject
    private CollectionLoader<InsuredEvent> insuredEventsDl;

    @Subscribe
    private void onInit(InitEvent event) {
        insuredEventsTable.setStyleProvider((insuredEvent, property) -> {
            if (property == null) {
                switch (insuredEvent.getStatus()) {
                    case COMPLETED:
                        return "green-color";
                    case DENIED:
                        return "red-color";
                }
            }
            return null;
        });

        TablePrintFormAction action = new TablePrintFormAction("eventAct", insuredEventsTable);
        insuredEventsTable.addAction(action);
        printDetails.setAction(action);

    }


    @Subscribe("completeBtn")
    public void onCompleteBtnClick(Button.ClickEvent event) {
        if (Objects.requireNonNull(insuredEventsTable.getSingleSelected()).getStatus() == InsuredEventStatus.ACTIVE) {
            insuredEventService.setState(insuredEventsTable.getSingleSelected(),InsuredEventStatus.COMPLETED);
            insuredEventsDl.load();
        }
    }

    @Subscribe("deniedBtn")
    public void onDeniedBtnClick(Button.ClickEvent event) {
        if (Objects.requireNonNull(insuredEventsTable.getSingleSelected()).getStatus() == InsuredEventStatus.ACTIVE) {
            insuredEventService.setState(insuredEventsTable.getSingleSelected(),InsuredEventStatus.DENIED);
            insuredEventsDl.load();
        }
    }

    @Subscribe("cancelBtn")
    public void onCancelBtnClick(Button.ClickEvent event) {
        if ((Objects.requireNonNull(insuredEventsTable.getSingleSelected()).getStatus() == InsuredEventStatus.COMPLETED) ||
            (Objects.requireNonNull(insuredEventsTable.getSingleSelected()).getStatus() == InsuredEventStatus.DENIED)) {
            insuredEventService.setState(insuredEventsTable.getSingleSelected(),InsuredEventStatus.ACTIVE);
            insuredEventsDl.load();
        }
    }


}
