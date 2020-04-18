package uz.ita.assistance.web.screens.address;

import com.haulmont.cuba.gui.screen.*;
import uz.ita.assistance.entity.address.Region;

@UiController("assistance_Region.browse")
@UiDescriptor("region-browse.xml")
@LookupComponent("regionsTable")
@LoadDataBeforeShow
public class RegionBrowse extends StandardLookup<Region> {
}