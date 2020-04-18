package uz.ita.assistance.web.screens.insuredevent;

import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.CoveredByInsurance;
import uz.ita.assistance.entity.InsuredEvent;
import uz.ita.assistance.entity.InsuredEventRepair;
import uz.ita.assistance.entity.InsuredEventRepairNotCovered;
import uz.ita.assistance.web.screens.insuredeventrepair.InsuredEventRepairEdit;
import uz.ita.assistance.web.screens.insuredeventrepairnotcovered.InsuredEventRepairNotCoveredEdit;

import javax.inject.Inject;

@UiController("assistance_InsuredEvent.edit")
@UiDescriptor("insured-event-edit.xml")
@EditedEntityContainer("insuredEventDc")
public class InsuredEventEdit extends StandardEditor<InsuredEvent> {

    @Inject private ScreenBuilders screenBuilders;
    @Inject private CollectionContainer<InsuredEventRepair> insuredEventRepairsDc;
    @Inject private CollectionContainer<InsuredEventRepairNotCovered> insuredEventRepairsNotCoveredDc;
    @Inject private GroupTable<InsuredEventRepair> insuredEventRepairsTable;
    @Inject private GroupTable<InsuredEventRepairNotCovered> insuredEventRepairsNotCoveredTable;
    @Inject private TextField<Double> sum;
    @Inject private TextField<Double> vatSum;
    @Inject private TextField<Double> total;
    @Inject private TextField<Double> sumNotRecovered;
    @Inject private TextField<Double> vatSumNotRecovered;
    @Inject private TextField<Double> totalNotRecovered;

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        getScreenData().loadAll();
    }

    @Subscribe("insuredEventRepairsTable.create")
    public void onCreate(Action.ActionPerformedEvent event) {
        screenBuilders.editor(insuredEventRepairsTable)
                .newEntity()
                .withScreenClass(InsuredEventRepairEdit.class)
                .withAfterCloseListener(afterCloseEvent -> {
                    calculate();
                })
                .build()
                .show();
    }

    @Subscribe("insuredEventRepairsTable.edit")
    public void onEdit(Action.ActionPerformedEvent event) {
        screenBuilders.editor(insuredEventRepairsTable)
                .editEntity(insuredEventRepairsTable.getSingleSelected())
                .withScreenClass(InsuredEventRepairEdit.class)
                .withAfterCloseListener(afterCloseEvent -> {
                    calculate();
                })
                .build()
                .show();
    }

    @Subscribe("insuredEventRepairsNotCoveredTable.create")
    public void onCreateNotCovered(Action.ActionPerformedEvent event) {
        screenBuilders.editor(insuredEventRepairsNotCoveredTable)
                .newEntity()
                .withScreenClass(InsuredEventRepairNotCoveredEdit.class)
                .withAfterCloseListener(afterCloseEvent -> {
                    calculateNotRecovered();
                })
                .build()
                .show();
    }

    @Subscribe("insuredEventRepairsNotCoveredTable.edit")
    public void onEditNotCovered(Action.ActionPerformedEvent event) {
        screenBuilders.editor(insuredEventRepairsNotCoveredTable)
                .editEntity(insuredEventRepairsNotCoveredTable.getSingleSelected())
                .withScreenClass(InsuredEventRepairNotCoveredEdit.class)
                .withAfterCloseListener(afterCloseEvent -> {
                    calculateNotRecovered();
                })
                .build()
                .show();
    }

    private void calculate() {
        double sum1 = 0;
        double vatSum1=0;
        double total1=0;
        for (InsuredEventRepair insuredEventRepair : insuredEventRepairsDc.getItems()) {
            sum1 = sum1 + insuredEventRepair.getSum();
            vatSum1 = vatSum1 + insuredEventRepair.getVatSum();
            total1 = total1 + insuredEventRepair.getTotal();
        }
        sum.setValue(sum1);
        vatSum.setValue(vatSum1);
        total.setValue(total1);
    }

    private void calculateNotRecovered() {
        double sum1 = 0;
        double vatSum1=0;
        double total1=0;
        for (InsuredEventRepairNotCovered insuredEventRepair : insuredEventRepairsNotCoveredDc.getItems()) {
            sum1 = sum1 + insuredEventRepair.getSum();
            vatSum1 = vatSum1 + insuredEventRepair.getVatSum();
            total1 = total1 + insuredEventRepair.getTotal();
        }
        sumNotRecovered.setValue(sum1);
        vatSumNotRecovered.setValue(vatSum1);
        totalNotRecovered.setValue(total1);
    }

}