package uz.ita.assistance.web.screens.detailandrepairlist;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.DetailAndRepairList;

@UiController("assistance_DetailAndRepairList.edit")
@UiDescriptor("detail-and-repair-list-edit.xml")
@EditedEntityContainer("detailAndRepairListDc")
@LoadDataBeforeShow
public class DetailAndRepairListEdit extends StandardEditor<DetailAndRepairList> {
}