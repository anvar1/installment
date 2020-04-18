package uz.ita.assistance.web.screens.contract;

import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.gui.screen.LookupComponent;
import de.diedavids.cuba.dataimport.web.WithImportWizard;
import uz.ita.assistance.entity.Contract;
import uz.ita.assistance.entity.ExtUser;

import javax.inject.Inject;
import java.util.Date;

@UiController("assistance_Contract.browse")
@UiDescriptor("contract-browse.xml")
@LookupComponent("contractsTable")
public class ContractBrowse extends StandardLookup<Contract> implements WithImportWizard {
    @Inject protected CollectionContainer<Contract> contractsDc;
    @Inject private CollectionLoader<Contract> contractsDl;
    @Inject protected GroupTable<Contract> contractsTable;
    @Inject protected ButtonsPanel buttonsPanel;
    @Inject private UserSessionSource userSessionSource;
    @Inject
    private TextField<String> policySearchText;

    @Subscribe
    private void onInit(InitEvent event) {
        contractsTable.setStyleProvider((contract, property) -> {
            if (property == null) {
                if (contract.getInsuredEvent().size()>0) {
                        return "red-color";
                } else
                    if (contract.getDateTo().before(new Date())) {
                        return "gray-color";
                    }
            }
            return null;
        });

    }

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
//        contractsDl.setParameter("agent",
//                ((ExtUser) userSessionSource.getUserSession().getCurrentOrSubstitutedUser()).getAgent());
        policySearchText.setValue("%");
        contractsDl.setParameter("number", (policySearchText.getValue()));
        getScreenData().loadAll();
    }

    @Override
    public ListComponent getListComponent() {
        return contractsTable;
    }

    @Override
    public CollectionContainer getCollectionContainer() {
        return contractsDc;
    }

    @Override
    public ButtonsPanel getButtonsPanel() {
        return buttonsPanel;
    }

    @Subscribe("searchButton")
    private void onSearchButtonClick(Button.ClickEvent event) {
        contractsDl.setParameter("number", ("%"+policySearchText.getValue()+"%"));
        getScreenData().loadAll();
    }

    @Subscribe("policySearchText")
    private void onPolicySearchTextEnterPress(TextInputField.EnterPressEvent event) {
        contractsDl.setParameter("number", ("%"+policySearchText.getValue()+"%"));
        getScreenData().loadAll();

    }


}
