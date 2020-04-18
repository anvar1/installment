package uz.ita.assistance.web.screens.insuredeventrepairnotcovered;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.InsuredEventRepairNotCovered;

import javax.inject.Inject;
import java.util.Objects;

@UiController("assistance_InsuredEventRepairNotCovered.edit")
@UiDescriptor("insured-event-repair-not-covered-edit.xml")
@EditedEntityContainer("insuredEventRepairNotCoveredDc")
@LoadDataBeforeShow
public class InsuredEventRepairNotCoveredEdit extends StandardEditor<InsuredEventRepairNotCovered> {
    @Inject private TextField<Double> sum;
    @Inject private TextField<Integer> count;
    @Inject private TextField<Double> price;
    @Inject private TextField<Double> vat;
    @Inject private TextField<Double> vatSum;
    @Inject private TextField<Double> total;

    private void calculate() {
        if (count.isValid() && price.isValid()) {
            sum.setValue((double) (Math.round(price.getValue() * count.getValue() * 100) / 100));
        } else sum.setValue(0D);
        if (vat.isValid() && sum.isValid()) {
            vatSum.setValue((double) (Math.round(sum.getValue() * vat.getValue()) / 100));
        } else vatSum.setValue(0D);
        total.setValue(sum.getValue() + vatSum.getValue());
    }

    @Subscribe("price")
    private void onPriceFieldValueChange(HasValue.ValueChangeEvent<Double> event) {
        if (!Objects.equals(event.getValue(), event.getPrevValue())) calculate();
    }

    @Subscribe("count")
    private void onCountFieldValueChange(HasValue.ValueChangeEvent<Integer> event) {
        if (!Objects.equals(event.getValue(), event.getPrevValue())) calculate();
    }

    @Subscribe("vat")
    private void onVatValueChange(HasValue.ValueChangeEvent<Double> event) {
        if (!Objects.equals(event.getValue(), event.getPrevValue())) calculate();
    }

    @Subscribe("sum")
    private void onSumValueChange(HasValue.ValueChangeEvent<Double> event) {
        if (!Objects.equals(event.getValue(), event.getPrevValue())) calculate();
    }
}