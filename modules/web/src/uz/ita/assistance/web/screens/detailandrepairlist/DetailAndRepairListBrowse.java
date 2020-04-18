package uz.ita.assistance.web.screens.detailandrepairlist;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.DetailAndRepairList;

@UiController("assistance_DetailAndRepairList.browse")
@UiDescriptor("detail-and-repair-list-browse.xml")
@LookupComponent("detailAndRepairListsTable")
@LoadDataBeforeShow
public class DetailAndRepairListBrowse extends StandardLookup<DetailAndRepairList> {
}